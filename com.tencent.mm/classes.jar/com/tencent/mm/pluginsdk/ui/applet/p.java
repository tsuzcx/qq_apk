package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.vfs.u;

public final class p
  implements j
{
  public final void N(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(284724);
    EmojiInfo localEmojiInfo2 = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.bxK(paramString2);
    String str = EmojiLogic.T(b.bcb(), "", paramString2);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      if (!ImgUtil.isGif(str)) {
        break label138;
      }
    }
    label138:
    for (int i = EmojiInfo.YCF;; i = EmojiInfo.YCE)
    {
      localEmojiInfo1 = new EmojiInfo();
      localEmojiInfo1.field_md5 = paramString2;
      localEmojiInfo1.field_catalog = EmojiInfo.YCx;
      localEmojiInfo1.field_type = i;
      localEmojiInfo1.field_size = ((int)u.bBQ(str));
      localEmojiInfo1.field_temp = 1;
      localEmojiInfo1.field_designerID = paramString3;
      localEmojiInfo1.field_thumbUrl = paramString4;
      com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.K(localEmojiInfo1);
      com.tencent.mm.plugin.emoji.model.p.cUO().a(paramString1, localEmojiInfo1, null);
      AppMethodBeat.o(284724);
      return;
    }
  }
  
  public final r a(w paramw, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31416);
    paramw = o.a(paramw, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31416);
    return paramw;
  }
  
  public final d a(Context paramContext, String paramString1, View paramView, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31419);
    paramContext = new o.a(paramContext).ee(paramString1).hv(paramView).w(Boolean.TRUE).hkx();
    paramContext.RfV = paramString2;
    paramContext = paramContext.a(parama).mUO;
    AppMethodBeat.o(31419);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31421);
    paramContext = new o.a(paramContext);
    paramContext.ee(paramString1);
    paramContext.bro(paramString2);
    paramContext.w(Boolean.TRUE);
    paramContext.RfV = paramString3;
    paramContext.a(parama).mUO.show();
    AppMethodBeat.o(31421);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31420);
    paramContext = new o.a(paramContext);
    paramContext.ee(paramString1).brm(paramString2).RfV = paramString3;
    paramContext.brn(paramString5).hkw();
    paramContext.RfU.bBh(paramString4);
    paramContext.a(parama).mUO.show();
    AppMethodBeat.o(31420);
  }
  
  public final void a(w paramw, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31417);
    o.a(paramw, paramString1, paramString2, paramString3, parama);
    AppMethodBeat.o(31417);
  }
  
  public final d b(w paramw, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31418);
    paramw = o.b(paramw, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31418);
    return paramw;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(284723);
    paramContext = new o.a(paramContext);
    paramContext.ee(paramString1);
    paramContext.brm(paramString2);
    paramContext.w(Boolean.TRUE);
    paramContext.hkv();
    paramContext.RfV = paramString3;
    paramContext.a(parama).mUO.show();
    AppMethodBeat.o(284723);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(284725);
    EmojiInfo localEmojiInfo2 = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.bxK(paramString2);
    String str = EmojiLogic.T(b.bcb(), "", paramString2);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      if (!ImgUtil.isGif(str)) {
        break label184;
      }
    }
    label184:
    for (int i = EmojiInfo.YCF;; i = EmojiInfo.YCE)
    {
      localEmojiInfo1 = new EmojiInfo();
      localEmojiInfo1.field_md5 = paramString2;
      localEmojiInfo1.field_catalog = EmojiInfo.YCx;
      localEmojiInfo1.field_type = i;
      localEmojiInfo1.field_size = ((int)u.bBQ(str));
      localEmojiInfo1.field_temp = 1;
      localEmojiInfo1.field_designerID = paramString3;
      localEmojiInfo1.field_thumbUrl = paramString5;
      com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.K(localEmojiInfo1);
      paramString2 = new o.a(paramContext);
      paramString2.ee(paramString1);
      paramString2.a(localEmojiInfo1, paramString4);
      paramString2.w(Boolean.TRUE);
      paramString2.RfV = paramContext.getString(R.l.app_send);
      paramString2.a(parama).mUO.show();
      AppMethodBeat.o(284725);
      return;
    }
  }
  
  public final void c(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31422);
    paramString2 = bj.hyV().VFH.bxK(paramString2);
    o.a locala = new o.a(paramContext);
    locala.ee(paramString1).a(paramString2, paramString3).w(Boolean.FALSE).aqk(R.l.app_send);
    locala.brl(paramContext.getResources().getString(R.l.retransmit_to_conv_comfirm));
    locala.a(parama).mUO.show();
    AppMethodBeat.o(31422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.p
 * JD-Core Version:    0.7.0.1
 */