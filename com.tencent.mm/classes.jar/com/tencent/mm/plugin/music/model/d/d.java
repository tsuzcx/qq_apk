package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d
{
  boolean wBe = false;
  boolean wBf = false;
  boolean wBg = false;
  boolean wBh = false;
  boolean wBi = false;
  boolean wBj = false;
  boolean wBk = false;
  boolean wBl = false;
  boolean wBm = false;
  int wBn = 0;
  com.tencent.mm.plugin.music.c.b wBo;
  
  final String getMimeType()
  {
    AppMethodBeat.i(63143);
    if (this.wBo != null) {}
    for (String str1 = this.wBo.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).dwe();
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