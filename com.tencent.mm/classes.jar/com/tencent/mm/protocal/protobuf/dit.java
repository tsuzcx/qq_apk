package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dit
  extends com.tencent.mm.bx.a
{
  public long HxD;
  public int HxE;
  public int HxF;
  public String ThumbUrl;
  public String nDo;
  public String uht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      paramVarArgs.aY(2, this.HxD);
      paramVarArgs.aS(3, this.HxE);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(4, this.ThumbUrl);
      }
      paramVarArgs.aS(5, this.HxF);
      if (this.uht != null) {
        paramVarArgs.d(6, this.uht);
      }
      AppMethodBeat.o(118434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HxD) + f.a.a.b.b.a.bz(3, this.HxE);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ThumbUrl);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HxF);
      paramInt = i;
      if (this.uht != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uht);
      }
      AppMethodBeat.o(118434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(118434);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dit localdit = (dit)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118434);
          return -1;
        case 1: 
          localdit.nDo = locala.NPN.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 2: 
          localdit.HxD = locala.NPN.zd();
          AppMethodBeat.o(118434);
          return 0;
        case 3: 
          localdit.HxE = locala.NPN.zc();
          AppMethodBeat.o(118434);
          return 0;
        case 4: 
          localdit.ThumbUrl = locala.NPN.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 5: 
          localdit.HxF = locala.NPN.zc();
          AppMethodBeat.o(118434);
          return 0;
        }
        localdit.uht = locala.NPN.readString();
        AppMethodBeat.o(118434);
        return 0;
      }
      AppMethodBeat.o(118434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dit
 * JD-Core Version:    0.7.0.1
 */