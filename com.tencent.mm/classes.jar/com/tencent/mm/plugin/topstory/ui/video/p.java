package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
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
  public static final p NaI;
  esy NaJ;
  
  static
  {
    AppMethodBeat.i(126175);
    NaI = new p();
    AppMethodBeat.o(126175);
  }
  
  public static void a(MMActivity paramMMActivity, esv paramesv, esy paramesy)
  {
    AppMethodBeat.i(126174);
    dd localdd = new dd();
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    if (Util.isNullOrNil(paramesy.CHR)) {}
    for (Object localObject = paramMMActivity.getString(c.g.recommend_video_share_desc_default);; localObject = paramesy.CHR)
    {
      localanm.bsD(paramesy.vhY);
      localanm.bsx(paramesy.pqW);
      localanm.bsy((String)localObject);
      localanm.bsG(paramesy.PyV);
      localanm.Ex(true);
      localanm.Ey(true);
      localanm.arq(5);
      aor localaor = new aor();
      localaor.btN(paramesy.PyV);
      localaor.btK(paramesy.pqW);
      localaor.btL((String)localObject);
      localaoc.c(localaor);
      localObject = new aj();
      ((aj)localObject).PyQ = paramesy.Crh;
      ((aj)localObject).PyR = paramesy.UuX;
      ((aj)localObject).PyS = paramesv.jQi;
      ((aj)localObject).PyT = paramesy.UuW;
      ((aj)localObject).PyU = 100201L;
      ((aj)localObject).vhY = paramesy.vhY;
      ((aj)localObject).pqW = paramesy.pqW;
      ((aj)localObject).CHR = paramesy.CHR;
      ((aj)localObject).PyV = paramesy.PyV;
      ((aj)localObject).PyW = paramesy.PyW;
      ((aj)localObject).PyX = paramesy.PyX;
      ((aj)localObject).source = paramesy.source;
      ((aj)localObject).fVx = paramesy.fVx;
      ((aj)localObject).PyY = paramesy.PyY;
      ((aj)localObject).PyZ = paramesy.PyZ;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(paramesv.Pye);
      localLinkedList.addAll(paramesy.Pye);
      ((aj)localObject).Pzb = h.iz(paramesy.Crg).toString();
      ((aj)localObject).Pza = iA(localLinkedList).toString();
      ((aj)localObject).Pzc = paramesy.Uve;
      ((aj)localObject).thumbUrl = paramesy.UuU;
      paramesv = new StringBuilder();
      ((aj)localObject).a(paramesv, null, null, null, 0, 0);
      localaor.btP(paramesv.toString());
      localaoi.btx(z.bcZ());
      localaoi.bty(z.bcZ());
      localaoi.arz(3);
      localaoi.Ue(Util.nowMilliSecond());
      localaoi.btE(paramesy.vhY);
      localaoi.btz(paramesy.vhY);
      localdd.fyI.title = localanm.title;
      localdd.fyI.fyK = localaoc;
      localdd.fyI.fyP = 25;
      localdd.fyI.scene = 2;
      localdd.fyI.type = 5;
      localdd.fyI.activity = paramMMActivity;
      localaoc.a(localaoi);
      localaoc.syG.add(localanm);
      EventCenter.instance.publish(localdd);
      AppMethodBeat.o(126174);
      return;
    }
  }
  
  static JSONArray iA(List<aci> paramList)
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
        aci localaci = (aci)paramList.get(i);
        localJSONObject.put("key", localaci.key);
        localJSONObject.put("uintValue", localaci.SnV);
        localJSONObject.put("textValue", localaci.SnW);
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
  
  static boolean l(esy paramesy)
  {
    return (paramesy.Uve != 100201L) && (paramesy.Uve != 100203L);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126172);
    if (paramInt1 == 1024)
    {
      if (paramInt2 == -1)
      {
        Toast.makeText(MMApplicationContext.getContext(), c.g.app_shared, 1).show();
        i.a(paramb.gqA(), this.NaJ, "1", z.bcZ(), "");
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
          if (ab.Lj(str))
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
        i.a(paramb.gqA(), this.NaJ, paramIntent.toString(), z.bcZ(), localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(126172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */