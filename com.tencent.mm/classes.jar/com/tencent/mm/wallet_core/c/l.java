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
import com.tencent.mm.g.a.vm;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static String a(bry parambry)
  {
    AppMethodBeat.i(72749);
    if (parambry == null)
    {
      AppMethodBeat.o(72749);
      return "JumpItem{null}";
    }
    parambry = "JumpItem{wording='" + parambry.dxD + '\'' + ", action=" + parambry.action + ", url='" + parambry.url + '\'' + ", username='" + parambry.username + '\'' + ", pagepath='" + parambry.xZB + '\'' + '}';
    AppMethodBeat.o(72749);
    return parambry;
  }
  
  public static <InputType> void a(Context paramContext, bry parambry, InputType paramInputType, a<InputType> parama)
  {
    AppMethodBeat.i(72754);
    String str1;
    if (parambry == null)
    {
      str1 = a(parambry);
      if (parama != null) {
        break label61;
      }
    }
    label61:
    for (String str2 = "null";; str2 = "no null")
    {
      ad.i("MicroMsg.JumpItemUtil", "handleAction() jumpItem:%s iJumpItemCallback:%s", new Object[] { str1, str2 });
      if (parambry != null) {
        break label68;
      }
      AppMethodBeat.o(72754);
      return;
      str1 = "null";
      break;
    }
    label68:
    switch (parambry.action)
    {
    }
    for (;;)
    {
      if (parama != null) {
        parama.dJa();
      }
      AppMethodBeat.o(72754);
      return;
      if (parama != null)
      {
        parama.dIY();
        continue;
        if (parama != null)
        {
          parama.dJf();
          continue;
          if (parama != null)
          {
            parama.dF(paramInputType);
            continue;
            paramInputType = new Intent();
            paramInputType.putExtra("rawUrl", parambry.url);
            e.an(paramContext, paramInputType);
            continue;
            for (;;)
            {
              try
              {
                paramInputType = new vm();
                paramInputType.dJF.userName = parambry.username;
                paramInputType.dJF.dJH = parambry.xZB;
                if (parama == null) {
                  break label291;
                }
                paramInputType.dJF.scene = parama.dIZ();
                paramInputType.dJF.dJI = 0;
                paramInputType.dJF.context = paramContext;
                a.IbL.l(paramInputType);
              }
              catch (Exception paramContext)
              {
                ad.e("MicroMsg.JumpItemUtil", "handleAction() Exception: %s", new Object[] { paramContext.getMessage() });
              }
              break;
              label291:
              paramInputType.dJF.scene = 1000;
            }
            if (parama != null) {
              parama.dJb();
            }
          }
        }
      }
    }
  }
  
  public static <InputType> void a(Context paramContext, final ctf paramctf, final InputType paramInputType, final a<InputType> parama)
  {
    AppMethodBeat.i(72755);
    if (paramctf == null)
    {
      ad.i("MicroMsg.JumpItemUtil", "showRemindWin() remindWin == null");
      AppMethodBeat.o(72755);
      return;
    }
    h.a(paramContext, paramctf.dxD, "", paramctf.DnW.dxD, paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72743);
        ad.i("MicroMsg.JumpItemUtil", "showRemindWin() ok click!");
        l.a(this.val$context, paramctf.DnW, paramInputType, parama);
        AppMethodBeat.o(72743);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72744);
        ad.i("MicroMsg.JumpItemUtil", "showRemindWin() cancel click!");
        AppMethodBeat.o(72744);
      }
    }).show();
    AppMethodBeat.o(72755);
  }
  
  public static <InputType> void a(Context paramContext, final yn paramyn, final InputType paramInputType, final a<InputType> parama, final a parama1)
  {
    AppMethodBeat.i(72756);
    if (paramyn == null)
    {
      ad.i("MicroMsg.JumpItemUtil", "showCheckWin() checkWin == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramyn.DnV == null) || (paramyn.DnW == null))
    {
      ad.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button == null || right_button == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramyn.FXZ == null) || (paramyn.FXZ.isEmpty()))
    {
      ad.i("MicroMsg.JumpItemUtil", "showCheckWin() check_item == null || check_item.isEmpty()");
      AppMethodBeat.o(72756);
      return;
    }
    View localView1 = LayoutInflater.from(paramContext).inflate(2131493528, null);
    ((TextView)localView1.findViewById(2131305529)).setText(paramyn.subtitle);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131301144);
    int i = 0;
    while (i < paramyn.FXZ.size())
    {
      View localView2 = LayoutInflater.from(paramContext).inflate(2131493527, null);
      ((TextView)localView2.findViewById(2131301158)).setText(((bsm)paramyn.FXZ.get(i)).key);
      ((TextView)localView2.findViewById(2131301201)).setText(((bsm)paramyn.FXZ.get(i)).value);
      localLinearLayout.addView(localView2);
      i += 1;
    }
    h.a(paramContext, false, paramyn.title, localView1, paramyn.DnW.dxD, paramyn.DnV.dxD, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72745);
        ad.i("MicroMsg.JumpItemUtil", "showCheckWin() right_button click!");
        l.a(this.val$context, paramyn.DnW, paramInputType, parama1);
        AppMethodBeat.o(72745);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72746);
        ad.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button click!");
        l.a(this.val$context, paramyn.DnV, paramInputType, parama);
        AppMethodBeat.o(72746);
      }
    }).show();
    AppMethodBeat.o(72756);
  }
  
  public static bry aYB(String paramString)
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
      ad.e("MicroMsg.JumpItemUtil", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(72752);
    }
    return null;
  }
  
  public static JSONObject b(bry parambry)
  {
    AppMethodBeat.i(72751);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", parambry.dxD);
      localJSONObject.put("action", parambry.action);
      localJSONObject.put("url", parambry.url);
      localJSONObject.put("username", parambry.username);
      localJSONObject.put("pagepath", parambry.xZB);
      AppMethodBeat.o(72751);
      return localJSONObject;
    }
    catch (JSONException parambry)
    {
      for (;;)
      {
        ad.e("MicroMsg.JumpItemUtil", "getJSONObject() Exception: %s", new Object[] { parambry.getMessage() });
      }
    }
  }
  
  public static bry bI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72753);
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.JumpItemUtil", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(72753);
      return null;
    }
    bry localbry = new bry();
    localbry.dxD = paramJSONObject.optString("wording");
    localbry.action = paramJSONObject.optInt("action");
    localbry.url = paramJSONObject.optString("url");
    localbry.username = paramJSONObject.optString("username");
    localbry.xZB = paramJSONObject.optString("pagepath");
    AppMethodBeat.o(72753);
    return localbry;
  }
  
  public static String bs(LinkedList<bry> paramLinkedList)
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
      localStringBuilder.append(a((bry)paramLinkedList.next())).append(", ");
    }
    localStringBuilder.append("}");
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(72750);
    return paramLinkedList;
  }
  
  public static abstract interface a<InputType>
  {
    public abstract void dF(InputType paramInputType);
    
    public abstract void dIY();
    
    public abstract int dIZ();
    
    public abstract void dJa();
    
    public abstract void dJb();
    
    public abstract void dJf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */