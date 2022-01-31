package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.b.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author=20, fComment="checked", lastDate="201400504", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class h
{
  public static com.tencent.mm.ui.widget.b.c J(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(156783);
    paramContext = b(paramContext, paramString1, paramString2, true);
    AppMethodBeat.o(156783);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, List<String> paramList, List<Integer> paramList1, h.d paramd)
  {
    AppMethodBeat.i(106465);
    paramContext = b(paramContext, paramString, paramList, paramList1, null, true, paramd);
    AppMethodBeat.o(106465);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, h.d paramd)
  {
    AppMethodBeat.i(106463);
    paramContext = b(paramContext, paramString1, paramList, paramList1, paramString2, true, paramd);
    AppMethodBeat.o(106463);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, boolean paramBoolean, h.d paramd)
  {
    AppMethodBeat.i(106464);
    paramContext = b(paramContext, paramString1, paramList, paramList1, paramString2, paramBoolean, paramd);
    AppMethodBeat.o(106464);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, String[] paramArrayOfString, h.c paramc)
  {
    AppMethodBeat.i(106467);
    paramContext = a(paramContext, paramString, paramArrayOfString, null, true, paramc, null);
    AppMethodBeat.o(106467);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, h.c paramc)
  {
    AppMethodBeat.i(106468);
    paramContext = a(paramContext, paramString1, paramArrayOfString, paramString2, true, paramc, null);
    AppMethodBeat.o(106468);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, h.c paramc, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106470);
    paramContext = a(paramContext, paramString1, paramArrayOfString, paramString2, true, paramc, paramOnCancelListener);
    AppMethodBeat.o(106470);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, boolean paramBoolean, h.c paramc)
  {
    AppMethodBeat.i(106469);
    paramContext = a(paramContext, paramString1, paramArrayOfString, paramString2, paramBoolean, paramc, null);
    AppMethodBeat.o(106469);
    return paramContext;
  }
  
  @Deprecated
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, boolean paramBoolean, h.c paramc, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106471);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106471);
      return null;
    }
    if (((paramArrayOfString == null) || (paramArrayOfString.length == 0)) && (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(106471);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      Collections.addAll(localArrayList, paramArrayOfString);
    }
    if (!bo.isNullOrNil(paramString2)) {
      localArrayList.add(paramString2);
    }
    if (paramBoolean)
    {
      paramArrayOfString = new com.tencent.mm.ui.tools.l(paramContext);
      paramArrayOfString.sao = new h.5(paramString1, localArrayList);
      paramArrayOfString.sap = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(106408);
          if (this.ziB != null) {
            this.ziB.iA(paramAnonymousMenuItem.getItemId());
          }
          AppMethodBeat.o(106408);
        }
      };
      paramArrayOfString.setOnCancelListener(paramOnCancelListener);
      paramString1 = paramArrayOfString.cwt();
      a(paramContext, paramString1);
      AppMethodBeat.o(106471);
      return paramString1;
    }
    paramContext = new d(paramContext, 1, false);
    paramContext.sao = new h.7(paramString1, localArrayList);
    paramContext.sap = new h.8(paramc);
    paramContext.crd();
    AppMethodBeat.o(106471);
    return null;
  }
  
  public static p a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106462);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106462);
      return null;
    }
    y.activateBroadcast(true);
    paramString = p.b(paramContext, paramString, paramBoolean, paramInt1, paramInt2, new h.15(new WeakReference(paramOnCancelListener)));
    a(paramContext, paramString);
    AppMethodBeat.o(106462);
    return paramString;
  }
  
  public static p a(Context paramContext, int paramInt, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106461);
    paramContext = a(paramContext, paramInt, -1, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(106461);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106443);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106443);
      return null;
    }
    c.a locala = new c.a(paramContext);
    if (paramInt2 != 0) {
      locala.Rb(paramInt2);
    }
    locala.Rf(paramInt1);
    locala.Ri(paramInt3).a(paramOnClickListener1);
    locala.Rj(paramInt4).b(paramOnClickListener2);
    locala.e(new h.10(paramOnClickListener2));
    paramOnClickListener1 = locala.aLZ();
    paramOnClickListener1.show();
    a(paramContext, paramOnClickListener1);
    AppMethodBeat.o(106443);
    return paramOnClickListener1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106441);
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
      AppMethodBeat.o(106441);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt5)
  {
    AppMethodBeat.i(106442);
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
      AppMethodBeat.o(106442);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106429);
    paramContext = a(paramContext, paramInt1, paramInt2, true, paramOnClickListener);
    AppMethodBeat.o(106429);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106439);
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
      AppMethodBeat.o(106439);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106430);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106430);
      return null;
    }
    c.a locala = new c.a(paramContext);
    if (paramInt2 > 0) {
      locala.Rb(paramInt2);
    }
    locala.Rf(paramInt1);
    locala.Ri(2131297018).a(paramOnClickListener);
    locala.rG(paramBoolean);
    paramOnClickListener = locala.aLZ();
    paramOnClickListener.show();
    a(paramContext, paramOnClickListener);
    AppMethodBeat.o(106430);
    return paramOnClickListener;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(106448);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106448);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString);
    locala.fu(paramView);
    locala.rG(true);
    paramView = locala.aLZ();
    paramView.show();
    a(paramContext, paramView);
    AppMethodBeat.o(106448);
    return paramView;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106449);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106449);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString);
    locala.fu(paramView);
    locala.Ri(2131297018).a(paramOnClickListener);
    paramString = locala.aLZ();
    paramString.show();
    a(paramContext, paramString);
    AppMethodBeat.o(106449);
    return paramString;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106454);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106454);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString);
    locala.avn(null);
    locala.fu(paramView);
    locala.Ri(2131297018).a(paramOnClickListener1);
    locala.Rj(2131296888).b(paramOnClickListener2);
    locala.e(new h.11(paramOnClickListener2));
    paramString = locala.aLZ();
    paramString.show();
    a(paramContext, paramString);
    AppMethodBeat.o(106454);
    return paramString;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106450);
    paramContext = a(paramContext, true, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(106450);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106431);
    paramContext = a(paramContext, paramString1, paramString2, true, paramOnClickListener);
    AppMethodBeat.o(106431);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106458);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106458);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.Ri(2131297018).a(paramOnClickListener);
    locala.e(paramOnCancelListener);
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106458);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106435);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106435);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.Ri(2131297018).a(paramOnClickListener1);
    locala.Rj(2131296888).b(paramOnClickListener2);
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106435);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106453);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106453);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString1);
    locala.fu(paramView);
    locala.avs(paramString2).a(paramOnClickListener);
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106453);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb)
  {
    AppMethodBeat.i(106455);
    paramContext = b(paramContext, paramString1, paramString2, paramString3, paramInt, paramb);
    AppMethodBeat.o(106455);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106433);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, true, paramOnClickListener);
    AppMethodBeat.o(106433);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(106445);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106445);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.avs(paramString3).a(paramOnClickListener1);
    locala.avt(paramString4).b(paramOnClickListener2);
    paramString1 = locala.aLZ();
    paramString1.QZ(paramContext.getResources().getColor(paramInt));
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106445);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106437);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(106437);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(106438);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106438);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.avs(paramString3).a(paramOnClickListener1);
    locala.avt(paramString4).b(paramOnClickListener2);
    locala.rG(paramBoolean);
    paramString1 = locala.aLZ();
    if (paramInt > 0) {
      paramString1.QZ(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106438);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106434);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106434);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.avs(paramString3).a(paramOnClickListener);
    locala.rG(paramBoolean);
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106434);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106432);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106432);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.Ri(2131297018).a(paramOnClickListener);
    locala.rG(paramBoolean);
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106432);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106436);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106436);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.Ri(2131297018).a(paramOnClickListener1);
    locala.Rj(2131296888).b(paramOnClickListener2);
    locala.rG(paramBoolean);
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106436);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString, List<String> paramList, int paramInt, h.a parama)
  {
    AppMethodBeat.i(106457);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106457);
      return null;
    }
    if (paramList.isEmpty())
    {
      ab.w("MicroMsg.MMAlert", "show switch alert fail");
      AppMethodBeat.o(106457);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.rG(false);
    locala.Rj(2131296888);
    locala.avm(paramString);
    View localView = View.inflate(paramContext, 2130970146, null);
    paramString = (LinearLayout)localView.findViewById(2131826156);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      TextView localTextView = (TextView)View.inflate(paramContext, 2130970500, null);
      localTextView.setText((CharSequence)paramList.get(i));
      if (i == paramInt) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2131231906, 0, 0, 0);
      }
      if (i == paramList.size() - 1)
      {
        paramContext.getResources().getDimensionPixelSize(2131427808);
        localTextView.setBackgroundResource(2130840493);
      }
      localTextView.setTag(Integer.valueOf(i));
      paramString.addView(localTextView, 0);
      localTextView.setOnClickListener(new h.14(paramString, parama));
      i -= 1;
    }
    locala.fu(localView);
    paramList = locala.aLZ();
    paramString.setTag(paramList);
    paramList.show();
    a(paramContext, paramList);
    AppMethodBeat.o(106457);
    return paramList;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106451);
    paramContext = a(paramContext, paramBoolean, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, -1);
    AppMethodBeat.o(106451);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    AppMethodBeat.i(106452);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106452);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString1);
    locala.fu(paramView);
    locala.avs(paramString2).a(paramOnClickListener1);
    locala.avt(paramString3).b(paramOnClickListener2);
    locala.rG(paramBoolean);
    paramString1 = locala.aLZ();
    if (paramInt > 0) {
      paramString1.QZ(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106452);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106446);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106446);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.avs(paramString3).a(paramOnClickListener1);
    locala.avt(paramString4).b(paramOnClickListener2);
    locala.rG(paramBoolean);
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106446);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106447);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106447);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.avs(paramString3).a(paramOnClickListener1);
    locala.avt(paramString4).b(paramOnClickListener2);
    locala.rG(paramBoolean);
    paramString1 = locala.aLZ();
    if (paramInt1 > 0) {
      paramString1.QZ(paramContext.getResources().getColor(paramInt1));
    }
    if (paramInt2 > 0) {
      paramString1.Ra(paramContext.getResources().getColor(paramInt2));
    }
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106447);
    return paramString1;
  }
  
  public static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(106421);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).addDialog(paramDialog);
    }
    AppMethodBeat.o(106421);
  }
  
  @Deprecated
  private static Dialog b(Context paramContext, String paramString1, List<String> paramList, final List<Integer> paramList1, final String paramString2, boolean paramBoolean, h.d paramd)
  {
    AppMethodBeat.i(106466);
    if (((paramList == null) || (paramList.size() == 0)) && (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(106466);
      return null;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (paramBoolean)
    {
      paramList = new com.tencent.mm.ui.tools.l(paramContext);
      paramList.sao = new h.16(paramString1, (List)localObject, paramList1, paramString2);
      paramList.sap = new h.2(paramd);
      paramList.setOnCancelListener(null);
      paramString1 = paramList.cwt();
      a(paramContext, paramString1);
      AppMethodBeat.o(106466);
      return paramString1;
    }
    paramContext = new d(paramContext, 1, false);
    paramContext.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(106405);
        if (!bo.isNullOrNil(this.cbK)) {
          paramAnonymousl.setHeaderTitle(this.cbK);
        }
        int i = 0;
        while (i < this.rHo.size())
        {
          paramAnonymousl.e(((Integer)paramList1.get(i)).intValue(), (CharSequence)this.rHo.get(i));
          i += 1;
        }
        if (!bo.isNullOrNil(paramString2)) {
          paramAnonymousl.e(-1, paramString2);
        }
        AppMethodBeat.o(106405);
      }
    };
    paramContext.sap = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(106406);
        if (this.ziz != null) {
          this.ziz.ca(paramAnonymousInt, paramAnonymousMenuItem.getItemId());
        }
        AppMethodBeat.o(106406);
      }
    };
    paramContext.crd();
    AppMethodBeat.o(106466);
    return null;
  }
  
  public static p b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106460);
    paramContext = a(paramContext, 2, paramString, true, paramOnCancelListener);
    AppMethodBeat.o(106460);
    return paramContext;
  }
  
  public static p b(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106459);
    paramContext = a(paramContext, 0, paramString, paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(106459);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c b(Context paramContext, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106440);
    if (paramInt > 0) {}
    for (String str = paramContext.getString(paramInt);; str = "")
    {
      paramContext = a(paramContext, str, paramContext.getString(2131297087), false, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(106440);
      return paramContext;
    }
  }
  
  private static com.tencent.mm.ui.widget.b.c b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb)
  {
    AppMethodBeat.i(106456);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106456);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.rG(false);
    locala.rH(true);
    locala.Rj(2131296888).b(null);
    locala.avm(paramString1);
    paramString1 = View.inflate(paramContext, 2130970145, null);
    MMEditText localMMEditText = (MMEditText)paramString1.findViewById(2131820995);
    if (!bo.isNullOrNil(paramString2)) {
      localMMEditText.avk(paramString2);
    }
    paramString2 = (TextView)paramString1.findViewById(2131823916);
    if (bo.isNullOrNil(paramString3)) {
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      locala.Ri(2131297018).a(false, new h.12(paramb, localMMEditText, paramContext));
      if (paramInt > 0) {
        com.tencent.mm.ui.tools.b.c.d(localMMEditText).QS(paramInt).a(null);
      }
      locala.fu(paramString1);
      paramString2 = locala.aLZ();
      paramString2.show();
      a(paramContext, paramString2);
      if ((paramContext instanceof MMActivity)) {
        paramString1.post(new h.13(paramContext));
      }
      AppMethodBeat.o(106456);
      return paramString2;
      paramString2.setText(paramString3);
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(106427);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106427);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.rG(paramBoolean);
    locala.Ri(2131297018).a(new h.1());
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106427);
    return paramString1;
  }
  
  public static Toast bL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(156782);
    paramContext = bO(paramContext, paramString);
    AppMethodBeat.o(156782);
    return paramContext;
  }
  
  public static Toast bM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(106423);
    paramContext = bO(paramContext, paramString);
    AppMethodBeat.o(106423);
    return paramContext;
  }
  
  public static void bN(Context paramContext, String paramString)
  {
    AppMethodBeat.i(106424);
    Toast.makeText(paramContext, paramString, 0).show();
    AppMethodBeat.o(106424);
  }
  
  public static Toast bO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(106425);
    paramContext = Toast.makeText(paramContext, paramString, 0);
    paramContext.show();
    AppMethodBeat.o(106425);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c d(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(106444);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(106444);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.avs(paramString3).a(paramOnClickListener1);
    locala.avt(paramString4).b(paramOnClickListener2);
    paramString1 = locala.aLZ();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(106444);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c h(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106428);
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
      paramContext = b(paramContext, str1, str2, true);
      AppMethodBeat.o(106428);
      return paramContext;
      str1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.h
 * JD-Core Version:    0.7.0.1
 */