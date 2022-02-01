package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.cxq;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.protocal.protobuf.drw;
import com.tencent.mm.protocal.protobuf.drx;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.protocal.protobuf.dtu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bh;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends a
{
  protected final boolean RS(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> ehn()
  {
    AppMethodBeat.i(30094);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11022));
    localArrayList.add(Integer.valueOf(11023));
    localArrayList.add(Integer.valueOf(11025));
    localArrayList.add(Integer.valueOf(11024));
    localArrayList.add(Integer.valueOf(11026));
    localArrayList.add(Integer.valueOf(11029));
    AppMethodBeat.o(30094);
    return localArrayList;
  }
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30095);
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eG(com.tencent.mm.plugin.boots.a.b.mQT, 1171);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30095);
      return null;
      Object localObject = new drz();
      try
      {
        ((drz)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.egW().a(new a((drz)localObject));
        com.tencent.mm.plugin.wear.model.a.egT().auO(((drz)localObject).Egc);
        com.tencent.mm.plugin.wear.model.c.a.in(2, ((drz)localObject).Scene);
        com.tencent.mm.plugin.wear.model.c.a.RQ(2);
        continue;
        localObject = new dry();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((dry)localObject).parseFrom(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.j.cOB().W(((dry)localObject).Egc, ((dry)localObject).CIE, w.tq(((dry)localObject).Egc));
          az.arV();
          com.tencent.mm.model.c.apR().aIp(((dry)localObject).Egc);
          com.tencent.mm.plugin.wear.model.c.a.in(3, ((dry)localObject).Scene);
          com.tencent.mm.plugin.wear.model.c.a.RQ(5);
          continue;
          localObject = new drx();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((drx)localObject).parseFrom(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.j.cOB().W(((drx)localObject).Egc, ((drx)localObject).CIE, w.tq(((drx)localObject).Egc));
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(aj.getContext(), ((drx)localObject).Egc, ((drx)localObject).MD5);
            az.arV();
            com.tencent.mm.model.c.apR().aIp(((drx)localObject).Egc);
            com.tencent.mm.plugin.wear.model.c.a.in(8, ((drx)localObject).Scene);
            com.tencent.mm.plugin.wear.model.c.a.RQ(4);
            continue;
            localObject = new drw();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((drw)localObject).parseFrom(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(aj.getContext(), ((drw)localObject).Egc, ((drw)localObject).MD5);
              az.arV();
              com.tencent.mm.model.c.apR().aIp(((drw)localObject).Egc);
              com.tencent.mm.plugin.wear.model.c.a.in(7, ((drw)localObject).Scene);
              com.tencent.mm.plugin.wear.model.c.a.RQ(3);
              continue;
              localObject = new dsd();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                ((dsd)localObject).parseFrom(paramArrayOfByte);
                com.tencent.mm.plugin.wear.model.a.egU();
                paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.egV().ADZ.AEM;
                if (paramArrayOfByte == null)
                {
                  ad.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                  continue;
                }
                ad.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(((dsd)localObject).EGP), h.formatTime("yyyy-MM-dd HH:mm:ss", ((dsd)localObject).DUQ / 1000L) });
                localdtu = new dtu();
                cxq localcxq = new cxq();
                if (((dsd)localObject).EGP > 0)
                {
                  paramInt = ((dsd)localObject).EGP;
                  localcxq.mBG = paramInt;
                  localcxq.Timestamp = ((int)(((dsd)localObject).DUQ / 1000L));
                  Calendar localCalendar = Calendar.getInstance();
                  localCalendar.setTimeInMillis(((dsd)localObject).DUQ);
                  localcxq.EpI = localCalendar.get(1);
                  localcxq.EpJ = (localCalendar.get(2) + 1);
                  localcxq.EpK = localCalendar.get(5);
                  localcxq.EpL = localCalendar.get(11);
                  localcxq.EpM = localCalendar.get(12);
                  localcxq.EpN = localCalendar.get(13);
                  localdtu.EIu.add(localcxq);
                  localObject = new xx();
                }
              }
              catch (IOException paramArrayOfByte)
              {
                try
                {
                  for (;;)
                  {
                    dtu localdtu;
                    ((xx)localObject).dEk.data = localdtu.toByteArray();
                    label661:
                    ((xx)localObject).dEk.dbV = 4;
                    ((xx)localObject).dEk.cLR = paramArrayOfByte.EGm;
                    ((xx)localObject).dEk.dfF = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                    break;
                    paramInt = 0;
                    continue;
                    if ((!com.tencent.mm.plugin.wear.model.a.egV().ehf()) || (com.tencent.mm.m.g.Zd().getInt("WearLuckyBlock", 0) != 0))
                    {
                      AppMethodBeat.o(30095);
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
                      label761:
                      break label761;
                    }
                    paramArrayOfByte = new xv();
                    paramArrayOfByte.dDY.action = 1;
                    paramArrayOfByte.dDY.ded = l1;
                    com.tencent.mm.sdk.b.a.ESL.a(paramArrayOfByte, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.in(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.RQ(11);
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
                  break label661;
                }
              }
            }
          }
        }
      }
    }
  }
  
  static final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    private drz AEO;
    
    public a(drz paramdrz)
    {
      this.AEO = paramdrz;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(30093);
      String str = s.Az(this.AEO.Egc);
      ad.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[] { str });
      Object localObject = s.X(str, false);
      ad.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[] { localObject });
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.AEO.CAF.toByteArray());
      com.tencent.mm.audio.e.c localc = new com.tencent.mm.audio.e.c(8000, 16000);
      localc.fR((String)localObject);
      localObject = new byte[320];
      int i = 0;
      for (;;)
      {
        try
        {
          int j = localByteArrayInputStream.read((byte[])localObject, 0, 320);
          i = j;
        }
        catch (IOException localIOException)
        {
          continue;
        }
        if (i <= 0) {
          continue;
        }
        localc.a(new g.a((byte[])localObject, i), 0, false);
      }
      localc.PQ();
      ad.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
      s.aq(str, (int)this.AEO.EGK);
      o.aDA().run();
      ad.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
      az.arV();
      com.tencent.mm.model.c.apR().aIp(this.AEO.Egc);
      AppMethodBeat.o(30093);
    }
    
    public final String getName()
    {
      return "SendVioceMsgTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m
 * JD-Core Version:    0.7.0.1
 */