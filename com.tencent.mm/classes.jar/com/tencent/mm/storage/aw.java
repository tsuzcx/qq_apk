package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.bw.a
{
  public int Jfd;
  public LinkedList<Integer> Jfe;
  public LinkedList<Integer> Jff;
  public LinkedList<Integer> Jfg;
  public LinkedList<Long> Jfh;
  public LinkedList<Long> Jfi;
  public LinkedList<Long> Jfj;
  
  public aw()
  {
    AppMethodBeat.i(43195);
    this.Jfe = new LinkedList();
    this.Jff = new LinkedList();
    this.Jfg = new LinkedList();
    this.Jfh = new LinkedList();
    this.Jfi = new LinkedList();
    this.Jfj = new LinkedList();
    AppMethodBeat.o(43195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Jfd);
      paramVarArgs.e(2, 2, this.Jfe);
      paramVarArgs.e(3, 2, this.Jff);
      paramVarArgs.e(4, 2, this.Jfg);
      paramVarArgs.e(5, 3, this.Jfh);
      paramVarArgs.e(6, 3, this.Jfi);
      paramVarArgs.e(7, 3, this.Jfj);
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Jfd);
      int i = f.a.a.a.c(2, 2, this.Jfe);
      int j = f.a.a.a.c(3, 2, this.Jff);
      int k = f.a.a.a.c(4, 2, this.Jfg);
      int m = f.a.a.a.c(5, 3, this.Jfh);
      int n = f.a.a.a.c(6, 3, this.Jfi);
      int i1 = f.a.a.a.c(7, 3, this.Jfj);
      AppMethodBeat.o(43196);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Jfe.clear();
      this.Jff.clear();
      this.Jfg.clear();
      this.Jfh.clear();
      this.Jfi.clear();
      this.Jfj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aw localaw = (aw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43196);
        return -1;
      case 1: 
        localaw.Jfd = locala.OmT.zc();
        AppMethodBeat.o(43196);
        return 0;
      case 2: 
        localaw.Jfe.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(43196);
        return 0;
      case 3: 
        localaw.Jff.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(43196);
        return 0;
      case 4: 
        localaw.Jfg.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(43196);
        return 0;
      case 5: 
        localaw.Jfh.add(Long.valueOf(locala.OmT.zd()));
        AppMethodBeat.o(43196);
        return 0;
      case 6: 
        localaw.Jfi.add(Long.valueOf(locala.OmT.zd()));
        AppMethodBeat.o(43196);
        return 0;
      }
      localaw.Jfj.add(Long.valueOf(locala.OmT.zd()));
      AppMethodBeat.o(43196);
      return 0;
    }
    AppMethodBeat.o(43196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.aw
 * JD-Core Version:    0.7.0.1
 */