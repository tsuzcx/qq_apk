package com.tencent.mm.wallet_core.c;

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
import com.tencent.mm.f.a.xw;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static <InputType> void a(Context paramContext, final aai paramaai, final InputType paramInputType, final a<InputType> parama, final a parama1)
  {
    AppMethodBeat.i(72756);
    if (paramaai == null)
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() checkWin == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramaai.Phd == null) || (paramaai.Phe == null))
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button == null || right_button == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramaai.Smz == null) || (paramaai.Smz.isEmpty()))
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() check_item == null || check_item.isEmpty()");
      AppMethodBeat.o(72756);
      return;
    }
    View localView1 = LayoutInflater.from(paramContext).inflate(a.g.check_win_alert_ui, null);
    ((TextView)localView1.findViewById(a.f.subtitle)).setText(paramaai.subtitle);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(a.f.item_container);
    int i = 0;
    while (i < paramaai.Smz.size())
    {
      View localView2 = LayoutInflater.from(paramContext).inflate(a.g.check_win_alert_item, null);
      ((TextView)localView2.findViewById(a.f.item_key)).setText(((cov)paramaai.Smz.get(i)).key);
      ((TextView)localView2.findViewById(a.f.item_value)).setText(((cov)paramaai.Smz.get(i)).value);
      localLinearLayout.addView(localView2);
      i += 1;
    }
    h.a(paramContext, false, paramaai.title, localView1, paramaai.Phe.wording, paramaai.Phd.wording, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72745);
        Log.i("MicroMsg.JumpItemUtil", "showCheckWin() right_button click!");
        l.a(this.val$context, paramaai.Phe, paramInputType, parama1);
        AppMethodBeat.o(72745);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72746);
        Log.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button click!");
        l.a(this.val$context, paramaai.Phd, paramInputType, parama);
        AppMethodBeat.o(72746);
      }
    }).show();
    AppMethodBeat.o(72756);
  }
  
  public static <InputType> void a(Context paramContext, coi paramcoi, InputType paramInputType, a<InputType> parama)
  {
    AppMethodBeat.i(72754);
    String str1;
    if (paramcoi == null)
    {
      str1 = b(paramcoi);
      if (parama != null) {
        break label61;
      }
    }
    label61:
    for (String str2 = "null";; str2 = "no null")
    {
      Log.i("MicroMsg.JumpItemUtil", "handleAction() jumpItem:%s iJumpItemCallback:%s", new Object[] { str1, str2 });
      if (paramcoi != null) {
        break label68;
      }
      AppMethodBeat.o(72754);
      return;
      str1 = "null";
      break;
    }
    label68:
    switch (paramcoi.action)
    {
    }
    for (;;)
    {
      if (parama != null) {
        parama.fAg();
      }
      AppMethodBeat.o(72754);
      return;
      if (parama != null)
      {
        parama.fAe();
        continue;
        if (parama != null)
        {
          parama.fAl();
          continue;
          if (parama != null)
          {
            parama.dS(paramInputType);
            continue;
            paramInputType = new Intent();
            paramInputType.putExtra("rawUrl", paramcoi.url);
            g.aJ(paramContext, paramInputType);
            continue;
            for (;;)
            {
              try
              {
                paramInputType = new xw();
                paramInputType.fWN.userName = paramcoi.username;
                paramInputType.fWN.fWP = paramcoi.InB;
                if (parama == null) {
                  break label292;
                }
                paramInputType.fWN.scene = parama.fAf();
                paramInputType.fWN.fWQ = 0;
                paramInputType.fWN.context = paramContext;
                EventCenter.instance.publish(paramInputType);
              }
              catch (Exception paramContext)
              {
                Log.e("MicroMsg.JumpItemUtil", "handleAction() Exception: %s", new Object[] { paramContext.getMessage() });
              }
              break;
              label292:
              paramInputType.fWN.scene = 1000;
            }
            if (parama != null) {
              parama.fAh();
            }
          }
        }
      }
    }
  }
  
  public static <InputType> void a(Context paramContext, final dwg paramdwg, final InputType paramInputType, final a<InputType> parama)
  {
    AppMethodBeat.i(72755);
    if (paramdwg == null)
    {
      Log.i("MicroMsg.JumpItemUtil", "showRemindWin() remindWin == null");
      AppMethodBeat.o(72755);
      return;
    }
    h.a(paramContext, paramdwg.wording, "", paramdwg.Phe.wording, paramContext.getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72743);
        Log.i("MicroMsg.JumpItemUtil", "showRemindWin() ok click!");
        l.a(this.val$context, paramdwg.Phe, paramInputType, parama);
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
  
  public static String b(coi paramcoi)
  {
    AppMethodBeat.i(72749);
    if (paramcoi == null)
    {
      AppMethodBeat.o(72749);
      return "JumpItem{null}";
    }
    paramcoi = "JumpItem{wording='" + paramcoi.wording + '\'' + ", action=" + paramcoi.action + ", url='" + paramcoi.url + '\'' + ", username='" + paramcoi.username + '\'' + ", pagepath='" + paramcoi.InB + '\'' + '}';
    AppMethodBeat.o(72749);
    return paramcoi;
  }
  
  public static coi bCj(String paramString)
  {
    AppMethodBeat.i(72752);
    try
    {
      paramString = ct(new JSONObject(paramString));
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
  
  public static JSONObject c(coi paramcoi)
  {
    AppMethodBeat.i(72751);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", paramcoi.wording);
      localJSONObject.put("action", paramcoi.action);
      localJSONObject.put("url", paramcoi.url);
      localJSONObject.put("username", paramcoi.username);
      localJSONObject.put("pagepath", paramcoi.InB);
      AppMethodBeat.o(72751);
      return localJSONObject;
    }
    catch (JSONException paramcoi)
    {
      for (;;)
      {
        Log.e("MicroMsg.JumpItemUtil", "getJSONObject() Exception: %s", new Object[] { paramcoi.getMessage() });
      }
    }
  }
  
  public static String cn(LinkedList<coi> paramLinkedList)
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
      localStringBuilder.append(b((coi)paramLinkedList.next())).append(", ");
    }
    localStringBuilder.append("}");
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(72750);
    return paramLinkedList;
  }
  
  public static coi ct(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72753);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JumpItemUtil", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(72753);
      return null;
    }
    coi localcoi = new coi();
    localcoi.wording = paramJSONObject.optString("wording");
    localcoi.action = paramJSONObject.optInt("action");
    localcoi.url = paramJSONObject.optString("url");
    localcoi.username = paramJSONObject.optString("username");
    localcoi.InB = paramJSONObject.optString("pagepath");
    AppMethodBeat.o(72753);
    return localcoi;
  }
  
  public static abstract interface a<InputType>
  {
    public abstract void dS(InputType paramInputType);
    
    public abstract void fAe();
    
    public abstract int fAf();
    
    public abstract void fAg();
    
    public abstract void fAh();
    
    public abstract void fAl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */