package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dxn;
import com.tencent.mm.protocal.protobuf.dxo;
import com.tencent.mm.protocal.protobuf.dxp;
import com.tencent.mm.protocal.protobuf.dxq;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.dzl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bk;
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
  protected final boolean Uc(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> ewH()
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eJ(com.tencent.mm.plugin.boots.a.b.ntd, 1171);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30095);
      return null;
      Object localObject = new dxq();
      try
      {
        ((dxq)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.ewq().a(new a((dxq)localObject));
        com.tencent.mm.plugin.wear.model.a.ewn().aAf(((dxq)localObject).FDc);
        com.tencent.mm.plugin.wear.model.c.a.iC(2, ((dxq)localObject).Scene);
        com.tencent.mm.plugin.wear.model.c.a.Ua(2);
        continue;
        localObject = new dxp();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((dxp)localObject).parseFrom(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.j.dck().X(((dxp)localObject).FDc, ((dxp)localObject).Ebg, w.xt(((dxp)localObject).FDc));
          az.ayM();
          com.tencent.mm.model.c.awG().aNK(((dxp)localObject).FDc);
          com.tencent.mm.plugin.wear.model.c.a.iC(3, ((dxp)localObject).Scene);
          com.tencent.mm.plugin.wear.model.c.a.Ua(5);
          continue;
          localObject = new dxo();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((dxo)localObject).parseFrom(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.j.dck().X(((dxo)localObject).FDc, ((dxo)localObject).Ebg, w.xt(((dxo)localObject).FDc));
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(ai.getContext(), ((dxo)localObject).FDc, ((dxo)localObject).MD5);
            az.ayM();
            com.tencent.mm.model.c.awG().aNK(((dxo)localObject).FDc);
            com.tencent.mm.plugin.wear.model.c.a.iC(8, ((dxo)localObject).Scene);
            com.tencent.mm.plugin.wear.model.c.a.Ua(4);
            continue;
            localObject = new dxn();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((dxn)localObject).parseFrom(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(ai.getContext(), ((dxn)localObject).FDc, ((dxn)localObject).MD5);
              az.ayM();
              com.tencent.mm.model.c.awG().aNK(((dxn)localObject).FDc);
              com.tencent.mm.plugin.wear.model.c.a.iC(7, ((dxn)localObject).Scene);
              com.tencent.mm.plugin.wear.model.c.a.Ua(3);
              continue;
              localObject = new dxu();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                ((dxu)localObject).parseFrom(paramArrayOfByte);
                com.tencent.mm.plugin.wear.model.a.ewo();
                paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.ewp().BWt.BXg;
                if (paramArrayOfByte == null)
                {
                  ac.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                  continue;
                }
                ac.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(((dxu)localObject).Geb), h.formatTime("yyyy-MM-dd HH:mm:ss", ((dxu)localObject).FrE / 1000L) });
                localdzl = new dzl();
                ddc localddc = new ddc();
                if (((dxu)localObject).Geb > 0)
                {
                  paramInt = ((dxu)localObject).Geb;
                  localddc.ndH = paramInt;
                  localddc.Timestamp = ((int)(((dxu)localObject).FrE / 1000L));
                  Calendar localCalendar = Calendar.getInstance();
                  localCalendar.setTimeInMillis(((dxu)localObject).FrE);
                  localddc.FMK = localCalendar.get(1);
                  localddc.FML = (localCalendar.get(2) + 1);
                  localddc.FMM = localCalendar.get(5);
                  localddc.FMN = localCalendar.get(11);
                  localddc.FMO = localCalendar.get(12);
                  localddc.FMP = localCalendar.get(13);
                  localdzl.GfG.add(localddc);
                  localObject = new yi();
                }
              }
              catch (IOException paramArrayOfByte)
              {
                try
                {
                  for (;;)
                  {
                    dzl localdzl;
                    ((yi)localObject).dBW.data = localdzl.toByteArray();
                    label661:
                    ((yi)localObject).dBW.cZu = 4;
                    ((yi)localObject).dBW.cIZ = paramArrayOfByte.Gdy;
                    ((yi)localObject).dBW.dda = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                    break;
                    paramInt = 0;
                    continue;
                    if ((!com.tencent.mm.plugin.wear.model.a.ewp().ewz()) || (com.tencent.mm.m.g.ZY().getInt("WearLuckyBlock", 0) != 0))
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
                    paramArrayOfByte = new yg();
                    paramArrayOfByte.dBK.action = 1;
                    paramArrayOfByte.dBK.dbz = l1;
                    com.tencent.mm.sdk.b.a.GpY.a(paramArrayOfByte, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.iC(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.Ua(11);
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
    private dxq BXi;
    
    public a(dxq paramdxq)
    {
      this.BXi = paramdxq;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(30093);
      String str = s.EE(this.BXi.FDc);
      ac.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[] { str });
      Object localObject = s.Y(str, false);
      ac.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[] { localObject });
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.BXi.DTb.toByteArray());
      com.tencent.mm.audio.e.c localc = new com.tencent.mm.audio.e.c(8000, 16000);
      localc.fH((String)localObject);
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
      localc.PM();
      ac.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
      s.au(str, (int)this.BXi.GdW);
      o.aKr().run();
      ac.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
      az.ayM();
      com.tencent.mm.model.c.awG().aNK(this.BXi.FDc);
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