package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUserAuth
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public stSchema schema;
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
    return "stUserAuth{show_confirm=" + this.show_confirm + ", schema=" + this.schema + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.show_confirm, 0);
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stUserAuth
 * JD-Core Version:    0.7.0.1
 */