package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajs
  extends com.tencent.mm.bw.a
{
  public String Gzj;
  public String SmallImgUrl;
  public String nIJ;
  public String nJO;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.Gzj != null) {
        paramVarArgs.d(2, this.Gzj);
      }
      if (this.nJO != null) {
        paramVarArgs.d(3, this.nJO);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(4, this.SmallImgUrl);
      }
      paramVarArgs.aS(5, this.nJb);
      AppMethodBeat.o(32210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label449;
      }
    }
    label449:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gzj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gzj);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nJO);
      }
      paramInt = i;
      if (this.SmallImgUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.SmallImgUrl);
      }
      i = f.a.a.b.b.a.bz(5, this.nJb);
      AppMethodBeat.o(32210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32210);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ajs localajs = (ajs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32210);
          return -1;
        case 1: 
          localajs.nIJ = locala.OmT.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 2: 
          localajs.Gzj = locala.OmT.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 3: 
          localajs.nJO = locala.OmT.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 4: 
          localajs.SmallImgUrl = locala.OmT.readString();
          AppMethodBeat.o(32210);
          return 0;
        }
        localajs.nJb = locala.OmT.zc();
        AppMethodBeat.o(32210);
        return 0;
      }
      AppMethodBeat.o(32210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajs
 * JD-Core Version:    0.7.0.1
 */