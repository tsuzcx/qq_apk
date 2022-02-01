package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.c.o.40;
import com.tencent.mm.plugin.multitalk.e.g;
import com.tencent.mm.plugin.multitalk.model.ab;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.af;
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.model.p.5;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.bf;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic;", "", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "(Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;)V", "blackBoardProjector", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector;", "fileProjector", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector;", "isOnline", "", "()Z", "setOnline", "(Z)V", "mCurrentAngle", "", "getMCurrentAngle", "()I", "setMCurrentAngle", "(I)V", "value", "Landroid/os/Bundle;", "mParams", "setMParams", "(Landroid/os/Bundle;)V", "getMainUI", "()Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setMainUI", "applyBottomOrLeftMargin", "", "checkOrientationChange", "context", "Landroid/content/Context;", "doFav", "path", "", "doSendTOFriend", "imgPath", "exitProjectScreen", "getCurrentFile", "initView", "type", "inputScreenProjectInfo", "params", "pageIndex", "isShown", "onBack", "onResume", "onScreenOnline", "onTimeSecondCallback", "refreshView", "stopScreenProjectSend", "isMini", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final a Lvg;
  public MultiTalkMainUI Luv;
  public f Lvh;
  public com.tencent.mm.plugin.multitalk.ui.widget.projector.d Lvi;
  public int Lvj;
  private Bundle ejT;
  private boolean isOnline;
  
  static
  {
    AppMethodBeat.i(285425);
    Lvg = new a((byte)0);
    AppMethodBeat.o(285425);
  }
  
  public k(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(285412);
    this.Luv = paramMultiTalkMainUI;
    this.Lvj = -1;
    AppMethodBeat.o(285412);
  }
  
  private final void aH(Bundle paramBundle)
  {
    AppMethodBeat.i(285416);
    this.ejT = paramBundle;
    ac.ggS().Loh = paramBundle;
    AppMethodBeat.o(285416);
  }
  
  private final void ghv()
  {
    AppMethodBeat.i(285423);
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.Luv.cXB() != null) && (this.Luv.cXB().findViewById(a.e.rootview) != null))
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.Lvj = a.iY((Context)this.Luv);
      if ((this.Lvj != 0) && (this.Lvj != 180)) {
        break label123;
      }
      a.d((Activity)this.Luv, true);
      localLayoutParams.bottomMargin = a.iZ((Context)this.Luv);
    }
    for (;;)
    {
      this.Luv.cXB().findViewById(a.e.rootview).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(285423);
      return;
      label123:
      if (this.Lvj == 270)
      {
        a.d((Activity)this.Luv, false);
        localLayoutParams.leftMargin = a.iZ((Context)this.Luv);
      }
      else if (this.Lvj == 90)
      {
        a.d((Activity)this.Luv, false);
        localLayoutParams.rightMargin = a.iZ((Context)this.Luv);
      }
    }
  }
  
  public final void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(285442);
    s.u(paramBundle, "params");
    aH(paramBundle);
    this.isOnline = true;
    f localf = this.Lvh;
    if (localf != null) {
      localf.aI(paramBundle);
    }
    AppMethodBeat.o(285442);
  }
  
  public final void gfc()
  {
    AppMethodBeat.i(285446);
    this.isOnline = false;
    Object localObject = this.Luv.cXB();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.Lvh);
    }
    localObject = this.Luv.cXB();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.Lvi);
    }
    localObject = this.Lvh;
    if (localObject != null) {
      ((f)localObject).gie();
    }
    localObject = this.Lvi;
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject).gie();
    }
    this.Lvh = null;
    this.Lvi = null;
    ac.ggS().JFE = false;
    aH(null);
    localObject = g.LAS;
    g.gji();
    AppMethodBeat.o(285446);
  }
  
  public final void ghu()
  {
    AppMethodBeat.i(285428);
    ViewGroup localViewGroup = this.Luv.cXB();
    if (localViewGroup != null)
    {
      Object localObject = localViewGroup.getContext();
      s.s(localObject, "it.context");
      this.Lvh = new f((Context)localObject);
      localObject = this.Lvh;
      if (localObject != null) {
        ((f)localObject).setVisibility(0);
      }
      localViewGroup.addView((View)this.Lvh);
      ghv();
    }
    AppMethodBeat.o(285428);
  }
  
  public final boolean isShown()
  {
    AppMethodBeat.i(285439);
    if (this.Lvh != null)
    {
      localObject = this.Lvh;
      if (localObject == null)
      {
        AppMethodBeat.o(285439);
        return false;
      }
      bool = ((f)localObject).cvt();
      AppMethodBeat.o(285439);
      return bool;
    }
    Object localObject = this.Lvi;
    if (localObject == null)
    {
      AppMethodBeat.o(285439);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject).isShown();
    AppMethodBeat.o(285439);
    return bool;
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(285434);
    if (this.Luv.cXB() != null)
    {
      Object localObject = this.Lvh;
      if (localObject != null) {
        ((f)localObject).refreshView();
      }
      ghv();
      ac.ggS().ggd().onOrientationChange(a.iY((Context)this.Luv));
      if ((a.iY((Context)this.Luv) == 90) || (a.iY((Context)this.Luv) == 270))
      {
        if (this.Lvh != null)
        {
          localObject = com.tencent.mm.plugin.multitalk.e.d.LAq;
          com.tencent.mm.plugin.multitalk.e.d.ace(3);
          ac.ggS();
          com.tencent.mm.plugin.multitalk.model.o.gfF();
        }
        if (this.Lvi != null)
        {
          ac.ggS();
          com.tencent.mm.plugin.multitalk.model.o.gfF();
        }
      }
    }
    AppMethodBeat.o(285434);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic$Companion;", "", "()V", "SCREEN_PROJECT_TYPE_BLACK_BOARD", "", "SCREEN_PROJECT_TYPE_FILE", "TAG", "", "checkOrientation", "context", "Landroid/content/Context;", "doExport", "", "bitmap", "Landroid/graphics/Bitmap;", "doFavExport", "doScreenSharingSecurityCheck", "fileMd5", "fileId", "doSendToFriendExport", "fillEventInfo", "", "favEvent", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "sourceType", "imagePath", "getNavigationBarMargin", "showSystemStatusBar", "activity", "Landroid/app/Activity;", "show", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void aND(String paramString)
    {
      AppMethodBeat.i(285411);
      s.u(paramString, "fileMd5");
      boolean bool = ac.ggS().gfV();
      Log.i("MicroMsg.MultiTalkScreenProjectUILogic", "getMultiTalkSDKMode sdk mode:%s", new Object[] { Boolean.valueOf(bool) });
      Object localObject;
      if (bool)
      {
        localObject = com.tencent.mm.plugin.multitalk.c.o.Ljn;
        ((com.tencent.mm.plugin.multitalk.c.o)localObject).au(new o.40((com.tencent.mm.plugin.multitalk.c.o)localObject, paramString));
      }
      for (;;)
      {
        localObject = ac.ggS();
        if (((p)localObject).LoT == null) {
          ((p)localObject).LoT = new x();
        }
        ((p)localObject).LoS = new ab();
        ((p)localObject).LoS.LqE = System.currentTimeMillis();
        ((p)localObject).LoS.md5 = paramString;
        h.ahAA.b(new p.5((p)localObject), 3000L, "delayChecking");
        ((p)localObject).LoT.t(((p)localObject).LoS);
        AppMethodBeat.o(285411);
        return;
        ac.ggR().LnJ.bFo(paramString);
      }
    }
    
    public static void b(Context paramContext, Bitmap paramBitmap)
    {
      AppMethodBeat.i(285391);
      s.u(paramBitmap, "bitmap");
      if (paramContext == null)
      {
        AppMethodBeat.o(285391);
        return;
      }
      paramBitmap = new k.a..ExternalSyntheticLambda5(paramBitmap, paramContext);
      k.a..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new k.a..ExternalSyntheticLambda0(paramContext);
      if ((paramContext instanceof Activity))
      {
        ExportFileUtil.a(paramContext, paramBitmap, localExternalSyntheticLambda0);
        AppMethodBeat.o(285391);
        return;
      }
      localExternalSyntheticLambda0.run();
      AppMethodBeat.o(285391);
    }
    
    private static final void b(Bitmap paramBitmap, Context paramContext)
    {
      AppMethodBeat.i(285417);
      s.u(paramBitmap, "$bitmap");
      String str = AndroidMediaUtil.getExportImagePath("jpg");
      boolean bool = BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
      if (!bool)
      {
        Toast.makeText(paramContext, (CharSequence)paramContext.getString(a.h.save_image_err), 1).show();
        AppMethodBeat.o(285417);
        return;
      }
      if (bool)
      {
        AndroidMediaUtil.refreshMediaScannerAsync(str, paramContext);
        Toast.makeText(paramContext, (CharSequence)paramContext.getString(a.h.save_screen_img_succ, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
      }
      AppMethodBeat.o(285417);
    }
    
    public static void c(Context paramContext, Bitmap paramBitmap)
    {
      AppMethodBeat.i(285397);
      s.u(paramBitmap, "bitmap");
      if (paramContext == null)
      {
        AppMethodBeat.o(285397);
        return;
      }
      paramBitmap = new k.a..ExternalSyntheticLambda3(paramBitmap, paramContext);
      k.a..ExternalSyntheticLambda2 localExternalSyntheticLambda2 = new k.a..ExternalSyntheticLambda2(paramContext);
      if ((paramContext instanceof Activity))
      {
        ExportFileUtil.a(paramContext, paramBitmap, localExternalSyntheticLambda2);
        AppMethodBeat.o(285397);
        return;
      }
      localExternalSyntheticLambda2.run();
      AppMethodBeat.o(285397);
    }
    
    private static final void c(Bitmap paramBitmap, Context paramContext)
    {
      AppMethodBeat.i(285424);
      s.u(paramBitmap, "$bitmap");
      String str = AndroidMediaUtil.getExportImagePath("jpg");
      boolean bool = BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
      if (!bool)
      {
        Toast.makeText(paramContext, (CharSequence)paramContext.getString(a.h.save_image_err), 1).show();
        AppMethodBeat.o(285424);
        return;
      }
      if (bool)
      {
        AndroidMediaUtil.refreshMediaScannerAsync(str, paramContext);
        paramBitmap = ac.ggS();
        if (paramBitmap.Lnt != null) {
          paramBitmap.Lnt.aMZ(str);
        }
      }
      AppMethodBeat.o(285424);
    }
    
    public static void d(Activity paramActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(285382);
      s.u(paramActivity, "activity");
      if (!paramBoolean)
      {
        paramActivity.getWindow().setFlags(1024, 1024);
        paramActivity.getWindow().clearFlags(134217728);
        AppMethodBeat.o(285382);
        return;
      }
      paramActivity.getWindow().clearFlags(1024);
      paramActivity.getWindow().addFlags(134217728);
      AppMethodBeat.o(285382);
    }
    
    public static void d(Context paramContext, Bitmap paramBitmap)
    {
      AppMethodBeat.i(285403);
      s.u(paramBitmap, "bitmap");
      if (paramContext == null)
      {
        AppMethodBeat.o(285403);
        return;
      }
      paramBitmap = new k.a..ExternalSyntheticLambda4(paramBitmap, paramContext);
      k.a..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = new k.a..ExternalSyntheticLambda1(paramContext);
      if ((paramContext instanceof Activity))
      {
        ExportFileUtil.a(paramContext, paramBitmap, localExternalSyntheticLambda1);
        AppMethodBeat.o(285403);
        return;
      }
      localExternalSyntheticLambda1.run();
      AppMethodBeat.o(285403);
    }
    
    private static final void d(Bitmap paramBitmap, Context paramContext)
    {
      AppMethodBeat.i(285433);
      s.u(paramBitmap, "$bitmap");
      String str = AndroidMediaUtil.getExportImagePath("jpg");
      boolean bool = BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
      if (!bool)
      {
        Toast.makeText(paramContext, (CharSequence)paramContext.getString(a.h.save_image_err), 1).show();
        AppMethodBeat.o(285433);
        return;
      }
      if (bool)
      {
        AndroidMediaUtil.refreshMediaScannerAsync(str, paramContext);
        paramBitmap = ac.ggS();
        if (paramBitmap.Lnt != null) {
          paramBitmap.Lnt.aNa(str);
        }
      }
      AppMethodBeat.o(285433);
    }
    
    public static int iY(Context paramContext)
    {
      AppMethodBeat.i(285368);
      s.u(paramContext, "context");
      paramContext = paramContext.getSystemService("window");
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(285368);
        throw paramContext;
      }
      switch (((WindowManager)paramContext).getDefaultDisplay().getRotation())
      {
      default: 
        AppMethodBeat.o(285368);
        return 0;
      case 0: 
        AppMethodBeat.o(285368);
        return 0;
      case 1: 
        AppMethodBeat.o(285368);
        return 90;
      case 2: 
        AppMethodBeat.o(285368);
        return 180;
      }
      AppMethodBeat.o(285368);
      return 270;
    }
    
    public static int iZ(Context paramContext)
    {
      AppMethodBeat.i(285377);
      s.u(paramContext, "context");
      int i = 0;
      int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = Resources.getSystem().getDimensionPixelSize(j);
      }
      int k = bf.bi(paramContext);
      j = i;
      if (k != 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
      AppMethodBeat.o(285377);
      return j;
    }
    
    private static final void ja(Context paramContext)
    {
      AppMethodBeat.i(285421);
      Toast.makeText(paramContext, (CharSequence)paramContext.getString(a.h.save_image_err), 1).show();
      AppMethodBeat.o(285421);
    }
    
    private static final void jb(Context paramContext)
    {
      AppMethodBeat.i(285427);
      Toast.makeText(paramContext, (CharSequence)paramContext.getString(a.h.save_image_err), 1).show();
      AppMethodBeat.o(285427);
    }
    
    private static final void jc(Context paramContext)
    {
      AppMethodBeat.i(285438);
      Toast.makeText(paramContext, (CharSequence)paramContext.getString(a.h.save_image_err), 1).show();
      AppMethodBeat.o(285438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k
 * JD-Core Version:    0.7.0.1
 */