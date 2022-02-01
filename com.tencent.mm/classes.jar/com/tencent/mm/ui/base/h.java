package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
@JgClassChecked(author=20, fComment="checked", lastDate="201400504", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class h
{
  public static d Q(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210323);
    paramContext = c(paramContext, paramString1, paramString2, true);
    AppMethodBeat.o(210323);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, List<String> paramList, List<Integer> paramList1, d paramd)
  {
    AppMethodBeat.i(141829);
    paramContext = c(paramContext, paramString, paramList, paramList1, null, paramd);
    AppMethodBeat.o(141829);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, d paramd)
  {
    AppMethodBeat.i(141827);
    paramContext = c(paramContext, paramString1, paramList, paramList1, paramString2, paramd);
    AppMethodBeat.o(141827);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, String[] paramArrayOfString, c paramc)
  {
    AppMethodBeat.i(141831);
    paramContext = d(paramContext, paramString, paramArrayOfString, null, paramc);
    AppMethodBeat.o(141831);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, c paramc)
  {
    AppMethodBeat.i(141832);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramc);
    AppMethodBeat.o(141832);
    return paramContext;
  }
  
  public static p a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141826);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141826);
      return null;
    }
    y.activateBroadcast(true);
    paramString = p.b(paramContext, paramString, paramBoolean, paramInt1, paramInt2, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(141784);
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)this.HvY.get();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        y.activateBroadcast(false);
        AppMethodBeat.o(141784);
      }
    });
    a(paramContext, paramString);
    AppMethodBeat.o(141826);
    return paramString;
  }
  
  public static p a(Context paramContext, int paramInt, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141825);
    paramContext = a(paramContext, paramInt, -1, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(141825);
    return paramContext;
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141806);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label67;
      }
    }
    label67:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramContext.getString(paramInt3), paramContext.getString(paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(141806);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt5)
  {
    AppMethodBeat.i(141807);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label69;
      }
    }
    label69:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramContext.getString(paramInt3), paramContext.getString(paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2, paramInt5);
      AppMethodBeat.o(141807);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141794);
    paramContext = a(paramContext, paramInt1, paramInt2, true, paramOnClickListener);
    AppMethodBeat.o(141794);
    return paramContext;
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141804);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label53;
      }
    }
    label53:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(141804);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141795);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141795);
      return null;
    }
    d.a locala = new d.a(paramContext);
    if (paramInt2 > 0) {
      locala.acF(paramInt2);
    }
    locala.acJ(paramInt1);
    locala.acM(2131755835).b(paramOnClickListener);
    locala.yf(paramBoolean);
    paramOnClickListener = locala.fvp();
    paramOnClickListener.show();
    a(paramContext, paramOnClickListener);
    AppMethodBeat.o(141795);
    return paramOnClickListener;
  }
  
  public static d a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141813);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141813);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString);
    locala.gH(paramView);
    locala.acM(2131755835).b(paramOnClickListener);
    paramString = locala.fvp();
    paramString.show();
    a(paramContext, paramString);
    AppMethodBeat.o(141813);
    return paramString;
  }
  
  public static d a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141818);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141818);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString);
    locala.aRI(null);
    locala.gH(paramView);
    locala.acM(2131755835).b(paramOnClickListener1);
    locala.acN(2131755691).c(paramOnClickListener2);
    locala.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(141778);
        if (this.CuM != null) {
          this.CuM.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(141778);
      }
    });
    paramString = locala.fvp();
    paramString.show();
    a(paramContext, paramString);
    AppMethodBeat.o(141818);
    return paramString;
  }
  
  public static d a(Context paramContext, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141814);
    paramContext = a(paramContext, true, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(141814);
    return paramContext;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141822);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141822);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.acM(2131755835).b(paramOnClickListener);
    locala.e(paramOnCancelListener);
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141822);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141800);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141800);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.acM(2131755835).b(paramOnClickListener1);
    locala.acN(2131755691).c(paramOnClickListener2);
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141800);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(164147);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(164147);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.a(paramOnDismissListener);
    locala.yf(false);
    locala.acM(2131755835).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(141776);
        paramAnonymousDialogInterface.cancel();
        AppMethodBeat.o(141776);
      }
    });
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(164147);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141817);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141817);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString1);
    locala.gH(paramView);
    locala.aRO(paramString2).b(paramOnClickListener);
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141817);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, b paramb)
  {
    AppMethodBeat.i(141819);
    paramContext = b(paramContext, paramString1, paramString2, paramString3, paramInt, paramb);
    AppMethodBeat.o(141819);
    return paramContext;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141798);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, true, paramOnClickListener);
    AppMethodBeat.o(141798);
    return paramContext;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(141810);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141810);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.aRO(paramString3).b(paramOnClickListener1);
    locala.aRP(paramString4).c(paramOnClickListener2);
    paramString1 = locala.fvp();
    paramString1.Yl(paramContext.getResources().getColor(paramInt));
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141810);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141802);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141802);
    return paramContext;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(141803);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141803);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.aRO(paramString3).b(paramOnClickListener1);
    locala.aRP(paramString4).c(paramOnClickListener2);
    locala.yf(paramBoolean);
    paramString1 = locala.fvp();
    if (paramInt > 0) {
      paramString1.Yl(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141803);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141799);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141799);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.aRO(paramString3).b(paramOnClickListener);
    locala.yf(paramBoolean);
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141799);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141797);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141797);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.acM(2131755835).b(paramOnClickListener);
    locala.yf(paramBoolean);
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141797);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141801);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141801);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.acM(2131755835).b(paramOnClickListener1);
    locala.acN(2131755691).c(paramOnClickListener2);
    locala.yf(paramBoolean);
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141801);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString, List<String> paramList, int paramInt, final a parama)
  {
    AppMethodBeat.i(141821);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141821);
      return null;
    }
    if (paramList.isEmpty())
    {
      ac.w("MicroMsg.MMAlert", "show switch alert fail");
      AppMethodBeat.o(141821);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.yf(false);
    locala.acN(2131755691);
    locala.aRH(paramString);
    View localView = View.inflate(paramContext, 2131494769, null);
    paramString = (LinearLayout)localView.findViewById(2131305591);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      TextView localTextView = (TextView)View.inflate(paramContext, 2131495173, null);
      localTextView.setText((CharSequence)paramList.get(i));
      if (i == paramInt) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
      }
      if (i == paramList.size() - 1)
      {
        paramContext.getResources().getDimensionPixelSize(2131165516);
        localTextView.setBackgroundResource(2131234277);
      }
      localTextView.setTag(Integer.valueOf(i));
      paramString.addView(localTextView, 0);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141783);
          int i = 0;
          while (i < this.xrd.getChildCount())
          {
            TextView localTextView = (TextView)this.xrd.getChildAt(i);
            if (localTextView.getId() != 2131305896) {
              localTextView.setCompoundDrawablesWithIntrinsicBounds(2131691077, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141782);
              ((Dialog)h.10.this.xrd.getTag()).dismiss();
              if (h.10.this.HvV != null) {
                h.10.this.HvV.LW(this.HvW);
              }
              AppMethodBeat.o(141782);
            }
          });
          AppMethodBeat.o(141783);
        }
      });
      i -= 1;
    }
    locala.gH(localView);
    paramList = locala.fvp();
    paramString.setTag(paramList);
    paramList.show();
    a(paramContext, paramList);
    AppMethodBeat.o(141821);
    return paramList;
  }
  
  public static d a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141815);
    paramContext = a(paramContext, paramBoolean, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141815);
    return paramContext;
  }
  
  public static d a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(141816);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141816);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString1);
    locala.gH(paramView);
    locala.aRO(paramString2).b(paramOnClickListener1);
    locala.aRP(paramString3).c(paramOnClickListener2);
    locala.yf(paramBoolean);
    paramString1 = locala.fvp();
    if (paramInt > 0) {
      paramString1.Yl(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141816);
    return paramString1;
  }
  
  public static d a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141811);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141811);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.aRO(paramString3).b(paramOnClickListener1);
    locala.aRP(paramString4).c(paramOnClickListener2);
    locala.yf(paramBoolean);
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141811);
    return paramString1;
  }
  
  public static d a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141812);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141812);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.aRO(paramString3).b(paramOnClickListener1);
    locala.aRP(paramString4).c(paramOnClickListener2);
    locala.yf(paramBoolean);
    paramString1 = locala.fvp();
    if (paramInt1 > 0) {
      paramString1.Yl(paramContext.getResources().getColor(paramInt1));
    }
    if (paramInt2 > 0) {
      paramString1.Ym(paramContext.getResources().getColor(paramInt2));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141812);
    return paramString1;
  }
  
  public static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(141786);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).addDialog(paramDialog);
      if ((paramContext instanceof com.tencent.mm.ui.widget.a.c))
      {
        if ((paramDialog instanceof d))
        {
          ((d)paramDialog).iOnDialogDismissListener = ((com.tencent.mm.ui.widget.a.c)paramContext);
          AppMethodBeat.o(141786);
          return;
        }
        if ((paramDialog instanceof i)) {
          ((i)paramDialog).setiOnDialogDismissListener((com.tencent.mm.ui.widget.a.c)paramContext);
        }
      }
    }
    AppMethodBeat.o(141786);
  }
  
  public static Dialog b(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, d paramd)
  {
    AppMethodBeat.i(141828);
    paramContext = c(paramContext, paramString1, paramList, paramList1, paramString2, paramd);
    AppMethodBeat.o(141828);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, c paramc)
  {
    AppMethodBeat.i(141833);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramc);
    AppMethodBeat.o(141833);
    return paramContext;
  }
  
  public static p b(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141823);
    paramContext = a(paramContext, 0, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(141823);
    return paramContext;
  }
  
  public static d b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141808);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141808);
      return null;
    }
    d.a locala = new d.a(paramContext);
    if (paramInt2 != 0) {
      locala.acF(paramInt2);
    }
    locala.acJ(paramInt1);
    locala.acM(paramInt3).b(paramOnClickListener1);
    locala.acN(paramInt4).c(paramOnClickListener2);
    locala.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(141777);
        if (this.CuM != null) {
          this.CuM.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(141777);
      }
    });
    paramOnClickListener1 = locala.fvp();
    paramOnClickListener1.show();
    a(paramContext, paramOnClickListener1);
    AppMethodBeat.o(141808);
    return paramOnClickListener1;
  }
  
  public static d b(Context paramContext, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141805);
    if (paramInt > 0) {}
    for (String str = paramContext.getString(paramInt);; str = "")
    {
      paramContext = a(paramContext, str, paramContext.getString(2131755906), false, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(141805);
      return paramContext;
    }
  }
  
  private static d b(final Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, b paramb)
  {
    AppMethodBeat.i(141820);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141820);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.yf(false);
    locala.yg(true);
    locala.acN(2131755691).c(null);
    locala.aRH(paramString1);
    paramString1 = View.inflate(paramContext, 2131494768, null);
    final MMEditText localMMEditText = (MMEditText)paramString1.findViewById(2131299306);
    if (!bs.isNullOrNil(paramString2)) {
      localMMEditText.aRF(paramString2);
    }
    paramString2 = (TextView)paramString1.findViewById(2131305896);
    if (bs.isNullOrNil(paramString3)) {
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      locala.acM(2131755835).a(false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(141780);
          boolean bool = true;
          if (this.BLq != null) {
            bool = this.BLq.onFinish(localMMEditText.getText().toString().trim());
          }
          if (bool)
          {
            paramAnonymousDialogInterface.dismiss();
            if ((paramContext instanceof MMActivity)) {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(141779);
                  ((MMActivity)h.8.this.val$context).hideVKB();
                  AppMethodBeat.o(141779);
                }
              });
            }
          }
          AppMethodBeat.o(141780);
        }
      });
      if (paramInt > 0) {
        com.tencent.mm.ui.tools.b.c.d(localMMEditText).acw(paramInt).a(null);
      }
      locala.gH(paramString1);
      paramString2 = locala.fvp();
      paramString2.show();
      a(paramContext, paramString2);
      if ((paramContext instanceof MMActivity)) {
        paramString1.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141781);
            ((MMActivity)this.val$context).showVKB();
            AppMethodBeat.o(141781);
          }
        });
      }
      AppMethodBeat.o(141820);
      return paramString2;
      paramString2.setText(paramString3);
    }
  }
  
  @Deprecated
  private static Dialog c(Context paramContext, String paramString1, List<String> paramList, final List<Integer> paramList1, final String paramString2, d paramd)
  {
    AppMethodBeat.i(141830);
    if (((paramList == null) || (paramList.size() == 0)) && (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(141830);
      return null;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramContext = new e(paramContext, 1, false);
    paramContext.ISu = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(141785);
        if (!bs.isNullOrNil(this.cNi)) {
          paramAnonymousl.setHeaderTitle(this.cNi);
        }
        int i = 0;
        while (i < this.yAc.size())
        {
          paramAnonymousl.c(((Integer)paramList1.get(i)).intValue(), (CharSequence)this.yAc.get(i));
          i += 1;
        }
        if (!bs.isNullOrNil(paramString2)) {
          paramAnonymousl.c(-1, paramString2);
        }
        AppMethodBeat.o(141785);
      }
    };
    paramContext.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(141773);
        if (this.HvR != null) {
          this.HvR.ct(paramAnonymousInt, paramAnonymousMenuItem.getItemId());
        }
        AppMethodBeat.o(141773);
      }
    };
    paramContext.cED();
    AppMethodBeat.o(141830);
    return null;
  }
  
  public static Dialog c(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, c paramc)
  {
    AppMethodBeat.i(141834);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramc);
    AppMethodBeat.o(141834);
    return paramContext;
  }
  
  public static p c(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(197188);
    paramContext = a(paramContext, 2, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(197188);
    return paramContext;
  }
  
  public static d c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(141792);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141792);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.yf(paramBoolean);
    locala.acM(2131755835).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(141772);
        paramAnonymousDialogInterface.cancel();
        AppMethodBeat.o(141772);
      }
    });
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141792);
    return paramString1;
  }
  
  public static Toast cd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210322);
    paramContext = cg(paramContext, paramString);
    AppMethodBeat.o(210322);
    return paramContext;
  }
  
  public static Toast ce(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141788);
    paramContext = cg(paramContext, paramString);
    AppMethodBeat.o(141788);
    return paramContext;
  }
  
  public static void cf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141789);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141789);
      return;
    }
    Toast.makeText(paramContext, paramString, 0).show();
    AppMethodBeat.o(141789);
  }
  
  public static Toast cg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141790);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141790);
      return null;
    }
    paramContext = Toast.makeText(paramContext, paramString, 0);
    paramContext.show();
    AppMethodBeat.o(141790);
    return paramContext;
  }
  
  @Deprecated
  private static Dialog d(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, c paramc)
  {
    AppMethodBeat.i(141835);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141835);
      return null;
    }
    if (((paramArrayOfString == null) || (paramArrayOfString.length == 0)) && (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(141835);
      return null;
    }
    final ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      Collections.addAll(localArrayList, paramArrayOfString);
    }
    if (!bs.isNullOrNil(paramString2)) {
      localArrayList.add(paramString2);
    }
    paramContext = new e(paramContext, 1, false);
    paramContext.ISu = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(141774);
        paramAnonymousl.setHeaderTitle(this.cNi);
        int i = 0;
        while (i < localArrayList.size())
        {
          paramAnonymousl.c(i, (CharSequence)localArrayList.get(i));
          i += 1;
        }
        AppMethodBeat.o(141774);
      }
    };
    paramContext.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(141775);
        if (this.HvS != null) {
          this.HvS.kG(paramAnonymousMenuItem.getItemId());
        }
        AppMethodBeat.o(141775);
      }
    };
    paramContext.cED();
    AppMethodBeat.o(141835);
    return null;
  }
  
  public static d d(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141796);
    paramContext = a(paramContext, paramString1, paramString2, true, paramOnClickListener);
    AppMethodBeat.o(141796);
    return paramContext;
  }
  
  public static d d(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141809);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141809);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.aRO(paramString3).b(paramOnClickListener1);
    locala.aRP(paramString4).c(paramOnClickListener2);
    paramString1 = locala.fvp();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141809);
    return paramString1;
  }
  
  public static d l(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141793);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label50;
      }
    }
    label50:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = c(paramContext, str1, str2, true);
      AppMethodBeat.o(141793);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void LW(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean onFinish(CharSequence paramCharSequence);
  }
  
  public static abstract interface c
  {
    public abstract void kG(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void ct(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.h
 * JD-Core Version:    0.7.0.1
 */