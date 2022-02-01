package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class aqo
  extends com.tencent.mm.bx.a
{
  public long Fzm;
  public long ZxF;
  public long ZxG;
  public long ZxH;
  public int ZxI;
  public String msgId;
  public int qvp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259141);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.qvp);
      if (this.msgId != null) {
        paramVarArgs.g(2, this.msgId);
      }
      paramVarArgs.bv(3, this.ZxF);
      paramVarArgs.bv(4, this.ZxG);
      paramVarArgs.bv(5, this.ZxH);
      paramVarArgs.bS(6, this.ZxI);
      paramVarArgs.bv(7, this.Fzm);
      AppMethodBeat.o(259141);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.qvp) + 0;
      paramInt = i;
      if (this.msgId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.msgId);
      }
      i = i.a.a.b.b.a.q(3, this.ZxF);
      int j = i.a.a.b.b.a.q(4, this.ZxG);
      int k = i.a.a.b.b.a.q(5, this.ZxH);
      int m = i.a.a.b.b.a.cJ(6, this.ZxI);
      int n = i.a.a.b.b.a.q(7, this.Fzm);
      AppMethodBeat.o(259141);
      return paramInt + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259141);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aqo localaqo = (aqo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259141);
        return -1;
      case 1: 
        localaqo.qvp = locala.ajGk.aar();
        AppMethodBeat.o(259141);
        return 0;
      case 2: 
        localaqo.msgId = locala.ajGk.readString();
        AppMethodBeat.o(259141);
        return 0;
      case 3: 
        localaqo.ZxF = locala.ajGk.aaw();
        AppMethodBeat.o(259141);
        return 0;
      case 4: 
        localaqo.ZxG = locala.ajGk.aaw();
        AppMethodBeat.o(259141);
        return 0;
      case 5: 
        localaqo.ZxH = locala.ajGk.aaw();
        AppMethodBeat.o(259141);
        return 0;
      case 6: 
        localaqo.ZxI = locala.ajGk.aar();
        AppMethodBeat.o(259141);
        return 0;
      }
      localaqo.Fzm = locala.ajGk.aaw();
      AppMethodBeat.o(259141);
      return 0;
    }
    AppMethodBeat.o(259141);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqo
 * JD-Core Version:    0.7.0.1
 */