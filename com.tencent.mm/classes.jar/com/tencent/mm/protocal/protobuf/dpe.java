package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dpe
  extends com.tencent.mm.bw.a
{
  public b Geo;
  public int Gep;
  public int HWF;
  public int HWG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(7, this.HWF);
      if (this.Geo != null) {
        paramVarArgs.c(8, this.Geo);
      }
      paramVarArgs.aS(9, this.Gep);
      paramVarArgs.aS(10, this.HWG);
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(7, this.HWF) + 0;
      paramInt = i;
      if (this.Geo != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.Geo);
      }
      i = f.a.a.b.b.a.bz(9, this.Gep);
      int j = f.a.a.b.b.a.bz(10, this.HWG);
      AppMethodBeat.o(91718);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dpe localdpe = (dpe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91718);
        return -1;
      case 7: 
        localdpe.HWF = locala.OmT.zc();
        AppMethodBeat.o(91718);
        return 0;
      case 8: 
        localdpe.Geo = locala.OmT.gCk();
        AppMethodBeat.o(91718);
        return 0;
      case 9: 
        localdpe.Gep = locala.OmT.zc();
        AppMethodBeat.o(91718);
        return 0;
      }
      localdpe.HWG = locala.OmT.zc();
      AppMethodBeat.o(91718);
      return 0;
    }
    AppMethodBeat.o(91718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpe
 * JD-Core Version:    0.7.0.1
 */