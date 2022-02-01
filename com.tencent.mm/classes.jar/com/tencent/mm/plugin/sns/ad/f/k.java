package com.tencent.mm.plugin.sns.ad.f;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class k
{
  public static String a(long paramLong, Object... paramVarArgs)
  {
    AppMethodBeat.i(94986);
    aj.fOC();
    paramVarArgs = new StringBuilder(n.u(paramVarArgs));
    a(paramLong, paramVarArgs);
    paramVarArgs = paramVarArgs.toString();
    AppMethodBeat.o(94986);
    return paramVarArgs;
  }
  
  public static void a(long paramLong, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(94987);
    Object localObject = aj.fOL().QX(paramLong);
    if (localObject != null)
    {
      localObject = ((AdSnsInfo)localObject).getTimeLine();
      if (localObject != null)
      {
        o.a(((TimeLineObject)localObject).statExtStr, paramStringBuilder);
        AppMethodBeat.o(94987);
        return;
      }
      Log.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[] { Long.valueOf(paramLong) });
      paramStringBuilder.append(",,");
      AppMethodBeat.o(94987);
      return;
    }
    Log.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[] { Long.valueOf(paramLong) });
    paramStringBuilder.append(",,");
    AppMethodBeat.o(94987);
  }
  
  public static void a(String paramString, com.tencent.mm.modelsns.n paramn)
  {
    AppMethodBeat.i(94985);
    Object localObject = aj.fOI().bbk(paramString);
    if (localObject != null)
    {
      localObject = ((SnsInfo)localObject).getTimeLine();
      if (localObject != null)
      {
        o.a(((TimeLineObject)localObject).statExtStr, paramn);
        AppMethodBeat.o(94985);
        return;
      }
      Log.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[] { paramString });
      AppMethodBeat.o(94985);
      return;
    }
    Log.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[] { paramString });
    AppMethodBeat.o(94985);
  }
  
  private static String aYA(String paramString)
  {
    AppMethodBeat.i(94989);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94989);
      return "";
    }
    paramString = Base64.decode(paramString, 0);
    emp localemp = new emp();
    try
    {
      localemp.parseFrom(paramString);
      paramString = o.a(localemp.Upe);
      AppMethodBeat.o(94989);
      return paramString;
    }
    catch (IOException paramString)
    {
      Log.e("SnsAdExtUtil", "", new Object[] { paramString });
      AppMethodBeat.o(94989);
    }
    return "";
  }
  
  public static String b(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(94988);
    if (paramTimeLineObject != null)
    {
      paramTimeLineObject = aYA(paramTimeLineObject.statExtStr);
      AppMethodBeat.o(94988);
      return paramTimeLineObject;
    }
    Log.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
    AppMethodBeat.o(94988);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.k
 * JD-Core Version:    0.7.0.1
 */