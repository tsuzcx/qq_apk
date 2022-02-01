package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbh
  extends com.tencent.mm.bx.a
{
  public String YBb;
  public String YBc;
  public int YBd;
  public String comment;
  public String iaI;
  public String iaJ;
  public String wsy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114073);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.iaI != null) {
        paramVarArgs.g(1, this.iaI);
      }
      if (this.wsy != null) {
        paramVarArgs.g(2, this.wsy);
      }
      if (this.iaJ != null) {
        paramVarArgs.g(3, this.iaJ);
      }
      if (this.YBb != null) {
        paramVarArgs.g(4, this.YBb);
      }
      if (this.YBc != null) {
        paramVarArgs.g(5, this.YBc);
      }
      paramVarArgs.bS(6, this.YBd);
      if (this.comment != null) {
        paramVarArgs.g(7, this.comment);
      }
      AppMethodBeat.o(114073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iaI == null) {
        break label558;
      }
    }
    label558:
    for (int i = i.a.a.b.b.a.h(1, this.iaI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wsy);
      }
      i = paramInt;
      if (this.iaJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.iaJ);
      }
      paramInt = i;
      if (this.YBb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YBb);
      }
      i = paramInt;
      if (this.YBc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YBc);
      }
      i += i.a.a.b.b.a.cJ(6, this.YBd);
      paramInt = i;
      if (this.comment != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.comment);
      }
      AppMethodBeat.o(114073);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114073);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fbh localfbh = (fbh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114073);
          return -1;
        case 1: 
          localfbh.iaI = locala.ajGk.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 2: 
          localfbh.wsy = locala.ajGk.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 3: 
          localfbh.iaJ = locala.ajGk.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 4: 
          localfbh.YBb = locala.ajGk.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 5: 
          localfbh.YBc = locala.ajGk.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 6: 
          localfbh.YBd = locala.ajGk.aar();
          AppMethodBeat.o(114073);
          return 0;
        }
        localfbh.comment = locala.ajGk.readString();
        AppMethodBeat.o(114073);
        return 0;
      }
      AppMethodBeat.o(114073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbh
 * JD-Core Version:    0.7.0.1
 */