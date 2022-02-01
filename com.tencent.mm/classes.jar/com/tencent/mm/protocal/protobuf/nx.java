package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nx
  extends com.tencent.mm.bw.a
{
  public String FZa;
  public LinkedList<String> GaF;
  
  public nx()
  {
    AppMethodBeat.i(188931);
    this.GaF = new LinkedList();
    AppMethodBeat.o(188931);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188932);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZa != null) {
        paramVarArgs.d(1, this.FZa);
      }
      paramVarArgs.e(2, 1, this.GaF);
      AppMethodBeat.o(188932);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZa == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.FZa) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.GaF);
      AppMethodBeat.o(188932);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GaF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188932);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        nx localnx = (nx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188932);
          return -1;
        case 1: 
          localnx.FZa = locala.OmT.readString();
          AppMethodBeat.o(188932);
          return 0;
        }
        localnx.GaF.add(locala.OmT.readString());
        AppMethodBeat.o(188932);
        return 0;
      }
      AppMethodBeat.o(188932);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nx
 * JD-Core Version:    0.7.0.1
 */