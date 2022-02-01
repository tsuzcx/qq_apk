package com.tencent.mm.plugin.textstatus.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.textstatus.a.b;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.plugin.textstatus.third.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.glocom.b.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@com.tencent.mm.ui.base.a(32)
@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPreviewFinderActivity;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "btnOk", "Landroid/widget/Button;", "getBtnOk", "()Landroid/widget/Button;", "btnOk$delegate", "Lkotlin/Lazy;", "ivAuth", "Landroid/widget/ImageView;", "getIvAuth", "()Landroid/widget/ImageView;", "ivAuth$delegate", "ivAuthor", "getIvAuthor", "ivAuthor$delegate", "layoutFinderPreview", "Landroid/widget/FrameLayout;", "getLayoutFinderPreview", "()Landroid/widget/FrameLayout;", "layoutFinderPreview$delegate", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "tvAuthorName", "Landroid/widget/TextView;", "getTvAuthorName", "()Landroid/widget/TextView;", "tvAuthorName$delegate", "closeThirdBack", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "openThirdBack", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusPreviewFinderActivity
  extends MMSecDataActivity
{
  public static final TextStatusPreviewFinderActivity.a TAh;
  private final j TAi;
  private final j TAj;
  private final j TAk;
  private final j TAl;
  private final j TAm;
  private com.tencent.mm.ui.widget.b Tvz;
  
  static
  {
    AppMethodBeat.i(291625);
    TAh = new TextStatusPreviewFinderActivity.a((byte)0);
    AppMethodBeat.o(291625);
  }
  
  public TextStatusPreviewFinderActivity()
  {
    AppMethodBeat.i(291603);
    this.TAi = k.cm((kotlin.g.a.a)new e(this));
    this.TAj = k.cm((kotlin.g.a.a)new d(this));
    this.TAk = k.cm((kotlin.g.a.a)new f(this));
    this.TAl = k.cm((kotlin.g.a.a)new b(this));
    this.TAm = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(291603);
  }
  
  private static final void a(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity, View paramView)
  {
    AppMethodBeat.i(291619);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusPreviewFinderActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusPreviewFinderActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusPreviewFinderActivity, "this$0");
    paramTextStatusPreviewFinderActivity.setResult(-1);
    paramTextStatusPreviewFinderActivity.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusPreviewFinderActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291619);
  }
  
  private static final boolean a(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291612);
    s.u(paramTextStatusPreviewFinderActivity, "this$0");
    paramTextStatusPreviewFinderActivity.finish();
    AppMethodBeat.o(291612);
    return false;
  }
  
  private final void hJF()
  {
    AppMethodBeat.i(291609);
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if ((localb != null) && (!localb.hU))
    {
      localb.etL();
      localb.etO();
    }
    AppMethodBeat.o(291609);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.f.TfD;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(291656);
    com.tencent.mm.pluginsdk.h.w((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    setNavigationbarColor(getResources().getColor(a.b.transparent));
    setMMTitle("");
    hideActionbarLine();
    setBackBtn(new TextStatusPreviewFinderActivity..ExternalSyntheticLambda0(this));
    paramBundle = getIntent().getByteArrayExtra("SELECT_OBJECT");
    if (paramBundle == null)
    {
      Log.e("MicroMsg.TextStatus.TextStatusPreviewFinderActivity", "finderObj bytes == null");
      finish();
      AppMethodBeat.o(291656);
      return;
    }
    Object localObject3 = new FinderObject();
    ((FinderObject)localObject3).parseFrom(paramBundle);
    paramBundle = ((FinderObject)localObject3).contact;
    Object localObject1;
    if (paramBundle == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label435;
      }
      paramBundle = null;
      label149:
      Object localObject4 = p.ExI;
      localObject4 = p.eCp();
      paramBundle = new com.tencent.mm.plugin.finder.loader.b(paramBundle);
      ImageView localImageView = (ImageView)this.TAj.getValue();
      p localp = p.ExI;
      ((com.tencent.mm.loader.d)localObject4).a(paramBundle, localImageView, p.a(p.a.ExM));
      localObject4 = (TextView)this.TAk.getValue();
      if (localObject1 != null) {
        break label443;
      }
      paramBundle = (CharSequence)"";
      label226:
      ((TextView)localObject4).setText(paramBundle);
      paramBundle = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(paramBundle, "service(IFinderCommonService::class.java)");
      localObject4 = (com.tencent.mm.plugin.h)paramBundle;
      localImageView = (ImageView)this.TAm.getValue();
      paramBundle = ((FinderObject)localObject3).contact;
      if (paramBundle != null) {
        break label470;
      }
      paramBundle = null;
      label278:
      if (localObject1 != null) {
        break label478;
      }
      localObject1 = null;
      label284:
      h.a.a((com.tencent.mm.plugin.h)localObject4, localImageView, paramBundle, 0, (pu)localObject1, 4);
      ((Button)this.TAl.getValue()).setOnClickListener(new TextStatusPreviewFinderActivity..ExternalSyntheticLambda1(this));
      paramBundle = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).b((FinderObject)localObject3);
      localObject1 = new l();
      ((l)localObject1).nDl = 0;
      ((l)localObject1).ToO = 4;
      ((l)localObject1).ToQ = cn.getSyncServerTimeSecond();
      localObject3 = i.TuX;
      localObject3 = i.bec(paramBundle.jumpType);
      if (localObject3 != null) {
        break label487;
      }
    }
    label435:
    label443:
    label470:
    label478:
    label487:
    for (paramBundle = localObject2;; paramBundle = ((o)localObject3).a("finder@inner", (FrameLayout)this.TAi.getValue(), paramBundle, (l)localObject1))
    {
      this.Tvz = paramBundle;
      paramBundle = getContext();
      if ((paramBundle instanceof MMFragmentActivity))
      {
        localObject1 = this.Tvz;
        if (localObject1 != null) {
          b.a.a((com.tencent.mm.ui.component.glocom.b)localObject1, (MMFragmentActivity)paramBundle);
        }
      }
      hJF();
      AppMethodBeat.o(291656);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.c.a(paramBundle, null, false);
      break;
      paramBundle = ((m)localObject1).amx();
      break label149;
      paramBundle = ((m)localObject1).getNickname();
      if (paramBundle == null)
      {
        paramBundle = (CharSequence)"";
        break label226;
      }
      paramBundle = (CharSequence)paramBundle;
      break label226;
      paramBundle = paramBundle.authInfo;
      break label278;
      localObject1 = com.tencent.mm.plugin.finder.api.c.a((m)localObject1, false);
      break label284;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291667);
    super.onPause();
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if ((localb != null) && (localb.hU))
    {
      localb.etM();
      localb.onPostClose();
    }
    AppMethodBeat.o(291667);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291663);
    super.onResume();
    hJF();
    AppMethodBeat.o(291663);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Button>
  {
    b(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    c(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    d(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    e(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusPreviewFinderActivity
 * JD-Core Version:    0.7.0.1
 */