package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPersonExt
  extends JceStruct
{
  static stSchema cache_dingSchema = new stSchema();
  static stSchema cache_editSchema = new stSchema();
  static stSchema cache_fansSchema;
  static stSchema cache_followSchema = new stSchema();
  static stSchema cache_msgSchema = new stSchema();
  static stSchema cache_settingSchema;
  public stSchema dingSchema = null;
  public stSchema editSchema = null;
  public stSchema fansSchema = null;
  public stSchema followSchema = null;
  public stSchema msgSchema = null;
  public stSchema settingSchema = null;
  
  static
  {
    cache_fansSchema = new stSchema();
    cache_settingSchema = new stSchema();
  }
  
  public stPersonExt() {}
  
  public stPersonExt(stSchema paramstSchema1, stSchema paramstSchema2, stSchema paramstSchema3, stSchema paramstSchema4, stSchema paramstSchema5, stSchema paramstSchema6)
  {
    this.dingSchema = paramstSchema1;
    this.followSchema = paramstSchema2;
    this.fansSchema = paramstSchema3;
    this.settingSchema = paramstSchema4;
    this.editSchema = paramstSchema5;
    this.msgSchema = paramstSchema6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dingSchema = ((stSchema)paramJceInputStream.read(cache_dingSchema, 0, false));
    this.followSchema = ((stSchema)paramJceInputStream.read(cache_followSchema, 1, false));
    this.fansSchema = ((stSchema)paramJceInputStream.read(cache_fansSchema, 2, false));
    this.settingSchema = ((stSchema)paramJceInputStream.read(cache_settingSchema, 3, false));
    this.editSchema = ((stSchema)paramJceInputStream.read(cache_editSchema, 4, false));
    this.msgSchema = ((stSchema)paramJceInputStream.read(cache_msgSchema, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    stSchema localstSchema = this.dingSchema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 0);
    }
    localstSchema = this.followSchema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 1);
    }
    localstSchema = this.fansSchema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 2);
    }
    localstSchema = this.settingSchema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 3);
    }
    localstSchema = this.editSchema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 4);
    }
    localstSchema = this.msgSchema;
    if (localstSchema != null) {
      paramJceOutputStream.write(localstSchema, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPersonExt
 * JD-Core Version:    0.7.0.1
 */