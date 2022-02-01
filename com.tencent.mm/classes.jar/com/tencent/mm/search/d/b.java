package com.tencent.mm.search.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.emoji.panel.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.ui.t;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "dismiss", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;Lkotlin/jvm/functions/Function0;)V", "commentScrolling", "", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "galleryScale", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "needCancelTouch", "targetView", "Lcom/tencent/mm/search/ui/SimilarEmojiView;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "wrapSheet", "Companion", "plugin-emojisdk_release"})
public final class b
  extends e
{
  public static final b.a GwK;
  private SimilarEmojiQueryModel Cgp;
  private c GwH;
  private final b GwI;
  private d.g.a.a<y> GwJ;
  private com.tencent.mm.ui.j.b fSY;
  private boolean gFW;
  private boolean gFX;
  private boolean gFY;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(105877);
    GwK = new b.a((byte)0);
    AppMethodBeat.o(105877);
  }
  
  public b(Context paramContext, SimilarEmojiQueryModel paramSimilarEmojiQueryModel, d.g.a.a<y> parama)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(105876);
    this.mContext = paramContext;
    this.Cgp = paramSimilarEmojiQueryModel;
    this.GwJ = parama;
    this.GwH = new c((Context)new t(this.mContext, 2131820870), this);
    gt();
    paramContext = getContext();
    k.g(paramContext, "context");
    this.fSY = new com.tencent.mm.ui.j.b(paramContext);
    paramContext = this.GwH;
    paramSimilarEmojiQueryModel = this.Cgp;
    k.h(paramSimilarEmojiQueryModel, "model");
    paramContext.Gwn = paramSimilarEmojiQueryModel.Gwn;
    parama = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    k.g(parama, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
    parama = ((com.tencent.mm.plugin.emoji.b.d)parama).getEmojiMgr().XL(paramSimilarEmojiQueryModel.emojiMD5);
    Object localObject = paramContext.Cgs;
    k.g(parama, "head");
    ((a)localObject).G(parama);
    paramContext.Cgs.GwE = false;
    paramContext.Cgs.eXb();
    paramContext.Cgs.notifyDataSetChanged();
    localObject = paramContext.Cgs.fTR;
    if (localObject == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.search.logic.SimilarEmojiPanelClickListener");
      AppMethodBeat.o(105876);
      throw paramContext;
    }
    ((com.tencent.mm.search.b.b)localObject).Gwu = paramSimilarEmojiQueryModel;
    localObject = paramContext.Cgs.fTR;
    if (localObject == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.EmojiPanelClickListener");
      AppMethodBeat.o(105876);
      throw paramContext;
    }
    ((com.tencent.mm.emoji.panel.a.d)localObject).fTJ = paramSimilarEmojiQueryModel.Gwo;
    paramContext.GwO.a(paramSimilarEmojiQueryModel, (com.tencent.mm.ak.g)new c.b(paramContext, parama));
    this.GwI = new b(this);
    AppMethodBeat.o(105876);
  }
  
  private final boolean aly()
  {
    AppMethodBeat.i(105873);
    Resources localResources = this.mContext.getResources();
    k.g(localResources, "mContext.resources");
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
    ac.i("MicroMsg.SimilarEmoji", "dialog dismiss");
    super.dismiss();
    this.GwJ.invoke();
    AppMethodBeat.o(105872);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(105875);
    k.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.fSY.ae(paramMotionEvent);
      int i = this.fSY.ILj;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.gFX) || (this.gFW)) {
            break label178;
          }
          bool1 = this.fSY.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.gFX) && (!bool1)) {
        break label234;
      }
      if (!this.gFY)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.gFY = true;
      }
      AppMethodBeat.o(105875);
      return true;
      this.gFY = false;
      this.gFX = false;
      break;
      label178:
      bool1 = bool2;
      if (!this.gFY)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.fSY.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.gFY = true;
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
    setContentView((View)this.GwH);
    ac.i("MicroMsg.SimilarEmoji", "dialog onCreate " + this.Cgp);
    paramBundle = this.Cgp.Gwo;
    if (paramBundle != null)
    {
      com.tencent.mm.search.b.a locala = com.tencent.mm.search.b.a.Gwt;
      com.tencent.mm.search.b.a.a(paramBundle);
      AppMethodBeat.o(105870);
      return;
    }
    AppMethodBeat.o(105870);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(105871);
    ac.i("MicroMsg.SimilarEmoji", "dialog onStop");
    super.onStop();
    this.GwH.GwO.onDestroy();
    com.tencent.mm.search.b.a locala = com.tencent.mm.search.b.a.Gwt;
    com.tencent.mm.search.b.a.destroy();
    AppMethodBeat.o(105871);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(105874);
    k.h(paramView, "view");
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (aly())
    {
      if (localObject == null) {
        k.fOy();
      }
      ((Window)localObject).setGravity(5);
      ((Window)localObject).setWindowAnimations(2131821249);
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = ((Window)localObject).getAttributes();
      if (!aly()) {
        break label182;
      }
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      ((Window)localObject).setAttributes(localLayoutParams);
      int i = aa.bi(getContext());
      localObject = getContext();
      k.g(localObject, "context");
      super.setContentView(paramView, new ViewGroup.LayoutParams(-1, i + ((Context)localObject).getResources().getDimensionPixelOffset(2131165299) * 1));
      paramView = getWindow();
      if (paramView == null) {
        k.fOy();
      }
      paramView.setLayout(-1, -2);
      AppMethodBeat.o(105874);
      return;
      if (localObject == null) {
        k.fOy();
      }
      ((Window)localObject).setGravity(80);
      ((Window)localObject).setWindowAnimations(2131820790);
      break;
      label182:
      localLayoutParams.width = -1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void anM()
    {
      long l1 = 0L;
      AppMethodBeat.i(209874);
      c localc = b.a(this.GwL);
      localc.setEnabled(false);
      long l2 = ((localc.getHeight() - localc.getTranslationY()) / localc.getHeight() * 300.0F);
      if (l2 < 0L) {}
      for (;;)
      {
        localc.animate().translationY(localc.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
        AppMethodBeat.o(209874);
        return;
        l1 = l2;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(b.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(209873);
        new ao().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209872);
            if (this.GwN.GwM.GwL.isShowing()) {
              this.GwN.GwM.GwL.cancel();
            }
            AppMethodBeat.o(209872);
          }
        });
        AppMethodBeat.o(209873);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.d.b
 * JD-Core Version:    0.7.0.1
 */