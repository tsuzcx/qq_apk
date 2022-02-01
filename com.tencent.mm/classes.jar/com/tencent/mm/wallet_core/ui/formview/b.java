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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

public final class b
{
  private static int agUD = 0;
  private static int agUE = 0;
  private static final int agVF = a.f.wallet_date_dialog_tag_id;
  
  public static void a(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73137);
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(73137);
      return;
    }
    paramMMActivity.addDialog(com.tencent.mm.wallet_core.ui.b.a(paramMMActivity, paramInt1, paramMMActivity.getResources().getString(paramInt2), paramMMActivity.getResources().getString(a.i.wallet_i_know_it), new DialogInterface.OnClickListener()
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
  
  public static void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(242218);
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(242218);
      return;
    }
    String str1 = paramMMActivity.getResources().getString(paramInt2);
    String str2 = paramMMActivity.getResources().getString(a.i.wallet_i_know_it);
    b.3 local3 = new b.3();
    View localView = ((LayoutInflater)paramMMActivity.getSystemService("layout_inflater")).inflate(paramInt1, null);
    if ((paramString != null) && (!paramString.isEmpty())) {
      ((TextView)localView.findViewById(a.f.tips_tv)).setText(paramString);
    }
    paramMMActivity.addDialog(k.a(paramMMActivity, str1, str2, localView, local3));
    AppMethodBeat.o(242218);
  }
  
  static void a(TenpaySecureEditText paramTenpaySecureEditText, int paramInt)
  {
    AppMethodBeat.i(73135);
    a(paramTenpaySecureEditText, paramInt, true);
    AppMethodBeat.o(73135);
  }
  
  static void a(TenpaySecureEditText paramTenpaySecureEditText, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(242213);
    if (paramTenpaySecureEditText != null)
    {
      if (paramInt == 1)
      {
        paramTenpaySecureEditText.setIsPasswordFormat(true, paramBoolean);
        AppMethodBeat.o(242213);
        return;
      }
      if (paramInt == 2)
      {
        paramTenpaySecureEditText.setIsSecurityAnswerFormat(true);
        AppMethodBeat.o(242213);
        return;
      }
      if (paramInt == 3)
      {
        paramTenpaySecureEditText.setIsCvvPaymentFormat(true);
        AppMethodBeat.o(242213);
        return;
      }
      if (paramInt == 4)
      {
        paramTenpaySecureEditText.setIsCvv4PaymentFormat(true);
        AppMethodBeat.o(242213);
        return;
      }
      if (paramInt == 5)
      {
        paramTenpaySecureEditText.setIsValidThru(true);
        AppMethodBeat.o(242213);
        return;
      }
      if (paramInt == 6)
      {
        paramTenpaySecureEditText.setIsBankcardFormat(true);
        AppMethodBeat.o(242213);
        return;
      }
      if (paramInt == 7)
      {
        paramTenpaySecureEditText.setIsMoneyAmountFormat(true);
        AppMethodBeat.o(242213);
        return;
      }
      if (paramInt == 8)
      {
        paramTenpaySecureEditText.setIsIdCardTailFormat(true);
        AppMethodBeat.o(242213);
        return;
      }
      paramTenpaySecureEditText.setIsCvv4PaymentFormat(false);
      AppMethodBeat.o(242213);
      return;
    }
    Log.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
    AppMethodBeat.o(242213);
  }
  
  public static void f(MMActivity paramMMActivity, final WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(73136);
    paramWalletFormView.setOnClickListener(new View.OnClickListener()
    {
      int agVG = -1;
      int year = -1;
      
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(73132);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/formview/FormViewUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        b.this.hideVKB();
        if ((b.this instanceof WalletBaseUI)) {
          ((WalletBaseUI)b.this).hideTenpayKB();
        }
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(b.this);
        paramAnonymousView.bP(true, false);
        paramAnonymousView.agjU = new a.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(73131);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean)
            {
              localObject = paramAnonymousView.jIy();
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
              b.1.this.agVG = (Util.safeParseInt(arrayOfString[1]) - 1);
              Log.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(b.1.this.agVG) });
              if ((paramAnonymous2Int1 >= b.agUD) || (b.1.this.agVG >= b.agUE)) {
                break label222;
              }
              k.c(b.this, b.this.getString(a.i.wallet_err_expired_date), null, true);
              if (b.1.this.agVs.getInputValidChangeListener() != null) {
                b.1.this.agVs.getInputValidChangeListener().onInputValidChange(b.1.this.agVs.bZp());
              }
            }
            AppMethodBeat.o(73131);
            return;
            label222:
            Object localObject = new DecimalFormat("00");
            if (z.bBi()) {
              b.1.this.agVs.setTag(((DecimalFormat)localObject).format(b.1.this.agVG + 1) + paramAnonymous2Int1);
            }
            for (;;)
            {
              b.1.this.agVs.setText(((DecimalFormat)localObject).format(b.1.this.agVG + 1) + ((DecimalFormat)localObject).format(paramAnonymous2Int1).substring(2));
              break;
              b.1.this.agVs.setTag(((DecimalFormat)localObject).format(paramAnonymous2Int1).substring(2) + ((DecimalFormat)localObject).format(b.1.this.agVG + 1));
            }
          }
        };
        if ((this.year >= b.agUD) && (this.agVG >= b.agUE)) {
          paramAnonymousView.bC(this.year, this.agVG + 1, 1);
        }
        for (;;)
        {
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/FormViewUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73132);
          return;
          localObject = Calendar.getInstance();
          paramAnonymousView.bC(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
        }
      }
    });
    AppMethodBeat.o(73136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.b
 * JD-Core Version:    0.7.0.1
 */