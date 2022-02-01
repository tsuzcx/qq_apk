package com.tencent.mm.plugin.sns.ad.e;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;

public final class i
{
  public static String a(long paramLong, Object... paramVarArgs)
  {
    AppMethodBeat.i(94986);
    ah.dXy();
    paramVarArgs = new StringBuilder(l.u(paramVarArgs));
    a(paramLong, paramVarArgs);
    paramVarArgs = paramVarArgs.toString();
    AppMethodBeat.o(94986);
    return paramVarArgs;
  }
  
  public static void a(long paramLong, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(94987);
    Object localObject = ah.dXH().Ax(paramLong);
    if (localObject != null)
    {
      localObject = ((e)localObject).ebP();
      if (localObject != null)
      {
        com.tencent.mm.modelstat.p.a(((TimeLineObject)localObject).AiG, paramStringBuilder);
        AppMethodBeat.o(94987);
        return;
      }
      ae.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[] { Long.valueOf(paramLong) });
      paramStringBuilder.append(",,");
      AppMethodBeat.o(94987);
      return;
    }
    ae.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[] { Long.valueOf(paramLong) });
    paramStringBuilder.append(",,");
    AppMethodBeat.o(94987);
  }
  
  public static void a(String paramString, g paramg)
  {
    AppMethodBeat.i(94985);
    Object localObject = ah.dXE().aBq(paramString);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.p)localObject).ebP();
      if (localObject != null)
      {
        com.tencent.mm.modelstat.p.a(((TimeLineObject)localObject).AiG, paramg);
        AppMethodBeat.o(94985);
        return;
      }
      ae.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[] { paramString });
      AppMethodBeat.o(94985);
      return;
    }
    ae.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[] { paramString });
    AppMethodBeat.o(94985);
  }
  
  private static String ayV(String paramString)
  {
    AppMethodBeat.i(94989);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94989);
      return "";
    }
    paramString = Base64.decode(paramString, 0);
    djc localdjc = new djc();
    try
    {
      localdjc.parseFrom(paramString);
      paramString = com.tencent.mm.modelstat.p.a(localdjc.HQJ);
      AppMethodBeat.o(94989);
      return paramString;
    }
    catch (IOException paramString)
    {
      ae.e("SnsAdExtUtil", "", new Object[] { paramString });
      AppMethodBeat.o(94989);
    }
    return "";
  }
  
  public static String b(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(94988);
    if (paramTimeLineObject != null)
    {
      paramTimeLineObject = ayV(paramTimeLineObject.AiG);
      AppMethodBeat.o(94988);
      return paramTimeLineObject;
    }
    ae.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
    AppMethodBeat.o(94988);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.i
 * JD-Core Version:    0.7.0.1
 */