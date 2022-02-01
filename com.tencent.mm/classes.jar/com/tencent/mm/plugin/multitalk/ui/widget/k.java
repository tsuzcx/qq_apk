package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.ag;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic;", "", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "(Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;)V", "blackBoardProjector", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector;", "fileProjector", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector;", "isOnline", "", "()Z", "setOnline", "(Z)V", "mCurrentAngle", "", "getMCurrentAngle", "()I", "setMCurrentAngle", "(I)V", "value", "Landroid/os/Bundle;", "mParams", "setMParams", "(Landroid/os/Bundle;)V", "getMainUI", "()Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setMainUI", "applyBottomOrLeftMargin", "", "checkOrientationChange", "context", "Landroid/content/Context;", "doFav", "path", "", "doSendTOFriend", "imgPath", "exitProjectScreen", "getCurrentFile", "initView", "type", "inputScreenProjectInfo", "params", "pageIndex", "isShown", "onBack", "onResume", "onScreenOnline", "onTimeSecondCallback", "refreshView", "stopScreenProjectSend", "isMini", "Companion", "plugin-multitalk_release"})
public final class k
{
  public static final a Fzb;
  public f FyY;
  public com.tencent.mm.plugin.multitalk.ui.widget.projector.d FyZ;
  public MultiTalkMainUI Fyj;
  public int Fza;
  private boolean isOnline;
  private Bundle mParams;
  
  static
  {
    AppMethodBeat.i(198687);
    Fzb = new a((byte)0);
    AppMethodBeat.o(198687);
  }
  
  public k(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(198685);
    this.Fyj = paramMultiTalkMainUI;
    this.Fza = -1;
    AppMethodBeat.o(198685);
  }
  
  private final void aj(Bundle paramBundle)
  {
    AppMethodBeat.i(198652);
    this.mParams = paramBundle;
    ad.eYc().FrU = paramBundle;
    AppMethodBeat.o(198652);
  }
  
  private final void eYA()
  {
    AppMethodBeat.i(198664);
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.Fyj.cuR() != null) && (this.Fyj.cuR().findViewById(a.e.rootview) != null))
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.Fza = a.hB((Context)this.Fyj);
      if ((this.Fza != 0) && (this.Fza != 180)) {
        break label131;
      }
      a.d((Activity)this.Fyj, true);
      localLayoutParams.bottomMargin = a.hC((Context)this.Fyj);
    }
    for (;;)
    {
      View localView = this.Fyj.cuR().findViewById(a.e.rootview);
      kotlin.g.b.p.j(localView, "mainUI.rootView.findViewById<View>(R.id.rootview)");
      localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(198664);
      return;
      label131:
      if (this.Fza == 270)
      {
        a.d((Activity)this.Fyj, false);
        localLayoutParams.leftMargin = a.hC((Context)this.Fyj);
      }
      else if (this.Fza == 90)
      {
        a.d((Activity)this.Fyj, false);
        localLayoutParams.rightMargin = a.hC((Context)this.Fyj);
      }
    }
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(198677);
    kotlin.g.b.p.k(paramBundle, "params");
    aj(paramBundle);
    this.isOnline = true;
    f localf = this.FyY;
    if (localf != null)
    {
      localf.ak(paramBundle);
      AppMethodBeat.o(198677);
      return;
    }
    AppMethodBeat.o(198677);
  }
  
  public final void eWl()
  {
    AppMethodBeat.i(198683);
    this.isOnline = false;
    Object localObject = this.Fyj.cuR();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.FyY);
    }
    localObject = this.Fyj.cuR();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.FyZ);
    }
    localObject = this.FyY;
    if (localObject != null) {
      ((f)localObject).eZf();
    }
    localObject = this.FyZ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject).eZf();
    }
    this.FyY = null;
    this.FyZ = null;
    ad.eYc().DOp = false;
    aj(null);
    AppMethodBeat.o(198683);
  }
  
  public final void eYz()
  {
    AppMethodBeat.i(198656);
    ViewGroup localViewGroup = this.Fyj.cuR();
    if (localViewGroup != null)
    {
      Object localObject = localViewGroup.getContext();
      kotlin.g.b.p.j(localObject, "it.context");
      this.FyY = new f((Context)localObject);
      localObject = this.FyY;
      if (localObject != null) {
        ((f)localObject).setVisibility(0);
      }
      localViewGroup.addView((View)this.FyY);
      eYA();
      AppMethodBeat.o(198656);
      return;
    }
    AppMethodBeat.o(198656);
  }
  
  public final boolean isShown()
  {
    AppMethodBeat.i(198674);
    boolean bool;
    if (this.FyY != null)
    {
      localObject = this.FyY;
      if (localObject != null)
      {
        bool = ((f)localObject).bVd();
        AppMethodBeat.o(198674);
        return bool;
      }
      AppMethodBeat.o(198674);
      return false;
    }
    Object localObject = this.FyZ;
    if (localObject != null)
    {
      bool = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject).isShown();
      AppMethodBeat.o(198674);
      return bool;
    }
    AppMethodBeat.o(198674);
    return false;
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(198670);
    if (this.Fyj.cuR() != null)
    {
      Object localObject = this.FyY;
      if (localObject != null) {
        ((f)localObject).refreshView();
      }
      eYA();
      localObject = ad.eYc();
      kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      ((q)localObject).eXn().onOrientationChange(a.hB((Context)this.Fyj));
      if ((a.hB((Context)this.Fyj) == 90) || (a.hB((Context)this.Fyj) == 270))
      {
        if (this.FyY != null)
        {
          localObject = ad.eYc();
          kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
          com.tencent.mm.plugin.multitalk.model.p.q(((q)localObject).eXb().FmO, 1, 3, 1);
        }
        if (this.FyZ != null)
        {
          localObject = ad.eYc();
          kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
          com.tencent.mm.plugin.multitalk.model.p.q(((q)localObject).eXb().FmO, 2, 3, 1);
        }
      }
    }
    AppMethodBeat.o(198670);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic$Companion;", "", "()V", "SCREEN_PROJECT_TYPE_BLACK_BOARD", "", "SCREEN_PROJECT_TYPE_FILE", "TAG", "", "checkOrientation", "context", "Landroid/content/Context;", "doExport", "", "bitmap", "Landroid/graphics/Bitmap;", "doFavExport", "doScreenSharingSecurityCheck", "fileMd5", "fileId", "doSendToFriendExport", "fillEventInfo", "", "favEvent", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "sourceType", "imagePath", "getNavigationBarMargin", "showSystemStatusBar", "activity", "Landroid/app/Activity;", "show", "plugin-multitalk_release"})
  public static final class a
  {
    public static void aQK(String paramString)
    {
      AppMethodBeat.i(201740);
      kotlin.g.b.p.k(paramString, "fileMd5");
      Object localObject = ad.eYc();
      kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      boolean bool = ((q)localObject).eXg();
      Log.i("MicroMsg.MultiTalkScreenProjectUILogic", "getMultiTalkSDKMode sdk mode:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        com.tencent.mm.plugin.multitalk.b.o.Fne.aPK(paramString);
      }
      for (;;)
      {
        ad.eYc().aQr(paramString);
        AppMethodBeat.o(201740);
        return;
        localObject = ad.eYb();
        kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiEngine()");
        ((com.tencent.mm.plugin.multitalk.model.o)localObject).eWv().bCL(paramString);
      }
    }
    
    public static void d(Activity paramActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(201737);
      kotlin.g.b.p.k(paramActivity, "activity");
      if (!paramBoolean)
      {
        paramActivity.getWindow().setFlags(1024, 1024);
        paramActivity.getWindow().clearFlags(134217728);
        AppMethodBeat.o(201737);
        return;
      }
      paramActivity.getWindow().clearFlags(1024);
      paramActivity.getWindow().addFlags(134217728);
      AppMethodBeat.o(201737);
    }
    
    public static int hB(Context paramContext)
    {
      AppMethodBeat.i(201732);
      kotlin.g.b.p.k(paramContext, "context");
      paramContext = paramContext.getSystemService("window");
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(201732);
        throw paramContext;
      }
      paramContext = ((WindowManager)paramContext).getDefaultDisplay();
      kotlin.g.b.p.j(paramContext, "(context.getSystemServic…owManager).defaultDisplay");
      switch (paramContext.getRotation())
      {
      default: 
        AppMethodBeat.o(201732);
        return 0;
      case 0: 
        AppMethodBeat.o(201732);
        return 0;
      case 1: 
        AppMethodBeat.o(201732);
        return 90;
      case 2: 
        AppMethodBeat.o(201732);
        return 180;
      }
      AppMethodBeat.o(201732);
      return 270;
    }
    
    public static int hC(Context paramContext)
    {
      AppMethodBeat.i(201735);
      kotlin.g.b.p.k(paramContext, "context");
      int i = 0;
      int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = Resources.getSystem().getDimensionPixelSize(j);
      }
      int k = ax.az(paramContext);
      j = i;
      if (k != 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
      AppMethodBeat.o(201735);
      return j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k
 * JD-Core Version:    0.7.0.1
 */