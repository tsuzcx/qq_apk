package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.xp;
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
  public static final p yQo;
  ddb yQp;
  
  static
  {
    AppMethodBeat.i(126175);
    yQo = new p();
    AppMethodBeat.o(126175);
  }
  
  public static void a(MMActivity paramMMActivity, dcy paramdcy, ddb paramddb)
  {
    AppMethodBeat.i(126174);
    cs localcs = new cs();
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    if (bt.isNullOrNil(paramddb.rUO)) {}
    for (Object localObject = paramMMActivity.getString(2131762231);; localObject = paramddb.rUO)
    {
      localafy.aDr(paramddb.oYa);
      localafy.aDl(paramddb.oYb);
      localafy.aDm((String)localObject);
      localafy.aDu(paramddb.AGx);
      localafy.uw(true);
      localafy.ux(true);
      localafy.VD(5);
      ahd localahd = new ahd();
      localahd.aEB(paramddb.AGx);
      localahd.aEy(paramddb.oYb);
      localahd.aEz((String)localObject);
      localago.b(localahd);
      localObject = new ab();
      ((ab)localObject).AGs = paramddb.rNP;
      ((ab)localObject).AGt = paramddb.EuP;
      ((ab)localObject).AGu = paramdcy.jko;
      ((ab)localObject).AGv = paramddb.EuO;
      ((ab)localObject).AGw = 100201L;
      ((ab)localObject).oYa = paramddb.oYa;
      ((ab)localObject).oYb = paramddb.oYb;
      ((ab)localObject).rUO = paramddb.rUO;
      ((ab)localObject).AGx = paramddb.AGx;
      ((ab)localObject).AGy = paramddb.AGy;
      ((ab)localObject).AGz = paramddb.AGz;
      ((ab)localObject).source = paramddb.source;
      ((ab)localObject).kqB = paramddb.kqB;
      ((ab)localObject).AGA = paramddb.AGA;
      ((ab)localObject).AGB = paramddb.AGB;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(paramdcy.AFX);
      localLinkedList.addAll(paramddb.AFX);
      ((ab)localObject).AGD = h.gh(paramddb.rNO).toString();
      ((ab)localObject).AGC = gi(localLinkedList).toString();
      ((ab)localObject).AGE = paramddb.EuX;
      ((ab)localObject).thumbUrl = paramddb.EuM;
      paramdcy = new StringBuilder();
      ((ab)localObject).b(paramdcy, null, null, null, 0, 0);
      localahd.aED(paramdcy.toString());
      localagu.aEl(u.aqG());
      localagu.aEm(u.aqG());
      localagu.VM(3);
      localagu.vv(bt.eGO());
      localagu.aEs(paramddb.oYa);
      localagu.aEn(paramddb.oYa);
      localcs.deQ.title = localafy.title;
      localcs.deQ.deS = localago;
      localcs.deQ.deW = 25;
      localcs.deQ.scene = 2;
      localcs.deQ.type = 5;
      localcs.deQ.activity = paramMMActivity;
      localago.a(localagu);
      localago.mVb.add(localafy);
      a.ESL.l(localcs);
      AppMethodBeat.o(126174);
      return;
    }
  }
  
  static JSONArray gi(List<xp> paramList)
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
        xp localxp = (xp)paramList.get(i);
        localJSONObject.put("key", localxp.key);
        localJSONObject.put("uintValue", localxp.CZi);
        localJSONObject.put("textValue", localxp.CZj);
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
  
  static boolean k(ddb paramddb)
  {
    return (paramddb.EuX != 100201L) && (paramddb.EuX != 100203L);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126172);
    if (paramInt1 == 1024)
    {
      if (paramInt2 == -1)
      {
        Toast.makeText(aj.getContext(), 2131755894, 1).show();
        i.a(paramb.dOH(), this.yQp, "1", u.aqG(), "");
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
          if (w.pF(str))
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
        i.a(paramb.dOH(), this.yQp, paramIntent.toString(), u.aqG(), localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(126172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */