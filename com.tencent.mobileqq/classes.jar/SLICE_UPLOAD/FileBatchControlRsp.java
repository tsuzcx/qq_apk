package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FileBatchControlRsp
  extends JceStruct
{
  static Map<String, FileControlRsp> cache_control_rsp = new HashMap();
  public Map<String, FileControlRsp> control_rsp = null;
  
  static
  {
    FileControlRsp localFileControlRsp = new FileControlRsp();
    cache_control_rsp.put("", localFileControlRsp);
  }
  
  public FileBatchControlRsp() {}
  
  public FileBatchControlRsp(Map<String, FileControlRsp> paramMap)
  {
    this.control_rsp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.control_rsp = ((Map)paramJceInputStream.read(cache_control_rsp, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.control_rsp, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.FileBatchControlRsp
 * JD-Core Version:    0.7.0.1
 */