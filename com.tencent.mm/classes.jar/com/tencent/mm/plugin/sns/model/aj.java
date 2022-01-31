package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.anz;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btw;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class aj
{
  private static Map<String, bto> ote = new ConcurrentHashMap();
  
  public static n ND(String paramString)
  {
    Cursor localCursor = af.bDF().b(paramString, 1, false, "");
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      paramString = null;
    }
    n localn;
    do
    {
      return paramString;
      localCursor.moveToFirst();
      localn = new n();
      localn.d(localCursor);
      paramString = localn;
    } while (localCursor.isClosed());
    localCursor.close();
    return localn;
  }
  
  public static boolean NE(String paramString)
  {
    return q.Gj().equals(paramString.trim());
  }
  
  public static String NF(String paramString)
  {
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = af.bDL().getCursor();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        t localt = new t();
        localt.d((Cursor)localObject);
        localLinkedList.add(bk.aM(localt.field_tagName, ""));
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    localObject = paramString;
    while (localLinkedList.contains(localObject))
    {
      localObject = paramString + i;
      i += 1;
    }
    return localObject;
  }
  
  public static List<com.tencent.mm.plugin.sns.g.b> NG(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (af.bDo()) {
      return localArrayList;
    }
    Object localObject = h.OB(paramString);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((n)localObject).bGe();
    if ((((bxk)localObject).tNr == null) || (((bxk)localObject).tNr.sPJ.size() == 0)) {
      return localArrayList;
    }
    localArrayList.clear();
    Iterator localIterator = ((bxk)localObject).tNr.sPJ.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      awd localawd = (awd)localIterator.next();
      com.tencent.mm.plugin.sns.g.b localb = new com.tencent.mm.plugin.sns.g.b();
      localb.bZK = localawd;
      localb.owP = paramString;
      localb.enw = ((bxk)localObject).mPL;
      localb.owQ = i;
      localArrayList.add(localb);
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean U(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (paramInt > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static long a(n paramn, bto parambto, String paramString, int paramInt)
  {
    int i = 1;
    n localn = paramn;
    if (paramn == null) {
      localn = new n();
    }
    if (!af.bDE().gc(localn.field_snsId)) {
      return parambto.sGd;
    }
    if (parambto.tKf != 0)
    {
      y.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + parambto.sGd + "  " + i.fN(parambto.sGd));
      if (localn.yr(paramInt)) {
        break label728;
      }
      localn.yp(paramInt);
    }
    label728:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        af.bDF().a(parambto.sGd, localn);
      }
      return parambto.sGd;
      paramn = parambto.tKb;
      y.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(parambto.sGd), Integer.valueOf(paramn.size()), i.fN(parambto.sGd) });
      if ((parambto.tJU == null) || (parambto.tJU.tFM == null))
      {
        y.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        return parambto.sGd;
      }
      paramn = new String(parambto.tJU.tFM.toByteArray());
      y.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[] { Long.valueOf(parambto.sGd) });
      if (bk.bl(paramn)) {
        return parambto.sGd;
      }
      if (!localn.Oz(paramn)) {
        return parambto.sGd;
      }
      parambto.tKl = b(parambto.tKl, localn.field_attrBuf);
      y.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(parambto.sGd) });
      parambto.tJU.bs(new byte[0]);
      localn.field_userName = parambto.sxM;
      localn.iB(parambto.mPL);
      localn.field_likeFlag = parambto.tJV;
      localn.gp(parambto.sGd);
      localn.gr(parambto.sGd);
      localn.yp(paramInt);
      try
      {
        l = bk.UZ();
      }
      catch (Exception paramn)
      {
        label489:
        int j;
        for (;;)
        {
          long l;
          y.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramn, "", new Object[0]);
          continue;
          i = 0;
          continue;
          localn.bGC();
        }
        if ((j != 1) && ((paramString.equals(parambto.sxM)) || (paramInt != 4))) {
          continue;
        }
        localn.bGy();
        localn.c(paramn);
        localn.field_type = paramn.tNr.sPI;
        localn.field_subType = paramn.tNr.sPK;
        af.bDF().a(parambto.sGd, localn);
        return parambto.sGd;
      }
      try
      {
        if (localn.field_type == 15)
        {
          paramn = (bto)new bto().aH(localn.field_attrBuf);
          if ((paramn != null) && (paramn.tKn != null) && (paramn.tKn.tzV > 0))
          {
            parambto.tKn = paramn.tKn;
            y.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(parambto.tKn.tzV), Integer.valueOf(parambto.tKn.tzW), parambto.tKn.tzX, Long.valueOf(bk.cp(l)) });
          }
        }
      }
      catch (Exception paramn)
      {
        y.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[] { paramn.toString() });
        break label489;
      }
      localn.aL(parambto.toByteArray());
      paramn = localn.bGe();
      paramn.hPY = parambto.sxM;
      j = paramn.trR;
      localn.field_pravited = j;
      y.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[] { Long.valueOf(parambto.sGd), Integer.valueOf(parambto.ttI) });
      if ((parambto.ttI & 0x1) > 0)
      {
        i = 1;
        if (i == 0) {
          continue;
        }
        localn.bGB();
        if ((j != 1) || (paramInt == 4)) {
          continue;
        }
        y.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        return 0L;
      }
    }
  }
  
  public static awd a(n paramn, int paramInt)
  {
    if (af.bDo()) {}
    do
    {
      do
      {
        return null;
      } while (paramn == null);
      paramn = paramn.bGe();
    } while ((paramn.tNr == null) || (paramn.tNr.sPJ.size() == 0) || (paramn.tNr.sPJ.size() <= paramInt));
    return (awd)paramn.tNr.sPJ.get(paramInt);
  }
  
  public static awd a(n paramn, String paramString)
  {
    paramn = paramn.bGe();
    if ((paramn.tNr == null) || (paramn.tNr.sPJ.size() == 0)) {
      return null;
    }
    paramn = paramn.tNr.sPJ.iterator();
    while (paramn.hasNext())
    {
      awd localawd = (awd)paramn.next();
      if (localawd.lsK.equals(paramString)) {
        return localawd;
      }
    }
    return null;
  }
  
  public static List<n> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (paramString1 = af.bDF().b(paramString1, 10, paramBoolean1, paramString2);; paramString1 = af.bDF().b(paramString1, 0, paramBoolean1, paramString2))
    {
      paramString2 = new ArrayList();
      if (paramString1.getCount() != 0) {
        break;
      }
      paramString1.close();
      return paramString2;
    }
    if (paramString1.moveToFirst()) {
      do
      {
        n localn = new n();
        localn.d(paramString1);
        paramString2.add(localn);
      } while (paramString1.moveToNext());
    }
    paramString1.close();
    return paramString2;
  }
  
  public static void a(String paramString1, int paramInt, LinkedList<bto> paramLinkedList, String paramString2)
  {
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
      return;
    }
    Object localObject3 = af.bDF();
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    Object localObject2;
    while (i < paramLinkedList.size())
    {
      bto localbto = (bto)paramLinkedList.get(i);
      localObject2 = ((o)localObject3).gt(localbto.sGd);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new n();
      }
      if (a((n)localObject1, localbto, paramString1, paramInt) != 0L)
      {
        if ((localLinkedList.size() < 3) && ((((n)localObject1).field_type == 1) || (((n)localObject1).field_type == 15))) {
          localLinkedList.add(i.fN(((n)localObject1).field_snsId));
        }
        localArrayList.add(Long.valueOf(localbto.sGd));
      }
      i += 1;
    }
    if (((paramInt == 4) || (paramInt == 8)) && (paramString2.equals("")))
    {
      localObject1 = af.bDJ().OF(paramString1);
      if (localObject1 != null)
      {
        localObject1 = ((l)localObject1).field_newerIds;
        localObject1 = bk.G(bk.aM((String)localObject1, "").split(","));
        y.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + cv(localLinkedList));
        label258:
        do
        {
          if ((localLinkedList.size() >= 3) || (((List)localObject1).size() <= 0)) {
            break;
          }
          localObject2 = (String)((List)localObject1).remove(0);
        } while (localObject2 == null);
        i = 0;
      }
      for (;;)
      {
        if (i < localLinkedList.size())
        {
          localObject3 = (String)localLinkedList.get(i);
          if (((String)localObject2).compareTo((String)localObject3) != 0)
          {
            if (((String)localObject2).compareTo((String)localObject3) <= 0) {
              break label388;
            }
            localLinkedList.add(0, localObject2);
          }
        }
        if (localLinkedList.contains(localObject2)) {
          break label258;
        }
        localLinkedList.add(localObject2);
        break label258;
        localObject1 = "";
        break;
        label388:
        i += 1;
      }
      y.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + cv(localLinkedList));
      af.bDJ().eX(paramString1, cv(localLinkedList));
    }
    Object localObject1 = i.Nb(i.fN(((bto)paramLinkedList.getLast()).sGd));
    y.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString2 + "  -  " + (String)localObject1);
    if (paramInt == 2)
    {
      localObject2 = af.bDF();
      paramLinkedList = o.bGU();
      if (paramString2 != null)
      {
        paramString1 = paramLinkedList;
        if (paramString2.equals("")) {}
      }
      else
      {
        paramString1 = paramLinkedList + " AND " + ((o)localObject2).ON(paramString2);
      }
      paramLinkedList = paramString1;
      if (o.OJ((String)localObject1)) {
        paramLinkedList = paramString1 + " AND " + ((o)localObject2).OK((String)localObject1);
      }
      y.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + paramLinkedList);
      paramString1 = ((o)localObject2).dXw.rawQuery(paramLinkedList, null);
      label623:
      if (paramString1 != null)
      {
        if (paramString1.moveToFirst()) {
          break label788;
        }
        paramString1.close();
      }
    }
    else
    {
      localObject2 = af.bDF();
      if (paramInt != 4) {
        break label782;
      }
    }
    label782:
    for (boolean bool = true;; bool = false)
    {
      paramLinkedList = o.be(paramString1, bool);
      paramString1 = paramLinkedList;
      if (o.OJ(paramString2)) {
        paramString1 = paramLinkedList + " AND " + ((o)localObject2).ON(paramString2);
      }
      paramLinkedList = paramString1;
      if (o.OJ((String)localObject1)) {
        paramLinkedList = paramString1 + " AND " + ((o)localObject2).OK((String)localObject1);
      }
      y.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + paramLinkedList);
      paramString1 = ((o)localObject2).dXw.rawQuery(paramLinkedList, null);
      break label623;
      break;
    }
    for (;;)
    {
      label788:
      paramLinkedList = new n();
      paramLinkedList.d(paramString1);
      long l = paramLinkedList.field_snsId;
      if (paramLinkedList.bGF()) {
        y.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
      }
      while (!paramString1.moveToNext())
      {
        paramString1.close();
        return;
        if (paramLinkedList.bGG())
        {
          y.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!localArrayList.contains(Long.valueOf(l)))
        {
          paramLinkedList.ys(paramInt);
          af.bDF().b(l, paramLinkedList);
          y.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt);
        }
      }
    }
  }
  
  public static boolean a(long paramLong, bsy parambsy)
  {
    bsx localbsx = parambsy.tJB;
    if ((localbsx.hQR != 1) && (localbsx.hQR != 2)) {
      return true;
    }
    n localn = af.bDF().gt(paramLong);
    if (localn == null) {
      return true;
    }
    if ((localn.field_type == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.bCv()))
    {
      y.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
      return false;
    }
    try
    {
      bto localbto = (bto)new bto().aH(localn.field_attrBuf);
      localbto.sGd = paramLong;
      Iterator localIterator;
      btd localbtd;
      if (localbsx.hQR == 1)
      {
        localIterator = localbto.tJY.iterator();
        while (localIterator.hasNext())
        {
          localbtd = (btd)localIterator.next();
          if ((localbtd.mPL == localbsx.mPL) && (localbtd.sxM.equals(localbsx.tAY))) {
            return true;
          }
        }
        localbto.tJY.add(ad.b(parambsy));
      }
      for (;;)
      {
        localn.aL(localbto.toByteArray());
        af.bDF().a(localbto.sGd, localn);
        break;
        if (localbsx.hQR == 2)
        {
          localIterator = localbto.tKb.iterator();
          while (localIterator.hasNext())
          {
            localbtd = (btd)localIterator.next();
            if ((localbtd.mPL == localbsx.mPL) && (localbtd.sxM.equals(localbsx.tAY))) {
              return true;
            }
          }
          localbto.tKb.add(ad.b(parambsy));
        }
      }
      return true;
    }
    catch (Exception parambsy)
    {
      y.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", parambsy, "", new Object[0]);
    }
  }
  
  public static bmk b(bmk parambmk, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    bmk localbmk;
    do
    {
      try
      {
        localbmk = ((bto)new bto().aH(paramArrayOfByte)).tKl;
      }
      catch (Exception parambmk)
      {
        btw localbtw;
        y.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", parambmk, "", new Object[0]);
        return null;
      }
      localbtw = new btw();
      paramArrayOfByte = localbtw;
      if (localbmk != null) {
        paramArrayOfByte = (btw)localbtw.aH(localbmk.tFM.oY);
      }
      parambmk = (btw)new btw().aH(parambmk.tFM.oY);
      if (parambmk.tKA == null) {
        parambmk.tKA = paramArrayOfByte.tKA;
      }
      if (paramArrayOfByte.tKz == null) {
        parambmk.tKz = null;
      }
      for (;;)
      {
        parambmk = parambmk.toByteArray();
        return new bmk().bs(parambmk);
        if (parambmk.tKz == null)
        {
          parambmk.tKz = paramArrayOfByte.tKz;
          continue;
          localbmk = null;
        }
      }
    } while (parambmk != null);
    return localbmk;
  }
  
  public static void b(long paramLong, bsy parambsy)
  {
    parambsy = parambsy.tJB;
    if (parambsy.hQR != 9) {}
    n localn;
    do
    {
      return;
      localn = af.bDF().gt(paramLong);
    } while (localn == null);
    try
    {
      bto localbto = (bto)new bto().aH(localn.field_attrBuf);
      localbto.sGd = paramLong;
      Iterator localIterator = localbto.tKb.iterator();
      while (localIterator.hasNext())
      {
        btd localbtd = (btd)localIterator.next();
        if ((localbtd.tJu == parambsy.tJu) && (!bk.bl(localbtd.sxM)) && (localbtd.sxM.equals(parambsy.tAY))) {
          localbto.tKb.remove(localbtd);
        }
      }
      localn.aL(localbto.toByteArray());
      af.bDF().a(localbto.sGd, localn);
      return;
    }
    catch (Exception parambsy)
    {
      y.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", parambsy, "", new Object[0]);
    }
  }
  
  public static void bDX()
  {
    if (ote != null) {
      ote.clear();
    }
  }
  
  public static List<n> bDY()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = af.bDF();
    Object localObject2 = o.bGV() + " AND " + o.oLG + " AND  (snsId = 0  ) ";
    localObject1 = ((o)localObject1).dXw.rawQuery((String)localObject2, null);
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      return localArrayList;
    }
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject2 = new n();
      ((n)localObject2).d((Cursor)localObject1);
      localArrayList.add(localObject2);
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    return localArrayList;
  }
  
  public static void bDZ()
  {
    Cursor localCursor = af.bDF().cv("", 0);
    if (localCursor != null)
    {
      y.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
      while (localCursor.moveToNext())
      {
        n localn = new n();
        localn.d(localCursor);
        y.i("MicroMsg.SnsInfoStorageLogic", localn.bGk());
      }
      y.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
      localCursor.close();
    }
  }
  
  public static void c(long paramLong, bsy parambsy)
  {
    parambsy = parambsy.tJB;
    if (parambsy.hQR != 13) {}
    n localn;
    do
    {
      return;
      localn = af.bDF().gt(paramLong);
    } while (localn == null);
    try
    {
      bto localbto = (bto)new bto().aH(localn.field_attrBuf);
      localbto.sGd = paramLong;
      if (localbto.tKm == null) {
        localbto.tKm = new bud();
      }
      if (parambsy.hQR == 13)
      {
        Object localObject = localbto.tKm.tKP.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((btk)((Iterator)localObject).next()).sxM.equals(parambsy.tAY)) {
            return;
          }
        }
        localObject = new btk();
        ((btk)localObject).tJy = parambsy.tJy;
        ((btk)localObject).mPL = parambsy.mPL;
        ((btk)localObject).sxM = parambsy.tAY;
        localbto.tKm.tKP.add(localObject);
        localbto.tKm.tKO = localbto.tKm.tKP.size();
      }
      localn.aL(localbto.toByteArray());
      af.bDF().a(localbto.sGd, localn);
      return;
    }
    catch (Exception parambsy)
    {
      y.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + parambsy.getMessage());
      y.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", parambsy, "", new Object[0]);
    }
  }
  
  private static String cv(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = "";
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramList.length() == 0) {
        paramList = str;
      } else {
        paramList = paramList + "," + str;
      }
    }
    return paramList;
  }
  
  public static List<com.tencent.mm.plugin.sns.g.b> cw(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    localArrayList.clear();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      com.tencent.mm.plugin.sns.g.b localb = new com.tencent.mm.plugin.sns.g.b();
      awd localawd = new awd();
      localawd.lsK = ("pre_temp_extend_pic" + str);
      localb.bZK = localawd;
      localb.owP = "";
      localb.owQ = i;
      localArrayList.add(localb);
      i += 1;
    }
    return localArrayList;
  }
  
  public static long d(bto parambto)
  {
    n localn2 = af.bDF().gt(parambto.sGd);
    n localn1 = localn2;
    if (localn2 == null) {
      localn1 = new n();
    }
    return a(localn1, parambto, "", 0);
  }
  
  public static List<com.tencent.mm.plugin.sns.g.b> eI(String paramString1, String paramString2)
  {
    int i = 0;
    localArrayList = new ArrayList();
    Object localObject1 = null;
    try
    {
      Object localObject2 = paramString2 + paramString1 + "_ARTISTF.mm";
      Object localObject3 = paramString2 + paramString1 + "_ARTIST.mm";
      paramString1 = (String)localObject1;
      if (com.tencent.mm.vfs.e.bK((String)localObject2))
      {
        paramString1 = com.tencent.mm.vfs.e.c((String)localObject2, 0, (int)com.tencent.mm.vfs.e.aeQ((String)localObject2));
        paramString1 = (cq)new cq().aH(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        com.tencent.mm.vfs.e.deleteFile((String)localObject2);
        paramString2 = a.Oi(new String(com.tencent.mm.vfs.e.c((String)localObject3, 0, (int)com.tencent.mm.vfs.e.aeQ((String)localObject3))));
        com.tencent.mm.vfs.e.b((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.swl.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (anz)paramString1.next();
        paramString2 = ((anz)localObject1).kRZ;
        localObject1 = ((anz)localObject1).sPJ.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (awd)((Iterator)localObject1).next();
          ((awd)localObject2).kRN = paramString2;
          localObject3 = new com.tencent.mm.plugin.sns.g.b();
          ((com.tencent.mm.plugin.sns.g.b)localObject3).bZK = ((awd)localObject2);
          ((com.tencent.mm.plugin.sns.g.b)localObject3).owP = "";
          ((com.tencent.mm.plugin.sns.g.b)localObject3).owQ = j;
          localArrayList.add(localObject3);
          j += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
    }
  }
  
  public static bto p(n paramn)
  {
    try
    {
      paramn = (bto)new bto().aH(paramn.field_attrBuf);
      paramn = af.bDE().c(paramn);
      ote.clear();
      return paramn;
    }
    catch (Exception paramn)
    {
      y.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      y.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramn, "", new Object[0]);
    }
    return new bto();
  }
  
  public static bto q(n paramn)
  {
    try
    {
      if (paramn.oLj == null) {
        paramn.oLj = (com.tencent.mm.a.g.o(paramn.field_content) + com.tencent.mm.a.g.o(paramn.field_attrBuf));
      }
      if (ote.containsKey(paramn.oLj))
      {
        localbto = (bto)ote.get(paramn.oLj);
        if (localbto != null)
        {
          af.bDE().c(localbto);
          return localbto;
        }
      }
      bto localbto = (bto)new bto().aH(paramn.field_attrBuf);
      ote.put(paramn.oLj, localbto);
      af.bDE().c(localbto);
      return localbto;
    }
    catch (Exception paramn)
    {
      y.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      y.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramn, "", new Object[0]);
    }
    return new bto();
  }
  
  /* Error */
  public static boolean xN(int paramInt)
  {
    // Byte code:
    //   0: ldc 228
    //   2: new 115	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 777
    //   9: invokespecial 233	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_0
    //   13: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 492	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: invokestatic 25	com/tencent/mm/plugin/sns/model/af:bDF	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   25: iload_0
    //   26: invokevirtual 781	com/tencent/mm/plugin/sns/storage/o:yt	(I)Lcom/tencent/mm/plugin/sns/storage/n;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnonnull +5 -> 38
    //   36: iconst_0
    //   37: ireturn
    //   38: aload 6
    //   40: invokevirtual 784	com/tencent/mm/plugin/sns/storage/n:bGH	()V
    //   43: aload 6
    //   45: invokestatic 789	java/lang/System:currentTimeMillis	()J
    //   48: ldc2_w 790
    //   51: ldiv
    //   52: l2i
    //   53: invokevirtual 337	com/tencent/mm/plugin/sns/storage/n:iB	(I)V
    //   56: aconst_null
    //   57: astore 5
    //   59: new 793	com/tencent/mm/protocal/c/awe
    //   62: dup
    //   63: invokespecial 794	com/tencent/mm/protocal/c/awe:<init>	()V
    //   66: aload 6
    //   68: getfield 797	com/tencent/mm/plugin/sns/storage/n:field_postBuf	[B
    //   71: invokevirtual 798	com/tencent/mm/protocal/c/awe:aH	([B)Lcom/tencent/mm/bv/a;
    //   74: checkcast 793	com/tencent/mm/protocal/c/awe
    //   77: astore_3
    //   78: aload_3
    //   79: iconst_0
    //   80: putfield 801	com/tencent/mm/protocal/c/awe:ebp	I
    //   83: aload_3
    //   84: invokestatic 789	java/lang/System:currentTimeMillis	()J
    //   87: putfield 804	com/tencent/mm/protocal/c/awe:tsq	J
    //   90: aload 6
    //   92: aload_3
    //   93: invokevirtual 805	com/tencent/mm/protocal/c/awe:toByteArray	()[B
    //   96: putfield 797	com/tencent/mm/plugin/sns/storage/n:field_postBuf	[B
    //   99: aload_3
    //   100: ifnull -64 -> 36
    //   103: invokestatic 25	com/tencent/mm/plugin/sns/model/af:bDF	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   106: iload_0
    //   107: aload 6
    //   109: invokevirtual 808	com/tencent/mm/plugin/sns/storage/o:b	(ILcom/tencent/mm/plugin/sns/storage/n;)I
    //   112: pop
    //   113: iconst_0
    //   114: istore_0
    //   115: iload_0
    //   116: aload_3
    //   117: getfield 811	com/tencent/mm/protocal/c/awe:tsn	Ljava/util/LinkedList;
    //   120: invokevirtual 158	java/util/LinkedList:size	()I
    //   123: if_icmpge +144 -> 267
    //   126: aload_3
    //   127: getfield 811	com/tencent/mm/protocal/c/awe:tsn	Ljava/util/LinkedList;
    //   130: iload_0
    //   131: invokevirtual 442	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   134: checkcast 813	com/tencent/mm/protocal/c/auf
    //   137: getfield 816	com/tencent/mm/protocal/c/auf:tpH	I
    //   140: istore_1
    //   141: invokestatic 820	com/tencent/mm/plugin/sns/model/af:bDu	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   144: iload_1
    //   145: i2l
    //   146: invokevirtual 826	com/tencent/mm/plugin/sns/storage/s:gu	(J)Lcom/tencent/mm/plugin/sns/storage/r;
    //   149: astore 4
    //   151: aload 4
    //   153: ifnull +39 -> 192
    //   156: aload 4
    //   158: iconst_0
    //   159: putfield 831	com/tencent/mm/plugin/sns/storage/r:offset	I
    //   162: new 833	com/tencent/mm/protocal/c/awg
    //   165: dup
    //   166: invokespecial 834	com/tencent/mm/protocal/c/awg:<init>	()V
    //   169: aload 4
    //   171: getfield 837	com/tencent/mm/plugin/sns/storage/r:oLV	[B
    //   174: invokevirtual 838	com/tencent/mm/protocal/c/awg:aH	([B)Lcom/tencent/mm/bv/a;
    //   177: checkcast 833	com/tencent/mm/protocal/c/awg
    //   180: astore 5
    //   182: aload 5
    //   184: getfield 841	com/tencent/mm/protocal/c/awg:tsL	I
    //   187: istore_2
    //   188: iload_2
    //   189: ifne +31 -> 220
    //   192: iload_0
    //   193: iconst_1
    //   194: iadd
    //   195: istore_0
    //   196: goto -81 -> 115
    //   199: astore 4
    //   201: aload 5
    //   203: astore_3
    //   204: ldc 228
    //   206: aload 4
    //   208: ldc 27
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 418	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: goto -118 -> 99
    //   220: aload 5
    //   222: iconst_2
    //   223: putfield 841	com/tencent/mm/protocal/c/awg:tsL	I
    //   226: aload 5
    //   228: ldc 27
    //   230: putfield 844	com/tencent/mm/protocal/c/awg:tsM	Ljava/lang/String;
    //   233: aload 4
    //   235: aload 5
    //   237: invokevirtual 845	com/tencent/mm/protocal/c/awg:toByteArray	()[B
    //   240: putfield 837	com/tencent/mm/plugin/sns/storage/r:oLV	[B
    //   243: invokestatic 820	com/tencent/mm/plugin/sns/model/af:bDu	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   246: iload_1
    //   247: aload 4
    //   249: invokevirtual 848	com/tencent/mm/plugin/sns/storage/s:a	(ILcom/tencent/mm/plugin/sns/storage/r;)I
    //   252: pop
    //   253: goto -61 -> 192
    //   256: astore_3
    //   257: ldc 228
    //   259: ldc_w 850
    //   262: invokestatic 409	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: iconst_0
    //   266: ireturn
    //   267: iconst_1
    //   268: ireturn
    //   269: astore 4
    //   271: goto -67 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramInt	int
    //   140	107	1	i	int
    //   187	2	2	j	int
    //   77	127	3	localObject	Object
    //   256	1	3	localException1	Exception
    //   149	21	4	localr	com.tencent.mm.plugin.sns.storage.r
    //   199	49	4	localException2	Exception
    //   269	1	4	localException3	Exception
    //   57	179	5	localawg	com.tencent.mm.protocal.c.awg
    //   29	79	6	localn	n
    // Exception table:
    //   from	to	target	type
    //   59	78	199	java/lang/Exception
    //   162	188	256	java/lang/Exception
    //   220	243	256	java/lang/Exception
    //   78	99	269	java/lang/Exception
  }
  
  public static n xO(int paramInt)
  {
    n localn = new n();
    Object localObject1 = af.bDF();
    Object localObject2 = o.bGW();
    localObject2 = (String)localObject2 + " and createTime < " + paramInt;
    localObject2 = (String)localObject2 + o.oLA;
    localObject2 = (String)localObject2 + " LIMIT 1";
    y.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[] { localObject2 });
    localObject2 = ((o)localObject1).dXw.rawQuery((String)localObject2, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return null;
    }
    if (((Cursor)localObject1).moveToFirst())
    {
      localn.d((Cursor)localObject1);
      ((Cursor)localObject1).close();
      return localn;
    }
    ((Cursor)localObject1).close();
    return null;
  }
  
  public static void xP(int paramInt)
  {
    y.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　" + paramInt);
    n localn = af.bDF().yt(paramInt);
    if (localn == null) {
      return;
    }
    if ((localn.field_localFlag & 0x40) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localn.field_localFlag &= 0xFFFFFFBF;
      }
      af.bDF().b(paramInt, localn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj
 * JD-Core Version:    0.7.0.1
 */