package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class ReaderWizard
{
  private DexLoader a;
  private TbsReaderView.ReaderCallback b;
  
  public ReaderWizard(TbsReaderView.ReaderCallback paramReaderCallback)
  {
    AppMethodBeat.i(64061);
    this.a = null;
    this.b = null;
    this.a = a();
    this.b = paramReaderCallback;
    AppMethodBeat.o(64061);
  }
  
  private static DexLoader a()
  {
    AppMethodBeat.i(64062);
    bl localbl = o.a(true).c();
    DexLoader localDexLoader = null;
    if (localbl != null) {
      localDexLoader = localbl.b();
    }
    AppMethodBeat.o(64062);
    return localDexLoader;
  }
  
  public static Drawable getResDrawable(int paramInt)
  {
    AppMethodBeat.i(64059);
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      if (!(localObject instanceof Drawable)) {}
    }
    for (localObject = (Drawable)localObject;; localObject = null)
    {
      AppMethodBeat.o(64059);
      return localObject;
    }
  }
  
  public static String getResString(int paramInt)
  {
    AppMethodBeat.i(64060);
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      if (!(localObject instanceof String)) {}
    }
    for (localObject = (String)localObject;; localObject = "")
    {
      AppMethodBeat.o(64060);
      return localObject;
    }
  }
  
  public static boolean isSupportCurrentPlatform(Context paramContext)
  {
    AppMethodBeat.i(64057);
    DexLoader localDexLoader = a();
    if (localDexLoader != null)
    {
      paramContext = localDexLoader.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[] { Context.class }, new Object[] { paramContext });
      if (!(paramContext instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)paramContext).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64057);
      return bool;
    }
  }
  
  public static boolean isSupportExt(String paramString)
  {
    AppMethodBeat.i(64058);
    DexLoader localDexLoader = a();
    if (localDexLoader != null)
    {
      paramString = localDexLoader.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[] { String.class }, new Object[] { paramString });
      if (!(paramString instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)paramString).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64058);
      return bool;
    }
  }
  
  public boolean checkPlugin(Object paramObject, Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(64065);
    if (this.a == null)
    {
      AppMethodBeat.o(64065);
      return false;
    }
    paramObject = this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[] { Context.class, String.class, Boolean.class }, new Object[] { paramContext, paramString, Boolean.valueOf(paramBoolean) });
    if (!(paramObject instanceof Boolean))
    {
      AppMethodBeat.o(64065);
      return false;
    }
    paramBoolean = ((Boolean)paramObject).booleanValue();
    AppMethodBeat.o(64065);
    return paramBoolean;
  }
  
  public void destroy(Object paramObject)
  {
    AppMethodBeat.i(64070);
    this.b = null;
    if ((this.a == null) || (paramObject == null))
    {
      AppMethodBeat.o(64070);
      return;
    }
    this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
    AppMethodBeat.o(64070);
  }
  
  public void doCommand(Object paramObject1, Integer paramInteger, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(64069);
    if (this.a == null)
    {
      AppMethodBeat.o(64069);
      return;
    }
    DexLoader localDexLoader = this.a;
    paramInteger = new Integer(paramInteger.intValue());
    localDexLoader.invokeMethod(paramObject1, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[] { Integer.class, Object.class, Object.class }, new Object[] { paramInteger, paramObject2, paramObject3 });
    AppMethodBeat.o(64069);
  }
  
  public Object getTbsReader()
  {
    AppMethodBeat.i(64063);
    Object localObject = this.a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    AppMethodBeat.o(64063);
    return localObject;
  }
  
  public boolean initTbsReader(Object paramObject, Context paramContext)
  {
    AppMethodBeat.i(64064);
    if ((this.a == null) || (paramObject == null))
    {
      AppMethodBeat.o(64064);
      return false;
    }
    DexLoader localDexLoader1 = this.a;
    DexLoader localDexLoader2 = this.a;
    paramObject = localDexLoader1.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "init", new Class[] { Context.class, DexLoader.class, Object.class }, new Object[] { paramContext, localDexLoader2, this });
    if (!(paramObject instanceof Boolean))
    {
      AppMethodBeat.o(64064);
      return false;
    }
    boolean bool = ((Boolean)paramObject).booleanValue();
    AppMethodBeat.o(64064);
    return bool;
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(64068);
    if (this.b != null) {
      this.b.onCallBackAction(paramInteger, paramObject1, paramObject2);
    }
    AppMethodBeat.o(64068);
  }
  
  public void onSizeChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(64067);
    if (this.a == null)
    {
      AppMethodBeat.o(64067);
      return;
    }
    this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[] { Integer.class, Integer.class }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(64067);
  }
  
  public boolean openFile(Object paramObject, Context paramContext, Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(64066);
    if (this.a == null)
    {
      AppMethodBeat.o(64066);
      return false;
    }
    paramObject = this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[] { Context.class, Bundle.class, FrameLayout.class }, new Object[] { paramContext, paramBundle, paramFrameLayout });
    if (!(paramObject instanceof Boolean))
    {
      AppMethodBeat.o(64066);
      return false;
    }
    boolean bool = ((Boolean)paramObject).booleanValue();
    AppMethodBeat.o(64066);
    return bool;
  }
  
  public void userStatistics(Object paramObject, String paramString)
  {
    AppMethodBeat.i(64071);
    if (this.a == null)
    {
      AppMethodBeat.o(64071);
      return;
    }
    this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(64071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.ReaderWizard
 * JD-Core Version:    0.7.0.1
 */