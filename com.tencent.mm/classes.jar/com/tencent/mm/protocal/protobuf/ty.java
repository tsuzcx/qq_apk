package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ty
  extends com.tencent.mm.bw.a
{
  public String GkO;
  public String GkP;
  public int GkQ;
  public int GkR;
  public int GkS;
  public int GkT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123560);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GkO != null) {
        paramVarArgs.d(1, this.GkO);
      }
      if (this.GkP != null) {
        paramVarArgs.d(2, this.GkP);
      }
      paramVarArgs.aS(3, this.GkQ);
      paramVarArgs.aS(4, this.GkR);
      paramVarArgs.aS(5, this.GkS);
      paramVarArgs.aS(6, this.GkT);
      AppMethodBeat.o(123560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GkO == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.GkO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GkP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GkP);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GkQ);
      int j = f.a.a.b.b.a.bz(4, this.GkR);
      int k = f.a.a.b.b.a.bz(5, this.GkS);
      int m = f.a.a.b.b.a.bz(6, this.GkT);
      AppMethodBeat.o(123560);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123560);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ty localty = (ty)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123560);
          return -1;
        case 1: 
          localty.GkO = locala.OmT.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 2: 
          localty.GkP = locala.OmT.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 3: 
          localty.GkQ = locala.OmT.zc();
          AppMethodBeat.o(123560);
          return 0;
        case 4: 
          localty.GkR = locala.OmT.zc();
          AppMethodBeat.o(123560);
          return 0;
        case 5: 
          localty.GkS = locala.OmT.zc();
          AppMethodBeat.o(123560);
          return 0;
        }
        localty.GkT = locala.OmT.zc();
        AppMethodBeat.o(123560);
        return 0;
      }
      AppMethodBeat.o(123560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ty
 * JD-Core Version:    0.7.0.1
 */