package com.tencent.xweb.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public long ailf;
  public long ailg;
  public long ailh;
  public List<b.a> aili;
  public List<b.a> ailj;
  public List<b.a> ailk;
  public List<b.a> aill;
  public List<b.a> ailm;
  public List<b.a> ailn;
  public List<b.a> ailo;
  
  public b()
  {
    AppMethodBeat.i(212516);
    this.aili = new ArrayList();
    this.ailj = new ArrayList();
    this.ailk = new ArrayList();
    this.aill = new ArrayList();
    this.ailm = new ArrayList();
    this.ailn = new ArrayList();
    this.ailo = new ArrayList();
    AppMethodBeat.o(212516);
  }
  
  public static String oB(List<b.a> paramList)
  {
    AppMethodBeat.i(212523);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(212523);
      return "{}";
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((b.a)paramList.next()).toString());
    }
    paramList = "{" + TextUtils.join(";", localArrayList) + "}";
    AppMethodBeat.o(212523);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.b.b
 * JD-Core Version:    0.7.0.1
 */