package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public static final p BNo;
  dpa BNp;
  
  static
  {
    AppMethodBeat.i(126175);
    BNo = new p();
    AppMethodBeat.o(126175);
  }
  
  public static void a(MMActivity paramMMActivity, dox paramdox, dpa paramdpa)
  {
    AppMethodBeat.i(126174);
    cw localcw = new cw();
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    if (bu.isNullOrNil(paramdpa.uly)) {}
    for (Object localObject = paramMMActivity.getString(2131762231);; localObject = paramdpa.uly)
    {
      localajx.aPI(paramdpa.qlv);
      localajx.aPC(paramdpa.qlw);
      localajx.aPD((String)localObject);
      localajx.aPL(paramdpa.DTI);
      localajx.ws(true);
      localajx.wt(true);
      localajx.aao(5);
      alc localalc = new alc();
      localalc.aQS(paramdpa.DTI);
      localalc.aQP(paramdpa.qlw);
      localalc.aQQ((String)localObject);
      localakn.b(localalc);
      localObject = new ae();
      ((ae)localObject).DTD = paramdpa.udb;
      ((ae)localObject).DTE = paramdpa.HWj;
      ((ae)localObject).DTF = paramdox.kid;
      ((ae)localObject).DTG = paramdpa.HWi;
      ((ae)localObject).DTH = 100201L;
      ((ae)localObject).qlv = paramdpa.qlv;
      ((ae)localObject).qlw = paramdpa.qlw;
      ((ae)localObject).uly = paramdpa.uly;
      ((ae)localObject).DTI = paramdpa.DTI;
      ((ae)localObject).DTJ = paramdpa.DTJ;
      ((ae)localObject).DTK = paramdpa.DTK;
      ((ae)localObject).source = paramdpa.source;
      ((ae)localObject).dJL = paramdpa.dJL;
      ((ae)localObject).DTL = paramdpa.DTL;
      ((ae)localObject).DTM = paramdpa.DTM;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(paramdox.DTg);
      localLinkedList.addAll(paramdpa.DTg);
      ((ae)localObject).DTO = h.gI(paramdpa.uda).toString();
      ((ae)localObject).DTN = gJ(localLinkedList).toString();
      ((ae)localObject).DTP = paramdpa.HWr;
      ((ae)localObject).thumbUrl = paramdpa.HWg;
      paramdox = new StringBuilder();
      ((ae)localObject).a(paramdox, null, null, null, 0, 0);
      localalc.aQU(paramdox.toString());
      localakt.aQC(v.aAC());
      localakt.aQD(v.aAC());
      localakt.aax(3);
      localakt.Dk(bu.fpO());
      localakt.aQJ(paramdpa.qlv);
      localakt.aQE(paramdpa.qlv);
      localcw.doL.title = localajx.title;
      localcw.doL.doN = localakn;
      localcw.doL.doR = 25;
      localcw.doL.scene = 2;
      localcw.doL.type = 5;
      localcw.doL.activity = paramMMActivity;
      localakn.a(localakt);
      localakn.oeJ.add(localajx);
      a.IvT.l(localcw);
      AppMethodBeat.o(126174);
      return;
    }
  }
  
  static JSONArray gJ(List<aaj> paramList)
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
        aaj localaaj = (aaj)paramList.get(i);
        localJSONObject.put("key", localaaj.key);
        localJSONObject.put("uintValue", localaaj.GrE);
        localJSONObject.put("textValue", localaaj.GrF);
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
  
  static boolean k(dpa paramdpa)
  {
    return (paramdpa.HWr != 100201L) && (paramdpa.HWr != 100203L);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126172);
    if (paramInt1 == 1024)
    {
      if (paramInt2 == -1)
      {
        Toast.makeText(ak.getContext(), 2131755894, 1).show();
        i.a(paramb.etg(), this.BNp, "1", v.aAC(), "");
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
          if (x.wb(str))
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
        i.a(paramb.etg(), this.BNp, paramIntent.toString(), v.aAC(), localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(126172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */