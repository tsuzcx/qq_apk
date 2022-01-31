package com.tencent.mm.sdk.platformtools;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
{
  public ArrayMap<String, Object> ymV;
  public boolean ymW;
  
  public s()
  {
    AppMethodBeat.i(115188);
    this.ymV = null;
    this.ymW = false;
    this.ymV = new ArrayMap();
    AppMethodBeat.o(115188);
  }
  
  private static void a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(115189);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" expected ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" but value was a ");
    localStringBuilder.append(paramObject1.getClass().getName());
    localStringBuilder.append(".  The default value ");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(" was returned.");
    ab.w("MicroMsg.ImmutableBundle", localStringBuilder.toString());
    ab.w("MicroMsg.ImmutableBundle", "Attempt to cast generated internal exception:", new Object[] { paramClassCastException });
    AppMethodBeat.o(115189);
  }
  
  public final boolean apb(String paramString)
  {
    AppMethodBeat.i(115190);
    Object localObject = this.ymV.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(115190);
      return false;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(115190);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      a(paramString, localObject, "Boolean", Boolean.FALSE, localClassCastException);
      AppMethodBeat.o(115190);
    }
    return false;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(115191);
    Object localObject = this.ymV.get(paramString);
    try
    {
      String str = (String)localObject;
      AppMethodBeat.o(115191);
      return str;
    }
    catch (ClassCastException localClassCastException)
    {
      a(paramString, localObject, "String", "<null>", localClassCastException);
      AppMethodBeat.o(115191);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.s
 * JD-Core Version:    0.7.0.1
 */