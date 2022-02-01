package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmn
  extends com.tencent.mm.bx.a
{
  public String HfQ;
  public int HfR;
  public String dxD;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD != null) {
        paramVarArgs.d(1, this.dxD);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.HfQ != null) {
        paramVarArgs.d(3, this.HfQ);
      }
      paramVarArgs.aS(4, this.HfR);
      AppMethodBeat.o(104374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dxD == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.dxD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.HfQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HfQ);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HfR);
      AppMethodBeat.o(104374);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104374);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cmn localcmn = (cmn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104374);
          return -1;
        case 1: 
          localcmn.dxD = locala.NPN.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 2: 
          localcmn.url = locala.NPN.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 3: 
          localcmn.HfQ = locala.NPN.readString();
          AppMethodBeat.o(104374);
          return 0;
        }
        localcmn.HfR = locala.NPN.zc();
        AppMethodBeat.o(104374);
        return 0;
      }
      AppMethodBeat.o(104374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmn
 * JD-Core Version:    0.7.0.1
 */