package com.tencent.mm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.core.provider.AccProviderFactory;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.sdk.platformtools.Log;

final class af$b
  extends LayoutInflater
{
  af.a adGC;
  
  protected af$b(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
  }
  
  public final LayoutInflater cloneInContext(Context paramContext)
  {
    AppMethodBeat.i(249909);
    paramContext = new b(this, paramContext);
    AppMethodBeat.o(249909);
    return paramContext;
  }
  
  public final View inflate(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(249914);
    long l = System.currentTimeMillis();
    if (this.adGC != null)
    {
      this.adGC.adFE = paramInt;
      if (this.adGC.adFF != null) {
        this.adGC.adFF.adFE = paramInt;
      }
    }
    localObject1 = null;
    try
    {
      localObject2 = super.inflate(paramInt, paramViewGroup, paramBoolean);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Log.printErrStackTrace("MicroMsg.MMLayoutInflater", localException, "MMLayoutInflaterWrapper.inflate", new Object[0]);
        continue;
        paramBoolean = false;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.adGC != null)
      {
        localObject2 = localObject1;
        if (this.adGC.adFF != null)
        {
          localObject2 = localObject1;
          if (this.adGC.adFF.dvH == null) {}
        }
      }
    }
    try
    {
      localObject2 = this.adGC.adFF.dvH.inflate(paramInt, paramViewGroup, paramBoolean);
      if (localObject2 != null) {
        break label234;
      }
      paramBoolean = true;
      localObject1 = localObject2;
      Log.i("MicroMsg.MMLayoutInflater", "inflater view using originLayoutInflater view:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMLayoutInflater", paramViewGroup, "MMLayoutInflaterWrapper.originInflate", new Object[0]);
        Object localObject3 = localObject1;
      }
    }
    if (localObject2 != null)
    {
      ((View)localObject2).setTag(a.g.tag_acc_layout_id, Integer.valueOf(paramInt));
      AccProviderFactory.INSTANCE.onInflateRootAsync((View)localObject2);
    }
    Log.d("MicroMsg.MMLayoutInflater", "inflate cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(249914);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.af.b
 * JD-Core Version:    0.7.0.1
 */