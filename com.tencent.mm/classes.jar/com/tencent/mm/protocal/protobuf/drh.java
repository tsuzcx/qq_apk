package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drh
  extends com.tencent.mm.bx.a
{
  public String OQR;
  public int Zhu;
  public String aawp;
  public int block;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116456);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.OQR != null) {
        paramVarArgs.g(1, this.OQR);
      }
      paramVarArgs.bS(2, this.block);
      if (this.aawp != null) {
        paramVarArgs.g(3, this.aawp);
      }
      paramVarArgs.bS(4, this.Zhu);
      AppMethodBeat.o(116456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OQR == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.OQR) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.block);
      paramInt = i;
      if (this.aawp != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aawp);
      }
      i = i.a.a.b.b.a.cJ(4, this.Zhu);
      AppMethodBeat.o(116456);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116456);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        drh localdrh = (drh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116456);
          return -1;
        case 1: 
          localdrh.OQR = locala.ajGk.readString();
          AppMethodBeat.o(116456);
          return 0;
        case 2: 
          localdrh.block = locala.ajGk.aar();
          AppMethodBeat.o(116456);
          return 0;
        case 3: 
          localdrh.aawp = locala.ajGk.readString();
          AppMethodBeat.o(116456);
          return 0;
        }
        localdrh.Zhu = locala.ajGk.aar();
        AppMethodBeat.o(116456);
        return 0;
      }
      AppMethodBeat.o(116456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drh
 * JD-Core Version:    0.7.0.1
 */