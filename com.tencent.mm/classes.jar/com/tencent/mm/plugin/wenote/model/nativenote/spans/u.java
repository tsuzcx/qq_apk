package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b rKY = new b();
  public static final j rKZ = new j();
  public static final c rLa = new c();
  public static final l rLb = new l();
  public static final h rLc = new h();
  public static final ArrayList<t> rLd;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    rLd = localArrayList;
    localArrayList.add(rKY);
    rLd.add(rLa);
    rLd.add(rLb);
    rLd.add(rKZ);
  }
  
  private static void a(WXRTEditText paramWXRTEditText, o paramo, t... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramo == paramVarArgs[i]) {
        return;
      }
      i += 1;
    }
    paramo.a(paramWXRTEditText, null, null);
  }
  
  public static void a(WXRTEditText paramWXRTEditText, t... paramVarArgs)
  {
    a(paramWXRTEditText, rLc, paramVarArgs);
    a(paramWXRTEditText, rLa, paramVarArgs);
    a(paramWXRTEditText, rLb, paramVarArgs);
    a(paramWXRTEditText, rKZ, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */