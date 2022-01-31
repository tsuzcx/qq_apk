package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FileBatchCommitReq
  extends JceStruct
{
  static Map<String, FileCommitReq> cache_commit_req = new HashMap();
  public Map<String, FileCommitReq> commit_req = null;
  
  static
  {
    FileCommitReq localFileCommitReq = new FileCommitReq();
    cache_commit_req.put("", localFileCommitReq);
  }
  
  public FileBatchCommitReq() {}
  
  public FileBatchCommitReq(Map<String, FileCommitReq> paramMap)
  {
    this.commit_req = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commit_req = ((Map)paramJceInputStream.read(cache_commit_req, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.commit_req, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SLICE_UPLOAD.FileBatchCommitReq
 * JD-Core Version:    0.7.0.1
 */