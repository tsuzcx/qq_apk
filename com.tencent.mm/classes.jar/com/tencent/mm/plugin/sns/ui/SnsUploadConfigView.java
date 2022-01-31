package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.au.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.j.a.a;
import com.tencent.mm.ui.j.a.b;
import com.tencent.mm.ui.j.a.c;
import com.tencent.mm.ui.w;
import org.b.d.i;

public class SnsUploadConfigView
  extends LinearLayout
  implements f, a.a, a.b
{
  private static String bYA = "com.tencent.mm";
  private Context context;
  private ProgressDialog nVm;
  boolean rVp;
  com.tencent.mm.ui.j.a sbA;
  ImageView sbn;
  ImageView sbo;
  ImageView sbp;
  ImageView sbq;
  private boolean sbr;
  boolean sbs;
  boolean sbt;
  private boolean sbu;
  private boolean sbv;
  private boolean sbw;
  private boolean sbx;
  boolean sby;
  bap sbz;
  
  public SnsUploadConfigView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39701);
    this.rVp = false;
    this.sbr = false;
    this.sbs = false;
    this.sbt = false;
    this.sbu = false;
    this.sbv = false;
    this.sbw = true;
    this.sbx = false;
    this.sby = false;
    this.sbz = new bap();
    this.sbA = new com.tencent.mm.ui.j.a();
    this.nVm = null;
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = w.hM(paramContext).inflate(2130970891, this, true);
    this.sbn = ((ImageView)paramAttributeSet.findViewById(2131828167));
    this.sbo = ((ImageView)paramAttributeSet.findViewById(2131828168));
    this.sbp = ((ImageView)paramAttributeSet.findViewById(2131828165));
    this.sbq = ((ImageView)paramAttributeSet.findViewById(2131828166));
    if (!b.aie()) {
      this.sbp.setVisibility(8);
    }
    g.RM();
    if (!g.RL().Ru().getBoolean(ac.a.yzX, false)) {
      this.sbq.setVisibility(8);
    }
    if (!b.aih()) {
      this.sbo.setVisibility(8);
    }
    if (!r.ZM()) {
      this.sbn.setVisibility(8);
    }
    this.sbp.setOnClickListener(new SnsUploadConfigView.1(this, paramContext));
    this.sbq.setOnClickListener(new SnsUploadConfigView.8(this, paramContext));
    this.sbn.setOnClickListener(new SnsUploadConfigView.9(this));
    this.sbo.setOnClickListener(new SnsUploadConfigView.10(this));
    AppMethodBeat.o(39701);
  }
  
  private void xU(int paramInt)
  {
    AppMethodBeat.i(39708);
    h.a(getContext(), paramInt, 2131297087, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(39708);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(39710);
    if (this.nVm != null) {
      this.nVm.cancel();
    }
    switch (SnsUploadConfigView.7.nVJ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      cwz();
      AppMethodBeat.o(39710);
      return;
      this.sbt = true;
      xU(2131304399);
      continue;
      this.sbt = false;
      continue;
      this.sbt = false;
      xU(2131304398);
    }
  }
  
  public final void b(a.c paramc)
  {
    AppMethodBeat.i(39711);
    switch (SnsUploadConfigView.7.nVJ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      cwz();
      AppMethodBeat.o(39711);
      return;
      this.sbt = false;
    }
  }
  
  public final void cww()
  {
    AppMethodBeat.i(39702);
    this.sbr = false;
    this.sbs = false;
    this.sbt = false;
    this.sbu = false;
    this.sbv = false;
    this.sbp.setImageResource(2131230782);
    this.sbq.setImageResource(2131230790);
    this.sbn.setImageResource(2131230772);
    this.sbo.setImageResource(2131230788);
    AppMethodBeat.o(39702);
  }
  
  final void cwx()
  {
    AppMethodBeat.i(39703);
    if (this.sbu)
    {
      g.RM();
      int i = bo.g((Integer)g.RL().Ru().get(9, null));
      if (i == 0) {
        h.a(getContext(), 2131303526, 2131297087, new SnsUploadConfigView.11(this), new SnsUploadConfigView.12(this));
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label96;
        }
        this.sbu = false;
        AppMethodBeat.o(39703);
        return;
        if (i == 0) {
          break;
        }
      }
      label96:
      this.sbp.setImageResource(2131230783);
      AppMethodBeat.o(39703);
      return;
    }
    this.sbp.setImageResource(2131230782);
    AppMethodBeat.o(39703);
  }
  
  final void cwy()
  {
    AppMethodBeat.i(39704);
    if (this.sbq == null)
    {
      AppMethodBeat.o(39704);
      return;
    }
    if (this.sby)
    {
      g.RM();
      if (g.RL().Ru().getBoolean(ac.a.yzX, false)) {}
    }
    else
    {
      this.sbv = false;
      this.sbq.setVisibility(8);
      AppMethodBeat.o(39704);
      return;
    }
    this.sbq.setVisibility(0);
    if (this.sbv)
    {
      this.sbq.setImageResource(2131230791);
      AppMethodBeat.o(39704);
      return;
    }
    this.sbq.setImageResource(2131230790);
    AppMethodBeat.o(39704);
  }
  
  final void cwz()
  {
    AppMethodBeat.i(39706);
    if (this.sbt)
    {
      if (!this.sbA.dOy()) {
        h.a(getContext(), 2131303493, 2131297087, new SnsUploadConfigView.15(this), new SnsUploadConfigView.2(this));
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.sbt = false;
        AppMethodBeat.o(39706);
        return;
      }
      this.sbo.setImageResource(2131230789);
      AppMethodBeat.o(39706);
      return;
    }
    this.sbo.setImageResource(2131230788);
    AppMethodBeat.o(39706);
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.rVp) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.sbr) {
      j = 1;
    }
    int i = j;
    if (this.sbs) {
      i = j | 0x2;
    }
    j = i;
    if (this.sbt) {
      j = i | 0x8;
    }
    i = j;
    if (this.sbu) {
      i = j | 0x4;
    }
    j = i;
    if (this.sbv) {
      j = i | 0x10;
    }
    return j;
  }
  
  public i getTwitterAccessToken()
  {
    return this.sbA.ABb;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(39709);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramm == null))
    {
      AppMethodBeat.o(39709);
      return;
    }
    cwy();
    AppMethodBeat.o(39709);
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    AppMethodBeat.i(39707);
    this.rVp = paramBoolean;
    if (paramBoolean) {
      cww();
    }
    AppMethodBeat.o(39707);
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    AppMethodBeat.i(39705);
    if (this.sbs)
    {
      if (!r.ZP()) {
        h.a(getContext(), 2131303251, 2131297087, new DialogInterface.OnClickListener()new SnsUploadConfigView.14
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(39699);
            d.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
            AppMethodBeat.o(39699);
          }
        }, new SnsUploadConfigView.14(this));
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.sbs = false;
        AppMethodBeat.o(39705);
        return;
      }
      if ((!paramBoolean) && (!this.sbx) && (r.ZP()))
      {
        gd localgd = new gd();
        localgd.callback = new SnsUploadConfigView.3(this, localgd);
        com.tencent.mm.sdk.b.a.ymk.a(localgd, Looper.myLooper());
      }
      this.sbn.setImageResource(2131230773);
      AppMethodBeat.o(39705);
      return;
    }
    this.sbn.setImageResource(2131230772);
    AppMethodBeat.o(39705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */