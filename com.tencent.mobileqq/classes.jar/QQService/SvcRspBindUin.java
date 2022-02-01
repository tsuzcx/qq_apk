package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRspBindUin
  extends JceStruct
{
  static ArrayList<BindUinResult> cache_vecResult;
  public ArrayList<BindUinResult> vecResult = null;
  
  public SvcRspBindUin() {}
  
  public SvcRspBindUin(ArrayList<BindUinResult> paramArrayList)
  {
    this.vecResult = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResult == null)
    {
      cache_vecResult = new ArrayList();
      BindUinResult localBindUinResult = new BindUinResult();
      cache_vecResult.add(localBindUinResult);
    }
    this.vecResult = ((ArrayList)paramJceInputStream.read(cache_vecResult, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResult, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.SvcRspBindUin
 * JD-Core Version:    0.7.0.1
 */