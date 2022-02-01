package com.tencent.mm.search.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "dismiss", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;Lkotlin/jvm/functions/Function0;)V", "commentScrolling", "", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "galleryScale", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "needCancelTouch", "targetView", "Lcom/tencent/mm/search/ui/SimilarEmojiView;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "wrapSheet", "Companion", "plugin-emojisdk_release"})
public final class b
  extends androidx.appcompat.app.e
{
  public static final a UXg;
  private SimilarEmojiQueryModel PJV;
  private c UXe;
  private final b UXf;
  private com.tencent.mm.ui.o.b jKS;
  private kotlin.g.a.a<kotlin.x> jQd;
  private boolean kJN;
  private boolean kJO;
  private boolean kJP;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(105877);
    UXg = new a((byte)0);
    AppMethodBeat.o(105877);
  }
  
  public b(Context paramContext, SimilarEmojiQueryModel paramSimilarEmojiQueryModel, kotlin.g.a.a<kotlin.x> parama)
  {
    super(paramContext, a.k.CustomSheetStyle);
    AppMethodBeat.i(105876);
    this.mContext = paramContext;
    this.PJV = paramSimilarEmojiQueryModel;
    this.jQd = parama;
    this.UXe = new c((Context)new com.tencent.mm.ui.x(this.mContext, a.k.EmojiPanel), this);
    bb();
    paramContext = getContext();
    p.j(paramContext, "context");
    this.jKS = new com.tencent.mm.ui.o.b(paramContext);
    paramContext = this.UXe;
    paramSimilarEmojiQueryModel = this.PJV;
    p.k(paramSimilarEmojiQueryModel, "model");
    paramContext.UWN = paramSimilarEmojiQueryModel.UWN;
    if (paramSimilarEmojiQueryModel.gTo())
    {
      parama = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(parama, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
      parama = ((com.tencent.mm.plugin.emoji.b.d)parama).getEmojiMgr().aud(paramSimilarEmojiQueryModel.emojiMD5);
      a locala = paramContext.PJX;
      p.j(parama, "head");
      locala.G(parama);
    }
    for (;;)
    {
      paramContext.PJX.UXc = false;
      paramContext.PJX.htz();
      paramContext.PJX.notifyDataSetChanged();
      parama = paramContext.PJX.jLP;
      if (parama != null) {
        break;
      }
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.search.logic.SimilarEmojiPanelClickListener");
      AppMethodBeat.o(105876);
      throw paramContext;
      a.a(paramContext.PJX);
    }
    ((com.tencent.mm.search.b.b)parama).jQa = paramSimilarEmojiQueryModel;
    parama = paramContext.PJX.jLP;
    if (parama == null)
    {
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.EmojiPanelClickListener");
      AppMethodBeat.o(105876);
      throw paramContext;
    }
    ((com.tencent.mm.emoji.panel.a.e)parama).jLH = paramSimilarEmojiQueryModel.UWO;
    paramContext.UXk.b(paramSimilarEmojiQueryModel, (com.tencent.mm.an.i)new c.b(paramContext, paramSimilarEmojiQueryModel));
    this.UXf = new b(this);
    AppMethodBeat.o(105876);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(105873);
    Resources localResources = this.mContext.getResources();
    p.j(localResources, "mContext.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(105873);
      return true;
    }
    AppMethodBeat.o(105873);
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(105872);
    Log.i("MicroMsg.SimilarEmoji", "dialog dismiss");
    super.dismiss();
    this.jQd.invoke();
    AppMethodBeat.o(105872);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(105875);
    p.k(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.jKS.at(paramMotionEvent);
      int i = this.jKS.XLC;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.kJO) || (this.kJN)) {
            break label178;
          }
          bool1 = this.jKS.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.kJO) && (!bool1)) {
        break label234;
      }
      if (!this.kJP)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.j(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.kJP = true;
      }
      AppMethodBeat.o(105875);
      return true;
      this.kJP = false;
      this.kJO = false;
      break;
      label178:
      bool1 = bool2;
      if (!this.kJP)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.j(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.jKS.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.kJP = true;
        bool1 = bool2;
      }
    }
    label234:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(105875);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(105870);
    super.onCreate(paramBundle);
    setContentView((View)this.UXe);
    Log.i("MicroMsg.SimilarEmoji", "dialog onCreate " + this.PJV);
    paramBundle = this.PJV.UWO;
    if (paramBundle != null)
    {
      com.tencent.mm.search.b.a locala = com.tencent.mm.search.b.a.UWT;
      com.tencent.mm.search.b.a.a(paramBundle);
      AppMethodBeat.o(105870);
      return;
    }
    AppMethodBeat.o(105870);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(105871);
    Log.i("MicroMsg.SimilarEmoji", "dialog onStop");
    super.onStop();
    this.UXe.UXk.onDestroy();
    com.tencent.mm.search.b.a locala = com.tencent.mm.search.b.a.UWT;
    com.tencent.mm.search.b.a.destroy();
    AppMethodBeat.o(105871);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(105874);
    p.k(paramView, "view");
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      if (localObject == null) {
        p.iCn();
      }
      ((Window)localObject).setGravity(5);
      ((Window)localObject).setWindowAnimations(a.k.RightToLeftAnimation);
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = ((Window)localObject).getAttributes();
      if (!isLandscape()) {
        break label182;
      }
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      ((Window)localObject).setAttributes(localLayoutParams);
      int i = ad.bC(getContext());
      localObject = getContext();
      p.j(localObject, "context");
      super.setContentView(paramView, new ViewGroup.LayoutParams(-1, i + ((Context)localObject).getResources().getDimensionPixelOffset(a.e.Edge_7A) * 1));
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.setLayout(-1, -2);
      AppMethodBeat.o(105874);
      return;
      if (localObject == null) {
        p.iCn();
      }
      ((Window)localObject).setGravity(80);
      ((Window)localObject).setWindowAnimations(a.k.BottomToTopSlowAnimation);
      break;
      label182:
      localLayoutParams.width = -1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/ui/SimilarEmojiDialog$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void aRj()
    {
      long l1 = 0L;
      AppMethodBeat.i(228441);
      c localc = b.a(this.UXh);
      localc.setEnabled(false);
      long l2 = ((localc.getHeight() - localc.getTranslationY()) / localc.getHeight() * 300.0F);
      if (l2 < 0L) {}
      for (;;)
      {
        localc.animate().translationY(localc.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
        AppMethodBeat.o(228441);
        return;
        l1 = l2;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(b.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(226207);
        new MMHandler().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241299);
            if (this.UXj.UXi.UXh.isShowing()) {
              this.UXj.UXi.UXh.cancel();
            }
            AppMethodBeat.o(241299);
          }
        });
        AppMethodBeat.o(226207);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.d.b
 * JD-Core Version:    0.7.0.1
 */