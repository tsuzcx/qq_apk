package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ffs
  extends com.tencent.mm.cd.a
{
  public b Sth;
  public int UGd;
  public int UhB;
  public int YU;
  public String idV;
  public int mbp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147790);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.mbp);
      paramVarArgs.aY(2, this.YU);
      if (this.idV != null) {
        paramVarArgs.f(3, this.idV);
      }
      if (this.Sth != null) {
        paramVarArgs.c(4, this.Sth);
      }
      paramVarArgs.aY(5, this.UhB);
      paramVarArgs.aY(6, this.UGd);
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.mbp) + 0 + g.a.a.b.b.a.bM(2, this.YU);
      paramInt = i;
      if (this.idV != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.idV);
      }
      i = paramInt;
      if (this.Sth != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.Sth);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.UhB);
      int j = g.a.a.b.b.a.bM(6, this.UGd);
      AppMethodBeat.o(147790);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ffs localffs = (ffs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147790);
        return -1;
      case 1: 
        localffs.mbp = locala.abFh.AK();
        AppMethodBeat.o(147790);
        return 0;
      case 2: 
        localffs.YU = locala.abFh.AK();
        AppMethodBeat.o(147790);
        return 0;
      case 3: 
        localffs.idV = locala.abFh.readString();
        AppMethodBeat.o(147790);
        return 0;
      case 4: 
        localffs.Sth = locala.abFh.iUw();
        AppMethodBeat.o(147790);
        return 0;
      case 5: 
        localffs.UhB = locala.abFh.AK();
        AppMethodBeat.o(147790);
        return 0;
      }
      localffs.UGd = locala.abFh.AK();
      AppMethodBeat.o(147790);
      return 0;
    }
    AppMethodBeat.o(147790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffs
 * JD-Core Version:    0.7.0.1
 */