package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  apv OkY;
  apv OkZ;
  boolean Ola;
  private Context context;
  
  public b()
  {
    this.context = null;
    this.OkY = null;
    this.OkZ = null;
    this.Ola = false;
  }
  
  public b(Context paramContext, apv paramapv)
  {
    AppMethodBeat.i(289185);
    this.context = null;
    this.OkY = null;
    this.OkZ = null;
    this.Ola = false;
    this.context = paramContext;
    this.OkY = paramapv;
    if (paramapv == null)
    {
      Log.i("MicroMsg.ExtraBuyInfoHelper", "no extra buy info");
      AppMethodBeat.o(289185);
      return;
    }
    Log.i("MicroMsg.ExtraBuyInfoHelper", "init. title = %s, detail count = %d", new Object[] { paramapv.title, Integer.valueOf(paramapv.Oiy.size()) });
    paramContext = paramapv.Oiy.iterator();
    while (paramContext.hasNext())
    {
      paramapv = (apu)paramContext.next();
      Log.i("MicroMsg.ExtraBuyInfoHelper", "extra buy item: %d, %s", new Object[] { Long.valueOf(paramapv.Zxa), paramapv.Zxb });
    }
    AppMethodBeat.o(289185);
  }
  
  private int gMm()
  {
    AppMethodBeat.i(289186);
    Iterator localIterator = gMk().Oiy.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((apu)localIterator.next()).Zxg != 0) {
        break label56;
      }
      i += 1;
    }
    label56:
    for (;;)
    {
      break;
      AppMethodBeat.o(289186);
      return i;
    }
  }
  
  public final void a(apv paramapv)
  {
    AppMethodBeat.i(289209);
    if (paramapv == null)
    {
      Log.e("MicroMsg.ExtraBuyInfoHelper", "set favor resp extra buy info (null)");
      AppMethodBeat.o(289209);
      return;
    }
    this.OkZ = paramapv;
    Log.i("MicroMsg.ExtraBuyInfoHelper", "set favor resp extra buy info with %d items", new Object[] { Integer.valueOf(paramapv.Oiy.size()) });
    paramapv = paramapv.Oiy.iterator();
    while (paramapv.hasNext())
    {
      apu localapu = (apu)paramapv.next();
      Log.i("MicroMsg.ExtraBuyInfoHelper", "item updated, id=%d. unavailable=%d, selected=%b", new Object[] { Long.valueOf(localapu.Zxa), Integer.valueOf(localapu.Zxg), Boolean.valueOf(localapu.Bvd) });
    }
    AppMethodBeat.o(289209);
  }
  
  public final boolean gMe()
  {
    AppMethodBeat.i(289189);
    if (gMk() == null)
    {
      AppMethodBeat.o(289189);
      return false;
    }
    if (gMk().Oiy.size() > 0)
    {
      AppMethodBeat.o(289189);
      return true;
    }
    AppMethodBeat.o(289189);
    return false;
  }
  
  public final boolean gMf()
  {
    AppMethodBeat.i(289191);
    if (this.Ola)
    {
      AppMethodBeat.o(289191);
      return false;
    }
    if (gMk().Oiy.size() == 1)
    {
      if (gMm() > 0)
      {
        AppMethodBeat.o(289191);
        return true;
      }
      AppMethodBeat.o(289191);
      return false;
    }
    AppMethodBeat.o(289191);
    return true;
  }
  
  public final boolean gMg()
  {
    AppMethodBeat.i(289194);
    if (gMk().Oiy.size() > 1)
    {
      AppMethodBeat.o(289194);
      return true;
    }
    AppMethodBeat.o(289194);
    return false;
  }
  
  public final int gMh()
  {
    AppMethodBeat.i(289198);
    if (gMm() > 0)
    {
      i = this.context.getResources().getColor(a.c.Orange);
      AppMethodBeat.o(289198);
      return i;
    }
    int i = this.context.getResources().getColor(a.c.hint_text_color);
    AppMethodBeat.o(289198);
    return i;
  }
  
  public final boolean gMi()
  {
    AppMethodBeat.i(289203);
    boolean bool = ((apu)gMk().Oiy.getFirst()).Bvd;
    AppMethodBeat.o(289203);
    return bool;
  }
  
  public final long gMj()
  {
    AppMethodBeat.i(289206);
    if (this.OkY == null)
    {
      AppMethodBeat.o(289206);
      return 0L;
    }
    Iterator localIterator = gMk().Oiy.iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      apu localapu = (apu)localIterator.next();
      if ((localapu.Zxg != 0) || (!localapu.Bvd)) {
        break label86;
      }
      l += localapu.Zxd;
    }
    label86:
    for (;;)
    {
      break;
      AppMethodBeat.o(289206);
      return l;
    }
  }
  
  public final apv gMk()
  {
    if (this.OkZ != null) {
      return this.OkZ;
    }
    return this.OkY;
  }
  
  public final void gMl()
  {
    AppMethodBeat.i(289211);
    if (this.OkY == null)
    {
      AppMethodBeat.o(289211);
      return;
    }
    Log.i("MicroMsg.ExtraBuyInfoHelper", "clear response info");
    this.OkZ = null;
    Iterator localIterator = this.OkY.Oiy.iterator();
    while (localIterator.hasNext()) {
      ((apu)localIterator.next()).Bvd = false;
    }
    AppMethodBeat.o(289211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.b
 * JD-Core Version:    0.7.0.1
 */