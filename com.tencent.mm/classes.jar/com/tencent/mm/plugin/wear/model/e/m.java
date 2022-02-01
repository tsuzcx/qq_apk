package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.autogen.a.adr;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.protobuf.ggr;
import com.tencent.mm.protocal.protobuf.ggs;
import com.tencent.mm.protocal.protobuf.ggt;
import com.tencent.mm.protocal.protobuf.ggu;
import com.tencent.mm.protocal.protobuf.ggy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.by;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class m
  extends a
{
  protected final boolean asM(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> iob()
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
  
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30095);
    ((com.tencent.mm.plugin.boots.a.c)h.ax(com.tencent.mm.plugin.boots.a.c.class)).gs(com.tencent.mm.plugin.boots.a.b.vyL, 1171);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30095);
      return null;
      Object localObject = new ggu();
      try
      {
        ((ggu)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.inJ().a(new a((ggu)localObject));
        com.tencent.mm.plugin.wear.model.a.inG().bhB(((ggu)localObject).abvu);
        com.tencent.mm.plugin.wear.model.c.a.kK(2, ((ggu)localObject).IJG);
        com.tencent.mm.plugin.wear.model.c.a.asK(2);
        continue;
        localObject = new ggt();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((ggt)localObject).parseFrom(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.g.gaI().ap(((ggt)localObject).abvu, ((ggt)localObject).YRE, ab.IX(((ggt)localObject).abvu));
          bh.bCz();
          com.tencent.mm.model.c.bzG().bxO(((ggt)localObject).abvu);
          com.tencent.mm.plugin.wear.model.c.a.kK(3, ((ggt)localObject).IJG);
          com.tencent.mm.plugin.wear.model.c.a.asK(5);
          continue;
          localObject = new ggs();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((ggs)localObject).parseFrom(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.g.gaI().ap(((ggs)localObject).abvu, ((ggs)localObject).YRE, ab.IX(((ggs)localObject).abvu));
            ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().y(MMApplicationContext.getContext(), ((ggs)localObject).abvu, ((ggs)localObject).MD5);
            bh.bCz();
            com.tencent.mm.model.c.bzG().bxO(((ggs)localObject).abvu);
            com.tencent.mm.plugin.wear.model.c.a.kK(8, ((ggs)localObject).IJG);
            com.tencent.mm.plugin.wear.model.c.a.asK(4);
            continue;
            localObject = new ggr();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((ggr)localObject).parseFrom(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().y(MMApplicationContext.getContext(), ((ggr)localObject).abvu, ((ggr)localObject).MD5);
              bh.bCz();
              com.tencent.mm.model.c.bzG().bxO(((ggr)localObject).abvu);
              com.tencent.mm.plugin.wear.model.c.a.kK(7, ((ggr)localObject).IJG);
              com.tencent.mm.plugin.wear.model.c.a.asK(3);
              continue;
              localObject = new ggy();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                for (;;)
                {
                  ((ggy)localObject).parseFrom(paramArrayOfByte);
                  label422:
                  com.tencent.mm.plugin.wear.model.a.inH();
                  com.tencent.mm.plugin.wear.model.b.a((ggy)localObject);
                  break;
                  if ((!com.tencent.mm.plugin.wear.model.a.inI().inU()) || (com.tencent.mm.k.i.aRC().getInt("WearLuckyBlock", 0) != 0))
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
                  paramArrayOfByte = new adr();
                  paramArrayOfByte.ihS.action = 1;
                  paramArrayOfByte.ihS.hCz = l1;
                  paramArrayOfByte.asyncPublish(Looper.getMainLooper());
                  com.tencent.mm.plugin.wear.model.c.a.kK(11, 0);
                  com.tencent.mm.plugin.wear.model.c.a.asK(11);
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
  
  static final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    private ggu Wjm;
    
    public a(ggu paramggu)
    {
      this.Wjm = paramggu;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(30093);
      String str = s.QJ(this.Wjm.abvu);
      Log.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[] { str });
      Object localObject = s.af(str, false);
      Log.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[] { localObject });
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.Wjm.YID.toByteArray());
      com.tencent.mm.audio.e.c localc = new com.tencent.mm.audio.e.c(8000, 16000);
      localc.jO((String)localObject);
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
      localc.aIz();
      Log.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
      s.bi(str, (int)this.Wjm.acdg);
      o.bPh().run();
      Log.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxO(this.Wjm.abvu);
      AppMethodBeat.o(30093);
    }
    
    public final String getName()
    {
      return "SendVioceMsgTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m
 * JD-Core Version:    0.7.0.1
 */