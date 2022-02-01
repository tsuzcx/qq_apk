package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.a.b;
import com.tencent.mm.ui.widget.a.e.a.d;

public final class o$a
{
  final e.a GGP;
  public String GGQ;
  Context mContext;
  public e pRv;
  public DialogInterface.OnDismissListener uBy;
  
  public o$a(Context paramContext)
  {
    AppMethodBeat.i(31360);
    this.GGQ = null;
    this.mContext = paramContext;
    this.GGP = new e.a(this.mContext);
    this.GGP.NC(false);
    this.GGP.ND(false);
    this.GGP.a(new e.a.d()
    {
      public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
      {
        AppMethodBeat.i(31359);
        paramAnonymousCharSequence = ((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(o.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
        AppMethodBeat.o(31359);
        return paramAnonymousCharSequence;
      }
    });
    AppMethodBeat.o(31360);
  }
  
  public final a I(Boolean paramBoolean)
  {
    AppMethodBeat.i(31370);
    this.GGP.NB(paramBoolean.booleanValue());
    if (paramBoolean.booleanValue()) {
      this.GGP.bDA(this.mContext.getString(R.l.confirm_dialog_edittext_hint));
    }
    AppMethodBeat.o(31370);
    return this;
  }
  
  public final a JH(boolean paramBoolean)
  {
    AppMethodBeat.i(245304);
    this.GGP.NC(paramBoolean);
    this.GGP.ND(paramBoolean);
    AppMethodBeat.o(245304);
    return this;
  }
  
  public final a a(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(245320);
    o.a(this.mContext, this.GGP, paramEmojiInfo, paramString);
    this.GGP.NA(false);
    AppMethodBeat.o(245320);
    return this;
  }
  
  public final a a(e.a.b paramb)
  {
    AppMethodBeat.i(31368);
    this.GGP.c(paramb);
    AppMethodBeat.o(31368);
    return this;
  }
  
  public final a awo(int paramInt)
  {
    AppMethodBeat.i(31372);
    this.GGQ = this.mContext.getResources().getString(paramInt);
    AppMethodBeat.o(31372);
    return this;
  }
  
  public final a b(y.a parama)
  {
    AppMethodBeat.i(31373);
    this.pRv = this.GGP.jHH();
    if (this.uBy != null) {
      this.pRv.setOnDismissListener(this.uBy);
    }
    o.a(this.mContext, this.pRv, this.GGQ, parama, parama);
    AppMethodBeat.o(31373);
    return this;
  }
  
  public final a bqZ(String paramString)
  {
    AppMethodBeat.i(31362);
    int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, (int)(20.0F * com.tencent.mm.cd.a.getScaleSize(this.mContext)));
    if (!Util.isNullOrNil(paramString))
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(this.mContext, paramString.toString(), i);
      this.GGP.bc(paramString);
    }
    AppMethodBeat.o(31362);
    return this;
  }
  
  public final a bra(String paramString)
  {
    AppMethodBeat.i(31364);
    int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.cd.a.getScaleSize(this.mContext)));
    if (!Util.isNullOrNil(paramString))
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(this.mContext, paramString.toString(), i);
      this.GGP.be(paramString);
    }
    AppMethodBeat.o(31364);
    return this;
  }
  
  public final a brb(String paramString)
  {
    AppMethodBeat.i(31365);
    this.GGP.bDy(paramString);
    AppMethodBeat.o(31365);
    return this;
  }
  
  public final a brc(String paramString)
  {
    AppMethodBeat.i(31367);
    o.a(this.mContext, this.GGP, paramString);
    this.GGP.NA(false);
    AppMethodBeat.o(31367);
    return this;
  }
  
  public final a gA(Object paramObject)
  {
    AppMethodBeat.i(31361);
    o.a(this.mContext, this.GGP, paramObject);
    this.GGP.NA(true);
    AppMethodBeat.o(31361);
    return this;
  }
  
  public final a iLm()
  {
    AppMethodBeat.i(31363);
    this.GGP.aEP(2);
    AppMethodBeat.o(31363);
    return this;
  }
  
  public final a iLn()
  {
    this.GGP.ageh.acrg = 8;
    return this;
  }
  
  public final a iLo()
  {
    AppMethodBeat.i(31371);
    this.GGP.NA(false);
    AppMethodBeat.o(31371);
    return this;
  }
  
  public final a kL(View paramView)
  {
    AppMethodBeat.i(31369);
    this.GGP.md(paramView);
    AppMethodBeat.o(31369);
    return this;
  }
  
  public final a m(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(31366);
    this.GGP.b(paramBitmap, true, paramInt);
    this.GGP.NA(false);
    o.b(this.GGP, paramBitmap);
    AppMethodBeat.o(31366);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o.a
 * JD-Core Version:    0.7.0.1
 */