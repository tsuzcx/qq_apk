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
    AppMethodBeat.i(188536);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(188536);
  }
  
  public void clearHttpAuthUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(188540);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(188540);
  }
  
  public void clearUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(188538);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(188538);
  }
  
  public boolean hasFormData(Context paramContext)
  {
    AppMethodBeat.i(188541);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(188541);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(188541);
    return bool;
  }
  
  public boolean hasHttpAuthUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(188539);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(188539);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(188539);
    return bool;
  }
  
  public boolean hasUsernamePassword(Context paramContext)
  {
    AppMethodBeat.i(188537);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(188537);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(188537);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.i
 * JD-Core Version:    0.7.0.1
 */