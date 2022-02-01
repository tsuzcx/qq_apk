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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.go.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private static String dFD = "com.tencent.mm";
  private boolean AoA;
  boolean AoB;
  com.tencent.mm.ui.k.a AoC;
  ImageView Aoq;
  ImageView Aor;
  ImageView Aos;
  ImageView Aot;
  private boolean Aou;
  boolean Aov;
  boolean Aow;
  private boolean Aox;
  private boolean Aoy;
  private boolean Aoz;
  private Context context;
  private ProgressDialog sBI;
  boolean sKd;
  bvq zTr;
  
  public SnsUploadConfigView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99531);
    this.sKd = false;
    this.Aou = false;
    this.Aov = false;
    this.Aow = false;
    this.Aox = false;
    this.Aoy = false;
    this.Aoz = true;
    this.AoA = false;
    this.AoB = false;
    this.zTr = new bvq();
    this.AoC = new com.tencent.mm.ui.k.a();
    this.sBI = null;
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = z.jO(paramContext).inflate(2131495618, this, true);
    this.Aoq = ((ImageView)paramAttributeSet.findViewById(2131305071));
    this.Aor = ((ImageView)paramAttributeSet.findViewById(2131305073));
    this.Aos = ((ImageView)paramAttributeSet.findViewById(2131305072));
    this.Aot = ((ImageView)paramAttributeSet.findViewById(2131305074));
    paramAttributeSet = new StateListDrawable();
    Drawable localDrawable1 = ao.k(paramContext, 2131689537, Color.parseColor("#FFC300"));
    Drawable localDrawable2 = ao.k(paramContext, 2131689537, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.Aos.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ao.k(paramContext, 2131689527, Color.parseColor("#3C5998"));
    localDrawable2 = ao.k(paramContext, 2131689527, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.Aoq.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ao.k(paramContext, 2131689543, Color.parseColor("#1DA1F2"));
    localDrawable2 = ao.k(paramContext, 2131689543, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.Aor.setImageDrawable(paramAttributeSet);
    paramAttributeSet = new StateListDrawable();
    localDrawable1 = ao.k(paramContext, 2131689545, Color.parseColor("#FF0F80"));
    localDrawable2 = ao.k(paramContext, 2131689545, paramContext.getResources().getColor(2131099982));
    paramAttributeSet.addState(new int[] { 16842919, 16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { 16842919, -16842908 }, localDrawable1);
    paramAttributeSet.addState(new int[] { -16842908 }, localDrawable2);
    paramAttributeSet.addState(new int[0], localDrawable2);
    this.Aot.setImageDrawable(paramAttributeSet);
    if (!com.tencent.mm.ax.b.aJl()) {
      this.Aos.setVisibility(8);
    }
    g.ajD();
    if (!g.ajC().ajl().getBoolean(al.a.IsA, false)) {
      this.Aot.setVisibility(8);
    }
    if (!com.tencent.mm.ax.b.aJo()) {
      this.Aor.setVisibility(8);
    }
    if (!u.aAP()) {
      this.Aoq.setVisibility(8);
    }
    this.Aos.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.Aot.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99525);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((!SnsUploadConfigView.d(SnsUploadConfigView.this)) && (SnsUploadConfigView.b(SnsUploadConfigView.this)))
        {
          h.l(paramContext, 2131764010, 2131755906);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99525);
          return;
        }
        g.ajD();
        if (g.ajC().ajl().getBoolean(al.a.IsB, true))
        {
          g.ajD();
          g.ajC().ajl().set(al.a.IsB, Boolean.FALSE);
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
    this.Aoq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99526);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.Aor.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99527);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
  
  private void IN(int paramInt)
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
    if (this.sBI != null) {
      this.sBI.cancel();
    }
    switch (SnsUploadConfigView.7.uTV[paramc.ordinal()])
    {
    }
    for (;;)
    {
      edx();
      AppMethodBeat.o(99540);
      return;
      this.Aow = true;
      IN(2131764543);
      continue;
      this.Aow = false;
      continue;
      this.Aow = false;
      IN(2131764542);
    }
  }
  
  public final void b(a.c paramc)
  {
    AppMethodBeat.i(99541);
    switch (SnsUploadConfigView.7.uTV[paramc.ordinal()])
    {
    }
    for (;;)
    {
      edx();
      AppMethodBeat.o(99541);
      return;
      this.Aow = false;
    }
  }
  
  public final void edu()
  {
    AppMethodBeat.i(99532);
    this.Aou = false;
    this.Aov = false;
    this.Aow = false;
    this.Aox = false;
    this.Aoy = false;
    this.Aos.setImageDrawable(ao.k(this.context, 2131689537, this.context.getResources().getColor(2131099982)));
    this.Aot.setImageDrawable(ao.k(this.context, 2131689545, this.context.getResources().getColor(2131099982)));
    this.Aoq.setImageDrawable(ao.k(this.context, 2131689527, this.context.getResources().getColor(2131099982)));
    this.Aor.setImageDrawable(ao.k(this.context, 2131689543, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99532);
  }
  
  final void edv()
  {
    AppMethodBeat.i(99533);
    if (this.Aox)
    {
      g.ajD();
      int i = bt.n((Integer)g.ajC().ajl().get(9, null));
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
        this.Aox = false;
        AppMethodBeat.o(99533);
        return;
        if (i == 0) {
          break;
        }
      }
      label97:
      this.Aos.setImageDrawable(ao.k(this.context, 2131689537, Color.parseColor("#FFC300")));
      AppMethodBeat.o(99533);
      return;
    }
    this.Aos.setImageDrawable(ao.k(this.context, 2131689537, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99533);
  }
  
  final void edw()
  {
    AppMethodBeat.i(99534);
    if (this.Aot == null)
    {
      AppMethodBeat.o(99534);
      return;
    }
    if (this.AoB)
    {
      g.ajD();
      if (g.ajC().ajl().getBoolean(al.a.IsA, false)) {}
    }
    else
    {
      this.Aoy = false;
      this.Aot.setVisibility(8);
      AppMethodBeat.o(99534);
      return;
    }
    this.Aot.setVisibility(0);
    if (this.Aoy)
    {
      this.Aot.setImageDrawable(ao.k(this.context, 2131689545, Color.parseColor("#FF0F80")));
      AppMethodBeat.o(99534);
      return;
    }
    this.Aot.setImageDrawable(ao.k(this.context, 2131689545, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99534);
  }
  
  final void edx()
  {
    AppMethodBeat.i(99536);
    if (this.Aow)
    {
      if (!this.AoC.fLk()) {
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
        this.Aow = false;
        AppMethodBeat.o(99536);
        return;
      }
      this.Aor.setImageDrawable(ao.k(this.context, 2131689543, Color.parseColor("#1DA1F2")));
      AppMethodBeat.o(99536);
      return;
    }
    this.Aor.setImageDrawable(ao.k(this.context, 2131689543, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99536);
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.sKd) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.Aou) {
      j = 1;
    }
    int i = j;
    if (this.Aov) {
      i = j | 0x2;
    }
    j = i;
    if (this.Aow) {
      j = i | 0x8;
    }
    i = j;
    if (this.Aox) {
      i = j | 0x4;
    }
    j = i;
    if (this.Aoy) {
      j = i | 0x10;
    }
    return j;
  }
  
  public i getTwitterAccessToken()
  {
    return this.AoC.KPb;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99539);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn == null))
    {
      AppMethodBeat.o(99539);
      return;
    }
    edw();
    AppMethodBeat.o(99539);
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    AppMethodBeat.i(99537);
    this.sKd = paramBoolean;
    if (paramBoolean) {
      edu();
    }
    AppMethodBeat.o(99537);
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    AppMethodBeat.i(99535);
    if (this.Aov)
    {
      if (!u.aAS()) {
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
        this.Aov = false;
        AppMethodBeat.o(99535);
        return;
      }
      if ((!paramBoolean) && (!this.AoA) && (u.aAS()))
      {
        final go localgo = new go();
        localgo.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99521);
            if (!localgo.dsx.dno) {
              SnsUploadConfigView.m(SnsUploadConfigView.this);
            }
            AppMethodBeat.o(99521);
          }
        };
        com.tencent.mm.sdk.b.a.IbL.a(localgo, Looper.myLooper());
      }
      this.Aoq.setImageDrawable(ao.k(this.context, 2131689527, Color.parseColor("#3C5998")));
      AppMethodBeat.o(99535);
      return;
    }
    this.Aoq.setImageDrawable(ao.k(this.context, 2131689527, this.context.getResources().getColor(2131099982)));
    AppMethodBeat.o(99535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */