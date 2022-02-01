package com.tencent.mm.sdk.platformtools;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
{
  public ArrayMap<String, Object> ETM;
  public boolean ETN;
  
  public u()
  {
    AppMethodBeat.i(125223);
    this.ETM = null;
    this.ETN = false;
    this.ETM = new ArrayMap();
    AppMethodBeat.o(125223);
  }
  
  private static void a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(125224);
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
    ad.w("MicroMsg.ImmutableBundle", localStringBuilder.toString());
    ad.w("MicroMsg.ImmutableBundle", "Attempt to cast generated internal exception:", new Object[] { paramClassCastException });
    AppMethodBeat.o(125224);
  }
  
  public final boolean aFp(String paramString)
  {
    AppMethodBeat.i(125225);
    Object localObject = this.ETM.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(125225);
      return false;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(125225);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      a(paramString, localObject, "Boolean", Boolean.FALSE, localClassCastException);
      AppMethodBeat.o(125225);
    }
    return false;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(125226);
    Object localObject = this.ETM.get(paramString);
    try
    {
      String str = (String)localObject;
      AppMethodBeat.o(125226);
      return str;
    }
    catch (ClassCastException localClassCastException)
    {
      a(paramString, localObject, "String", "<null>", localClassCastException);
      AppMethodBeat.o(125226);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.u
 * JD-Core Version:    0.7.0.1
 */