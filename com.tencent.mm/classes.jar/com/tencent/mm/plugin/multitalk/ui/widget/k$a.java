package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic$Companion;", "", "()V", "SCREEN_PROJECT_TYPE_BLACK_BOARD", "", "SCREEN_PROJECT_TYPE_FILE", "TAG", "", "checkOrientation", "context", "Landroid/content/Context;", "doExport", "", "bitmap", "Landroid/graphics/Bitmap;", "doFavExport", "doSendToFriendExport", "fillEventInfo", "", "favEvent", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "sourceType", "imagePath", "getNavigationBarMargin", "showSystemStatusBar", "activity", "Landroid/app/Activity;", "show", "plugin-multitalk_release"})
public final class k$a
{
  public static void c(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(239814);
    p.h(paramActivity, "activity");
    if (!paramBoolean)
    {
      paramActivity.getWindow().setFlags(1024, 1024);
      paramActivity.getWindow().clearFlags(134217728);
      AppMethodBeat.o(239814);
      return;
    }
    paramActivity.getWindow().clearFlags(1024);
    paramActivity.getWindow().addFlags(134217728);
    AppMethodBeat.o(239814);
  }
  
  public static int gE(Context paramContext)
  {
    AppMethodBeat.i(239812);
    p.h(paramContext, "context");
    paramContext = paramContext.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(239812);
      throw paramContext;
    }
    paramContext = ((WindowManager)paramContext).getDefaultDisplay();
    p.g(paramContext, "(context.getSystemServic…owManager).defaultDisplay");
    switch (paramContext.getRotation())
    {
    default: 
      AppMethodBeat.o(239812);
      return 0;
    case 0: 
      AppMethodBeat.o(239812);
      return 0;
    case 1: 
      AppMethodBeat.o(239812);
      return 90;
    case 2: 
      AppMethodBeat.o(239812);
      return 180;
    }
    AppMethodBeat.o(239812);
    return 270;
  }
  
  public static int gF(Context paramContext)
  {
    AppMethodBeat.i(239813);
    p.h(paramContext, "context");
    int i = 0;
    int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (j > 0) {
      i = Resources.getSystem().getDimensionPixelSize(j);
    }
    int k = au.aB(paramContext);
    j = i;
    if (k != 0)
    {
      j = i;
      if (k < i) {
        j = k;
      }
    }
    AppMethodBeat.o(239813);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k.a
 * JD-Core Version:    0.7.0.1
 */