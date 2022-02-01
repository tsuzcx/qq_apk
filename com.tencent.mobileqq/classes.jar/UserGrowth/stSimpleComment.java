package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaPerson;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSimpleComment
  extends JceStruct
{
  static stSchema cache_dingSchema = new stSchema();
  static stMetaPerson cache_poster = new stMetaPerson();
  public long dingNum = 0L;
  public stSchema dingSchema = null;
  public String feedId = "";
  public String id = "";
  public int isDing = 0;
  public stMetaPerson poster = null;
  public String posterId = "";
  public String wording = "";
  
  public stSimpleComment() {}
  
  public stSimpleComment(String paramString1, String paramString2, String paramString3, stMetaPerson paramstMetaPerson, long paramLong, int paramInt, String paramString4, stSchema paramstSchema)
  {
    this.id = paramString1;
    this.wording = paramString2;
    this.posterId = paramString3;
    this.poster = paramstMetaPerson;
    this.dingNum = paramLong;
    this.isDing = paramInt;
    this.feedId = paramString4;
    this.dingSchema = paramstSchema;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.wording = paramJceInputStream.readString(1, false);
    this.posterId = paramJceInputStream.readString(2, false);
    this.poster = ((stMetaPerson)paramJceInputStream.read(cache_poster, 3, false));
    this.dingNum = paramJceInputStream.read(this.dingNum, 4, false);
    this.isDing = paramJceInputStream.read(this.isDing, 5, false);
    this.feedId = paramJceInputStream.readString(6, false);
    this.dingSchema = ((stSchema)paramJceInputStream.read(cache_dingSchema, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.wording;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.posterId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.poster;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    paramJceOutputStream.write(this.dingNum, 4);
    paramJceOutputStream.write(this.isDing, 5);
    localObject = this.feedId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.dingSchema;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSimpleComment
 * JD-Core Version:    0.7.0.1
 */