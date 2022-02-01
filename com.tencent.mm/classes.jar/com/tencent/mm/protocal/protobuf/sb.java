package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sb
  extends com.tencent.mm.bx.a
{
  public String FBY;
  public String FON;
  public int FOO;
  public String FOP;
  public String abi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FON != null) {
        paramVarArgs.d(1, this.FON);
      }
      paramVarArgs.aS(2, this.FOO);
      if (this.abi != null) {
        paramVarArgs.d(3, this.abi);
      }
      if (this.FBY != null) {
        paramVarArgs.d(4, this.FBY);
      }
      if (this.FOP != null) {
        paramVarArgs.d(5, this.FOP);
      }
      AppMethodBeat.o(116466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FON == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.FON) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FOO);
      paramInt = i;
      if (this.abi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.abi);
      }
      i = paramInt;
      if (this.FBY != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FBY);
      }
      paramInt = i;
      if (this.FOP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FOP);
      }
      AppMethodBeat.o(116466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        sb localsb = (sb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116466);
          return -1;
        case 1: 
          localsb.FON = locala.NPN.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 2: 
          localsb.FOO = locala.NPN.zc();
          AppMethodBeat.o(116466);
          return 0;
        case 3: 
          localsb.abi = locala.NPN.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 4: 
          localsb.FBY = locala.NPN.readString();
          AppMethodBeat.o(116466);
          return 0;
        }
        localsb.FOP = locala.NPN.readString();
        AppMethodBeat.o(116466);
        return 0;
      }
      AppMethodBeat.o(116466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sb
 * JD-Core Version:    0.7.0.1
 */