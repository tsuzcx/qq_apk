package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMusicListRsp
  extends JceStruct
{
  static CommRsp cache_errInfo = new CommRsp();
  static MusicListInfo cache_stMusicList = new MusicListInfo();
  public CommRsp errInfo = null;
  public long iTotal = 0L;
  public boolean isEnd = true;
  public String sCookie = "";
  public MusicListInfo stMusicList = null;
  
  public GetMusicListRsp() {}
  
  public GetMusicListRsp(CommRsp paramCommRsp, MusicListInfo paramMusicListInfo, String paramString, boolean paramBoolean, long paramLong)
  {
    this.errInfo = paramCommRsp;
    this.stMusicList = paramMusicListInfo;
    this.sCookie = paramString;
    this.isEnd = paramBoolean;
    this.iTotal = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.errInfo = ((CommRsp)paramJceInputStream.read(cache_errInfo, 0, false));
    this.stMusicList = ((MusicListInfo)paramJceInputStream.read(cache_stMusicList, 1, false));
    this.sCookie = paramJceInputStream.readString(2, false);
    this.isEnd = paramJceInputStream.read(this.isEnd, 3, false);
    this.iTotal = paramJceInputStream.read(this.iTotal, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.errInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stMusicList;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.sCookie;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.isEnd, 3);
    paramJceOutputStream.write(this.iTotal, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.GetMusicListRsp
 * JD-Core Version:    0.7.0.1
 */