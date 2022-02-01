package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aw
  extends com.tencent.mm.bx.a
{
  public String CuS;
  public String CuT;
  public String CuU;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125688);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC != null) {
        paramVarArgs.d(1, this.hnC);
      }
      if (this.CuS != null) {
        paramVarArgs.d(2, this.CuS);
      }
      if (this.CuT != null) {
        paramVarArgs.d(3, this.CuT);
      }
      if (this.CuU != null) {
        paramVarArgs.d(4, this.CuU);
      }
      AppMethodBeat.o(125688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hnC == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.hnC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CuS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CuS);
      }
      i = paramInt;
      if (this.CuT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CuT);
      }
      paramInt = i;
      if (this.CuU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CuU);
      }
      AppMethodBeat.o(125688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125688);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125688);
          return -1;
        case 1: 
          localaw.hnC = locala.KhF.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 2: 
          localaw.CuS = locala.KhF.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 3: 
          localaw.CuT = locala.KhF.readString();
          AppMethodBeat.o(125688);
          return 0;
        }
        localaw.CuU = locala.KhF.readString();
        AppMethodBeat.o(125688);
        return 0;
      }
      AppMethodBeat.o(125688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aw
 * JD-Core Version:    0.7.0.1
 */