package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeq
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public int YHX;
  public int ZmF;
  public String ZmG;
  public int ZmH;
  public int ZmI;
  public int ZmJ;
  public int ZmK;
  public String content;
  public String openid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103206);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.g(1, this.content);
      }
      if (this.openid != null) {
        paramVarArgs.g(3, this.openid);
      }
      paramVarArgs.bS(4, this.HTK);
      paramVarArgs.bS(5, this.YHX);
      paramVarArgs.bS(6, this.ZmF);
      if (this.ZmG != null) {
        paramVarArgs.g(7, this.ZmG);
      }
      paramVarArgs.bS(8, this.ZmH);
      paramVarArgs.bS(9, this.ZmI);
      paramVarArgs.bS(10, this.ZmJ);
      paramVarArgs.bS(11, this.ZmK);
      AppMethodBeat.o(103206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = i.a.a.b.b.a.h(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.openid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.openid);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.HTK) + i.a.a.b.b.a.cJ(5, this.YHX) + i.a.a.b.b.a.cJ(6, this.ZmF);
      paramInt = i;
      if (this.ZmG != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZmG);
      }
      i = i.a.a.b.b.a.cJ(8, this.ZmH);
      int j = i.a.a.b.b.a.cJ(9, this.ZmI);
      int k = i.a.a.b.b.a.cJ(10, this.ZmJ);
      int m = i.a.a.b.b.a.cJ(11, this.ZmK);
      AppMethodBeat.o(103206);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(103206);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aeq localaeq = (aeq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 2: 
        default: 
          AppMethodBeat.o(103206);
          return -1;
        case 1: 
          localaeq.content = locala.ajGk.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 3: 
          localaeq.openid = locala.ajGk.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 4: 
          localaeq.HTK = locala.ajGk.aar();
          AppMethodBeat.o(103206);
          return 0;
        case 5: 
          localaeq.YHX = locala.ajGk.aar();
          AppMethodBeat.o(103206);
          return 0;
        case 6: 
          localaeq.ZmF = locala.ajGk.aar();
          AppMethodBeat.o(103206);
          return 0;
        case 7: 
          localaeq.ZmG = locala.ajGk.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 8: 
          localaeq.ZmH = locala.ajGk.aar();
          AppMethodBeat.o(103206);
          return 0;
        case 9: 
          localaeq.ZmI = locala.ajGk.aar();
          AppMethodBeat.o(103206);
          return 0;
        case 10: 
          localaeq.ZmJ = locala.ajGk.aar();
          AppMethodBeat.o(103206);
          return 0;
        }
        localaeq.ZmK = locala.ajGk.aar();
        AppMethodBeat.o(103206);
        return 0;
      }
      AppMethodBeat.o(103206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeq
 * JD-Core Version:    0.7.0.1
 */