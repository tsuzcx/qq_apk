package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  private static String TAG = "MicroMsg.CommonHintViewConfig";
  
  public static void a(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.3());
    b.f(paramMMActivity, paramWalletFormView);
    paramWalletFormView.setOnInfoIvClickListener(new a.4(paramWalletFormView, paramMMActivity));
  }
  
  public static void a(EditHintPasswdView paramEditHintPasswdView)
  {
    if (paramEditHintPasswdView != null) {
      paramEditHintPasswdView.setEncrType(1);
    }
  }
  
  public static void a(EditHintPasswdView paramEditHintPasswdView, boolean paramBoolean)
  {
    if (paramEditHintPasswdView != null) {
      if (!paramBoolean) {
        break label17;
      }
    }
    label17:
    for (int i = -10;; i = 20)
    {
      paramEditHintPasswdView.setEncrType(i);
      return;
    }
  }
  
  public static void b(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setOnInfoIvClickListener(new a.5(paramWalletFormView, paramMMActivity));
  }
  
  public static void b(WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.1());
  }
  
  public static void c(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setOnInfoIvClickListener(new a.7(paramMMActivity));
    paramWalletFormView.setLogicDelegate(new a.8());
  }
  
  public static void c(WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.a(paramWalletFormView, (byte)0));
  }
  
  public static void d(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setOnInfoIvClickListener(new a.9(paramMMActivity));
    paramWalletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
  }
  
  public static void d(WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.a(paramWalletFormView));
    paramWalletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
  }
  
  public static void e(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setOnInfoIvClickListener(new a.10(paramMMActivity));
    paramWalletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
  }
  
  public static void e(WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.6());
  }
  
  public static void f(WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.2());
  }
  
  public static void g(WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramWalletFormView.setIsSecretAnswer(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a
 * JD-Core Version:    0.7.0.1
 */