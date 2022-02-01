package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFriendLike
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public String nick = "";
  public stSchema schema = null;
  
  public stFriendLike() {}
  
  public stFriendLike(String paramString, stSchema paramstSchema)
  {
    this.nick = paramString;
    this.schema = paramstSchema;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nick = paramJceInputStream.readString(0, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.nick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.schema;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFriendLike
 * JD-Core Version:    0.7.0.1
 */