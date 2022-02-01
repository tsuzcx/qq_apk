package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommentBubble
  extends JceStruct
{
  static int cache_eType;
  static BubbleSource cache_stSource = new BubbleSource();
  public int eType = 0;
  public int iFrameRate = 0;
  public int iItemId = -1;
  public BubbleSource stSource = null;
  public String strAndBgUrl = "";
  public String strFrameZip = "";
  public String strIosBgUrl = "";
  public String strTextColor = "";
  
  public CommentBubble() {}
  
  public CommentBubble(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, BubbleSource paramBubbleSource, String paramString4, int paramInt3)
  {
    this.iItemId = paramInt1;
    this.strTextColor = paramString1;
    this.strAndBgUrl = paramString2;
    this.strIosBgUrl = paramString3;
    this.eType = paramInt2;
    this.stSource = paramBubbleSource;
    this.strFrameZip = paramString4;
    this.iFrameRate = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.strTextColor = paramJceInputStream.readString(1, false);
    this.strAndBgUrl = paramJceInputStream.readString(2, false);
    this.strIosBgUrl = paramJceInputStream.readString(3, false);
    this.eType = paramJceInputStream.read(this.eType, 4, false);
    this.stSource = ((BubbleSource)paramJceInputStream.read(cache_stSource, 5, false));
    this.strFrameZip = paramJceInputStream.readString(6, false);
    this.iFrameRate = paramJceInputStream.read(this.iFrameRate, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    Object localObject = this.strTextColor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.strAndBgUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.strIosBgUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.eType, 4);
    localObject = this.stSource;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.strFrameZip;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.iFrameRate, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CommentBubble
 * JD-Core Version:    0.7.0.1
 */