package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.ar;

public class BaseLuggageActivity
  extends BaseActivity
  implements f.e
{
  private static boolean blR(String paramString)
  {
    AppMethodBeat.i(176011);
    String str1 = Build.MODEL;
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null))
    {
      AppMethodBeat.o(176011);
      return false;
    }
    if ((ne(str1, paramString)) || (ne(str2, paramString)))
    {
      AppMethodBeat.o(176011);
      return true;
    }
    AppMethodBeat.o(176011);
    return false;
  }
  
  private static boolean ne(String paramString1, String paramString2)
  {
    AppMethodBeat.i(176010);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(176010);
      return false;
    }
    boolean bool = Util.isEqual(paramString1.toLowerCase(), paramString2.toLowerCase());
    AppMethodBeat.o(176010);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131493027;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(204437);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(204437);
    return localResources;
  }
  
  protected final void hideActionbarLine()
  {
    AppMethodBeat.i(131600);
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().setElevation(0.0F);
    }
    AppMethodBeat.o(131600);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131598);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    f.aK(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(131598);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131599);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    f.aK(this).b(paramInt, paramArrayOfInt);
    AppMethodBeat.o(131599);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    AppMethodBeat.i(176012);
    int i;
    View localView;
    if (Build.VERSION.SDK_INT >= 26)
    {
      if ((!blR("y83a")) && (!blR("y83")) && (!blR("v1732a")) && (!blR("v1732t"))) {
        break label100;
      }
      i = 1;
      if (i == 0)
      {
        getWindow().setNavigationBarColor(paramInt);
        boolean bool = ar.aln(paramInt);
        localView = getWindow().getDecorView();
        paramInt = localView.getSystemUiVisibility();
        if (!bool) {
          break label105;
        }
        paramInt &= 0xFFFFFFEF;
      }
    }
    for (;;)
    {
      localView.setSystemUiVisibility(paramInt);
      AppMethodBeat.o(176012);
      return;
      label100:
      i = 0;
      break;
      label105:
      paramInt |= 0x10;
    }
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(131601);
    try
    {
      super.setRequestedOrientation(paramInt);
      AppMethodBeat.o(131601);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.BaseLuggageActivity", localThrowable, "AndroidOSafety.safety uncaught", new Object[0]);
      AppMethodBeat.o(131601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.BaseLuggageActivity
 * JD-Core Version:    0.7.0.1
 */