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
import com.tencent.mm.g.a.vq;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.yq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static String a(bss parambss)
  {
    AppMethodBeat.i(72749);
    if (parambss == null)
    {
      AppMethodBeat.o(72749);
      return "JumpItem{null}";
    }
    parambss = "JumpItem{wording='" + parambss.dyI + '\'' + ", action=" + parambss.action + ", url='" + parambss.url + '\'' + ", username='" + parambss.username + '\'' + ", pagepath='" + parambss.ypt + '\'' + '}';
    AppMethodBeat.o(72749);
    return parambss;
  }
  
  public static <InputType> void a(Context paramContext, bss parambss, InputType paramInputType, a<InputType> parama)
  {
    AppMethodBeat.i(72754);
    String str1;
    if (parambss == null)
    {
      str1 = a(parambss);
      if (parama != null) {
        break label61;
      }
    }
    label61:
    for (String str2 = "null";; str2 = "no null")
    {
      ae.i("MicroMsg.JumpItemUtil", "handleAction() jumpItem:%s iJumpItemCallback:%s", new Object[] { str1, str2 });
      if (parambss != null) {
        break label68;
      }
      AppMethodBeat.o(72754);
      return;
      str1 = "null";
      break;
    }
    label68:
    switch (parambss.action)
    {
    }
    for (;;)
    {
      if (parama != null) {
        parama.dMr();
      }
      AppMethodBeat.o(72754);
      return;
      if (parama != null)
      {
        parama.dMp();
        continue;
        if (parama != null)
        {
          parama.dMw();
          continue;
          if (parama != null)
          {
            parama.dG(paramInputType);
            continue;
            paramInputType = new Intent();
            paramInputType.putExtra("rawUrl", parambss.url);
            f.an(paramContext, paramInputType);
            continue;
            for (;;)
            {
              try
              {
                paramInputType = new vq();
                paramInputType.dKT.userName = parambss.username;
                paramInputType.dKT.dKV = parambss.ypt;
                if (parama == null) {
                  break label291;
                }
                paramInputType.dKT.scene = parama.dMq();
                paramInputType.dKT.dKW = 0;
                paramInputType.dKT.context = paramContext;
                a.IvT.l(paramInputType);
              }
              catch (Exception paramContext)
              {
                ae.e("MicroMsg.JumpItemUtil", "handleAction() Exception: %s", new Object[] { paramContext.getMessage() });
              }
              break;
              label291:
              paramInputType.dKT.scene = 1000;
            }
            if (parama != null) {
              parama.dMs();
            }
          }
        }
      }
    }
  }
  
  public static <InputType> void a(Context paramContext, final ctz paramctz, final InputType paramInputType, final a<InputType> parama)
  {
    AppMethodBeat.i(72755);
    if (paramctz == null)
    {
      ae.i("MicroMsg.JumpItemUtil", "showRemindWin() remindWin == null");
      AppMethodBeat.o(72755);
      return;
    }
    h.a(paramContext, paramctz.dyI, "", paramctz.DFB.dyI, paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72743);
        ae.i("MicroMsg.JumpItemUtil", "showRemindWin() ok click!");
        l.a(this.val$context, paramctz.DFB, paramInputType, parama);
        AppMethodBeat.o(72743);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72744);
        ae.i("MicroMsg.JumpItemUtil", "showRemindWin() cancel click!");
        AppMethodBeat.o(72744);
      }
    }).show();
    AppMethodBeat.o(72755);
  }
  
  public static <InputType> void a(Context paramContext, final yq paramyq, final InputType paramInputType, final a<InputType> parama, final a parama1)
  {
    AppMethodBeat.i(72756);
    if (paramyq == null)
    {
      ae.i("MicroMsg.JumpItemUtil", "showCheckWin() checkWin == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramyq.DFA == null) || (paramyq.DFB == null))
    {
      ae.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button == null || right_button == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramyq.Gqy == null) || (paramyq.Gqy.isEmpty()))
    {
      ae.i("MicroMsg.JumpItemUtil", "showCheckWin() check_item == null || check_item.isEmpty()");
      AppMethodBeat.o(72756);
      return;
    }
    View localView1 = LayoutInflater.from(paramContext).inflate(2131493528, null);
    ((TextView)localView1.findViewById(2131305529)).setText(paramyq.subtitle);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131301144);
    int i = 0;
    while (i < paramyq.Gqy.size())
    {
      View localView2 = LayoutInflater.from(paramContext).inflate(2131493527, null);
      ((TextView)localView2.findViewById(2131301158)).setText(((btg)paramyq.Gqy.get(i)).key);
      ((TextView)localView2.findViewById(2131301201)).setText(((btg)paramyq.Gqy.get(i)).value);
      localLinearLayout.addView(localView2);
      i += 1;
    }
    h.a(paramContext, false, paramyq.title, localView1, paramyq.DFB.dyI, paramyq.DFA.dyI, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72745);
        ae.i("MicroMsg.JumpItemUtil", "showCheckWin() right_button click!");
        l.a(this.val$context, paramyq.DFB, paramInputType, parama1);
        AppMethodBeat.o(72745);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72746);
        ae.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button click!");
        l.a(this.val$context, paramyq.DFA, paramInputType, parama);
        AppMethodBeat.o(72746);
      }
    }).show();
    AppMethodBeat.o(72756);
  }
  
  public static JSONObject b(bss parambss)
  {
    AppMethodBeat.i(72751);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", parambss.dyI);
      localJSONObject.put("action", parambss.action);
      localJSONObject.put("url", parambss.url);
      localJSONObject.put("username", parambss.username);
      localJSONObject.put("pagepath", parambss.ypt);
      AppMethodBeat.o(72751);
      return localJSONObject;
    }
    catch (JSONException parambss)
    {
      for (;;)
      {
        ae.e("MicroMsg.JumpItemUtil", "getJSONObject() Exception: %s", new Object[] { parambss.getMessage() });
      }
    }
  }
  
  public static bss bI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72753);
    if (paramJSONObject == null)
    {
      ae.w("MicroMsg.JumpItemUtil", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(72753);
      return null;
    }
    bss localbss = new bss();
    localbss.dyI = paramJSONObject.optString("wording");
    localbss.action = paramJSONObject.optInt("action");
    localbss.url = paramJSONObject.optString("url");
    localbss.username = paramJSONObject.optString("username");
    localbss.ypt = paramJSONObject.optString("pagepath");
    AppMethodBeat.o(72753);
    return localbss;
  }
  
  public static bss bae(String paramString)
  {
    AppMethodBeat.i(72752);
    try
    {
      paramString = bI(new JSONObject(paramString));
      AppMethodBeat.o(72752);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ae.e("MicroMsg.JumpItemUtil", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(72752);
    }
    return null;
  }
  
  public static String bt(LinkedList<bss> paramLinkedList)
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
      localStringBuilder.append(a((bss)paramLinkedList.next())).append(", ");
    }
    localStringBuilder.append("}");
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(72750);
    return paramLinkedList;
  }
  
  public static abstract interface a<InputType>
  {
    public abstract void dG(InputType paramInputType);
    
    public abstract void dMp();
    
    public abstract int dMq();
    
    public abstract void dMr();
    
    public abstract void dMs();
    
    public abstract void dMw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */