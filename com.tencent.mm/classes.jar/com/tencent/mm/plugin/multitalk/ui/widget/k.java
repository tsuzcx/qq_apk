package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.af;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.d;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic;", "", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "(Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;)V", "blackBoardProjector", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector;", "fileProjector", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector;", "isOnline", "", "()Z", "setOnline", "(Z)V", "mCurrentAngle", "", "getMCurrentAngle", "()I", "setMCurrentAngle", "(I)V", "value", "Landroid/os/Bundle;", "mParams", "setMParams", "(Landroid/os/Bundle;)V", "getMainUI", "()Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setMainUI", "applyBottomOrLeftMargin", "", "checkOrientationChange", "context", "Landroid/content/Context;", "doFav", "path", "", "doSendTOFriend", "imgPath", "exitProjectScreen", "initView", "type", "inputScreenProjectInfo", "params", "pageIndex", "isShown", "onBack", "onResume", "onScreenOnline", "onTimeSecondCallback", "onVideoGroupMemberChange", "refreshView", "stopScreenProjectSend", "isMini", "Companion", "plugin-multitalk_release"})
public final class k
{
  public static final k.a zTz;
  private boolean isOnline;
  private Bundle mParams;
  public MultiTalkMainUI zSH;
  public f zTw;
  public d zTx;
  public int zTy;
  
  static
  {
    AppMethodBeat.i(239823);
    zTz = new k.a((byte)0);
    AppMethodBeat.o(239823);
  }
  
  public k(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(239822);
    this.zSH = paramMultiTalkMainUI;
    this.zTy = -1;
    AppMethodBeat.o(239822);
  }
  
  private final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(239815);
    this.mParams = paramBundle;
    ac.eom().zMB = paramBundle;
    AppMethodBeat.o(239815);
  }
  
  private final void eoI()
  {
    AppMethodBeat.i(239817);
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.zSH.chG() != null) && (this.zSH.chG().findViewById(2131307175) != null))
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.zTy = k.a.gE((Context)this.zSH);
      if ((this.zTy != 0) && (this.zTy != 180)) {
        break label129;
      }
      k.a.c((Activity)this.zSH, true);
      localLayoutParams.bottomMargin = k.a.gF((Context)this.zSH);
    }
    for (;;)
    {
      View localView = this.zSH.chG().findViewById(2131307175);
      kotlin.g.b.p.g(localView, "mainUI.rootView.findViewById<View>(R.id.rootview)");
      localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(239817);
      return;
      label129:
      if (this.zTy == 270)
      {
        k.a.c((Activity)this.zSH, false);
        localLayoutParams.leftMargin = k.a.gF((Context)this.zSH);
      }
      else if (this.zTy == 90)
      {
        k.a.c((Activity)this.zSH, false);
        localLayoutParams.rightMargin = k.a.gF((Context)this.zSH);
      }
    }
  }
  
  public final void Rs(int paramInt)
  {
    AppMethodBeat.i(239816);
    ViewGroup localViewGroup = this.zSH.chG();
    if (localViewGroup != null)
    {
      Object localObject;
      if (paramInt == 2)
      {
        localObject = localViewGroup.getContext();
        kotlin.g.b.p.g(localObject, "it.context");
        this.zTw = new f((Context)localObject);
        localObject = this.zTw;
        if (localObject != null) {
          ((f)localObject).setVisibility(0);
        }
        localViewGroup.addView((View)this.zTw);
      }
      for (;;)
      {
        eoI();
        AppMethodBeat.o(239816);
        return;
        localObject = localViewGroup.getContext();
        kotlin.g.b.p.g(localObject, "it.context");
        this.zTx = new d((Context)localObject);
        localObject = this.zTx;
        if (localObject != null) {
          ((d)localObject).setVisibility(0);
        }
        localViewGroup.addView((View)this.zTx);
      }
    }
    AppMethodBeat.o(239816);
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(239820);
    kotlin.g.b.p.h(paramBundle, "params");
    ap(paramBundle);
    this.isOnline = true;
    f localf = this.zTw;
    if (localf != null)
    {
      localf.aq(paramBundle);
      AppMethodBeat.o(239820);
      return;
    }
    AppMethodBeat.o(239820);
  }
  
  public final void emx()
  {
    AppMethodBeat.i(239821);
    this.isOnline = false;
    Object localObject = this.zSH.chG();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.zTw);
    }
    localObject = this.zSH.chG();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.zTx);
    }
    localObject = this.zTw;
    if (localObject != null) {
      ((f)localObject).epp();
    }
    localObject = this.zTx;
    if (localObject != null) {
      ((d)localObject).epp();
    }
    this.zTw = null;
    this.zTx = null;
    ac.eom().yon = false;
    ap(null);
    AppMethodBeat.o(239821);
  }
  
  public final boolean isShown()
  {
    AppMethodBeat.i(239819);
    boolean bool;
    if (this.zTw != null)
    {
      localObject = this.zTw;
      if (localObject != null)
      {
        bool = ((f)localObject).bJw();
        AppMethodBeat.o(239819);
        return bool;
      }
      AppMethodBeat.o(239819);
      return false;
    }
    Object localObject = this.zTx;
    if (localObject != null)
    {
      bool = ((d)localObject).isShown();
      AppMethodBeat.o(239819);
      return bool;
    }
    AppMethodBeat.o(239819);
    return false;
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(239818);
    if (this.zSH.chG() != null)
    {
      Object localObject = this.zTw;
      if (localObject != null) {
        ((f)localObject).refreshView();
      }
      eoI();
      localObject = ac.eom();
      kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      ((q)localObject).enx().onOrientationChange(k.a.gE((Context)this.zSH));
      if ((k.a.gE((Context)this.zSH) == 90) || (k.a.gE((Context)this.zSH) == 270))
      {
        if (this.zTw != null)
        {
          localObject = ac.eom();
          kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
          com.tencent.mm.plugin.multitalk.model.p.n(((q)localObject).enn().zHD, 1, 3, 1);
        }
        if (this.zTx != null)
        {
          localObject = ac.eom();
          kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
          com.tencent.mm.plugin.multitalk.model.p.n(((q)localObject).enn().zHD, 2, 3, 1);
        }
      }
    }
    AppMethodBeat.o(239818);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class a$c
    implements Runnable
  {
    public a$c(Bitmap paramBitmap, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(239808);
      String str = AndroidMediaUtil.getExportImagePath("jpg");
      boolean bool = BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, str, true);
      if (!bool)
      {
        Toast.makeText(this.$context, (CharSequence)this.$context.getString(2131764864), 1).show();
        AppMethodBeat.o(239808);
        return;
      }
      if (bool)
      {
        AndroidMediaUtil.refreshMediaScannerAsync(str, this.$context);
        ac.eom().aFS(str);
      }
      AppMethodBeat.o(239808);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class a$e
    implements Runnable
  {
    public a$e(Bitmap paramBitmap, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(239810);
      String str = AndroidMediaUtil.getExportImagePath("jpg");
      boolean bool = BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, str, true);
      if (!bool)
      {
        Toast.makeText(this.$context, (CharSequence)this.$context.getString(2131764864), 1).show();
        AppMethodBeat.o(239810);
        return;
      }
      if (bool)
      {
        AndroidMediaUtil.refreshMediaScannerAsync(str, this.$context);
        ac.eom().aFY(str);
      }
      AppMethodBeat.o(239810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k
 * JD-Core Version:    0.7.0.1
 */