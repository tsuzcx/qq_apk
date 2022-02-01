package com.tencent.mm.wallet_core.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.epk;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static <InputType> void a(Context paramContext, final aci paramaci, final InputType paramInputType, final a<InputType> parama, final a parama1)
  {
    AppMethodBeat.i(72756);
    if (paramaci == null)
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() checkWin == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramaci.VXQ == null) || (paramaci.VXR == null))
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button == null || right_button == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramaci.ZkL == null) || (paramaci.ZkL.isEmpty()))
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() check_item == null || check_item.isEmpty()");
      AppMethodBeat.o(72756);
      return;
    }
    View localView1 = LayoutInflater.from(paramContext).inflate(a.g.check_win_alert_ui, null);
    ((TextView)localView1.findViewById(a.f.subtitle)).setText(paramaci.igN);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(a.f.item_container);
    int i = 0;
    while (i < paramaci.ZkL.size())
    {
      View localView2 = LayoutInflater.from(paramContext).inflate(a.g.check_win_alert_item, null);
      ((TextView)localView2.findViewById(a.f.item_key)).setText(((dfp)paramaci.ZkL.get(i)).key);
      ((TextView)localView2.findViewById(a.f.item_value)).setText(((dfp)paramaci.ZkL.get(i)).value);
      localLinearLayout.addView(localView2);
      i += 1;
    }
    k.a(paramContext, false, paramaci.title, localView1, paramaci.VXR.wording, paramaci.VXQ.wording, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72745);
        Log.i("MicroMsg.JumpItemUtil", "showCheckWin() right_button click!");
        l.a(l.this, paramaci.VXR, paramInputType, parama1);
        AppMethodBeat.o(72745);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72746);
        Log.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button click!");
        l.a(l.this, paramaci.VXQ, paramInputType, parama);
        AppMethodBeat.o(72746);
      }
    }).show();
    AppMethodBeat.o(72756);
  }
  
  public static <InputType> void a(Context paramContext, dfc paramdfc, InputType paramInputType, a<InputType> parama)
  {
    AppMethodBeat.i(72754);
    String str1;
    if (paramdfc == null)
    {
      str1 = b(paramdfc);
      if (parama != null) {
        break label61;
      }
    }
    label61:
    for (String str2 = "null";; str2 = "no null")
    {
      Log.i("MicroMsg.JumpItemUtil", "handleAction() jumpItem:%s iJumpItemCallback:%s", new Object[] { str1, str2 });
      if (paramdfc != null) {
        break label68;
      }
      AppMethodBeat.o(72754);
      return;
      str1 = "null";
      break;
    }
    label68:
    switch (paramdfc.action)
    {
    }
    for (;;)
    {
      if (parama != null) {
        parama.gLS();
      }
      AppMethodBeat.o(72754);
      return;
      if (parama != null)
      {
        parama.gLQ();
        continue;
        if (parama != null)
        {
          parama.dJE();
          continue;
          if (parama != null)
          {
            parama.go(paramInputType);
            continue;
            paramInputType = new Intent();
            paramInputType.putExtra("rawUrl", paramdfc.url);
            i.aS(paramContext, paramInputType);
            continue;
            for (;;)
            {
              try
              {
                paramInputType = new zp();
                paramInputType.icM.userName = paramdfc.username;
                paramInputType.icM.icO = paramdfc.OkP;
                if (parama == null) {
                  break label289;
                }
                paramInputType.icM.scene = parama.gLR();
                paramInputType.icM.icP = 0;
                paramInputType.icM.context = paramContext;
                paramInputType.publish();
              }
              catch (Exception paramContext)
              {
                Log.e("MicroMsg.JumpItemUtil", "handleAction() Exception: %s", new Object[] { paramContext.getMessage() });
              }
              break;
              label289:
              paramInputType.icM.scene = 1000;
            }
            if (parama != null) {
              parama.gLT();
            }
          }
        }
      }
    }
  }
  
  public static <InputType> void a(Context paramContext, final epk paramepk, final InputType paramInputType, final a<InputType> parama)
  {
    AppMethodBeat.i(72755);
    if (paramepk == null)
    {
      Log.i("MicroMsg.JumpItemUtil", "showRemindWin() remindWin == null");
      AppMethodBeat.o(72755);
      return;
    }
    k.a(paramContext, paramepk.wording, "", paramepk.VXR.wording, paramContext.getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72743);
        Log.i("MicroMsg.JumpItemUtil", "showRemindWin() ok click!");
        l.a(l.this, paramepk.VXR, paramInputType, parama);
        AppMethodBeat.o(72743);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72744);
        Log.i("MicroMsg.JumpItemUtil", "showRemindWin() cancel click!");
        AppMethodBeat.o(72744);
      }
    }).show();
    AppMethodBeat.o(72755);
  }
  
  public static String b(dfc paramdfc)
  {
    AppMethodBeat.i(72749);
    if (paramdfc == null)
    {
      AppMethodBeat.o(72749);
      return "JumpItem{null}";
    }
    paramdfc = "JumpItem{wording='" + paramdfc.wording + '\'' + ", action=" + paramdfc.action + ", url='" + paramdfc.url + '\'' + ", username='" + paramdfc.username + '\'' + ", pagepath='" + paramdfc.OkP + '\'' + '}';
    AppMethodBeat.o(72749);
    return paramdfc;
  }
  
  public static dfc bEE(String paramString)
  {
    AppMethodBeat.i(72752);
    try
    {
      paramString = cO(new JSONObject(paramString));
      AppMethodBeat.o(72752);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.JumpItemUtil", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(72752);
    }
    return null;
  }
  
  public static JSONObject c(dfc paramdfc)
  {
    AppMethodBeat.i(72751);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", paramdfc.wording);
      localJSONObject.put("action", paramdfc.action);
      localJSONObject.put("url", paramdfc.url);
      localJSONObject.put("username", paramdfc.username);
      localJSONObject.put("pagepath", paramdfc.OkP);
      AppMethodBeat.o(72751);
      return localJSONObject;
    }
    catch (JSONException paramdfc)
    {
      for (;;)
      {
        Log.e("MicroMsg.JumpItemUtil", "getJSONObject() Exception: %s", new Object[] { paramdfc.getMessage() });
      }
    }
  }
  
  public static String cB(LinkedList<dfc> paramLinkedList)
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
      localStringBuilder.append(b((dfc)paramLinkedList.next())).append(", ");
    }
    localStringBuilder.append("}");
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(72750);
    return paramLinkedList;
  }
  
  public static dfc cO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72753);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JumpItemUtil", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(72753);
      return null;
    }
    dfc localdfc = new dfc();
    localdfc.wording = paramJSONObject.optString("wording");
    localdfc.action = paramJSONObject.optInt("action");
    localdfc.url = paramJSONObject.optString("url");
    localdfc.username = paramJSONObject.optString("username");
    localdfc.OkP = paramJSONObject.optString("pagepath");
    AppMethodBeat.o(72753);
    return localdfc;
  }
  
  public static abstract interface a<InputType>
  {
    public abstract void dJE();
    
    public abstract void gLQ();
    
    public abstract int gLR();
    
    public abstract void gLS();
    
    public abstract void gLT();
    
    public abstract void go(InputType paramInputType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.l
 * JD-Core Version:    0.7.0.1
 */