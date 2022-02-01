package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ao;
import com.tencent.xweb.util.l;
import org.xwalk.core.XWalkEnvironment;

public final class a
{
  private static String aild = null;
  private static String aile = null;
  
  public static void bHT(String paramString)
  {
    aild = paramString;
  }
  
  public static void bHU(String paramString)
  {
    aile = paramString;
  }
  
  public static void bW(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(212530);
    Object localObject = new StringBuilder().append(ao.kge()).append(",").append(XWalkEnvironment.getInstalledNewstVersionForCurAbi()).append(",");
    int i;
    label63:
    StringBuilder localStringBuilder;
    if (paramBoolean1)
    {
      i = 1;
      localObject = ((StringBuilder)localObject).append(i).append(",");
      if (!paramBoolean2) {
        break label139;
      }
      i = j;
      localStringBuilder = ((StringBuilder)localObject).append(i).append(",2,");
      if (aild == null) {
        break label144;
      }
      localObject = aild;
      label87:
      localStringBuilder = localStringBuilder.append((String)localObject).append(",");
      if (aile == null) {
        break label151;
      }
    }
    label139:
    label144:
    label151:
    for (localObject = aile;; localObject = "")
    {
      l.ev(24525, (String)localObject);
      AppMethodBeat.o(212530);
      return;
      i = 2;
      break;
      i = 2;
      break label63;
      localObject = "";
      break label87;
    }
  }
  
  public static void reset()
  {
    aild = null;
    aile = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.b.a
 * JD-Core Version:    0.7.0.1
 */