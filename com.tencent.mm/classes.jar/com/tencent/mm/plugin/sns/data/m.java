package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m
{
  public Map<String, Map<String, Long>> map;
  public ArrayList<String> zug;
  public ArrayList<List<String>> zuh;
  
  public m()
  {
    AppMethodBeat.i(95085);
    this.zug = new ArrayList();
    this.zuh = new ArrayList();
    this.map = new HashMap();
    AppMethodBeat.o(95085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.m
 * JD-Core Version:    0.7.0.1
 */