package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class dh
{
  private static int a(String paramString, dl[] paramArrayOfdl)
  {
    int m = paramArrayOfdl.length;
    int j = 0;
    int i = 14;
    if (j < m)
    {
      dl localdl = paramArrayOfdl[j];
      int k;
      if (i == 14) {
        if ((localdl.type == 9) || (localdl.type == 2) || (localdl.type == 6)) {
          k = localdl.type;
        }
      }
      do
      {
        do
        {
          j += 1;
          i = k;
          break;
          k = i;
        } while (localdl.type == 14);
        i = localdl.type;
        throw new IllegalArgumentException(String.valueOf(paramString).length() + 48 + "Unexpected TypedValue type: " + i + " for key " + paramString);
        k = i;
      } while (localdl.type == i);
      j = localdl.type;
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 126 + "The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + i + " and " + j);
    }
    return i;
  }
  
  public static di a(n paramn)
  {
    dj localdj = new dj();
    ArrayList localArrayList = new ArrayList();
    localdj.SD = a(paramn, localArrayList);
    return new di(localdj, localArrayList);
  }
  
  private static dl a(List<Asset> paramList, Object paramObject)
  {
    dl localdl1 = new dl();
    if (paramObject == null)
    {
      localdl1.type = 14;
      return localdl1;
    }
    localdl1.SH = new dm();
    if ((paramObject instanceof String))
    {
      localdl1.type = 2;
      localdl1.SH.SJ = ((String)paramObject);
    }
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    for (;;)
    {
      return localdl1;
      if ((paramObject instanceof Integer))
      {
        localdl1.type = 6;
        localdl1.SH.SN = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        localdl1.type = 5;
        localdl1.SH.SM = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        localdl1.type = 3;
        localdl1.SH.SK = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        localdl1.type = 4;
        localdl1.SH.SL = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        localdl1.type = 8;
        localdl1.SH.SP = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        localdl1.type = 7;
        localdl1.SH.SO = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        localdl1.type = 1;
        localdl1.SH.SI = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        localdl1.type = 11;
        localdl1.SH.SS = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        localdl1.type = 12;
        localdl1.SH.ST = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        localdl1.type = 15;
        localdl1.SH.SU = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        localdl1.type = 13;
        localObject1 = localdl1.SH;
        paramList.add((Asset)paramObject);
        ((dm)localObject1).SV = (paramList.size() - 1);
      }
      else
      {
        if (!(paramObject instanceof n)) {
          break;
        }
        localdl1.type = 9;
        paramObject = (n)paramObject;
        localObject2 = new TreeSet(paramObject.keySet());
        localObject1 = new dk[((TreeSet)localObject2).size()];
        localObject2 = ((TreeSet)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1[i] = new dk();
          localObject1[i].name = ((String)localObject3);
          localObject1[i].SF = a(paramList, paramObject.get((String)localObject3));
          i += 1;
        }
        localdl1.SH.SQ = ((dk[])localObject1);
      }
    }
    int j;
    label590:
    dl localdl2;
    if ((paramObject instanceof ArrayList))
    {
      localdl1.type = 10;
      localObject2 = (ArrayList)paramObject;
      localObject3 = new dl[((ArrayList)localObject2).size()];
      paramObject = null;
      int k = ((ArrayList)localObject2).size();
      i = 0;
      j = 14;
      if (i < k)
      {
        localObject1 = ((ArrayList)localObject2).get(i);
        localdl2 = a(paramList, localObject1);
        if ((localdl2.type != 14) && (localdl2.type != 2) && (localdl2.type != 6) && (localdl2.type != 9))
        {
          paramList = String.valueOf(localObject1.getClass());
          throw new IllegalArgumentException(String.valueOf(paramList).length() + 130 + "The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + paramList);
        }
        if ((j == 14) && (localdl2.type != 14))
        {
          j = localdl2.type;
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      localObject3[i] = localdl2;
      i += 1;
      break label590;
      if (localdl2.type != j)
      {
        paramList = String.valueOf(paramObject.getClass());
        paramObject = String.valueOf(localObject1.getClass());
        throw new IllegalArgumentException(String.valueOf(paramList).length() + 80 + String.valueOf(paramObject).length() + "ArrayList elements must all be of the sameclass, but this one contains a " + paramList + " and a " + paramObject);
        localdl1.SH.SR = ((dl[])localObject3);
        break;
        paramList = String.valueOf(paramObject.getClass().getSimpleName());
        if (paramList.length() != 0) {}
        for (paramList = "newFieldValueFromValue: unexpected value ".concat(paramList);; paramList = new String("newFieldValueFromValue: unexpected value ")) {
          throw new RuntimeException(paramList);
        }
      }
    }
  }
  
  public static n a(di paramdi)
  {
    n localn = new n();
    dk[] arrayOfdk = paramdi.SB.SD;
    int j = arrayOfdk.length;
    int i = 0;
    while (i < j)
    {
      dk localdk = arrayOfdk[i];
      a(paramdi.SC, localn, localdk.name, localdk.SF);
      i += 1;
    }
    return localn;
  }
  
  private static ArrayList a(List<Asset> paramList, dm paramdm, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramdm.SR.length);
    paramdm = paramdm.SR;
    int k = paramdm.length;
    int i = 0;
    if (i < k)
    {
      dk[] arrayOfdk = paramdm[i];
      if (arrayOfdk.type == 14) {
        localArrayList.add(null);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == 9)
        {
          n localn = new n();
          arrayOfdk = arrayOfdk.SH.SQ;
          int m = arrayOfdk.length;
          int j = 0;
          while (j < m)
          {
            dk localdk = arrayOfdk[j];
            a(paramList, localn, localdk.name, localdk.SF);
            j += 1;
          }
          localArrayList.add(localn);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(arrayOfdk.SH.SJ);
        }
        else
        {
          if (paramInt != 6) {
            break label191;
          }
          localArrayList.add(Integer.valueOf(arrayOfdk.SH.SN));
        }
      }
      label191:
      throw new IllegalArgumentException(39 + "Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }
  
  private static void a(List<Asset> paramList, n paramn, String paramString, dl paramdl)
  {
    int i = paramdl.type;
    if (i == 14)
    {
      paramn.putString(paramString, null);
      return;
    }
    Object localObject1 = paramdl.SH;
    if (i == 1)
    {
      paramn.putByteArray(paramString, ((dm)localObject1).SI);
      return;
    }
    if (i == 11)
    {
      paramn.putStringArray(paramString, ((dm)localObject1).SS);
      return;
    }
    if (i == 12)
    {
      paramn.putLongArray(paramString, ((dm)localObject1).ST);
      return;
    }
    if (i == 15)
    {
      paramn.putFloatArray(paramString, ((dm)localObject1).SU);
      return;
    }
    if (i == 2)
    {
      paramn.putString(paramString, ((dm)localObject1).SJ);
      return;
    }
    if (i == 3)
    {
      paramn.putDouble(paramString, ((dm)localObject1).SK);
      return;
    }
    if (i == 4)
    {
      paramn.putFloat(paramString, ((dm)localObject1).SL);
      return;
    }
    if (i == 5)
    {
      paramn.putLong(paramString, ((dm)localObject1).SM);
      return;
    }
    if (i == 6)
    {
      paramn.putInt(paramString, ((dm)localObject1).SN);
      return;
    }
    if (i == 7)
    {
      paramn.putByte(paramString, (byte)((dm)localObject1).SO);
      return;
    }
    if (i == 8)
    {
      paramn.putBoolean(paramString, ((dm)localObject1).SP);
      return;
    }
    if (i == 13)
    {
      if (paramList == null)
      {
        paramList = String.valueOf(paramString);
        if (paramList.length() != 0) {}
        for (paramList = "populateBundle: unexpected type for: ".concat(paramList);; paramList = new String("populateBundle: unexpected type for: ")) {
          throw new RuntimeException(paramList);
        }
      }
      paramn.a(paramString, (Asset)paramList.get((int)((dm)localObject1).SV));
      return;
    }
    if (i == 9)
    {
      paramdl = new n();
      localObject1 = ((dm)localObject1).SQ;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        a(paramList, paramdl, localObject2.name, localObject2.SF);
        i += 1;
      }
      paramn.a(paramString, paramdl);
      return;
    }
    if (i == 10)
    {
      i = a(paramString, ((dm)localObject1).SR);
      paramList = a(paramList, (dm)localObject1, i);
      if (i == 14)
      {
        paramn.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 9)
      {
        paramn.a(paramString, paramList);
        return;
      }
      if (i == 2)
      {
        paramn.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 6)
      {
        paramn.putIntegerArrayList(paramString, paramList);
        return;
      }
      throw new IllegalStateException(39 + "Unexpected typeOfArrayList: " + i);
    }
    throw new RuntimeException(43 + "populateBundle: unexpected type " + i);
  }
  
  private static dk[] a(n paramn, List<Asset> paramList)
  {
    Object localObject1 = new TreeSet(paramn.keySet());
    dk[] arrayOfdk = new dk[((TreeSet)localObject1).size()];
    localObject1 = ((TreeSet)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramn.get(str);
      arrayOfdk[i] = new dk();
      arrayOfdk[i].name = str;
      arrayOfdk[i].SF = a(paramList, localObject2);
      i += 1;
    }
    return arrayOfdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dh
 * JD-Core Version:    0.7.0.1
 */