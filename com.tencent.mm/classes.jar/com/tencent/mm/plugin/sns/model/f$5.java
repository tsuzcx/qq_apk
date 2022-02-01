package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.c;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class f$5
  implements Runnable
{
  public f$5(f paramf, String paramString, f.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(95461);
    EmojiInfo localEmojiInfo = aw.eLx().FyY.aJx(this.kzy);
    if (localEmojiInfo != null)
    {
      e locale = e.fLn;
      e.a(localEmojiInfo, new i.c() {});
    }
    AppMethodBeat.o(95461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.f.5
 * JD-Core Version:    0.7.0.1
 */