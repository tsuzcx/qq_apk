package com.tencent.mm.ui.widget.pulldown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "btnOk", "Landroid/widget/Button;", "getBtnOk", "()Landroid/widget/Button;", "btnOk$delegate", "Lkotlin/Lazy;", "contentView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getContentView", "()Landroid/view/View;", "edtDecelerateRatio", "Landroid/widget/EditText;", "getEdtDecelerateRatio", "()Landroid/widget/EditText;", "edtDecelerateRatio$delegate", "edtMaxDampingFactor", "getEdtMaxDampingFactor", "edtMaxDampingFactor$delegate", "edtMaxSpringDuration", "getEdtMaxSpringDuration", "edtMaxSpringDuration$delegate", "edtMinDampingFactor", "getEdtMinDampingFactor", "edtMinDampingFactor$delegate", "edtMinSpringDuration", "getEdtMinSpringDuration", "edtMinSpringDuration$delegate", "index", "", "getIndex", "()I", "setIndex", "(I)V", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.google.android.material.bottomsheet.a
{
  private final kotlin.j TAl;
  private final kotlin.j aglD;
  private final kotlin.j aglE;
  private final kotlin.j aglF;
  private final kotlin.j aglG;
  private final kotlin.j aglH;
  final View contentView;
  int index;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251956);
    this.aglD = k.cm((kotlin.g.a.a)new f(this));
    this.aglE = k.cm((kotlin.g.a.a)new d(this));
    this.aglF = k.cm((kotlin.g.a.a)new e(this));
    this.aglG = k.cm((kotlin.g.a.a)new g(this));
    this.aglH = k.cm((kotlin.g.a.a)new c(this));
    this.TAl = k.cm((kotlin.g.a.a)new b(this));
    this.contentView = LayoutInflater.from(paramContext).inflate(a.g.layout_nestscroll_setting, null, false);
    setContentView(this.contentView);
    paramContext = jIL();
    Object localObject1 = j.aglL;
    paramContext.setText((CharSequence)String.valueOf(j.jIT()));
    paramContext = jIM();
    localObject1 = j.aglL;
    paramContext.setText((CharSequence)String.valueOf(j.jIU()));
    paramContext = jIO();
    localObject1 = j.aglL;
    paramContext.setText((CharSequence)String.valueOf(j.jIS()));
    paramContext = jIN();
    localObject1 = j.aglL;
    paramContext.setText((CharSequence)String.valueOf(j.jIR()));
    paramContext = jIP();
    localObject1 = j.aglL;
    paramContext.setText((CharSequence)String.valueOf(j.jIQ()));
    paramContext = this.TAl.getValue();
    s.s(paramContext, "<get-btnOk>(...)");
    ((Button)paramContext).setOnClickListener(new i..ExternalSyntheticLambda0(this));
    paramContext = new ArrayList();
    paramContext.add("default");
    paramContext.add("scale");
    localObject1 = findViewById(a.f.option_text);
    if (localObject1 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(251956);
      throw paramContext;
    }
    localObject1 = (TextView)localObject1;
    Object localObject2 = j.aglL;
    this.index = j.jIV();
    ((TextView)localObject1).setText((CharSequence)paramContext.get(this.index));
    localObject2 = findViewById(a.f.option_picker);
    if (localObject2 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.Button");
      AppMethodBeat.o(251956);
      throw paramContext;
    }
    ((Button)localObject2).setOnClickListener(new i..ExternalSyntheticLambda1(this, paramContext, (TextView)localObject1));
    AppMethodBeat.o(251956);
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(251990);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    try
    {
      paramView = j.aglL;
      j.aFv((int)Float.parseFloat(parami.jIL().getText().toString()));
      paramView = j.aglL;
      j.aFw((int)Float.parseFloat(parami.jIM().getText().toString()));
      paramView = j.aglL;
      j.aFu((int)Float.parseFloat(parami.jIO().getText().toString()));
      paramView = j.aglL;
      j.aFt((int)Float.parseFloat(parami.jIN().getText().toString()));
      paramView = j.aglL;
      j.ek(Float.parseFloat(parami.jIP().getText().toString()));
      label163:
      parami.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251990);
      return;
    }
    finally
    {
      break label163;
    }
  }
  
  private static final void a(final i parami, ArrayList paramArrayList, final TextView paramTextView, View paramView)
  {
    AppMethodBeat.i(251994);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramArrayList);
    localb.cH(paramTextView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    s.u(paramArrayList, "$optionFirstList");
    s.u(paramTextView, "$optionText");
    paramArrayList = new com.tencent.mm.ui.widget.picker.b(parami.getContext(), paramArrayList);
    paramArrayList.aFq(parami.index);
    paramArrayList.agkc = ((b.b)new a(paramArrayList, paramTextView, parami));
    paramArrayList.show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251994);
  }
  
  private EditText jIL()
  {
    AppMethodBeat.i(251962);
    Object localObject = this.aglD.getValue();
    s.s(localObject, "<get-edtMinDampingFactor>(...)");
    localObject = (EditText)localObject;
    AppMethodBeat.o(251962);
    return localObject;
  }
  
  private EditText jIM()
  {
    AppMethodBeat.i(251968);
    Object localObject = this.aglE.getValue();
    s.s(localObject, "<get-edtMaxDampingFactor>(...)");
    localObject = (EditText)localObject;
    AppMethodBeat.o(251968);
    return localObject;
  }
  
  private EditText jIN()
  {
    AppMethodBeat.i(251973);
    Object localObject = this.aglF.getValue();
    s.s(localObject, "<get-edtMaxSpringDuration>(...)");
    localObject = (EditText)localObject;
    AppMethodBeat.o(251973);
    return localObject;
  }
  
  private EditText jIO()
  {
    AppMethodBeat.i(251978);
    Object localObject = this.aglG.getValue();
    s.s(localObject, "<get-edtMinSpringDuration>(...)");
    localObject = (EditText)localObject;
    AppMethodBeat.o(251978);
    return localObject;
  }
  
  private EditText jIP()
  {
    AppMethodBeat.i(251984);
    Object localObject = this.aglH.getValue();
    s.s(localObject, "<get-edtDecelerateRatio>(...)");
    localObject = (EditText)localObject;
    AppMethodBeat.o(251984);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog$2$1", "Lcom/tencent/mm/ui/widget/picker/MMOptionPicker$OnResultListener;", "", "onResult", "", "hasSetResult", "", "result", "secondResult", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.b<Object>
  {
    a(com.tencent.mm.ui.widget.picker.b paramb, TextView paramTextView, i parami) {}
    
    public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(251929);
      this.aglI.hide();
      if (paramBoolean)
      {
        paramObject2 = paramTextView;
        if (paramObject1 == null)
        {
          paramObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(251929);
          throw paramObject1;
        }
        paramObject2.setText((CharSequence)paramObject1);
      }
      paramObject1 = j.aglL;
      j.aFx(this.aglI.jIz());
      parami.index = this.aglI.jIz();
      AppMethodBeat.o(251929);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Button>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<EditText>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<EditText>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<EditText>
  {
    e(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<EditText>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<EditText>
  {
    g(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.i
 * JD-Core Version:    0.7.0.1
 */