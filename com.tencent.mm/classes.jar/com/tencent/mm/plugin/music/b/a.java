package com.tencent.mm.plugin.music.b;

import com.tencent.mm.af.b;
import com.tencent.mm.af.d;
import com.tencent.mm.h.a.s;
import com.tencent.mm.h.a.s.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static boolean a(s params)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool2 = false;
    if (params.bFK.action != 6) {
      y.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(params.bFK.action) });
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    switch (params.bFK.action)
    {
    default: 
    case 10: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 14: 
    case 5: 
    case 4: 
    case 8: 
    case 7: 
    case 17: 
    case 13: 
    case 6: 
    case 11: 
    case 12: 
    case 9: 
    case 15: 
      do
      {
        return true;
        localObject1 = e.blY().dZ(params.bFK.appId, params.bFK.bFM);
        params.bFK.bFM = ((String)localObject1);
        return true;
        bool1 = e.blY().b(params.bFK.bFO);
        params.bFL.bFQ = bool1;
        return bool1;
        bool1 = e.blY().a(params.bFK.bFM, params.bFK.bFO);
        params.bFL.bFQ = bool1;
        return bool1;
        localObject1 = e.blY();
        localObject2 = params.bFK.bFM;
        localObject3 = ((e)localObject1).IV((String)localObject2);
        if (localObject3 == null) {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
        }
        for (bool1 = false;; bool1 = true)
        {
          params.bFL.bFQ = bool1;
          return bool1;
          y.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[] { localObject2 });
          ((g)localObject3).pause();
          ((e)localObject1).b((String)localObject2, (g)localObject3);
          ((e)localObject1).f((String)localObject2, (g)localObject3);
        }
        bool1 = e.blY().IR(params.bFK.bFM);
        params.bFL.bFQ = bool1;
        return bool1;
        localObject1 = e.blY();
        localObject2 = params.bFK.bFM;
        localObject3 = ((e)localObject1).IV((String)localObject2);
        if (localObject3 == null) {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
        }
        for (bool1 = bool2;; bool1 = true)
        {
          params.bFL.bFQ = bool1;
          return bool1;
          y.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[] { localObject2 });
          ((g)localObject3).eaW = false;
          ((g)localObject3).mxs = true;
          ((g)localObject3).bmr();
          ((g)localObject3).dEq = System.currentTimeMillis();
          localObject4 = (b)((e)localObject1).mwV.get(localObject2);
          if (localObject4 != null)
          {
            ((b)localObject4).startTime = 0;
            ((b)localObject4).eaO = true;
          }
          ((e)localObject1).b((String)localObject2, (g)localObject3);
          ((e)localObject1).f((String)localObject2, (g)localObject3);
        }
        bool1 = e.blY().IS(params.bFK.bFM);
        params.bFL.bFQ = bool1;
        return bool1;
        localObject1 = e.blY();
        localObject2 = params.bFK.bFM;
        int i = params.bFK.bFN;
        localObject3 = ((e)localObject1).IV((String)localObject2);
        if (localObject3 == null)
        {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
          bool1 = ((e)localObject1).bY((String)localObject2, i);
        }
        for (;;)
        {
          params.bFL.bFQ = bool1;
          return bool1;
          if (i < 0)
          {
            y.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((g)localObject3).getDuration()) });
            bool1 = bool3;
          }
          else
          {
            if (((g)localObject3).getDuration() <= 0) {
              y.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((g)localObject3).getDuration()) });
            }
            do
            {
              ((g)localObject3).bms();
              bool1 = ((e)localObject1).bY((String)localObject2, i);
              break;
              if ((i > 0) && (i > ((g)localObject3).getDuration()))
              {
                y.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((g)localObject3).getDuration()) });
                bool1 = bool3;
                break;
              }
              y.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[] { localObject2, Integer.valueOf(i) });
            } while ((!((g)localObject3).Pu()) && (!((g)localObject3).Pv()) && (!((g)localObject3).isPaused()));
            bool1 = ((g)localObject3).iV(i);
          }
        }
        localObject1 = e.blY().IV(params.bFK.bFM);
        if (localObject1 == null) {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
        }
        for (bool1 = bool4;; bool1 = ((g)localObject1).Pv())
        {
          params.bFL.bFQ = bool1;
          return bool1;
        }
        localObject1 = e.blY().IV(params.bFK.bFM);
        if (localObject1 == null) {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
        }
        for (bool1 = bool5;; bool1 = ((g)localObject1).Pu())
        {
          params.bFL.bFQ = bool1;
          return bool1;
        }
        localObject1 = e.blY().IV(params.bFK.bFM);
        if (localObject1 == null) {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
        }
        for (;;)
        {
          params.bFL.bFQ = bool1;
          return bool1;
          bool1 = ((g)localObject1).isStopped();
        }
        localObject1 = e.blY();
        localObject2 = params.bFK.bFM;
        localObject3 = ((e)localObject1).IV((String)localObject2);
        if (localObject3 == null)
        {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
          localObject1 = ((e)localObject1).IT((String)localObject2);
          bool1 = bool6;
          if (localObject1 == null) {}
        }
        for (bool1 = ((d)localObject1).eaW;; bool1 = ((g)localObject3).eaW)
        {
          params.bFL.bFQ = bool1;
          return bool1;
        }
        localObject1 = e.blY().IT(params.bFK.bFM);
        params.bFL.bFR = ((d)localObject1);
        return true;
        i = e.blY().IU(params.bFK.appId);
        params.bFL.count = i;
        return true;
        e.blY().IW(params.bFK.appId);
        return true;
        e.blY().IX(params.bFK.appId);
        return true;
        localObject1 = e.blY();
        params = params.bFK.processName;
      } while (((e)localObject1).mwS.size() == 0);
      y.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[] { params });
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll(((e)localObject1).mwS);
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = (String)((e)localObject1).mwT.get(localObject3);
        if ((params != null) && (params.equalsIgnoreCase((String)localObject4)))
        {
          y.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
          ((e)localObject1).IX((String)localObject3);
        }
      }
    case 16: 
      localObject1 = e.blY().jQ(params.bFK.bFM);
      params.bFK.bFO = ((b)localObject1);
      return true;
    case 18: 
      localObject4 = e.blY();
      localObject2 = params.bFK.bFO;
      if (localObject2 == null)
      {
        y.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
        bool1 = bool7;
        params.bFL.bFQ = bool1;
        return bool1;
      }
      localObject3 = (b)((e)localObject4).mwV.get(((b)localObject2).bFM);
      if (localObject3 != null)
      {
        ((b)localObject3).bFM = ((b)localObject2).bFM;
        ((b)localObject3).ceM = ((b)localObject2).ceM;
        if ((((b)localObject2).filePath != null) && (!((b)localObject2).filePath.equals(""))) {
          ((b)localObject3).filePath = ((b)localObject2).filePath;
        }
        ((b)localObject3).startTime = ((b)localObject2).startTime;
        ((b)localObject3).eaN = ((b)localObject2).eaN;
        ((b)localObject3).eaO = ((b)localObject2).eaO;
        ((b)localObject3).eaP = ((b)localObject2).eaP;
        ((b)localObject3).fromScene = ((b)localObject2).fromScene;
        ((b)localObject3).processName = ((b)localObject2).processName;
        ((b)localObject3).eaR = ((b)localObject2).eaR;
        ((b)localObject3).appId = ((b)localObject2).appId;
        localObject1 = localObject3;
        if (((b)localObject2).eaV != null)
        {
          ((b)localObject3).eaV = ((b)localObject2).eaV;
          localObject1 = localObject3;
        }
        label1470:
        localObject2 = ((e)localObject4).IV(((b)localObject2).bFM);
        if (localObject2 == null) {
          break label1530;
        }
        y.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
        ((g)localObject2).c((b)localObject1);
      }
      for (;;)
      {
        bool1 = true;
        break;
        ((e)localObject4).mwV.put(((b)localObject2).bFM, localObject2);
        localObject1 = localObject2;
        break label1470;
        label1530:
        y.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
      }
    }
    e.blY().bFP = params.bFK.bFP;
    params.bFL.bFQ = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a
 * JD-Core Version:    0.7.0.1
 */