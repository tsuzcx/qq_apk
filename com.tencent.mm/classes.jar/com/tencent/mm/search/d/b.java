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
import com.tencent.mm.al.f;
import com.tencent.mm.api.aa;
import com.tencent.mm.emoji.panel.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.ui.t;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "dismiss", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;Lkotlin/jvm/functions/Function0;)V", "commentScrolling", "", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "galleryScale", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "needCancelTouch", "targetView", "Lcom/tencent/mm/search/ui/SimilarEmojiView;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "wrapSheet", "Companion", "plugin-emojisdk_release"})
public final class b
  extends e
{
  public static final b.a IiE;
  private SimilarEmojiQueryModel DJs;
  private c IiB;
  private final b IiC;
  private d.g.a.a<z> IiD;
  private boolean gZG;
  private boolean gZH;
  private boolean gZI;
  private com.tencent.mm.ui.j.b gmC;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(105877);
    IiE = new b.a((byte)0);
    AppMethodBeat.o(105877);
  }
  
  public b(Context paramContext, SimilarEmojiQueryModel paramSimilarEmojiQueryModel, d.g.a.a<z> parama)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(105876);
    this.mContext = paramContext;
    this.DJs = paramSimilarEmojiQueryModel;
    this.IiD = parama;
    this.IiB = new c((Context)new t(this.mContext, 2131820870), this);
    gK();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.gmC = new com.tencent.mm.ui.j.b(paramContext);
    paramContext = this.IiB;
    paramSimilarEmojiQueryModel = this.DJs;
    p.h(paramSimilarEmojiQueryModel, "model");
    paramContext.Iih = paramSimilarEmojiQueryModel.Iih;
    parama = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    p.g(parama, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
    parama = ((com.tencent.mm.plugin.emoji.b.d)parama).getEmojiMgr().abr(paramSimilarEmojiQueryModel.emojiMD5);
    Object localObject = paramContext.DJv;
    p.g(parama, "head");
    ((a)localObject).F(parama);
    paramContext.DJv.Iiy = false;
    paramContext.DJv.fmL();
    paramContext.DJv.notifyDataSetChanged();
    localObject = paramContext.DJv.gnv;
    if (localObject == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.search.logic.SimilarEmojiPanelClickListener");
      AppMethodBeat.o(105876);
      throw paramContext;
    }
    ((com.tencent.mm.search.b.b)localObject).Iio = paramSimilarEmojiQueryModel;
    localObject = paramContext.DJv.gnv;
    if (localObject == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.EmojiPanelClickListener");
      AppMethodBeat.o(105876);
      throw paramContext;
    }
    ((com.tencent.mm.emoji.panel.a.d)localObject).gnn = paramSimilarEmojiQueryModel.Iii;
    paramContext.IiI.a(paramSimilarEmojiQueryModel, (f)new c.b(paramContext, parama));
    this.IiC = new b(this);
    AppMethodBeat.o(105876);
  }
  
  private final boolean aol()
  {
    AppMethodBeat.i(105873);
    Resources localResources = this.mContext.getResources();
    p.g(localResources, "mContext.resources");
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
    ad.i("MicroMsg.SimilarEmoji", "dialog dismiss");
    super.dismiss();
    this.IiD.invoke();
    AppMethodBeat.o(105872);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(105875);
    p.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.gmC.ag(paramMotionEvent);
      int i = this.gmC.KCq;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.gZH) || (this.gZG)) {
            break label178;
          }
          bool1 = this.gmC.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.gZH) && (!bool1)) {
        break label234;
      }
      if (!this.gZI)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.gZI = true;
      }
      AppMethodBeat.o(105875);
      return true;
      this.gZI = false;
      this.gZH = false;
      break;
      label178:
      bool1 = bool2;
      if (!this.gZI)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.gmC.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.gZI = true;
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
    setContentView((View)this.IiB);
    ad.i("MicroMsg.SimilarEmoji", "dialog onCreate " + this.DJs);
    paramBundle = this.DJs.Iii;
    if (paramBundle != null)
    {
      com.tencent.mm.search.b.a locala = com.tencent.mm.search.b.a.Iin;
      com.tencent.mm.search.b.a.a(paramBundle);
      AppMethodBeat.o(105870);
      return;
    }
    AppMethodBeat.o(105870);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(105871);
    ad.i("MicroMsg.SimilarEmoji", "dialog onStop");
    super.onStop();
    this.IiB.IiI.onDestroy();
    com.tencent.mm.search.b.a locala = com.tencent.mm.search.b.a.Iin;
    com.tencent.mm.search.b.a.destroy();
    AppMethodBeat.o(105871);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(105874);
    p.h(paramView, "view");
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (aol())
    {
      if (localObject == null) {
        p.gfZ();
      }
      ((Window)localObject).setGravity(5);
      ((Window)localObject).setWindowAnimations(2131821249);
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = ((Window)localObject).getAttributes();
      if (!aol()) {
        break label182;
      }
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      ((Window)localObject).setAttributes(localLayoutParams);
      int i = aa.bi(getContext());
      localObject = getContext();
      p.g(localObject, "context");
      super.setContentView(paramView, new ViewGroup.LayoutParams(-1, i + ((Context)localObject).getResources().getDimensionPixelOffset(2131165299) * 1));
      paramView = getWindow();
      if (paramView == null) {
        p.gfZ();
      }
      paramView.setLayout(-1, -2);
      AppMethodBeat.o(105874);
      return;
      if (localObject == null) {
        p.gfZ();
      }
      ((Window)localObject).setGravity(80);
      ((Window)localObject).setWindowAnimations(2131820790);
      break;
      label182:
      localLayoutParams.width = -1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void aqy()
    {
      long l1 = 0L;
      AppMethodBeat.i(219000);
      c localc = b.a(this.IiF);
      localc.setEnabled(false);
      long l2 = ((localc.getHeight() - localc.getTranslationY()) / localc.getHeight() * 300.0F);
      if (l2 < 0L) {}
      for (;;)
      {
        localc.animate().translationY(localc.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
        AppMethodBeat.o(219000);
        return;
        l1 = l2;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(b.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(218999);
        new ap().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218998);
            if (this.IiH.IiG.IiF.isShowing()) {
              this.IiH.IiG.IiF.cancel();
            }
            AppMethodBeat.o(218998);
          }
        });
        AppMethodBeat.o(218999);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.d.b
 * JD-Core Version:    0.7.0.1
 */