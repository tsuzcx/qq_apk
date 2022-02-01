package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rs
  extends com.tencent.mm.bx.a
{
  public int CSA;
  public int CSB;
  public String CSw;
  public String CSx;
  public int CSy;
  public int CSz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123560);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CSw != null) {
        paramVarArgs.d(1, this.CSw);
      }
      if (this.CSx != null) {
        paramVarArgs.d(2, this.CSx);
      }
      paramVarArgs.aR(3, this.CSy);
      paramVarArgs.aR(4, this.CSz);
      paramVarArgs.aR(5, this.CSA);
      paramVarArgs.aR(6, this.CSB);
      AppMethodBeat.o(123560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CSw == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.CSw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CSx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CSx);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.CSy);
      int j = f.a.a.b.b.a.bA(4, this.CSz);
      int k = f.a.a.b.b.a.bA(5, this.CSA);
      int m = f.a.a.b.b.a.bA(6, this.CSB);
      AppMethodBeat.o(123560);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123560);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rs localrs = (rs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123560);
          return -1;
        case 1: 
          localrs.CSw = locala.KhF.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 2: 
          localrs.CSx = locala.KhF.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 3: 
          localrs.CSy = locala.KhF.xS();
          AppMethodBeat.o(123560);
          return 0;
        case 4: 
          localrs.CSz = locala.KhF.xS();
          AppMethodBeat.o(123560);
          return 0;
        case 5: 
          localrs.CSA = locala.KhF.xS();
          AppMethodBeat.o(123560);
          return 0;
        }
        localrs.CSB = locala.KhF.xS();
        AppMethodBeat.o(123560);
        return 0;
      }
      AppMethodBeat.o(123560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rs
 * JD-Core Version:    0.7.0.1
 */