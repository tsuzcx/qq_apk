package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqk
  extends com.tencent.mm.bw.a
{
  public String GHi;
  public String GHj;
  public String GHk;
  public String GHl;
  public int GHm;
  public String GHn;
  public String GHo;
  public String appName;
  public String jpU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169017);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GHi != null) {
        paramVarArgs.d(1, this.GHi);
      }
      if (this.GHj != null) {
        paramVarArgs.d(2, this.GHj);
      }
      if (this.GHk != null) {
        paramVarArgs.d(3, this.GHk);
      }
      if (this.appName != null) {
        paramVarArgs.d(4, this.appName);
      }
      if (this.GHl != null) {
        paramVarArgs.d(5, this.GHl);
      }
      if (this.jpU != null) {
        paramVarArgs.d(6, this.jpU);
      }
      paramVarArgs.aS(7, this.GHm);
      if (this.GHn != null) {
        paramVarArgs.d(8, this.GHn);
      }
      if (this.GHo != null) {
        paramVarArgs.d(9, this.GHo);
      }
      AppMethodBeat.o(169017);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GHi == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.GHi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GHj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GHj);
      }
      i = paramInt;
      if (this.GHk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GHk);
      }
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.appName);
      }
      i = paramInt;
      if (this.GHl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GHl);
      }
      paramInt = i;
      if (this.jpU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jpU);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GHm);
      paramInt = i;
      if (this.GHn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GHn);
      }
      i = paramInt;
      if (this.GHo != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GHo);
      }
      AppMethodBeat.o(169017);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169017);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aqk localaqk = (aqk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169017);
          return -1;
        case 1: 
          localaqk.GHi = locala.OmT.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 2: 
          localaqk.GHj = locala.OmT.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 3: 
          localaqk.GHk = locala.OmT.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 4: 
          localaqk.appName = locala.OmT.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 5: 
          localaqk.GHl = locala.OmT.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 6: 
          localaqk.jpU = locala.OmT.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 7: 
          localaqk.GHm = locala.OmT.zc();
          AppMethodBeat.o(169017);
          return 0;
        case 8: 
          localaqk.GHn = locala.OmT.readString();
          AppMethodBeat.o(169017);
          return 0;
        }
        localaqk.GHo = locala.OmT.readString();
        AppMethodBeat.o(169017);
        return 0;
      }
      AppMethodBeat.o(169017);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqk
 * JD-Core Version:    0.7.0.1
 */