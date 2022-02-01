package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqBatchProcess
  extends JceStruct
{
  static ArrayList<BatchRequest> cache_batch_request_list;
  public ArrayList<BatchRequest> batch_request_list = null;
  
  public ReqBatchProcess() {}
  
  public ReqBatchProcess(ArrayList<BatchRequest> paramArrayList)
  {
    this.batch_request_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_batch_request_list == null)
    {
      cache_batch_request_list = new ArrayList();
      BatchRequest localBatchRequest = new BatchRequest();
      cache_batch_request_list.add(localBatchRequest);
    }
    this.batch_request_list = ((ArrayList)paramJceInputStream.read(cache_batch_request_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.batch_request_list;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.ReqBatchProcess
 * JD-Core Version:    0.7.0.1
 */