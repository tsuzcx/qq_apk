package com.tencent.mm.plugin.sns.a.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class f
{
  private static String Zt(String paramString)
  {
    AppMethodBeat.i(35715);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(35715);
      return "";
    }
    paramString = Base64.decode(paramString, 0);
    cgh localcgh = new cgh();
    try
    {
      localcgh.parseFrom(paramString);
      paramString = p.a(localcgh.xQY);
      AppMethodBeat.o(35715);
      return paramString;
    }
    catch (IOException paramString)
    {
      ab.e("SnsAdExtUtil", "", new Object[] { paramString });
      AppMethodBeat.o(35715);
    }
    return "";
  }
  
  public static String a(long paramLong, Object... paramVarArgs)
  {
    AppMethodBeat.i(35712);
    ag.coZ();
    paramVarArgs = new StringBuilder(i.t(paramVarArgs));
    a(paramLong, paramVarArgs);
    paramVarArgs = paramVarArgs.toString();
    AppMethodBeat.o(35712);
    return paramVarArgs;
  }
  
  public static String a(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(35714);
    if (paramTimeLineObject != null)
    {
      paramTimeLineObject = Zt(paramTimeLineObject.rHA);
      AppMethodBeat.o(35714);
      return paramTimeLineObject;
    }
    ab.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
    AppMethodBeat.o(35714);
    return null;
  }
  
  public static void a(long paramLong, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(35713);
    Object localObject = ag.cpi().lQ(paramLong);
    if (localObject != null)
    {
      localObject = ((e)localObject).csh();
      if (localObject != null)
      {
        p.a(((TimeLineObject)localObject).rHA, paramStringBuilder);
        AppMethodBeat.o(35713);
        return;
      }
      ab.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[] { Long.valueOf(paramLong) });
      paramStringBuilder.append(",,");
      AppMethodBeat.o(35713);
      return;
    }
    ab.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[] { Long.valueOf(paramLong) });
    paramStringBuilder.append(",,");
    AppMethodBeat.o(35713);
  }
  
  public static void a(String paramString, d paramd)
  {
    AppMethodBeat.i(35711);
    Object localObject = ag.cpf().abu(paramString);
    if (localObject != null)
    {
      localObject = ((n)localObject).csh();
      if (localObject != null)
      {
        p.a(((TimeLineObject)localObject).rHA, paramd);
        AppMethodBeat.o(35711);
        return;
      }
      ab.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[] { paramString });
      AppMethodBeat.o(35711);
      return;
    }
    ab.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[] { paramString });
    AppMethodBeat.o(35711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.f
 * JD-Core Version:    0.7.0.1
 */