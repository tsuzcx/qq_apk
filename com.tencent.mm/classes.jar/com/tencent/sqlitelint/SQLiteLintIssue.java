package com.tencent.sqlitelint;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SQLiteLintIssue
  implements Parcelable
{
  public static final Parcelable.Creator<SQLiteLintIssue> CREATOR = new Parcelable.Creator() {};
  public static final int ERROR = 4;
  public static final int PASS = 0;
  public static final int SUGGESTION = 2;
  public static final int TIPS = 1;
  public static final int WARNING = 3;
  public String advice;
  public long createTime;
  public String dbPath;
  public String desc;
  public String detail;
  public String extInfo;
  public String id;
  public boolean isInMainThread;
  public boolean isNew;
  public int level;
  public String sql;
  public long sqlTimeCost;
  public String table;
  public int type;
  
  public SQLiteLintIssue() {}
  
  protected SQLiteLintIssue(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.dbPath = paramParcel.readString();
    this.level = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.sql = paramParcel.readString();
    this.table = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.detail = paramParcel.readString();
    this.advice = paramParcel.readString();
    this.createTime = paramParcel.readLong();
    this.extInfo = paramParcel.readString();
    this.sqlTimeCost = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isInMainThread = bool;
      return;
      bool = false;
    }
  }
  
  public SQLiteLintIssue(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong1, String paramString8, long paramLong2, boolean paramBoolean)
  {
    this.id = paramString1;
    this.dbPath = paramString2;
    this.level = paramInt1;
    this.type = paramInt2;
    this.sql = paramString3;
    this.table = paramString4;
    this.desc = paramString5;
    this.detail = paramString6;
    this.advice = paramString7;
    this.createTime = paramLong1;
    this.extInfo = paramString8;
    this.sqlTimeCost = paramLong2;
    this.isInMainThread = paramBoolean;
  }
  
  public static String getLevelText(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getString(d.d.diagnosis_level_suggestion);
    case 1: 
      return paramContext.getString(d.d.diagnosis_level_tips);
    case 2: 
      return paramContext.getString(d.d.diagnosis_level_suggestion);
    case 3: 
      return paramContext.getString(d.d.diagnosis_level_warning);
    }
    return paramContext.getString(d.d.diagnosis_level_error);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SQLiteLintIssue)) {
      return false;
    }
    return ((SQLiteLintIssue)paramObject).id.equals(((SQLiteLintIssue)paramObject).id);
  }
  
  public int hashCode()
  {
    return this.id.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.dbPath);
    paramParcel.writeInt(this.level);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.sql);
    paramParcel.writeString(this.table);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.detail);
    paramParcel.writeString(this.advice);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeLong(this.sqlTimeCost);
    if (this.isInMainThread) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLintIssue
 * JD-Core Version:    0.7.0.1
 */