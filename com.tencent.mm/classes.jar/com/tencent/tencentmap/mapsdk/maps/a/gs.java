package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.b;
import com.tencent.tencentmap.mapsdk.a.c;
import com.tencent.tencentmap.mapsdk.a.d;

public class gs
{
  private Context a;
  
  public gs(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private <T> void a(String paramString, d paramd, Class<T> paramClass, b paramb)
  {
    AppMethodBeat.i(148027);
    if ((paramd == null) || (!paramd.b()))
    {
      fr.a("wrong parameter");
      AppMethodBeat.o(148027);
      return;
    }
    String str = de.a(this.a);
    if (TextUtils.isEmpty(str))
    {
      if (paramb != null) {
        paramb.a(-1, "请申请并填写开发者密钥", null);
      }
      AppMethodBeat.o(148027);
      return;
    }
    paramd = paramd.c();
    if (paramd != null)
    {
      paramd.b("key", str);
      paramd.b("output", "json");
    }
    fk.a(this.a, paramString, paramd, paramClass, paramb);
    AppMethodBeat.o(148027);
  }
  
  public void getRoutePlan(c paramc, b paramb)
  {
    AppMethodBeat.i(148026);
    a(paramc.a(), paramc, paramc.d(), paramb);
    AppMethodBeat.o(148026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gs
 * JD-Core Version:    0.7.0.1
 */