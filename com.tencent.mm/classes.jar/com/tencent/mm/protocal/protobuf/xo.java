package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xo
  extends com.tencent.mm.bx.a
{
  public int FXd;
  public String dxD;
  public String title;
  public String wCQ;
  public String yaL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.wCQ != null) {
        paramVarArgs.d(3, this.wCQ);
      }
      if (this.yaL != null) {
        paramVarArgs.d(4, this.yaL);
      }
      paramVarArgs.aS(5, this.FXd);
      AppMethodBeat.o(72459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.wCQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wCQ);
      }
      paramInt = i;
      if (this.yaL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.yaL);
      }
      i = f.a.a.b.b.a.bz(5, this.FXd);
      AppMethodBeat.o(72459);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72459);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xo localxo = (xo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72459);
          return -1;
        case 1: 
          localxo.title = locala.NPN.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 2: 
          localxo.dxD = locala.NPN.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 3: 
          localxo.wCQ = locala.NPN.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 4: 
          localxo.yaL = locala.NPN.readString();
          AppMethodBeat.o(72459);
          return 0;
        }
        localxo.FXd = locala.NPN.zc();
        AppMethodBeat.o(72459);
        return 0;
      }
      AppMethodBeat.o(72459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xo
 * JD-Core Version:    0.7.0.1
 */