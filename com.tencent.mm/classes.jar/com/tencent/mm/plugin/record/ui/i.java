package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.zh;
import com.tencent.mm.f.a.zh.a;
import com.tencent.mm.f.a.zk;
import com.tencent.mm.f.a.zk.a;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  public BaseAdapter HEJ;
  a HEK;
  boolean HEL;
  private IListener HEM;
  Pattern HEN;
  Pattern HEO;
  Context context;
  
  public i(Context paramContext, BaseAdapter paramBaseAdapter, a parama)
  {
    AppMethodBeat.i(27996);
    this.HEM = new IListener() {};
    this.HEN = Pattern.compile("[a-zA-z]");
    this.HEO = Pattern.compile("[一-龥]");
    this.context = paramContext;
    this.HEJ = paramBaseAdapter;
    this.HEK = parama;
    EventCenter.instance.addListener(this.HEM);
    AppMethodBeat.o(27996);
  }
  
  public final void aR(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27997);
    w localw = acf(paramInt);
    if ((!Util.isNullOrNil(localw.HDx)) && (!paramBoolean))
    {
      localw.status = 2;
      this.HEJ.notifyDataSetChanged();
      AppMethodBeat.o(27997);
      return;
    }
    if (paramInt >= this.HEK.HDy.size())
    {
      AppMethodBeat.o(27997);
      return;
    }
    zh localzh = new zh();
    localzh.fYE.fYG = false;
    localzh.fYE.id = String.valueOf(paramInt);
    localzh.fYE.fYF = ((anm)this.HEK.HDy.get(paramInt)).desc;
    zh.a locala = localzh.fYE;
    if (localw.GdC != null) {}
    for (byte[] arrayOfByte = localw.GdC.UH;; arrayOfByte = null)
    {
      locala.fYH = arrayOfByte;
      localzh.fYE.type = 4;
      EventCenter.instance.publish(localzh);
      localw.status = 1;
      this.HEJ.notifyDataSetChanged();
      this.HEL = true;
      AppMethodBeat.o(27997);
      return;
    }
  }
  
  public final w acf(int paramInt)
  {
    AppMethodBeat.i(27998);
    Object localObject = this.HEK.HDz.lpz.iterator();
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
    this.HEK.HDz.lpz.add(localObject);
    AppMethodBeat.o(27998);
    return localObject;
  }
  
  public final byte[] fuI()
  {
    AppMethodBeat.i(27999);
    EventCenter.instance.removeListener(this.HEM);
    Object localObject = new x();
    if ((this.HEK != null) && (this.HEK.HDz != null) && (this.HEK.HDz.lpz != null))
    {
      Iterator localIterator = this.HEK.HDz.lpz.iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if (!Util.isNullOrNil(localw.HDx)) {
          ((x)localObject).lpz.add(localw);
        }
      }
    }
    this.HEJ = null;
    this.HEK = null;
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