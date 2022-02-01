package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.g.a.wc.a;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.g.a.wf.a;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.b.v;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  Context context;
  public BaseAdapter nAW;
  a wkJ;
  boolean wkK;
  private c wkL;
  Pattern wkM;
  Pattern wkN;
  
  public i(Context paramContext, BaseAdapter paramBaseAdapter, a parama)
  {
    AppMethodBeat.i(27996);
    this.wkL = new c() {};
    this.wkM = Pattern.compile("[a-zA-z]");
    this.wkN = Pattern.compile("[一-龥]");
    this.context = paramContext;
    this.nAW = paramBaseAdapter;
    this.wkJ = parama;
    com.tencent.mm.sdk.b.a.GpY.c(this.wkL);
    AppMethodBeat.o(27996);
  }
  
  public final u Md(int paramInt)
  {
    AppMethodBeat.i(27998);
    Object localObject = this.wkJ.wjI.hkS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      u localu = (u)((Iterator)localObject).next();
      if (paramInt == localu.id)
      {
        AppMethodBeat.o(27998);
        return localu;
      }
    }
    localObject = new u();
    ((u)localObject).id = paramInt;
    ((u)localObject).status = 0;
    this.wkJ.wjI.hkS.add(localObject);
    AppMethodBeat.o(27998);
    return localObject;
  }
  
  public final void ao(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27997);
    u localu = Md(paramInt);
    if ((!bs.isNullOrNil(localu.wjF)) && (!paramBoolean))
    {
      localu.status = 2;
      this.nAW.notifyDataSetChanged();
      AppMethodBeat.o(27997);
      return;
    }
    if (paramInt >= this.wkJ.wjH.size())
    {
      AppMethodBeat.o(27997);
      return;
    }
    wc localwc = new wc();
    localwc.dyW.dyY = false;
    localwc.dyW.id = String.valueOf(paramInt);
    localwc.dyW.dyX = ((agx)this.wkJ.wjH.get(paramInt)).desc;
    wc.a locala = localwc.dyW;
    if (localu.wjG != null) {}
    for (byte[] arrayOfByte = localu.wjG.xy;; arrayOfByte = null)
    {
      locala.dyZ = arrayOfByte;
      localwc.dyW.type = 4;
      com.tencent.mm.sdk.b.a.GpY.l(localwc);
      localu.status = 1;
      this.nAW.notifyDataSetChanged();
      this.wkK = true;
      AppMethodBeat.o(27997);
      return;
    }
  }
  
  public final byte[] duc()
  {
    AppMethodBeat.i(27999);
    com.tencent.mm.sdk.b.a.GpY.d(this.wkL);
    Object localObject = new v();
    if ((this.wkJ != null) && (this.wkJ.wjI != null) && (this.wkJ.wjI.hkS != null))
    {
      Iterator localIterator = this.wkJ.wjI.hkS.iterator();
      while (localIterator.hasNext())
      {
        u localu = (u)localIterator.next();
        if (!bs.isNullOrNil(localu.wjF)) {
          ((v)localObject).hkS.add(localu);
        }
      }
    }
    this.nAW = null;
    this.wkJ = null;
    this.context = null;
    try
    {
      localObject = ((v)localObject).toByteArray();
      AppMethodBeat.o(27999);
      return localObject;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(27999);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.i
 * JD-Core Version:    0.7.0.1
 */