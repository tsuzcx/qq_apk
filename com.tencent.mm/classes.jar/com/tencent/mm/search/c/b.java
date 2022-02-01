package com.tencent.mm.search.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.emoji.panel.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.ui.s;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "dismiss", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;Lkotlin/jvm/functions/Function0;)V", "commentScrolling", "", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "galleryScale", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "needCancelTouch", "targetView", "Lcom/tencent/mm/search/ui/SimilarEmojiView;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "wrapSheet", "Companion", "plugin-emojisdk_release"})
public final class b
  extends e
{
  public static final a EZv;
  private SimilarEmojiQueryModel ANX;
  private c EZs;
  private final b.b EZt;
  private d.g.a.a<y> EZu;
  private com.tencent.mm.ui.j.b fPd;
  private Context mContext;
  private boolean ysM;
  private boolean ysN;
  private boolean ysO;
  
  static
  {
    AppMethodBeat.i(105877);
    EZv = new a((byte)0);
    AppMethodBeat.o(105877);
  }
  
  public b(Context paramContext, SimilarEmojiQueryModel paramSimilarEmojiQueryModel, d.g.a.a<y> parama)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(105876);
    this.mContext = paramContext;
    this.ANX = paramSimilarEmojiQueryModel;
    this.EZu = parama;
    this.EZs = new c((Context)new s(this.mContext, 2131820870), this);
    gl();
    paramContext = getContext();
    k.g(paramContext, "context");
    this.fPd = new com.tencent.mm.ui.j.b(paramContext);
    paramContext = this.EZs;
    paramSimilarEmojiQueryModel = this.ANX;
    k.h(paramSimilarEmojiQueryModel, "model");
    paramContext.EZb = paramSimilarEmojiQueryModel.EZb;
    parama = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    k.g(parama, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
    parama = ((com.tencent.mm.plugin.emoji.b.d)parama).getEmojiMgr().Tz(paramSimilarEmojiQueryModel.emojiMD5);
    Object localObject = paramContext.AOa;
    k.g(parama, "head");
    ((a)localObject).G(parama);
    paramContext.AOa.EZp = false;
    paramContext.AOa.eHF();
    paramContext.AOa.notifyDataSetChanged();
    localObject = paramContext.AOa.fPW;
    if (localObject == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.search.logic.SimilarEmojiPanelClickListener");
      AppMethodBeat.o(105876);
      throw paramContext;
    }
    ((com.tencent.mm.search.a.b)localObject).EZg = paramSimilarEmojiQueryModel;
    localObject = paramContext.AOa.fPW;
    if (localObject == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.EmojiPanelClickListener");
      AppMethodBeat.o(105876);
      throw paramContext;
    }
    ((com.tencent.mm.emoji.panel.a.d)localObject).fPO = paramSimilarEmojiQueryModel.EZc;
    paramContext.EZx.a(paramSimilarEmojiQueryModel, (com.tencent.mm.al.g)new c.b(paramContext, parama));
    this.EZt = new b.b(this);
    AppMethodBeat.o(105876);
  }
  
  private final boolean aov()
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
    ad.i("MicroMsg.SimilarEmoji", "dialog dismiss");
    super.dismiss();
    this.EZu.invoke();
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
      this.fPd.ae(paramMotionEvent);
      int i = this.fPd.HkQ;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.ysN) || (this.ysM)) {
            break label178;
          }
          bool1 = this.fPd.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.ysN) && (!bool1)) {
        break label234;
      }
      if (!this.ysO)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.ysO = true;
      }
      AppMethodBeat.o(105875);
      return true;
      this.ysO = false;
      this.ysN = false;
      break;
      label178:
      bool1 = bool2;
      if (!this.ysO)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.fPd.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.ysO = true;
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
    setContentView((View)this.EZs);
    ad.i("MicroMsg.SimilarEmoji", "dialog onCreate " + this.ANX);
    paramBundle = this.ANX.EZc;
    if (paramBundle != null)
    {
      com.tencent.mm.search.a.a locala = com.tencent.mm.search.a.a.EZf;
      com.tencent.mm.search.a.a.a(paramBundle);
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
    this.EZs.EZx.onDestroy();
    com.tencent.mm.search.a.a locala = com.tencent.mm.search.a.a.EZf;
    com.tencent.mm.search.a.a.destroy();
    AppMethodBeat.o(105871);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(105874);
    k.h(paramView, "view");
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (aov())
    {
      if (localObject == null) {
        k.fvU();
      }
      ((Window)localObject).setGravity(5);
      ((Window)localObject).setWindowAnimations(2131821249);
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = ((Window)localObject).getAttributes();
      if (!aov()) {
        break label182;
      }
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      ((Window)localObject).setAttributes(localLayoutParams);
      int i = aa.bh(getContext());
      localObject = getContext();
      k.g(localObject, "context");
      super.setContentView(paramView, new ViewGroup.LayoutParams(-1, i + ((Context)localObject).getResources().getDimensionPixelOffset(2131165299) * 1));
      paramView = getWindow();
      if (paramView == null) {
        k.fvU();
      }
      paramView.setLayout(-1, -2);
      AppMethodBeat.o(105874);
      return;
      if (localObject == null) {
        k.fvU();
      }
      ((Window)localObject).setGravity(80);
      ((Window)localObject).setWindowAnimations(2131820790);
      break;
      label182:
      localLayoutParams.width = -1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/ui/SimilarEmojiDialog$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.c.b
 * JD-Core Version:    0.7.0.1
 */