package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SyncRes
  extends JceStruct
{
  static SyncReqCookie cache_cookie;
  static ArrayList<InfoItem> cache_vecResPkg;
  public SyncReqCookie cookie;
  public byte result;
  public ArrayList<InfoItem> vecResPkg;
  
  public SyncRes() {}
  
  public SyncRes(byte paramByte, ArrayList<InfoItem> paramArrayList, SyncReqCookie paramSyncReqCookie)
  {
    this.result = paramByte;
    this.vecResPkg = paramArrayList;
    this.cookie = paramSyncReqCookie;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    if (cache_vecResPkg == null)
    {
      cache_vecResPkg = new ArrayList();
      InfoItem localInfoItem = new InfoItem();
      cache_vecResPkg.add(localInfoItem);
    }
    this.vecResPkg = ((ArrayList)paramJceInputStream.read(cache_vecResPkg, 1, true));
    if (cache_cookie == null) {
      cache_cookie = new SyncReqCookie();
    }
    this.cookie = ((SyncReqCookie)paramJceInputStream.read(cache_cookie, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.vecResPkg, 1);
    if (this.cookie != null) {
      paramJceOutputStream.write(this.cookie, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.SyncRes
 * JD-Core Version:    0.7.0.1
 */