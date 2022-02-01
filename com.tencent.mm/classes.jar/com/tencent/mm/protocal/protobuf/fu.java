package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fu
  extends com.tencent.mm.bw.a
{
  public String FQA;
  public int FQB;
  public int FQv;
  public int FQw;
  public int FQx;
  public int FQy;
  public int FQz;
  public int height;
  public long otU;
  public String url;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103201);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aS(2, this.FQv);
      paramVarArgs.aS(3, this.FQw);
      paramVarArgs.aZ(4, this.otU);
      paramVarArgs.aS(5, this.width);
      paramVarArgs.aS(6, this.height);
      paramVarArgs.aS(10, this.FQx);
      paramVarArgs.aS(11, this.FQy);
      paramVarArgs.aS(12, this.FQz);
      if (this.FQA != null) {
        paramVarArgs.d(13, this.FQA);
      }
      paramVarArgs.aS(15, this.FQB);
      AppMethodBeat.o(103201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FQv) + f.a.a.b.b.a.bz(3, this.FQw) + f.a.a.b.b.a.p(4, this.otU) + f.a.a.b.b.a.bz(5, this.width) + f.a.a.b.b.a.bz(6, this.height) + f.a.a.b.b.a.bz(10, this.FQx) + f.a.a.b.b.a.bz(11, this.FQy) + f.a.a.b.b.a.bz(12, this.FQz);
      paramInt = i;
      if (this.FQA != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FQA);
      }
      i = f.a.a.b.b.a.bz(15, this.FQB);
      AppMethodBeat.o(103201);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(103201);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fu localfu = (fu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        case 8: 
        case 9: 
        case 14: 
        default: 
          AppMethodBeat.o(103201);
          return -1;
        case 1: 
          localfu.url = locala.OmT.readString();
          AppMethodBeat.o(103201);
          return 0;
        case 2: 
          localfu.FQv = locala.OmT.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 3: 
          localfu.FQw = locala.OmT.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 4: 
          localfu.otU = locala.OmT.zd();
          AppMethodBeat.o(103201);
          return 0;
        case 5: 
          localfu.width = locala.OmT.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 6: 
          localfu.height = locala.OmT.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 10: 
          localfu.FQx = locala.OmT.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 11: 
          localfu.FQy = locala.OmT.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 12: 
          localfu.FQz = locala.OmT.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 13: 
          localfu.FQA = locala.OmT.readString();
          AppMethodBeat.o(103201);
          return 0;
        }
        localfu.FQB = locala.OmT.zc();
        AppMethodBeat.o(103201);
        return 0;
      }
      AppMethodBeat.o(103201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fu
 * JD-Core Version:    0.7.0.1
 */