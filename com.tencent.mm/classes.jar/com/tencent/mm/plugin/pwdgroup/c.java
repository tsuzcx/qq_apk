package com.tencent.mm.plugin.pwdgroup;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.b.f;
import com.tencent.mm.cc.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.model.ax;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c
  implements ax
{
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(27618);
    b.a.wYb = new j.a()
    {
      private Bitmap cTq;
      private f<String, WeakReference<Bitmap>> wYc;
      
      public final Bitmap LL()
      {
        return this.cTq;
      }
      
      public final Bitmap a(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        return null;
      }
      
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(27616);
        if ((paramAnonymousj instanceof e.a)) {
          p.aEk().a((e.a)paramAnonymousj);
        }
        AppMethodBeat.o(27616);
      }
      
      public final Bitmap fg(String paramAnonymousString)
      {
        AppMethodBeat.i(27617);
        Object localObject = (WeakReference)this.wYc.get(paramAnonymousString);
        if ((localObject == null) || (((WeakReference)localObject).get() == null) || (((Bitmap)((WeakReference)localObject).get()).isRecycled()) || (((WeakReference)localObject).get() != LL()))
        {
          localObject = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {}
          for (paramAnonymousString = this.cTq;; paramAnonymousString = (String)localObject)
          {
            AppMethodBeat.o(27617);
            return paramAnonymousString;
            this.wYc.q(paramAnonymousString, new WeakReference(localObject));
          }
        }
        paramAnonymousString = (Bitmap)((WeakReference)localObject).get();
        AppMethodBeat.o(27617);
        return paramAnonymousString;
      }
      
      public final Bitmap fh(String paramAnonymousString)
      {
        return null;
      }
    };
    AppMethodBeat.o(27618);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.c
 * JD-Core Version:    0.7.0.1
 */