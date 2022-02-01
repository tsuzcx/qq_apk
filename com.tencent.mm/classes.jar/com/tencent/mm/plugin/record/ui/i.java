package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.a;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class i
{
  public BaseAdapter BIB;
  a BIC;
  boolean BID;
  private IListener BIE;
  Pattern BIF;
  Pattern BIG;
  Context context;
  
  public i(Context paramContext, BaseAdapter paramBaseAdapter, a parama)
  {
    AppMethodBeat.i(27996);
    this.BIE = new i.1(this);
    this.BIF = Pattern.compile("[a-zA-z]");
    this.BIG = Pattern.compile("[一-龥]");
    this.context = paramContext;
    this.BIB = paramBaseAdapter;
    this.BIC = parama;
    EventCenter.instance.addListener(this.BIE);
    AppMethodBeat.o(27996);
  }
  
  public final w Vx(int paramInt)
  {
    AppMethodBeat.i(27998);
    Object localObject = this.BIC.BHt.iAd.iterator();
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
    this.BIC.BHt.iAd.add(localObject);
    AppMethodBeat.o(27998);
    return localObject;
  }
  
  public final void aK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27997);
    w localw = Vx(paramInt);
    if ((!Util.isNullOrNil(localw.BHr)) && (!paramBoolean))
    {
      localw.status = 2;
      this.BIB.notifyDataSetChanged();
      AppMethodBeat.o(27997);
      return;
    }
    if (paramInt >= this.BIC.BHs.size())
    {
      AppMethodBeat.o(27997);
      return;
    }
    ya localya = new ya();
    localya.eep.eer = false;
    localya.eep.id = String.valueOf(paramInt);
    localya.eep.eeq = ((aml)this.BIC.BHs.get(paramInt)).desc;
    ya.a locala = localya.eep;
    if (localw.AqP != null) {}
    for (byte[] arrayOfByte = localw.AqP.zy;; arrayOfByte = null)
    {
      locala.ees = arrayOfByte;
      localya.eep.type = 4;
      EventCenter.instance.publish(localya);
      localw.status = 1;
      this.BIB.notifyDataSetChanged();
      this.BID = true;
      AppMethodBeat.o(27997);
      return;
    }
  }
  
  public final byte[] eID()
  {
    AppMethodBeat.i(27999);
    EventCenter.instance.removeListener(this.BIE);
    Object localObject = new x();
    if ((this.BIC != null) && (this.BIC.BHt != null) && (this.BIC.BHt.iAd != null))
    {
      Iterator localIterator = this.BIC.BHt.iAd.iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if (!Util.isNullOrNil(localw.BHr)) {
          ((x)localObject).iAd.add(localw);
        }
      }
    }
    this.BIB = null;
    this.BIC = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.i
 * JD-Core Version:    0.7.0.1
 */