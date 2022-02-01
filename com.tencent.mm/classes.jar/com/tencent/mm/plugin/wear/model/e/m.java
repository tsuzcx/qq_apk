package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.protocal.protobuf.edo;
import com.tencent.mm.protocal.protobuf.edp;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.efp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bq;
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
  protected final boolean VU(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> eKN()
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eN(com.tencent.mm.plugin.boots.a.b.nTZ, 1171);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30095);
      return null;
      Object localObject = new edq();
      try
      {
        ((edq)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.eKw().a(new a((edq)localObject));
        com.tencent.mm.plugin.wear.model.a.eKt().aFp(((edq)localObject).Hnp);
        com.tencent.mm.plugin.wear.model.c.a.iP(2, ((edq)localObject).Scene);
        com.tencent.mm.plugin.wear.model.c.a.VS(2);
        continue;
        localObject = new edp();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((edp)localObject).parseFrom(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.g.dlD().aa(((edp)localObject).Hnp, ((edp)localObject).FGP, w.Ar(((edp)localObject).Hnp));
          ba.aBQ();
          com.tencent.mm.model.c.azv().aTB(((edp)localObject).Hnp);
          com.tencent.mm.plugin.wear.model.c.a.iP(3, ((edp)localObject).Scene);
          com.tencent.mm.plugin.wear.model.c.a.VS(5);
          continue;
          localObject = new edo();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((edo)localObject).parseFrom(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.g.dlD().aa(((edo)localObject).Hnp, ((edo)localObject).FGP, w.Ar(((edo)localObject).Hnp));
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(aj.getContext(), ((edo)localObject).Hnp, ((edo)localObject).MD5);
            ba.aBQ();
            com.tencent.mm.model.c.azv().aTB(((edo)localObject).Hnp);
            com.tencent.mm.plugin.wear.model.c.a.iP(8, ((edo)localObject).Scene);
            com.tencent.mm.plugin.wear.model.c.a.VS(4);
            continue;
            localObject = new edn();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((edn)localObject).parseFrom(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(aj.getContext(), ((edn)localObject).Hnp, ((edn)localObject).MD5);
              ba.aBQ();
              com.tencent.mm.model.c.azv().aTB(((edn)localObject).Hnp);
              com.tencent.mm.plugin.wear.model.c.a.iP(7, ((edn)localObject).Scene);
              com.tencent.mm.plugin.wear.model.c.a.VS(3);
              continue;
              localObject = new edu();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                ((edu)localObject).parseFrom(paramArrayOfByte);
                com.tencent.mm.plugin.wear.model.a.eKu();
                paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.eKv().DwN.Dxz;
                if (paramArrayOfByte == null)
                {
                  ad.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                  continue;
                }
                ad.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(((edu)localObject).HPh), com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((edu)localObject).Hbs / 1000L) });
                localefp = new efp();
                dip localdip = new dip();
                if (((edu)localObject).HPh > 0)
                {
                  paramInt = ((edu)localObject).HPh;
                  localdip.nEe = paramInt;
                  localdip.Timestamp = ((int)(((edu)localObject).Hbs / 1000L));
                  Calendar localCalendar = Calendar.getInstance();
                  localCalendar.setTimeInMillis(((edu)localObject).Hbs);
                  localdip.Hxv = localCalendar.get(1);
                  localdip.Hxw = (localCalendar.get(2) + 1);
                  localdip.Hxx = localCalendar.get(5);
                  localdip.Hxy = localCalendar.get(11);
                  localdip.Hxz = localCalendar.get(12);
                  localdip.HxA = localCalendar.get(13);
                  localefp.HQP.add(localdip);
                  localObject = new zc();
                }
              }
              catch (IOException paramArrayOfByte)
              {
                try
                {
                  for (;;)
                  {
                    efp localefp;
                    ((zc)localObject).dOj.data = localefp.toByteArray();
                    label661:
                    ((zc)localObject).dOj.dkM = 4;
                    ((zc)localObject).dOj.cUi = paramArrayOfByte.HOE;
                    ((zc)localObject).dOj.dow = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                    break;
                    paramInt = 0;
                    continue;
                    if ((!com.tencent.mm.plugin.wear.model.a.eKv().eKF()) || (com.tencent.mm.n.g.acA().getInt("WearLuckyBlock", 0) != 0))
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
                    paramArrayOfByte = new za();
                    paramArrayOfByte.dNX.action = 1;
                    paramArrayOfByte.dNX.dmV = l1;
                    com.tencent.mm.sdk.b.a.IbL.a(paramArrayOfByte, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.iP(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.VS(11);
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
    private edq DxB;
    
    public a(edq paramedq)
    {
      this.DxB = paramedq;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(30093);
      String str = s.HT(this.DxB.Hnp);
      ad.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[] { str });
      Object localObject = s.Y(str, false);
      ad.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[] { localObject });
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.DxB.Fyu.toByteArray());
      com.tencent.mm.audio.e.c localc = new com.tencent.mm.audio.e.c(8000, 16000);
      localc.gC((String)localObject);
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
      localc.Ry();
      ad.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
      s.aw(str, (int)this.DxB.HPc);
      o.aNA().run();
      ad.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
      ba.aBQ();
      com.tencent.mm.model.c.azv().aTB(this.DxB.Hnp);
      AppMethodBeat.o(30093);
    }
    
    public final String getName()
    {
      return "SendVioceMsgTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m
 * JD-Core Version:    0.7.0.1
 */