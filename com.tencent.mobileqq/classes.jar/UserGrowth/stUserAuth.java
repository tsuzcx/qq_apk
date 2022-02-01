package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUserAuth
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public stSchema schema = null;
  public boolean show_confirm = true;
  
  public stUserAuth() {}
  
  public stUserAuth(boolean paramBoolean, stSchema paramstSchema)
  {
    this.show_confirm = paramBoolean;
    this.schema = paramstSchema;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.show_confirm = paramJceInputStream.read(this.show_confirm, 0, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 1, false));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stUserAuth{show_confirm=");
    localStringBuilder.append(this.show_confirm);
    localStringBuilder.append(", schema=");
    localStringBuilder.append(this.schema);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.show_confirm, 0);
    stSchema localstSchema = this.schema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stUserAuth
 * JD-Core Version:    0.7.0.1
 */