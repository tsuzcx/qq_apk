package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.topstory.a.e
{
  eiq GiK;
  eiq GiL;
  LinkedList<eiq> GiM;
  e.a GiN;
  q GiO;
  com.tencent.mm.plugin.topstory.a.c.b GiP;
  final String GiQ;
  String GiR;
  IListener<fp> GiS;
  private i gNh;
  
  public b()
  {
    AppMethodBeat.i(88420);
    this.GiM = new LinkedList();
    this.GiO = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(88417);
        int i;
        if ((paramAnonymousMap != null) && (paramAnonymousString != null) && (paramAnonymousString.equals("mmsearch_reddot_new")))
        {
          i = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.entry"));
          if (i == 2)
          {
            paramAnonymousa = new eiq();
            b.a(paramAnonymousa);
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramAnonymousMap.toString() });
            paramAnonymousa.NhP = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.clear"));
            paramAnonymousa.IFn = i;
            paramAnonymousa.msgId = Util.safeFormatString((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
            paramAnonymousa.IFp = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
            paramAnonymousa.IFo = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
            paramAnonymousa.jmW = Util.safeParseLong((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
            paramAnonymousa.IEj = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
            paramAnonymousa.type = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
            paramAnonymousa.text = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_text"));
            paramAnonymousa.icon = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon"));
            paramAnonymousa.NhO = Util.safeParseLong((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
            paramAnonymousa.NhQ = cl.aWA();
            paramAnonymousa.jlm = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.seq"));
            paramAnonymousa.priority = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.priority"));
            paramAnonymousa.extInfo = Util.safeFormatString((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.ext_info"), new Object[0]);
            if (paramAnonymousa.NhP == 1)
            {
              paramAnonymousString = b.this;
              switch (paramAnonymousa.type)
              {
              case 5: 
              case 6: 
              case 9: 
              default: 
                switch (paramAnonymousa.type)
                {
                default: 
                  i = 1;
                }
                break;
              }
              for (;;)
              {
                ar.a(paramAnonymousa, 100, i, 0, 0L, "");
                AppMethodBeat.o(88417);
                return;
                paramAnonymousString.fxq();
                paramAnonymousString = new ts();
                EventCenter.instance.publish(paramAnonymousString);
                break;
                paramAnonymousString.a(paramAnonymousa.NhO, true, paramAnonymousa.jlm, false);
                paramAnonymousString = new ts();
                EventCenter.instance.publish(paramAnonymousString);
                break;
                paramAnonymousString.N(paramAnonymousa.NhO, false);
                paramAnonymousString = new ts();
                EventCenter.instance.publish(paramAnonymousString);
                break;
                paramAnonymousString.p("", "", 0L);
                break;
                i = 2;
                continue;
                i = 3;
                continue;
                i = 4;
              }
            }
          }
        }
        switch (paramAnonymousa.type)
        {
        case 5: 
        case 6: 
        default: 
          ar.a(paramAnonymousa, 109, 0, 0, 0L, "r12|" + paramAnonymousa.type);
        case 9: 
          do
          {
            AppMethodBeat.o(88417);
            return;
          } while (b.this.GiN == null);
          b.this.GiN.fP(paramAnonymousa.extInfo, paramAnonymousa.type);
          ar.a(paramAnonymousa, 100, 4, 0, 0L, "");
          AppMethodBeat.o(88417);
          return;
        case 8: 
          ar.a(paramAnonymousa, 100, 3, 0, 0L, "");
          paramAnonymousString = b.this;
          Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", new Object[] { paramAnonymousa.msgId });
          paramAnonymousString.GiK = paramAnonymousa;
          g.aAh().azQ().set(ar.a.Ohs, b.b(paramAnonymousa));
          g.aAh().azQ().gBI();
          ar.a(paramAnonymousa, 101, 3, 0, 0L, "");
          AppMethodBeat.o(88417);
          return;
        case 7: 
          ar.a(paramAnonymousa, 100, 2, b.this.GiM.size(), 0L, "");
          paramAnonymousMap = b.this;
          Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", new Object[] { Integer.valueOf(paramAnonymousa.jlm) });
          if (!paramAnonymousMap.fxI()) {
            ar.a(paramAnonymousa, 108, 2, paramAnonymousMap.GiM.size(), 0L, "");
          }
          if (paramAnonymousa.jlm <= b.fxA())
          {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", new Object[] { Integer.valueOf(paramAnonymousa.jlm), Integer.valueOf(b.fxA()) });
            ar.a(paramAnonymousa, 103, 2, paramAnonymousMap.fxv(), 0L, "");
            ar.a(paramAnonymousa, 109, 2, paramAnonymousMap.fxv(), 0L, "r6|" + paramAnonymousa.jlm + "|" + b.fxA());
            AppMethodBeat.o(88417);
            return;
          }
          paramAnonymousString = paramAnonymousMap.GiM;
          i = 0;
        }
        label1894:
        for (;;)
        {
          try
          {
            if (!Util.isNullOrNil(paramAnonymousMap.GiM))
            {
              i = 0;
              if (i >= paramAnonymousMap.GiM.size()) {
                break label1894;
              }
              eiq localeiq = (eiq)paramAnonymousMap.GiM.get(i);
              if (localeiq.msgId.equals(paramAnonymousa.msgId))
              {
                Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
                ar.a(paramAnonymousa, 109, 2, paramAnonymousMap.fxv(), 0L, "r11");
                return;
              }
              if (localeiq.jlm > paramAnonymousa.jlm) {
                break label1894;
              }
              i += 1;
              continue;
            }
            paramAnonymousMap.GiM.add(i, paramAnonymousa);
            if (paramAnonymousMap.fxI()) {
              ar.a(paramAnonymousMap.fxw(), 101, 2, paramAnonymousMap.GiM.size(), 0L, "");
            }
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", new Object[] { paramAnonymousa.msgId, Long.valueOf(paramAnonymousa.NhO) });
            paramAnonymousMap.fxp();
            if (paramAnonymousMap.GiN != null) {
              paramAnonymousMap.GiN.a(paramAnonymousMap.GiM.size(), ((eiq)paramAnonymousMap.GiM.getFirst()).msgId, ((eiq)paramAnonymousMap.GiM.getLast()).msgId, ((eiq)paramAnonymousMap.GiM.getFirst()).jlm, ((eiq)paramAnonymousMap.GiM.getLast()).jlm, ((eiq)paramAnonymousMap.GiM.getLast()).extInfo);
            }
            paramAnonymousString = new ts();
            EventCenter.instance.publish(paramAnonymousString);
            AppMethodBeat.o(88417);
            return;
          }
          finally
          {
            AppMethodBeat.o(88417);
          }
          b.c(paramAnonymousa);
          ar.a(paramAnonymousa, 100, 1, 0, 0L, "");
          paramAnonymousMap = b.this;
          if (!paramAnonymousMap.fxI()) {
            ar.a(paramAnonymousa, 108, 1, 0, 0L, "");
          }
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = paramAnonymousa.NhO;
          if (paramAnonymousMap.GiL == null) {}
          for (paramAnonymousString = "null";; paramAnonymousString = paramAnonymousMap.GiL.NhO)
          {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot showTime new:%s, cur:%s, curTime:%s", new Object[] { Long.valueOf(l2), paramAnonymousString, Long.valueOf(l1) });
            if (paramAnonymousa.NhO > b.fxz()) {
              break;
            }
            ar.a(paramAnonymousa, 103, 1, 0, 0L, "");
            ar.a(paramAnonymousa, 109, 1, 0, 0L, "r6|" + paramAnonymousa.NhO + "|" + b.fxz());
            AppMethodBeat.o(88417);
            return;
          }
          if (paramAnonymousa.NhO > 3600L + l1)
          {
            ar.a(paramAnonymousa, 109, 1, 0, 0L, "r10|" + paramAnonymousa.NhO + "|" + l1);
            AppMethodBeat.o(88417);
            return;
          }
          if ((paramAnonymousMap.GiL != null) && (!Util.isNullOrNil(paramAnonymousMap.GiL.msgId)) && (paramAnonymousMap.GiL.NhO > paramAnonymousa.NhO))
          {
            ar.a(paramAnonymousa, 105, 1, 0, 0L, paramAnonymousMap.GiL.msgId);
            ar.a(paramAnonymousa, 109, 1, 0, 0L, "r9|" + paramAnonymousa.NhO + "|" + b.fxz());
            AppMethodBeat.o(88417);
            return;
          }
          if (paramAnonymousMap.GiL.priority > paramAnonymousa.priority)
          {
            ar.a(paramAnonymousa, 109, 1, 0, 0L, "r11|" + paramAnonymousa.NhO + "|" + b.fxz());
            AppMethodBeat.o(88417);
            return;
          }
          if ((paramAnonymousMap.GiL != null) && (!Util.isNullOrNil(paramAnonymousMap.GiL.msgId))) {
            ar.a(paramAnonymousa, 105, 1, 0, 0L, paramAnonymousa.msgId);
          }
          Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot valid");
          paramAnonymousMap.GiL = paramAnonymousa;
          g.aAh().azQ().set(ar.a.OfW, b.b(paramAnonymousMap.GiL));
          g.aAh().azQ().gBI();
          if (paramAnonymousMap.fxI()) {
            ar.a(paramAnonymousMap.GiL, 101, 1, 0, 0L, "");
          }
          if (paramAnonymousMap.GiN != null) {
            paramAnonymousMap.GiN.p(paramAnonymousMap.GiL.msgId, paramAnonymousMap.GiL.NhO, paramAnonymousMap.GiL.type);
          }
          paramAnonymousString = new ts();
          EventCenter.instance.publish(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
          ar.a(paramAnonymousa, 100, 5, 0, 0L, "");
          b.this.p(paramAnonymousa.msgId, paramAnonymousa.extInfo, paramAnonymousa.NhO);
          AppMethodBeat.o(88417);
          return;
          ar.a(paramAnonymousa, 100, 11, 0, 0L, "");
          b.c(paramAnonymousa);
          AppMethodBeat.o(88417);
          return;
        }
      }
    };
    this.gNh = new b.2(this);
    this.GiQ = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    this.GiR = "";
    this.GiS = new IListener() {};
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.GiO);
    this.GiL = new eiq();
    a(this.GiL);
    eiq localeiq = this.GiL;
    Object localObject = (String)g.aAh().azQ().get(ar.a.OfW, "");
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label253;
      }
    }
    try
    {
      if (localObject.length >= 13)
      {
        a(localeiq, (String[])localObject);
        this.GiK = new eiq();
        a(this.GiK);
        localeiq = this.GiK;
        localObject = (String)g.aAh().azQ().get(ar.a.Ohs, "");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = ((String)localObject).split(",");
          if (localObject == null) {
            break label306;
          }
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        if (localObject.length >= 13) {
          a(localeiq, (String[])localObject);
        }
        for (;;)
        {
          fxs();
          EventCenter.instance.add(this.GiS);
          AppMethodBeat.o(88420);
          return;
          label253:
          g.aAh().azQ().set(ar.a.OfW, "");
          g.aAh().azQ().gBI();
          break;
          localException1 = localException1;
          g.aAh().azQ().set(ar.a.OfW, "");
          g.aAh().azQ().gBI();
          break;
          label306:
          g.aAh().azQ().set(ar.a.Ohs, "");
          g.aAh().azQ().gBI();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          g.aAh().azQ().set(ar.a.Ohs, "");
          g.aAh().azQ().gBI();
        }
      }
    }
  }
  
  static void a(eiq parameiq)
  {
    parameiq.icon = "";
    parameiq.msgId = "";
    parameiq.text = "";
  }
  
  private static void a(eiq parameiq, String[] paramArrayOfString)
  {
    AppMethodBeat.i(88435);
    parameiq.msgId = paramArrayOfString[0];
    parameiq.NhP = Integer.valueOf(paramArrayOfString[1]).intValue();
    parameiq.IFo = Integer.valueOf(paramArrayOfString[2]).intValue();
    parameiq.IFp = Integer.valueOf(paramArrayOfString[3]).intValue();
    parameiq.IFn = Integer.valueOf(paramArrayOfString[4]).intValue();
    parameiq.jmW = Long.valueOf(paramArrayOfString[5]).longValue();
    parameiq.IEj = Integer.valueOf(paramArrayOfString[6]).intValue();
    parameiq.NhQ = Long.valueOf(paramArrayOfString[7]).longValue();
    parameiq.text = paramArrayOfString[8];
    parameiq.type = Integer.valueOf(paramArrayOfString[9]).intValue();
    parameiq.showFlag = Integer.valueOf(paramArrayOfString[10]).intValue();
    parameiq.NhO = Long.valueOf(paramArrayOfString[11]).longValue();
    parameiq.icon = paramArrayOfString[12];
    if (paramArrayOfString.length > 13) {
      parameiq.jlm = Integer.valueOf(paramArrayOfString[13]).intValue();
    }
    while (paramArrayOfString.length > 14)
    {
      parameiq.extInfo = paramArrayOfString[14];
      AppMethodBeat.o(88435);
      return;
      parameiq.jlm = 0;
      if (parameiq.type == 7) {
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
      }
    }
    parameiq.extInfo = "";
    AppMethodBeat.o(88435);
  }
  
  public static String b(eiq parameiq)
  {
    AppMethodBeat.i(88434);
    parameiq = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { parameiq.msgId, Integer.valueOf(parameiq.NhP), Integer.valueOf(parameiq.IFo), Integer.valueOf(parameiq.IFp), Integer.valueOf(parameiq.IFn), Long.valueOf(parameiq.jmW), Integer.valueOf(parameiq.IEj), Long.valueOf(parameiq.NhQ), parameiq.text, Integer.valueOf(parameiq.type), Integer.valueOf(parameiq.showFlag), Long.valueOf(parameiq.NhO), parameiq.icon, Integer.valueOf(parameiq.jlm), parameiq.extInfo });
    AppMethodBeat.o(88434);
    return parameiq;
  }
  
  public static int fxA()
  {
    AppMethodBeat.i(88446);
    Object localObject = g.aAh().azQ().get(ar.a.OfV, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88446);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(88446);
    return i;
  }
  
  private void fxn()
  {
    AppMethodBeat.i(201210);
    this.GiL = new eiq();
    a(this.GiL);
    g.aAh().azQ().set(ar.a.OfW, "");
    g.aAh().azQ().gBI();
    if (this.GiN != null)
    {
      e.a locala = this.GiN;
      fxz();
      locala.fxO();
    }
    AppMethodBeat.o(201210);
  }
  
  private void fxs()
  {
    AppMethodBeat.i(88436);
    Object localObject1 = (String)g.aAh().azQ().get(ar.a.Ohr, "");
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(";");
      try
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject2 = ((String)localObject2).split(",");
            eiq localeiq = new eiq();
            a(localeiq, (String[])localObject2);
            this.GiM.addLast(localeiq);
          }
          i += 1;
        }
        AppMethodBeat.o(88436);
        return;
      }
      catch (Exception localException)
      {
        g.aAh().azQ().set(ar.a.Ohr, "");
        g.aAh().azQ().gBI();
      }
    }
    AppMethodBeat.o(88436);
  }
  
  public static long fxz()
  {
    AppMethodBeat.i(88445);
    Object localObject = g.aAh().azQ().get(ar.a.OfT, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88445);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(88445);
    return l;
  }
  
  public final void KH(long paramLong)
  {
    AppMethodBeat.i(201212);
    N(paramLong, true);
    AppMethodBeat.o(201212);
  }
  
  public final void N(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(201211);
    if ((this.GiL == null) || (Util.isNullOrNil(this.GiL.msgId)))
    {
      AppMethodBeat.o(201211);
      return;
    }
    long l = cl.aWA() / 1000L;
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if ((paramLong < fxz()) || (paramLong <= 0L) || (l + 3600L < paramLong))
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", new Object[] { Long.valueOf(fxz()) });
      AppMethodBeat.o(201211);
      return;
    }
    if ((this.GiL != null) && (paramLong < this.GiL.NhO))
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", new Object[] { Long.valueOf(this.GiL.NhO) });
      AppMethodBeat.o(201211);
      return;
    }
    if (paramBoolean) {
      ar.a(this.GiL, 106, 1, 0, paramLong, "");
    }
    fxn();
    g.aAh().azQ().set(ar.a.OfT, Long.valueOf(paramLong));
    g.aAh().azQ().gBI();
    AppMethodBeat.o(201211);
  }
  
  public final void a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(88441);
    if (this.GiM.size() == 0)
    {
      AppMethodBeat.o(88441);
      return;
    }
    if (paramInt <= fxA())
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fxA()) });
      AppMethodBeat.o(88441);
      return;
    }
    int i = this.GiM.size();
    Object localObject2 = this.GiM;
    String str = "";
    for (;;)
    {
      try
      {
        if ((this.GiM.size() > 0) && (((eiq)this.GiM.getFirst()).jlm <= paramInt))
        {
          str = ((eiq)this.GiM.getFirst()).msgId;
          this.GiM.removeFirst();
          continue;
        }
        if (i != this.GiM.size()) {
          fxp();
        }
        if (this.GiN != null)
        {
          if (this.GiM.size() > 0) {
            this.GiN.a(this.GiM.size(), ((eiq)this.GiM.getFirst()).msgId, ((eiq)this.GiM.getLast()).msgId, ((eiq)this.GiM.getFirst()).jlm, ((eiq)this.GiM.getLast()).jlm, ((eiq)this.GiM.getLast()).extInfo, paramBoolean1);
          }
        }
        else
        {
          if (paramBoolean2)
          {
            localObject2 = new eiq();
            ((eiq)localObject2).msgId = str;
            ((eiq)localObject2).NhO = paramLong;
            ((eiq)localObject2).jlm = paramInt;
            ar.a((eiq)localObject2, 106, 2, i, paramLong, "");
          }
          g.aAh().azQ().set(ar.a.OfU, Long.valueOf(paramLong));
          g.aAh().azQ().gBI();
          Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", new Object[] { Integer.valueOf(paramInt) });
          g.aAh().azQ().set(ar.a.OfV, Integer.valueOf(paramInt));
          g.aAh().azQ().gBI();
          AppMethodBeat.o(88441);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(88441);
      }
      this.GiN.a(0, "", "", 0, 0, "", paramBoolean1);
    }
  }
  
  public final void a(e.a parama)
  {
    this.GiN = parama;
  }
  
  public final int abP(int paramInt)
  {
    AppMethodBeat.i(201213);
    if (fxu() > 0)
    {
      AppMethodBeat.o(201213);
      return 110;
    }
    if ((fxl()) && (fxB()))
    {
      if (this.GiK.priority > this.GiL.priority)
      {
        AppMethodBeat.o(201213);
        return 100;
      }
      if (this.GiK.priority < this.GiL.priority)
      {
        AppMethodBeat.o(201213);
        return 110;
      }
      if (this.GiK.NhQ > this.GiL.NhQ)
      {
        AppMethodBeat.o(201213);
        return 100;
      }
      if (this.GiK.NhQ < this.GiL.NhQ)
      {
        AppMethodBeat.o(201213);
        return 110;
      }
      AppMethodBeat.o(201213);
      return paramInt;
    }
    if (fxl())
    {
      AppMethodBeat.o(201213);
      return 110;
    }
    if (fxB())
    {
      AppMethodBeat.o(201213);
      return 100;
    }
    AppMethodBeat.o(201213);
    return paramInt;
  }
  
  public final void b(e.a parama)
  {
    if (this.GiN == parama) {
      this.GiN = null;
    }
  }
  
  public final boolean fxB()
  {
    AppMethodBeat.i(88447);
    eiq localeiq = this.GiK;
    if (!Util.isNullOrNil(localeiq.msgId))
    {
      long l1 = localeiq.NhQ;
      long l2 = localeiq.jmW;
      if (System.currentTimeMillis() > l1 + l2 * 1000L)
      {
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { localeiq.msgId });
        fxq();
        AppMethodBeat.o(88447);
        return false;
      }
      AppMethodBeat.o(88447);
      return true;
    }
    AppMethodBeat.o(88447);
    return false;
  }
  
  public final String fxC()
  {
    AppMethodBeat.i(88448);
    String str = this.GiK.msgId;
    AppMethodBeat.o(88448);
    return str;
  }
  
  public final void fxD()
  {
    AppMethodBeat.i(88449);
    eiq localeiq = new eiq();
    localeiq.msgId = this.GiK.msgId;
    ar.a(localeiq, 106, 3, 0, 0L, "");
    fxq();
    AppMethodBeat.o(88449);
  }
  
  public final String fxE()
  {
    AppMethodBeat.i(88451);
    String str = (String)g.aAh().azQ().get(ar.a.Oht, "");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(88451);
      return "";
    }
    try
    {
      str = new JSONObject(str).optString("msgId", "");
      AppMethodBeat.o(88451);
      return str;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(88451);
    }
    return "";
  }
  
  public final long fxF()
  {
    AppMethodBeat.i(88452);
    String str = (String)g.aAh().azQ().get(ar.a.Oht, "");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(88452);
      return 0L;
    }
    try
    {
      int i = new JSONObject(str).optInt("ts", 0);
      long l = i;
      AppMethodBeat.o(88452);
      return l;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(88452);
    }
    return 0L;
  }
  
  public final String fxG()
  {
    AppMethodBeat.i(88453);
    String str = (String)g.aAh().azQ().get(ar.a.Oht, "");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(88453);
      return "";
    }
    try
    {
      str = new JSONObject(str).optString("extInfo");
      AppMethodBeat.o(88453);
      return str;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(88453);
    }
    return "";
  }
  
  public final void fxH()
  {
    AppMethodBeat.i(88454);
    p("", "", 0L);
    AppMethodBeat.o(88454);
  }
  
  public final boolean fxI()
  {
    AppMethodBeat.i(88455);
    long l = z.aUd();
    if ((0x4000000 & l) == 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
      boolean bool3 = com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null));
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "isShowRecEntry %s %s %s %s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool1) || (bool2) || (bool3)) {
        break;
      }
      AppMethodBeat.o(88455);
      return true;
    }
    AppMethodBeat.o(88455);
    return false;
  }
  
  public final boolean fxJ()
  {
    AppMethodBeat.i(88456);
    if (((d.KyO >= 654311424) || (d.KyS)) && (Util.isNullOrNil(this.GiR))) {
      this.GiR = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRL, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.GiR).getJSONArray("tabs");
      int i = 0;
      while (i < localJSONArray.length())
      {
        int j = localJSONArray.getJSONObject(i).getInt("category");
        if (j == 110)
        {
          AppMethodBeat.o(88456);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(88456);
    }
  }
  
  public final boolean fxK()
  {
    AppMethodBeat.i(201214);
    long l = g.aAh().azQ().a(ar.a.Ogf, 0L);
    if (this.GiL.NhQ < l)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHaokanFindMoreEntryRedDot already click find more entry");
      AppMethodBeat.o(201214);
      return false;
    }
    AppMethodBeat.o(201214);
    return true;
  }
  
  public final boolean fxL()
  {
    AppMethodBeat.i(201215);
    long l = g.aAh().azQ().a(ar.a.Ogf, 0L);
    if (this.GiK.NhQ < l)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHomeFindMoreEntryRedDot already click find more entry");
      AppMethodBeat.o(201215);
      return false;
    }
    AppMethodBeat.o(201215);
    return true;
  }
  
  public final void fxM()
  {
    AppMethodBeat.i(201216);
    g.aAh().azQ().set(ar.a.Ogf, Long.valueOf(cl.aWA()));
    AppMethodBeat.o(201216);
  }
  
  public final void fxN()
  {
    AppMethodBeat.i(201217);
    if (fxu() > 0)
    {
      eiq localeiq = fxw();
      if (localeiq != null) {
        ar.a(localeiq.msgId, localeiq.NhO, 2, fxu(), "", localeiq.jlm);
      }
      AppMethodBeat.o(201217);
      return;
    }
    if ((fxl()) && (fxB()))
    {
      if (this.GiK.priority > this.GiL.priority)
      {
        ar.a(this.GiK.msgId, this.GiK.NhO, 1, 0, "", 0);
        AppMethodBeat.o(201217);
        return;
      }
      if (this.GiK.priority < this.GiL.priority)
      {
        ar.a(this.GiL.msgId, this.GiL.NhO, 1, 0, "", 0);
        AppMethodBeat.o(201217);
        return;
      }
      if (this.GiK.NhQ > this.GiL.NhQ)
      {
        ar.a(this.GiK.msgId, this.GiK.NhO, 1, 0, "", 0);
        AppMethodBeat.o(201217);
        return;
      }
      if (this.GiK.NhQ < this.GiL.NhQ)
      {
        ar.a(this.GiL.msgId, this.GiL.NhO, 1, 0, "", 0);
        AppMethodBeat.o(201217);
        return;
      }
      ar.a(this.GiL.msgId, this.GiL.NhO, 1, 0, "", 0);
      AppMethodBeat.o(201217);
      return;
    }
    if (fxl())
    {
      ar.a(this.GiL.msgId, this.GiL.NhO, 1, 0, "", 0);
      AppMethodBeat.o(201217);
      return;
    }
    if (fxB()) {
      ar.a(this.GiK.msgId, this.GiK.NhO, 1, 0, "", 0);
    }
    AppMethodBeat.o(201217);
  }
  
  public final boolean fxl()
  {
    AppMethodBeat.i(201209);
    if (!fxJ())
    {
      AppMethodBeat.o(201209);
      return false;
    }
    int i;
    if (Util.isNullOrNil(this.GiL.msgId)) {
      i = -5;
    }
    while (i == 0)
    {
      if (!fxI()) {
        break label369;
      }
      AppMethodBeat.o(201209);
      return true;
      if (this.GiL.NhP == 1)
      {
        i = -1;
      }
      else if (this.GiL.IFo > d.KyO)
      {
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.GiL.msgId, Integer.valueOf(this.GiL.IFo), Integer.valueOf(d.KyO) });
        i = -2;
      }
      else
      {
        if (this.GiL.jmW != 0L)
        {
          long l1 = this.GiL.NhQ;
          long l2 = this.GiL.jmW;
          if (System.currentTimeMillis() > l1 + l2 * 1000L)
          {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { this.GiL.msgId });
            i = -3;
            continue;
          }
        }
        boolean bool;
        if (ai.aft(1) >= this.GiL.IEj)
        {
          bool = true;
          label224:
          Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.GiL.IEj), Integer.valueOf(ai.aft(1)), Long.valueOf(this.GiL.NhO), Long.valueOf(fxz()) });
          if ((ai.aft(1) < this.GiL.IEj) || (this.GiL.NhO <= fxz())) {
            break label335;
          }
        }
        label335:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label340;
          }
          i = -4;
          break;
          bool = false;
          break label224;
        }
        label340:
        i = 0;
      }
    }
    if (i == -3)
    {
      ar.a(this.GiL, 104, 1, 0, 0L, "");
      fxn();
    }
    label369:
    AppMethodBeat.o(201209);
    return false;
  }
  
  public final boolean fxm()
  {
    AppMethodBeat.i(88422);
    if (!fxJ())
    {
      AppMethodBeat.o(88422);
      return false;
    }
    if ((eiq)this.GiM.getLast() == null)
    {
      AppMethodBeat.o(88422);
      return false;
    }
    AppMethodBeat.o(88422);
    return true;
  }
  
  public final eiq fxo()
  {
    return this.GiL;
  }
  
  final void fxp()
  {
    AppMethodBeat.i(88430);
    synchronized (this.GiM)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.GiM.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(b((eiq)localIterator.next())).append(";");
      }
    }
    g.aAh().azQ().set(ar.a.Ohr, localObject.toString());
    g.aAh().azQ().gBI();
    AppMethodBeat.o(88430);
  }
  
  public final void fxq()
  {
    AppMethodBeat.i(88432);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
    this.GiK = new eiq();
    a(this.GiK);
    g.aAh().azQ().set(ar.a.Ohs, "");
    g.aAh().azQ().gBI();
    AppMethodBeat.o(88432);
  }
  
  public final eiq fxr()
  {
    return this.GiK;
  }
  
  public final boolean fxt()
  {
    if (this.GiL != null) {
      return this.GiL.IFp == 1;
    }
    return false;
  }
  
  public final int fxu()
  {
    AppMethodBeat.i(88437);
    if (!fxJ())
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88437);
      return 0;
    }
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(this.GiM.size()) });
    int i = this.GiM.size();
    AppMethodBeat.o(88437);
    return i;
  }
  
  final int fxv()
  {
    AppMethodBeat.i(88438);
    if (!fxJ())
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88438);
      return 0;
    }
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(this.GiM.size()) });
    int i = this.GiM.size();
    AppMethodBeat.o(88438);
    return i;
  }
  
  public final eiq fxw()
  {
    AppMethodBeat.i(88439);
    synchronized (this.GiM)
    {
      if (Util.isNullOrNil(this.GiM))
      {
        AppMethodBeat.o(88439);
        return null;
      }
      eiq localeiq = (eiq)this.GiM.getLast();
      AppMethodBeat.o(88439);
      return localeiq;
    }
  }
  
  public final eiq fxx()
  {
    AppMethodBeat.i(88440);
    synchronized (this.GiM)
    {
      if (Util.isNullOrNil(this.GiM))
      {
        AppMethodBeat.o(88440);
        return null;
      }
      eiq localeiq = (eiq)this.GiM.getFirst();
      AppMethodBeat.o(88440);
      return localeiq;
    }
  }
  
  public final boolean fxy()
  {
    AppMethodBeat.i(88443);
    if (!Util.isNullOrNil(this.GiM))
    {
      if (((eiq)this.GiM.getLast()).IFp == 1)
      {
        AppMethodBeat.o(88443);
        return true;
      }
      AppMethodBeat.o(88443);
      return false;
    }
    AppMethodBeat.o(88443);
    return false;
  }
  
  public final void j(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88442);
    a(paramLong, paramBoolean, paramInt, true);
    AppMethodBeat.o(88442);
  }
  
  public final void p(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(88450);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgId", paramString1);
      localJSONObject.put("extInfo", paramString2);
      localJSONObject.put("ts", paramLong);
      g.aAh().azQ().set(ar.a.Oht, localJSONObject.toString());
      g.aAh().azQ().gBI();
      if ((!Util.isNullOrNil(paramString1)) && (this.GiN != null)) {
        this.GiN.bt(paramString1, paramLong);
      }
      AppMethodBeat.o(88450);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", paramString2, "setUserIconRedDot error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */