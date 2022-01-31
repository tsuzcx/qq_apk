package com.tencent.sqlitelint;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.util.SLog;
import java.util.concurrent.ConcurrentHashMap;

public enum SQLiteLintAndroidCoreManager
{
  private static final String TAG = "SQLiteLint.SQLiteLintAndroidCoreManager";
  private ConcurrentHashMap<String, SQLiteLintAndroidCore> mCoresMap;
  
  static
  {
    AppMethodBeat.i(94009);
    INSTANCE = new SQLiteLintAndroidCoreManager("INSTANCE", 0);
    $VALUES = new SQLiteLintAndroidCoreManager[] { INSTANCE };
    AppMethodBeat.o(94009);
  }
  
  private SQLiteLintAndroidCoreManager()
  {
    AppMethodBeat.i(94003);
    this.mCoresMap = new ConcurrentHashMap();
    AppMethodBeat.o(94003);
  }
  
  public final void addBehavior(BaseBehaviour paramBaseBehaviour, String paramString)
  {
    AppMethodBeat.i(94005);
    if (get(paramString) == null)
    {
      AppMethodBeat.o(94005);
      return;
    }
    get(paramString).addBehavior(paramBaseBehaviour);
    AppMethodBeat.o(94005);
  }
  
  public final SQLiteLintAndroidCore get(String paramString)
  {
    AppMethodBeat.i(94007);
    paramString = (SQLiteLintAndroidCore)this.mCoresMap.get(paramString);
    AppMethodBeat.o(94007);
    return paramString;
  }
  
  public final void install(Context paramContext, SQLiteLint.InstallEnv paramInstallEnv, SQLiteLint.Options paramOptions)
  {
    AppMethodBeat.i(94004);
    String str = paramInstallEnv.getConcernedDbPath();
    if (this.mCoresMap.containsKey(str))
    {
      SLog.w("SQLiteLint.SQLiteLintAndroidCoreManager", "install twice!! ignore", new Object[0]);
      AppMethodBeat.o(94004);
      return;
    }
    paramContext = new SQLiteLintAndroidCore(paramContext, paramInstallEnv, paramOptions);
    this.mCoresMap.put(str, paramContext);
    AppMethodBeat.o(94004);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(94008);
    this.mCoresMap.remove(paramString);
    AppMethodBeat.o(94008);
  }
  
  public final void removeBehavior(BaseBehaviour paramBaseBehaviour, String paramString)
  {
    AppMethodBeat.i(94006);
    if (get(paramString) == null)
    {
      AppMethodBeat.o(94006);
      return;
    }
    get(paramString).removeBehavior(paramBaseBehaviour);
    AppMethodBeat.o(94006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLintAndroidCoreManager
 * JD-Core Version:    0.7.0.1
 */