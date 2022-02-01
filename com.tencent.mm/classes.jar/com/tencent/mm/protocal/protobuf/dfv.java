package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfv
  extends com.tencent.mm.bw.a
{
  public int FPf;
  public String FPg;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.FPf);
      if (this.FPg != null) {
        paramVarArgs.d(4, this.FPg);
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(2, this.ndI) + 0 + f.a.a.b.b.a.bx(3, this.FPf);
      paramInt = i;
      if (this.FPg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FPg);
      }
      AppMethodBeat.o(153305);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dfv localdfv = (dfv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153305);
        return -1;
      case 2: 
        localdfv.ndI = locala.LVo.xF();
        AppMethodBeat.o(153305);
        return 0;
      case 3: 
        localdfv.FPf = locala.LVo.xF();
        AppMethodBeat.o(153305);
        return 0;
      }
      localdfv.FPg = locala.LVo.readString();
      AppMethodBeat.o(153305);
      return 0;
    }
    AppMethodBeat.o(153305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfv
 * JD-Core Version:    0.7.0.1
 */