package com.tencent.mm.plugin.sns.ad.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;

public final class h
{
  public static String a(long paramLong, Object... paramVarArgs)
  {
    AppMethodBeat.i(94986);
    af.dHL();
    paramVarArgs = new StringBuilder(k.v(paramVarArgs));
    a(paramLong, paramVarArgs);
    paramVarArgs = paramVarArgs.toString();
    AppMethodBeat.o(94986);
    return paramVarArgs;
  }
  
  public static void a(long paramLong, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(94987);
    Object localObject = af.dHU().xB(paramLong);
    if (localObject != null)
    {
      localObject = ((e)localObject).dLV();
      if (localObject != null)
      {
        com.tencent.mm.modelstat.p.a(((TimeLineObject)localObject).yAj, paramStringBuilder);
        AppMethodBeat.o(94987);
        return;
      }
      ac.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[] { Long.valueOf(paramLong) });
      paramStringBuilder.append(",,");
      AppMethodBeat.o(94987);
      return;
    }
    ac.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[] { Long.valueOf(paramLong) });
    paramStringBuilder.append(",,");
    AppMethodBeat.o(94987);
  }
  
  public static void a(String paramString, com.tencent.mm.modelsns.f paramf)
  {
    AppMethodBeat.i(94985);
    Object localObject = af.dHR().auS(paramString);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.p)localObject).dLV();
      if (localObject != null)
      {
        com.tencent.mm.modelstat.p.a(((TimeLineObject)localObject).yAj, paramf);
        AppMethodBeat.o(94985);
        return;
      }
      ac.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[] { paramString });
      AppMethodBeat.o(94985);
      return;
    }
    ac.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[] { paramString });
    AppMethodBeat.o(94985);
  }
  
  private static String asE(String paramString)
  {
    AppMethodBeat.i(94989);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94989);
      return "";
    }
    paramString = Base64.decode(paramString, 0);
    dcu localdcu = new dcu();
    try
    {
      localdcu.parseFrom(paramString);
      paramString = com.tencent.mm.modelstat.p.a(localdcu.FMs);
      AppMethodBeat.o(94989);
      return paramString;
    }
    catch (IOException paramString)
    {
      ac.e("SnsAdExtUtil", "", new Object[] { paramString });
      AppMethodBeat.o(94989);
    }
    return "";
  }
  
  public static String b(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(94988);
    if (paramTimeLineObject != null)
    {
      paramTimeLineObject = asE(paramTimeLineObject.yAj);
      AppMethodBeat.o(94988);
      return paramTimeLineObject;
    }
    ac.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
    AppMethodBeat.o(94988);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.h
 * JD-Core Version:    0.7.0.1
 */