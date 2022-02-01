package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMsgRedDotCount
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public int count = 0;
  public stSchema schema = null;
  public int subjectID = 0;
  
  public stMsgRedDotCount() {}
  
  public stMsgRedDotCount(int paramInt1, int paramInt2, stSchema paramstSchema)
  {
    this.subjectID = paramInt1;
    this.count = paramInt2;
    this.schema = paramstSchema;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subjectID = paramJceInputStream.read(this.subjectID, 0, false);
    this.count = paramJceInputStream.read(this.count, 1, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subjectID, 0);
    paramJceOutputStream.write(this.count, 1);
    stSchema localstSchema = this.schema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stMsgRedDotCount
 * JD-Core Version:    0.7.0.1
 */