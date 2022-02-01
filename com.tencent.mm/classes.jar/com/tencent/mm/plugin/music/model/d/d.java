package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d
{
  boolean tXo = false;
  boolean tXp = false;
  boolean tXq = false;
  boolean tXr = false;
  boolean tXs = false;
  boolean tXt = false;
  boolean tXu = false;
  boolean tXv = false;
  boolean tXw = false;
  int tXx = 0;
  com.tencent.mm.plugin.music.c.b tXy;
  
  final String getMimeType()
  {
    AppMethodBeat.i(63143);
    if (this.tXy != null) {}
    for (String str1 = this.tXy.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.f.c.b.aP(e.class)).cUX();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.d
 * JD-Core Version:    0.7.0.1
 */