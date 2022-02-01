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
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

public final class b
{
  private static int LWv = 0;
  private static int LWw = 0;
  private static final int LXk = 2131306731;
  
  public static void a(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73137);
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(73137);
      return;
    }
    paramMMActivity.addDialog(com.tencent.mm.wallet_core.ui.b.a(paramMMActivity, paramInt1, paramMMActivity.getResources().getString(paramInt2), paramMMActivity.getResources().getString(2131765291), new DialogInterface.OnClickListener()
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
    AppMethodBeat.i(190259);
    if (paramTenpaySecureEditText != null)
    {
      if (paramInt == 1)
      {
        paramTenpaySecureEditText.setIsPasswordFormat(true, paramBoolean);
        AppMethodBeat.o(190259);
        return;
      }
      if (paramInt == 2)
      {
        paramTenpaySecureEditText.setIsSecurityAnswerFormat(true);
        AppMethodBeat.o(190259);
        return;
      }
      if (paramInt == 3)
      {
        paramTenpaySecureEditText.setIsCvvPaymentFormat(true);
        AppMethodBeat.o(190259);
        return;
      }
      if (paramInt == 4)
      {
        paramTenpaySecureEditText.setIsCvv4PaymentFormat(true);
        AppMethodBeat.o(190259);
        return;
      }
      if (paramInt == 5)
      {
        paramTenpaySecureEditText.setIsValidThru(true);
        AppMethodBeat.o(190259);
        return;
      }
      if (paramInt == 6)
      {
        paramTenpaySecureEditText.setIsBankcardFormat(true);
        AppMethodBeat.o(190259);
        return;
      }
      if (paramInt == 7)
      {
        paramTenpaySecureEditText.setIsMoneyAmountFormat(true);
        AppMethodBeat.o(190259);
        return;
      }
      if (paramInt == 8)
      {
        paramTenpaySecureEditText.setIsIdCardTailFormat(true);
        AppMethodBeat.o(190259);
        return;
      }
      paramTenpaySecureEditText.setIsCvv4PaymentFormat(false);
      AppMethodBeat.o(190259);
      return;
    }
    ae.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
    AppMethodBeat.o(190259);
  }
  
  public static void e(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(73138);
    String str1 = paramMMActivity.getResources().getString(2131765155);
    String str2 = paramMMActivity.getResources().getString(2131765291);
    DialogInterface.OnClickListener local3 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(73134);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(73134);
      }
    };
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
      int LXl = -1;
      int year = -1;
      
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(73132);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/wallet_core/ui/formview/FormViewUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        this.qlr.hideVKB();
        if ((this.qlr instanceof WalletBaseUI)) {
          ((WalletBaseUI)this.qlr).hideTenpayKB();
        }
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(this.qlr);
        paramAnonymousView.aW(true, false);
        paramAnonymousView.Lxi = new b.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(73131);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean)
            {
              localObject = paramAnonymousView.fRf();
              if (bu.isNullOrNil((String)localObject))
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
              ae.d("MicroMsg.FormatViewUtil", "result: %s", new Object[] { localObject });
              paramAnonymous2Int1 = bu.aSB(arrayOfString[0]);
              b.1.this.LXl = (bu.aSB(arrayOfString[1]) - 1);
              ae.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(b.1.this.LXl) });
              if ((paramAnonymous2Int1 >= b.LWv) || (b.1.this.LXl >= b.LWw)) {
                break label221;
              }
              h.c(b.1.this.qlr, b.1.this.qlr.getString(2131765250), null, true);
              if (b.1.this.LWX.getInputValidChangeListener() != null) {
                b.1.this.LWX.getInputValidChangeListener().onInputValidChange(b.1.this.LWX.aVz());
              }
            }
            AppMethodBeat.o(73131);
            return;
            label221:
            Object localObject = new DecimalFormat("00");
            if (v.aAR()) {
              b.1.this.LWX.setTag(((DecimalFormat)localObject).format(b.1.this.LXl + 1) + paramAnonymous2Int1);
            }
            for (;;)
            {
              b.1.this.LWX.setText(((DecimalFormat)localObject).format(b.1.this.LXl + 1) + ((DecimalFormat)localObject).format(paramAnonymous2Int1).substring(2));
              break;
              b.1.this.LWX.setTag(((DecimalFormat)localObject).format(paramAnonymous2Int1).substring(2) + ((DecimalFormat)localObject).format(b.1.this.LXl + 1));
            }
          }
        };
        if ((this.year >= b.LWv) && (this.LXl >= b.LWw)) {
          paramAnonymousView.aQ(this.year, this.LXl + 1, 1);
        }
        for (;;)
        {
          paramAnonymousView.show();
          a.a(this, "com/tencent/mm/wallet_core/ui/formview/FormViewUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73132);
          return;
          localObject = Calendar.getInstance();
          paramAnonymousView.aQ(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
        }
      }
    });
    AppMethodBeat.o(73136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.b
 * JD-Core Version:    0.7.0.1
 */