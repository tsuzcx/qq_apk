package com.tencent.mm.ui.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.widget.q.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.bb;

public class BaseLuggageActivity
  extends BaseActivity
  implements e.e
{
  private final Object adOf;
  private volatile LayoutInflater mLayoutInflater;
  
  public BaseLuggageActivity()
  {
    AppMethodBeat.i(251467);
    this.adOf = new byte[0];
    this.mLayoutInflater = null;
    AppMethodBeat.o(251467);
  }
  
  private static boolean bzM(String paramString)
  {
    AppMethodBeat.i(176011);
    String str1 = q.aPo();
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null))
    {
      AppMethodBeat.o(176011);
      return false;
    }
    if ((pV(str1, paramString)) || (pV(str2, paramString)))
    {
      AppMethodBeat.o(176011);
      return true;
    }
    AppMethodBeat.o(176011);
    return false;
  }
  
  private LayoutInflater jlR()
  {
    AppMethodBeat.i(251471);
    if (this.mLayoutInflater == null) {}
    synchronized (this.adOf)
    {
      if (this.mLayoutInflater == null) {
        this.mLayoutInflater = j.adPk.ex(this);
      }
      ??? = this.mLayoutInflater;
      AppMethodBeat.o(251471);
      return ???;
    }
  }
  
  private static boolean pV(String paramString1, String paramString2)
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
    return q.d.app_brand_empty;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(251475);
    LayoutInflater localLayoutInflater = jlR();
    AppMethodBeat.o(251475);
    return localLayoutInflater;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(251480);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(251480);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(251474);
    if ("layout_inflater".equals(paramString))
    {
      paramString = jlR();
      AppMethodBeat.o(251474);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(251474);
    return paramString;
  }
  
  protected final void hideActionbarLine()
  {
    AppMethodBeat.i(131600);
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null)) {
      getSupportActionBar().g(0.0F);
    }
    AppMethodBeat.o(131600);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131598);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e.bt(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(131598);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131599);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    e.bt(this).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
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
      if ((!bzM("y83a")) && (!bzM("y83")) && (!bzM("v1732a")) && (!bzM("v1732t"))) {
        break label100;
      }
      i = 1;
      if (i == 0)
      {
        getWindow().setNavigationBarColor(paramInt);
        boolean bool = bb.aAF(paramInt);
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
    finally
    {
      Log.printErrStackTrace("MicroMsg.BaseLuggageActivity", localThrowable, "AndroidOSafety.safety uncaught", new Object[0]);
      AppMethodBeat.o(131601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.BaseLuggageActivity
 * JD-Core Version:    0.7.0.1
 */