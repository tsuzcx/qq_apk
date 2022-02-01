package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class in
  extends com.tencent.mm.bx.a
{
  public String FBs;
  public String dkR;
  public String uJF;
  public String wCE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91356);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FBs != null) {
        paramVarArgs.d(1, this.FBs);
      }
      if (this.dkR != null) {
        paramVarArgs.d(2, this.dkR);
      }
      if (this.uJF != null) {
        paramVarArgs.d(3, this.uJF);
      }
      if (this.wCE != null) {
        paramVarArgs.d(4, this.wCE);
      }
      AppMethodBeat.o(91356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FBs == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.FBs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dkR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dkR);
      }
      i = paramInt;
      if (this.uJF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uJF);
      }
      paramInt = i;
      if (this.wCE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wCE);
      }
      AppMethodBeat.o(91356);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91356);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        in localin = (in)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91356);
          return -1;
        case 1: 
          localin.FBs = locala.NPN.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 2: 
          localin.dkR = locala.NPN.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 3: 
          localin.uJF = locala.NPN.readString();
          AppMethodBeat.o(91356);
          return 0;
        }
        localin.wCE = locala.NPN.readString();
        AppMethodBeat.o(91356);
        return 0;
      }
      AppMethodBeat.o(91356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.in
 * JD-Core Version:    0.7.0.1
 */