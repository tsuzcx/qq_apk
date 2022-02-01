package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aji
  extends com.tencent.mm.bx.a
{
  public String GgA;
  public String SmallImgUrl;
  public int nDG;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.GgA != null) {
        paramVarArgs.d(2, this.GgA);
      }
      if (this.nEt != null) {
        paramVarArgs.d(3, this.nEt);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(4, this.SmallImgUrl);
      }
      paramVarArgs.aS(5, this.nDG);
      AppMethodBeat.o(32210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label449;
      }
    }
    label449:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GgA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GgA);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nEt);
      }
      paramInt = i;
      if (this.SmallImgUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.SmallImgUrl);
      }
      i = f.a.a.b.b.a.bz(5, this.nDG);
      AppMethodBeat.o(32210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32210);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aji localaji = (aji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32210);
          return -1;
        case 1: 
          localaji.nDo = locala.NPN.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 2: 
          localaji.GgA = locala.NPN.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 3: 
          localaji.nEt = locala.NPN.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 4: 
          localaji.SmallImgUrl = locala.NPN.readString();
          AppMethodBeat.o(32210);
          return 0;
        }
        localaji.nDG = locala.NPN.zc();
        AppMethodBeat.o(32210);
        return 0;
      }
      AppMethodBeat.o(32210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aji
 * JD-Core Version:    0.7.0.1
 */