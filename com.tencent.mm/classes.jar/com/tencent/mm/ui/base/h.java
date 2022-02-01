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
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
@JgClassChecked(author=20, fComment="checked", lastDate="201400504", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class h
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
  
  public static Dialog a(Context paramContext, String paramString, String[] paramArrayOfString, h.d paramd)
  {
    AppMethodBeat.i(141831);
    paramContext = d(paramContext, paramString, paramArrayOfString, null, paramd);
    AppMethodBeat.o(141831);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, h.d paramd)
  {
    AppMethodBeat.i(141832);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramd);
    AppMethodBeat.o(141832);
    return paramContext;
  }
  
  public static s a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141826);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141826);
      return null;
    }
    ac.activateBroadcast(true);
    paramString = s.b(paramContext, paramString, paramBoolean, paramInt1, paramInt2, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(199339);
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)this.Wiu.get();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        ac.activateBroadcast(false);
        AppMethodBeat.o(199339);
      }
    });
    a(paramContext, paramString);
    AppMethodBeat.o(141826);
    return paramString;
  }
  
  public static s a(Context paramContext, int paramInt, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141825);
    paramContext = a(paramContext, paramInt, -1, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(141825);
    return paramContext;
  }
  
  public static s a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141823);
    paramContext = a(paramContext, 0, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(141823);
    return paramContext;
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141808);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141808);
      return null;
    }
    d.a locala = new d.a(paramContext);
    if (paramInt2 != 0) {
      locala.ayc(paramInt2);
    }
    locala.ayg(paramInt1);
    locala.ayj(paramInt3).c(paramOnClickListener1);
    locala.ayk(paramInt4).d(paramOnClickListener2);
    locala.f(new h.8(paramOnClickListener2));
    paramOnClickListener1 = locala.icu();
    paramOnClickListener1.show();
    a(paramContext, paramOnClickListener1);
    AppMethodBeat.o(141808);
    return paramOnClickListener1;
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141806);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = com.tencent.mm.cj.e.bb(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label67;
      }
    }
    label67:
    for (String str2 = com.tencent.mm.cj.e.bb(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, com.tencent.mm.cj.e.bb(paramContext, paramInt3), com.tencent.mm.cj.e.bb(paramContext, paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2);
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
      str1 = com.tencent.mm.cj.e.bb(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label69;
      }
    }
    label69:
    for (String str2 = com.tencent.mm.cj.e.bb(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, com.tencent.mm.cj.e.bb(paramContext, paramInt3), com.tencent.mm.cj.e.bb(paramContext, paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2, paramInt5);
      AppMethodBeat.o(141807);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(191552);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(191552);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.ayc(paramInt1);
    locala.ayg(-1);
    locala.iI(paramView);
    locala.ayj(paramInt2).c(paramOnClickListener1);
    locala.ayk(paramInt3).d(paramOnClickListener2);
    locala.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(220928);
        if (this.QaB != null) {
          this.QaB.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(220928);
      }
    });
    paramView = locala.icu();
    paramView.show();
    a(paramContext, paramView);
    AppMethodBeat.o(191552);
    return paramView;
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
    paramContext = a(paramContext, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141804);
    return paramContext;
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt3)
  {
    AppMethodBeat.i(191486);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = com.tencent.mm.cj.e.bb(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label55;
      }
    }
    label55:
    for (String str2 = com.tencent.mm.cj.e.bb(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramOnClickListener1, paramOnClickListener2, paramInt3);
      AppMethodBeat.o(191486);
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
      locala.bBc(com.tencent.mm.cj.e.kt(paramContext).getString(paramInt2));
    }
    locala.bBd(com.tencent.mm.cj.e.kt(paramContext).getString(paramInt1));
    locala.ayj(a.k.app_ok).c(paramOnClickListener);
    locala.HG(paramBoolean);
    paramOnClickListener = locala.icu();
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
    locala.bBc(paramString);
    locala.iI(paramView);
    locala.ayj(a.k.app_ok).c(paramOnClickListener);
    paramString = locala.icu();
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
    locala.bBc(paramString);
    locala.bBd(null);
    locala.iI(paramView);
    locala.ayj(a.k.app_ok).c(paramOnClickListener1);
    locala.ayk(a.k.app_cancel).d(paramOnClickListener2);
    locala.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(203715);
        if (this.QaB != null) {
          this.QaB.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(203715);
      }
    });
    paramString = locala.icu();
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.ayj(a.k.app_ok).c(paramOnClickListener);
    locala.f(paramOnCancelListener);
    paramString1 = locala.icu();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141822);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141800);
    paramContext = a(paramContext, paramString1, paramString2, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141800);
    return paramContext;
  }
  
  private static d a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(191460);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(191460);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.ayj(a.k.app_ok).c(paramOnClickListener1);
    locala.ayk(a.k.app_cancel).d(paramOnClickListener2);
    paramString1 = locala.icu();
    if (paramInt > 0) {
      paramString1.asd(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(191460);
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.a(paramOnDismissListener);
    locala.HG(false);
    locala.ayj(a.k.app_ok).c(new h.7());
    paramString1 = locala.icu();
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
    locala.bBc(paramString1);
    locala.iI(paramView);
    locala.bBj(paramString2).c(paramOnClickListener);
    paramString1 = locala.icu();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141817);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(191541);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(191541);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.bBc(paramString1);
    locala.bBd(null);
    locala.iI(paramView);
    locala.bBj(paramString2).c(paramOnClickListener1);
    locala.ayk(a.k.app_cancel).d(paramOnClickListener2);
    locala.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(141778);
        if (this.QaB != null) {
          this.QaB.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(141778);
      }
    });
    paramString1 = locala.icu();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(191541);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb)
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.bBj(paramString3).c(paramOnClickListener1);
    locala.bBk(paramString4).d(paramOnClickListener2);
    paramString1 = locala.icu();
    paramString1.asd(paramContext.getResources().getColor(paramInt));
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.bBj(paramString3).c(paramOnClickListener1);
    locala.bBk(paramString4).d(paramOnClickListener2);
    locala.HG(paramBoolean);
    paramString1 = locala.icu();
    if (paramInt > 0) {
      paramString1.asd(paramContext.getResources().getColor(paramInt));
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.bBj(paramString3).c(paramOnClickListener);
    locala.HG(paramBoolean);
    paramString1 = locala.icu();
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.ayj(a.k.app_ok).c(paramOnClickListener);
    locala.HG(paramBoolean);
    paramString1 = locala.icu();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141797);
    return paramString1;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141801);
    paramContext = b(paramContext, paramString1, paramString2, paramBoolean, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(141801);
    return paramContext;
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
      Log.w("MicroMsg.MMAlert", "show switch alert fail");
      AppMethodBeat.o(141821);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.HG(false);
    locala.ayk(a.k.app_cancel);
    locala.bBc(paramString);
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
          AppMethodBeat.i(223191);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          a.c("com/tencent/mm/ui/base/MMAlert$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          int i = 0;
          while (i < this.Jgk.getChildCount())
          {
            localObject = (TextView)this.Jgk.getChildAt(i);
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
              AppMethodBeat.i(201244);
              ((Dialog)h.14.this.Jgk.getTag()).dismiss();
              if (h.14.this.WiA != null) {
                h.14.this.WiA.abY(this.WiB);
              }
              AppMethodBeat.o(201244);
            }
          });
          a.a(this, "com/tencent/mm/ui/base/MMAlert$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223191);
        }
      });
      i -= 1;
    }
    locala.iI(localView);
    paramList = locala.icu();
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
    locala.bBc(paramString1);
    locala.iI(paramView);
    locala.bBj(paramString2).c(paramOnClickListener1);
    locala.bBk(paramString3).d(paramOnClickListener2);
    locala.HG(paramBoolean);
    paramString1 = locala.icu();
    if (paramInt > 0) {
      paramString1.asd(paramContext.getResources().getColor(paramInt));
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.bBj(paramString3).c(paramOnClickListener1);
    locala.bBk(paramString4).d(paramOnClickListener2);
    locala.HG(paramBoolean);
    paramString1 = locala.icu();
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.bBj(paramString3).c(paramOnClickListener1);
    locala.bBk(paramString4).d(paramOnClickListener2);
    locala.HG(paramBoolean);
    paramString1 = locala.icu();
    if (paramInt1 > 0) {
      paramString1.asd(paramContext.getResources().getColor(paramInt1));
    }
    if (paramInt2 > 0) {
      paramString1.ase(paramContext.getResources().getColor(paramInt2));
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
  
  public static d af(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(293118);
    paramContext = c(paramContext, paramString1, paramString2, true);
    AppMethodBeat.o(293118);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, e parame)
  {
    AppMethodBeat.i(141828);
    paramContext = c(paramContext, paramString1, paramList, paramList1, paramString2, parame);
    AppMethodBeat.o(141828);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, h.d paramd)
  {
    AppMethodBeat.i(141833);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramd);
    AppMethodBeat.o(141833);
    return paramContext;
  }
  
  public static s b(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(191568);
    paramContext = a(paramContext, 2, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(191568);
    return paramContext;
  }
  
  public static d b(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(191490);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = com.tencent.mm.cj.e.bb(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label56;
      }
    }
    label56:
    for (String str2 = com.tencent.mm.cj.e.bb(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, false, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(191490);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  private static d b(final Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb)
  {
    AppMethodBeat.i(141820);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141820);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.HG(false);
    locala.HH(true);
    locala.ayk(a.k.app_cancel).d(null);
    locala.bBc(paramString1);
    paramString1 = View.inflate(paramContext, a.h.mm_alert_input, null);
    final MMEditText localMMEditText = (MMEditText)paramString1.findViewById(a.g.edittext);
    if (!Util.isNullOrNil(paramString2)) {
      localMMEditText.bBa(paramString2);
    }
    paramString2 = (TextView)paramString1.findViewById(a.g.tips_tv);
    if (Util.isNullOrNil(paramString3)) {
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      locala.ayj(a.k.app_ok).a(false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(224036);
          boolean bool = true;
          if (this.PeQ != null) {
            bool = this.PeQ.onFinish(localMMEditText.getText().toString().trim());
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
                  ((MMActivity)h.12.this.val$context).hideVKB();
                  AppMethodBeat.o(141782);
                }
              });
            }
          }
          AppMethodBeat.o(224036);
        }
      });
      if (paramInt > 0) {
        com.tencent.mm.ui.tools.b.c.i(localMMEditText).axx(paramInt).a(null);
      }
      locala.iI(paramString1);
      paramString2 = locala.icu();
      paramString2.show();
      a(paramContext, paramString2);
      if ((paramContext instanceof MMActivity)) {
        paramString1.post(new h.13(paramContext));
      }
      AppMethodBeat.o(141820);
      return paramString2;
      paramString2.setText(paramString3);
    }
  }
  
  private static d b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(191471);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(191471);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.ayj(a.k.app_ok).c(paramOnClickListener1);
    locala.ayk(a.k.app_cancel).d(paramOnClickListener2);
    locala.HG(paramBoolean);
    paramString1 = locala.icu();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(191471);
    return paramString1;
  }
  
  @Deprecated
  private static Dialog c(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, e parame)
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
    paramContext = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext.ODT = new h.3(paramString1, (List)localObject, paramList1, paramString2);
    paramContext.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(141775);
        if (this.Wiw != null) {
          this.Wiw.cS(paramAnonymousInt, paramAnonymousMenuItem.getItemId());
        }
        AppMethodBeat.o(141775);
      }
    };
    paramContext.eik();
    AppMethodBeat.o(141830);
    return null;
  }
  
  public static Dialog c(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, h.d paramd)
  {
    AppMethodBeat.i(141834);
    paramContext = d(paramContext, paramString1, paramArrayOfString, paramString2, paramd);
    AppMethodBeat.o(141834);
    return paramContext;
  }
  
  public static d c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141809);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141809);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.bBj(paramString3).c(paramOnClickListener1);
    locala.bBk(paramString4).d(paramOnClickListener2);
    paramString1 = locala.icu();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141809);
    return paramString1;
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
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.HG(paramBoolean);
    locala.ayj(a.k.app_ok).c(new h.1());
    paramString1 = locala.icu();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141792);
    return paramString1;
  }
  
  public static Toast cL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(293117);
    paramContext = cO(paramContext, paramString);
    AppMethodBeat.o(293117);
    return paramContext;
  }
  
  public static Toast cM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141788);
    paramContext = cO(paramContext, paramString);
    AppMethodBeat.o(141788);
    return paramContext;
  }
  
  public static void cN(Context paramContext, String paramString)
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
  
  public static Toast cO(Context paramContext, String paramString)
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
  private static Dialog d(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, h.d paramd)
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
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      Collections.addAll(localArrayList, paramArrayOfString);
    }
    if (!Util.isNullOrNil(paramString2)) {
      localArrayList.add(paramString2);
    }
    paramContext = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext.ODT = new h.5(paramString1, localArrayList);
    paramContext.ODU = new h.6(paramd);
    paramContext.eik();
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
  
  public static d p(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141793);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = com.tencent.mm.cj.e.bb(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label50;
      }
    }
    label50:
    for (String str2 = com.tencent.mm.cj.e.bb(paramContext, paramInt2);; str2 = "")
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
    public abstract void abY(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void addDialog(Dialog paramDialog);
  }
  
  public static abstract interface e
  {
    public abstract void cS(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.h
 * JD-Core Version:    0.7.0.1
 */