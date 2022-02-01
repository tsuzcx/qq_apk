package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
{
  public static boolean Kk(int paramInt)
  {
    AppMethodBeat.i(127216);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dkc().Kr(paramInt);
    if (locala == null)
    {
      ac.e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
      AppMethodBeat.o(127216);
      return false;
    }
    String str3;
    label285:
    Object localObject;
    label303:
    String str1;
    if ((d(com.tencent.mm.plugin.newtips.a.dkc().Kr(paramInt))) && (locala.field_tipsShowInfo != null) && (locala.field_tipsShowInfo.cZX == d.vmY))
    {
      if (locala == null) {
        ac.e("MicroMsg.NewTipsManager", "reportShowNewTips, newTipsInfo is null !!");
      }
      do
      {
        AppMethodBeat.o(127216);
        return true;
        str3 = String.format("newtips_show_%d-%d", new Object[] { Integer.valueOf(locala.field_tipId), Integer.valueOf(locala.field_tipVersion) });
      } while (ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).getBoolean(str3, false));
      i = locala.field_tipId;
      j = locala.field_tipVersion;
      k = locala.field_tipType;
      l1 = ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).getLong("newtips_gettipstime", 0L);
      l2 = bs.eWj();
      ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).edit().putLong("newtips_realshow_time", l2).commit();
      if (locala.field_tipsShowInfo != null)
      {
        paramInt = locala.field_tipsShowInfo.cZX;
        if (locala.field_tipsShowInfo == null) {
          break label528;
        }
        localObject = locala.field_tipsShowInfo.title;
        if (locala.field_tipsShowInfo == null) {
          break label535;
        }
        str1 = locala.field_tipsShowInfo.oGN;
        label321:
        if (locala.field_tipsShowInfo == null) {
          break label542;
        }
      }
      label528:
      label535:
      label542:
      for (str2 = locala.field_tipsShowInfo.path;; str2 = "")
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14995, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), "", "", "", Long.valueOf(l2), "", "", "", Integer.valueOf(paramInt), localObject, str1, str2, "", Integer.valueOf(d.vne), "" });
        ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).edit().putBoolean(str3, true).commit();
        break;
        paramInt = 0;
        break label285;
        localObject = "";
        break label303;
        str1 = "";
        break label321;
      }
    }
    if (locala == null) {
      ac.e("MicroMsg.NewTipsManager", "reportDismissNewTips, newTipsInfo is null !!");
    }
    do
    {
      AppMethodBeat.o(127216);
      return false;
      str3 = String.format("newtips_dismiss_%d-%d", new Object[] { Integer.valueOf(locala.field_tipId), Integer.valueOf(locala.field_tipVersion) });
    } while (ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).getBoolean(str3, false));
    int j = locala.field_tipId;
    int k = locala.field_tipVersion;
    int m = locala.field_tipType;
    long l1 = ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).getLong("newtips_gettipstime", 0L);
    long l2 = locala.field_beginShowTime;
    long l3 = locala.field_overdueTime;
    long l4 = locala.field_disappearTime;
    long l5 = ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).getLong("newtips_realshow_time", 0L);
    long l6 = ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).getLong("newtips_makeread_time", 0L);
    int i = 0;
    long l7 = bs.aNx();
    if ((!b(locala)) || (!c(locala)))
    {
      paramInt = 1;
      label819:
      if (locala.field_tipsShowInfo == null) {
        break label1299;
      }
      i = locala.field_tipsShowInfo.cZX;
      label836:
      if (locala.field_tipsShowInfo == null) {
        break label1304;
      }
      localObject = locala.field_tipsShowInfo.title;
      label854:
      if (locala.field_tipsShowInfo == null) {
        break label1311;
      }
      str1 = locala.field_tipsShowInfo.oGN;
      label872:
      if (locala.field_tipsShowInfo == null) {
        break label1318;
      }
    }
    label1299:
    label1304:
    label1311:
    label1318:
    for (String str2 = locala.field_tipsShowInfo.path;; str2 = "")
    {
      l7 = locala.field_pagestaytime;
      com.tencent.mm.plugin.report.service.h.wUl.f(14995, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l6 - l5), Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str1, str2, "", Integer.valueOf(d.vnf), Long.valueOf(l7) });
      if (m == d.vmP)
      {
        localObject = com.tencent.mm.plugin.newtips.a.dkc();
        str1 = "delete from NewTipsInfo where tipId = " + locala.field_tipId;
        ac.i("MicroMsg.NewTipsCompatInfoStorage", "delete sql: ".concat(String.valueOf(str1)));
        ((b)localObject).db.execSQL("NewTipsInfo", str1);
        ((b)localObject).doNotify(locala.field_tipId, 5, Integer.valueOf(locala.field_tipId));
      }
      ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).edit().putBoolean(str3, true).commit();
      break;
      if (locala.field_hadRead)
      {
        paramInt = 4;
        break label819;
      }
      if ((locala.field_disappearTime != 0L) && (l7 > locala.field_disappearTime))
      {
        paramInt = 3;
        break label819;
      }
      paramInt = i;
      if (locala.field_overdueTime == 0L) {
        break label819;
      }
      paramInt = i;
      if (locala.field_beginShowTime + locala.field_overdueTime > locala.field_disappearTime) {
        break label819;
      }
      paramInt = i;
      if (l7 <= locala.field_beginShowTime + locala.field_overdueTime) {
        break label819;
      }
      paramInt = 2;
      break label819;
      i = 0;
      break label836;
      localObject = "";
      break label854;
      str1 = "";
      break label872;
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.newtips.b.a parama)
  {
    AppMethodBeat.i(127212);
    if (parama == null)
    {
      ac.e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
      AppMethodBeat.o(127212);
      return false;
    }
    long l1 = bs.aNx();
    boolean bool2;
    if ((parama.field_overdueTime == 0L) && (parama.field_disappearTime == 0L))
    {
      bool2 = true;
      ac.i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", new Object[] { Long.valueOf(l1), Long.valueOf(parama.field_overdueTime), Long.valueOf(parama.field_disappearTime), Boolean.valueOf(bool2) });
      AppMethodBeat.o(127212);
      return bool2;
    }
    Long localLong = Long.valueOf(Math.min(parama.field_beginShowTime + parama.field_overdueTime, parama.field_disappearTime));
    if ((l1 >= parama.field_beginShowTime) && (l1 <= localLong.longValue())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (l1 <= localLong.longValue()) {
        break;
      }
      long l2 = bs.eWj();
      ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l2).commit();
      bool2 = bool1;
      break;
    }
  }
  
  public static boolean b(com.tencent.mm.plugin.newtips.b.a parama)
  {
    AppMethodBeat.i(127213);
    if (parama == null)
    {
      ac.e("MicroMsg.NewTipsManager", "check path, tipsInfo is null!!!");
      AppMethodBeat.o(127213);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.newtips.a.dkc().Kr(parama.field_tipId);
    if ((localObject != null) && (((com.tencent.mm.plugin.newtips.b.a)localObject).field_tipsShowInfo != null) && (parama.field_tipsShowInfo != null))
    {
      localObject = ((com.tencent.mm.plugin.newtips.b.a)localObject).field_tipsShowInfo.path;
      parama = parama.field_tipsShowInfo.path;
      if (((localObject == null) && (parama == null)) || ((localObject != null) && (((String)localObject).equals(parama))))
      {
        AppMethodBeat.o(127213);
        return true;
      }
      ac.i("MicroMsg.NewTipsManager", "path illegal, localPath:%s, newPath:%s", new Object[] { localObject, parama });
    }
    AppMethodBeat.o(127213);
    return false;
  }
  
  public static boolean c(com.tencent.mm.plugin.newtips.b.a parama)
  {
    AppMethodBeat.i(127214);
    if (parama == null)
    {
      ac.e("MicroMsg.NewTipsManager", "check version, tipsInfo is null!!!");
      AppMethodBeat.o(127214);
      return false;
    }
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dkc().Kr(parama.field_tipId);
    if ((locala != null) && ((parama.field_tipVersion > locala.field_tipVersion) || ((!parama.field_hadRead) && (parama.field_tipVersion == locala.field_tipVersion))))
    {
      AppMethodBeat.o(127214);
      return true;
    }
    AppMethodBeat.o(127214);
    return false;
  }
  
  protected static boolean d(com.tencent.mm.plugin.newtips.b.a parama)
  {
    AppMethodBeat.i(127215);
    if (parama == null)
    {
      ac.e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
      AppMethodBeat.o(127215);
      return false;
    }
    if ((parama.field_isExit) && (!parama.field_hadRead) && (a(parama)))
    {
      AppMethodBeat.o(127215);
      return true;
    }
    ac.i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", new Object[] { Boolean.valueOf(parama.field_isExit), Boolean.valueOf(parama.field_hadRead), Boolean.valueOf(a(parama)) });
    AppMethodBeat.o(127215);
    return false;
  }
  
  public static List<c> eo(List<c> paramList)
  {
    AppMethodBeat.i(127217);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(127217);
      return localArrayList;
    }
    Iterator localIterator = paramList.iterator();
    label229:
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      boolean bool;
      if (localc == null) {
        bool = false;
      }
      for (;;)
      {
        if (!bool) {
          break label229;
        }
        localArrayList.add(localc);
        break;
        int i = localc.field_tipId;
        f.dkg();
        h localh = f.Kl(i);
        i = localc.field_path;
        f.dkg();
        j localj = (j)f.vnj.get(Integer.valueOf(i));
        paramList = localj;
        if (localj == null)
        {
          paramList = null;
          ac.e("MicroMsg.NewTips.NewTipsFilterPool", "Invalid pathId:%s", new Object[] { Integer.valueOf(i) });
        }
        if ((localh == null) && (paramList == null)) {
          bool = true;
        } else if ((localh != null) && (paramList != null))
        {
          if ((localh.dki()) && (paramList.dki())) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else if (localh != null) {
          bool = localh.dki();
        } else {
          bool = paramList.dki();
        }
      }
    }
    AppMethodBeat.o(127217);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.e
 * JD-Core Version:    0.7.0.1
 */