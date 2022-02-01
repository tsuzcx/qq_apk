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
    AppMethodBeat.i(192680);
    DexLoader localDexLoader = this.a;
    DexClassLoader localDexClassLoader = this.a.getClassLoader();
    paramContext = localDexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[] { Context.class, DexClassLoader.class }, new Object[] { paramContext, localDexClassLoader });
    AppMethodBeat.o(192680);
    return paramContext;
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(192683);
    this.a.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    AppMethodBeat.o(192683);
  }
  
  public void a(Object paramObject, Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(192682);
    this.a.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[] { Activity.class, Integer.TYPE }, new Object[] { paramActivity, Integer.valueOf(paramInt) });
    AppMethodBeat.o(192682);
  }
  
  public boolean a(Object paramObject1, Bundle paramBundle, FrameLayout paramFrameLayout, Object paramObject2)
  {
    AppMethodBeat.i(192681);
    if (paramObject2 != null) {}
    for (paramObject1 = this.a.invokeMethod(paramObject1, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[] { Bundle.class, FrameLayout.class, Object.class }, new Object[] { paramBundle, paramFrameLayout, paramObject2 }); (paramObject1 instanceof Boolean); paramObject1 = this.a.invokeMethod(paramObject1, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[] { Bundle.class, FrameLayout.class }, new Object[] { paramBundle, paramFrameLayout }))
    {
      boolean bool = ((Boolean)paramObject1).booleanValue();
      AppMethodBeat.o(192681);
      return bool;
    }
    AppMethodBeat.o(192681);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.w
 * JD-Core Version:    0.7.0.1
 */