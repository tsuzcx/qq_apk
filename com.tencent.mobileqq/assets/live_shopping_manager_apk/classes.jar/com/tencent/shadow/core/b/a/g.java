package com.tencent.shadow.core.b.a;

import android.content.ContentValues;
import java.util.Arrays;
import org.json.JSONArray;

public class g
{
  public String a;
  public long b;
  public String c;
  public String d;
  public String[] e;
  public String[] f;
  public String g;
  public int h;
  public String i;
  public String j;
  
  public g() {}
  
  public g(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.g = paramString3;
    this.h = paramInt;
  }
  
  public g(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString1, String paramString4, int paramInt, String[] paramArrayOfString2)
  {
    this(paramString1, paramString3, paramString4, paramInt);
    this.d = paramString2;
    this.e = paramArrayOfString1;
    this.f = paramArrayOfString2;
  }
  
  public ContentValues a()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hash", this.a);
    localContentValues.put("installedTime", Long.valueOf(this.b));
    if (this.d != null) {
      localContentValues.put("businessName", this.d);
    }
    if (this.c != null) {
      localContentValues.put("partKey", this.c);
    }
    if (this.e != null) {
      localContentValues.put("dependsOn", new JSONArray(Arrays.asList(this.e)).toString());
    }
    if (this.f != null) {
      localContentValues.put("hostWhiteList", new JSONArray(Arrays.asList(this.f)).toString());
    }
    localContentValues.put("type", Integer.valueOf(this.h));
    localContentValues.put("uuid", this.i);
    localContentValues.put("version", this.j);
    localContentValues.put("filePath", this.g);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.g
 * JD-Core Version:    0.7.0.1
 */