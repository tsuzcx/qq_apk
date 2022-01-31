package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d
{
  boolean pae = false;
  boolean paf = false;
  boolean pag = false;
  boolean pah = false;
  boolean pai = false;
  boolean paj = false;
  boolean pak = false;
  boolean pal = false;
  boolean pam = false;
  int pan = 0;
  com.tencent.mm.plugin.music.c.b pao;
  
  final String getMimeType()
  {
    AppMethodBeat.i(105010);
    if (this.pao != null) {}
    for (String str1 = this.pao.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.f.c.b.am(e.class)).bVw();
        str2 = str1;
        if (locala != null) {
          str2 = locala.field_mimetype;
        }
      }
      AppMethodBeat.o(105010);
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.d
 * JD-Core Version:    0.7.0.1
 */