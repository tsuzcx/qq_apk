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
    AppMethodBeat.i(52853);
    INSTANCE = new SQLiteLintAndroidCoreManager("INSTANCE", 0);
    $VALUES = new SQLiteLintAndroidCoreManager[] { INSTANCE };
    AppMethodBeat.o(52853);
  }
  
  private SQLiteLintAndroidCoreManager()
  {
    AppMethodBeat.i(52847);
    this.mCoresMap = new ConcurrentHashMap();
    AppMethodBeat.o(52847);
  }
  
  public final void addBehavior(BaseBehaviour paramBaseBehaviour, String paramString)
  {
    AppMethodBeat.i(52849);
    if (get(paramString) == null)
    {
      AppMethodBeat.o(52849);
      return;
    }
    get(paramString).addBehavior(paramBaseBehaviour);
    AppMethodBeat.o(52849);
  }
  
  public final SQLiteLintAndroidCore get(String paramString)
  {
    AppMethodBeat.i(52851);
    paramString = (SQLiteLintAndroidCore)this.mCoresMap.get(paramString);
    AppMethodBeat.o(52851);
    return paramString;
  }
  
  public final void install(Context paramContext, SQLiteLint.InstallEnv paramInstallEnv, SQLiteLint.Options paramOptions)
  {
    AppMethodBeat.i(52848);
    String str = paramInstallEnv.getConcernedDbPath();
    if (this.mCoresMap.containsKey(str))
    {
      SLog.w("SQLiteLint.SQLiteLintAndroidCoreManager", "install twice!! ignore", new Object[0]);
      AppMethodBeat.o(52848);
      return;
    }
    paramContext = new SQLiteLintAndroidCore(paramContext, paramInstallEnv, paramOptions);
    this.mCoresMap.put(str, paramContext);
    AppMethodBeat.o(52848);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(52852);
    this.mCoresMap.remove(paramString);
    AppMethodBeat.o(52852);
  }
  
  public final void removeBehavior(BaseBehaviour paramBaseBehaviour, String paramString)
  {
    AppMethodBeat.i(52850);
    if (get(paramString) == null)
    {
      AppMethodBeat.o(52850);
      return;
    }
    get(paramString).removeBehavior(paramBaseBehaviour);
    AppMethodBeat.o(52850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLintAndroidCoreManager
 * JD-Core Version:    0.7.0.1
 */