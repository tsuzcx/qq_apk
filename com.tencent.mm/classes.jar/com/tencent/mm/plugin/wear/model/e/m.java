package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abu;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.protobuf.fkd;
import com.tencent.mm.protocal.protobuf.fke;
import com.tencent.mm.protocal.protobuf.fkf;
import com.tencent.mm.protocal.protobuf.fkg;
import com.tencent.mm.protocal.protobuf.fkk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class m
  extends a
{
  protected final boolean amV(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> gON()
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
  
  protected final byte[] t(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30095);
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).fA(com.tencent.mm.plugin.boots.a.b.smM, 1171);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30095);
      return null;
      Object localObject = new fkg();
      try
      {
        ((fkg)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.gOu().a(new m.a((fkg)localObject));
        com.tencent.mm.plugin.wear.model.a.gOr().bhS(((fkg)localObject).Ueg);
        com.tencent.mm.plugin.wear.model.c.a.lp(2, ((fkg)localObject).CPw);
        com.tencent.mm.plugin.wear.model.c.a.amT(2);
        continue;
        localObject = new fkf();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((fkf)localObject).parseFrom(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.g.eRW().ai(((fkf)localObject).Ueg, ((fkf)localObject).RUd, ab.QZ(((fkf)localObject).Ueg));
          bh.beI();
          com.tencent.mm.model.c.bbR().bwz(((fkf)localObject).Ueg);
          com.tencent.mm.plugin.wear.model.c.a.lp(3, ((fkf)localObject).CPw);
          com.tencent.mm.plugin.wear.model.c.a.amT(5);
          continue;
          localObject = new fke();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((fke)localObject).parseFrom(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.g.eRW().ai(((fke)localObject).Ueg, ((fke)localObject).RUd, ab.QZ(((fke)localObject).Ueg));
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().x(MMApplicationContext.getContext(), ((fke)localObject).Ueg, ((fke)localObject).MD5);
            bh.beI();
            com.tencent.mm.model.c.bbR().bwz(((fke)localObject).Ueg);
            com.tencent.mm.plugin.wear.model.c.a.lp(8, ((fke)localObject).CPw);
            com.tencent.mm.plugin.wear.model.c.a.amT(4);
            continue;
            localObject = new fkd();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((fkd)localObject).parseFrom(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().x(MMApplicationContext.getContext(), ((fkd)localObject).Ueg, ((fkd)localObject).MD5);
              bh.beI();
              com.tencent.mm.model.c.bbR().bwz(((fkd)localObject).Ueg);
              com.tencent.mm.plugin.wear.model.c.a.lp(7, ((fkd)localObject).CPw);
              com.tencent.mm.plugin.wear.model.c.a.amT(3);
              continue;
              localObject = new fkk();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                for (;;)
                {
                  ((fkk)localObject).parseFrom(paramArrayOfByte);
                  label422:
                  com.tencent.mm.plugin.wear.model.a.gOs();
                  com.tencent.mm.plugin.wear.model.b.a((fkk)localObject);
                  break;
                  if ((!com.tencent.mm.plugin.wear.model.a.gOt().gOG()) || (com.tencent.mm.n.h.axc().getInt("WearLuckyBlock", 0) != 0))
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
                    label484:
                    break label484;
                  }
                  paramArrayOfByte = new abu();
                  paramArrayOfByte.gbG.action = 1;
                  paramArrayOfByte.gbG.fxU = l1;
                  EventCenter.instance.asyncPublish(paramArrayOfByte, Looper.getMainLooper());
                  com.tencent.mm.plugin.wear.model.c.a.lp(11, 0);
                  com.tencent.mm.plugin.wear.model.c.a.amT(11);
                  break;
                  paramArrayOfByte = paramArrayOfByte;
                  continue;
                  paramArrayOfByte = paramArrayOfByte;
                  continue;
                  paramArrayOfByte = paramArrayOfByte;
                }
                paramArrayOfByte = paramArrayOfByte;
              }
              catch (IOException paramArrayOfByte)
              {
                break label422;
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