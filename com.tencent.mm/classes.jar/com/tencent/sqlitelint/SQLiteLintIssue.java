package com.tencent.sqlitelint;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SQLiteLintIssue
  implements Parcelable
{
  public static final Parcelable.Creator<SQLiteLintIssue> CREATOR;
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
  
  static
  {
    AppMethodBeat.i(52862);
    CREATOR = new Parcelable.Creator()
    {
      public final SQLiteLintIssue createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(52854);
        paramAnonymousParcel = new SQLiteLintIssue(paramAnonymousParcel);
        AppMethodBeat.o(52854);
        return paramAnonymousParcel;
      }
      
      public final SQLiteLintIssue[] newArray(int paramAnonymousInt)
      {
        return new SQLiteLintIssue[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(52862);
  }
  
  public SQLiteLintIssue() {}
  
  protected SQLiteLintIssue(Parcel paramParcel)
  {
    AppMethodBeat.i(52860);
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
      AppMethodBeat.o(52860);
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
    AppMethodBeat.i(52857);
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(R.string.diagnosis_level_suggestion);
    }
    for (;;)
    {
      AppMethodBeat.o(52857);
      return paramContext;
      paramContext = paramContext.getString(R.string.diagnosis_level_tips);
      continue;
      paramContext = paramContext.getString(R.string.diagnosis_level_suggestion);
      continue;
      paramContext = paramContext.getString(R.string.diagnosis_level_warning);
      continue;
      paramContext = paramContext.getString(R.string.diagnosis_level_error);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(52858);
    if (!(paramObject instanceof SQLiteLintIssue))
    {
      AppMethodBeat.o(52858);
      return false;
    }
    boolean bool = ((SQLiteLintIssue)paramObject).id.equals(this.id);
    AppMethodBeat.o(52858);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(52859);
    int i = this.id.hashCode();
    AppMethodBeat.o(52859);
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(52861);
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
      AppMethodBeat.o(52861);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLintIssue
 * JD-Core Version:    0.7.0.1
 */