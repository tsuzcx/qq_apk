package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class a
{
  private static String TAG = "MicroMsg.CommonHintViewConfig";
  
  public static void a(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49379);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49379);
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.3());
    b.f(paramMMActivity, paramWalletFormView);
    paramWalletFormView.setOnInfoIvClickListener(new a.4(paramWalletFormView, paramMMActivity));
    AppMethodBeat.o(49379);
  }
  
  public static void a(EditHintPasswdView paramEditHintPasswdView)
  {
    AppMethodBeat.i(49376);
    if (paramEditHintPasswdView != null) {
      paramEditHintPasswdView.setEncrType(1);
    }
    AppMethodBeat.o(49376);
  }
  
  public static void a(EditHintPasswdView paramEditHintPasswdView, boolean paramBoolean)
  {
    AppMethodBeat.i(49377);
    if (paramEditHintPasswdView != null) {
      if (!paramBoolean) {
        break label27;
      }
    }
    label27:
    for (int i = -10;; i = 20)
    {
      paramEditHintPasswdView.setEncrType(i);
      AppMethodBeat.o(49377);
      return;
    }
  }
  
  public static void b(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49380);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49380);
      return;
    }
    paramWalletFormView.setOnInfoIvClickListener(new a.5(paramWalletFormView, paramMMActivity));
    AppMethodBeat.o(49380);
  }
  
  public static void b(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49378);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49378);
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.1());
    AppMethodBeat.o(49378);
  }
  
  public static void c(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49384);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49384);
      return;
    }
    paramWalletFormView.setOnInfoIvClickListener(new a.7(paramMMActivity));
    paramWalletFormView.setLogicDelegate(new a.8());
    AppMethodBeat.o(49384);
  }
  
  public static void c(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49381);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49381);
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.a(paramWalletFormView, (byte)0));
    AppMethodBeat.o(49381);
  }
  
  public static void d(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49385);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49385);
      return;
    }
    paramWalletFormView.setOnInfoIvClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49366);
        h.d(this.lHl, this.lHl.getString(2131304957), this.lHl.getString(2131304954), this.lHl.getString(2131304956), this.lHl.getString(2131304958), new a.9.1(this), new a.9.2(this));
        AppMethodBeat.o(49366);
      }
    });
    paramWalletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    AppMethodBeat.o(49385);
  }
  
  public static void d(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49382);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49382);
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.a(paramWalletFormView));
    paramWalletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    AppMethodBeat.o(49382);
  }
  
  public static void e(MMActivity paramMMActivity, WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49386);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49386);
      return;
    }
    paramWalletFormView.setOnInfoIvClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49367);
        b.a(this.lHl, 2130971206, 2131304954);
        AppMethodBeat.o(49367);
      }
    });
    paramWalletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    AppMethodBeat.o(49386);
  }
  
  public static void e(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49383);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49383);
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.6());
    AppMethodBeat.o(49383);
  }
  
  public static void f(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49387);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49387);
      return;
    }
    paramWalletFormView.setLogicDelegate(new a.2());
    AppMethodBeat.o(49387);
  }
  
  public static void g(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49388);
    if (paramWalletFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(49388);
      return;
    }
    paramWalletFormView.setIsSecretAnswer(true);
    AppMethodBeat.o(49388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a
 * JD-Core Version:    0.7.0.1
 */