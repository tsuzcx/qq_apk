package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public static final p BvQ;
  dod BvR;
  
  static
  {
    AppMethodBeat.i(126175);
    BvQ = new p();
    AppMethodBeat.o(126175);
  }
  
  public static void a(MMActivity paramMMActivity, doa paramdoa, dod paramdod)
  {
    AppMethodBeat.i(126174);
    cv localcv = new cv();
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    if (bt.isNullOrNil(paramdod.uaw)) {}
    for (Object localObject = paramMMActivity.getString(2131762231);; localObject = paramdod.uaw)
    {
      localajn.aOl(paramdod.qeQ);
      localajn.aOf(paramdod.qeR);
      localajn.aOg((String)localObject);
      localajn.aOo(paramdod.DBL);
      localajn.wk(true);
      localajn.wl(true);
      localajn.ZI(5);
      aks localaks = new aks();
      localaks.aPv(paramdod.DBL);
      localaks.aPs(paramdod.qeR);
      localaks.aPt((String)localObject);
      localakd.b(localaks);
      localObject = new ae();
      ((ae)localObject).DBG = paramdod.tSk;
      ((ae)localObject).DBH = paramdod.HCw;
      ((ae)localObject).DBI = paramdoa.keN;
      ((ae)localObject).DBJ = paramdod.HCv;
      ((ae)localObject).DBK = 100201L;
      ((ae)localObject).qeQ = paramdod.qeQ;
      ((ae)localObject).qeR = paramdod.qeR;
      ((ae)localObject).uaw = paramdod.uaw;
      ((ae)localObject).DBL = paramdod.DBL;
      ((ae)localObject).DBM = paramdod.DBM;
      ((ae)localObject).DBN = paramdod.DBN;
      ((ae)localObject).source = paramdod.source;
      ((ae)localObject).lox = paramdod.lox;
      ((ae)localObject).DBO = paramdod.DBO;
      ((ae)localObject).DBP = paramdod.DBP;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(paramdoa.DBj);
      localLinkedList.addAll(paramdod.DBj);
      ((ae)localObject).DBR = h.gz(paramdod.tSj).toString();
      ((ae)localObject).DBQ = gA(localLinkedList).toString();
      ((ae)localObject).DBS = paramdod.HCE;
      ((ae)localObject).thumbUrl = paramdod.HCt;
      paramdoa = new StringBuilder();
      ((ae)localObject).a(paramdoa, null, null, null, 0, 0);
      localaks.aPx(paramdoa.toString());
      localakj.aPf(u.aAm());
      localakj.aPg(u.aAm());
      localakj.ZR(3);
      localakj.CM(bt.flT());
      localakj.aPm(paramdod.qeQ);
      localakj.aPh(paramdod.qeQ);
      localcv.dnG.title = localajn.title;
      localcv.dnG.dnI = localakd;
      localcv.dnG.dnM = 25;
      localcv.dnG.scene = 2;
      localcv.dnG.type = 5;
      localcv.dnG.activity = paramMMActivity;
      localakd.a(localakj);
      localakd.nZa.add(localajn);
      a.IbL.l(localcv);
      AppMethodBeat.o(126174);
      return;
    }
  }
  
  static JSONArray gA(List<aag> paramList)
  {
    AppMethodBeat.i(126173);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        aag localaag = (aag)paramList.get(i);
        localJSONObject.put("key", localaag.key);
        localJSONObject.put("uintValue", localaag.FZe);
        localJSONObject.put("textValue", localaag.FZf);
        localJSONArray.put(localJSONObject);
        label91:
        i += 1;
        continue;
        AppMethodBeat.o(126173);
        return localJSONArray;
      }
      catch (Exception localException)
      {
        break label91;
      }
    }
  }
  
  static boolean k(dod paramdod)
  {
    return (paramdod.HCE != 100201L) && (paramdod.HCE != 100203L);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126172);
    if (paramInt1 == 1024)
    {
      if (paramInt2 == -1)
      {
        Toast.makeText(aj.getContext(), 2131755894, 1).show();
        i.a(paramb.epz(), this.BvR, "1", u.aAm(), "");
        AppMethodBeat.o(126172);
      }
    }
    else if ((paramInt1 == 2048) && (paramInt2 == -1))
    {
      Object localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramIntent = new StringBuilder("");
        StringBuilder localStringBuilder = new StringBuilder("");
        localObject = ((ArrayList)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (w.vF(str))
          {
            paramIntent.append(3);
            paramIntent.append(";");
          }
          for (;;)
          {
            localStringBuilder.append(str);
            localStringBuilder.append(";");
            break;
            paramIntent.append(2);
            paramIntent.append(";");
          }
        }
        i.a(paramb.epz(), this.BvR, paramIntent.toString(), u.aAm(), localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(126172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */