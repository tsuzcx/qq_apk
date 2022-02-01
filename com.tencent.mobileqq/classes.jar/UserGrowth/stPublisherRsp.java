package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPublisherRsp
  extends JceStruct
{
  static stPublisherGuide cache_guide = new stPublisherGuide();
  public boolean enable = false;
  public stPublisherGuide guide = null;
  public String h5Url = "";
  public String miniAppSchema = "";
  public boolean newUser = false;
  public String newsUserText = "";
  public int noInstallAction = 0;
  public String weishiSchema = "";
  
  public stPublisherRsp() {}
  
  public stPublisherRsp(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt, stPublisherGuide paramstPublisherGuide, String paramString3, String paramString4)
  {
    this.enable = paramBoolean1;
    this.newUser = paramBoolean2;
    this.newsUserText = paramString1;
    this.weishiSchema = paramString2;
    this.noInstallAction = paramInt;
    this.guide = paramstPublisherGuide;
    this.miniAppSchema = paramString3;
    this.h5Url = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.enable = paramJceInputStream.read(this.enable, 0, false);
    this.newUser = paramJceInputStream.read(this.newUser, 1, false);
    this.newsUserText = paramJceInputStream.readString(2, false);
    this.weishiSchema = paramJceInputStream.readString(3, false);
    this.noInstallAction = paramJceInputStream.read(this.noInstallAction, 4, false);
    this.guide = ((stPublisherGuide)paramJceInputStream.read(cache_guide, 5, false));
    this.miniAppSchema = paramJceInputStream.readString(6, false);
    this.h5Url = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.enable, 0);
    paramJceOutputStream.write(this.newUser, 1);
    Object localObject = this.newsUserText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.weishiSchema;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.noInstallAction, 4);
    localObject = this.guide;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.miniAppSchema;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.h5Url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPublisherRsp
 * JD-Core Version:    0.7.0.1
 */