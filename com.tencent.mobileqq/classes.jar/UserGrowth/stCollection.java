package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCollection
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public String cid = "";
  public int click_action = 0;
  public String cover = "";
  public String desc = "";
  public int feed_count = 0;
  public String name = "";
  public stSchema schema = null;
  public String subTitle = "";
  
  public stCollection() {}
  
  public stCollection(String paramString1, String paramString2, String paramString3, int paramInt1, stSchema paramstSchema, int paramInt2, String paramString4, String paramString5)
  {
    this.cid = paramString1;
    this.name = paramString2;
    this.desc = paramString3;
    this.click_action = paramInt1;
    this.schema = paramstSchema;
    this.feed_count = paramInt2;
    this.cover = paramString4;
    this.subTitle = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cid = paramJceInputStream.readString(0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.click_action = paramJceInputStream.read(this.click_action, 3, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 4, false));
    this.feed_count = paramJceInputStream.read(this.feed_count, 5, false);
    this.cover = paramJceInputStream.readString(6, false);
    this.subTitle = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cid != null) {
      paramJceOutputStream.write(this.cid, 0);
    }
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 1);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
    paramJceOutputStream.write(this.click_action, 3);
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 4);
    }
    paramJceOutputStream.write(this.feed_count, 5);
    if (this.cover != null) {
      paramJceOutputStream.write(this.cover, 6);
    }
    if (this.subTitle != null) {
      paramJceOutputStream.write(this.subTitle, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stCollection
 * JD-Core Version:    0.7.0.1
 */