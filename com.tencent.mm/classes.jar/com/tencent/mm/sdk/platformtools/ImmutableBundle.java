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
    AppMethodBeat.i(249358);
    this.mMap = null;
    this.mImmutable = false;
    this.mMap = new ArrayMap(paramArrayMap);
    AppMethodBeat.o(249358);
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(249363);
    boolean bool = this.mMap.containsKey(paramString);
    AppMethodBeat.o(249363);
    return bool;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(249364);
    paramString = this.mMap.get(paramString);
    AppMethodBeat.o(249364);
    return paramString;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(249367);
    boolean bool = getBoolean(paramString, false);
    AppMethodBeat.o(249367);
    return bool;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(249370);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249370);
      return paramBoolean;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(249370);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Boolean", Boolean.valueOf(paramBoolean), localClassCastException);
      AppMethodBeat.o(249370);
    }
    return paramBoolean;
  }
  
  public boolean[] getBooleanArray(String paramString)
  {
    AppMethodBeat.i(249396);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249396);
      return null;
    }
    try
    {
      boolean[] arrayOfBoolean = (boolean[])localObject;
      AppMethodBeat.o(249396);
      return arrayOfBoolean;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "byte[]", localClassCastException);
      AppMethodBeat.o(249396);
    }
    return null;
  }
  
  byte getByte(String paramString)
  {
    AppMethodBeat.i(249371);
    byte b = getByte(paramString, (byte)0).byteValue();
    AppMethodBeat.o(249371);
    return b;
  }
  
  Byte getByte(String paramString, byte paramByte)
  {
    AppMethodBeat.i(249372);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249372);
      return Byte.valueOf(paramByte);
    }
    try
    {
      Byte localByte = (Byte)localObject;
      AppMethodBeat.o(249372);
      return localByte;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Byte", Byte.valueOf(paramByte), localClassCastException);
      AppMethodBeat.o(249372);
    }
    return Byte.valueOf(paramByte);
  }
  
  byte[] getByteArray(String paramString)
  {
    AppMethodBeat.i(249398);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249398);
      return null;
    }
    try
    {
      byte[] arrayOfByte = (byte[])localObject;
      AppMethodBeat.o(249398);
      return arrayOfByte;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "byte[]", localClassCastException);
      AppMethodBeat.o(249398);
    }
    return null;
  }
  
  char getChar(String paramString)
  {
    AppMethodBeat.i(249373);
    char c = getChar(paramString, '\000');
    AppMethodBeat.o(249373);
    return c;
  }
  
  char getChar(String paramString, char paramChar)
  {
    AppMethodBeat.i(249374);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249374);
      return paramChar;
    }
    try
    {
      char c = ((Character)localObject).charValue();
      AppMethodBeat.o(249374);
      return c;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Character", Character.valueOf(paramChar), localClassCastException);
      AppMethodBeat.o(249374);
    }
    return paramChar;
  }
  
  char[] getCharArray(String paramString)
  {
    AppMethodBeat.i(249400);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249400);
      return null;
    }
    try
    {
      char[] arrayOfChar = (char[])localObject;
      AppMethodBeat.o(249400);
      return arrayOfChar;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "char[]", localClassCastException);
      AppMethodBeat.o(249400);
    }
    return null;
  }
  
  CharSequence getCharSequence(String paramString)
  {
    AppMethodBeat.i(249391);
    Object localObject = this.mMap.get(paramString);
    try
    {
      CharSequence localCharSequence = (CharSequence)localObject;
      AppMethodBeat.o(249391);
      return localCharSequence;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "CharSequence", localClassCastException);
      AppMethodBeat.o(249391);
    }
    return null;
  }
  
  CharSequence getCharSequence(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(249392);
    paramString = getCharSequence(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(249392);
      return paramCharSequence;
    }
    AppMethodBeat.o(249392);
    return paramString;
  }
  
  CharSequence[] getCharSequenceArray(String paramString)
  {
    AppMethodBeat.i(249407);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249407);
      return null;
    }
    try
    {
      CharSequence[] arrayOfCharSequence = (CharSequence[])localObject;
      AppMethodBeat.o(249407);
      return arrayOfCharSequence;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "CharSequence[]", localClassCastException);
      AppMethodBeat.o(249407);
    }
    return null;
  }
  
  ArrayList<CharSequence> getCharSequenceArrayList(String paramString)
  {
    AppMethodBeat.i(249395);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249395);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(249395);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<CharSequence>", localClassCastException);
      AppMethodBeat.o(249395);
    }
    return null;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(249387);
    double d = getDouble(paramString, 0.0D);
    AppMethodBeat.o(249387);
    return d;
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(249389);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249389);
      return paramDouble;
    }
    try
    {
      double d = ((Double)localObject).doubleValue();
      AppMethodBeat.o(249389);
      return d;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Double", Double.valueOf(paramDouble), localClassCastException);
      AppMethodBeat.o(249389);
    }
    return paramDouble;
  }
  
  public double[] getDoubleArray(String paramString)
  {
    AppMethodBeat.i(249405);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249405);
      return null;
    }
    try
    {
      double[] arrayOfDouble = (double[])localObject;
      AppMethodBeat.o(249405);
      return arrayOfDouble;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "double[]", localClassCastException);
      AppMethodBeat.o(249405);
    }
    return null;
  }
  
  float getFloat(String paramString)
  {
    AppMethodBeat.i(249385);
    float f = getFloat(paramString, 0.0F);
    AppMethodBeat.o(249385);
    return f;
  }
  
  float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(249386);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249386);
      return paramFloat;
    }
    try
    {
      float f = ((Float)localObject).floatValue();
      AppMethodBeat.o(249386);
      return f;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Float", Float.valueOf(paramFloat), localClassCastException);
      AppMethodBeat.o(249386);
    }
    return paramFloat;
  }
  
  float[] getFloatArray(String paramString)
  {
    AppMethodBeat.i(249403);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249403);
      return null;
    }
    try
    {
      float[] arrayOfFloat = (float[])localObject;
      AppMethodBeat.o(249403);
      return arrayOfFloat;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "float[]", localClassCastException);
      AppMethodBeat.o(249403);
    }
    return null;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(249381);
    int i = getInt(paramString, 0);
    AppMethodBeat.o(249381);
    return i;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(249382);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249382);
      return paramInt;
    }
    try
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(249382);
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Integer", Integer.valueOf(paramInt), localClassCastException);
      AppMethodBeat.o(249382);
    }
    return paramInt;
  }
  
  public int[] getIntArray(String paramString)
  {
    AppMethodBeat.i(249401);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249401);
      return null;
    }
    try
    {
      int[] arrayOfInt = (int[])localObject;
      AppMethodBeat.o(249401);
      return arrayOfInt;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "int[]", localClassCastException);
      AppMethodBeat.o(249401);
    }
    return null;
  }
  
  ArrayList<Integer> getIntegerArrayList(String paramString)
  {
    AppMethodBeat.i(249393);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249393);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(249393);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<Integer>", localClassCastException);
      AppMethodBeat.o(249393);
    }
    return null;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(249383);
    long l = getLong(paramString, 0L);
    AppMethodBeat.o(249383);
    return l;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(249384);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249384);
      return paramLong;
    }
    try
    {
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(249384);
      return l;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Long", Long.valueOf(paramLong), localClassCastException);
      AppMethodBeat.o(249384);
    }
    return paramLong;
  }
  
  public long[] getLongArray(String paramString)
  {
    AppMethodBeat.i(249402);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249402);
      return null;
    }
    try
    {
      long[] arrayOfLong = (long[])localObject;
      AppMethodBeat.o(249402);
      return arrayOfLong;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "long[]", localClassCastException);
      AppMethodBeat.o(249402);
    }
    return null;
  }
  
  short getShort(String paramString)
  {
    AppMethodBeat.i(249376);
    short s = getShort(paramString, (short)0);
    AppMethodBeat.o(249376);
    return s;
  }
  
  short getShort(String paramString, short paramShort)
  {
    AppMethodBeat.i(249377);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249377);
      return paramShort;
    }
    try
    {
      short s = ((Short)localObject).shortValue();
      AppMethodBeat.o(249377);
      return s;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Short", Short.valueOf(paramShort), localClassCastException);
      AppMethodBeat.o(249377);
    }
    return paramShort;
  }
  
  short[] getShortArray(String paramString)
  {
    AppMethodBeat.i(249399);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249399);
      return null;
    }
    try
    {
      short[] arrayOfShort = (short[])localObject;
      AppMethodBeat.o(249399);
      return arrayOfShort;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "short[]", localClassCastException);
      AppMethodBeat.o(249399);
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
    AppMethodBeat.i(249390);
    paramString1 = getString(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(249390);
      return paramString2;
    }
    AppMethodBeat.o(249390);
    return paramString1;
  }
  
  public String[] getStringArray(String paramString)
  {
    AppMethodBeat.i(249406);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249406);
      return null;
    }
    try
    {
      String[] arrayOfString = (String[])localObject;
      AppMethodBeat.o(249406);
      return arrayOfString;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "String[]", localClassCastException);
      AppMethodBeat.o(249406);
    }
    return null;
  }
  
  ArrayList<String> getStringArrayList(String paramString)
  {
    AppMethodBeat.i(249394);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(249394);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(249394);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<String>", localClassCastException);
      AppMethodBeat.o(249394);
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(249362);
    boolean bool = this.mMap.isEmpty();
    AppMethodBeat.o(249362);
    return bool;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(249365);
    Set localSet = this.mMap.keySet();
    AppMethodBeat.o(249365);
    return localSet;
  }
  
  public void markImmutable()
  {
    this.mImmutable = true;
  }
  
  public void putAll(ArrayMap paramArrayMap)
  {
    AppMethodBeat.i(249359);
    if (this.mImmutable)
    {
      AppMethodBeat.o(249359);
      return;
    }
    this.mMap.putAll(paramArrayMap);
    AppMethodBeat.o(249359);
  }
  
  public int size()
  {
    AppMethodBeat.i(249361);
    int i = this.mMap.size();
    AppMethodBeat.o(249361);
    return i;
  }
  
  void typeWarning(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(249369);
    typeWarning(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
    AppMethodBeat.o(249369);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ImmutableBundle
 * JD-Core Version:    0.7.0.1
 */