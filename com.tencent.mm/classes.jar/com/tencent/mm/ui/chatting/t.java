package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class t
{
  long lIf;
  public LinearLayout lrN;
  Context mContext;
  public String pOH;
  String pOI;
  String pOJ;
  SharedPreferences sp;
  public FrameLayout zAa;
  public FrameLayout zAb;
  public TextView zAc;
  public ImageView zAd;
  t.a zAe;
  public int zAf;
  public boolean zAg;
  String zAh;
  public String zAi;
  public View.OnClickListener zAj;
  public View.OnClickListener zAk;
  private j.a zAl;
  public ChatFooterCustom zzZ;
  
  public t(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(30748);
    this.lrN = null;
    this.zAe = t.a.zAp;
    this.zAf = -1;
    this.zAh = null;
    this.lIf = -1L;
    this.zAj = new t.1(this);
    this.zAk = new t.2(this);
    this.zAl = new j.a()
    {
      public final void cdV()
      {
        AppMethodBeat.i(30743);
        t.this.zAc.setText(2131298126);
        AppMethodBeat.o(30743);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(30742);
        t.this.zAf = paramAnonymousInt;
        t.this.dGE();
        AppMethodBeat.o(30742);
      }
    };
    this.mContext = paramChatFooterCustom.getContext();
    this.zzZ = paramChatFooterCustom;
    AppMethodBeat.o(30748);
  }
  
  public final void dGC()
  {
    AppMethodBeat.i(30749);
    if (this.zAe == t.a.zAt)
    {
      this.zAd.setImageResource(2131231885);
      AppMethodBeat.o(30749);
      return;
    }
    this.zAd.setImageResource(2131231886);
    AppMethodBeat.o(30749);
  }
  
  public final void dGD()
  {
    AppMethodBeat.i(30750);
    Object localObject;
    if (p.u(this.mContext, "com.tencent.androidqqmail")) {
      localObject = t.a.zAt;
    }
    for (;;)
    {
      this.zAe = ((t.a)localObject);
      dGC();
      ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.zAe.toString() });
      switch (t.8.zAo[this.zAe.ordinal()])
      {
      default: 
        j.a(this.zAl);
        AppMethodBeat.o(30750);
        return;
        this.sp = this.mContext.getSharedPreferences("QQMAIL", h.Mp());
        this.lIf = this.sp.getLong("qqmail_downloadid", -1L);
        if (this.lIf < 0L)
        {
          if (bo.isNullOrNil(this.pOH)) {
            localObject = t.a.zAu;
          } else {
            localObject = t.a.zAq;
          }
        }
        else
        {
          localObject = f.bjl().iA(this.lIf);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.zAh = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (bo.isNullOrNil(this.pOH)) {
              localObject = t.a.zAu;
            }
            break;
          case 3: 
            if (e.cN(this.zAh)) {
              localObject = t.a.zAs;
            } else if (bo.isNullOrNil(this.pOH)) {
              localObject = t.a.zAu;
            } else {
              localObject = t.a.zAq;
            }
            break;
          case 1: 
            localObject = t.a.zAr;
            continue;
            localObject = t.a.zAq;
          }
        }
        break;
      }
    }
    this.zAc.setText(2131298119);
    AppMethodBeat.o(30750);
    return;
    this.zAc.setText(2131298117);
    AppMethodBeat.o(30750);
    return;
    j.a(this.zAl);
    AppMethodBeat.o(30750);
  }
  
  public final void dGE()
  {
    AppMethodBeat.i(30751);
    if (this.zAf == 0)
    {
      this.zAc.setText(2131298126);
      AppMethodBeat.o(30751);
      return;
    }
    if (this.zAf > 99)
    {
      this.zAc.setText(2131298125);
      AppMethodBeat.o(30751);
      return;
    }
    this.zAc.setText(String.format(a.aq(this.mContext, 2131298124), new Object[] { Integer.valueOf(this.zAf) }));
    AppMethodBeat.o(30751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t
 * JD-Core Version:    0.7.0.1
 */