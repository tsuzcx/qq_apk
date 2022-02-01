package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMusicListReq
  extends JceStruct
{
  static SourceInfo cache_stSource = new SourceInfo();
  public int iMode = 0;
  public long iNum = 0L;
  public long iUin = 0L;
  public String sCookie = "";
  public SourceInfo stSource = null;
  
  public GetMusicListReq() {}
  
  public GetMusicListReq(long paramLong1, String paramString, long paramLong2, SourceInfo paramSourceInfo, int paramInt)
  {
    this.iUin = paramLong1;
    this.sCookie = paramString;
    this.iNum = paramLong2;
    this.stSource = paramSourceInfo;
    this.iMode = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.sCookie = paramJceInputStream.readString(1, false);
    this.iNum = paramJceInputStream.read(this.iNum, 2, false);
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 3, false));
    this.iMode = paramJceInputStream.read(this.iMode, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    Object localObject = this.sCookie;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.iNum, 2);
    localObject = this.stSource;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    paramJceOutputStream.write(this.iMode, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.GetMusicListReq
 * JD-Core Version:    0.7.0.1
 */