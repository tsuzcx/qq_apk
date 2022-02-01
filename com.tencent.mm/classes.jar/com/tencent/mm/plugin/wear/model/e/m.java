package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aan;
import com.tencent.mm.g.a.aap;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.boots.a.b;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.protobuf.ecw;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.protocal.protobuf.ezm;
import com.tencent.mm.protocal.protobuf.ezn;
import com.tencent.mm.protocal.protobuf.ezo;
import com.tencent.mm.protocal.protobuf.ezp;
import com.tencent.mm.protocal.protobuf.ezt;
import com.tencent.mm.protocal.protobuf.fbx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends a
{
  protected final boolean afh(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> fWe()
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(b.pkD, 1171);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30095);
      return null;
      Object localObject = new ezp();
      try
      {
        ((ezp)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.fVN().a(new m.a((ezp)localObject));
        com.tencent.mm.plugin.wear.model.a.fVK().aWl(((ezp)localObject).MRZ);
        com.tencent.mm.plugin.wear.model.c.a.jZ(2, ((ezp)localObject).Scene);
        com.tencent.mm.plugin.wear.model.c.a.aff(2);
        continue;
        localObject = new ezo();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((ezo)localObject).parseFrom(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.g.eir().ad(((ezo)localObject).MRZ, ((ezo)localObject).KTg, ab.JG(((ezo)localObject).MRZ));
          bg.aVF();
          com.tencent.mm.model.c.aST().bka(((ezo)localObject).MRZ);
          com.tencent.mm.plugin.wear.model.c.a.jZ(3, ((ezo)localObject).Scene);
          com.tencent.mm.plugin.wear.model.c.a.aff(5);
          continue;
          localObject = new ezn();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((ezn)localObject).parseFrom(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.g.eir().ad(((ezn)localObject).MRZ, ((ezn)localObject).KTg, ab.JG(((ezn)localObject).MRZ));
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(MMApplicationContext.getContext(), ((ezn)localObject).MRZ, ((ezn)localObject).MD5);
            bg.aVF();
            com.tencent.mm.model.c.aST().bka(((ezn)localObject).MRZ);
            com.tencent.mm.plugin.wear.model.c.a.jZ(8, ((ezn)localObject).Scene);
            com.tencent.mm.plugin.wear.model.c.a.aff(4);
            continue;
            localObject = new ezm();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((ezm)localObject).parseFrom(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(MMApplicationContext.getContext(), ((ezm)localObject).MRZ, ((ezm)localObject).MD5);
              bg.aVF();
              com.tencent.mm.model.c.aST().bka(((ezm)localObject).MRZ);
              com.tencent.mm.plugin.wear.model.c.a.jZ(7, ((ezm)localObject).Scene);
              com.tencent.mm.plugin.wear.model.c.a.aff(3);
              continue;
              localObject = new ezt();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                ((ezt)localObject).parseFrom(paramArrayOfByte);
                com.tencent.mm.plugin.wear.model.a.fVL();
                paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.fVM().IxH.Iyu;
                if (paramArrayOfByte == null)
                {
                  Log.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                  continue;
                }
                Log.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(((ezt)localObject).NvS), com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", ((ezt)localObject).MDQ / 1000L) });
                localfbx = new fbx();
                ecw localecw = new ecw();
                if (((ezt)localObject).NvS > 0)
                {
                  paramInt = ((ezt)localObject).NvS;
                  localecw.oUu = paramInt;
                  localecw.Timestamp = ((int)(((ezt)localObject).MDQ / 1000L));
                  Calendar localCalendar = Calendar.getInstance();
                  localCalendar.setTimeInMillis(((ezt)localObject).MDQ);
                  localecw.Ndh = localCalendar.get(1);
                  localecw.Ndi = (localCalendar.get(2) + 1);
                  localecw.Ndj = localCalendar.get(5);
                  localecw.Ndk = localCalendar.get(11);
                  localecw.Ndl = localCalendar.get(12);
                  localecw.Ndm = localCalendar.get(13);
                  localfbx.NxX.add(localecw);
                  localObject = new aap();
                }
              }
              catch (IOException paramArrayOfByte)
              {
                try
                {
                  for (;;)
                  {
                    fbx localfbx;
                    ((aap)localObject).ehC.data = localfbx.toByteArray();
                    label661:
                    ((aap)localObject).ehC.dDe = 4;
                    ((aap)localObject).ehC.dGL = paramArrayOfByte.Nvp;
                    ((aap)localObject).ehC.dGP = "gh_43f2581f6fd6";
                    EventCenter.instance.publish((IEvent)localObject);
                    break;
                    paramInt = 0;
                    continue;
                    if ((!com.tencent.mm.plugin.wear.model.a.fVM().fVW()) || (h.aqJ().getInt("WearLuckyBlock", 0) != 0))
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
                    paramArrayOfByte = new aan();
                    paramArrayOfByte.ehq.action = 1;
                    paramArrayOfByte.ehq.dFm = l1;
                    EventCenter.instance.asyncPublish(paramArrayOfByte, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.jZ(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.aff(11);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m
 * JD-Core Version:    0.7.0.1
 */