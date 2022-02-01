package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public static final p Aee;
  dio Aef;
  
  static
  {
    AppMethodBeat.i(126175);
    Aee = new p();
    AppMethodBeat.o(126175);
  }
  
  public static void a(MMActivity paramMMActivity, dil paramdil, dio paramdio)
  {
    AppMethodBeat.i(126174);
    cs localcs = new cs();
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    if (bs.isNullOrNil(paramdio.tcG)) {}
    for (Object localObject = paramMMActivity.getString(2131762231);; localObject = paramdio.tcG)
    {
      localagx.aII(paramdio.pBl);
      localagx.aIC(paramdio.pBm);
      localagx.aID((String)localObject);
      localagx.aIL(paramdio.BYP);
      localagx.vy(true);
      localagx.vz(true);
      localagx.XM(5);
      aic localaic = new aic();
      localaic.aJS(paramdio.BYP);
      localaic.aJP(paramdio.pBm);
      localaic.aJQ((String)localObject);
      localahn.b(localaic);
      localObject = new aa();
      ((aa)localObject).BYK = paramdio.sVF;
      ((aa)localObject).BYL = paramdio.FRQ;
      ((aa)localObject).BYM = paramdil.jKB;
      ((aa)localObject).BYN = paramdio.FRP;
      ((aa)localObject).BYO = 100201L;
      ((aa)localObject).pBl = paramdio.pBl;
      ((aa)localObject).pBm = paramdio.pBm;
      ((aa)localObject).tcG = paramdio.tcG;
      ((aa)localObject).BYP = paramdio.BYP;
      ((aa)localObject).BYQ = paramdio.BYQ;
      ((aa)localObject).BYR = paramdio.BYR;
      ((aa)localObject).source = paramdio.source;
      ((aa)localObject).kRU = paramdio.kRU;
      ((aa)localObject).BYS = paramdio.BYS;
      ((aa)localObject).BYT = paramdio.BYT;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(paramdil.BYq);
      localLinkedList.addAll(paramdio.BYq);
      ((aa)localObject).BYV = h.go(paramdio.sVE).toString();
      ((aa)localObject).BYU = gp(localLinkedList).toString();
      ((aa)localObject).BYW = paramdio.FRY;
      ((aa)localObject).thumbUrl = paramdio.FRN;
      paramdil = new StringBuilder();
      ((aa)localObject).a(paramdil, null, null, null, 0, 0);
      localaic.aJU(paramdil.toString());
      localaht.aJC(u.axw());
      localaht.aJD(u.axw());
      localaht.XV(3);
      localaht.zY(bs.eWj());
      localaht.aJJ(paramdio.pBl);
      localaht.aJE(paramdio.pBl);
      localcs.dck.title = localagx.title;
      localcs.dck.dcm = localahn;
      localcs.dck.dcq = 25;
      localcs.dck.scene = 2;
      localcs.dck.type = 5;
      localcs.dck.activity = paramMMActivity;
      localahn.a(localaht);
      localahn.nxC.add(localagx);
      a.GpY.l(localcs);
      AppMethodBeat.o(126174);
      return;
    }
  }
  
  static JSONArray gp(List<yh> paramList)
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
        yh localyh = (yh)paramList.get(i);
        localJSONObject.put("key", localyh.key);
        localJSONObject.put("uintValue", localyh.ErV);
        localJSONObject.put("textValue", localyh.ErW);
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
  
  static boolean k(dio paramdio)
  {
    return (paramdio.FRY != 100201L) && (paramdio.FRY != 100203L);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126172);
    if (paramInt1 == 1024)
    {
      if (paramInt2 == -1)
      {
        Toast.makeText(ai.getContext(), 2131755894, 1).show();
        i.a(paramb.edh(), this.Aef, "1", u.axw(), "");
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
          if (w.sQ(str))
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
        i.a(paramb.edh(), this.Aef, paramIntent.toString(), u.axw(), localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(126172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */