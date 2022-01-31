package com.tencent.mm.storage.emotion;

import com.tencent.mm.h.c.ea;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class q
  extends ea
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.ujN.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "key";
    locala.columns[1] = "cnValue";
    locala.ujN.put("cnValue", "TEXT");
    localStringBuilder.append(" cnValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "qqValue";
    locala.ujN.put("qqValue", "TEXT");
    localStringBuilder.append(" qqValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "twValue";
    locala.ujN.put("twValue", "TEXT");
    localStringBuilder.append(" twValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "enValue";
    locala.ujN.put("enValue", "TEXT");
    localStringBuilder.append(" enValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "thValue";
    locala.ujN.put("thValue", "TEXT");
    localStringBuilder.append(" thValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "fileName";
    locala.ujN.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "eggIndex";
    locala.ujN.put("eggIndex", "INTEGER default '-1' ");
    localStringBuilder.append(" eggIndex INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "position";
    locala.ujN.put("position", "INTEGER default '-1' ");
    localStringBuilder.append(" position INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "flag";
    locala.ujN.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public q() {}
  
  public q(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.field_key = paramString1;
    this.field_cnValue = paramString3;
    this.field_qqValue = paramString2;
    this.field_enValue = paramString5;
    this.field_thValue = paramString6;
    this.field_twValue = paramString4;
    this.field_position = paramInt;
  }
  
  protected final c.a rM()
  {
    return null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key:").append(this.field_key).append("/n");
    localStringBuilder.append("cn:").append(this.field_cnValue).append("/n");
    localStringBuilder.append("qq:").append(this.field_qqValue).append("/n");
    localStringBuilder.append("en:").append(this.field_enValue).append("/n");
    localStringBuilder.append("th:").append(this.field_thValue).append("/n");
    localStringBuilder.append("tw:").append(this.field_twValue).append("/n");
    localStringBuilder.append("position:").append(this.field_position).append("/n");
    localStringBuilder.append("file Name:").append(this.field_fileName).append("/n");
    localStringBuilder.append("egg index:").append(this.field_eggIndex).append("/n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.q
 * JD-Core Version:    0.7.0.1
 */