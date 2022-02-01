package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.g.a.wz.a;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.a.xc.a;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  public BaseAdapter ohU;
  a xIA;
  boolean xIB;
  private c xIC;
  Pattern xID;
  Pattern xIE;
  
  public i(Context paramContext, BaseAdapter paramBaseAdapter, a parama)
  {
    AppMethodBeat.i(27996);
    this.xIC = new c() {};
    this.xID = Pattern.compile("[a-zA-z]");
    this.xIE = Pattern.compile("[一-龥]");
    this.context = paramContext;
    this.ohU = paramBaseAdapter;
    this.xIA = parama;
    com.tencent.mm.sdk.b.a.IvT.c(this.xIC);
    AppMethodBeat.o(27996);
  }
  
  public final w Oi(int paramInt)
  {
    AppMethodBeat.i(27998);
    Object localObject = this.xIA.xHv.hFT.iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      if (paramInt == localw.id)
      {
        AppMethodBeat.o(27998);
        return localw;
      }
    }
    localObject = new w();
    ((w)localObject).id = paramInt;
    ((w)localObject).status = 0;
    this.xIA.xHv.hFT.add(localObject);
    AppMethodBeat.o(27998);
    return localObject;
  }
  
  public final void aw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27997);
    w localw = Oi(paramInt);
    if ((!bu.isNullOrNil(localw.xHs)) && (!paramBoolean))
    {
      localw.status = 2;
      this.ohU.notifyDataSetChanged();
      AppMethodBeat.o(27997);
      return;
    }
    if (paramInt >= this.xIA.xHu.size())
    {
      AppMethodBeat.o(27997);
      return;
    }
    wz localwz = new wz();
    localwz.dMx.dMz = false;
    localwz.dMx.id = String.valueOf(paramInt);
    localwz.dMx.dMy = ((ajx)this.xIA.xHu.get(paramInt)).desc;
    wz.a locala = localwz.dMx;
    if (localw.xHt != null) {}
    for (byte[] arrayOfByte = localw.xHt.zr;; arrayOfByte = null)
    {
      locala.dMA = arrayOfByte;
      localwz.dMx.type = 4;
      com.tencent.mm.sdk.b.a.IvT.l(localwz);
      localw.status = 1;
      this.ohU.notifyDataSetChanged();
      this.xIB = true;
      AppMethodBeat.o(27997);
      return;
    }
  }
  
  public final byte[] dHQ()
  {
    AppMethodBeat.i(27999);
    com.tencent.mm.sdk.b.a.IvT.d(this.xIC);
    Object localObject = new x();
    if ((this.xIA != null) && (this.xIA.xHv != null) && (this.xIA.xHv.hFT != null))
    {
      Iterator localIterator = this.xIA.xHv.hFT.iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if (!bu.isNullOrNil(localw.xHs)) {
          ((x)localObject).hFT.add(localw);
        }
      }
    }
    this.ohU = null;
    this.xIA = null;
    this.context = null;
    try
    {
      localObject = ((x)localObject).toByteArray();
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