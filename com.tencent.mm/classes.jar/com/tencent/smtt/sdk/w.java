package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

class w
{
  protected DexLoader a = null;
  
  public w(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public Object a(Context paramContext)
  {
    AppMethodBeat.i(219403);
    DexLoader localDexLoader = this.a;
    DexClassLoader localDexClassLoader = this.a.getClassLoader();
    paramContext = localDexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[] { Context.class, DexClassLoader.class }, new Object[] { paramContext, localDexClassLoader });
    AppMethodBeat.o(219403);
    return paramContext;
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(219412);
    this.a.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    AppMethodBeat.o(219412);
  }
  
  public void a(Object paramObject, Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(219408);
    this.a.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[] { Activity.class, Integer.TYPE }, new Object[] { paramActivity, Integer.valueOf(paramInt) });
    AppMethodBeat.o(219408);
  }
  
  public boolean a(Object paramObject1, Bundle paramBundle, FrameLayout paramFrameLayout, Object paramObject2)
  {
    AppMethodBeat.i(219405);
    if (paramObject2 != null) {}
    for (paramObject1 = this.a.invokeMethod(paramObject1, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[] { Bundle.class, FrameLayout.class, Object.class }, new Object[] { paramBundle, paramFrameLayout, paramObject2 }); (paramObject1 instanceof Boolean); paramObject1 = this.a.invokeMethod(paramObject1, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[] { Bundle.class, FrameLayout.class }, new Object[] { paramBundle, paramFrameLayout }))
    {
      boolean bool = ((Boolean)paramObject1).booleanValue();
      AppMethodBeat.o(219405);
      return bool;
    }
    AppMethodBeat.o(219405);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.w
 * JD-Core Version:    0.7.0.1
 */