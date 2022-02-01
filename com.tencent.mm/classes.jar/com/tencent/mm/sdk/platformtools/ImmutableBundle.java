package com.tencent.mm.sdk.platformtools;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;

public class ImmutableBundle
{
  private static final String TAG = "MicroMsg.ImmutableBundle";
  private boolean mImmutable;
  ArrayMap<String, Object> mMap;
  
  public ImmutableBundle()
  {
    AppMethodBeat.i(125223);
    this.mMap = null;
    this.mImmutable = false;
    this.mMap = new ArrayMap();
    AppMethodBeat.o(125223);
  }
  
  public ImmutableBundle(ArrayMap<String, Object> paramArrayMap)
  {
    AppMethodBeat.i(200846);
    this.mMap = null;
    this.mImmutable = false;
    this.mMap = new ArrayMap(paramArrayMap);
    AppMethodBeat.o(200846);
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(200850);
    boolean bool = this.mMap.containsKey(paramString);
    AppMethodBeat.o(200850);
    return bool;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(200851);
    paramString = this.mMap.get(paramString);
    AppMethodBeat.o(200851);
    return paramString;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(200853);
    boolean bool = getBoolean(paramString, false);
    AppMethodBeat.o(200853);
    return bool;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(200855);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200855);
      return paramBoolean;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(200855);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Boolean", Boolean.valueOf(paramBoolean), localClassCastException);
      AppMethodBeat.o(200855);
    }
    return paramBoolean;
  }
  
  public boolean[] getBooleanArray(String paramString)
  {
    AppMethodBeat.i(200876);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200876);
      return null;
    }
    try
    {
      boolean[] arrayOfBoolean = (boolean[])localObject;
      AppMethodBeat.o(200876);
      return arrayOfBoolean;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "byte[]", localClassCastException);
      AppMethodBeat.o(200876);
    }
    return null;
  }
  
  byte getByte(String paramString)
  {
    AppMethodBeat.i(200856);
    byte b = getByte(paramString, (byte)0).byteValue();
    AppMethodBeat.o(200856);
    return b;
  }
  
  Byte getByte(String paramString, byte paramByte)
  {
    AppMethodBeat.i(200857);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200857);
      return Byte.valueOf(paramByte);
    }
    try
    {
      Byte localByte = (Byte)localObject;
      AppMethodBeat.o(200857);
      return localByte;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Byte", Byte.valueOf(paramByte), localClassCastException);
      AppMethodBeat.o(200857);
    }
    return Byte.valueOf(paramByte);
  }
  
  byte[] getByteArray(String paramString)
  {
    AppMethodBeat.i(200877);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200877);
      return null;
    }
    try
    {
      byte[] arrayOfByte = (byte[])localObject;
      AppMethodBeat.o(200877);
      return arrayOfByte;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "byte[]", localClassCastException);
      AppMethodBeat.o(200877);
    }
    return null;
  }
  
  char getChar(String paramString)
  {
    AppMethodBeat.i(200858);
    char c = getChar(paramString, '\000');
    AppMethodBeat.o(200858);
    return c;
  }
  
  char getChar(String paramString, char paramChar)
  {
    AppMethodBeat.i(200859);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200859);
      return paramChar;
    }
    try
    {
      char c = ((Character)localObject).charValue();
      AppMethodBeat.o(200859);
      return c;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Character", Character.valueOf(paramChar), localClassCastException);
      AppMethodBeat.o(200859);
    }
    return paramChar;
  }
  
  char[] getCharArray(String paramString)
  {
    AppMethodBeat.i(200879);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200879);
      return null;
    }
    try
    {
      char[] arrayOfChar = (char[])localObject;
      AppMethodBeat.o(200879);
      return arrayOfChar;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "char[]", localClassCastException);
      AppMethodBeat.o(200879);
    }
    return null;
  }
  
  CharSequence getCharSequence(String paramString)
  {
    AppMethodBeat.i(200871);
    Object localObject = this.mMap.get(paramString);
    try
    {
      CharSequence localCharSequence = (CharSequence)localObject;
      AppMethodBeat.o(200871);
      return localCharSequence;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "CharSequence", localClassCastException);
      AppMethodBeat.o(200871);
    }
    return null;
  }
  
  CharSequence getCharSequence(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200872);
    paramString = getCharSequence(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(200872);
      return paramCharSequence;
    }
    AppMethodBeat.o(200872);
    return paramString;
  }
  
  CharSequence[] getCharSequenceArray(String paramString)
  {
    AppMethodBeat.i(200885);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200885);
      return null;
    }
    try
    {
      CharSequence[] arrayOfCharSequence = (CharSequence[])localObject;
      AppMethodBeat.o(200885);
      return arrayOfCharSequence;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "CharSequence[]", localClassCastException);
      AppMethodBeat.o(200885);
    }
    return null;
  }
  
  ArrayList<CharSequence> getCharSequenceArrayList(String paramString)
  {
    AppMethodBeat.i(200875);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200875);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(200875);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<CharSequence>", localClassCastException);
      AppMethodBeat.o(200875);
    }
    return null;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(200868);
    double d = getDouble(paramString, 0.0D);
    AppMethodBeat.o(200868);
    return d;
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(200869);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200869);
      return paramDouble;
    }
    try
    {
      double d = ((Double)localObject).doubleValue();
      AppMethodBeat.o(200869);
      return d;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Double", Double.valueOf(paramDouble), localClassCastException);
      AppMethodBeat.o(200869);
    }
    return paramDouble;
  }
  
  public double[] getDoubleArray(String paramString)
  {
    AppMethodBeat.i(200883);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200883);
      return null;
    }
    try
    {
      double[] arrayOfDouble = (double[])localObject;
      AppMethodBeat.o(200883);
      return arrayOfDouble;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "double[]", localClassCastException);
      AppMethodBeat.o(200883);
    }
    return null;
  }
  
  float getFloat(String paramString)
  {
    AppMethodBeat.i(200866);
    float f = getFloat(paramString, 0.0F);
    AppMethodBeat.o(200866);
    return f;
  }
  
  float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(200867);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200867);
      return paramFloat;
    }
    try
    {
      float f = ((Float)localObject).floatValue();
      AppMethodBeat.o(200867);
      return f;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Float", Float.valueOf(paramFloat), localClassCastException);
      AppMethodBeat.o(200867);
    }
    return paramFloat;
  }
  
  float[] getFloatArray(String paramString)
  {
    AppMethodBeat.i(200882);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200882);
      return null;
    }
    try
    {
      float[] arrayOfFloat = (float[])localObject;
      AppMethodBeat.o(200882);
      return arrayOfFloat;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "float[]", localClassCastException);
      AppMethodBeat.o(200882);
    }
    return null;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(200862);
    int i = getInt(paramString, 0);
    AppMethodBeat.o(200862);
    return i;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(200863);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200863);
      return paramInt;
    }
    try
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(200863);
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Integer", Integer.valueOf(paramInt), localClassCastException);
      AppMethodBeat.o(200863);
    }
    return paramInt;
  }
  
  public int[] getIntArray(String paramString)
  {
    AppMethodBeat.i(200880);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200880);
      return null;
    }
    try
    {
      int[] arrayOfInt = (int[])localObject;
      AppMethodBeat.o(200880);
      return arrayOfInt;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "int[]", localClassCastException);
      AppMethodBeat.o(200880);
    }
    return null;
  }
  
  ArrayList<Integer> getIntegerArrayList(String paramString)
  {
    AppMethodBeat.i(200873);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200873);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(200873);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<Integer>", localClassCastException);
      AppMethodBeat.o(200873);
    }
    return null;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(200864);
    long l = getLong(paramString, 0L);
    AppMethodBeat.o(200864);
    return l;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(200865);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200865);
      return paramLong;
    }
    try
    {
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(200865);
      return l;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Long", Long.valueOf(paramLong), localClassCastException);
      AppMethodBeat.o(200865);
    }
    return paramLong;
  }
  
  public long[] getLongArray(String paramString)
  {
    AppMethodBeat.i(200881);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200881);
      return null;
    }
    try
    {
      long[] arrayOfLong = (long[])localObject;
      AppMethodBeat.o(200881);
      return arrayOfLong;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "long[]", localClassCastException);
      AppMethodBeat.o(200881);
    }
    return null;
  }
  
  short getShort(String paramString)
  {
    AppMethodBeat.i(200860);
    short s = getShort(paramString, (short)0);
    AppMethodBeat.o(200860);
    return s;
  }
  
  short getShort(String paramString, short paramShort)
  {
    AppMethodBeat.i(200861);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200861);
      return paramShort;
    }
    try
    {
      short s = ((Short)localObject).shortValue();
      AppMethodBeat.o(200861);
      return s;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Short", Short.valueOf(paramShort), localClassCastException);
      AppMethodBeat.o(200861);
    }
    return paramShort;
  }
  
  short[] getShortArray(String paramString)
  {
    AppMethodBeat.i(200878);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200878);
      return null;
    }
    try
    {
      short[] arrayOfShort = (short[])localObject;
      AppMethodBeat.o(200878);
      return arrayOfShort;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "short[]", localClassCastException);
      AppMethodBeat.o(200878);
    }
    return null;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(125226);
    Object localObject = this.mMap.get(paramString);
    try
    {
      String str = (String)localObject;
      AppMethodBeat.o(125226);
      return str;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "String", localClassCastException);
      AppMethodBeat.o(125226);
    }
    return null;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200870);
    paramString1 = getString(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(200870);
      return paramString2;
    }
    AppMethodBeat.o(200870);
    return paramString1;
  }
  
  public String[] getStringArray(String paramString)
  {
    AppMethodBeat.i(200884);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200884);
      return null;
    }
    try
    {
      String[] arrayOfString = (String[])localObject;
      AppMethodBeat.o(200884);
      return arrayOfString;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "String[]", localClassCastException);
      AppMethodBeat.o(200884);
    }
    return null;
  }
  
  ArrayList<String> getStringArrayList(String paramString)
  {
    AppMethodBeat.i(200874);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(200874);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(200874);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<String>", localClassCastException);
      AppMethodBeat.o(200874);
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(200849);
    boolean bool = this.mMap.isEmpty();
    AppMethodBeat.o(200849);
    return bool;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(200852);
    Set localSet = this.mMap.keySet();
    AppMethodBeat.o(200852);
    return localSet;
  }
  
  public void markImmutable()
  {
    this.mImmutable = true;
  }
  
  public void putAll(ArrayMap paramArrayMap)
  {
    AppMethodBeat.i(200847);
    if (this.mImmutable)
    {
      AppMethodBeat.o(200847);
      return;
    }
    this.mMap.putAll(paramArrayMap);
    AppMethodBeat.o(200847);
  }
  
  public int size()
  {
    AppMethodBeat.i(200848);
    int i = this.mMap.size();
    AppMethodBeat.o(200848);
    return i;
  }
  
  void typeWarning(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(200854);
    typeWarning(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
    AppMethodBeat.o(200854);
  }
  
  void typeWarning(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
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
    Log.w("MicroMsg.ImmutableBundle", localStringBuilder.toString());
    Log.w("MicroMsg.ImmutableBundle", "Attempt to cast generated internal exception:", new Object[] { paramClassCastException });
    AppMethodBeat.o(125224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ImmutableBundle
 * JD-Core Version:    0.7.0.1
 */