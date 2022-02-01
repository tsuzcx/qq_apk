package com.tencent.smtt.sdk.a;

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
    AppMethodBeat.i(54830);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(54830);
  }
  
  public void clearHttpAuthUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(54834);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(54834);
  }
  
  public void clearUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(54832);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(54832);
  }
  
  public boolean hasFormData(Context paramContext)
  {
    AppMethodBeat.i(54835);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(54835);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(54835);
    return bool;
  }
  
  public boolean hasHttpAuthUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(54833);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(54833);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(54833);
    return bool;
  }
  
  public boolean hasUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(54831);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(54831);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(54831);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.i
 * JD-Core Version:    0.7.0.1
 */