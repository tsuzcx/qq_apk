package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ar
  extends com.tencent.mm.bw.a
{
  public int GXi;
  public LinkedList<Integer> GXj;
  public LinkedList<Integer> GXk;
  public LinkedList<Integer> GXl;
  public LinkedList<Long> GXm;
  public LinkedList<Long> GXn;
  public LinkedList<Long> GXo;
  
  public ar()
  {
    AppMethodBeat.i(43195);
    this.GXj = new LinkedList();
    this.GXk = new LinkedList();
    this.GXl = new LinkedList();
    this.GXm = new LinkedList();
    this.GXn = new LinkedList();
    this.GXo = new LinkedList();
    AppMethodBeat.o(43195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.GXi);
      paramVarArgs.e(2, 2, this.GXj);
      paramVarArgs.e(3, 2, this.GXk);
      paramVarArgs.e(4, 2, this.GXl);
      paramVarArgs.e(5, 3, this.GXm);
      paramVarArgs.e(6, 3, this.GXn);
      paramVarArgs.e(7, 3, this.GXo);
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.GXi);
      int i = f.a.a.a.c(2, 2, this.GXj);
      int j = f.a.a.a.c(3, 2, this.GXk);
      int k = f.a.a.a.c(4, 2, this.GXl);
      int m = f.a.a.a.c(5, 3, this.GXm);
      int n = f.a.a.a.c(6, 3, this.GXn);
      int i1 = f.a.a.a.c(7, 3, this.GXo);
      AppMethodBeat.o(43196);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GXj.clear();
      this.GXk.clear();
      this.GXl.clear();
      this.GXm.clear();
      this.GXn.clear();
      this.GXo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ar localar = (ar)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43196);
        return -1;
      case 1: 
        localar.GXi = locala.LVo.xF();
        AppMethodBeat.o(43196);
        return 0;
      case 2: 
        localar.GXj.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(43196);
        return 0;
      case 3: 
        localar.GXk.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(43196);
        return 0;
      case 4: 
        localar.GXl.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(43196);
        return 0;
      case 5: 
        localar.GXm.add(Long.valueOf(locala.LVo.xG()));
        AppMethodBeat.o(43196);
        return 0;
      case 6: 
        localar.GXn.add(Long.valueOf(locala.LVo.xG()));
        AppMethodBeat.o(43196);
        return 0;
      }
      localar.GXo.add(Long.valueOf(locala.LVo.xG()));
      AppMethodBeat.o(43196);
      return 0;
    }
    AppMethodBeat.o(43196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ar
 * JD-Core Version:    0.7.0.1
 */