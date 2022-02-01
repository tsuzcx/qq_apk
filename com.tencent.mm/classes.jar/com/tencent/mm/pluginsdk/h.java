package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;

public final class h
{
  public static void a(AppCompatActivity paramAppCompatActivity, View paramView)
  {
    AppMethodBeat.i(244519);
    if (paramAppCompatActivity == null)
    {
      AppMethodBeat.o(244519);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (paramAppCompatActivity.getWindow() != null) && (paramAppCompatActivity.getWindow().getDecorView() != null)) {
      paramAppCompatActivity.getWindow().getDecorView().post(new h.3(paramAppCompatActivity, paramView));
    }
    AppMethodBeat.o(244519);
  }
  
  public static void b(MMFragmentActivity paramMMFragmentActivity, View paramView)
  {
    AppMethodBeat.i(141151);
    if (paramMMFragmentActivity == null)
    {
      AppMethodBeat.o(141151);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (paramMMFragmentActivity.getWindow() != null) && (paramMMFragmentActivity.getWindow().getDecorView() != null)) {
      paramMMFragmentActivity.getWindow().getDecorView().post(new h.2(paramMMFragmentActivity, paramView));
    }
    AppMethodBeat.o(141151);
  }
  
  public static void bE(Activity paramActivity)
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
  
  public static int fs(Context paramContext)
  {
    AppMethodBeat.i(141153);
    int i = 0;
    Object localObject = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(a.c.actionBarSize, (TypedValue)localObject, true)) {
      i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject).data, paramContext.getResources().getDisplayMetrics());
    }
    localObject = paramContext.getResources().getDisplayMetrics();
    int j = i;
    if (i <= 0) {
      if (((DisplayMetrics)localObject).widthPixels <= ((DisplayMetrics)localObject).heightPixels) {
        break label88;
      }
    }
    label88:
    for (j = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightLand);; j = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort))
    {
      AppMethodBeat.o(141153);
      return j;
    }
  }
  
  public static int lm(Context paramContext)
  {
    AppMethodBeat.i(141147);
    int i = 0;
    if ((paramContext instanceof MMActivity)) {
      i = ((MMActivity)paramContext).getTitleLocation();
    }
    int j = i;
    if (i <= 0) {
      j = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
    }
    AppMethodBeat.o(141147);
    return j;
  }
  
  public static void w(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(141149);
    if (Build.VERSION.SDK_INT >= 16) {
      paramMMActivity.supportRequestWindowFeature(109);
    }
    AppMethodBeat.o(141149);
  }
  
  public static void x(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(141150);
    WeakReference localWeakReference = new WeakReference(paramMMActivity);
    if (Build.VERSION.SDK_INT >= 16) {
      paramMMActivity.getWindow().getDecorView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(141144);
          MMActivity localMMActivity = (MMActivity)h.this.get();
          if ((localMMActivity == null) || (localMMActivity.isFinishing()) || (localMMActivity.isDestroyed()))
          {
            AppMethodBeat.o(141144);
            return;
          }
          localMMActivity.getWindow().getDecorView().setSystemUiVisibility(localMMActivity.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
          int i = com.tencent.mm.compatible.util.a.di(localMMActivity);
          Log.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.cd.a.fromDPToPix(localMMActivity, 2)) });
          localMMActivity.getBodyView().setPadding(0, i - com.tencent.mm.cd.a.fromDPToPix(localMMActivity, 2), 0, 0);
          AppMethodBeat.o(141144);
        }
      });
    }
    AppMethodBeat.o(141150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h
 * JD-Core Version:    0.7.0.1
 */