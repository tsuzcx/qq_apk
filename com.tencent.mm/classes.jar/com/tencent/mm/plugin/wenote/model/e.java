package com.tencent.mm.plugin.wenote.model;

public final class e
{
  public String field_cdnKey;
  public String field_cdnUrl;
  public String field_dataId;
  public int field_dataType;
  public int field_extFlag;
  public long field_favLocalId;
  public int field_localId;
  public long field_modifyTime;
  public int field_offset;
  public String field_path;
  public int field_status;
  public int field_totalLen;
  public int field_type;
  
  public final boolean isFinished()
  {
    return (this.field_status == 3) || (this.field_status == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.e
 * JD-Core Version:    0.7.0.1
 */