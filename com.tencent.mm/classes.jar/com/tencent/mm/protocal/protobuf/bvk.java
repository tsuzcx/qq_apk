package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvk
  extends com.tencent.mm.bx.a
{
  public String bNK;
  public int status;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      paramVarArgs.aR(2, this.status);
      if (this.bNK != null) {
        paramVarArgs.d(3, this.bNK);
      }
      AppMethodBeat.o(152636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.status);
      paramInt = i;
      if (this.bNK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.bNK);
      }
      AppMethodBeat.o(152636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152636);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvk localbvk = (bvk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152636);
          return -1;
        case 1: 
          localbvk.userName = locala.KhF.readString();
          AppMethodBeat.o(152636);
          return 0;
        case 2: 
          localbvk.status = locala.KhF.xS();
          AppMethodBeat.o(152636);
          return 0;
        }
        localbvk.bNK = locala.KhF.readString();
        AppMethodBeat.o(152636);
        return 0;
      }
      AppMethodBeat.o(152636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvk
 * JD-Core Version:    0.7.0.1
 */