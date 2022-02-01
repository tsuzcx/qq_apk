package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cu
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> CxJ;
  public String dlX;
  
  public cu()
  {
    AppMethodBeat.i(190258);
    this.CxJ = new LinkedList();
    AppMethodBeat.o(190258);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlX != null) {
        paramVarArgs.d(1, this.dlX);
      }
      paramVarArgs.e(2, 1, this.CxJ);
      AppMethodBeat.o(190259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlX == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlX) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.CxJ);
      AppMethodBeat.o(190259);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CxJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(190259);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cu localcu = (cu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190259);
          return -1;
        case 1: 
          localcu.dlX = locala.KhF.readString();
          AppMethodBeat.o(190259);
          return 0;
        }
        localcu.CxJ.add(locala.KhF.readString());
        AppMethodBeat.o(190259);
        return 0;
      }
      AppMethodBeat.o(190259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cu
 * JD-Core Version:    0.7.0.1
 */