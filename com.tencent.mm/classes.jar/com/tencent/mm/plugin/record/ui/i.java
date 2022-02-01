package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.a;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.a.wy.a;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  public BaseAdapter ocf;
  a xsD;
  boolean xsE;
  private c xsF;
  Pattern xsG;
  Pattern xsH;
  
  public i(Context paramContext, BaseAdapter paramBaseAdapter, a parama)
  {
    AppMethodBeat.i(27996);
    this.xsF = new c() {};
    this.xsG = Pattern.compile("[a-zA-z]");
    this.xsH = Pattern.compile("[一-龥]");
    this.context = paramContext;
    this.ocf = paramBaseAdapter;
    this.xsD = parama;
    com.tencent.mm.sdk.b.a.IbL.c(this.xsF);
    AppMethodBeat.o(27996);
  }
  
  public final w NC(int paramInt)
  {
    AppMethodBeat.i(27998);
    Object localObject = this.xsD.xry.hDb.iterator();
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
    this.xsD.xry.hDb.add(localObject);
    AppMethodBeat.o(27998);
    return localObject;
  }
  
  public final void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27997);
    w localw = NC(paramInt);
    if ((!bt.isNullOrNil(localw.xrv)) && (!paramBoolean))
    {
      localw.status = 2;
      this.ocf.notifyDataSetChanged();
      AppMethodBeat.o(27997);
      return;
    }
    if (paramInt >= this.xsD.xrx.size())
    {
      AppMethodBeat.o(27997);
      return;
    }
    wv localwv = new wv();
    localwv.dLi.dLk = false;
    localwv.dLi.id = String.valueOf(paramInt);
    localwv.dLi.dLj = ((ajn)this.xsD.xrx.get(paramInt)).desc;
    wv.a locala = localwv.dLi;
    if (localw.xrw != null) {}
    for (byte[] arrayOfByte = localw.xrw.zr;; arrayOfByte = null)
    {
      locala.dLl = arrayOfByte;
      localwv.dLi.type = 4;
      com.tencent.mm.sdk.b.a.IbL.l(localwv);
      localw.status = 1;
      this.ocf.notifyDataSetChanged();
      this.xsE = true;
      AppMethodBeat.o(27997);
      return;
    }
  }
  
  public final byte[] dEz()
  {
    AppMethodBeat.i(27999);
    com.tencent.mm.sdk.b.a.IbL.d(this.xsF);
    Object localObject = new x();
    if ((this.xsD != null) && (this.xsD.xry != null) && (this.xsD.xry.hDb != null))
    {
      Iterator localIterator = this.xsD.xry.hDb.iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if (!bt.isNullOrNil(localw.xrv)) {
          ((x)localObject).hDb.add(localw);
        }
      }
    }
    this.ocf = null;
    this.xsD = null;
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