package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class c
{
  boolean mAa = false;
  boolean mAb = false;
  boolean mAc = false;
  boolean mAd = false;
  boolean mAe = false;
  boolean mAf = false;
  boolean mAg = false;
  int mAh = 0;
  com.tencent.mm.plugin.music.c.b mAi;
  boolean mzY = false;
  boolean mzZ = false;
  
  final String getMimeType()
  {
    if (this.mAi != null) {}
    for (String str1 = this.mAi.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.f.c.b.Q(e.class)).bna();
        str2 = str1;
        if (locala != null) {
          str2 = locala.field_mimetype;
        }
      }
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.c
 * JD-Core Version:    0.7.0.1
 */