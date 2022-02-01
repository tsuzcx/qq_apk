package com.tencent.mm.ui.widget.pulldown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "btnOk", "Landroid/widget/Button;", "getBtnOk", "()Landroid/widget/Button;", "btnOk$delegate", "Lkotlin/Lazy;", "contentView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getContentView", "()Landroid/view/View;", "edtDecelerateRatio", "Landroid/widget/EditText;", "getEdtDecelerateRatio", "()Landroid/widget/EditText;", "edtDecelerateRatio$delegate", "edtMaxDampingFactor", "getEdtMaxDampingFactor", "edtMaxDampingFactor$delegate", "edtMaxSpringDuration", "getEdtMaxSpringDuration", "edtMaxSpringDuration$delegate", "edtMinDampingFactor", "getEdtMinDampingFactor", "edtMinDampingFactor$delegate", "edtMinSpringDuration", "getEdtMinSpringDuration", "edtMinSpringDuration$delegate", "index", "", "getIndex", "()I", "setIndex", "(I)V", "weui-native-android-lib_release"})
public final class h
  extends com.google.android.material.bottomsheet.a
{
  private final f MNN;
  private final f Ytp;
  private final f Ytq;
  private final f Ytr;
  private final f Yts;
  private final f Ytt;
  final View contentView;
  int index;
  
  public h(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(250605);
    this.Ytp = g.ar((kotlin.g.a.a)new e(this));
    this.Ytq = g.ar((kotlin.g.a.a)new c(this));
    this.Ytr = g.ar((kotlin.g.a.a)new d(this));
    this.Yts = g.ar((kotlin.g.a.a)new f(this));
    this.Ytt = g.ar((kotlin.g.a.a)new b(this));
    this.MNN = g.ar((kotlin.g.a.a)new a(this));
    this.contentView = LayoutInflater.from(paramContext).inflate(a.g.layout_nestscroll_setting, null, false);
    setContentView(this.contentView);
    paramContext = idD();
    Object localObject1 = i.YtH;
    paramContext.setText((CharSequence)String.valueOf(i.idL()));
    paramContext = idE();
    localObject1 = i.YtH;
    paramContext.setText((CharSequence)String.valueOf(i.idM()));
    paramContext = idG();
    localObject1 = i.YtH;
    paramContext.setText((CharSequence)String.valueOf(i.idK()));
    paramContext = idF();
    localObject1 = i.YtH;
    paramContext.setText((CharSequence)String.valueOf(i.idJ()));
    paramContext = idH();
    localObject1 = i.YtH;
    paramContext.setText((CharSequence)String.valueOf(i.idI()));
    ((Button)this.MNN.getValue()).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(250123);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = i.YtH;
        i.ayP((int)Float.parseFloat(this.Ytu.idD().getText().toString()));
        paramAnonymousView = i.YtH;
        i.ayQ((int)Float.parseFloat(this.Ytu.idE().getText().toString()));
        paramAnonymousView = i.YtH;
        i.ayO((int)Float.parseFloat(this.Ytu.idG().getText().toString()));
        paramAnonymousView = i.YtH;
        i.ayN((int)Float.parseFloat(this.Ytu.idF().getText().toString()));
        paramAnonymousView = i.YtH;
        i.cW(Float.parseFloat(this.Ytu.idH().getText().toString()));
        this.Ytu.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250123);
      }
    });
    paramContext = new ArrayList();
    paramContext.add("default");
    paramContext.add("scale");
    localObject1 = findViewById(a.f.option_text);
    if (localObject1 == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(250605);
      throw paramContext;
    }
    localObject1 = (TextView)localObject1;
    Object localObject2 = i.YtH;
    this.index = i.idN();
    ((TextView)localObject1).setText((CharSequence)paramContext.get(this.index));
    localObject2 = findViewById(a.f.option_picker);
    if (localObject2 == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.Button");
      AppMethodBeat.o(250605);
      throw paramContext;
    }
    ((Button)localObject2).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(250664);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(this.Ytu.getContext(), paramContext);
        paramAnonymousView.ayK(this.Ytu.index);
        paramAnonymousView.a((b.b)new b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(252232);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2Object2 = this.Ytx.Ytw;
              if (paramAnonymous2Object1 == null)
              {
                paramAnonymous2Object1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(252232);
                throw paramAnonymous2Object1;
              }
              paramAnonymous2Object2.setText((CharSequence)paramAnonymous2Object1);
            }
            paramAnonymous2Object1 = i.YtH;
            i.ayR(paramAnonymousView.idp());
            this.Ytx.Ytu.index = paramAnonymousView.idp();
            AppMethodBeat.o(252232);
          }
        });
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250664);
      }
    });
    AppMethodBeat.o(250605);
  }
  
  public final EditText idD()
  {
    AppMethodBeat.i(250597);
    EditText localEditText = (EditText)this.Ytp.getValue();
    AppMethodBeat.o(250597);
    return localEditText;
  }
  
  public final EditText idE()
  {
    AppMethodBeat.i(250598);
    EditText localEditText = (EditText)this.Ytq.getValue();
    AppMethodBeat.o(250598);
    return localEditText;
  }
  
  public final EditText idF()
  {
    AppMethodBeat.i(250600);
    EditText localEditText = (EditText)this.Ytr.getValue();
    AppMethodBeat.o(250600);
    return localEditText;
  }
  
  public final EditText idG()
  {
    AppMethodBeat.i(250601);
    EditText localEditText = (EditText)this.Yts.getValue();
    AppMethodBeat.o(250601);
    return localEditText;
  }
  
  public final EditText idH()
  {
    AppMethodBeat.i(250603);
    EditText localEditText = (EditText)this.Ytt.getValue();
    AppMethodBeat.o(250603);
    return localEditText;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Button>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<EditText>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<EditText>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<EditText>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<EditText>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<EditText>
  {
    f(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.h
 * JD-Core Version:    0.7.0.1
 */