package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public static final p GnV;
  eiw GnW;
  
  static
  {
    AppMethodBeat.i(126175);
    GnV = new p();
    AppMethodBeat.o(126175);
  }
  
  public static void a(MMActivity paramMMActivity, eit parameit, eiw parameiw)
  {
    AppMethodBeat.i(126174);
    cz localcz = new cz();
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    if (Util.isNullOrNil(parameiw.xDQ)) {}
    for (Object localObject = paramMMActivity.getString(2131764255);; localObject = parameiw.xDQ)
    {
      localaml.bgl(parameiw.rCq);
      localaml.bgf(parameiw.msN);
      localaml.bgg((String)localObject);
      localaml.bgo(parameiw.IED);
      localaml.As(true);
      localaml.At(true);
      localaml.ajd(5);
      anq localanq = new anq();
      localanq.bhv(parameiw.IED);
      localanq.bhs(parameiw.msN);
      localanq.bht((String)localObject);
      localanb.b(localanq);
      localObject = new aj();
      ((aj)localObject).IEy = parameiw.psI;
      ((aj)localObject).IEz = parameiw.Nir;
      ((aj)localObject).IEA = parameit.hes;
      ((aj)localObject).IEB = parameiw.Niq;
      ((aj)localObject).IEC = 100201L;
      ((aj)localObject).rCq = parameiw.rCq;
      ((aj)localObject).msN = parameiw.msN;
      ((aj)localObject).xDQ = parameiw.xDQ;
      ((aj)localObject).IED = parameiw.IED;
      ((aj)localObject).IEE = parameiw.IEE;
      ((aj)localObject).IEF = parameiw.IEF;
      ((aj)localObject).source = parameiw.source;
      ((aj)localObject).eby = parameiw.eby;
      ((aj)localObject).IEG = parameiw.IEG;
      ((aj)localObject).IEH = parameiw.IEH;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(parameit.IDO);
      localLinkedList.addAll(parameiw.IDO);
      ((aj)localObject).IEJ = h.hK(parameiw.xuO).toString();
      ((aj)localObject).IEI = hL(localLinkedList).toString();
      ((aj)localObject).IEK = parameiw.Niy;
      ((aj)localObject).thumbUrl = parameiw.Nio;
      parameit = new StringBuilder();
      ((aj)localObject).a(parameit, null, null, null, 0, 0);
      localanq.bhx(parameit.toString());
      localanh.bhf(z.aTY());
      localanh.bhg(z.aTY());
      localanh.ajm(3);
      localanh.MA(Util.nowMilliSecond());
      localanh.bhm(parameiw.rCq);
      localanh.bhh(parameiw.rCq);
      localcz.dFZ.title = localaml.title;
      localcz.dFZ.dGb = localanb;
      localcz.dFZ.dGf = 25;
      localcz.dFZ.scene = 2;
      localcz.dFZ.type = 5;
      localcz.dFZ.activity = paramMMActivity;
      localanb.a(localanh);
      localanb.ppH.add(localaml);
      EventCenter.instance.publish(localcz);
      AppMethodBeat.o(126174);
      return;
    }
  }
  
  static JSONArray hL(List<aca> paramList)
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
        aca localaca = (aca)paramList.get(i);
        localJSONObject.put("key", localaca.key);
        localJSONObject.put("uintValue", localaca.LmC);
        localJSONObject.put("textValue", localaca.LmD);
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
  
  static boolean l(eiw parameiw)
  {
    return (parameiw.Niy != 100201L) && (parameiw.Niy != 100203L);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126172);
    if (paramInt1 == 1024)
    {
      if (paramInt2 == -1)
      {
        Toast.makeText(MMApplicationContext.getContext(), 2131755986, 1).show();
        i.a(paramb.fyD(), this.GnW, "1", z.aTY(), "");
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
          if (ab.Eq(str))
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
        i.a(paramb.fyD(), this.GnW, paramIntent.toString(), z.aTY(), localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(126172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */