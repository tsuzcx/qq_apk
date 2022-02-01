package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcReqBindUin
  extends JceStruct
{
  static ArrayList<BindUin> cache_vecBindUin;
  public byte cCmd = 0;
  public ArrayList<BindUin> vecBindUin = null;
  
  public SvcReqBindUin() {}
  
  public SvcReqBindUin(byte paramByte, ArrayList<BindUin> paramArrayList)
  {
    this.cCmd = paramByte;
    this.vecBindUin = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cCmd = paramJceInputStream.read(this.cCmd, 0, true);
    if (cache_vecBindUin == null)
    {
      cache_vecBindUin = new ArrayList();
      BindUin localBindUin = new BindUin();
      cache_vecBindUin.add(localBindUin);
    }
    this.vecBindUin = ((ArrayList)paramJceInputStream.read(cache_vecBindUin, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cCmd, 0);
    paramJceOutputStream.write(this.vecBindUin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.SvcReqBindUin
 * JD-Core Version:    0.7.0.1
 */