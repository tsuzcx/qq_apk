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
  public static d X(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(258462);
    paramContext = c(paramContext, paramString1, paramString2, true);
    AppMethodBeat.o(258462);
    return paramContext;
  }
  
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
  
  public static q a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141826);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141826);
      return null;
    }
    aa.activateBroadcast(true);
    paramString = q.b(paramContext, paramString, paramBoolean, paramInt1, paramInt2, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(205221);
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)this.OPv.get();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        aa.activateBroadcast(false);
        AppMethodBeat.o(205221);
      }
    });
    a(paramContext, paramString);
    AppMethodBeat.o(141826);
    return paramString;
  }
  
  public static q a(Context paramContext, int paramInt, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(141825);
    paramContext = a(paramContext, paramInt, -1, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(141825);
    return paramContext;
  }
  
  public static q a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
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
      locala.aoO(paramInt2);
    }
    locala.aoS(paramInt1);
    locala.aoV(paramInt3).c(paramOnClickListener1);
    locala.aoW(paramInt4).d(paramOnClickListener2);
    locala.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(141777);
        if (this.JdC != null) {
          this.JdC.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(141777);
      }
    });
    paramOnClickListener1 = locala.hbn();
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
      str1 = com.tencent.mm.cc.e.aJ(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label67;
      }
    }
    label67:
    for (String str2 = com.tencent.mm.cc.e.aJ(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, com.tencent.mm.cc.e.aJ(paramContext, paramInt3), com.tencent.mm.cc.e.aJ(paramContext, paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2);
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
      str1 = com.tencent.mm.cc.e.aJ(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label69;
      }
    }
    label69:
    for (String str2 = com.tencent.mm.cc.e.aJ(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, com.tencent.mm.cc.e.aJ(paramContext, paramInt3), com.tencent.mm.cc.e.aJ(paramContext, paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2, paramInt5);
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
    paramContext = a(paramContext, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(141804);
    return paramContext;
  }
  
  public static d a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt3)
  {
    AppMethodBeat.i(205226);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = com.tencent.mm.cc.e.aJ(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label55;
      }
    }
    label55:
    for (String str2 = com.tencent.mm.cc.e.aJ(paramContext, paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramOnClickListener1, paramOnClickListener2, paramInt3);
      AppMethodBeat.o(205226);
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
      locala.bon(com.tencent.mm.cc.e.jp(paramContext).getString(paramInt2));
    }
    locala.boo(com.tencent.mm.cc.e.jp(paramContext).getString(paramInt1));
    locala.aoV(2131755921).c(paramOnClickListener);
    locala.Dk(paramBoolean);
    paramOnClickListener = locala.hbn();
    paramOnClickListener.show();
    a(paramContext, paramOnClickListener);
    AppMethodBeat.o(141795);
    return paramOnClickListener;
  }
  
  public static d a(Context paramContext, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(205227);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(205227);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.aoO(2131755998);
    locala.aoS(-1);
    locala.hs(paramView);
    locala.aoV(2131755921).c(paramOnClickListener1);
    locala.aoW(2131755316).d(paramOnClickListener2);
    locala.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(205215);
        if (this.JdC != null) {
          this.JdC.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(205215);
      }
    });
    paramView = locala.hbn();
    paramView.show();
    a(paramContext, paramView);
    AppMethodBeat.o(205227);
    return paramView;
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
    locala.bon(paramString);
    locala.hs(paramView);
    locala.aoV(2131755921).c(paramOnClickListener);
    paramString = locala.hbn();
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
    locala.bon(paramString);
    locala.boo(null);
    locala.hs(paramView);
    locala.aoV(2131755921).c(paramOnClickListener1);
    locala.aoW(2131755761).d(paramOnClickListener2);
    locala.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(141778);
        if (this.JdC != null) {
          this.JdC.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(141778);
      }
    });
    paramString = locala.hbn();
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.aoV(2131755921).c(paramOnClickListener);
    locala.f(paramOnCancelListener);
    paramString1 = locala.hbn();
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
    AppMethodBeat.i(205224);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(205224);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.aoV(2131755921).c(paramOnClickListener1);
    locala.aoW(2131755761).d(paramOnClickListener2);
    paramString1 = locala.hbn();
    if (paramInt > 0) {
      paramString1.ajL(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(205224);
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.a(paramOnDismissListener);
    locala.Dk(false);
    locala.aoV(2131755921).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(141776);
        paramAnonymousDialogInterface.cancel();
        AppMethodBeat.o(141776);
      }
    });
    paramString1 = locala.hbn();
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
    locala.bon(paramString1);
    locala.hs(paramView);
    locala.bou(paramString2).c(paramOnClickListener);
    paramString1 = locala.hbn();
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.bou(paramString3).c(paramOnClickListener1);
    locala.bov(paramString4).d(paramOnClickListener2);
    paramString1 = locala.hbn();
    paramString1.ajL(paramContext.getResources().getColor(paramInt));
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.bou(paramString3).c(paramOnClickListener1);
    locala.bov(paramString4).d(paramOnClickListener2);
    locala.Dk(paramBoolean);
    paramString1 = locala.hbn();
    if (paramInt > 0) {
      paramString1.ajL(paramContext.getResources().getColor(paramInt));
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.bou(paramString3).c(paramOnClickListener);
    locala.Dk(paramBoolean);
    paramString1 = locala.hbn();
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.aoV(2131755921).c(paramOnClickListener);
    locala.Dk(paramBoolean);
    paramString1 = locala.hbn();
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
    locala.Dk(false);
    locala.aoW(2131755761);
    locala.bon(paramString);
    View localView = View.inflate(paramContext, 2131495503, null);
    paramString = (LinearLayout)localView.findViewById(2131308813);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      TextView localTextView = (TextView)View.inflate(paramContext, 2131496016, null);
      localTextView.setText((CharSequence)paramList.get(i));
      if (i == paramInt) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2131691380, 0, 0, 0);
      }
      if (i == paramList.size() - 1)
      {
        paramContext.getResources().getDimensionPixelSize(2131165534);
        localTextView.setBackgroundResource(2131235154);
      }
      localTextView.setTag(Integer.valueOf(i));
      paramString.addView(localTextView, 0);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(205220);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/base/MMAlert$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          int i = 0;
          while (i < this.DaJ.getChildCount())
          {
            localObject = (TextView)this.DaJ.getChildAt(i);
            if (((TextView)localObject).getId() != 2131309187) {
              ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691379, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691380, 0, 0, 0);
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205219);
              ((Dialog)h.12.this.DaJ.getTag()).dismiss();
              if (h.12.this.OPs != null) {
                h.12.this.OPs.Vq(this.OPt);
              }
              AppMethodBeat.o(205219);
            }
          });
          a.a(this, "com/tencent/mm/ui/base/MMAlert$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205220);
        }
      });
      i -= 1;
    }
    locala.hs(localView);
    paramList = locala.hbn();
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
    locala.bon(paramString1);
    locala.hs(paramView);
    locala.bou(paramString2).c(paramOnClickListener1);
    locala.bov(paramString3).d(paramOnClickListener2);
    locala.Dk(paramBoolean);
    paramString1 = locala.hbn();
    if (paramInt > 0) {
      paramString1.ajL(paramContext.getResources().getColor(paramInt));
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.bou(paramString3).c(paramOnClickListener1);
    locala.bov(paramString4).d(paramOnClickListener2);
    locala.Dk(paramBoolean);
    paramString1 = locala.hbn();
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.bou(paramString3).c(paramOnClickListener1);
    locala.bov(paramString4).d(paramOnClickListener2);
    locala.Dk(paramBoolean);
    paramString1 = locala.hbn();
    if (paramInt1 > 0) {
      paramString1.ajL(paramContext.getResources().getColor(paramInt1));
    }
    if (paramInt2 > 0) {
      paramString1.ajM(paramContext.getResources().getColor(paramInt2));
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
  
  public static q b(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(205228);
    paramContext = a(paramContext, 2, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(205228);
    return paramContext;
  }
  
  public static d b(Context paramContext, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141805);
    if (paramInt > 0) {}
    for (String str = com.tencent.mm.cc.e.aJ(paramContext, paramInt);; str = "")
    {
      paramContext = a(paramContext, str, com.tencent.mm.cc.e.aJ(paramContext, 2131755998), false, paramOnClickListener1, paramOnClickListener2);
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
    locala.Dk(false);
    locala.Dl(true);
    locala.aoW(2131755761).d(null);
    locala.bon(paramString1);
    paramString1 = View.inflate(paramContext, 2131495502, null);
    final MMEditText localMMEditText = (MMEditText)paramString1.findViewById(2131299910);
    if (!Util.isNullOrNil(paramString2)) {
      localMMEditText.bol(paramString2);
    }
    paramString2 = (TextView)paramString1.findViewById(2131309187);
    if (Util.isNullOrNil(paramString3)) {
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      locala.aoV(2131755921).a(false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(205217);
          boolean bool = true;
          if (this.Imy != null) {
            bool = this.Imy.onFinish(localMMEditText.getText().toString().trim());
          }
          if (bool)
          {
            paramAnonymousDialogInterface.dismiss();
            if ((paramContext instanceof MMActivity)) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(205216);
                  ((MMActivity)h.10.this.val$context).hideVKB();
                  AppMethodBeat.o(205216);
                }
              });
            }
          }
          AppMethodBeat.o(205217);
        }
      });
      if (paramInt > 0) {
        com.tencent.mm.ui.tools.b.c.f(localMMEditText).aoq(paramInt).a(null);
      }
      locala.hs(paramString1);
      paramString2 = locala.hbn();
      paramString2.show();
      a(paramContext, paramString2);
      if ((paramContext instanceof MMActivity)) {
        paramString1.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205218);
            ((MMActivity)this.val$context).showVKB();
            AppMethodBeat.o(205218);
          }
        });
      }
      AppMethodBeat.o(141820);
      return paramString2;
      paramString2.setText(paramString3);
    }
  }
  
  private static d b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(205225);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(205225);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.aoV(2131755921).c(paramOnClickListener1);
    locala.aoW(2131755761).d(paramOnClickListener2);
    locala.Dk(paramBoolean);
    paramString1 = locala.hbn();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(205225);
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
    paramContext = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(205211);
        if (!Util.isNullOrNil(this.dqb)) {
          paramAnonymousm.setHeaderTitle(this.dqb);
        }
        int i = 0;
        while (i < this.Ere.size())
        {
          paramAnonymousm.d(((Integer)paramList1.get(i)).intValue(), (CharSequence)this.Ere.get(i));
          i += 1;
        }
        if (!Util.isNullOrNil(paramString2)) {
          paramAnonymousm.d(-1, paramString2);
        }
        AppMethodBeat.o(205211);
      }
    };
    paramContext.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(205212);
        if (this.OPo != null) {
          this.OPo.cy(paramAnonymousInt, paramAnonymousMenuItem.getItemId());
        }
        AppMethodBeat.o(205212);
      }
    };
    paramContext.dGm();
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
  
  public static d c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(141809);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(141809);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.bou(paramString3).c(paramOnClickListener1);
    locala.bov(paramString4).d(paramOnClickListener2);
    paramString1 = locala.hbn();
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
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.Dk(paramBoolean);
    locala.aoV(2131755921).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(141772);
        paramAnonymousDialogInterface.cancel();
        AppMethodBeat.o(141772);
      }
    });
    paramString1 = locala.hbn();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(141792);
    return paramString1;
  }
  
  public static Toast cA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(258461);
    paramContext = cD(paramContext, paramString);
    AppMethodBeat.o(258461);
    return paramContext;
  }
  
  public static Toast cB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141788);
    paramContext = cD(paramContext, paramString);
    AppMethodBeat.o(141788);
    return paramContext;
  }
  
  public static void cC(Context paramContext, String paramString)
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
  
  public static Toast cD(Context paramContext, String paramString)
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
    paramContext = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(205213);
        paramAnonymousm.setHeaderTitle(this.dqb);
        int i = 0;
        while (i < localArrayList.size())
        {
          paramAnonymousm.d(i, (CharSequence)localArrayList.get(i));
          i += 1;
        }
        AppMethodBeat.o(205213);
      }
    };
    paramContext.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(205214);
        if (this.OPp != null) {
          this.OPp.oj(paramAnonymousMenuItem.getItemId());
        }
        AppMethodBeat.o(205214);
      }
    };
    paramContext.dGm();
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
  
  public static d n(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141793);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = com.tencent.mm.cc.e.aJ(paramContext, paramInt1);
      if (paramInt2 <= 0) {
        break label50;
      }
    }
    label50:
    for (String str2 = com.tencent.mm.cc.e.aJ(paramContext, paramInt2);; str2 = "")
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
    public abstract void Vq(int paramInt);
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
    public abstract void oj(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void cy(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.h
 * JD-Core Version:    0.7.0.1
 */