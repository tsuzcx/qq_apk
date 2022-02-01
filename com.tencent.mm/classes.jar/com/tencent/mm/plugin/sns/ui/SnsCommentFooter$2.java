package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.t;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class SnsCommentFooter$2
  implements ad.a
{
  SnsCommentFooter$2(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(369945);
    if ((paramt instanceof EmojiInfo))
    {
      boolean bool = false;
      String str;
      if ((SnsCommentFooter.o(this.RqJ) != null) && (!Util.isNullOrNil(SnsCommentFooter.o(this.RqJ).Username)))
      {
        str = SnsCommentFooter.o(this.RqJ).Username;
        bool = true;
      }
      while (!SnsCommentFooter.q(this.RqJ))
      {
        AppMethodBeat.o(369945);
        return;
        if ((this.RqJ.getTag() != null) && ((this.RqJ.getTag() instanceof SnsInfo)))
        {
          str = ((SnsInfo)this.RqJ.getTag()).getUserName();
        }
        else
        {
          AppMethodBeat.o(369945);
          return;
        }
      }
      a.pFn.a(SnsCommentFooter.j(this.RqJ), str, ((EmojiInfo)paramt).field_md5, bool, new SnsCommentFooter.2.1(this, paramt));
    }
    AppMethodBeat.o(369945);
  }
  
  public final void onHide() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.2
 * JD-Core Version:    0.7.0.1
 */