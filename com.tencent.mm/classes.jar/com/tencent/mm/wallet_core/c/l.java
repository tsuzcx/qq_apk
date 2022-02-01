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
import com.tencent.mm.g.a.wq;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static <InputType> void a(Context paramContext, final aae paramaae, final InputType paramInputType, final a<InputType> parama, final a parama1)
  {
    AppMethodBeat.i(72756);
    if (paramaae == null)
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() checkWin == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramaae.IoL == null) || (paramaae.IoM == null))
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button == null || right_button == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramaae.Llq == null) || (paramaae.Llq.isEmpty()))
    {
      Log.i("MicroMsg.JumpItemUtil", "showCheckWin() check_item == null || check_item.isEmpty()");
      AppMethodBeat.o(72756);
      return;
    }
    View localView1 = LayoutInflater.from(paramContext).inflate(2131493640, null);
    ((TextView)localView1.findViewById(2131308746)).setText(paramaae.subtitle);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131302798);
    int i = 0;
    while (i < paramaae.Llq.size())
    {
      View localView2 = LayoutInflater.from(paramContext).inflate(2131493639, null);
      ((TextView)localView2.findViewById(2131302818)).setText(((cfz)paramaae.Llq.get(i)).key);
      ((TextView)localView2.findViewById(2131302873)).setText(((cfz)paramaae.Llq.get(i)).value);
      localLinearLayout.addView(localView2);
      i += 1;
    }
    h.a(paramContext, false, paramaae.title, localView1, paramaae.IoM.dQx, paramaae.IoL.dQx, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72745);
        Log.i("MicroMsg.JumpItemUtil", "showCheckWin() right_button click!");
        l.a(this.val$context, paramaae.IoM, paramInputType, parama1);
        AppMethodBeat.o(72745);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72746);
        Log.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button click!");
        l.a(this.val$context, paramaae.IoL, paramInputType, parama);
        AppMethodBeat.o(72746);
      }
    }).show();
    AppMethodBeat.o(72756);
  }
  
  public static <InputType> void a(Context paramContext, cfl paramcfl, InputType paramInputType, a<InputType> parama)
  {
    AppMethodBeat.i(72754);
    String str1;
    if (paramcfl == null)
    {
      str1 = b(paramcfl);
      if (parama != null) {
        break label61;
      }
    }
    label61:
    for (String str2 = "null";; str2 = "no null")
    {
      Log.i("MicroMsg.JumpItemUtil", "handleAction() jumpItem:%s iJumpItemCallback:%s", new Object[] { str1, str2 });
      if (paramcfl != null) {
        break label68;
      }
      AppMethodBeat.o(72754);
      return;
      str1 = "null";
      break;
    }
    label68:
    switch (paramcfl.action)
    {
    }
    for (;;)
    {
      if (parama != null) {
        parama.eNr();
      }
      AppMethodBeat.o(72754);
      return;
      if (parama != null)
      {
        parama.eNp();
        continue;
        if (parama != null)
        {
          parama.eNw();
          continue;
          if (parama != null)
          {
            parama.dP(paramInputType);
            continue;
            paramInputType = new Intent();
            paramInputType.putExtra("rawUrl", paramcfl.url);
            f.aA(paramContext, paramInputType);
            continue;
            for (;;)
            {
              try
              {
                paramInputType = new wq();
                paramInputType.ecI.userName = paramcfl.username;
                paramInputType.ecI.ecK = paramcfl.Cqk;
                if (parama == null) {
                  break label291;
                }
                paramInputType.ecI.scene = parama.eNq();
                paramInputType.ecI.ecL = 0;
                paramInputType.ecI.context = paramContext;
                EventCenter.instance.publish(paramInputType);
              }
              catch (Exception paramContext)
              {
                Log.e("MicroMsg.JumpItemUtil", "handleAction() Exception: %s", new Object[] { paramContext.getMessage() });
              }
              break;
              label291:
              paramInputType.ecI.scene = 1000;
            }
            if (parama != null) {
              parama.eNs();
            }
          }
        }
      }
    }
  }
  
  public static <InputType> void a(Context paramContext, final dmp paramdmp, final InputType paramInputType, final a<InputType> parama)
  {
    AppMethodBeat.i(72755);
    if (paramdmp == null)
    {
      Log.i("MicroMsg.JumpItemUtil", "showRemindWin() remindWin == null");
      AppMethodBeat.o(72755);
      return;
    }
    h.a(paramContext, paramdmp.dQx, "", paramdmp.IoM.dQx, paramContext.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72743);
        Log.i("MicroMsg.JumpItemUtil", "showRemindWin() ok click!");
        l.a(this.val$context, paramdmp.IoM, paramInputType, parama);
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
  
  public static String b(cfl paramcfl)
  {
    AppMethodBeat.i(72749);
    if (paramcfl == null)
    {
      AppMethodBeat.o(72749);
      return "JumpItem{null}";
    }
    paramcfl = "JumpItem{wording='" + paramcfl.dQx + '\'' + ", action=" + paramcfl.action + ", url='" + paramcfl.url + '\'' + ", username='" + paramcfl.username + '\'' + ", pagepath='" + paramcfl.Cqk + '\'' + '}';
    AppMethodBeat.o(72749);
    return paramcfl;
  }
  
  public static String bO(LinkedList<cfl> paramLinkedList)
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
      localStringBuilder.append(b((cfl)paramLinkedList.next())).append(", ");
    }
    localStringBuilder.append("}");
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(72750);
    return paramLinkedList;
  }
  
  public static cfl bpm(String paramString)
  {
    AppMethodBeat.i(72752);
    try
    {
      paramString = ci(new JSONObject(paramString));
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
  
  public static JSONObject c(cfl paramcfl)
  {
    AppMethodBeat.i(72751);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", paramcfl.dQx);
      localJSONObject.put("action", paramcfl.action);
      localJSONObject.put("url", paramcfl.url);
      localJSONObject.put("username", paramcfl.username);
      localJSONObject.put("pagepath", paramcfl.Cqk);
      AppMethodBeat.o(72751);
      return localJSONObject;
    }
    catch (JSONException paramcfl)
    {
      for (;;)
      {
        Log.e("MicroMsg.JumpItemUtil", "getJSONObject() Exception: %s", new Object[] { paramcfl.getMessage() });
      }
    }
  }
  
  public static cfl ci(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72753);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JumpItemUtil", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(72753);
      return null;
    }
    cfl localcfl = new cfl();
    localcfl.dQx = paramJSONObject.optString("wording");
    localcfl.action = paramJSONObject.optInt("action");
    localcfl.url = paramJSONObject.optString("url");
    localcfl.username = paramJSONObject.optString("username");
    localcfl.Cqk = paramJSONObject.optString("pagepath");
    AppMethodBeat.o(72753);
    return localcfl;
  }
  
  public static abstract interface a<InputType>
  {
    public abstract void dP(InputType paramInputType);
    
    public abstract void eNp();
    
    public abstract int eNq();
    
    public abstract void eNr();
    
    public abstract void eNs();
    
    public abstract void eNw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */