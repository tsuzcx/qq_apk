package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d
{
  boolean FSA = false;
  boolean FSB = false;
  int FSC = 0;
  com.tencent.mm.plugin.music.c.b FSD;
  boolean FSt = false;
  boolean FSu = false;
  boolean FSv = false;
  boolean FSw = false;
  boolean FSx = false;
  boolean FSy = false;
  boolean FSz = false;
  
  final String getMimeType()
  {
    AppMethodBeat.i(63143);
    if (this.FSD != null) {}
    for (String str1 = this.FSD.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.f.c.b.bm(e.class)).fei();
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