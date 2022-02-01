package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.logic.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d
{
  boolean LNp = false;
  boolean LNq = false;
  boolean LNr = false;
  boolean LNs = false;
  boolean LNt = false;
  boolean LNu = false;
  boolean LNv = false;
  boolean LNw = false;
  boolean LNx = false;
  int LNy = 0;
  com.tencent.mm.plugin.music.c.b LNz;
  
  final String getMimeType()
  {
    AppMethodBeat.i(63143);
    if (this.LNz != null) {}
    for (String str1 = this.LNz.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.e.c.b.bU(e.class)).gnl();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.d
 * JD-Core Version:    0.7.0.1
 */