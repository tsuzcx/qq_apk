package com.tencent.mm.plugin.textstatus.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.pulldown.c;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@c(0)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPreviewFinderActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "btnOk", "Landroid/widget/Button;", "getBtnOk", "()Landroid/widget/Button;", "btnOk$delegate", "Lkotlin/Lazy;", "ivAuth", "Landroid/widget/ImageView;", "getIvAuth", "()Landroid/widget/ImageView;", "ivAuth$delegate", "ivAuthor", "getIvAuthor", "ivAuthor$delegate", "layoutFinderPreview", "Landroid/widget/FrameLayout;", "getLayoutFinderPreview", "()Landroid/widget/FrameLayout;", "layoutFinderPreview$delegate", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "tvAuthorName", "Landroid/widget/TextView;", "getTvAuthorName", "()Landroid/widget/TextView;", "tvAuthorName$delegate", "closeThirdBack", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "openThirdBack", "Companion", "plugin-textstatus_release"})
public final class TextStatusPreviewFinderActivity
  extends MMSecDataActivity
{
  public static final TextStatusPreviewFinderActivity.a MNP;
  private com.tencent.mm.ui.widget.b MJn;
  private final f MNK;
  private final f MNL;
  private final f MNM;
  private final f MNN;
  private final f MNO;
  
  static
  {
    AppMethodBeat.i(232130);
    MNP = new TextStatusPreviewFinderActivity.a((byte)0);
    AppMethodBeat.o(232130);
  }
  
  public TextStatusPreviewFinderActivity()
  {
    AppMethodBeat.i(232128);
    this.MNK = g.ar((kotlin.g.a.a)new e(this));
    this.MNL = g.ar((kotlin.g.a.a)new d(this));
    this.MNM = g.ar((kotlin.g.a.a)new h(this));
    this.MNN = g.ar((kotlin.g.a.a)new b(this));
    this.MNO = g.ar((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(232128);
  }
  
  private final void gnj()
  {
    AppMethodBeat.i(232127);
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null)
    {
      if (!localb.gZ)
      {
        localb.dDB();
        localb.dDE();
      }
      AppMethodBeat.o(232127);
      return;
    }
    AppMethodBeat.o(232127);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxZ;
  }
  
  @SuppressLint({"ResourceType"})
  public final void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.ui.widget.b localb = null;
    AppMethodBeat.i(232120);
    h.r((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1792);
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    setNavigationbarColor(getResources().getColor(b.b.transparent));
    setMMTitle("");
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
    paramBundle = getIntent().getByteArrayExtra("SELECT_OBJECT");
    if (paramBundle == null)
    {
      Log.e("MicroMsg.TextStatus.TextStatusPreviewFinderActivity", "finderObj bytes == null");
      finish();
      AppMethodBeat.o(232120);
      return;
    }
    Object localObject1 = new FinderObject();
    ((FinderObject)localObject1).parseFrom(paramBundle);
    paramBundle = ((FinderObject)localObject1).contact;
    Object localObject2;
    Object localObject3;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.headUrl;
      localObject2 = t.ztT;
      localObject2 = t.dJh();
      paramBundle = new e(paramBundle);
      localObject3 = (ImageView)this.MNL.getValue();
      t localt = t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(paramBundle, (ImageView)localObject3, t.a(t.a.ztX));
      localObject2 = (TextView)this.MNM.getValue();
      paramBundle = ((FinderObject)localObject1).nickname;
      if (paramBundle == null) {
        break label441;
      }
      paramBundle = (CharSequence)paramBundle;
      label238:
      ((TextView)localObject2).setText(paramBundle);
      paramBundle = aj.AGc;
      localObject2 = (ImageView)this.MNO.getValue();
      paramBundle = ((FinderObject)localObject1).contact;
      if (paramBundle == null) {
        break label450;
      }
    }
    label441:
    label450:
    for (paramBundle = paramBundle.authInfo;; paramBundle = null)
    {
      aj.a((ImageView)localObject2, paramBundle);
      ((Button)this.MNN.getValue()).setOnClickListener((View.OnClickListener)new g(this));
      paramBundle = ac.AEJ;
      localObject1 = ac.a.v((FinderObject)localObject1);
      localObject2 = new com.tencent.mm.plugin.textstatus.proto.d();
      ((com.tencent.mm.plugin.textstatus.proto.d)localObject2).kYn = 0;
      ((com.tencent.mm.plugin.textstatus.proto.d)localObject2).MEO = 4;
      ((com.tencent.mm.plugin.textstatus.proto.d)localObject2).MEQ = cm.bfF();
      paramBundle = com.tencent.mm.plugin.textstatus.j.d.MIW;
      localObject3 = com.tencent.mm.plugin.textstatus.j.d.beD(((TextStatusJumpInfo)localObject1).jumpType);
      paramBundle = localb;
      if (localObject3 != null) {
        paramBundle = ((m)localObject3).a("finder@inner", (FrameLayout)this.MNK.getValue(), (TextStatusJumpInfo)localObject1, (com.tencent.mm.plugin.textstatus.proto.d)localObject2);
      }
      this.MJn = paramBundle;
      paramBundle = getContext();
      if ((paramBundle instanceof MMFragmentActivity))
      {
        localb = this.MJn;
        if (localb != null) {
          localb.a((MMFragmentActivity)paramBundle);
        }
      }
      gnj();
      AppMethodBeat.o(232120);
      return;
      paramBundle = null;
      break;
      paramBundle = (CharSequence)"";
      break label238;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(232123);
    super.onPause();
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null)
    {
      if (localb.gZ)
      {
        localb.dDC();
        localb.onPostClose();
      }
      AppMethodBeat.o(232123);
      return;
    }
    AppMethodBeat.o(232123);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(232122);
    super.onResume();
    gnj();
    AppMethodBeat.o(232122);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Button>
  {
    b(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    c(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    d(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<FrameLayout>
  {
    e(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(235920);
      this.MNQ.finish();
      AppMethodBeat.o(235920);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232462);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusPreviewFinderActivity$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.MNQ.setResult(-1);
      this.MNQ.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusPreviewFinderActivity$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232462);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<TextView>
  {
    h(TextStatusPreviewFinderActivity paramTextStatusPreviewFinderActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusPreviewFinderActivity
 * JD-Core Version:    0.7.0.1
 */