package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abb;
import com.tencent.mm.autogen.a.abb.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.record.model.w;
import com.tencent.mm.plugin.record.model.x;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class i
{
  public BaseAdapter NCl;
  a NCm;
  boolean NCn;
  private IListener NCo;
  Pattern NCp;
  Pattern NCq;
  Context context;
  
  public i(Context paramContext, BaseAdapter paramBaseAdapter, a parama)
  {
    AppMethodBeat.i(27996);
    this.NCo = new TranslateHelper.1(this, f.hfK);
    this.NCp = Pattern.compile("[a-zA-z]");
    this.NCq = Pattern.compile("[一-龥]");
    this.context = paramContext;
    this.NCl = paramBaseAdapter;
    this.NCm = parama;
    this.NCo.alive();
    AppMethodBeat.o(27996);
  }
  
  public final w agt(int paramInt)
  {
    AppMethodBeat.i(27998);
    Object localObject = this.NCm.NBb.nUC.iterator();
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
    this.NCm.NBb.nUC.add(localObject);
    AppMethodBeat.o(27998);
    return localObject;
  }
  
  public final void bt(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27997);
    w localw = agt(paramInt);
    if ((!Util.isNullOrNil(localw.NAZ)) && (!paramBoolean))
    {
      localw.status = 2;
      this.NCl.notifyDataSetChanged();
      AppMethodBeat.o(27997);
      return;
    }
    if (paramInt >= this.NCm.NBa.size())
    {
      AppMethodBeat.o(27997);
      return;
    }
    abb localabb = new abb();
    localabb.ieG.ieI = false;
    localabb.ieG.id = String.valueOf(paramInt);
    localabb.ieG.ieH = ((arf)this.NCm.NBa.get(paramInt)).desc;
    abb.a locala = localabb.ieG;
    if (localw.cookie != null) {}
    for (byte[] arrayOfByte = localw.cookie.Op;; arrayOfByte = null)
    {
      locala.ieJ = arrayOfByte;
      localabb.ieG.type = 4;
      localabb.publish();
      localw.status = 1;
      this.NCl.notifyDataSetChanged();
      this.NCn = true;
      AppMethodBeat.o(27997);
      return;
    }
  }
  
  public final byte[] gGy()
  {
    AppMethodBeat.i(27999);
    this.NCo.dead();
    Object localObject = new x();
    if ((this.NCm != null) && (this.NCm.NBb != null) && (this.NCm.NBb.nUC != null))
    {
      Iterator localIterator = this.NCm.NBb.nUC.iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if (!Util.isNullOrNil(localw.NAZ)) {
          ((x)localObject).nUC.add(localw);
        }
      }
    }
    this.NCl = null;
    this.NCm = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.i
 * JD-Core Version:    0.7.0.1
 */