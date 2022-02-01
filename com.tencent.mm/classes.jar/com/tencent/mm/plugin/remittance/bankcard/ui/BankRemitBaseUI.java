package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class BankRemitBaseUI
  extends WalletBaseUI
{
  public static int bk(Activity paramActivity)
  {
    int j = 0;
    int i = j;
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label37;
      }
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(8192);
      i = 3;
    }
    label37:
    do
    {
      return i;
      if (bl(paramActivity)) {
        return 1;
      }
      i = j;
    } while (!f(paramActivity.getWindow()));
    return 2;
  }
  
  private static boolean bl(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    if (localWindow != null)
    {
      Class localClass1 = localWindow.getClass();
      try
      {
        Class localClass2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int i = localClass2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass2);
        localClass1.getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(localWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
        return false;
      }
      catch (Exception paramActivity)
      {
        try
        {
          if (Build.VERSION.SDK_INT >= 23) {
            paramActivity.getWindow().getDecorView().setSystemUiVisibility(8192);
          }
          return true;
        }
        catch (Exception paramActivity)
        {
          return true;
        }
        paramActivity = paramActivity;
        return false;
      }
    }
  }
  
  private static boolean f(Window paramWindow)
  {
    if (paramWindow != null) {
      try
      {
        WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
        Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        localField1.setAccessible(true);
        localField2.setAccessible(true);
        localField2.setInt(localLayoutParams, localField1.getInt(null) | localField2.getInt(localLayoutParams));
        paramWindow.setAttributes(localLayoutParams);
        return true;
      }
      catch (Exception paramWindow) {}
    }
    return false;
  }
  
  protected void fPx() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fPx();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67500);
        if (BankRemitBaseUI.a(BankRemitBaseUI.this))
        {
          BankRemitBaseUI.this.hideVKB();
          BankRemitBaseUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(67500);
          return true;
          BankRemitBaseUI.this.finish();
        }
      }
    });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI
 * JD-Core Version:    0.7.0.1
 */