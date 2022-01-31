package com.tencent.mm.plugin.sns.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsCommentCollapseLayout$2
  implements Runnable
{
  SnsCommentCollapseLayout$2(SnsCommentCollapseLayout paramSnsCommentCollapseLayout, CharSequence paramCharSequence, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(40480);
    ab.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", new Object[] { this.sne, Integer.valueOf(this.snf) });
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = this.snd;
    if (this.sne == null) {}
    for (Object localObject = "";; localObject = this.sne)
    {
      SnsCommentCollapseLayout.a(localSnsCommentCollapseLayout, (CharSequence)localObject);
      if (!d.fS(this.snf, 16)) {
        break;
      }
      SnsCommentCollapseLayout.b(this.snd);
      AppMethodBeat.o(40480);
      return;
    }
    SnsCommentCollapseLayout.c(this.snd);
    AppMethodBeat.o(40480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout.2
 * JD-Core Version:    0.7.0.1
 */