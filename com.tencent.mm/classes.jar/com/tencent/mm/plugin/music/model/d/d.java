package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d
{
  boolean wlA = false;
  boolean wlB = false;
  boolean wlC = false;
  boolean wlD = false;
  int wlE = 0;
  com.tencent.mm.plugin.music.c.b wlF;
  boolean wlv = false;
  boolean wlw = false;
  boolean wlx = false;
  boolean wly = false;
  boolean wlz = false;
  
  final String getMimeType()
  {
    AppMethodBeat.i(63143);
    if (this.wlF != null) {}
    for (String str1 = this.wlF.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).dsP();
        str2 = str1;
        if (locala != null) {
          str2 = locala.field_mimetype;
        }
      }
      AppMethodBeat.o(63143);
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.d
 * JD-Core Version:    0.7.0.1
 */