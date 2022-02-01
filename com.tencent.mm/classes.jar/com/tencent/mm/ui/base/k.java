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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.ce.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
public final class k
{
  public static Dialog a(Context paramContext, String paramString, List<String> paramList, List<Integer> paramList1, e parame)
  {
    AppMethodBeat.i(141829);
    paramContext = c(paramContext, paramString, paramList, paramList1, null, parame);
    AppMethodBeat.o(141829);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, e parame)
  {
    AppMethodBeat.i(141827);
    paramContext = c(paramContext, paramString1, paramList, paramList1, paramString2, parame);
    AppMethodBeat.o(141827);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, String[] paramArrayOfString, d paramd)
  {
    AppMethodBeat.i(141831);
    paramContext = d(paramContext, paramString, paramArrayOfString, null, paramd);
    AppMethodBeat.o(141831);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, d paramd)
  {
    AppMethodBeat.i(141832);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramd);
    AppMethodBeat.o(141832);
    return paramContext;
  }
  
  public static w a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141826);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141826);
      return null;
    }
    ag.activateBroadcast(true);
    paramString = w.b(paramContext, paramString, paramBoolean, paramInt1, paramInt2, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(251459);
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)k.this.get();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        ag.activateBroadcast(false);
        AppMethodBeat.o(251459);
      }
    });
    a(paramContext, paramString);
    AppMethodBeat.o(141826);
    return paramString;
  }
  
  public static w a(Context paramContext, int paramInt, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141825);
    paramContext = a(paramContext, paramInt, -1, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(141825);
    return paramContext;
  }
  
  public static w a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141823);
    paramContext = a(paramContext, 0, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(141823);
    return paramContext;
  }
  
  public static e a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141808);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141808);
      return null;
    }
    e.a locala = new e.a(paramContext);
    if (paramInt2 != 0) {
      locala.aEK(paramInt2);
    }
    locala.aEO(paramInt1);
    locala.aER(paramInt3).c(paramOnClickListener1);
    locala.aES(paramInt4).d(paramOnClickListener2);
    locala.e(new k.8(paramOnClickListener2));
    paramOnClickListener1 = locala.jHH();
    paramOnClickListener1.show();
    a(paramContext, paramOnClickListener1);
    AppMethodBeat.o(141808);
    return paramOnClickListener1;
  }
  
  public static e a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141806);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = g.bu(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label67;
      }
    }
    label67:
    for (String str2 = g.bu(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, g.bu(paramContext, paramInt3), g.bu(paramContext, paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(141806);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static e a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt5)
  {
    AppMethodBeat.i(141807);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = g.bu(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label69;
      }
    }
    label69:
    for (String str2 = g.bu(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, g.bu(paramContext, paramInt3), g.bu(paramContext, paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2, paramInt5);
      AppMethodBeat.o(141807);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static e a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141794);
    paramContext = a(paramContext, paramInt1, paramInt2, true, paramOnClickListener);
    AppMethodBeat.o(141794);
    return paramContext;
  }
  
  public static e a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141804);
    paramContext = a(paramContext, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141804);
    return paramContext;
  }
  
  public static e a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt3)
  {
    AppMethodBeat.i(251417);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = g.bu(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label55;
      }
    }
    label55:
    for (String str2 = g.bu(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramOnClickListener1, paramOnClickListener2, paramInt3);
      AppMethodBeat.o(251417);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static e a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141795);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141795);
      return null;
    }
    e.a locala = new e.a(paramContext);
    if (paramInt2 > 0) {
      locala.bDv(g.mv(paramContext).getString(paramInt2));
    }
    locala.bDw(g.mv(paramContext).getString(paramInt1));
    locala.aER(a.k.app_ok).c(paramOnClickListener);
    locala.NC(paramBoolean);
    paramOnClickListener = locala.jHH();
    paramOnClickListener.show();
    a(paramContext, paramOnClickListener);
    AppMethodBeat.o(141795);
    return paramOnClickListener;
  }
  
  public static e a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141813);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141813);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString);
    locala.md(paramView);
    locala.aER(a.k.app_ok).c(paramOnClickListener);
    paramString = locala.jHH();
    paramString.show();
    a(paramContext, paramString);
    AppMethodBeat.o(141813);
    return paramString;
  }
  
  public static e a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141818);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141818);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString);
    locala.bDw(null);
    locala.md(paramView);
    locala.aER(a.k.app_ok).c(paramOnClickListener1);
    locala.aES(a.k.app_cancel).d(paramOnClickListener2);
    locala.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(251309);
        if (k.this != null) {
          k.this.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(251309);
      }
    });
    paramString = locala.jHH();
    paramString.show();
    a(paramContext, paramString);
    AppMethodBeat.o(141818);
    return paramString;
  }
  
  public static e a(Context paramContext, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141814);
    paramContext = a(paramContext, true, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(141814);
    return paramContext;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141822);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141822);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.aER(a.k.app_ok).c(paramOnClickListener);
    locala.e(paramOnCancelListener);
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141822);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141800);
    paramContext = a(paramContext, paramString1, paramString2, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141800);
    return paramContext;
  }
  
  private static e a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(251405);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(251405);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.aER(a.k.app_ok).c(paramOnClickListener1);
    locala.aES(a.k.app_cancel).d(paramOnClickListener2);
    paramString1 = locala.jHH();
    if (paramInt > 0) {
      paramString1.ayi(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(251405);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(164147);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(164147);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.c(paramOnDismissListener);
    locala.NC(false);
    locala.aER(a.k.app_ok).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(141776);
        paramAnonymousDialogInterface.cancel();
        AppMethodBeat.o(141776);
      }
    });
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(164147);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141817);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141817);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString1);
    locala.md(paramView);
    locala.bDC(paramString2).c(paramOnClickListener);
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141817);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(251427);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(251427);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString1);
    locala.bDw(null);
    locala.md(paramView);
    locala.bDC(paramString2).c(paramOnClickListener1);
    locala.aES(a.k.app_cancel).d(paramOnClickListener2);
    locala.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(141778);
        if (k.this != null) {
          k.this.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(141778);
      }
    });
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(251427);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, b paramb)
  {
    AppMethodBeat.i(141819);
    paramContext = b(paramContext, paramString1, paramString2, paramString3, paramInt, paramb);
    AppMethodBeat.o(141819);
    return paramContext;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141798);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, true, paramOnClickListener);
    AppMethodBeat.o(141798);
    return paramContext;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, b paramb)
  {
    AppMethodBeat.i(251432);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, -1, paramb);
    AppMethodBeat.o(251432);
    return paramContext;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(141810);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141810);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.bDC(paramString3).c(paramOnClickListener1);
    locala.bDD(paramString4).d(paramOnClickListener2);
    paramString1 = locala.jHH();
    paramString1.ayi(paramContext.getResources().getColor(paramInt));
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141810);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141802);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141802);
    return paramContext;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(141803);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141803);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.bDC(paramString3).c(paramOnClickListener1);
    locala.bDD(paramString4).d(paramOnClickListener2);
    locala.NC(paramBoolean);
    paramString1 = locala.jHH();
    if (paramInt > 0) {
      paramString1.ayi(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141803);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141799);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141799);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.bDC(paramString3).c(paramOnClickListener);
    locala.NC(paramBoolean);
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141799);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141797);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141797);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.aER(a.k.app_ok).c(paramOnClickListener);
    locala.NC(paramBoolean);
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141797);
    return paramString1;
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141801);
    paramContext = b(paramContext, paramString1, paramString2, paramBoolean, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(141801);
    return paramContext;
  }
  
  public static e a(Context paramContext, String paramString, List<String> paramList, int paramInt, final a parama)
  {
    AppMethodBeat.i(141821);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141821);
      return null;
    }
    if (paramList.isEmpty())
    {
      Log.w("MicroMsg.MMAlert", "show switch alert fail");
      AppMethodBeat.o(141821);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.NC(false);
    locala.aES(a.k.app_cancel);
    locala.bDv(paramString);
    View localView = View.inflate(paramContext, a.h.mm_alert_switch, null);
    paramString = (LinearLayout)localView.findViewById(a.g.switcher_container);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      TextView localTextView = (TextView)View.inflate(paramContext, a.h.radio_btn_item, null);
      localTextView.setText((CharSequence)paramList.get(i));
      if (i == paramInt) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(a.j.radio_on, 0, 0, 0);
      }
      if (i == paramList.size() - 1)
      {
        paramContext.getResources().getDimensionPixelSize(a.e.NormalPadding);
        localTextView.setBackgroundResource(a.f.submenu_item_selector_no_divider);
      }
      localTextView.setTag(Integer.valueOf(i));
      paramString.addView(localTextView, 0);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251313);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/base/MMAlert$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          int i = 0;
          while (i < k.this.getChildCount())
          {
            localObject = (TextView)k.this.getChildAt(i);
            if (((TextView)localObject).getId() != a.g.tips_tv) {
              ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(a.j.radio_off, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(a.j.radio_on, 0, 0, 0);
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(251338);
              ((Dialog)k.this.getTag()).dismiss();
              if (k.14.this.adPB != null) {
                k.14.this.adPB.agm(this.adPC);
              }
              AppMethodBeat.o(251338);
            }
          });
          a.a(this, "com/tencent/mm/ui/base/MMAlert$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251313);
        }
      });
      i -= 1;
    }
    locala.md(localView);
    paramList = locala.jHH();
    paramString.setTag(paramList);
    paramList.show();
    a(paramContext, paramList);
    AppMethodBeat.o(141821);
    return paramList;
  }
  
  public static e a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141815);
    paramContext = a(paramContext, paramBoolean, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141815);
    return paramContext;
  }
  
  public static e a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(141816);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141816);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString1);
    locala.md(paramView);
    locala.bDC(paramString2).c(paramOnClickListener1);
    locala.bDD(paramString3).d(paramOnClickListener2);
    locala.NC(paramBoolean);
    paramString1 = locala.jHH();
    if (paramInt > 0) {
      paramString1.ayi(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141816);
    return paramString1;
  }
  
  public static e a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141811);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141811);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.bDC(paramString3).c(paramOnClickListener1);
    locala.bDD(paramString4).d(paramOnClickListener2);
    locala.NC(paramBoolean);
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141811);
    return paramString1;
  }
  
  public static e a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141812);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141812);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.bDC(paramString3).c(paramOnClickListener1);
    locala.bDD(paramString4).d(paramOnClickListener2);
    locala.NC(paramBoolean);
    paramString1 = locala.jHH();
    if (paramInt1 > 0) {
      paramString1.ayi(paramContext.getResources().getColor(paramInt1));
    }
    if (paramInt2 > 0) {
      paramString1.ayj(paramContext.getResources().getColor(paramInt2));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141812);
    return paramString1;
  }
  
  public static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(141786);
    if ((paramContext instanceof c))
    {
      ((c)paramContext).addDialog(paramDialog);
      if ((paramContext instanceof d))
      {
        if ((paramDialog instanceof e))
        {
          ((e)paramDialog).iOnDialogDismissListener = ((d)paramContext);
          AppMethodBeat.o(141786);
          return;
        }
        if ((paramDialog instanceof i)) {
          ((i)paramDialog).setiOnDialogDismissListener((d)paramContext);
        }
      }
    }
    AppMethodBeat.o(141786);
  }
  
  public static e ak(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(369635);
    paramContext = c(paramContext, paramString1, paramString2, true);
    AppMethodBeat.o(369635);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, e parame)
  {
    AppMethodBeat.i(141828);
    paramContext = c(paramContext, paramString1, paramList, paramList1, paramString2, parame);
    AppMethodBeat.o(141828);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, d paramd)
  {
    AppMethodBeat.i(141833);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramd);
    AppMethodBeat.o(141833);
    return paramContext;
  }
  
  public static w b(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(251442);
    paramContext = a(paramContext, 2, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(251442);
    return paramContext;
  }
  
  public static e b(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(251421);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = g.bu(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label56;
      }
    }
    label56:
    for (String str2 = g.bu(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, false, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(251421);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  private static e b(final Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, b paramb)
  {
    AppMethodBeat.i(141820);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141820);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.NC(false);
    locala.ND(true);
    locala.aES(a.k.app_cancel).d(null);
    locala.bDv(paramString1);
    paramString1 = View.inflate(paramContext, a.h.mm_alert_input, null);
    final MMEditText localMMEditText = (MMEditText)paramString1.findViewById(a.g.edittext);
    if (!Util.isNullOrNil(paramString2)) {
      localMMEditText.bDt(paramString2);
    }
    paramString2 = (TextView)paramString1.findViewById(a.g.tips_tv);
    if (Util.isNullOrNil(paramString3)) {
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      locala.aER(a.k.app_ok).a(false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(251311);
          boolean bool = true;
          if (k.this != null) {
            bool = k.this.onFinish(localMMEditText.getText().toString().trim());
          }
          if (bool)
          {
            paramAnonymousDialogInterface.dismiss();
            if ((paramContext instanceof MMActivity)) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(141782);
                  ((MMActivity)k.12.this.val$context).hideVKB();
                  AppMethodBeat.o(141782);
                }
              });
            }
          }
          AppMethodBeat.o(251311);
        }
      });
      if (paramInt > 0) {
        c.i(localMMEditText).aEg(paramInt).a(null);
      }
      locala.md(paramString1);
      paramString2 = locala.jHH();
      paramString2.show();
      a(paramContext, paramString2);
      if ((paramContext instanceof MMActivity)) {
        paramString1.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(251316);
            ((MMActivity)k.this).showVKB();
            AppMethodBeat.o(251316);
          }
        });
      }
      AppMethodBeat.o(141820);
      return paramString2;
      paramString2.setText(paramString3);
    }
  }
  
  public static e b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141809);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141809);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.bDC(paramString3).c(paramOnClickListener1);
    locala.bDD(paramString4).d(paramOnClickListener2);
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141809);
    return paramString1;
  }
  
  private static e b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(251411);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(251411);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.aER(a.k.app_ok).c(paramOnClickListener1);
    locala.aES(a.k.app_cancel).d(paramOnClickListener2);
    locala.NC(paramBoolean);
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(251411);
    return paramString1;
  }
  
  @Deprecated
  private static Dialog c(Context paramContext, String paramString1, List<String> paramList, final List<Integer> paramList1, final String paramString2, e parame)
  {
    AppMethodBeat.i(141830);
    if (((paramList == null) || (paramList.size() == 0)) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(141830);
      return null;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramContext = new f(paramContext, 1, false);
    paramContext.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(141774);
        if (!Util.isNullOrNil(k.this)) {
          paramAnonymouss.setHeaderTitle(k.this);
        }
        int i = 0;
        while (i < this.adPu.size())
        {
          paramAnonymouss.c(((Integer)paramList1.get(i)).intValue(), (CharSequence)this.adPu.get(i));
          i += 1;
        }
        if (!Util.isNullOrNil(paramString2)) {
          paramAnonymouss.c(-1, paramString2);
        }
        AppMethodBeat.o(141774);
      }
    };
    paramContext.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(141775);
        if (k.this != null) {
          k.this.onClick(paramAnonymousInt, paramAnonymousMenuItem.getItemId());
        }
        AppMethodBeat.o(141775);
      }
    };
    paramContext.dDn();
    AppMethodBeat.o(141830);
    return null;
  }
  
  public static Dialog c(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, d paramd)
  {
    AppMethodBeat.i(141834);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramd);
    AppMethodBeat.o(141834);
    return paramContext;
  }
  
  public static e c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(251425);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(251425);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.bDC(paramString3).c(null);
    locala.bDD(paramString4).d(null);
    locala.jHG();
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(251425);
    return paramString1;
  }
  
  public static e c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(141792);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141792);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.NC(paramBoolean);
    locala.aER(a.k.app_ok).c(new k.1());
    paramString1 = locala.jHH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141792);
    return paramString1;
  }
  
  public static Toast cW(Context paramContext, String paramString)
  {
    AppMethodBeat.i(369634);
    paramContext = cZ(paramContext, paramString);
    AppMethodBeat.o(369634);
    return paramContext;
  }
  
  public static Toast cX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141788);
    paramContext = cZ(paramContext, paramString);
    AppMethodBeat.o(141788);
    return paramContext;
  }
  
  public static void cY(Context paramContext, String paramString)
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
  
  public static Toast cZ(Context paramContext, String paramString)
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
  private static Dialog d(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, d paramd)
  {
    AppMethodBeat.i(141835);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141835);
      return null;
    }
    if (((paramArrayOfString == null) || (paramArrayOfString.length == 0)) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(141835);
      return null;
    }
    final ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      Collections.addAll(localArrayList, paramArrayOfString);
    }
    if (!Util.isNullOrNil(paramString2)) {
      localArrayList.add(paramString2);
    }
    paramContext = new f(paramContext, 1, false);
    paramContext.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(251479);
        paramAnonymouss.setHeaderTitle(k.this);
        int i = 0;
        while (i < localArrayList.size())
        {
          paramAnonymouss.c(i, (CharSequence)localArrayList.get(i));
          i += 1;
        }
        AppMethodBeat.o(251479);
      }
    };
    paramContext.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(251476);
        if (k.this != null) {
          k.this.qz(paramAnonymousMenuItem.getItemId());
        }
        AppMethodBeat.o(251476);
      }
    };
    paramContext.dDn();
    AppMethodBeat.o(141835);
    return null;
  }
  
  public static e d(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141796);
    paramContext = a(paramContext, paramString1, paramString2, true, paramOnClickListener);
    AppMethodBeat.o(141796);
    return paramContext;
  }
  
  public static e s(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141793);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = g.bu(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label50;
      }
    }
    label50:
    for (String str2 = g.bu(paramContext, paramInt2);; str2 = "")
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
    public abstract void agm(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean onFinish(CharSequence paramCharSequence);
  }
  
  public static abstract interface c
  {
    public abstract void addDialog(Dialog paramDialog);
  }
  
  public static abstract interface d
  {
    public abstract void qz(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void onClick(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.k
 * JD-Core Version:    0.7.0.1
 */