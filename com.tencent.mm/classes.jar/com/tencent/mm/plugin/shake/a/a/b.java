package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class b
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final Column Jmb;
  public static final Column Jmc;
  private static final int Jmd = "lastshaketime".hashCode();
  private static final int Jme = "isshowed".hashCode();
  public static final SingleTable TABLE = new SingleTable("ShakeNewYearFriendInfo");
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  public boolean field_isshowed;
  public int field_lastshaketime;
  public String field_username;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ShakeNewYearFriendInfo", "");
    C_USERNAME = new Column("username", "string", "ShakeNewYearFriendInfo", "");
    Jmb = new Column("lastshaketime", "int", "ShakeNewYearFriendInfo", "");
    Jmc = new Column("isshowed", "boolean", "ShakeNewYearFriendInfo", "");
    username_HASHCODE = "username".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = arrayOfString.length;
      while (i < j)
      {
        int k = arrayOfString[i].hashCode();
        if (username_HASHCODE == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (Jmd == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (Jme == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
        i += 1;
      }
    }
  }
  
  public ContentValues convertTo()
  {
    new ContentValues();
    throw null;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "ShakeNewYearFriendInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.b
 * JD-Core Version:    0.7.0.1
 */