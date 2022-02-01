package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ft
  extends com.tencent.mm.bx.a
{
  public int ReqType;
  public String Url;
  public String hCW;
  public int hCZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124391);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hCW != null) {
        paramVarArgs.d(1, this.hCW);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      paramVarArgs.aS(3, this.ReqType);
      paramVarArgs.aS(4, this.hCZ);
      AppMethodBeat.o(124391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hCW == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.hCW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Url);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.ReqType);
      int j = f.a.a.b.b.a.bz(4, this.hCZ);
      AppMethodBeat.o(124391);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124391);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ft localft = (ft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124391);
          return -1;
        case 1: 
          localft.hCW = locala.NPN.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 2: 
          localft.Url = locala.NPN.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 3: 
          localft.ReqType = locala.NPN.zc();
          AppMethodBeat.o(124391);
          return 0;
        }
        localft.hCZ = locala.NPN.zc();
        AppMethodBeat.o(124391);
        return 0;
      }
      AppMethodBeat.o(124391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ft
 * JD-Core Version:    0.7.0.1
 */