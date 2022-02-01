package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cst
  extends com.tencent.mm.bw.a
{
  public String FQl;
  public b GTp;
  public b GTq;
  public String Gdj;
  public String HDV;
  public b HDW;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdj != null) {
        paramVarArgs.d(1, this.Gdj);
      }
      if (this.HDV != null) {
        paramVarArgs.d(2, this.HDV);
      }
      if (this.FQl != null) {
        paramVarArgs.d(3, this.FQl);
      }
      if (this.GTq != null) {
        paramVarArgs.c(4, this.GTq);
      }
      if (this.GTp != null) {
        paramVarArgs.c(5, this.GTp);
      }
      paramVarArgs.aS(6, this.Scene);
      if (this.HDW != null) {
        paramVarArgs.c(7, this.HDW);
      }
      AppMethodBeat.o(104831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gdj == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.Gdj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HDV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HDV);
      }
      i = paramInt;
      if (this.FQl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FQl);
      }
      paramInt = i;
      if (this.GTq != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GTq);
      }
      i = paramInt;
      if (this.GTp != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.GTp);
      }
      i += f.a.a.b.b.a.bz(6, this.Scene);
      paramInt = i;
      if (this.HDW != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.HDW);
      }
      AppMethodBeat.o(104831);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104831);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cst localcst = (cst)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104831);
          return -1;
        case 1: 
          localcst.Gdj = locala.OmT.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 2: 
          localcst.HDV = locala.OmT.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 3: 
          localcst.FQl = locala.OmT.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 4: 
          localcst.GTq = locala.OmT.gCk();
          AppMethodBeat.o(104831);
          return 0;
        case 5: 
          localcst.GTp = locala.OmT.gCk();
          AppMethodBeat.o(104831);
          return 0;
        case 6: 
          localcst.Scene = locala.OmT.zc();
          AppMethodBeat.o(104831);
          return 0;
        }
        localcst.HDW = locala.OmT.gCk();
        AppMethodBeat.o(104831);
        return 0;
      }
      AppMethodBeat.o(104831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cst
 * JD-Core Version:    0.7.0.1
 */