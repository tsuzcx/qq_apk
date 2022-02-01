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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.gp.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.b;
import com.tencent.mm.ui.k.a.c;
import com.tencent.mm.ui.z;
import org.b.d.i;

public class SnsUploadConfigView
  extends LinearLayout
  implements f, a.a, a.b
{
  private static String dGI = "com.tencent.mm";
  ImageView AFD;
  ImageView AFE;
  ImageView AFF;
  ImageView AFG;
  private boolean AFH;
  boolean AFI;
  boolean AFJ;
  private boolean AFK;
  private boolean AFL;
  private boolean AFM;
  private boolean AFN;
  boolean AFO;
  com.tencent.mm.ui.k.a AFP;
  bwk Aky;
  private Context context;
  private ProgressDialog sMH;
  boolean sVq;
  
  public SnsUploadConfigView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99531);
    this.sVq = false;
    this.AFH = false;
    this.AFI = false;
    this.AFJ = false;
    this.AFK = false;
    this.AFL = false;
    this.AFM = true;
    this.AFN = false;
    this.AFO = false;
    this.Aky = new bwk();
    this.AFP = new com.tencent.mm.ui.k.a();
    this.sMH = null;
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = z.jV(paramContext).inflate(2131495618, this, true);
    this.AFD = ((ImageView)paramAttributeSet.findViewById(2131305071));
    this.AFE = ((ImageView)paramAttributeSet.findViewById(2131305073));
    this.AFF = ((ImageView)paramAttributeSet.findViewById(2131305072));
    this.AFG = ((ImageView)paramAttributeSet.findViewById(2131305074));
    paramAttributeSet = new StateListDrawable();
    Drawable localDrawable1 = ao.k(paramContext, 2131689537, Color.parseColor("#FFC300"));
    Drawable localDrawable2 = ao.k(paramContext, 2131689537, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.AFF.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ao.k(paramContext, 2131689527, Color.parseColor("#3C5998"));
    localDrawable2 = ao.k(paramContext, 2131689527, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.AFD.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ao.k(paramContext, 2131689543, Color.parseColor("#1DA1F2"));
    localDrawable2 = ao.k(paramContext, 2131689543, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.AFE.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ao.k(paramContext, 2131689545, Color.parseColor("#FF0F80"));
    localDrawable2 = ao.k(paramContext, 2131689545, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.AFG.setImageDrawable(paramAttributeSet);
    if (!com.tencent.mm.aw.b.aJD()) {
      this.AFF.setVisibility(8);
    }
    g.ajS();
    if (!g.ajR().ajA().getBoolean(am.a.IMW, false)) {
      this.AFG.setVisibility(8);
    }
    if (!com.tencent.mm.aw.b.aJG()) {
      this.AFE.setVisibility(8);
    }
    if (!v.aBf()) {
      this.AFD.setVisibility(8);
    }
    this.AFF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((!SnsUploadConfigView.a(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.l(paramContext, 2131764008, 2131755906);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99520);
          return;
        }
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.a(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.a(paramAnonymousView, bool);
          SnsUploadConfigView.c(SnsUploadConfigView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99520);
          return;
        }
      }
    });
    this.AFG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99525);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((!SnsUploadConfigView.d(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.l(paramContext, 2131764010, 2131755906);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
        g.ajS();
        if (g.ajR().ajA().getBoolean(am.a.IMX, true))
        {
          g.ajS();
          g.ajR().ajA().set(am.a.IMX, Boolean.FALSE);
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.d(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.b(paramAnonymousView, bool);
          SnsUploadConfigView.e(SnsUploadConfigView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
      }
    });
    this.AFD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99526);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.f(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.c(paramAnonymousView, bool);
          if (SnsUploadConfigView.f(SnsUploadConfigView.this)) {
            SnsUploadConfigView.g(SnsUploadConfigView.this);
          }
          SnsUploadConfigView.h(SnsUploadConfigView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99526);
          return;
        }
      }
    });
    this.AFE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99527);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = SnsUploadConfigView.this;
        if (SnsUploadConfigView.i(SnsUploadConfigView.this)) {}
        for (boolean bool = false;; bool = true)
        {
          SnsUploadConfigView.d(paramAnonymousView, bool);
          if (SnsUploadConfigView.i(SnsUploadConfigView.this)) {
            SnsUploadConfigView.g(SnsUploadConfigView.this);
          }
          SnsUploadConfigView.j(SnsUploadConfigView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99527);
          return;
        }
      }
    });
    AppMethodBeat.o(99531);
  }
  
  private void Jl(int paramInt)
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
    if (this.sMH != null) {
      this.sMH.cancel();
    }
    switch (SnsUploadConfigView.7.vfI[paramc.ordinal()])
    {
    }
    for (;;)
    {
      ehe();
      AppMethodBeat.o(99540);
      return;
      this.AFJ = true;
      Jl(2131764543);
      continue;
      this.AFJ = false;
      continue;
      this.AFJ = false;
      Jl(2131764542);
    }
  }
  
  public final void b(a.c paramc)
  {
    AppMethodBeat.i(99541);
    switch (SnsUploadConfigView.7.vfI[paramc.ordinal()])
    {
    }
    for (;;)
    {
      ehe();
      AppMethodBeat.o(99541);
      return;
      this.AFJ = false;
    }
  }
  
  public final void ehb()
  {
    AppMethodBeat.i(99532);
    this.AFH = false;
    this.AFI = false;
    this.AFJ = false;
    this.AFK = false;
    this.AFL = false;
    this.AFF.setImageDrawable(ao.k(this.context, 2131689537, this.context.getResources().getColor(2131099982)));
    this.AFG.setImageDrawable(ao.k(this.context, 2131689545, this.context.getResources().getColor(2131099982)));
    this.AFD.setImageDrawable(ao.k(this.context, 2131689527, this.context.getResources().getColor(2131099982)));
    this.AFE.setImageDrawable(ao.k(this.context, 2131689543, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99532);
  }
  
  final void ehc()
  {
    AppMethodBeat.i(99533);
    if (this.AFK)
    {
      g.ajS();
      int i = bu.o((Integer)g.ajR().ajA().get(9, null));
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
        this.AFK = false;
        AppMethodBeat.o(99533);
        return;
        if (i == 0) {
          break;
        }
      }
      label97:
      this.AFF.setImageDrawable(ao.k(this.context, 2131689537, Color.parseColor("#FFC300")));
      AppMethodBeat.o(99533);
      return;
    }
    this.AFF.setImageDrawable(ao.k(this.context, 2131689537, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99533);
  }
  
  final void ehd()
  {
    AppMethodBeat.i(99534);
    if (this.AFG == null)
    {
      AppMethodBeat.o(99534);
      return;
    }
    if (this.AFO)
    {
      g.ajS();
      if (g.ajR().ajA().getBoolean(am.a.IMW, false)) {}
    }
    else
    {
      this.AFL = false;
      this.AFG.setVisibility(8);
      AppMethodBeat.o(99534);
      return;
    }
    this.AFG.setVisibility(0);
    if (this.AFL)
    {
      this.AFG.setImageDrawable(ao.k(this.context, 2131689545, Color.parseColor("#FF0F80")));
      AppMethodBeat.o(99534);
      return;
    }
    this.AFG.setImageDrawable(ao.k(this.context, 2131689545, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99534);
  }
  
  final void ehe()
  {
    AppMethodBeat.i(99536);
    if (this.AFJ)
    {
      if (!this.AFP.fPD()) {
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
        this.AFJ = false;
        AppMethodBeat.o(99536);
        return;
      }
      this.AFE.setImageDrawable(ao.k(this.context, 2131689543, Color.parseColor("#1DA1F2")));
      AppMethodBeat.o(99536);
      return;
    }
    this.AFE.setImageDrawable(ao.k(this.context, 2131689543, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99536);
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.sVq) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.AFH) {
      j = 1;
    }
    int i = j;
    if (this.AFI) {
      i = j | 0x2;
    }
    j = i;
    if (this.AFJ) {
      j = i | 0x8;
    }
    i = j;
    if (this.AFK) {
      i = j | 0x4;
    }
    j = i;
    if (this.AFL) {
      j = i | 0x10;
    }
    return j;
  }
  
  public i getTwitterAccessToken()
  {
    return this.AFP.Llz;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99539);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn == null))
    {
      AppMethodBeat.o(99539);
      return;
    }
    ehd();
    AppMethodBeat.o(99539);
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    AppMethodBeat.i(99537);
    this.sVq = paramBoolean;
    if (paramBoolean) {
      ehb();
    }
    AppMethodBeat.o(99537);
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    AppMethodBeat.i(99535);
    if (this.AFI)
    {
      if (!v.aBi()) {
        h.a(getContext(), 2131763220, 2131755906, new SnsUploadConfigView.13(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.AFI = false;
        AppMethodBeat.o(99535);
        return;
      }
      if ((!paramBoolean) && (!this.AFN) && (v.aBi()))
      {
        final gp localgp = new gp();
        localgp.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99521);
            if (!localgp.dtD.doq) {
              SnsUploadConfigView.m(SnsUploadConfigView.this);
            }
            AppMethodBeat.o(99521);
          }
        };
        com.tencent.mm.sdk.b.a.IvT.a(localgp, Looper.myLooper());
      }
      this.AFD.setImageDrawable(ao.k(this.context, 2131689527, Color.parseColor("#3C5998")));
      AppMethodBeat.o(99535);
      return;
    }
    this.AFD.setImageDrawable(ao.k(this.context, 2131689527, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */