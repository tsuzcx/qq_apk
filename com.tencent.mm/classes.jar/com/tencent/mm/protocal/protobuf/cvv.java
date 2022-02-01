package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvv
  extends com.tencent.mm.bw.a
{
  public String GXn;
  public int GXq;
  public int Gdl;
  public String dwb;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175247);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.GXn != null) {
        paramVarArgs.d(3, this.GXn);
      }
      paramVarArgs.aS(4, this.GXq);
      paramVarArgs.aS(5, this.Gdl);
      AppMethodBeat.o(175247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.dwb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.GXn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GXn);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GXq);
      int j = f.a.a.b.b.a.bz(5, this.Gdl);
      AppMethodBeat.o(175247);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(175247);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvv localcvv = (cvv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(175247);
          return -1;
        case 1: 
          localcvv.dwb = locala.OmT.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 2: 
          localcvv.username = locala.OmT.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 3: 
          localcvv.GXn = locala.OmT.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 4: 
          localcvv.GXq = locala.OmT.zc();
          AppMethodBeat.o(175247);
          return 0;
        }
        localcvv.Gdl = locala.OmT.zc();
        AppMethodBeat.o(175247);
        return 0;
      }
      AppMethodBeat.o(175247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvv
 * JD-Core Version:    0.7.0.1
 */