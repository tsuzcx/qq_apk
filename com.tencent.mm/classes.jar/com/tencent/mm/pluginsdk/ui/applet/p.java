package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.vfs.s;

public final class p
  implements j
{
  public final void G(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(232197);
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().OpN.blk(paramString2);
    Object localObject = a.hdT;
    String str = EmojiLogic.W(a.awt(), "", paramString2);
    localObject = localEmojiInfo;
    if (localEmojiInfo == null) {
      if (!ImgUtil.isGif(str)) {
        break label143;
      }
    }
    label143:
    for (int i = EmojiInfo.Uux;; i = EmojiInfo.Uuw)
    {
      localObject = new EmojiInfo();
      ((EmojiInfo)localObject).field_md5 = paramString2;
      ((EmojiInfo)localObject).field_catalog = EmojiInfo.Uup;
      ((EmojiInfo)localObject).field_type = i;
      ((EmojiInfo)localObject).field_size = ((int)s.boW(str));
      ((EmojiInfo)localObject).field_temp = 1;
      ((EmojiInfo)localObject).field_designerID = paramString3;
      ((EmojiInfo)localObject).field_thumbUrl = paramString4;
      k.getEmojiStorageMgr().OpN.J((EmojiInfo)localObject);
      k.cGf().a(paramString1, (EmojiInfo)localObject, null);
      AppMethodBeat.o(232197);
      return;
    }
  }
  
  public final com.tencent.mm.ui.base.p a(t paramt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31416);
    paramt = o.a(paramt, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31416);
    return paramt;
  }
  
  public final d a(Context paramContext, String paramString1, View paramView, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31419);
    paramContext = new o.a(paramContext).ea(paramString1).gl(paramView).p(Boolean.TRUE).gpz();
    paramContext.Kfh = paramString2;
    paramContext = paramContext.a(parama).kdo;
    AppMethodBeat.o(31419);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31421);
    paramContext = new o.a(paramContext);
    paramContext.ea(paramString1);
    paramContext.beS(paramString2);
    paramContext.p(Boolean.TRUE);
    paramContext.Kfh = paramString3;
    paramContext.a(parama).kdo.show();
    AppMethodBeat.o(31421);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31420);
    paramContext = new o.a(paramContext);
    paramContext.ea(paramString1).beQ(paramString2).Kfh = paramString3;
    paramContext.beR(paramString5).gpy();
    paramContext.Kfg.bos(paramString4);
    paramContext.a(parama).kdo.show();
    AppMethodBeat.o(31420);
  }
  
  public final void a(t paramt, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31417);
    o.a(paramt, paramString1, paramString2, paramString3, parama);
    AppMethodBeat.o(31417);
  }
  
  public final d b(t paramt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31418);
    paramt = o.b(paramt, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31418);
    return paramt;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31422);
    paramString2 = bj.gCJ().OpN.blk(paramString2);
    o.a locala = new o.a(paramContext);
    locala.ea(paramString1).a(paramString2, paramString3).p(Boolean.FALSE).aii(2131755976);
    locala.beP(paramContext.getResources().getString(2131764633));
    locala.a(parama).kdo.show();
    AppMethodBeat.o(31422);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(232198);
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().OpN.blk(paramString2);
    Object localObject = a.hdT;
    String str = EmojiLogic.W(a.awt(), "", paramString2);
    localObject = localEmojiInfo;
    if (localEmojiInfo == null) {
      if (!ImgUtil.isGif(str)) {
        break label188;
      }
    }
    label188:
    for (int i = EmojiInfo.Uux;; i = EmojiInfo.Uuw)
    {
      localObject = new EmojiInfo();
      ((EmojiInfo)localObject).field_md5 = paramString2;
      ((EmojiInfo)localObject).field_catalog = EmojiInfo.Uup;
      ((EmojiInfo)localObject).field_type = i;
      ((EmojiInfo)localObject).field_size = ((int)s.boW(str));
      ((EmojiInfo)localObject).field_temp = 1;
      ((EmojiInfo)localObject).field_designerID = paramString3;
      ((EmojiInfo)localObject).field_thumbUrl = paramString5;
      k.getEmojiStorageMgr().OpN.J((EmojiInfo)localObject);
      paramString2 = new o.a(paramContext);
      paramString2.ea(paramString1);
      paramString2.a((EmojiInfo)localObject, paramString4);
      paramString2.p(Boolean.TRUE);
      paramString2.Kfh = paramContext.getString(2131755976);
      paramString2.a(parama).kdo.show();
      AppMethodBeat.o(232198);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.p
 * JD-Core Version:    0.7.0.1
 */