package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespBatchProcess
  extends JceStruct
{
  static ArrayList<BatchResponse> cache_batch_response_list;
  public ArrayList<BatchResponse> batch_response_list = null;
  
  public RespBatchProcess() {}
  
  public RespBatchProcess(ArrayList<BatchResponse> paramArrayList)
  {
    this.batch_response_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_batch_response_list == null)
    {
      cache_batch_response_list = new ArrayList();
      BatchResponse localBatchResponse = new BatchResponse();
      cache_batch_response_list.add(localBatchResponse);
    }
    this.batch_response_list = ((ArrayList)paramJceInputStream.read(cache_batch_response_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.batch_response_list != null) {
      paramJceOutputStream.write(this.batch_response_list, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.RespBatchProcess
 * JD-Core Version:    0.7.0.1
 */