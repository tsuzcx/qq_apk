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
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ae;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.ui.z;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "dismiss", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;Lkotlin/jvm/functions/Function0;)V", "commentScrolling", "", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "galleryScale", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "needCancelTouch", "targetView", "Lcom/tencent/mm/search/ui/SimilarEmojiView;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "wrapSheet", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public static final b.a acsn;
  private SimilarEmojiQueryModel WAo;
  private c acso;
  private final b acsp;
  private Context mContext;
  private com.tencent.mm.ui.o.b mke;
  private kotlin.g.a.a<ah> moW;
  private boolean nmh;
  private boolean nmi;
  private boolean nmj;
  
  static
  {
    AppMethodBeat.i(105877);
    acsn = new b.a((byte)0);
    AppMethodBeat.o(105877);
  }
  
  public b(Context paramContext, SimilarEmojiQueryModel paramSimilarEmojiQueryModel, kotlin.g.a.a<ah> parama)
  {
    super(paramContext, a.k.CustomSheetStyle);
    AppMethodBeat.i(105876);
    this.mContext = paramContext;
    this.WAo = paramSimilarEmojiQueryModel;
    this.moW = parama;
    this.acso = new c((Context)new z(this.mContext, a.k.EmojiPanel), this);
    bU();
    paramContext = getContext();
    s.s(paramContext, "context");
    this.mke = new com.tencent.mm.ui.o.b(paramContext);
    this.acso.a(this.WAo);
    this.acsp = new b(this);
    AppMethodBeat.o(105876);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(105873);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
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
    this.moW.invoke();
    AppMethodBeat.o(105872);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(105875);
    s.u(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.mke.aw(paramMotionEvent);
      int i = this.mke.Irw;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.nmi) || (this.nmh)) {
            break label166;
          }
          bool1 = this.mke.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.nmi) && (!bool1)) {
        break label225;
      }
      if (!this.nmj)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.nmj = true;
      }
      AppMethodBeat.o(105875);
      return true;
      this.nmj = false;
      this.nmi = false;
      break;
      label166:
      bool1 = bool2;
      if (!this.nmj)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(3);
        com.tencent.mm.ui.o.b localb = this.mke;
        s.s(localMotionEvent, "cancelEvent");
        localb.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.nmj = true;
        bool1 = bool2;
      }
    }
    label225:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(105875);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(105870);
    super.onCreate(paramBundle);
    setContentView((View)this.acso);
    Log.i("MicroMsg.SimilarEmoji", s.X("dialog onCreate ", this.WAo));
    paramBundle = this.WAo.acsb;
    if (paramBundle != null)
    {
      com.tencent.mm.search.b.a locala = com.tencent.mm.search.b.a.acse;
      com.tencent.mm.search.b.a.a(paramBundle);
    }
    AppMethodBeat.o(105870);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(105871);
    Log.i("MicroMsg.SimilarEmoji", "dialog onStop");
    super.onStop();
    this.acso.acst.onDestroy();
    com.tencent.mm.search.b.a locala = com.tencent.mm.search.b.a.acse;
    com.tencent.mm.search.b.a.destroy();
    AppMethodBeat.o(105871);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(105874);
    s.u(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      s.checkNotNull(localWindow);
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(a.k.RightToLeftAnimation);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!isLandscape()) {
        break label159;
      }
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      localWindow.setAttributes(localLayoutParams);
      super.setContentView(paramView, new ViewGroup.LayoutParams(-1, ae.cp(getContext()) + getContext().getResources().getDimensionPixelOffset(a.e.Edge_7A) * 1));
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.setLayout(-1, -2);
      AppMethodBeat.o(105874);
      return;
      s.checkNotNull(localWindow);
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(a.k.BottomToTopSlowAnimation);
      break;
      label159:
      localLayoutParams.width = -1;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    b(b paramb) {}
    
    private static final void b(b paramb)
    {
      AppMethodBeat.i(236860);
      s.u(paramb, "this$0");
      if (paramb.isShowing()) {
        paramb.cancel();
      }
      AppMethodBeat.o(236860);
    }
    
    private static final void c(b paramb)
    {
      AppMethodBeat.i(236864);
      s.u(paramb, "this$0");
      new MMHandler().post(new b.b..ExternalSyntheticLambda1(paramb));
      AppMethodBeat.o(236864);
    }
    
    public final void bkW()
    {
      long l1 = 0L;
      AppMethodBeat.i(236876);
      c localc = b.a(this.acsq);
      b localb = this.acsq;
      localc.setEnabled(false);
      long l2 = ((localc.getHeight() - localc.getTranslationY()) / localc.getHeight() * 300.0F);
      if (l2 < 0L) {}
      for (;;)
      {
        localc.animate().translationY(localc.getHeight()).setDuration(l1).withEndAction(new b.b..ExternalSyntheticLambda0(localb)).start();
        AppMethodBeat.o(236876);
        return;
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.d.b
 * JD-Core Version:    0.7.0.1
 */