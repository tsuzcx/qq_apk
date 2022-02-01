package com.tencent.mm.sensitive;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/PermissionConstants;", "", "()V", "safeValueOfBusiness", "Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;", "value", "", "", "safeValueOfPermission", "Lcom/tencent/mm/sensitive/IPluginSensitive$PERMISSION;", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i actT;
  
  static
  {
    AppMethodBeat.i(240897);
    actT = new i();
    AppMethodBeat.o(240897);
  }
  
  public static d.a ayl(int paramInt)
  {
    AppMethodBeat.i(240891);
    try
    {
      d.a[] arrayOfa = d.a.values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        d.a locala = arrayOfa[i];
        i += 1;
        if (locala.qDL == paramInt)
        {
          AppMethodBeat.o(240891);
          return locala;
        }
      }
      AppMethodBeat.o(240891);
      return null;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(240891);
    }
    return null;
  }
  
  public static d.a bup(String paramString)
  {
    AppMethodBeat.i(240886);
    s.u(paramString, "value");
    try
    {
      d.a[] arrayOfa = d.a.values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        d.a locala = arrayOfa[i];
        i += 1;
        if (n.T(locala.value, paramString, true))
        {
          AppMethodBeat.o(240886);
          return locala;
        }
      }
      AppMethodBeat.o(240886);
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(240886);
    }
    return null;
  }
  
  public static d.c buq(String paramString)
  {
    AppMethodBeat.i(240895);
    s.u(paramString, "value");
    try
    {
      d.c[] arrayOfc = d.c.values();
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        d.c localc = arrayOfc[i];
        i += 1;
        if (n.T(localc.value, paramString, true))
        {
          AppMethodBeat.o(240895);
          return localc;
        }
      }
      AppMethodBeat.o(240895);
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(240895);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.i
 * JD-Core Version:    0.7.0.1
 */