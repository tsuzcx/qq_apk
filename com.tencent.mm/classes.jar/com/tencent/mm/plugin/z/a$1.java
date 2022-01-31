package com.tencent.mm.plugin.z;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.x;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.dd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

final class a$1
  implements com.tencent.mm.plugin.z.a.a
{
  a$1(a parama) {}
  
  public final f KC(String paramString)
  {
    return a.brn().VU(paramString);
  }
  
  public final f KD(String paramString)
  {
    a.brm();
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject1 = new LinkedList();
    ((List)localObject1).add(paramString);
    localObject1 = new com.tencent.mm.pluginsdk.model.app.ae((List)localObject1);
    Object localObject2 = new b.a();
    ((b.a)localObject2).ecH = new dc();
    ((b.a)localObject2).ecI = new dd();
    ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject2).ecG = 452;
    ((b.a)localObject2).ecJ = 0;
    ((b.a)localObject2).ecK = 0;
    localObject2 = ((b.a)localObject2).Kt();
    Object localObject3 = (dc)((b)localObject2).ecE.ecN;
    byte[] arrayOfByte = ((com.tencent.mm.pluginsdk.model.app.ae)localObject1).ckB();
    if (arrayOfByte != null) {
      ((dc)localObject3).swr = new bmk().bs(arrayOfByte);
    }
    ((dc)localObject3).hQR = 7;
    localObject3 = x.c((b)localObject2);
    y.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((com.tencent.mm.ah.a.a)localObject3).errType), Integer.valueOf(((com.tencent.mm.ah.a.a)localObject3).errCode) });
    if ((((com.tencent.mm.ah.a.a)localObject3).errType != 0) || (((com.tencent.mm.ah.a.a)localObject3).errCode != 0)) {
      return null;
    }
    ((com.tencent.mm.pluginsdk.model.app.ae)localObject1).bi(aa.a(((dd)((com.tencent.mm.ah.a.a)localObject3).ecw).sws));
    ((com.tencent.mm.pluginsdk.model.app.ae)localObject1).a(0, ((com.tencent.mm.ah.a.a)localObject3).errType, ((com.tencent.mm.ah.a.a)localObject3).errCode, ((com.tencent.mm.ah.a.a)localObject3).aox, (q)localObject2, new byte[0]);
    localObject1 = com.tencent.mm.plugin.z.a.a.a.bru();
    if (localObject1 == null)
    {
      y.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
      return null;
    }
    return ((com.tencent.mm.plugin.z.a.a)localObject1).KC(paramString);
  }
  
  public final void KE(String paramString)
  {
    a.brm().VS(paramString);
  }
  
  public final Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    a.brn();
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
      return null;
    }
    if (paramString.equals("wx7fa037cc7dfabad5")) {
      return BitmapFactory.decodeResource(com.tencent.mm.sdk.platformtools.ae.getContext().getResources(), a.d.app_icon);
    }
    paramString = i.di(paramString, paramInt);
    if (!com.tencent.mm.a.e.bK(paramString))
    {
      y.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramString + ", iconType = " + paramInt);
      return null;
    }
    return BackwardSupportUtil.b.e(paramString, paramFloat);
  }
  
  public final void ad(LinkedList<String> paramLinkedList)
  {
    a.brm().ax(paramLinkedList);
  }
  
  public final Cursor brr()
  {
    Cursor localCursor2 = a.brn().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
    Cursor localCursor1 = localCursor2;
    if (localCursor2 == null)
    {
      y.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      localCursor1 = null;
    }
    return localCursor1;
  }
  
  public final i brs()
  {
    return a.brn();
  }
  
  public final Cursor brt()
  {
    Object localObject = a.brn();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("select * from AppInfo");
    localStringBuilder.append(" where ");
    localStringBuilder.append("serviceAppType > 0");
    localObject = ((i)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
    if (localObject == null)
    {
      y.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
      return null;
    }
    y.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    return localObject;
  }
  
  public final void c(f paramf)
  {
    i locali = a.brn();
    if ((paramf != null) && (paramf.field_status != 5))
    {
      paramf.field_status = 3;
      y.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramf.field_packageName });
      locali.a(paramf, new String[0]);
    }
  }
  
  public final void cf(String paramString, int paramInt)
  {
    a.brl().dg(paramString, paramInt);
  }
  
  public final void d(f paramf)
  {
    i locali = a.brn();
    if ((paramf == null) || (paramf.field_status != 3)) {
      return;
    }
    paramf.field_status = 4;
    locali.a(paramf, new String[0]);
  }
  
  public final Cursor dz(int paramInt1, int paramInt2)
  {
    return a.brn().dz(paramInt1, paramInt2);
  }
  
  public final void e(f paramf)
  {
    a.brn().a(paramf, new String[0]);
  }
  
  public final Cursor p(int[] paramArrayOfInt)
  {
    i locali = a.brn();
    Object localObject = "select * from AppInfo where ";
    int i = 0;
    while (i <= 0)
    {
      localObject = (String)localObject + " status = " + paramArrayOfInt[0];
      i += 1;
    }
    localObject = locali.rawQuery((String)localObject + " order by status desc, modifyTime asc", new String[0]);
    paramArrayOfInt = (int[])localObject;
    if (localObject == null)
    {
      y.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      paramArrayOfInt = null;
    }
    return paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.z.a.1
 * JD-Core Version:    0.7.0.1
 */