package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.cgo;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.be;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends a
{
  protected final boolean IT(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26412);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11022));
    localArrayList.add(Integer.valueOf(11023));
    localArrayList.add(Integer.valueOf(11025));
    localArrayList.add(Integer.valueOf(11024));
    localArrayList.add(Integer.valueOf(11026));
    localArrayList.add(Integer.valueOf(11029));
    AppMethodBeat.o(26412);
    return localArrayList;
  }
  
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26413);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26413);
      return null;
      Object localObject = new cxv();
      try
      {
        ((cxv)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.cYy().uGI.a(new m.a((cxv)localObject));
        com.tencent.mm.plugin.wear.model.a.cYy().uGE.agd(((cxv)localObject).xlH);
        com.tencent.mm.plugin.wear.model.c.a.gD(2, ((cxv)localObject).Scene);
        com.tencent.mm.plugin.wear.model.c.a.IR(2);
        continue;
        localObject = new cxu();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((cxu)localObject).parseFrom(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.g.bPJ().K(((cxu)localObject).xlH, ((cxu)localObject).wxW, t.oF(((cxu)localObject).xlH));
          aw.aaz();
          c.YF().arJ(((cxu)localObject).xlH);
          com.tencent.mm.plugin.wear.model.c.a.gD(3, ((cxu)localObject).Scene);
          com.tencent.mm.plugin.wear.model.c.a.IR(5);
          continue;
          localObject = new cxt();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((cxt)localObject).parseFrom(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.g.bPJ().K(((cxt)localObject).xlH, ((cxt)localObject).wxW, t.oF(((cxt)localObject).xlH));
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(ah.getContext(), ((cxt)localObject).xlH, ((cxt)localObject).wQr);
            aw.aaz();
            c.YF().arJ(((cxt)localObject).xlH);
            com.tencent.mm.plugin.wear.model.c.a.gD(8, ((cxt)localObject).Scene);
            com.tencent.mm.plugin.wear.model.c.a.IR(4);
            continue;
            localObject = new cxs();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((cxs)localObject).parseFrom(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(ah.getContext(), ((cxs)localObject).xlH, ((cxs)localObject).wQr);
              aw.aaz();
              c.YF().arJ(((cxs)localObject).xlH);
              com.tencent.mm.plugin.wear.model.c.a.gD(7, ((cxs)localObject).Scene);
              com.tencent.mm.plugin.wear.model.c.a.IR(3);
              continue;
              localObject = new cxz();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                ((cxz)localObject).parseFrom(paramArrayOfByte);
                com.tencent.mm.plugin.wear.model.a.cYy();
                paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.cYy().uGC.uGT.uHH;
                if (paramArrayOfByte == null)
                {
                  ab.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                  continue;
                }
                ab.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(((cxz)localObject).yff), h.formatTime("yyyy-MM-dd HH:mm:ss", ((cxz)localObject).yfg / 1000L) });
                localcze = new cze();
                cgo localcgo = new cgo();
                if (((cxz)localObject).yff > 0)
                {
                  paramInt = ((cxz)localObject).yff;
                  localcgo.jKr = paramInt;
                  localcgo.Timestamp = ((int)(((cxz)localObject).yfg / 1000L));
                  Calendar localCalendar = Calendar.getInstance();
                  localCalendar.setTimeInMillis(((cxz)localObject).yfg);
                  localcgo.xRo = localCalendar.get(1);
                  localcgo.xRp = (localCalendar.get(2) + 1);
                  localcgo.xRq = localCalendar.get(5);
                  localcgo.xRr = localCalendar.get(11);
                  localcgo.xRs = localCalendar.get(12);
                  localcgo.xRt = localCalendar.get(13);
                  localcze.yge.add(localcgo);
                  localObject = new vx();
                }
              }
              catch (IOException paramArrayOfByte)
              {
                try
                {
                  for (;;)
                  {
                    cze localcze;
                    ((vx)localObject).cNm.data = localcze.toByteArray();
                    label650:
                    ((vx)localObject).cNm.coO = 4;
                    ((vx)localObject).cNm.bYu = paramArrayOfByte.yeC;
                    ((vx)localObject).cNm.cqJ = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
                    break;
                    paramInt = 0;
                    continue;
                    if ((!com.tencent.mm.plugin.wear.model.a.cYy().uGC.cYD()) || (com.tencent.mm.m.g.Nq().getInt("WearLuckyBlock", 0) != 0))
                    {
                      AppMethodBeat.o(26413);
                      return null;
                    }
                    long l1 = 0L;
                    try
                    {
                      long l2 = Long.valueOf(new String(paramArrayOfByte)).longValue();
                      l1 = l2;
                    }
                    catch (Exception paramArrayOfByte)
                    {
                      label753:
                      break label753;
                    }
                    paramArrayOfByte = new vv();
                    paramArrayOfByte.cNa.action = 1;
                    paramArrayOfByte.cNa.cpg = l1;
                    com.tencent.mm.sdk.b.a.ymk.a(paramArrayOfByte, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.gD(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.IR(11);
                    break;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                  }
                  paramArrayOfByte = paramArrayOfByte;
                }
                catch (IOException localIOException)
                {
                  break label650;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m
 * JD-Core Version:    0.7.0.1
 */