package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.widget.b.e.c;

final class SmileyGrid$11
  implements e.c
{
  SmileyGrid$11(SmileyGrid paramSmileyGrid, EmojiInfo paramEmojiInfo) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(62908);
    if (paramBoolean)
    {
      this.AQQ.a(EmojiInfo.a.yPE);
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.AQQ);
      paramString = new EmojiCaptureReporter();
      paramString.eyh = System.currentTimeMillis();
      paramString.lsN = System.currentTimeMillis();
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().b(new EmojiCaptureUploadManager.UploadTask(this.AQQ.field_md5, paramString));
    }
    AppMethodBeat.o(62908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid.11
 * JD-Core Version:    0.7.0.1
 */