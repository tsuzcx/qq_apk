package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

public final class b
{
  private static final int IfP = 2131306731;
  private static int Ifa = 0;
  private static int Ifb = 0;
  
  public static void a(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73137);
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(73137);
      return;
    }
    paramMMActivity.addDialog(com.tencent.mm.wallet_core.ui.b.a(paramMMActivity, paramInt1, paramMMActivity.getResources().getString(paramInt2), paramMMActivity.getResources().getString(2131765291), new b.2()));
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
    AppMethodBeat.i(187200);
    if (paramTenpaySecureEditText != null)
    {
      if (paramInt == 1)
      {
        paramTenpaySecureEditText.setIsPasswordFormat(true, paramBoolean);
        AppMethodBeat.o(187200);
        return;
      }
      if (paramInt == 2)
      {
        paramTenpaySecureEditText.setIsSecurityAnswerFormat(true);
        AppMethodBeat.o(187200);
        return;
      }
      if (paramInt == 3)
      {
        paramTenpaySecureEditText.setIsCvvPaymentFormat(true);
        AppMethodBeat.o(187200);
        return;
      }
      if (paramInt == 4)
      {
        paramTenpaySecureEditText.setIsCvv4PaymentFormat(true);
        AppMethodBeat.o(187200);
        return;
      }
      if (paramInt == 5)
      {
        paramTenpaySecureEditText.setIsValidThru(true);
        AppMethodBeat.o(187200);
        return;
      }
      if (paramInt == 6)
      {
        paramTenpaySecureEditText.setIsBankcardFormat(true);
        AppMethodBeat.o(187200);
        return;
      }
      if (paramInt == 7)
      {
        paramTenpaySecureEditText.setIsMoneyAmountFormat(true);
        AppMethodBeat.o(187200);
        return;
      }
      if (paramInt == 8)
      {
        paramTenpaySecureEditText.setIsIdCardTailFormat(true);
        AppMethodBeat.o(187200);
        return;
      }
      paramTenpaySecureEditText.setIsCvv4PaymentFormat(false);
      AppMethodBeat.o(187200);
      return;
    }
    ad.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
    AppMethodBeat.o(187200);
  }
  
  public static void e(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(73138);
    String str1 = paramMMActivity.getResources().getString(2131765155);
    String str2 = paramMMActivity.getResources().getString(2131765291);
    b.3 local3 = new b.3();
    View localView = ((LayoutInflater)paramMMActivity.getSystemService("layout_inflater")).inflate(2131496010, null);
    if ((paramString != null) && (!paramString.isEmpty())) {
      ((TextView)localView.findViewById(2131305896)).setText(paramString);
    }
    paramMMActivity.addDialog(h.a(paramMMActivity, str1, str2, localView, local3));
    AppMethodBeat.o(73138);
  }
  
  public static void f(MMActivity paramMMActivity, final WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(73136);
    paramWalletFormView.setOnClickListener(new View.OnClickListener()
    {
      int IfQ = -1;
      int year = -1;
      
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(73132);
        this.oXW.hideVKB();
        if ((this.oXW instanceof WalletBaseUI)) {
          ((WalletBaseUI)this.oXW).hideTenpayKB();
        }
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(this.oXW);
        paramAnonymousView.aL(true, false);
        paramAnonymousView.HIQ = new b.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(73131);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean)
            {
              localObject = paramAnonymousView.ffY();
              if (bt.isNullOrNil((String)localObject))
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
              ad.d("MicroMsg.FormatViewUtil", "result: %s", new Object[] { localObject });
              paramAnonymous2Int1 = bt.aGh(arrayOfString[0]);
              b.1.this.IfQ = (bt.aGh(arrayOfString[1]) - 1);
              ad.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(b.1.this.IfQ) });
              if ((paramAnonymous2Int1 >= b.Ifa) || (b.1.this.IfQ >= b.Ifb)) {
                break label221;
              }
              h.c(b.1.this.oXW, b.1.this.oXW.getString(2131765250), null, true);
              if (b.1.this.IfC.getInputValidChangeListener() != null) {
                b.1.this.IfC.getInputValidChangeListener().onInputValidChange(b.1.this.IfC.aKX());
              }
            }
            AppMethodBeat.o(73131);
            return;
            label221:
            Object localObject = new DecimalFormat("00");
            if (u.aqV()) {
              b.1.this.IfC.setTag(((DecimalFormat)localObject).format(b.1.this.IfQ + 1) + paramAnonymous2Int1);
            }
            for (;;)
            {
              b.1.this.IfC.setText(((DecimalFormat)localObject).format(b.1.this.IfQ + 1) + ((DecimalFormat)localObject).format(paramAnonymous2Int1).substring(2));
              break;
              b.1.this.IfC.setTag(((DecimalFormat)localObject).format(paramAnonymous2Int1).substring(2) + ((DecimalFormat)localObject).format(b.1.this.IfQ + 1));
            }
          }
        };
        if ((this.year >= b.Ifa) && (this.IfQ >= b.Ifb)) {
          paramAnonymousView.aM(this.year, this.IfQ + 1, 1);
        }
        for (;;)
        {
          paramAnonymousView.show();
          AppMethodBeat.o(73132);
          return;
          Calendar localCalendar = Calendar.getInstance();
          paramAnonymousView.aM(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5));
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