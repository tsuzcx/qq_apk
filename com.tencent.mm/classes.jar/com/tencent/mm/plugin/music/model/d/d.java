package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d
{
  boolean Alm = false;
  boolean Aln = false;
  boolean Alo = false;
  boolean Alp = false;
  boolean Alq = false;
  boolean Alr = false;
  boolean Als = false;
  boolean Alt = false;
  boolean Alu = false;
  int Alv = 0;
  com.tencent.mm.plugin.music.c.b Alw;
  
  final String getMimeType()
  {
    AppMethodBeat.i(63143);
    if (this.Alw != null) {}
    for (String str1 = this.Alw.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.f.c.b.aS(e.class)).etY();
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