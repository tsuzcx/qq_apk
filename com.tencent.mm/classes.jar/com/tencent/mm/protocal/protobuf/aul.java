package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aul
  extends com.tencent.mm.bw.a
{
  public int LFn;
  public long LFo;
  public String dMW;
  public String iAR;
  public int likeFlag;
  public String nickName;
  public long tsR;
  public int unreadFlag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209478);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickName != null) {
        paramVarArgs.e(1, this.nickName);
      }
      if (this.iAR != null) {
        paramVarArgs.e(2, this.iAR);
      }
      paramVarArgs.bb(3, this.tsR);
      paramVarArgs.aM(4, this.likeFlag);
      paramVarArgs.aM(5, this.LFn);
      if (this.dMW != null) {
        paramVarArgs.e(6, this.dMW);
      }
      paramVarArgs.bb(7, this.LFo);
      paramVarArgs.aM(8, this.unreadFlag);
      AppMethodBeat.o(209478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickName == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = g.a.a.b.b.a.f(1, this.nickName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iAR != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.iAR);
      }
      i = i + g.a.a.b.b.a.r(3, this.tsR) + g.a.a.b.b.a.bu(4, this.likeFlag) + g.a.a.b.b.a.bu(5, this.LFn);
      paramInt = i;
      if (this.dMW != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dMW);
      }
      i = g.a.a.b.b.a.r(7, this.LFo);
      int j = g.a.a.b.b.a.bu(8, this.unreadFlag);
      AppMethodBeat.o(209478);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209478);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aul localaul = (aul)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209478);
          return -1;
        case 1: 
          localaul.nickName = locala.UbS.readString();
          AppMethodBeat.o(209478);
          return 0;
        case 2: 
          localaul.iAR = locala.UbS.readString();
          AppMethodBeat.o(209478);
          return 0;
        case 3: 
          localaul.tsR = locala.UbS.zl();
          AppMethodBeat.o(209478);
          return 0;
        case 4: 
          localaul.likeFlag = locala.UbS.zi();
          AppMethodBeat.o(209478);
          return 0;
        case 5: 
          localaul.LFn = locala.UbS.zi();
          AppMethodBeat.o(209478);
          return 0;
        case 6: 
          localaul.dMW = locala.UbS.readString();
          AppMethodBeat.o(209478);
          return 0;
        case 7: 
          localaul.LFo = locala.UbS.zl();
          AppMethodBeat.o(209478);
          return 0;
        }
        localaul.unreadFlag = locala.UbS.zi();
        AppMethodBeat.o(209478);
        return 0;
      }
      AppMethodBeat.o(209478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aul
 * JD-Core Version:    0.7.0.1
 */