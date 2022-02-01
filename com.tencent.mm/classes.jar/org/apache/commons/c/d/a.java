package org.apache.commons.c.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.apache.commons.c.i;

public final class a
{
  static final Object ajXJ = "y";
  static final Object ajXK = "M";
  static final Object ajXL = "H";
  static final Object ajXM = "m";
  static final Object ajXN = "s";
  static final Object ajXO = "S";
  static final Object d = "d";
  
  private static String a(a[] paramArrayOfa, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(187230);
    org.apache.commons.c.c.a locala = new org.apache.commons.c.c.a();
    int m = 0;
    int n = paramArrayOfa.length;
    int j = 0;
    while (j < n)
    {
      a locala1 = paramArrayOfa[j];
      Object localObject = locala1.value;
      int i1 = locala1.count;
      int i;
      int k;
      if ((localObject instanceof StringBuffer))
      {
        locala.bLo(localObject.toString());
        i = m;
        k = paramInt5;
        j += 1;
        paramInt5 = k;
        m = i;
      }
      else
      {
        if (localObject == ajXJ) {
          locala.bLo(i.b(Integer.toString(0), i1, '0'));
        }
        for (;;)
        {
          i = 0;
          k = paramInt5;
          break;
          if (localObject == ajXK)
          {
            locala.bLo(i.b(Integer.toString(0), i1, '0'));
          }
          else if (localObject == d)
          {
            locala.bLo(i.b(Integer.toString(paramInt1), i1, '0'));
          }
          else if (localObject == ajXL)
          {
            locala.bLo(i.b(Integer.toString(paramInt2), i1, '0'));
          }
          else if (localObject == ajXM)
          {
            locala.bLo(i.b(Integer.toString(paramInt3), i1, '0'));
          }
          else
          {
            if (localObject == ajXN)
            {
              locala.bLo(i.b(Integer.toString(paramInt4), i1, '0'));
              i = 1;
              k = paramInt5;
              break;
            }
            k = paramInt5;
            i = m;
            if (localObject != ajXO) {
              break;
            }
            if (m != 0)
            {
              paramInt5 += 1000;
              locala.bLo(i.b(Integer.toString(paramInt5), i1, '0').substring(1));
            }
            else
            {
              locala.bLo(i.b(Integer.toString(paramInt5), i1, '0'));
            }
          }
        }
      }
    }
    paramArrayOfa = locala.toString();
    AppMethodBeat.o(187230);
    return paramArrayOfa;
  }
  
  public static String at(long paramLong, String paramString)
  {
    AppMethodBeat.i(187228);
    char[] arrayOfChar = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList(arrayOfChar.length);
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int m = arrayOfChar.length;
    int j = 0;
    if (j < m)
    {
      char c = arrayOfChar[j];
      Object localObject3;
      if ((i != 0) && (c != '\''))
      {
        ((StringBuffer)localObject1).append(c);
        k = i;
        localObject3 = localObject2;
      }
      label216:
      do
      {
        j += 1;
        localObject2 = localObject3;
        i = k;
        break;
        paramString = null;
        switch (c)
        {
        default: 
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = new StringBuffer();
            localArrayList.add(new a(localObject3));
          }
          ((StringBuffer)localObject3).append(c);
          localObject1 = localObject3;
          localObject3 = localObject2;
          k = i;
        }
      } while (paramString == null);
      if ((localObject2 != null) && (((a)localObject2).value == paramString)) {
        ((a)localObject2).count += 1;
      }
      for (;;)
      {
        localObject1 = null;
        localObject3 = localObject2;
        k = i;
        break;
        if (i != 0)
        {
          localObject1 = null;
          i = 0;
          break label216;
        }
        localObject1 = new StringBuffer();
        localArrayList.add(new a(localObject1));
        i = 1;
        break label216;
        paramString = ajXJ;
        break label216;
        paramString = ajXK;
        break label216;
        paramString = d;
        break label216;
        paramString = ajXL;
        break label216;
        paramString = ajXM;
        break label216;
        paramString = ajXN;
        break label216;
        paramString = ajXO;
        break label216;
        localObject2 = new a(paramString);
        localArrayList.add(localObject2);
      }
    }
    paramString = (a[])localArrayList.toArray(new a[localArrayList.size()]);
    i = 0;
    j = 0;
    int k = 0;
    m = 0;
    int n = 0;
    long l = paramLong;
    if (a.a(paramString, d))
    {
      i = (int)(paramLong / 86400000L);
      l = paramLong - i * 86400000L;
    }
    paramLong = l;
    if (a.a(paramString, ajXL))
    {
      j = (int)(l / 3600000L);
      paramLong = l - j * 3600000L;
    }
    l = paramLong;
    if (a.a(paramString, ajXM))
    {
      k = (int)(paramLong / 60000L);
      l = paramLong - k * 60000L;
    }
    paramLong = l;
    if (a.a(paramString, ajXN))
    {
      m = (int)(l / 1000L);
      paramLong = l - m * 1000L;
    }
    if (a.a(paramString, ajXO)) {
      n = (int)paramLong;
    }
    paramString = a(paramString, i, j, k, m, n);
    AppMethodBeat.o(187228);
    return paramString;
  }
  
  static final class a
  {
    int count;
    Object value;
    
    a(Object paramObject)
    {
      this.value = paramObject;
      this.count = 1;
    }
    
    static boolean a(a[] paramArrayOfa, Object paramObject)
    {
      boolean bool2 = false;
      int j = paramArrayOfa.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (paramArrayOfa[i].value == paramObject) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(187226);
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (this.value.getClass() != paramObject.value.getClass())
        {
          AppMethodBeat.o(187226);
          return false;
        }
        if (this.count != paramObject.count)
        {
          AppMethodBeat.o(187226);
          return false;
        }
        boolean bool;
        if ((this.value instanceof StringBuffer))
        {
          bool = this.value.toString().equals(paramObject.value.toString());
          AppMethodBeat.o(187226);
          return bool;
        }
        if ((this.value instanceof Number))
        {
          bool = this.value.equals(paramObject.value);
          AppMethodBeat.o(187226);
          return bool;
        }
        if (this.value == paramObject.value)
        {
          AppMethodBeat.o(187226);
          return true;
        }
        AppMethodBeat.o(187226);
        return false;
      }
      AppMethodBeat.o(187226);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(187227);
      int i = this.value.hashCode();
      AppMethodBeat.o(187227);
      return i;
    }
    
    public final String toString()
    {
      int k = 0;
      AppMethodBeat.i(187229);
      Object localObject = this.value.toString();
      int m = this.count;
      if (localObject == null)
      {
        AppMethodBeat.o(187229);
        return null;
      }
      if (m <= 0)
      {
        AppMethodBeat.o(187229);
        return "";
      }
      int n = ((String)localObject).length();
      if ((m == 1) || (n == 0))
      {
        AppMethodBeat.o(187229);
        return localObject;
      }
      if ((n == 1) && (m <= 8192))
      {
        localObject = i.b(m, ((String)localObject).charAt(0));
        AppMethodBeat.o(187229);
        return localObject;
      }
      int i1 = n * m;
      org.apache.commons.c.c.a locala;
      switch (n)
      {
      default: 
        locala = new org.apache.commons.c.c.a(i1);
      }
      while (k < m)
      {
        locala.bLo((String)localObject);
        k += 1;
        continue;
        int i = ((String)localObject).charAt(0);
        localObject = new char[i1];
        k = m - 1;
        while (k >= 0)
        {
          localObject[k] = i;
          k -= 1;
        }
        localObject = new String((char[])localObject);
        AppMethodBeat.o(187229);
        return localObject;
        i = ((String)localObject).charAt(0);
        int j = ((String)localObject).charAt(1);
        localObject = new char[i1];
        for (k = m * 2 - 2; k >= 0; k = k - 1 - 1)
        {
          localObject[k] = i;
          localObject[(k + 1)] = j;
        }
        localObject = new String((char[])localObject);
        AppMethodBeat.o(187229);
        return localObject;
      }
      localObject = locala.toString();
      AppMethodBeat.o(187229);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.c.d.a
 * JD-Core Version:    0.7.0.1
 */