package com.tencent.mm.plugin.patmsg.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class f
{
  public List<Pair<Integer, Integer>> MHq;
  public List<a> MHr;
  public List<String> oxE;
  public String result;
  
  public f()
  {
    AppMethodBeat.i(266347);
    this.MHq = new ArrayList();
    this.oxE = new ArrayList();
    this.MHr = new LinkedList();
    AppMethodBeat.o(266347);
  }
  
  public static final class a
  {
    public int end;
    public int start;
    public String username;
    
    public a(int paramInt1, int paramInt2, String paramString)
    {
      this.start = paramInt1;
      this.end = paramInt2;
      this.username = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.f
 * JD-Core Version:    0.7.0.1
 */