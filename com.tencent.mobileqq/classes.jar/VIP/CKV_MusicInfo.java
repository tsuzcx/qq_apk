package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class CKV_MusicInfo
  extends JceStruct
{
  static ArrayList<CKV_SingerInfo> cache_vSingerList = new ArrayList();
  public int iAccess = 0;
  public long iAddTime = 0L;
  public long iDuration = 0L;
  public long iModifyTime = 0L;
  public long iState = 0L;
  public String sAlbumName = "";
  public String sPic = "";
  public String sSongId = "";
  public String sSongName = "";
  public String sSongUrl = "";
  public ArrayList<CKV_SingerInfo> vSingerList = null;
  
  static
  {
    CKV_SingerInfo localCKV_SingerInfo = new CKV_SingerInfo();
    cache_vSingerList.add(localCKV_SingerInfo);
  }
  
  public CKV_MusicInfo() {}
  
  public CKV_MusicInfo(String paramString1, String paramString2, String paramString3, ArrayList<CKV_SingerInfo> paramArrayList, String paramString4, String paramString5, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4)
  {
    this.sSongId = paramString1;
    this.sSongName = paramString2;
    this.sAlbumName = paramString3;
    this.vSingerList = paramArrayList;
    this.sPic = paramString4;
    this.sSongUrl = paramString5;
    this.iState = paramLong1;
    this.iAddTime = paramLong2;
    this.iModifyTime = paramLong3;
    this.iAccess = paramInt;
    this.iDuration = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sSongId = paramJceInputStream.readString(0, false);
    this.sSongName = paramJceInputStream.readString(1, false);
    this.sAlbumName = paramJceInputStream.readString(2, false);
    this.vSingerList = ((ArrayList)paramJceInputStream.read(cache_vSingerList, 3, false));
    this.sPic = paramJceInputStream.readString(4, false);
    this.sSongUrl = paramJceInputStream.readString(5, false);
    this.iState = paramJceInputStream.read(this.iState, 6, false);
    this.iAddTime = paramJceInputStream.read(this.iAddTime, 7, false);
    this.iModifyTime = paramJceInputStream.read(this.iModifyTime, 8, false);
    this.iAccess = paramJceInputStream.read(this.iAccess, 9, false);
    this.iDuration = paramJceInputStream.read(this.iDuration, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.sSongId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.sSongName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.sAlbumName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.vSingerList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.sPic;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.sSongUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.iState, 6);
    paramJceOutputStream.write(this.iAddTime, 7);
    paramJceOutputStream.write(this.iModifyTime, 8);
    paramJceOutputStream.write(this.iAccess, 9);
    paramJceOutputStream.write(this.iDuration, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.CKV_MusicInfo
 * JD-Core Version:    0.7.0.1
 */