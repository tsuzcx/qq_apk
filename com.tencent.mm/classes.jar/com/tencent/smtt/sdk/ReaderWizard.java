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
    AppMethodBeat.i(55121);
    this.a = null;
    this.b = null;
    this.a = a();
    this.b = paramReaderCallback;
    AppMethodBeat.o(55121);
  }
  
  private static DexLoader a()
  {
    AppMethodBeat.i(55122);
    TbsWizard localTbsWizard = e.a(true).c();
    DexLoader localDexLoader = null;
    if (localTbsWizard != null) {
      localDexLoader = localTbsWizard.dexLoader();
    }
    AppMethodBeat.o(55122);
    return localDexLoader;
  }
  
  public static Drawable getResDrawable(int paramInt)
  {
    AppMethodBeat.i(55119);
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      if (!(localObject instanceof Drawable)) {}
    }
    for (localObject = (Drawable)localObject;; localObject = null)
    {
      AppMethodBeat.o(55119);
      return localObject;
    }
  }
  
  public static String getResString(int paramInt)
  {
    AppMethodBeat.i(55120);
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      if (!(localObject instanceof String)) {}
    }
    for (localObject = (String)localObject;; localObject = "")
    {
      AppMethodBeat.o(55120);
      return localObject;
    }
  }
  
  public static boolean isSupportCurrentPlatform(Context paramContext)
  {
    AppMethodBeat.i(55117);
    DexLoader localDexLoader = a();
    if (localDexLoader != null)
    {
      paramContext = localDexLoader.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[] { Context.class }, new Object[] { paramContext });
      if (!(paramContext instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)paramContext).booleanValue();; bool = false)
    {
      AppMethodBeat.o(55117);
      return bool;
    }
  }
  
  public static boolean isSupportExt(String paramString)
  {
    AppMethodBeat.i(55118);
    DexLoader localDexLoader = a();
    if (localDexLoader != null)
    {
      paramString = localDexLoader.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[] { String.class }, new Object[] { paramString });
      if (!(paramString instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)paramString).booleanValue();; bool = false)
    {
      AppMethodBeat.o(55118);
      return bool;
    }
  }
  
  public boolean checkPlugin(Object paramObject, Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55125);
    if (this.a == null)
    {
      AppMethodBeat.o(55125);
      return false;
    }
    paramObject = this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[] { Context.class, String.class, Boolean.class }, new Object[] { paramContext, paramString, Boolean.valueOf(paramBoolean) });
    if (!(paramObject instanceof Boolean))
    {
      AppMethodBeat.o(55125);
      return false;
    }
    paramBoolean = ((Boolean)paramObject).booleanValue();
    AppMethodBeat.o(55125);
    return paramBoolean;
  }
  
  public void destroy(Object paramObject)
  {
    AppMethodBeat.i(55130);
    this.b = null;
    if ((this.a == null) || (paramObject == null))
    {
      AppMethodBeat.o(55130);
      return;
    }
    this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
    AppMethodBeat.o(55130);
  }
  
  public void doCommand(Object paramObject1, Integer paramInteger, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(55129);
    new StringBuilder("doAction actionType:").append(paramInteger).append(" args").append(paramObject2).append(" result").append(paramObject3);
    if (this.a == null)
    {
      AppMethodBeat.o(55129);
      return;
    }
    DexLoader localDexLoader = this.a;
    paramInteger = new Integer(paramInteger.intValue());
    localDexLoader.invokeMethod(paramObject1, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[] { Integer.class, Object.class, Object.class }, new Object[] { paramInteger, paramObject2, paramObject3 });
    AppMethodBeat.o(55129);
  }
  
  public Object getTbsReader()
  {
    AppMethodBeat.i(55123);
    Object localObject = this.a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    AppMethodBeat.o(55123);
    return localObject;
  }
  
  public boolean initTbsReader(Object paramObject, Context paramContext)
  {
    AppMethodBeat.i(55124);
    if ((this.a == null) || (paramObject == null))
    {
      AppMethodBeat.o(55124);
      return false;
    }
    DexLoader localDexLoader1 = this.a;
    DexLoader localDexLoader2 = this.a;
    paramObject = localDexLoader1.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "init", new Class[] { Context.class, DexLoader.class, Object.class }, new Object[] { paramContext, localDexLoader2, this });
    if (!(paramObject instanceof Boolean))
    {
      AppMethodBeat.o(55124);
      return false;
    }
    boolean bool = ((Boolean)paramObject).booleanValue();
    AppMethodBeat.o(55124);
    return bool;
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(55128);
    new StringBuilder("onCallBackAction actionType:").append(paramInteger).append(" args").append(paramObject1).append(" result").append(paramObject2);
    if (this.b != null) {
      this.b.onCallBackAction(paramInteger, paramObject1, paramObject2);
    }
    AppMethodBeat.o(55128);
  }
  
  public void onSizeChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55127);
    if (this.a == null)
    {
      AppMethodBeat.o(55127);
      return;
    }
    this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[] { Integer.class, Integer.class }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(55127);
  }
  
  public boolean openFile(Object paramObject, Context paramContext, Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(55126);
    if (this.a == null)
    {
      AppMethodBeat.o(55126);
      return false;
    }
    paramObject = this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[] { Context.class, Bundle.class, FrameLayout.class }, new Object[] { paramContext, paramBundle, paramFrameLayout });
    if (!(paramObject instanceof Boolean))
    {
      AppMethodBeat.o(55126);
      return false;
    }
    boolean bool = ((Boolean)paramObject).booleanValue();
    AppMethodBeat.o(55126);
    return bool;
  }
  
  public void userStatistics(Object paramObject, String paramString)
  {
    AppMethodBeat.i(55131);
    if (this.a == null)
    {
      AppMethodBeat.o(55131);
      return;
    }
    this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(55131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.ReaderWizard
 * JD-Core Version:    0.7.0.1
 */