package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.c;

public final class q
{
  public final String[] ajMS;
  
  q(a parama)
  {
    AppMethodBeat.i(186662);
    this.ajMS = ((String[])parama.ajMT.toArray(new String[parama.ajMT.size()]));
    AppMethodBeat.o(186662);
  }
  
  static void bKl(String paramString)
  {
    AppMethodBeat.i(186678);
    if (paramString == null)
    {
      paramString = new NullPointerException("name == null");
      AppMethodBeat.o(186678);
      throw paramString;
    }
    if (paramString.isEmpty())
    {
      paramString = new IllegalArgumentException("name is empty");
      AppMethodBeat.o(186678);
      throw paramString;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      if ((k <= 32) || (k >= 127))
      {
        paramString = new IllegalArgumentException(c.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString }));
        AppMethodBeat.o(186678);
        throw paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(186678);
  }
  
  private static String f(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(186668);
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i]))
      {
        paramArrayOfString = paramArrayOfString[(i + 1)];
        AppMethodBeat.o(186668);
        return paramArrayOfString;
      }
      i -= 2;
    }
    AppMethodBeat.o(186668);
    return null;
  }
  
  static void rA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186691);
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("value for name " + paramString2 + " == null");
      AppMethodBeat.o(186691);
      throw paramString1;
    }
    int j = paramString1.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString1.charAt(i);
      if (((k <= 31) && (k != 9)) || (k >= 127))
      {
        paramString1 = new IllegalArgumentException(c.format("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString2, paramString1 }));
        AppMethodBeat.o(186691);
        throw paramString1;
      }
      i += 1;
    }
    AppMethodBeat.o(186691);
  }
  
  public final String aMS(int paramInt)
  {
    return this.ajMS[(paramInt * 2)];
  }
  
  public final String aMT(int paramInt)
  {
    return this.ajMS[(paramInt * 2 + 1)];
  }
  
  public final List<String> bKk(String paramString)
  {
    AppMethodBeat.i(186752);
    Object localObject1 = null;
    int i = 0;
    int j = this.ajMS.length / 2;
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (paramString.equalsIgnoreCase(aMS(i)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(aMT(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      paramString = Collections.unmodifiableList(localObject1);
      AppMethodBeat.o(186752);
      return paramString;
    }
    paramString = Collections.emptyList();
    AppMethodBeat.o(186752);
    return paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186764);
    if (((paramObject instanceof q)) && (Arrays.equals(((q)paramObject).ajMS, this.ajMS)))
    {
      AppMethodBeat.o(186764);
      return true;
    }
    AppMethodBeat.o(186764);
    return false;
  }
  
  public final String get(String paramString)
  {
    AppMethodBeat.i(186699);
    paramString = f(this.ajMS, paramString);
    AppMethodBeat.o(186699);
    return paramString;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186767);
    int i = Arrays.hashCode(this.ajMS);
    AppMethodBeat.o(186767);
    return i;
  }
  
  public final a kGL()
  {
    AppMethodBeat.i(186758);
    a locala = new a();
    Collections.addAll(locala.ajMT, this.ajMS);
    AppMethodBeat.o(186758);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186775);
    Object localObject = new StringBuilder();
    int i = 0;
    int j = this.ajMS.length / 2;
    while (i < j)
    {
      ((StringBuilder)localObject).append(aMS(i)).append(": ").append(aMT(i)).append("\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(186775);
    return localObject;
  }
  
  public static final class a
  {
    final List<String> ajMT;
    
    public a()
    {
      AppMethodBeat.i(186608);
      this.ajMT = new ArrayList(20);
      AppMethodBeat.o(186608);
    }
    
    final a bKm(String paramString)
    {
      AppMethodBeat.i(186614);
      int i = paramString.indexOf(":", 1);
      if (i != -1)
      {
        paramString = rC(paramString.substring(0, i), paramString.substring(i + 1));
        AppMethodBeat.o(186614);
        return paramString;
      }
      if (paramString.startsWith(":"))
      {
        paramString = rC("", paramString.substring(1));
        AppMethodBeat.o(186614);
        return paramString;
      }
      paramString = rC("", paramString);
      AppMethodBeat.o(186614);
      return paramString;
    }
    
    public final a bKn(String paramString)
    {
      AppMethodBeat.i(186629);
      int j;
      for (int i = 0; i < this.ajMT.size(); i = j + 2)
      {
        j = i;
        if (paramString.equalsIgnoreCase((String)this.ajMT.get(i)))
        {
          this.ajMT.remove(i);
          this.ajMT.remove(i);
          j = i - 2;
        }
      }
      AppMethodBeat.o(186629);
      return this;
    }
    
    public final String get(String paramString)
    {
      AppMethodBeat.i(186638);
      int i = this.ajMT.size() - 2;
      while (i >= 0)
      {
        if (paramString.equalsIgnoreCase((String)this.ajMT.get(i)))
        {
          paramString = (String)this.ajMT.get(i + 1);
          AppMethodBeat.o(186638);
          return paramString;
        }
        i -= 2;
      }
      AppMethodBeat.o(186638);
      return null;
    }
    
    public final q kGM()
    {
      AppMethodBeat.i(186643);
      q localq = new q(this);
      AppMethodBeat.o(186643);
      return localq;
    }
    
    public final a rB(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186620);
      q.bKl(paramString1);
      q.rA(paramString2, paramString1);
      paramString1 = rC(paramString1, paramString2);
      AppMethodBeat.o(186620);
      return paramString1;
    }
    
    final a rC(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186624);
      this.ajMT.add(paramString1);
      this.ajMT.add(paramString2.trim());
      AppMethodBeat.o(186624);
      return this;
    }
    
    public final a rD(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186633);
      q.bKl(paramString1);
      q.rA(paramString2, paramString1);
      bKn(paramString1);
      rC(paramString1, paramString2);
      AppMethodBeat.o(186633);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.q
 * JD-Core Version:    0.7.0.1
 */