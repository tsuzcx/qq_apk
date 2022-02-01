package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.bw.a
{
  public int OoY;
  public LinkedList<Integer> OoZ;
  public LinkedList<Integer> Opa;
  public LinkedList<Integer> Opb;
  public LinkedList<Long> Opc;
  public LinkedList<Long> Opd;
  public LinkedList<Long> Ope;
  
  public bb()
  {
    AppMethodBeat.i(43195);
    this.OoZ = new LinkedList();
    this.Opa = new LinkedList();
    this.Opb = new LinkedList();
    this.Opc = new LinkedList();
    this.Opd = new LinkedList();
    this.Ope = new LinkedList();
    AppMethodBeat.o(43195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43196);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.OoY);
      paramVarArgs.e(2, 2, this.OoZ);
      paramVarArgs.e(3, 2, this.Opa);
      paramVarArgs.e(4, 2, this.Opb);
      paramVarArgs.e(5, 3, this.Opc);
      paramVarArgs.e(6, 3, this.Opd);
      paramVarArgs.e(7, 3, this.Ope);
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.OoY);
      int i = g.a.a.a.c(2, 2, this.OoZ);
      int j = g.a.a.a.c(3, 2, this.Opa);
      int k = g.a.a.a.c(4, 2, this.Opb);
      int m = g.a.a.a.c(5, 3, this.Opc);
      int n = g.a.a.a.c(6, 3, this.Opd);
      int i1 = g.a.a.a.c(7, 3, this.Ope);
      AppMethodBeat.o(43196);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.OoZ.clear();
      this.Opa.clear();
      this.Opb.clear();
      this.Opc.clear();
      this.Opd.clear();
      this.Ope.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bb localbb = (bb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43196);
        return -1;
      case 1: 
        localbb.OoY = locala.UbS.zi();
        AppMethodBeat.o(43196);
        return 0;
      case 2: 
        localbb.OoZ.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(43196);
        return 0;
      case 3: 
        localbb.Opa.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(43196);
        return 0;
      case 4: 
        localbb.Opb.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(43196);
        return 0;
      case 5: 
        localbb.Opc.add(Long.valueOf(locala.UbS.zl()));
        AppMethodBeat.o(43196);
        return 0;
      case 6: 
        localbb.Opd.add(Long.valueOf(locala.UbS.zl()));
        AppMethodBeat.o(43196);
        return 0;
      }
      localbb.Ope.add(Long.valueOf(locala.UbS.zl()));
      AppMethodBeat.o(43196);
      return 0;
    }
    AppMethodBeat.o(43196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bb
 * JD-Core Version:    0.7.0.1
 */