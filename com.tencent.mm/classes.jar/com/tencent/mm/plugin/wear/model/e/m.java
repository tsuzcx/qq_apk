package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.g.a.zg;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.protocal.protobuf.efe;
import com.tencent.mm.protocal.protobuf.eff;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.br;
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
  protected final boolean WB(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> eOv()
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eO(com.tencent.mm.plugin.boots.a.b.nZF, 1171);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30095);
      return null;
      Object localObject = new efh();
      try
      {
        ((efh)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.eOe().a(new a((efh)localObject));
        com.tencent.mm.plugin.wear.model.a.eOb().aGJ(((efh)localObject).HGP);
        com.tencent.mm.plugin.wear.model.c.a.iT(2, ((efh)localObject).Scene);
        com.tencent.mm.plugin.wear.model.c.a.Wz(2);
        continue;
        localObject = new efg();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((efg)localObject).parseFrom(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.g.doC().aa(((efg)localObject).HGP, ((efg)localObject).FZl, x.Bb(((efg)localObject).HGP));
          bc.aCg();
          com.tencent.mm.model.c.azL().aVc(((efg)localObject).HGP);
          com.tencent.mm.plugin.wear.model.c.a.iT(3, ((efg)localObject).Scene);
          com.tencent.mm.plugin.wear.model.c.a.Wz(5);
          continue;
          localObject = new eff();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((eff)localObject).parseFrom(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.g.doC().aa(((eff)localObject).HGP, ((eff)localObject).FZl, x.Bb(((eff)localObject).HGP));
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(ak.getContext(), ((eff)localObject).HGP, ((eff)localObject).MD5);
            bc.aCg();
            com.tencent.mm.model.c.azL().aVc(((eff)localObject).HGP);
            com.tencent.mm.plugin.wear.model.c.a.iT(8, ((eff)localObject).Scene);
            com.tencent.mm.plugin.wear.model.c.a.Wz(4);
            continue;
            localObject = new efe();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((efe)localObject).parseFrom(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(ak.getContext(), ((efe)localObject).HGP, ((efe)localObject).MD5);
              bc.aCg();
              com.tencent.mm.model.c.azL().aVc(((efe)localObject).HGP);
              com.tencent.mm.plugin.wear.model.c.a.iT(7, ((efe)localObject).Scene);
              com.tencent.mm.plugin.wear.model.c.a.Wz(3);
              continue;
              localObject = new efl();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                ((efl)localObject).parseFrom(paramArrayOfByte);
                com.tencent.mm.plugin.wear.model.a.eOc();
                paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.eOd().DOs.DPe;
                if (paramArrayOfByte == null)
                {
                  ae.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                  continue;
                }
                ae.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(((efl)localObject).Ijo), com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((efl)localObject).HuS / 1000L) });
                localehg = new ehg();
                djk localdjk = new djk();
                if (((efl)localObject).Ijo > 0)
                {
                  paramInt = ((efl)localObject).Ijo;
                  localdjk.nJz = paramInt;
                  localdjk.Timestamp = ((int)(((efl)localObject).HuS / 1000L));
                  Calendar localCalendar = Calendar.getInstance();
                  localCalendar.setTimeInMillis(((efl)localObject).HuS);
                  localdjk.HRg = localCalendar.get(1);
                  localdjk.HRh = (localCalendar.get(2) + 1);
                  localdjk.HRi = localCalendar.get(5);
                  localdjk.HRj = localCalendar.get(11);
                  localdjk.HRk = localCalendar.get(12);
                  localdjk.HRl = localCalendar.get(13);
                  localehg.IkW.add(localdjk);
                  localObject = new zi();
                }
              }
              catch (IOException paramArrayOfByte)
              {
                try
                {
                  for (;;)
                  {
                    ehg localehg;
                    ((zi)localObject).dPz.data = localehg.toByteArray();
                    label661:
                    ((zi)localObject).dPz.dlO = 4;
                    ((zi)localObject).dPz.cVh = paramArrayOfByte.IiL;
                    ((zi)localObject).dPz.dpB = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                    break;
                    paramInt = 0;
                    continue;
                    if ((!com.tencent.mm.plugin.wear.model.a.eOd().eOn()) || (com.tencent.mm.n.g.acL().getInt("WearLuckyBlock", 0) != 0))
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
                    paramArrayOfByte = new zg();
                    paramArrayOfByte.dPn.action = 1;
                    paramArrayOfByte.dPn.dnX = l1;
                    com.tencent.mm.sdk.b.a.IvT.a(paramArrayOfByte, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.iT(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.Wz(11);
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
    private efh DPg;
    
    public a(efh paramefh)
    {
      this.DPg = paramefh;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(30093);
      String str = s.Iv(this.DPg.HGP);
      ae.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[] { str });
      Object localObject = s.Y(str, false);
      ae.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[] { localObject });
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.DPg.FQS.toByteArray());
      com.tencent.mm.audio.e.c localc = new com.tencent.mm.audio.e.c(8000, 16000);
      localc.gI((String)localObject);
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
      localc.Rx();
      ae.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
      s.ax(str, (int)this.DPg.Ijj);
      o.aNY().run();
      ae.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
      bc.aCg();
      com.tencent.mm.model.c.azL().aVc(this.DPg.HGP);
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