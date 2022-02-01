package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.g.a.vr.a;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.a.vu.a;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.b.v;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  Context context;
  public BaseAdapter mYx;
  private a vbV;
  private c vbW;
  
  public i(Context paramContext, BaseAdapter paramBaseAdapter, a parama)
  {
    AppMethodBeat.i(27996);
    this.vbW = new c() {};
    this.context = paramContext;
    this.mYx = paramBaseAdapter;
    this.vbV = parama;
    com.tencent.mm.sdk.b.a.ESL.c(this.vbW);
    AppMethodBeat.o(27996);
  }
  
  public final u Ke(int paramInt)
  {
    AppMethodBeat.i(27998);
    Object localObject = this.vbV.vaU.gKs.iterator();
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
    this.vbV.vaU.gKs.add(localObject);
    AppMethodBeat.o(27998);
    return localObject;
  }
  
  public final void al(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27997);
    u localu = Ke(paramInt);
    if ((!bt.isNullOrNil(localu.vaR)) && (!paramBoolean))
    {
      localu.status = 2;
      this.mYx.notifyDataSetChanged();
      AppMethodBeat.o(27997);
      return;
    }
    vr localvr = new vr();
    localvr.dBi.dBk = false;
    localvr.dBi.id = String.valueOf(paramInt);
    localvr.dBi.dBj = ((afy)this.vbV.vaT.get(paramInt)).desc;
    vr.a locala = localvr.dBi;
    if (localu.vaS != null) {}
    for (byte[] arrayOfByte = localu.vaS.wA;; arrayOfByte = null)
    {
      locala.dBl = arrayOfByte;
      localvr.dBi.type = 4;
      com.tencent.mm.sdk.b.a.ESL.l(localvr);
      localu.status = 1;
      this.mYx.notifyDataSetChanged();
      AppMethodBeat.o(27997);
      return;
    }
  }
  
  public final byte[] dgv()
  {
    AppMethodBeat.i(27999);
    com.tencent.mm.sdk.b.a.ESL.d(this.vbW);
    Object localObject = new v();
    if ((this.vbV != null) && (this.vbV.vaU != null) && (this.vbV.vaU.gKs != null))
    {
      Iterator localIterator = this.vbV.vaU.gKs.iterator();
      while (localIterator.hasNext())
      {
        u localu = (u)localIterator.next();
        if (!bt.isNullOrNil(localu.vaR)) {
          ((v)localObject).gKs.add(localu);
        }
      }
    }
    this.mYx = null;
    this.vbV = null;
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