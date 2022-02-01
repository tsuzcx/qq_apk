package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static String a(bnn parambnn)
  {
    AppMethodBeat.i(72749);
    if (parambnn == null)
    {
      AppMethodBeat.o(72749);
      return "JumpItem{null}";
    }
    parambnn = "JumpItem{wording='" + parambnn.dlQ + '\'' + ", action=" + parambnn.action + ", url='" + parambnn.url + '\'' + ", username='" + parambnn.username + '\'' + ", pagepath='" + parambnn.wLU + '\'' + '}';
    AppMethodBeat.o(72749);
    return parambnn;
  }
  
  public static <InputType> void a(Context paramContext, bnn parambnn, InputType paramInputType, a<InputType> parama)
  {
    AppMethodBeat.i(72754);
    String str1;
    if (parambnn == null)
    {
      str1 = a(parambnn);
      if (parama != null) {
        break label61;
      }
    }
    label61:
    for (String str2 = "null";; str2 = "no null")
    {
      ac.i("MicroMsg.JumpItemUtil", "handleAction() jumpItem:%s iJumpItemCallback:%s", new Object[] { str1, str2 });
      if (parambnn != null) {
        break label68;
      }
      AppMethodBeat.o(72754);
      return;
      str1 = "null";
      break;
    }
    label68:
    switch (parambnn.action)
    {
    }
    for (;;)
    {
      if (parama != null) {
        parama.dxI();
      }
      AppMethodBeat.o(72754);
      return;
      if (parama != null)
      {
        parama.dxG();
        continue;
        if (parama != null)
        {
          parama.dxN();
          continue;
          if (parama != null)
          {
            parama.dC(paramInputType);
            continue;
            paramInputType = new Intent();
            paramInputType.putExtra("rawUrl", parambnn.url);
            e.al(paramContext, paramInputType);
            continue;
            for (;;)
            {
              try
              {
                paramInputType = new ut();
                paramInputType.dxt.userName = parambnn.username;
                paramInputType.dxt.dxv = parambnn.wLU;
                if (parama == null) {
                  break label291;
                }
                paramInputType.dxt.scene = parama.dxH();
                paramInputType.dxt.dxw = 0;
                paramInputType.dxt.context = paramContext;
                a.GpY.l(paramInputType);
              }
              catch (Exception paramContext)
              {
                ac.e("MicroMsg.JumpItemUtil", "handleAction() Exception: %s", new Object[] { paramContext.getMessage() });
              }
              break;
              label291:
              paramInputType.dxt.scene = 1000;
            }
            if (parama != null) {
              parama.dxJ();
            }
          }
        }
      }
    }
  }
  
  public static <InputType> void a(Context paramContext, final coc paramcoc, final InputType paramInputType, final a<InputType> parama)
  {
    AppMethodBeat.i(72755);
    if (paramcoc == null)
    {
      ac.i("MicroMsg.JumpItemUtil", "showRemindWin() remindWin == null");
      AppMethodBeat.o(72755);
      return;
    }
    h.a(paramContext, paramcoc.dlQ, "", paramcoc.BNE.dlQ, paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72743);
        ac.i("MicroMsg.JumpItemUtil", "showRemindWin() ok click!");
        l.a(this.val$context, paramcoc.BNE, paramInputType, parama);
        AppMethodBeat.o(72743);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72744);
        ac.i("MicroMsg.JumpItemUtil", "showRemindWin() cancel click!");
        AppMethodBeat.o(72744);
      }
    }).show();
    AppMethodBeat.o(72755);
  }
  
  public static <InputType> void a(Context paramContext, final wo paramwo, final InputType paramInputType, final a<InputType> parama, final a parama1)
  {
    AppMethodBeat.i(72756);
    if (paramwo == null)
    {
      ac.i("MicroMsg.JumpItemUtil", "showCheckWin() checkWin == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramwo.BND == null) || (paramwo.BNE == null))
    {
      ac.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button == null || right_button == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramwo.EqP == null) || (paramwo.EqP.isEmpty()))
    {
      ac.i("MicroMsg.JumpItemUtil", "showCheckWin() check_item == null || check_item.isEmpty()");
      AppMethodBeat.o(72756);
      return;
    }
    View localView1 = LayoutInflater.from(paramContext).inflate(2131493528, null);
    ((TextView)localView1.findViewById(2131305529)).setText(paramwo.subtitle);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131301144);
    int i = 0;
    while (i < paramwo.EqP.size())
    {
      View localView2 = LayoutInflater.from(paramContext).inflate(2131493527, null);
      ((TextView)localView2.findViewById(2131301158)).setText(((boa)paramwo.EqP.get(i)).key);
      ((TextView)localView2.findViewById(2131301201)).setText(((boa)paramwo.EqP.get(i)).value);
      localLinearLayout.addView(localView2);
      i += 1;
    }
    h.a(paramContext, false, paramwo.title, localView1, paramwo.BNE.dlQ, paramwo.BND.dlQ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72745);
        ac.i("MicroMsg.JumpItemUtil", "showCheckWin() right_button click!");
        l.a(this.val$context, paramwo.BNE, paramInputType, parama1);
        AppMethodBeat.o(72745);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72746);
        ac.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button click!");
        l.a(this.val$context, paramwo.BND, paramInputType, parama);
        AppMethodBeat.o(72746);
      }
    }).show();
    AppMethodBeat.o(72756);
  }
  
  public static bnn aSC(String paramString)
  {
    AppMethodBeat.i(72752);
    try
    {
      paramString = bz(new JSONObject(paramString));
      AppMethodBeat.o(72752);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ac.e("MicroMsg.JumpItemUtil", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(72752);
    }
    return null;
  }
  
  public static JSONObject b(bnn parambnn)
  {
    AppMethodBeat.i(72751);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", parambnn.dlQ);
      localJSONObject.put("action", parambnn.action);
      localJSONObject.put("url", parambnn.url);
      localJSONObject.put("username", parambnn.username);
      localJSONObject.put("pagepath", parambnn.wLU);
      AppMethodBeat.o(72751);
      return localJSONObject;
    }
    catch (JSONException parambnn)
    {
      for (;;)
      {
        ac.e("MicroMsg.JumpItemUtil", "getJSONObject() Exception: %s", new Object[] { parambnn.getMessage() });
      }
    }
  }
  
  public static String bt(LinkedList<bnn> paramLinkedList)
  {
    AppMethodBeat.i(72750);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(72750);
      return "LinkedList<JumpItem>{null}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LinkedList<JumpItem>{");
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localStringBuilder.append(a((bnn)paramLinkedList.next())).append(", ");
    }
    localStringBuilder.append("}");
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(72750);
    return paramLinkedList;
  }
  
  public static bnn bz(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72753);
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.JumpItemUtil", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(72753);
      return null;
    }
    bnn localbnn = new bnn();
    localbnn.dlQ = paramJSONObject.optString("wording");
    localbnn.action = paramJSONObject.optInt("action");
    localbnn.url = paramJSONObject.optString("url");
    localbnn.username = paramJSONObject.optString("username");
    localbnn.wLU = paramJSONObject.optString("pagepath");
    AppMethodBeat.o(72753);
    return localbnn;
  }
  
  public static abstract interface a<InputType>
  {
    public abstract void dC(InputType paramInputType);
    
    public abstract void dxG();
    
    public abstract int dxH();
    
    public abstract void dxI();
    
    public abstract void dxJ();
    
    public abstract void dxN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */