package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwh
  extends com.tencent.mm.bx.a
{
  public String FEW;
  public int FUX;
  public String GQF;
  public String GQG;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GQF != null) {
        paramVarArgs.d(1, this.GQF);
      }
      if (this.FEW != null) {
        paramVarArgs.d(2, this.FEW);
      }
      if (this.type != null) {
        paramVarArgs.d(3, this.type);
      }
      paramVarArgs.aS(4, this.FUX);
      if (this.GQG != null) {
        paramVarArgs.d(5, this.GQG);
      }
      AppMethodBeat.o(116340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GQF == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.GQF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FEW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FEW);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.type);
      }
      i += f.a.a.b.b.a.bz(4, this.FUX);
      paramInt = i;
      if (this.GQG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GQG);
      }
      AppMethodBeat.o(116340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116340);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwh localbwh = (bwh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116340);
          return -1;
        case 1: 
          localbwh.GQF = locala.NPN.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 2: 
          localbwh.FEW = locala.NPN.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 3: 
          localbwh.type = locala.NPN.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 4: 
          localbwh.FUX = locala.NPN.zc();
          AppMethodBeat.o(116340);
          return 0;
        }
        localbwh.GQG = locala.NPN.readString();
        AppMethodBeat.o(116340);
        return 0;
      }
      AppMethodBeat.o(116340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwh
 * JD-Core Version:    0.7.0.1
 */