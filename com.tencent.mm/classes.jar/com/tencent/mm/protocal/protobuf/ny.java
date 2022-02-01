package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ny
  extends com.tencent.mm.bw.a
{
  public String FZa;
  public LinkedList<String> GaF;
  public String GaG;
  
  public ny()
  {
    AppMethodBeat.i(188933);
    this.GaF = new LinkedList();
    AppMethodBeat.o(188933);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188934);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZa != null) {
        paramVarArgs.d(1, this.FZa);
      }
      paramVarArgs.e(2, 1, this.GaF);
      if (this.GaG != null) {
        paramVarArgs.d(3, this.GaG);
      }
      AppMethodBeat.o(188934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZa == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = f.a.a.b.b.a.e(1, this.FZa) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.GaF);
      paramInt = i;
      if (this.GaG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GaG);
      }
      AppMethodBeat.o(188934);
      return paramInt;
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
        AppMethodBeat.o(188934);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ny localny = (ny)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188934);
          return -1;
        case 1: 
          localny.FZa = locala.OmT.readString();
          AppMethodBeat.o(188934);
          return 0;
        case 2: 
          localny.GaF.add(locala.OmT.readString());
          AppMethodBeat.o(188934);
          return 0;
        }
        localny.GaG = locala.OmT.readString();
        AppMethodBeat.o(188934);
        return 0;
      }
      AppMethodBeat.o(188934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ny
 * JD-Core Version:    0.7.0.1
 */