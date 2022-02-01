package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

public final class b
{
  private static int Rvl = 0;
  private static int Rvm = 0;
  private static final int Rwa = 2131310193;
  
  public static void a(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73137);
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(73137);
      return;
    }
    paramMMActivity.addDialog(com.tencent.mm.wallet_core.ui.b.a(paramMMActivity, paramInt1, paramMMActivity.getResources().getString(paramInt2), paramMMActivity.getResources().getString(2131767734), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(73133);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(73133);
      }
    }));
    AppMethodBeat.o(73137);
  }
  
  static void a(TenpaySecureEditText paramTenpaySecureEditText, int paramInt)
  {
    AppMethodBeat.i(73135);
    a(paramTenpaySecureEditText, paramInt, true);
    AppMethodBeat.o(73135);
  }
  
  static void a(TenpaySecureEditText paramTenpaySecureEditText, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(214345);
    if (paramTenpaySecureEditText != null)
    {
      if (paramInt == 1)
      {
        paramTenpaySecureEditText.setIsPasswordFormat(true, paramBoolean);
        AppMethodBeat.o(214345);
        return;
      }
      if (paramInt == 2)
      {
        paramTenpaySecureEditText.setIsSecurityAnswerFormat(true);
        AppMethodBeat.o(214345);
        return;
      }
      if (paramInt == 3)
      {
        paramTenpaySecureEditText.setIsCvvPaymentFormat(true);
        AppMethodBeat.o(214345);
        return;
      }
      if (paramInt == 4)
      {
        paramTenpaySecureEditText.setIsCvv4PaymentFormat(true);
        AppMethodBeat.o(214345);
        return;
      }
      if (paramInt == 5)
      {
        paramTenpaySecureEditText.setIsValidThru(true);
        AppMethodBeat.o(214345);
        return;
      }
      if (paramInt == 6)
      {
        paramTenpaySecureEditText.setIsBankcardFormat(true);
        AppMethodBeat.o(214345);
        return;
      }
      if (paramInt == 7)
      {
        paramTenpaySecureEditText.setIsMoneyAmountFormat(true);
        AppMethodBeat.o(214345);
        return;
      }
      if (paramInt == 8)
      {
        paramTenpaySecureEditText.setIsIdCardTailFormat(true);
        AppMethodBeat.o(214345);
        return;
      }
      paramTenpaySecureEditText.setIsCvv4PaymentFormat(false);
      AppMethodBeat.o(214345);
      return;
    }
    Log.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
    AppMethodBeat.o(214345);
  }
  
  public static void e(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(73138);
    String str1 = paramMMActivity.getResources().getString(2131767598);
    String str2 = paramMMActivity.getResources().getString(2131767734);
    b.3 local3 = new b.3();
    View localView = ((LayoutInflater)paramMMActivity.getSystemService("layout_inflater")).inflate(2131496990, null);
    if ((paramString != null) && (!paramString.isEmpty())) {
      ((TextView)localView.findViewById(2131309187)).setText(paramString);
    }
    paramMMActivity.addDialog(h.a(paramMMActivity, str1, str2, localView, local3));
    AppMethodBeat.o(73138);
  }
  
  public static void f(MMActivity paramMMActivity, final WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(73136);
    paramWalletFormView.setOnClickListener(new View.OnClickListener()
    {
      int Rwb = -1;
      int year = -1;
      
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(73132);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/wallet_core/ui/formview/FormViewUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        this.rCm.hideVKB();
        if ((this.rCm instanceof WalletBaseUI)) {
          ((WalletBaseUI)this.rCm).hideTenpayKB();
        }
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(this.rCm);
        paramAnonymousView.bg(true, false);
        paramAnonymousView.QSU = new b.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(73131);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean)
            {
              localObject = paramAnonymousView.hcf();
              if (Util.isNullOrNil((String)localObject))
              {
                AppMethodBeat.o(73131);
                return;
              }
              String[] arrayOfString = ((String)localObject).split("-");
              if (arrayOfString.length < 2)
              {
                AppMethodBeat.o(73131);
                return;
              }
              Log.d("MicroMsg.FormatViewUtil", "result: %s", new Object[] { localObject });
              paramAnonymous2Int1 = Util.safeParseInt(arrayOfString[0]);
              b.1.this.Rwb = (Util.safeParseInt(arrayOfString[1]) - 1);
              Log.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(b.1.this.Rwb) });
              if ((paramAnonymous2Int1 >= b.Rvl) || (b.1.this.Rwb >= b.Rvm)) {
                break label221;
              }
              h.c(b.1.this.rCm, b.1.this.rCm.getString(2131767693), null, true);
              if (b.1.this.RvN.getInputValidChangeListener() != null) {
                b.1.this.RvN.getInputValidChangeListener().onInputValidChange(b.1.this.RvN.bql());
              }
            }
            AppMethodBeat.o(73131);
            return;
            label221:
            Object localObject = new DecimalFormat("00");
            if (z.aUo()) {
              b.1.this.RvN.setTag(((DecimalFormat)localObject).format(b.1.this.Rwb + 1) + paramAnonymous2Int1);
            }
            for (;;)
            {
              b.1.this.RvN.setText(((DecimalFormat)localObject).format(b.1.this.Rwb + 1) + ((DecimalFormat)localObject).format(paramAnonymous2Int1).substring(2));
              break;
              b.1.this.RvN.setTag(((DecimalFormat)localObject).format(paramAnonymous2Int1).substring(2) + ((DecimalFormat)localObject).format(b.1.this.Rwb + 1));
            }
          }
        };
        if ((this.year >= b.Rvl) && (this.Rwb >= b.Rvm)) {
          paramAnonymousView.aX(this.year, this.Rwb + 1, 1);
        }
        for (;;)
        {
          paramAnonymousView.show();
          a.a(this, "com/tencent/mm/wallet_core/ui/formview/FormViewUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73132);
          return;
          localObject = Calendar.getInstance();
          paramAnonymousView.aX(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
        }
      }
    });
    AppMethodBeat.o(73136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.b
 * JD-Core Version:    0.7.0.1
 */