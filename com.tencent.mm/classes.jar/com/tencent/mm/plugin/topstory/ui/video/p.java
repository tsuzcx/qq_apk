package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public static final p TNr;
  foh TNs;
  
  static
  {
    AppMethodBeat.i(126175);
    TNr = new p();
    AppMethodBeat.o(126175);
  }
  
  public static void a(MMActivity paramMMActivity, foe paramfoe, foh paramfoh)
  {
    AppMethodBeat.i(126174);
    dn localdn = new dn();
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    if (Util.isNullOrNil(paramfoh.ICb)) {}
    for (Object localObject = paramMMActivity.getString(c.g.recommend_video_share_desc_default);; localObject = paramfoh.ICb)
    {
      localarf.bsu(paramfoh.ytZ);
      localarf.bso(paramfoh.svG);
      localarf.bsp((String)localObject);
      localarf.bsx(paramfoh.Wpe);
      localarf.Kj(true);
      localarf.Kk(true);
      localarf.axy(5);
      ask localask = new ask();
      localask.btE(paramfoh.Wpe);
      localask.btB(paramfoh.svG);
      localask.btC((String)localObject);
      localarv.c(localask);
      localObject = new ak();
      ((ak)localObject).WoZ = paramfoh.Ido;
      ((ak)localObject).Wpa = paramfoh.abOy;
      ((ak)localObject).Wpb = paramfoe.mpa;
      ((ak)localObject).Wpc = paramfoh.abOx;
      ((ak)localObject).Wpd = 100201L;
      ((ak)localObject).ytZ = paramfoh.ytZ;
      ((ak)localObject).svG = paramfoh.svG;
      ((ak)localObject).ICb = paramfoh.ICb;
      ((ak)localObject).Wpe = paramfoh.Wpe;
      ((ak)localObject).Wpf = paramfoh.Wpf;
      ((ak)localObject).Wpg = paramfoh.Wpg;
      ((ak)localObject).source = paramfoh.source;
      ((ak)localObject).ibx = paramfoh.ibx;
      ((ak)localObject).Wph = paramfoh.Wph;
      ((ak)localObject).Wpi = paramfoh.Wpi;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(paramfoe.Wol);
      localLinkedList.addAll(paramfoh.Wol);
      ((ak)localObject).Wpk = g.lE(paramfoh.Idn).toString();
      ((ak)localObject).Wpj = lF(localLinkedList).toString();
      ((ak)localObject).Wpl = paramfoh.abOF;
      ((ak)localObject).thumbUrl = paramfoh.oeS;
      paramfoe = new StringBuilder();
      ((ak)localObject).a(paramfoe, null, null, null, 0, 0);
      localask.btG(paramfoe.toString());
      localasb.bto(z.bAM());
      localasb.btp(z.bAM());
      localasb.axH(3);
      localasb.yu(Util.nowMilliSecond());
      localasb.btv(paramfoh.ytZ);
      localasb.btq(paramfoh.ytZ);
      localdn.hDr.title = localarf.title;
      localdn.hDr.hDt = localarv;
      localdn.hDr.hDy = 25;
      localdn.hDr.scene = 2;
      localdn.hDr.type = 5;
      localdn.hDr.activity = paramMMActivity;
      localarv.a(localasb);
      localarv.vEn.add(localarf);
      localdn.publish();
      AppMethodBeat.o(126174);
      return;
    }
  }
  
  static boolean l(foh paramfoh)
  {
    return (paramfoh.abOF != 100201L) && (paramfoh.abOF != 100203L);
  }
  
  static JSONArray lF(List<aem> paramList)
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
        aem localaem = (aem)paramList.get(i);
        localJSONObject.put("key", localaem.key);
        localJSONObject.put("uintValue", localaem.Zmx);
        localJSONObject.put("textValue", localaem.Zmy);
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
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126172);
    if (paramInt1 == 1024)
    {
      if (paramInt2 == -1)
      {
        Toast.makeText(MMApplicationContext.getContext(), c.g.app_shared, 1).show();
        h.a(paramb.hNz(), this.TNs, "1", z.bAM(), "");
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
          if (au.bwE(str))
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
        h.a(paramb.hNz(), this.TNs, paramIntent.toString(), z.bAM(), localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(126172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */