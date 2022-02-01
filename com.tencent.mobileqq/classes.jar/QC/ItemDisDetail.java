package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ItemDisDetail
  extends JceStruct
{
  static AuthResultInfo cache_authResult = new AuthResultInfo();
  static ExtraAppInfo cache_extraappinfo;
  static ExtraImageInfo cache_extraimage;
  static UniBusiExtraInfo cache_extrainfo = new UniBusiExtraInfo();
  public int appId = 0;
  public AuthResultInfo authResult = null;
  public ExtraAppInfo extraappinfo = null;
  public ExtraImageInfo extraimage = null;
  public UniBusiExtraInfo extrainfo = null;
  public int feeType = 0;
  public String image = "";
  public int isSetup = 0;
  public String itemBgColor = "";
  public int itemId = 0;
  public String name = "";
  public long validlast = 0L;
  
  static
  {
    cache_extraimage = new ExtraImageInfo();
    cache_extraappinfo = new ExtraAppInfo();
  }
  
  public ItemDisDetail() {}
  
  public ItemDisDetail(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, UniBusiExtraInfo paramUniBusiExtraInfo, long paramLong, int paramInt4, ExtraImageInfo paramExtraImageInfo, ExtraAppInfo paramExtraAppInfo, AuthResultInfo paramAuthResultInfo)
  {
    this.appId = paramInt1;
    this.itemId = paramInt2;
    this.name = paramString1;
    this.feeType = paramInt3;
    this.image = paramString2;
    this.itemBgColor = paramString3;
    this.extrainfo = paramUniBusiExtraInfo;
    this.validlast = paramLong;
    this.isSetup = paramInt4;
    this.extraimage = paramExtraImageInfo;
    this.extraappinfo = paramExtraAppInfo;
    this.authResult = paramAuthResultInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appId = paramJceInputStream.read(this.appId, 0, false);
    this.itemId = paramJceInputStream.read(this.itemId, 1, false);
    this.name = paramJceInputStream.readString(2, false);
    this.feeType = paramJceInputStream.read(this.feeType, 3, false);
    this.image = paramJceInputStream.readString(4, false);
    this.itemBgColor = paramJceInputStream.readString(5, false);
    this.extrainfo = ((UniBusiExtraInfo)paramJceInputStream.read(cache_extrainfo, 6, false));
    this.validlast = paramJceInputStream.read(this.validlast, 7, false);
    this.isSetup = paramJceInputStream.read(this.isSetup, 8, false);
    this.extraimage = ((ExtraImageInfo)paramJceInputStream.read(cache_extraimage, 9, false));
    this.extraappinfo = ((ExtraAppInfo)paramJceInputStream.read(cache_extraappinfo, 10, false));
    this.authResult = ((AuthResultInfo)paramJceInputStream.read(cache_authResult, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appId, 0);
    paramJceOutputStream.write(this.itemId, 1);
    Object localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.feeType, 3);
    localObject = this.image;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.itemBgColor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.extrainfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    paramJceOutputStream.write(this.validlast, 7);
    paramJceOutputStream.write(this.isSetup, 8);
    localObject = this.extraimage;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.extraappinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 10);
    }
    localObject = this.authResult;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.ItemDisDetail
 * JD-Core Version:    0.7.0.1
 */