package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCollection
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public String barText = "";
  public String cid = "";
  public int click_action = 0;
  public int collectionType = 0;
  public String cover = "";
  public String desc = "";
  public int feed_count = 0;
  public String name = "";
  public stSchema schema = null;
  public String subTitle = "";
  
  public stCollection() {}
  
  public stCollection(String paramString1, String paramString2, String paramString3, int paramInt1, stSchema paramstSchema, int paramInt2, String paramString4, String paramString5, String paramString6, int paramInt3)
  {
    this.cid = paramString1;
    this.name = paramString2;
    this.desc = paramString3;
    this.click_action = paramInt1;
    this.schema = paramstSchema;
    this.feed_count = paramInt2;
    this.cover = paramString4;
    this.subTitle = paramString5;
    this.barText = paramString6;
    this.collectionType = paramInt3;
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
    this.barText = paramJceInputStream.readString(8, false);
    this.collectionType = paramJceInputStream.read(this.collectionType, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.cid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.click_action, 3);
    localObject = this.schema;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    paramJceOutputStream.write(this.feed_count, 5);
    localObject = this.cover;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.subTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.barText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.collectionType, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stCollection
 * JD-Core Version:    0.7.0.1
 */