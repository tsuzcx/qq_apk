package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FileBatchCommitRsp
  extends JceStruct
{
  static Map<String, FileCommitRsp> cache_commit_rsp = new HashMap();
  public Map<String, FileCommitRsp> commit_rsp = null;
  
  static
  {
    FileCommitRsp localFileCommitRsp = new FileCommitRsp();
    cache_commit_rsp.put("", localFileCommitRsp);
  }
  
  public FileBatchCommitRsp() {}
  
  public FileBatchCommitRsp(Map<String, FileCommitRsp> paramMap)
  {
    this.commit_rsp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commit_rsp = ((Map)paramJceInputStream.read(cache_commit_rsp, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.commit_rsp, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.FileBatchCommitRsp
 * JD-Core Version:    0.7.0.1
 */