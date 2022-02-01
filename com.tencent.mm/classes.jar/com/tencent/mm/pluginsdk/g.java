package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;

public final class g
{
  public static void a(MMFragmentActivity paramMMFragmentActivity, View paramView)
  {
    AppMethodBeat.i(141151);
    if (paramMMFragmentActivity == null)
    {
      AppMethodBeat.o(141151);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (paramMMFragmentActivity.getWindow() != null) && (paramMMFragmentActivity.getWindow().getDecorView() != null)) {
      paramMMFragmentActivity.getWindow().getDecorView().post(new g.2(paramMMFragmentActivity, paramView));
    }
    AppMethodBeat.o(141151);
  }
  
  public static void aJ(Activity paramActivity)
  {
    AppMethodBeat.i(141148);
    if (Build.VERSION.SDK_INT >= 16)
    {
      if ((paramActivity instanceof AppCompatActivity))
      {
        ((AppCompatActivity)paramActivity).supportRequestWindowFeature(109);
        AppMethodBeat.o(141148);
        return;
      }
      paramActivity.requestWindowFeature(9);
    }
    AppMethodBeat.o(141148);
  }
  
  public static void b(MMFragmentActivity paramMMFragmentActivity, View paramView)
  {
    AppMethodBeat.i(141152);
    if (paramMMFragmentActivity == null)
    {
      AppMethodBeat.o(141152);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (paramMMFragmentActivity.getWindow() != null) && (paramMMFragmentActivity.getWindow().getDecorView() != null)) {
      paramMMFragmentActivity.getWindow().getDecorView().post(new g.3(paramMMFragmentActivity, paramView));
    }
    AppMethodBeat.o(141152);
  }
  
  public static int dL(Context paramContext)
  {
    AppMethodBeat.i(141153);
    int i = 0;
    Object localObject = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(2130968600, (TypedValue)localObject, true)) {
      i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject).data, paramContext.getResources().getDisplayMetrics());
    }
    localObject = paramContext.getResources().getDisplayMetrics();
    int j = i;
    if (i <= 0) {
      if (((DisplayMetrics)localObject).widthPixels <= ((DisplayMetrics)localObject).heightPixels) {
        break label86;
      }
    }
    label86:
    for (j = paramContext.getResources().getDimensionPixelSize(2131165251);; j = paramContext.getResources().getDimensionPixelSize(2131165252))
    {
      AppMethodBeat.o(141153);
      return j;
    }
  }
  
  public static int gW(Context paramContext)
  {
    AppMethodBeat.i(141147);
    int i = 0;
    if ((paramContext instanceof MMActivity)) {
      i = ((MMActivity)paramContext).getTitleLocation();
    }
    int j = i;
    if (i <= 0) {
      j = paramContext.getResources().getDimensionPixelSize(2131165252);
    }
    AppMethodBeat.o(141147);
    return j;
  }
  
  public static void o(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(141149);
    if (Build.VERSION.SDK_INT >= 16) {
      paramMMActivity.supportRequestWindowFeature(109);
    }
    AppMethodBeat.o(141149);
  }
  
  public static void p(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(141150);
    WeakReference localWeakReference = new WeakReference(paramMMActivity);
    if (Build.VERSION.SDK_INT >= 16) {
      paramMMActivity.getWindow().getDecorView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(141144);
          MMActivity localMMActivity = (MMActivity)this.BNs.get();
          if ((localMMActivity == null) || (localMMActivity.isFinishing()) || (localMMActivity.isDestroyed()))
          {
            AppMethodBeat.o(141144);
            return;
          }
          localMMActivity.getWindow().getDecorView().setSystemUiVisibility(localMMActivity.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
          int i = com.tencent.mm.compatible.util.a.ca(localMMActivity);
          ad.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.cd.a.fromDPToPix(localMMActivity, 2)) });
          localMMActivity.getBodyView().setPadding(0, i - com.tencent.mm.cd.a.fromDPToPix(localMMActivity, 2), 0, 0);
          AppMethodBeat.o(141144);
        }
      });
    }
    AppMethodBeat.o(141150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g
 * JD-Core Version:    0.7.0.1
 */