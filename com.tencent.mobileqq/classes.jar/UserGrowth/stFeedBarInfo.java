package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFeedBarInfo
  extends JceStruct
{
  static stSchema cache_jump = new stSchema();
  public String beginColor = "";
  public int changeTime = 0;
  public String endColor = "";
  public stSchema jump = null;
  public int progressPercentage = 0;
  public int switchOpen = 0;
  public String text = "";
  
  public stFeedBarInfo() {}
  
  public stFeedBarInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, stSchema paramstSchema, int paramInt3)
  {
    this.beginColor = paramString1;
    this.endColor = paramString2;
    this.changeTime = paramInt1;
    this.progressPercentage = paramInt2;
    this.text = paramString3;
    this.jump = paramstSchema;
    this.switchOpen = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.beginColor = paramJceInputStream.readString(0, false);
    this.endColor = paramJceInputStream.readString(1, false);
    this.changeTime = paramJceInputStream.read(this.changeTime, 2, false);
    this.progressPercentage = paramJceInputStream.read(this.progressPercentage, 3, false);
    this.text = paramJceInputStream.readString(4, false);
    this.jump = ((stSchema)paramJceInputStream.read(cache_jump, 5, false));
    this.switchOpen = paramJceInputStream.read(this.switchOpen, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.beginColor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.endColor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.changeTime, 2);
    paramJceOutputStream.write(this.progressPercentage, 3);
    localObject = this.text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.jump;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.switchOpen, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFeedBarInfo
 * JD-Core Version:    0.7.0.1
 */