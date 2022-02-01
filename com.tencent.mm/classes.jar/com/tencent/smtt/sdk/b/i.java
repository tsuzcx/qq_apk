package com.tencent.smtt.sdk.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB;

public class i
  implements IX5CoreWebViewDB
{
  private DexLoader a;
  
  i(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public void clearFormData(Context paramContext)
  {
    AppMethodBeat.i(192900);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(192900);
  }
  
  public void clearHttpAuthUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(192904);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(192904);
  }
  
  public void clearUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(192902);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(192902);
  }
  
  public boolean hasFormData(Context paramContext)
  {
    AppMethodBeat.i(192905);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(192905);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(192905);
    return bool;
  }
  
  public boolean hasHttpAuthUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(192903);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(192903);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(192903);
    return bool;
  }
  
  public boolean hasUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(192901);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(192901);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(192901);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.i
 * JD-Core Version:    0.7.0.1
 */