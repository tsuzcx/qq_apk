package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public float dia = -85.0F;
  public float dib = -1000.0F;
  Map<String, Object> ikn = new HashMap();
  int nZo = 0;
  long nZp = 0L;
  String nZq = "";
  
  public d()
  {
    this.ikn.clear();
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.ikn.put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.d
 * JD-Core Version:    0.7.0.1
 */