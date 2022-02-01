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
    AppMethodBeat.i(243908);
    this.mMap = null;
    this.mImmutable = false;
    this.mMap = new ArrayMap(paramArrayMap);
    AppMethodBeat.o(243908);
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(243946);
    boolean bool = this.mMap.containsKey(paramString);
    AppMethodBeat.o(243946);
    return bool;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(243951);
    paramString = this.mMap.get(paramString);
    AppMethodBeat.o(243951);
    return paramString;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(243961);
    boolean bool = getBoolean(paramString, false);
    AppMethodBeat.o(243961);
    return bool;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(243979);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(243979);
      return paramBoolean;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(243979);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Boolean", Boolean.valueOf(paramBoolean), localClassCastException);
      AppMethodBeat.o(243979);
    }
    return paramBoolean;
  }
  
  public boolean[] getBooleanArray(String paramString)
  {
    AppMethodBeat.i(244095);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244095);
      return null;
    }
    try
    {
      boolean[] arrayOfBoolean = (boolean[])localObject;
      AppMethodBeat.o(244095);
      return arrayOfBoolean;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "byte[]", localClassCastException);
      AppMethodBeat.o(244095);
    }
    return null;
  }
  
  byte getByte(String paramString)
  {
    AppMethodBeat.i(243986);
    byte b = getByte(paramString, (byte)0).byteValue();
    AppMethodBeat.o(243986);
    return b;
  }
  
  Byte getByte(String paramString, byte paramByte)
  {
    AppMethodBeat.i(243996);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(243996);
      return Byte.valueOf(paramByte);
    }
    try
    {
      Byte localByte = (Byte)localObject;
      AppMethodBeat.o(243996);
      return localByte;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Byte", Byte.valueOf(paramByte), localClassCastException);
      AppMethodBeat.o(243996);
    }
    return Byte.valueOf(paramByte);
  }
  
  byte[] getByteArray(String paramString)
  {
    AppMethodBeat.i(244100);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244100);
      return null;
    }
    try
    {
      byte[] arrayOfByte = (byte[])localObject;
      AppMethodBeat.o(244100);
      return arrayOfByte;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "byte[]", localClassCastException);
      AppMethodBeat.o(244100);
    }
    return null;
  }
  
  char getChar(String paramString)
  {
    AppMethodBeat.i(244002);
    char c = getChar(paramString, '\000');
    AppMethodBeat.o(244002);
    return c;
  }
  
  char getChar(String paramString, char paramChar)
  {
    AppMethodBeat.i(244007);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244007);
      return paramChar;
    }
    try
    {
      char c = ((Character)localObject).charValue();
      AppMethodBeat.o(244007);
      return c;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Character", Character.valueOf(paramChar), localClassCastException);
      AppMethodBeat.o(244007);
    }
    return paramChar;
  }
  
  char[] getCharArray(String paramString)
  {
    AppMethodBeat.i(244110);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244110);
      return null;
    }
    try
    {
      char[] arrayOfChar = (char[])localObject;
      AppMethodBeat.o(244110);
      return arrayOfChar;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "char[]", localClassCastException);
      AppMethodBeat.o(244110);
    }
    return null;
  }
  
  CharSequence getCharSequence(String paramString)
  {
    AppMethodBeat.i(244077);
    Object localObject = this.mMap.get(paramString);
    try
    {
      CharSequence localCharSequence = (CharSequence)localObject;
      AppMethodBeat.o(244077);
      return localCharSequence;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "CharSequence", localClassCastException);
      AppMethodBeat.o(244077);
    }
    return null;
  }
  
  CharSequence getCharSequence(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(244080);
    paramString = getCharSequence(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(244080);
      return paramCharSequence;
    }
    AppMethodBeat.o(244080);
    return paramString;
  }
  
  CharSequence[] getCharSequenceArray(String paramString)
  {
    AppMethodBeat.i(244134);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244134);
      return null;
    }
    try
    {
      CharSequence[] arrayOfCharSequence = (CharSequence[])localObject;
      AppMethodBeat.o(244134);
      return arrayOfCharSequence;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "CharSequence[]", localClassCastException);
      AppMethodBeat.o(244134);
    }
    return null;
  }
  
  ArrayList<CharSequence> getCharSequenceArrayList(String paramString)
  {
    AppMethodBeat.i(244089);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244089);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(244089);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<CharSequence>", localClassCastException);
      AppMethodBeat.o(244089);
    }
    return null;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(244053);
    double d = getDouble(paramString, 0.0D);
    AppMethodBeat.o(244053);
    return d;
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(244058);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244058);
      return paramDouble;
    }
    try
    {
      double d = ((Double)localObject).doubleValue();
      AppMethodBeat.o(244058);
      return d;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Double", Double.valueOf(paramDouble), localClassCastException);
      AppMethodBeat.o(244058);
    }
    return paramDouble;
  }
  
  public double[] getDoubleArray(String paramString)
  {
    AppMethodBeat.i(244129);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244129);
      return null;
    }
    try
    {
      double[] arrayOfDouble = (double[])localObject;
      AppMethodBeat.o(244129);
      return arrayOfDouble;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "double[]", localClassCastException);
      AppMethodBeat.o(244129);
    }
    return null;
  }
  
  float getFloat(String paramString)
  {
    AppMethodBeat.i(244047);
    float f = getFloat(paramString, 0.0F);
    AppMethodBeat.o(244047);
    return f;
  }
  
  float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(244050);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244050);
      return paramFloat;
    }
    try
    {
      float f = ((Float)localObject).floatValue();
      AppMethodBeat.o(244050);
      return f;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Float", Float.valueOf(paramFloat), localClassCastException);
      AppMethodBeat.o(244050);
    }
    return paramFloat;
  }
  
  float[] getFloatArray(String paramString)
  {
    AppMethodBeat.i(244124);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244124);
      return null;
    }
    try
    {
      float[] arrayOfFloat = (float[])localObject;
      AppMethodBeat.o(244124);
      return arrayOfFloat;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "float[]", localClassCastException);
      AppMethodBeat.o(244124);
    }
    return null;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(244026);
    int i = getInt(paramString, 0);
    AppMethodBeat.o(244026);
    return i;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(244035);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244035);
      return paramInt;
    }
    try
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(244035);
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Integer", Integer.valueOf(paramInt), localClassCastException);
      AppMethodBeat.o(244035);
    }
    return paramInt;
  }
  
  public int[] getIntArray(String paramString)
  {
    AppMethodBeat.i(244115);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244115);
      return null;
    }
    try
    {
      int[] arrayOfInt = (int[])localObject;
      AppMethodBeat.o(244115);
      return arrayOfInt;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "int[]", localClassCastException);
      AppMethodBeat.o(244115);
    }
    return null;
  }
  
  ArrayList<Integer> getIntegerArrayList(String paramString)
  {
    AppMethodBeat.i(244083);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244083);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(244083);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<Integer>", localClassCastException);
      AppMethodBeat.o(244083);
    }
    return null;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(244039);
    long l = getLong(paramString, 0L);
    AppMethodBeat.o(244039);
    return l;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(244046);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244046);
      return paramLong;
    }
    try
    {
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(244046);
      return l;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Long", Long.valueOf(paramLong), localClassCastException);
      AppMethodBeat.o(244046);
    }
    return paramLong;
  }
  
  public long[] getLongArray(String paramString)
  {
    AppMethodBeat.i(244120);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244120);
      return null;
    }
    try
    {
      long[] arrayOfLong = (long[])localObject;
      AppMethodBeat.o(244120);
      return arrayOfLong;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "long[]", localClassCastException);
      AppMethodBeat.o(244120);
    }
    return null;
  }
  
  short getShort(String paramString)
  {
    AppMethodBeat.i(244015);
    short s = getShort(paramString, (short)0);
    AppMethodBeat.o(244015);
    return s;
  }
  
  short getShort(String paramString, short paramShort)
  {
    AppMethodBeat.i(244021);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244021);
      return paramShort;
    }
    try
    {
      short s = ((Short)localObject).shortValue();
      AppMethodBeat.o(244021);
      return s;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "Short", Short.valueOf(paramShort), localClassCastException);
      AppMethodBeat.o(244021);
    }
    return paramShort;
  }
  
  short[] getShortArray(String paramString)
  {
    AppMethodBeat.i(244103);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244103);
      return null;
    }
    try
    {
      short[] arrayOfShort = (short[])localObject;
      AppMethodBeat.o(244103);
      return arrayOfShort;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "short[]", localClassCastException);
      AppMethodBeat.o(244103);
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
    AppMethodBeat.i(244072);
    paramString1 = getString(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(244072);
      return paramString2;
    }
    AppMethodBeat.o(244072);
    return paramString1;
  }
  
  public String[] getStringArray(String paramString)
  {
    AppMethodBeat.i(244131);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244131);
      return null;
    }
    try
    {
      String[] arrayOfString = (String[])localObject;
      AppMethodBeat.o(244131);
      return arrayOfString;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "String[]", localClassCastException);
      AppMethodBeat.o(244131);
    }
    return null;
  }
  
  ArrayList<String> getStringArrayList(String paramString)
  {
    AppMethodBeat.i(244086);
    Object localObject = this.mMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(244086);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(244086);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      typeWarning(paramString, localObject, "ArrayList<String>", localClassCastException);
      AppMethodBeat.o(244086);
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(243940);
    boolean bool = this.mMap.isEmpty();
    AppMethodBeat.o(243940);
    return bool;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(243955);
    Set localSet = this.mMap.keySet();
    AppMethodBeat.o(243955);
    return localSet;
  }
  
  public void markImmutable()
  {
    this.mImmutable = true;
  }
  
  public void putAll(ArrayMap paramArrayMap)
  {
    AppMethodBeat.i(243921);
    if (this.mImmutable)
    {
      AppMethodBeat.o(243921);
      return;
    }
    this.mMap.putAll(paramArrayMap);
    AppMethodBeat.o(243921);
  }
  
  public int size()
  {
    AppMethodBeat.i(243934);
    int i = this.mMap.size();
    AppMethodBeat.o(243934);
    return i;
  }
  
  void typeWarning(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(243974);
    typeWarning(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
    AppMethodBeat.o(243974);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ImmutableBundle
 * JD-Core Version:    0.7.0.1
 */