package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a
  implements b
{
  private static HashMap<String, Integer> mxF = new HashMap();
  private static HashMap<String, List<Long>> mxG = new HashMap();
  private static HashMap<String, List<Long>> mxH = new HashMap();
  private static HashMap<String, List<Long>> mxI = new HashMap();
  
  public final void Je(String paramString)
  {
    com.tencent.mm.cg.a.post(new a.3(this, paramString));
  }
  
  public final void a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    com.tencent.mm.cg.a.post(new a.2(this, paramString1, paramString2, paramLong1, paramLong2, paramLong3));
  }
  
  public final void dm(int paramInt1, int paramInt2)
  {
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(688);
    localIDKey1.SetKey(1);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(688);
    y.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrSceneIdKey, scene:" + paramInt1);
    switch (paramInt1)
    {
    }
    localIDKey2.SetKey(9);
    localIDKey2.SetValue(1L);
    IDKey localIDKey3 = new IDKey();
    localIDKey3.SetID(688);
    y.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:" + paramInt2);
    switch (paramInt2)
    {
    default: 
      paramInt1 = 30;
    }
    for (;;)
    {
      localIDKey3.SetKey(paramInt1);
      localIDKey3.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      localArrayList.add(localIDKey3);
      h.nFQ.b(localArrayList, true);
      return;
      paramInt1 = 17;
      continue;
      paramInt1 = 18;
      continue;
      paramInt1 = 19;
      continue;
      paramInt1 = 20;
      continue;
      paramInt1 = 21;
      continue;
      paramInt1 = 22;
      continue;
      paramInt1 = 23;
      continue;
      paramInt1 = 24;
      continue;
      paramInt1 = 25;
      continue;
      paramInt1 = 36;
      continue;
      paramInt1 = 26;
      continue;
      paramInt1 = 27;
      continue;
      paramInt1 = 28;
      continue;
      paramInt1 = 29;
      continue;
      paramInt1 = 31;
      continue;
      paramInt1 = 32;
      continue;
      paramInt1 = 33;
      continue;
      paramInt1 = 34;
      continue;
      paramInt1 = 35;
    }
  }
  
  public final void ea(final String paramString1, final String paramString2)
  {
    com.tencent.mm.cg.a.post(new Runnable()
    {
      public final void run()
      {
        String str = paramString1 + "-" + ad.bB(paramString2);
        synchronized (a.aYI())
        {
          if (a.aYI().containsKey(str))
          {
            a.aYI().put(str, Integer.valueOf(((Integer)a.aYI().get(str)).intValue() + 1));
            return;
          }
          a.aYI().put(str, Integer.valueOf(1));
        }
      }
    });
  }
  
  public final void ux(int paramInt)
  {
    y.d("MicroMsg.Audio.AudioPlayIdKeyReport", "idKeyReportQQAudioPlayerSum scene:%d", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(688);
    localIDKey1.SetKey(0);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(688);
    y.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerSumIdKeyByScene, scene:" + paramInt);
    switch (paramInt)
    {
    }
    localIDKey2.SetKey(2);
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    h.nFQ.b(localArrayList, true);
  }
  
  public final void uy(int paramInt)
  {
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(688);
    if (paramInt == 2) {
      paramInt = 42;
    }
    for (;;)
    {
      localIDKey.SetKey(paramInt);
      localIDKey.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey);
      h.nFQ.b(localArrayList, true);
      return;
      if (paramInt == 3) {
        paramInt = 43;
      } else if (paramInt == 4) {
        paramInt = 44;
      } else if (paramInt == 5) {
        paramInt = 45;
      } else if (paramInt == 6) {
        paramInt = 46;
      } else if (paramInt == 7) {
        paramInt = 47;
      } else if (paramInt == 8) {
        paramInt = 48;
      } else if (paramInt == 9) {
        paramInt = 49;
      } else {
        paramInt = 50;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.a
 * JD-Core Version:    0.7.0.1
 */