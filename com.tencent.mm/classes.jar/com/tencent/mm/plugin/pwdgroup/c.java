package com.tencent.mm.plugin.pwdgroup;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.b.f;
import com.tencent.mm.cc.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c
  implements aw
{
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(27618);
    b.a.vQR = new i.a()
    {
      private Bitmap cIi;
      private f<String, WeakReference<Bitmap>> vQS;
      
      public final Bitmap Kj()
      {
        return this.cIi;
      }
      
      public final Bitmap a(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        return null;
      }
      
      public final void a(i paramAnonymousi)
      {
        AppMethodBeat.i(27616);
        if ((paramAnonymousi instanceof e.a)) {
          p.aBh().a((e.a)paramAnonymousi);
        }
        AppMethodBeat.o(27616);
      }
      
      public final Bitmap el(String paramAnonymousString)
      {
        AppMethodBeat.i(27617);
        Object localObject = (WeakReference)this.vQS.get(paramAnonymousString);
        if ((localObject == null) || (((WeakReference)localObject).get() == null) || (((Bitmap)((WeakReference)localObject).get()).isRecycled()) || (((WeakReference)localObject).get() != Kj()))
        {
          localObject = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {}
          for (paramAnonymousString = this.cIi;; paramAnonymousString = (String)localObject)
          {
            AppMethodBeat.o(27617);
            return paramAnonymousString;
            this.vQS.o(paramAnonymousString, new WeakReference(localObject));
          }
        }
        paramAnonymousString = (Bitmap)((WeakReference)localObject).get();
        AppMethodBeat.o(27617);
        return paramAnonymousString;
      }
      
      public final Bitmap em(String paramAnonymousString)
      {
        return null;
      }
    };
    AppMethodBeat.o(27618);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.c
 * JD-Core Version:    0.7.0.1
 */