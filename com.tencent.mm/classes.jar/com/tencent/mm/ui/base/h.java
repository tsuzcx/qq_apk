package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author=20, fComment="checked", lastDate="201400504", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class h
{
  public static Dialog a(Context paramContext, String paramString, List<String> paramList, List<Integer> paramList1, h.d paramd)
  {
    return b(paramContext, paramString, paramList, paramList1, null, true, paramd);
  }
  
  public static Dialog a(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, h.d paramd)
  {
    return b(paramContext, paramString1, paramList, paramList1, paramString2, true, paramd);
  }
  
  public static Dialog a(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, boolean paramBoolean, h.d paramd)
  {
    return b(paramContext, paramString1, paramList, paramList1, paramString2, paramBoolean, paramd);
  }
  
  public static Dialog a(Context paramContext, String paramString, String[] paramArrayOfString, h.c paramc)
  {
    return a(paramContext, paramString, paramArrayOfString, null, true, paramc, null);
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, h.c paramc)
  {
    return a(paramContext, paramString1, paramArrayOfString, paramString2, true, paramc, null);
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, h.c paramc, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramContext, paramString1, paramArrayOfString, paramString2, true, paramc, paramOnCancelListener);
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, boolean paramBoolean, h.c paramc)
  {
    return a(paramContext, paramString1, paramArrayOfString, paramString2, paramBoolean, paramc, null);
  }
  
  @Deprecated
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, boolean paramBoolean, h.c paramc, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    if (((paramArrayOfString == null) || (paramArrayOfString.length == 0)) && (bk.bl(paramString2))) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      Collections.addAll(localArrayList, paramArrayOfString);
    }
    if (!bk.bl(paramString2)) {
      localArrayList.add(paramString2);
    }
    if (paramBoolean)
    {
      paramArrayOfString = new j(paramContext);
      paramArrayOfString.phH = new h.5(paramString1, localArrayList);
      paramArrayOfString.phI = new h.6(paramc);
      paramArrayOfString.d(paramOnCancelListener);
      paramString1 = paramArrayOfString.bJQ();
      a(paramContext, paramString1);
      return paramString1;
    }
    paramContext = new d(paramContext, 1, false);
    paramContext.phH = new h.7(paramString1, localArrayList);
    paramContext.phI = new h.8(paramc);
    paramContext.cfU();
    return null;
  }
  
  private static p a(Context paramContext, int paramInt, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    x.b(true, null);
    paramString = p.b(paramContext, paramString, paramBoolean, paramInt, new h.15(new WeakReference(paramOnCancelListener)));
    a(paramContext, paramString);
    return paramString;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    if (paramInt2 != 0) {
      locala.Ip(paramInt2);
    }
    locala.Iq(paramInt1);
    locala.Is(paramInt3).a(paramOnClickListener1);
    locala.It(paramInt4).b(paramOnClickListener2);
    locala.e(new h.10(paramOnClickListener2));
    paramOnClickListener1 = locala.aoP();
    paramOnClickListener1.show();
    a(paramContext, paramOnClickListener1);
    return paramOnClickListener1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label55;
      }
    }
    label55:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      return a(paramContext, str1, str2, paramContext.getString(paramInt3), paramContext.getString(paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2);
      str1 = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt5)
  {
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label57;
      }
    }
    label57:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      return a(paramContext, str1, str2, paramContext.getString(paramInt3), paramContext.getString(paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2, paramInt5);
      str1 = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return a(paramContext, paramInt1, paramInt2, true, paramOnClickListener);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label41;
      }
    }
    label41:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      return a(paramContext, str1, str2, paramOnClickListener1, paramOnClickListener2);
      str1 = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    if (paramInt2 > 0) {
      locala.Ip(paramInt2);
    }
    locala.Iq(paramInt1);
    locala.Is(a.k.app_ok).a(paramOnClickListener);
    locala.nW(paramBoolean);
    paramOnClickListener = locala.aoP();
    paramOnClickListener.show();
    a(paramContext, paramOnClickListener);
    return paramOnClickListener;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString);
    locala.ei(paramView);
    locala.Is(a.k.app_ok).a(paramOnClickListener);
    paramString = locala.aoP();
    paramString.show();
    a(paramContext, paramString);
    return paramString;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString);
    locala.aeA(null);
    locala.ei(paramView);
    locala.Is(a.k.app_ok).a(paramOnClickListener1);
    locala.It(a.k.app_cancel).b(paramOnClickListener2);
    locala.e(new h.11(paramOnClickListener2));
    paramString = locala.aoP();
    paramString.show();
    a(paramContext, paramString);
    return paramString;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, true, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return a(paramContext, paramString1, paramString2, true, paramOnClickListener);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.Is(a.k.app_ok).a(paramOnClickListener);
    locala.e(paramOnCancelListener);
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.Is(a.k.app_ok).a(paramOnClickListener1);
    locala.It(a.k.app_cancel).b(paramOnClickListener2);
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString1);
    locala.ei(paramView);
    locala.aeD(paramString2).a(paramOnClickListener);
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      paramString1 = null;
      return paramString1;
    }
    c.a locala = new c.a(paramContext);
    locala.nW(false);
    locala.nX(true);
    locala.It(a.k.app_cancel).b(null);
    locala.aez(paramString1);
    View localView = View.inflate(paramContext, a.h.mm_alert_input, null);
    paramString1 = (MMEditText)localView.findViewById(a.g.edittext);
    if (!bk.bl(paramString2)) {
      paramString1.aex(paramString2);
    }
    paramString2 = (TextView)localView.findViewById(a.g.tips_tv);
    if (bk.bl(paramString3)) {
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      locala.Is(a.k.app_ok).a(false, new h.12(paramb, paramString1, paramContext));
      if (paramInt > 0) {
        com.tencent.mm.ui.tools.a.c.d(paramString1).Ig(paramInt).a(null);
      }
      locala.ei(localView);
      paramString2 = locala.aoP();
      paramString2.show();
      a(paramContext, paramString2);
      paramString1 = paramString2;
      if (!(paramContext instanceof MMActivity)) {
        break;
      }
      localView.post(new h.13(paramContext));
      return paramString2;
      paramString2.setText(paramString3);
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    return a(paramContext, paramString1, paramString2, paramString3, true, paramOnClickListener);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.aeD(paramString3).a(paramOnClickListener1);
    locala.aeE(paramString4).b(paramOnClickListener2);
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.aeD(paramString3).a(paramOnClickListener1);
    locala.aeE(paramString4).b(paramOnClickListener2);
    paramString1 = locala.aoP();
    paramString1.In(paramContext.getResources().getColor(paramInt));
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramOnClickListener1, paramOnClickListener2, -1);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.aeD(paramString3).a(paramOnClickListener1);
    locala.aeE(paramString4).b(paramOnClickListener2);
    locala.nW(paramBoolean);
    paramString1 = locala.aoP();
    if (paramInt > 0) {
      paramString1.In(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.aeD(paramString3).a(paramOnClickListener);
    locala.nW(paramBoolean);
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.Is(a.k.app_ok).a(paramOnClickListener);
    locala.nW(paramBoolean);
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.Is(a.k.app_ok).a(paramOnClickListener1);
    locala.It(a.k.app_cancel).b(paramOnClickListener2);
    locala.nW(paramBoolean);
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, String paramString, List<String> paramList, int paramInt, a parama)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    if (paramList.isEmpty())
    {
      y.w("MicroMsg.MMAlert", "show switch alert fail");
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.nW(false);
    locala.It(a.k.app_cancel);
    locala.aez(paramString);
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
      localTextView.setOnClickListener(new h.14(paramString, parama));
      i -= 1;
    }
    locala.ei(localView);
    paramList = locala.aoP();
    paramString.setTag(paramList);
    paramList.show();
    a(paramContext, paramList);
    return paramList;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramBoolean, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, -1);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString1);
    locala.ei(paramView);
    locala.aeD(paramString2).a(paramOnClickListener1);
    locala.aeE(paramString3).b(paramOnClickListener2);
    locala.nW(paramBoolean);
    paramString1 = locala.aoP();
    if (paramInt > 0) {
      paramString1.In(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.aeD(paramString3).a(paramOnClickListener1);
    locala.aeE(paramString4).b(paramOnClickListener2);
    locala.nW(paramBoolean);
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.aeD(paramString3).a(paramOnClickListener1);
    locala.aeE(paramString4).b(paramOnClickListener2);
    locala.nW(paramBoolean);
    paramString1 = locala.aoP();
    if (paramInt1 > 0) {
      paramString1.In(paramContext.getResources().getColor(paramInt1));
    }
    if (paramInt2 > 0) {
      paramString1.Io(paramContext.getResources().getColor(paramInt2));
    }
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static void a(Context paramContext, Dialog paramDialog)
  {
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).addDialog(paramDialog);
    }
  }
  
  @Deprecated
  private static Dialog b(Context paramContext, String paramString1, List<String> paramList, final List<Integer> paramList1, final String paramString2, boolean paramBoolean, h.d paramd)
  {
    if (((paramList == null) || (paramList.size() == 0)) && (bk.bl(paramString2))) {
      return null;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (paramBoolean)
    {
      paramList = new j(paramContext);
      paramList.phH = new h.16(paramString1, (List)localObject, paramList1, paramString2);
      paramList.phI = new h.2(paramd);
      paramList.d(null);
      paramString1 = paramList.bJQ();
      a(paramContext, paramString1);
      return paramString1;
    }
    paramContext = new d(paramContext, 1, false);
    paramContext.phH = new n.c()
    {
      public final void a(l paramAnonymousl)
      {
        if (!bk.bl(this.dYK)) {
          paramAnonymousl.setHeaderTitle(this.dYK);
        }
        int i = 0;
        while (i < this.oPC.size())
        {
          paramAnonymousl.e(((Integer)paramList1.get(i)).intValue(), (CharSequence)this.oPC.get(i));
          i += 1;
        }
        if (!bk.bl(paramString2)) {
          paramAnonymousl.e(-1, paramString2);
        }
      }
    };
    paramContext.phI = new h.4(paramd);
    paramContext.cfU();
    return null;
  }
  
  public static p b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramContext, 2, paramString, true, paramOnCancelListener);
  }
  
  public static p b(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramContext, 0, paramString, paramBoolean, paramOnCancelListener);
  }
  
  public static com.tencent.mm.ui.widget.a.c b(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label42;
      }
    }
    label42:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      return a(paramContext, str1, str2, false, paramOnClickListener1, paramOnClickListener2);
      str1 = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aez(paramString2);
    locala.aeA(paramString1);
    locala.nW(paramBoolean);
    locala.Is(a.k.app_ok).a(new h.1());
    paramString1 = locala.aoP();
    paramString1.show();
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public static Toast bA(Context paramContext, String paramString)
  {
    return bC(paramContext, paramString);
  }
  
  public static void bB(Context paramContext, String paramString)
  {
    Toast.makeText(paramContext, paramString, 0).show();
  }
  
  public static Toast bC(Context paramContext, String paramString)
  {
    paramContext = Toast.makeText(paramContext, paramString, 0);
    paramContext.show();
    return paramContext;
  }
  
  public static Toast bz(Context paramContext, String paramString)
  {
    return bC(paramContext, paramString);
  }
  
  public static com.tencent.mm.ui.widget.a.c h(Context paramContext, int paramInt1, int paramInt2)
  {
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label36;
      }
    }
    label36:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      return b(paramContext, str1, str2, true);
      str1 = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c z(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, paramString1, paramString2, true);
  }
  
  public static abstract interface a
  {
    public abstract void wv(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.h
 * JD-Core Version:    0.7.0.1
 */