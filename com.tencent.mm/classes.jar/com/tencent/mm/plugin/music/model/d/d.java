package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d
{
  boolean vga = false;
  boolean vgb = false;
  boolean vgc = false;
  boolean vgd = false;
  boolean vge = false;
  boolean vgf = false;
  boolean vgg = false;
  boolean vgh = false;
  boolean vgi = false;
  int vgj = 0;
  com.tencent.mm.plugin.music.c.b vgk;
  
  final String getMimeType()
  {
    AppMethodBeat.i(63143);
    if (this.vgk != null) {}
    for (String str1 = this.vgk.mimeType;; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        a locala = ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).diD();
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