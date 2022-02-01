package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.i.b;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.pulldown.c;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@com.tencent.mm.ui.base.a(35)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusTransparentActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "reqCallback", "Landroid/os/ResultReceiver;", "getReqCallback", "()Landroid/os/ResultReceiver;", "reqCallback$delegate", "Lkotlin/Lazy;", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "getSetStatusParam", "()Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setStatusParam$delegate", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusTransparentActivity
  extends MMActivity
{
  public static final TextStatusTransparentActivity.a TAv;
  private final j TAw;
  private final j TAx;
  
  static
  {
    AppMethodBeat.i(291786);
    TAv = new TextStatusTransparentActivity.a((byte)0);
    AppMethodBeat.o(291786);
  }
  
  public TextStatusTransparentActivity()
  {
    AppMethodBeat.i(291768);
    this.TAw = k.cm((kotlin.g.a.a)new b(this));
    this.TAx = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(291768);
  }
  
  private static final void a(TextStatusTransparentActivity paramTextStatusTransparentActivity, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(291781);
    s.u(paramTextStatusTransparentActivity, "this$0");
    paramTextStatusTransparentActivity.finish();
    AppMethodBeat.o(291781);
  }
  
  private static final void a(TextStatusTransparentActivity paramTextStatusTransparentActivity, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(291776);
    s.u(paramTextStatusTransparentActivity, "this$0");
    paramTextStatusTransparentActivity.finish();
    AppMethodBeat.o(291776);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(291819);
    super.finish();
    Object localObject = (ResultReceiver)this.TAw.getValue();
    if (localObject != null) {
      ((ResultReceiver)localObject).send(0, null);
    }
    localObject = b.Trt;
    localObject = this.TAx.getValue();
    s.s(localObject, "<get-setStatusParam>(...)");
    b.a((w)localObject, 7L);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(291819);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291810);
    h.w((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    setMMTitle("");
    hideActionbarLine();
    hideActionBarOperationArea();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = new g.a((Context)this);
    paramBundle.bDE(getString(a.h.Tgf)).NF(true);
    g.a locala = paramBundle.c(new TextStatusTransparentActivity..ExternalSyntheticLambda1(this)).d(new TextStatusTransparentActivity..ExternalSyntheticLambda0(this));
    locala.Xdm = true;
    locala.show();
    paramBundle = paramBundle.pRv;
    paramBundle.cX(-2, false);
    paramBundle.show();
    AppMethodBeat.o(291810);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/os/ResultReceiver;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ResultReceiver>
  {
    b(TextStatusTransparentActivity paramTextStatusTransparentActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<w>
  {
    c(TextStatusTransparentActivity paramTextStatusTransparentActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusTransparentActivity
 * JD-Core Version:    0.7.0.1
 */