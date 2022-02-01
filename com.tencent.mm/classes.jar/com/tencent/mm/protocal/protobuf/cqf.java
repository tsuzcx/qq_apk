package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cqf
  extends com.tencent.mm.bw.a
{
  public int FDv;
  public String FDw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152669);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDw == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResKey");
        AppMethodBeat.o(152669);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.FDv);
      if (this.FDw != null) {
        paramVarArgs.d(2, this.FDw);
      }
      AppMethodBeat.o(152669);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FDv) + 0;
      paramInt = i;
      if (this.FDw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FDw);
      }
      AppMethodBeat.o(152669);
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
      if (this.FDw == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResKey");
        AppMethodBeat.o(152669);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152669);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cqf localcqf = (cqf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152669);
        return -1;
      case 1: 
        localcqf.FDv = locala.LVo.xF();
        AppMethodBeat.o(152669);
        return 0;
      }
      localcqf.FDw = locala.LVo.readString();
      AppMethodBeat.o(152669);
      return 0;
    }
    AppMethodBeat.o(152669);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqf
 * JD-Core Version:    0.7.0.1
 */