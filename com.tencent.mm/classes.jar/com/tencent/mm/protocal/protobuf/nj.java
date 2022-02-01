package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nj
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int YPk;
  public String YPl;
  public int YPm;
  public int YPn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124393);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      paramVarArgs.bS(2, this.YPk);
      if (this.YPl != null) {
        paramVarArgs.g(3, this.YPl);
      }
      paramVarArgs.bS(4, this.YPm);
      paramVarArgs.bS(5, this.YPn);
      AppMethodBeat.o(124393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YPk);
      paramInt = i;
      if (this.YPl != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YPl);
      }
      i = i.a.a.b.b.a.cJ(4, this.YPm);
      int j = i.a.a.b.b.a.cJ(5, this.YPn);
      AppMethodBeat.o(124393);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124393);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        nj localnj = (nj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124393);
          return -1;
        case 1: 
          localnj.UserName = locala.ajGk.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 2: 
          localnj.YPk = locala.ajGk.aar();
          AppMethodBeat.o(124393);
          return 0;
        case 3: 
          localnj.YPl = locala.ajGk.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 4: 
          localnj.YPm = locala.ajGk.aar();
          AppMethodBeat.o(124393);
          return 0;
        }
        localnj.YPn = locala.ajGk.aar();
        AppMethodBeat.o(124393);
        return 0;
      }
      AppMethodBeat.o(124393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nj
 * JD-Core Version:    0.7.0.1
 */