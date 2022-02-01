package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.aw.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gl.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.b;
import com.tencent.mm.ui.k.a.c;
import com.tencent.mm.ui.z;
import org.b.d.i;

public class SnsUploadConfigView
  extends LinearLayout
  implements com.tencent.mm.ak.g, a.a, a.b
{
  private static String dtC = "com.tencent.mm";
  private Context context;
  private ProgressDialog rGq;
  brd yBX;
  boolean yQQ;
  ImageView yWG;
  ImageView yWH;
  ImageView yWI;
  ImageView yWJ;
  private boolean yWK;
  boolean yWL;
  boolean yWM;
  private boolean yWN;
  private boolean yWO;
  private boolean yWP;
  private boolean yWQ;
  boolean yWR;
  com.tencent.mm.ui.k.a yWS;
  
  public SnsUploadConfigView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99531);
    this.yQQ = false;
    this.yWK = false;
    this.yWL = false;
    this.yWM = false;
    this.yWN = false;
    this.yWO = false;
    this.yWP = true;
    this.yWQ = false;
    this.yWR = false;
    this.yBX = new brd();
    this.yWS = new com.tencent.mm.ui.k.a();
    this.rGq = null;
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = z.jD(paramContext).inflate(2131495618, this, true);
    this.yWG = ((ImageView)paramAttributeSet.findViewById(2131305071));
    this.yWH = ((ImageView)paramAttributeSet.findViewById(2131305073));
    this.yWI = ((ImageView)paramAttributeSet.findViewById(2131305072));
    this.yWJ = ((ImageView)paramAttributeSet.findViewById(2131305074));
    paramAttributeSet = new StateListDrawable();
    Drawable localDrawable1 = am.k(paramContext, 2131689537, Color.parseColor("#FFC300"));
    Drawable localDrawable2 = am.k(paramContext, 2131689537, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.yWI.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = am.k(paramContext, 2131689527, Color.parseColor("#3C5998"));
    localDrawable2 = am.k(paramContext, 2131689527, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.yWG.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = am.k(paramContext, 2131689543, Color.parseColor("#1DA1F2"));
    localDrawable2 = am.k(paramContext, 2131689543, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.yWH.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = am.k(paramContext, 2131689545, Color.parseColor("#FF0F80"));
    localDrawable2 = am.k(paramContext, 2131689545, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.yWJ.setImageDrawable(paramAttributeSet);
    if (!b.aGc()) {
      this.yWI.setVisibility(8);
    }
    com.tencent.mm.kernel.g.agS();
    if (!com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GGi, false)) {
      this.yWJ.setVisibility(8);
    }
    if (!b.aGf()) {
      this.yWH.setVisibility(8);
    }
    if (!u.axW()) {
      this.yWG.setVisibility(8);
    }
    this.yWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99520);
        if ((!SnsUploadConfigView.a(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.l(paramContext, 2131764008, 2131755906);
          AppMethodBeat.o(99520);
          return;
        }
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.a(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.a(paramAnonymousView, bool);
          SnsUploadConfigView.c(SnsUploadConfigView.this);
          AppMethodBeat.o(99520);
          return;
        }
      }
    });
    this.yWJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(99525);
        if ((!SnsUploadConfigView.d(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.l(paramContext, 2131764010, 2131755906);
          AppMethodBeat.o(99525);
          return;
        }
        com.tencent.mm.kernel.g.agS();
        if (com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GGj, true))
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGj, Boolean.FALSE);
          h.a(paramContext, 2131763995, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(99524);
              paramAnonymous2DialogInterface = SnsUploadConfigView.this;
              if (SnsUploadConfigView.d(SnsUploadConfigView.this)) {}
              for (boolean bool = false;; bool = true)
              {
                SnsUploadConfigView.b(paramAnonymous2DialogInterface, bool);
                SnsUploadConfigView.e(SnsUploadConfigView.this);
                AppMethodBeat.o(99524);
                return;
              }
            }
          });
          AppMethodBeat.o(99525);
          return;
        }
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.d(SnsUploadConfigView.this)) {
          bool = false;
        }
        SnsUploadConfigView.b(paramAnonymousView, bool);
        SnsUploadConfigView.e(SnsUploadConfigView.this);
        AppMethodBeat.o(99525);
      }
    });
    this.yWG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99526);
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.f(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.c(paramAnonymousView, bool);
          if (SnsUploadConfigView.f(SnsUploadConfigView.this)) {
            SnsUploadConfigView.g(SnsUploadConfigView.this);
          }
          SnsUploadConfigView.h(SnsUploadConfigView.this);
          AppMethodBeat.o(99526);
          return;
        }
      }
    });
    this.yWH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99527);
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.i(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.d(paramAnonymousView, bool);
          if (SnsUploadConfigView.i(SnsUploadConfigView.this)) {
            SnsUploadConfigView.g(SnsUploadConfigView.this);
          }
          SnsUploadConfigView.j(SnsUploadConfigView.this);
          AppMethodBeat.o(99527);
          return;
        }
      }
    });
    AppMethodBeat.o(99531);
  }
  
  private void Hr(int paramInt)
  {
    AppMethodBeat.i(99538);
    h.a(getContext(), paramInt, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(99538);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(99540);
    if (this.rGq != null) {
      this.rGq.cancel();
    }
    switch (SnsUploadConfigView.7.tRi[paramc.ordinal()])
    {
    }
    for (;;)
    {
      dRf();
      AppMethodBeat.o(99540);
      return;
      this.yWM = true;
      Hr(2131764543);
      continue;
      this.yWM = false;
      continue;
      this.yWM = false;
      Hr(2131764542);
    }
  }
  
  public final void b(a.c paramc)
  {
    AppMethodBeat.i(99541);
    switch (SnsUploadConfigView.7.tRi[paramc.ordinal()])
    {
    }
    for (;;)
    {
      dRf();
      AppMethodBeat.o(99541);
      return;
      this.yWM = false;
    }
  }
  
  public final void dRc()
  {
    AppMethodBeat.i(99532);
    this.yWK = false;
    this.yWL = false;
    this.yWM = false;
    this.yWN = false;
    this.yWO = false;
    this.yWI.setImageDrawable(am.k(this.context, 2131689537, this.context.getResources().getColor(2131099982)));
    this.yWJ.setImageDrawable(am.k(this.context, 2131689545, this.context.getResources().getColor(2131099982)));
    this.yWG.setImageDrawable(am.k(this.context, 2131689527, this.context.getResources().getColor(2131099982)));
    this.yWH.setImageDrawable(am.k(this.context, 2131689543, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99532);
  }
  
  final void dRd()
  {
    AppMethodBeat.i(99533);
    if (this.yWN)
    {
      com.tencent.mm.kernel.g.agS();
      int i = bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(9, null));
      if (i == 0) {
        h.a(getContext(), 2131763508, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99528);
            com.tencent.mm.plugin.sns.c.a.iyx.g(new Intent(), SnsUploadConfigView.k(SnsUploadConfigView.this));
            AppMethodBeat.o(99528);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label97;
        }
        this.yWN = false;
        AppMethodBeat.o(99533);
        return;
        if (i == 0) {
          break;
        }
      }
      label97:
      this.yWI.setImageDrawable(am.k(this.context, 2131689537, Color.parseColor("#FFC300")));
      AppMethodBeat.o(99533);
      return;
    }
    this.yWI.setImageDrawable(am.k(this.context, 2131689537, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99533);
  }
  
  final void dRe()
  {
    AppMethodBeat.i(99534);
    if (this.yWJ == null)
    {
      AppMethodBeat.o(99534);
      return;
    }
    if (this.yWR)
    {
      com.tencent.mm.kernel.g.agS();
      if (com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GGi, false)) {}
    }
    else
    {
      this.yWO = false;
      this.yWJ.setVisibility(8);
      AppMethodBeat.o(99534);
      return;
    }
    this.yWJ.setVisibility(0);
    if (this.yWO)
    {
      this.yWJ.setImageDrawable(am.k(this.context, 2131689545, Color.parseColor("#FF0F80")));
      AppMethodBeat.o(99534);
      return;
    }
    this.yWJ.setImageDrawable(am.k(this.context, 2131689545, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99534);
  }
  
  final void dRf()
  {
    AppMethodBeat.i(99536);
    if (this.yWM)
    {
      if (!this.yWS.fux()) {
        h.a(getContext(), 2131763475, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99530);
            paramAnonymousDialogInterface = SnsUploadConfigView.this;
            Context localContext = SnsUploadConfigView.this.getContext();
            SnsUploadConfigView.this.getContext().getString(2131755906);
            SnsUploadConfigView.a(paramAnonymousDialogInterface, h.b(localContext, SnsUploadConfigView.this.getContext().getString(2131764541), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
            }));
            SnsUploadConfigView.l(SnsUploadConfigView.this).a(SnsUploadConfigView.this, SnsUploadConfigView.this.getContext());
            AppMethodBeat.o(99530);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.yWM = false;
        AppMethodBeat.o(99536);
        return;
      }
      this.yWH.setImageDrawable(am.k(this.context, 2131689543, Color.parseColor("#1DA1F2")));
      AppMethodBeat.o(99536);
      return;
    }
    this.yWH.setImageDrawable(am.k(this.context, 2131689543, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99536);
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.yQQ) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.yWK) {
      j = 1;
    }
    int i = j;
    if (this.yWL) {
      i = j | 0x2;
    }
    j = i;
    if (this.yWM) {
      j = i | 0x8;
    }
    i = j;
    if (this.yWN) {
      i = j | 0x4;
    }
    j = i;
    if (this.yWO) {
      j = i | 0x10;
    }
    return j;
  }
  
  public i getTwitterAccessToken()
  {
    return this.yWS.IXW;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99539);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn == null))
    {
      AppMethodBeat.o(99539);
      return;
    }
    dRe();
    AppMethodBeat.o(99539);
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    AppMethodBeat.i(99537);
    this.yQQ = paramBoolean;
    if (paramBoolean) {
      dRc();
    }
    AppMethodBeat.o(99537);
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    AppMethodBeat.i(99535);
    if (this.yWL)
    {
      if (!u.axZ()) {
        h.a(getContext(), 2131763220, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99529);
            d.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
            AppMethodBeat.o(99529);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.yWL = false;
        AppMethodBeat.o(99535);
        return;
      }
      if ((!paramBoolean) && (!this.yWQ) && (u.axZ()))
      {
        final gl localgl = new gl();
        localgl.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99521);
            if (!localgl.dgZ.dbS) {
              SnsUploadConfigView.m(SnsUploadConfigView.this);
            }
            AppMethodBeat.o(99521);
          }
        };
        com.tencent.mm.sdk.b.a.GpY.a(localgl, Looper.myLooper());
      }
      this.yWG.setImageDrawable(am.k(this.context, 2131689527, Color.parseColor("#3C5998")));
      AppMethodBeat.o(99535);
      return;
    }
    this.yWG.setImageDrawable(am.k(this.context, 2131689527, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */