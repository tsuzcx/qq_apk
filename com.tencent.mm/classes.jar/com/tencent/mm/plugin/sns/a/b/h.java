package com.tencent.mm.plugin.sns.a.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;

public final class h
{
  public static String a(long paramLong, Object... paramVarArgs)
  {
    AppMethodBeat.i(94986);
    af.dto();
    paramVarArgs = new StringBuilder(k.t(paramVarArgs));
    a(paramLong, paramVarArgs);
    paramVarArgs = paramVarArgs.toString();
    AppMethodBeat.o(94986);
    return paramVarArgs;
  }
  
  public static void a(long paramLong, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(94987);
    Object localObject = af.dtx().sY(paramLong);
    if (localObject != null)
    {
      localObject = ((e)localObject).dxy();
      if (localObject != null)
      {
        com.tencent.mm.modelstat.p.a(((TimeLineObject)localObject).xns, paramStringBuilder);
        AppMethodBeat.o(94987);
        return;
      }
      ad.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[] { Long.valueOf(paramLong) });
      paramStringBuilder.append(",,");
      AppMethodBeat.o(94987);
      return;
    }
    ad.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[] { Long.valueOf(paramLong) });
    paramStringBuilder.append(",,");
    AppMethodBeat.o(94987);
  }
  
  public static void a(String paramString, com.tencent.mm.modelsns.f paramf)
  {
    AppMethodBeat.i(94985);
    Object localObject = af.dtu().apJ(paramString);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.p)localObject).dxy();
      if (localObject != null)
      {
        com.tencent.mm.modelstat.p.a(((TimeLineObject)localObject).xns, paramf);
        AppMethodBeat.o(94985);
        return;
      }
      ad.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[] { paramString });
      AppMethodBeat.o(94985);
      return;
    }
    ad.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[] { paramString });
    AppMethodBeat.o(94985);
  }
  
  private static String ant(String paramString)
  {
    AppMethodBeat.i(94989);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94989);
      return "";
    }
    paramString = Base64.decode(paramString, 0);
    cxi localcxi = new cxi();
    try
    {
      localcxi.parseFrom(paramString);
      paramString = com.tencent.mm.modelstat.p.a(localcxi.Ept);
      AppMethodBeat.o(94989);
      return paramString;
    }
    catch (IOException paramString)
    {
      ad.e("SnsAdExtUtil", "", new Object[] { paramString });
      AppMethodBeat.o(94989);
    }
    return "";
  }
  
  public static String b(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(94988);
    if (paramTimeLineObject != null)
    {
      paramTimeLineObject = ant(paramTimeLineObject.xns);
      AppMethodBeat.o(94988);
      return paramTimeLineObject;
    }
    ad.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
    AppMethodBeat.o(94988);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.h
 * JD-Core Version:    0.7.0.1
 */