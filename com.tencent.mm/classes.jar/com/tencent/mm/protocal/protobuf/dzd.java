package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzd
  extends com.tencent.mm.bx.a
{
  public int LxF;
  public String bNK;
  public String gLg;
  public String hKD;
  public int likeFlag;
  public long qou;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.bNK != null) {
        paramVarArgs.d(1, this.bNK);
      }
      if (this.gLg != null) {
        paramVarArgs.d(2, this.gLg);
      }
      paramVarArgs.aG(3, this.qou);
      paramVarArgs.aR(4, this.likeFlag);
      paramVarArgs.aR(5, this.LxF);
      if (this.hKD != null) {
        paramVarArgs.d(6, this.hKD);
      }
      AppMethodBeat.o(203860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bNK == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.bNK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gLg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gLg);
      }
      i = i + f.a.a.b.b.a.q(3, this.qou) + f.a.a.b.b.a.bA(4, this.likeFlag) + f.a.a.b.b.a.bA(5, this.LxF);
      paramInt = i;
      if (this.hKD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hKD);
      }
      AppMethodBeat.o(203860);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203860);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzd localdzd = (dzd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203860);
          return -1;
        case 1: 
          localdzd.bNK = locala.KhF.readString();
          AppMethodBeat.o(203860);
          return 0;
        case 2: 
          localdzd.gLg = locala.KhF.readString();
          AppMethodBeat.o(203860);
          return 0;
        case 3: 
          localdzd.qou = locala.KhF.xT();
          AppMethodBeat.o(203860);
          return 0;
        case 4: 
          localdzd.likeFlag = locala.KhF.xS();
          AppMethodBeat.o(203860);
          return 0;
        case 5: 
          localdzd.LxF = locala.KhF.xS();
          AppMethodBeat.o(203860);
          return 0;
        }
        localdzd.hKD = locala.KhF.readString();
        AppMethodBeat.o(203860);
        return 0;
      }
      AppMethodBeat.o(203860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzd
 * JD-Core Version:    0.7.0.1
 */