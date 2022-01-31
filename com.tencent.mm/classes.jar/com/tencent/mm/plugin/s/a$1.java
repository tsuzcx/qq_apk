package com.tencent.mm.plugin.s;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;

final class a$1
  implements com.tencent.mm.plugin.s.a.a
{
  a$1(a parama) {}
  
  public final f WD(String paramString)
  {
    AppMethodBeat.i(79114);
    if (!g.RG())
    {
      AppMethodBeat.o(79114);
      return null;
    }
    paramString = a.cac().als(paramString);
    AppMethodBeat.o(79114);
    return paramString;
  }
  
  public final f WE(String paramString)
  {
    AppMethodBeat.i(79115);
    a.cab();
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(79115);
      return null;
    }
    Object localObject1 = new LinkedList();
    ((List)localObject1).add(paramString);
    localObject1 = new com.tencent.mm.pluginsdk.model.app.aa((List)localObject1);
    Object localObject2 = new b.a();
    ((b.a)localObject2).fsX = new dn();
    ((b.a)localObject2).fsY = new do();
    ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject2).funcId = 452;
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    localObject2 = ((b.a)localObject2).ado();
    Object localObject3 = (dn)((b)localObject2).fsV.fta;
    byte[] arrayOfByte = ((com.tencent.mm.pluginsdk.model.app.aa)localObject1).dli();
    if (arrayOfByte != null) {
      ((dn)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((dn)localObject3).jKs = 7;
    localObject3 = x.c((b)localObject2);
    if (localObject3 == null)
    {
      ab.e("MicroMsg.AppInfoService", "getSync resp == null");
      AppMethodBeat.o(79115);
      return null;
    }
    ab.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((com.tencent.mm.ai.a.a)localObject3).errType), Integer.valueOf(((com.tencent.mm.ai.a.a)localObject3).errCode) });
    if ((((com.tencent.mm.ai.a.a)localObject3).errType != 0) || (((com.tencent.mm.ai.a.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(79115);
      return null;
    }
    ((com.tencent.mm.pluginsdk.model.app.aa)localObject1).bJ(com.tencent.mm.platformtools.aa.a(((do)((com.tencent.mm.ai.a.a)localObject3).fsN).wpD));
    ((com.tencent.mm.pluginsdk.model.app.aa)localObject1).onGYNetEnd(0, ((com.tencent.mm.ai.a.a)localObject3).errType, ((com.tencent.mm.ai.a.a)localObject3).errCode, ((com.tencent.mm.ai.a.a)localObject3).errMsg, (q)localObject2, new byte[0]);
    localObject1 = com.tencent.mm.plugin.s.a.a.a.caj();
    if (localObject1 == null)
    {
      ab.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
      AppMethodBeat.o(79115);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.s.a.a)localObject1).WD(paramString);
    AppMethodBeat.o(79115);
    return paramString;
  }
  
  public final void WF(String paramString)
  {
    AppMethodBeat.i(79120);
    a.cab().alr(paramString);
    AppMethodBeat.o(79120);
  }
  
  public final Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(79118);
    a.cac();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
      AppMethodBeat.o(79118);
      return null;
    }
    if (paramString.equals("wx7fa037cc7dfabad5"))
    {
      paramString = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130837792);
      AppMethodBeat.o(79118);
      return paramString;
    }
    paramString = i.en(paramString, paramInt);
    if (!com.tencent.mm.a.e.cN(paramString))
    {
      ab.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramString + ", iconType = " + paramInt);
      AppMethodBeat.o(79118);
      return null;
    }
    paramString = BackwardSupportUtil.b.k(paramString, paramFloat);
    AppMethodBeat.o(79118);
    return paramString;
  }
  
  public final void al(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(79125);
    a.cab().aH(paramLinkedList);
    AppMethodBeat.o(79125);
  }
  
  public final void cX(String paramString, int paramInt)
  {
    AppMethodBeat.i(79119);
    a.caa().el(paramString, paramInt);
    AppMethodBeat.o(79119);
  }
  
  public final Cursor cag()
  {
    AppMethodBeat.i(79116);
    Cursor localCursor = a.cac().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
    if (localCursor == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      AppMethodBeat.o(79116);
      return null;
    }
    AppMethodBeat.o(79116);
    return localCursor;
  }
  
  public final i cah()
  {
    AppMethodBeat.i(79124);
    i locali = a.cac();
    AppMethodBeat.o(79124);
    return locali;
  }
  
  public final Cursor cai()
  {
    AppMethodBeat.i(79127);
    Object localObject = a.cac();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("select * from AppInfo");
    localStringBuilder.append(" where ");
    localStringBuilder.append("serviceAppType > 0");
    localObject = ((i)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
    if (localObject == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
      AppMethodBeat.o(79127);
      return null;
    }
    ab.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    AppMethodBeat.o(79127);
    return localObject;
  }
  
  public final void e(f paramf)
  {
    AppMethodBeat.i(79121);
    i locali = a.cac();
    if ((paramf != null) && (paramf.field_status != 5))
    {
      paramf.field_status = 3;
      ab.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramf.field_packageName });
      locali.a(paramf, new String[0]);
    }
    AppMethodBeat.o(79121);
  }
  
  public final Cursor eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79126);
    Cursor localCursor = a.cac().eZ(paramInt1, paramInt2);
    AppMethodBeat.o(79126);
    return localCursor;
  }
  
  public final void f(f paramf)
  {
    AppMethodBeat.i(79122);
    i locali = a.cac();
    if ((paramf == null) || (paramf.field_status != 3))
    {
      AppMethodBeat.o(79122);
      return;
    }
    paramf.field_status = 4;
    locali.a(paramf, new String[0]);
    AppMethodBeat.o(79122);
  }
  
  public final void g(f paramf)
  {
    AppMethodBeat.i(79123);
    a.cac().a(paramf, new String[0]);
    AppMethodBeat.o(79123);
  }
  
  public final Cursor z(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(79117);
    i locali = a.cac();
    String str = "select * from AppInfo where ";
    int i = 0;
    while (i <= 0)
    {
      str = str + " status = " + paramArrayOfInt[0];
      i += 1;
    }
    paramArrayOfInt = locali.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
    if (paramArrayOfInt == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      AppMethodBeat.o(79117);
      return null;
    }
    AppMethodBeat.o(79117);
    return paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a.1
 * JD-Core Version:    0.7.0.1
 */