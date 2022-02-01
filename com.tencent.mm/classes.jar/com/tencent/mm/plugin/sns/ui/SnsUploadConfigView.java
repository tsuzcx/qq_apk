package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.al.n;
import com.tencent.mm.ax.b;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.gk.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.b;
import com.tencent.mm.ui.k.a.c;
import com.tencent.mm.ui.y;
import org.b.d.i;

public class SnsUploadConfigView
  extends LinearLayout
  implements com.tencent.mm.al.g, a.a, a.b
{
  private static String dvP = "com.tencent.mm";
  private Context context;
  private ProgressDialog qLE;
  boolean xEc;
  ImageView xJQ;
  ImageView xJR;
  ImageView xJS;
  ImageView xJT;
  private boolean xJU;
  boolean xJV;
  boolean xJW;
  private boolean xJX;
  private boolean xJY;
  private boolean xJZ;
  private boolean xKa;
  boolean xKb;
  com.tencent.mm.ui.k.a xKc;
  bmn xph;
  
  public SnsUploadConfigView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99531);
    this.xEc = false;
    this.xJU = false;
    this.xJV = false;
    this.xJW = false;
    this.xJX = false;
    this.xJY = false;
    this.xJZ = true;
    this.xKa = false;
    this.xKb = false;
    this.xph = new bmn();
    this.xKc = new com.tencent.mm.ui.k.a();
    this.qLE = null;
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = y.js(paramContext).inflate(2131495618, this, true);
    this.xJQ = ((ImageView)paramAttributeSet.findViewById(2131305071));
    this.xJR = ((ImageView)paramAttributeSet.findViewById(2131305073));
    this.xJS = ((ImageView)paramAttributeSet.findViewById(2131305072));
    this.xJT = ((ImageView)paramAttributeSet.findViewById(2131305074));
    paramAttributeSet = new StateListDrawable();
    Drawable localDrawable1 = am.i(paramContext, 2131689537, Color.parseColor("#FFC300"));
    Drawable localDrawable2 = am.i(paramContext, 2131689537, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.xJS.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = am.i(paramContext, 2131689527, Color.parseColor("#3C5998"));
    localDrawable2 = am.i(paramContext, 2131689527, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.xJQ.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = am.i(paramContext, 2131689543, Color.parseColor("#1DA1F2"));
    localDrawable2 = am.i(paramContext, 2131689543, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.xJR.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = am.i(paramContext, 2131689545, Color.parseColor("#FF0F80"));
    localDrawable2 = am.i(paramContext, 2131689545, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.xJT.setImageDrawable(paramAttributeSet);
    if (!b.azl()) {
      this.xJS.setVisibility(8);
    }
    com.tencent.mm.kernel.g.afC();
    if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Fit, false)) {
      this.xJT.setVisibility(8);
    }
    if (!b.azo()) {
      this.xJR.setVisibility(8);
    }
    if (!u.arg()) {
      this.xJQ.setVisibility(8);
    }
    this.xJS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99520);
        if ((!SnsUploadConfigView.a(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.j(paramContext, 2131764008, 2131755906);
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
    this.xJT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(99525);
        if ((!SnsUploadConfigView.d(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.j(paramContext, 2131764010, 2131755906);
          AppMethodBeat.o(99525);
          return;
        }
        com.tencent.mm.kernel.g.afC();
        if (com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Fiu, true))
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fiu, Boolean.FALSE);
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
    this.xJQ.setOnClickListener(new View.OnClickListener()
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
    this.xJR.setOnClickListener(new View.OnClickListener()
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
  
  private void Fw(int paramInt)
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
    if (this.qLE != null) {
      this.qLE.cancel();
    }
    switch (7.sJC[paramc.ordinal()])
    {
    }
    for (;;)
    {
      dCI();
      AppMethodBeat.o(99540);
      return;
      this.xJW = true;
      Fw(2131764543);
      continue;
      this.xJW = false;
      continue;
      this.xJW = false;
      Fw(2131764542);
    }
  }
  
  public final void b(a.c paramc)
  {
    AppMethodBeat.i(99541);
    switch (7.sJC[paramc.ordinal()])
    {
    }
    for (;;)
    {
      dCI();
      AppMethodBeat.o(99541);
      return;
      this.xJW = false;
    }
  }
  
  public final void dCF()
  {
    AppMethodBeat.i(99532);
    this.xJU = false;
    this.xJV = false;
    this.xJW = false;
    this.xJX = false;
    this.xJY = false;
    this.xJS.setImageDrawable(am.i(this.context, 2131689537, this.context.getResources().getColor(2131099982)));
    this.xJT.setImageDrawable(am.i(this.context, 2131689545, this.context.getResources().getColor(2131099982)));
    this.xJQ.setImageDrawable(am.i(this.context, 2131689527, this.context.getResources().getColor(2131099982)));
    this.xJR.setImageDrawable(am.i(this.context, 2131689543, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99532);
  }
  
  final void dCG()
  {
    AppMethodBeat.i(99533);
    if (this.xJX)
    {
      com.tencent.mm.kernel.g.afC();
      int i = bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(9, null));
      if (i == 0) {
        h.a(getContext(), 2131763508, 2131755906, new SnsUploadConfigView.11(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label97;
        }
        this.xJX = false;
        AppMethodBeat.o(99533);
        return;
        if (i == 0) {
          break;
        }
      }
      label97:
      this.xJS.setImageDrawable(am.i(this.context, 2131689537, Color.parseColor("#FFC300")));
      AppMethodBeat.o(99533);
      return;
    }
    this.xJS.setImageDrawable(am.i(this.context, 2131689537, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99533);
  }
  
  final void dCH()
  {
    AppMethodBeat.i(99534);
    if (this.xJT == null)
    {
      AppMethodBeat.o(99534);
      return;
    }
    if (this.xKb)
    {
      com.tencent.mm.kernel.g.afC();
      if (com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Fit, false)) {}
    }
    else
    {
      this.xJY = false;
      this.xJT.setVisibility(8);
      AppMethodBeat.o(99534);
      return;
    }
    this.xJT.setVisibility(0);
    if (this.xJY)
    {
      this.xJT.setImageDrawable(am.i(this.context, 2131689545, Color.parseColor("#FF0F80")));
      AppMethodBeat.o(99534);
      return;
    }
    this.xJT.setImageDrawable(am.i(this.context, 2131689545, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99534);
  }
  
  final void dCI()
  {
    AppMethodBeat.i(99536);
    if (this.xJW)
    {
      if (!this.xKc.feC()) {
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
        this.xJW = false;
        AppMethodBeat.o(99536);
        return;
      }
      this.xJR.setImageDrawable(am.i(this.context, 2131689543, Color.parseColor("#1DA1F2")));
      AppMethodBeat.o(99536);
      return;
    }
    this.xJR.setImageDrawable(am.i(this.context, 2131689543, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99536);
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.xEc) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.xJU) {
      j = 1;
    }
    int i = j;
    if (this.xJV) {
      i = j | 0x2;
    }
    j = i;
    if (this.xJW) {
      j = i | 0x8;
    }
    i = j;
    if (this.xJX) {
      i = j | 0x4;
    }
    j = i;
    if (this.xJY) {
      j = i | 0x10;
    }
    return j;
  }
  
  public i getTwitterAccessToken()
  {
    return this.xKc.Hxz;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99539);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn == null))
    {
      AppMethodBeat.o(99539);
      return;
    }
    dCH();
    AppMethodBeat.o(99539);
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    AppMethodBeat.i(99537);
    this.xEc = paramBoolean;
    if (paramBoolean) {
      dCF();
    }
    AppMethodBeat.o(99537);
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    AppMethodBeat.i(99535);
    if (this.xJV)
    {
      if (!u.arj()) {
        h.a(getContext(), 2131763220, 2131755906, new SnsUploadConfigView.13(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.xJV = false;
        AppMethodBeat.o(99535);
        return;
      }
      if ((!paramBoolean) && (!this.xKa) && (u.arj()))
      {
        final gk localgk = new gk();
        localgk.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99521);
            if (!localgk.djE.dew) {
              SnsUploadConfigView.m(SnsUploadConfigView.this);
            }
            AppMethodBeat.o(99521);
          }
        };
        com.tencent.mm.sdk.b.a.ESL.a(localgk, Looper.myLooper());
      }
      this.xJQ.setImageDrawable(am.i(this.context, 2131689527, Color.parseColor("#3C5998")));
      AppMethodBeat.o(99535);
      return;
    }
    this.xJQ.setImageDrawable(am.i(this.context, 2131689527, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */