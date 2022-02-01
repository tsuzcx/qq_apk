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
import com.tencent.mm.g.a.uj;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.we;
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
  public static String a(bjt parambjt)
  {
    AppMethodBeat.i(72749);
    if (parambjt == null)
    {
      AppMethodBeat.o(72749);
      return "JumpItem{null}";
    }
    parambjt = "JumpItem{wording='" + parambjt.doh + '\'' + ", action=" + parambjt.action + ", url='" + parambjt.url + '\'' + ", username='" + parambjt.username + '\'' + ", pagepath='" + parambjt.vBP + '\'' + '}';
    AppMethodBeat.o(72749);
    return parambjt;
  }
  
  public static <InputType> void a(Context paramContext, bjt parambjt, InputType paramInputType, a<InputType> parama)
  {
    AppMethodBeat.i(72754);
    String str1;
    if (parambjt == null)
    {
      str1 = a(parambjt);
      if (parama != null) {
        break label61;
      }
    }
    label61:
    for (String str2 = "null";; str2 = "no null")
    {
      ad.i("MicroMsg.JumpItemUtil", "handleAction() jumpItem:%s iJumpItemCallback:%s", new Object[] { str1, str2 });
      if (parambjt != null) {
        break label68;
      }
      AppMethodBeat.o(72754);
      return;
      str1 = "null";
      break;
    }
    label68:
    switch (parambjt.action)
    {
    }
    for (;;)
    {
      if (parama != null) {
        parama.djG();
      }
      AppMethodBeat.o(72754);
      return;
      if (parama != null)
      {
        parama.djE();
        continue;
        if (parama != null)
        {
          parama.djL();
          continue;
          if (parama != null)
          {
            parama.dB(paramInputType);
            continue;
            paramInputType = new Intent();
            paramInputType.putExtra("rawUrl", parambjt.url);
            e.X(paramContext, paramInputType);
            continue;
            for (;;)
            {
              try
              {
                paramInputType = new uj();
                paramInputType.dzH.userName = parambjt.username;
                paramInputType.dzH.dzJ = parambjt.vBP;
                if (parama == null) {
                  break label291;
                }
                paramInputType.dzH.scene = parama.djF();
                paramInputType.dzH.dzK = 0;
                paramInputType.dzH.context = paramContext;
                a.ESL.l(paramInputType);
              }
              catch (Exception paramContext)
              {
                ad.e("MicroMsg.JumpItemUtil", "handleAction() Exception: %s", new Object[] { paramContext.getMessage() });
              }
              break;
              label291:
              paramInputType.dzH.scene = 1000;
            }
            if (parama != null) {
              parama.djH();
            }
          }
        }
      }
    }
  }
  
  public static <InputType> void a(Context paramContext, final civ paramciv, final InputType paramInputType, final a<InputType> parama)
  {
    AppMethodBeat.i(72755);
    if (paramciv == null)
    {
      ad.i("MicroMsg.JumpItemUtil", "showRemindWin() remindWin == null");
      AppMethodBeat.o(72755);
      return;
    }
    h.a(paramContext, paramciv.doh, "", paramciv.Avk.doh, paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new l.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72743);
        ad.i("MicroMsg.JumpItemUtil", "showRemindWin() ok click!");
        l.a(this.val$context, paramciv.Avk, paramInputType, parama);
        AppMethodBeat.o(72743);
      }
    }, new l.2()).show();
    AppMethodBeat.o(72755);
  }
  
  public static <InputType> void a(Context paramContext, final we paramwe, final InputType paramInputType, final a<InputType> parama, final a parama1)
  {
    AppMethodBeat.i(72756);
    if (paramwe == null)
    {
      ad.i("MicroMsg.JumpItemUtil", "showCheckWin() checkWin == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramwe.Avj == null) || (paramwe.Avk == null))
    {
      ad.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button == null || right_button == null");
      AppMethodBeat.o(72756);
      return;
    }
    if ((paramwe.CYg == null) || (paramwe.CYg.isEmpty()))
    {
      ad.i("MicroMsg.JumpItemUtil", "showCheckWin() check_item == null || check_item.isEmpty()");
      AppMethodBeat.o(72756);
      return;
    }
    View localView1 = LayoutInflater.from(paramContext).inflate(2131493528, null);
    ((TextView)localView1.findViewById(2131305529)).setText(paramwe.subtitle);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131301144);
    int i = 0;
    while (i < paramwe.CYg.size())
    {
      View localView2 = LayoutInflater.from(paramContext).inflate(2131493527, null);
      ((TextView)localView2.findViewById(2131301158)).setText(((bkg)paramwe.CYg.get(i)).key);
      ((TextView)localView2.findViewById(2131301201)).setText(((bkg)paramwe.CYg.get(i)).value);
      localLinearLayout.addView(localView2);
      i += 1;
    }
    h.a(paramContext, false, paramwe.title, localView1, paramwe.Avk.doh, paramwe.Avj.doh, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72745);
        ad.i("MicroMsg.JumpItemUtil", "showCheckWin() right_button click!");
        l.a(this.val$context, paramwe.Avk, paramInputType, parama1);
        AppMethodBeat.o(72745);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72746);
        ad.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button click!");
        l.a(this.val$context, paramwe.Avj, paramInputType, parama);
        AppMethodBeat.o(72746);
      }
    }).show();
    AppMethodBeat.o(72756);
  }
  
  public static bjt aMZ(String paramString)
  {
    AppMethodBeat.i(72752);
    try
    {
      paramString = by(new JSONObject(paramString));
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
  
  public static JSONObject b(bjt parambjt)
  {
    AppMethodBeat.i(72751);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", parambjt.doh);
      localJSONObject.put("action", parambjt.action);
      localJSONObject.put("url", parambjt.url);
      localJSONObject.put("username", parambjt.username);
      localJSONObject.put("pagepath", parambjt.vBP);
      AppMethodBeat.o(72751);
      return localJSONObject;
    }
    catch (JSONException parambjt)
    {
      for (;;)
      {
        ad.e("MicroMsg.JumpItemUtil", "getJSONObject() Exception: %s", new Object[] { parambjt.getMessage() });
      }
    }
  }
  
  public static String bm(LinkedList<bjt> paramLinkedList)
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
      localStringBuilder.append(a((bjt)paramLinkedList.next())).append(", ");
    }
    localStringBuilder.append("}");
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(72750);
    return paramLinkedList;
  }
  
  public static bjt by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72753);
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.JumpItemUtil", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(72753);
      return null;
    }
    bjt localbjt = new bjt();
    localbjt.doh = paramJSONObject.optString("wording");
    localbjt.action = paramJSONObject.optInt("action");
    localbjt.url = paramJSONObject.optString("url");
    localbjt.username = paramJSONObject.optString("username");
    localbjt.vBP = paramJSONObject.optString("pagepath");
    AppMethodBeat.o(72753);
    return localbjt;
  }
  
  public static abstract interface a<InputType>
  {
    public abstract void dB(InputType paramInputType);
    
    public abstract void djE();
    
    public abstract int djF();
    
    public abstract void djG();
    
    public abstract void djH();
    
    public abstract void djL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */