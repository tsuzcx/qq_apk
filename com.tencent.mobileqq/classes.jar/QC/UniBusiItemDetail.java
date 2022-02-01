package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiItemDetail
  extends JceStruct
{
  static ExtraAppInfo cache_extraappinfo = new ExtraAppInfo();
  static UniBusiExtraInfo cache_extrainfo = new UniBusiExtraInfo();
  public int appid = 0;
  public ExtraAppInfo extraappinfo = null;
  public UniBusiExtraInfo extrainfo = null;
  public int feetype = 0;
  public String image = "";
  public String itemBgColor = "";
  public int itemid = 0;
  public String itemname = "";
  public long validlast = 0L;
  public long validts = 0L;
  
  public UniBusiItemDetail() {}
  
  public UniBusiItemDetail(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, UniBusiExtraInfo paramUniBusiExtraInfo, String paramString2, String paramString3, int paramInt3, ExtraAppInfo paramExtraAppInfo)
  {
    this.itemid = paramInt1;
    this.itemname = paramString1;
    this.feetype = paramInt2;
    this.validts = paramLong1;
    this.validlast = paramLong2;
    this.extrainfo = paramUniBusiExtraInfo;
    this.image = paramString2;
    this.itemBgColor = paramString3;
    this.appid = paramInt3;
    this.extraappinfo = paramExtraAppInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.itemid = paramJceInputStream.read(this.itemid, 0, false);
    this.itemname = paramJceInputStream.readString(1, false);
    this.feetype = paramJceInputStream.read(this.feetype, 2, false);
    this.validts = paramJceInputStream.read(this.validts, 3, false);
    this.validlast = paramJceInputStream.read(this.validlast, 4, false);
    this.extrainfo = ((UniBusiExtraInfo)paramJceInputStream.read(cache_extrainfo, 5, false));
    this.image = paramJceInputStream.readString(6, false);
    this.itemBgColor = paramJceInputStream.readString(7, false);
    this.appid = paramJceInputStream.read(this.appid, 8, false);
    this.extraappinfo = ((ExtraAppInfo)paramJceInputStream.read(cache_extraappinfo, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.itemid, 0);
    Object localObject = this.itemname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.feetype, 2);
    paramJceOutputStream.write(this.validts, 3);
    paramJceOutputStream.write(this.validlast, 4);
    localObject = this.extrainfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.image;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.itemBgColor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.appid, 8);
    localObject = this.extraappinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusiItemDetail
 * JD-Core Version:    0.7.0.1
 */