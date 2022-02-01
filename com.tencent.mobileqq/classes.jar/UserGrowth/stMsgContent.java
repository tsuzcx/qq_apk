package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMsgContent
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public String btnWording = "";
  public String content = "";
  public String icon = "";
  public String picURL = "";
  public stSchema schema = null;
  public int templateID = 0;
  public String title = "";
  
  public stMsgContent() {}
  
  public stMsgContent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, stSchema paramstSchema, String paramString5)
  {
    this.templateID = paramInt;
    this.title = paramString1;
    this.icon = paramString2;
    this.content = paramString3;
    this.picURL = paramString4;
    this.schema = paramstSchema;
    this.btnWording = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.templateID = paramJceInputStream.read(this.templateID, 0, false);
    this.title = paramJceInputStream.readString(1, false);
    this.icon = paramJceInputStream.readString(2, false);
    this.content = paramJceInputStream.readString(3, false);
    this.picURL = paramJceInputStream.readString(4, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 5, false));
    this.btnWording = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.templateID, 0);
    Object localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.picURL;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.schema;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.btnWording;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stMsgContent
 * JD-Core Version:    0.7.0.1
 */