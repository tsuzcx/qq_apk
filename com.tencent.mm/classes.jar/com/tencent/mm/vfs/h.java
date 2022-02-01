package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  private static final Pattern agwS;
  private static final Comparator<a> agwT;
  private final a[] agwU;
  public final String value;
  
  static
  {
    AppMethodBeat.i(238380);
    agwS = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");
    agwT = new Comparator() {};
    AppMethodBeat.o(238380);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(238370);
    this.value = paramString;
    if (paramString != null)
    {
      paramString = agwS.matcher(paramString);
      if (paramString.find())
      {
        ArrayList localArrayList = new ArrayList();
        do
        {
          localArrayList.add(new a(paramString.group(1), paramString.start(), paramString.end()));
        } while (paramString.find());
        this.agwU = ((a[])localArrayList.toArray(new a[0]));
        Arrays.sort(this.agwU, agwT);
        AppMethodBeat.o(238370);
        return;
      }
    }
    this.agwU = null;
    AppMethodBeat.o(238370);
  }
  
  public final String cR(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238389);
    if ((this.agwU == null) || (this.value == null))
    {
      paramMap = this.value;
      AppMethodBeat.o(238389);
      return paramMap;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a[] arrayOfa = this.agwU;
    int k = arrayOfa.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      a locala = arrayOfa[i];
      String str = ah.aA(paramMap, locala.name);
      if (str == null)
      {
        AppMethodBeat.o(238389);
        return null;
      }
      localStringBuilder.append(this.value, j, locala.start).append(str);
      j = locala.end;
      i += 1;
    }
    paramMap = this.value;
    paramMap = localStringBuilder.append(paramMap, j, paramMap.length()).toString();
    AppMethodBeat.o(238389);
    return paramMap;
  }
  
  public final String[] cS(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238400);
    if (this.value == null)
    {
      AppMethodBeat.o(238400);
      return null;
    }
    if (this.agwU == null)
    {
      paramMap = this.value;
      AppMethodBeat.o(238400);
      return new String[] { paramMap };
    }
    Object[] arrayOfObject = new Object[this.agwU.length];
    int i = 0;
    Object localObject1;
    while (i < arrayOfObject.length)
    {
      localObject1 = paramMap.get(this.agwU[i].name);
      if (localObject1 == null)
      {
        AppMethodBeat.o(238400);
        return null;
      }
      arrayOfObject[i] = localObject1;
      i += 1;
    }
    i = 1;
    int k = arrayOfObject.length;
    int j = 0;
    if (j < k)
    {
      paramMap = arrayOfObject[j];
      if (!(paramMap instanceof String[])) {
        break label430;
      }
      i = ((String[])paramMap).length * i;
    }
    label430:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0)
      {
        AppMethodBeat.o(238400);
        return null;
      }
      paramMap = new int[this.agwU.length];
      localObject1 = new String[i];
      StringBuilder localStringBuilder = new StringBuilder();
      j = 0;
      while (j < i)
      {
        int m = 0;
        k = 0;
        if (k < paramMap.length)
        {
          localObject2 = this.agwU[k];
          Object localObject3 = arrayOfObject[k];
          localStringBuilder.append(this.value, m, ((a)localObject2).start);
          if ((localObject3 instanceof String)) {
            localStringBuilder.append((String)localObject3);
          }
          for (;;)
          {
            m = ((a)localObject2).end;
            k += 1;
            break;
            if (!(localObject3 instanceof String[])) {
              break label303;
            }
            localStringBuilder.append(((String[])(String[])localObject3)[paramMap[k]]);
          }
          label303:
          AppMethodBeat.o(238400);
          return null;
        }
        Object localObject2 = this.value;
        localObject1[j] = localStringBuilder.append((CharSequence)localObject2, m, ((String)localObject2).length()).toString();
        localStringBuilder.setLength(0);
        k = paramMap.length - 1;
        while (k >= 0)
        {
          localObject2 = arrayOfObject[k];
          if ((localObject2 instanceof String[]))
          {
            m = ((String[])localObject2).length;
            int n = paramMap[k] + 1;
            paramMap[k] = n;
            if (n < m) {
              break;
            }
            paramMap[k] = 0;
          }
          k -= 1;
        }
        j += 1;
      }
      AppMethodBeat.o(238400);
      return localObject1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238416);
    if (((paramObject instanceof h)) && (ah.equals(this.value, ((h)paramObject).value)))
    {
      AppMethodBeat.o(238416);
      return true;
    }
    AppMethodBeat.o(238416);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(238412);
    if (this.value == null)
    {
      AppMethodBeat.o(238412);
      return 0;
    }
    int i = this.value.hashCode();
    AppMethodBeat.o(238412);
    return i;
  }
  
  public final boolean jKr()
  {
    return this.agwU != null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(238421);
    String str = String.valueOf(this.value);
    if (this.agwU == null)
    {
      AppMethodBeat.o(238421);
      return str;
    }
    str = "$:".concat(String.valueOf(str));
    AppMethodBeat.o(238421);
    return str;
  }
  
  static final class a
  {
    final int end;
    final String name;
    final int start;
    
    a(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.start = paramInt1;
      this.end = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.h
 * JD-Core Version:    0.7.0.1
 */