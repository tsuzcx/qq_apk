package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCallWeishiButton
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public boolean isShow = true;
  public stSchema schema = null;
  
  public stCallWeishiButton() {}
  
  public stCallWeishiButton(boolean paramBoolean, stSchema paramstSchema)
  {
    this.isShow = paramBoolean;
    this.schema = paramstSchema;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isShow = paramJceInputStream.read(this.isShow, 0, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isShow, 0);
    stSchema localstSchema = this.schema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stCallWeishiButton
 * JD-Core Version:    0.7.0.1
 */