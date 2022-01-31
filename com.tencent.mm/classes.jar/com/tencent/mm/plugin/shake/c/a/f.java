package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.h.a.po;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public List<WeakReference<a>> fKm = new ArrayList();
  private String nZy = "";
  
  private void axs()
  {
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((a)localObject).bAd();
          }
        }
        i += 1;
      }
    }
  }
  
  private static void bAc()
  {
    po localpo = new po();
    com.tencent.mm.sdk.b.a.udP.m(localpo);
  }
  
  private static boolean yS(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public final void h(String paramString, long paramLong, int paramInt)
  {
    Map localMap = null;
    Object localObject = null;
    y.i("MicroMsg.ShakeCardMsgMgr", "msg_id is " + paramLong);
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
      return;
    }
    if (paramInt == 0)
    {
      y.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
      localMap = bn.s(paramString, "sysmsg");
      if (localMap == null)
      {
        paramString = (String)localObject;
        if (paramString != null) {
          break label491;
        }
        y.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
        bAc();
      }
    }
    label138:
    label180:
    label238:
    while (paramInt != 1) {
      for (;;)
      {
        com.tencent.mm.plugin.shake.c.c.a.bzO();
        return;
        paramString = new f.b();
        localObject = (String)localMap.get(".sysmsg.begintime");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (yS((String)localObject)))
        {
          paramString.nZz = Integer.valueOf((String)localObject).intValue();
          localObject = (String)localMap.get(".sysmsg.endtime");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!yS((String)localObject))) {
            break label393;
          }
          paramString.nZA = Integer.valueOf((String)localObject).intValue();
          paramString.nZB = ((String)localMap.get(".sysmsg.entrancename"));
          localObject = (String)localMap.get(".sysmsg.activitytype");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!yS((String)localObject))) {
            break label423;
          }
          paramString.nZC = Integer.valueOf((String)localObject).intValue();
          y.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is " + (String)localObject);
          localObject = (String)localMap.get(".sysmsg.flowcontrollevelmin");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!yS((String)localObject))) {
            break label431;
          }
          paramString.nZD = Integer.valueOf((String)localObject).intValue();
          paramString.nZF = ((String)localMap.get(".sysmsg.shakecardentrancetip"));
          localObject = (String)localMap.get(".sysmsg.flowcontrollevelmax");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!yS((String)localObject))) {
            break label461;
          }
        }
        for (paramString.nZE = Integer.valueOf((String)localObject).intValue();; paramString.nZE = 0)
        {
          break;
          y.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is " + (String)localObject);
          paramString.nZz = 0;
          break label138;
          y.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is " + (String)localObject);
          paramString.nZA = 0;
          break label180;
          paramString.nZC = 1;
          break label238;
          y.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is " + (String)localObject);
          paramString.nZD = 0;
          break label302;
          y.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is " + (String)localObject);
        }
        y.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
        if (!com.tencent.mm.plugin.shake.c.c.a.bzP()) {
          y.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
        }
        y.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramString.nZz + "  endtime:" + paramString.nZA + "  flowlevelmin:" + paramString.nZD + "  flowlevelmax:" + paramString.nZE + " entrancename:" + paramString.nZB + " activitytype:" + paramString.nZC);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unG, Integer.valueOf(paramString.nZz));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unH, Integer.valueOf(paramString.nZA));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unI, paramString.nZB);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unM, Integer.valueOf(paramString.nZC));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unJ, Integer.valueOf(paramString.nZD));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unK, Integer.valueOf(paramString.nZE));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unL, paramString.nZF);
      }
    }
    label302:
    label431:
    label461:
    label491:
    y.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
    label393:
    label423:
    localObject = bn.s(paramString, "sysmsg");
    if (localObject == null)
    {
      paramString = localMap;
      label762:
      if (paramString != null) {
        break label842;
      }
      y.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
    }
    for (;;)
    {
      bAc();
      break;
      paramString = new f.d();
      paramString.nZG = ((String)((Map)localObject).get(".sysmsg.reddotid"));
      paramString.nZH = ((String)((Map)localObject).get(".sysmsg.reddotdesc"));
      paramString.nZI = ((String)((Map)localObject).get(".sysmsg.reddottext"));
      break label762;
      label842:
      y.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramString.nZG);
      y.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.nZy);
      if (TextUtils.isEmpty(paramString.nZG))
      {
        y.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      }
      else if (TextUtils.isEmpty(this.nZy))
      {
        y.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
        com.tencent.mm.y.c.BS().w(262154, true);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unN, paramString.nZG);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unO, paramString.nZH);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unP, paramString.nZI);
        axs();
      }
      else if (!this.nZy.equals(paramString.nZG))
      {
        y.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
        com.tencent.mm.y.c.BS().w(262154, true);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unN, paramString.nZG);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unO, paramString.nZH);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unP, paramString.nZI);
        axs();
      }
      else if (this.nZy.equals(paramString.nZG))
      {
        y.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bAd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */