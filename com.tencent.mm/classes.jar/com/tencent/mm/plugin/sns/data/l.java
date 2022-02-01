package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class l
{
  public Map<String, Map<String, Long>> map;
  public ArrayList<String> wBb;
  public ArrayList<List<String>> wBc;
  
  public l()
  {
    AppMethodBeat.i(95085);
    this.wBb = new ArrayList();
    this.wBc = new ArrayList();
    this.map = new HashMap();
    AppMethodBeat.o(95085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.l
 * JD-Core Version:    0.7.0.1
 */