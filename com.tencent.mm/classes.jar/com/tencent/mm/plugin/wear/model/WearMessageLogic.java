package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.e.p.1;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.protocal.c.ckn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqpinyin.voicerecoapi.c;
import java.io.IOException;
import java.util.LinkedList;

public class WearMessageLogic
  extends BroadcastReceiver
{
  public WearMessageLogic()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.wear.message");
    ae.getContext().registerReceiver(this, localIntentFilter, "com.tencent.mm.wear.message", null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    int i;
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      paramContext = paramIntent.getExtras();
      i = paramContext.getInt("key_connecttype");
      if (i != 1) {
        break label139;
      }
      paramIntent = new WearMessageLogic.a(this, (byte)0);
      paramIntent.qRZ = i;
      paramIntent.qSa = paramContext.getInt("key_funid");
      paramIntent.igH = paramContext.getInt("key_sessionid");
      paramIntent.qSb = paramContext.getByteArray("key_data");
      paramContext = a.bYL().qRs.Bj(paramIntent.qSa);
      if (paramContext != null) {
        bool = paramContext.Bi(paramIntent.qSa);
      }
      if (!bool) {
        break label115;
      }
      ai.d(paramIntent);
    }
    label115:
    do
    {
      return;
      com.tencent.mm.sdk.f.e.post(paramIntent, "WearHttpMessageTask_" + paramIntent.qSa);
      return;
      if (i == 2)
      {
        paramIntent = new b((byte)0);
        paramIntent.qRZ = i;
        paramIntent.qSa = paramContext.getInt("key_funid");
        paramIntent.igH = paramContext.getInt("key_sessionid");
        paramIntent.qSb = paramContext.getByteArray("key_data");
        a.bYL().qRA.a(paramIntent);
        return;
      }
    } while (i != 3);
    label139:
    a.bYL().qRA.a(new WearMessageLogic.c(this, (byte)0));
  }
  
  private final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int igH;
    public int qRZ;
    public int qSa;
    public byte[] qSb;
    
    private b() {}
    
    protected final void execute()
    {
      switch (this.qSa)
      {
      }
      for (;;)
      {
        return;
        com.tencent.mm.plugin.wear.model.e.p localp = a.bYL().qRu.qRN;
        int i = this.igH;
        Object localObject = this.qSb;
        if (localp.fSX.contains(Integer.valueOf(i))) {
          continue;
        }
        ckn localckn = new ckn();
        try
        {
          localckn.aH((byte[])localObject);
          label75:
          if (localp.qSI == i)
          {
            if (localckn.tXS)
            {
              y.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
              localp.reset();
              return;
            }
            if (localckn.tXR)
            {
              localp.a(i, localckn);
              if (localp.qSG != null)
              {
                localp.qSG.uE();
                localp.qSG = null;
                y.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
              }
              if (localp.qSF != null)
              {
                localp.qSF.stop();
                localp.qSF = null;
                y.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
              }
              if (localp.qSE == null) {
                continue;
              }
              localp.qSE.eJS = true;
              if (!localp.ceg) {
                au.Dk().a(localp.qSE, 0);
              }
              localp.qSE = null;
              y.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
              return;
            }
            localp.a(i, localckn);
            return;
          }
          localp.reset();
          localp.qSI = i;
          y.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.qSI) });
          com.tencent.mm.a.e.deleteFile(com.tencent.mm.plugin.wear.model.e.p.qSD);
          if (localp.qSG == null)
          {
            localp.qSG = new com.tencent.mm.f.c.d();
            localp.qSG.cG(com.tencent.mm.plugin.wear.model.e.p.qSD);
          }
          if (localp.qSF == null)
          {
            localp.qSF = new c(1500000);
            if (localp.qSF.start() != 0)
            {
              localp.qSJ = -2;
              return;
            }
          }
          localObject = localckn.tXp;
          if (localp.qSE == null) {
            ai.d(new p.1(localp, (String)localObject));
          }
          localp.a(i, localckn);
          return;
        }
        catch (IOException localIOException)
        {
          break label75;
        }
      }
    }
    
    public final String getName()
    {
      return "LongConnectTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearMessageLogic
 * JD-Core Version:    0.7.0.1
 */