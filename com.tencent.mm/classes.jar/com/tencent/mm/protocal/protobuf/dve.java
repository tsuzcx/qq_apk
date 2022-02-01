package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dve
  extends com.tencent.mm.bx.a
{
  public String aaAp;
  public int abbc;
  public String desc;
  public String scope;
  public String tIs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82463);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.bS(3, this.abbc);
      if (this.tIs != null) {
        paramVarArgs.g(4, this.tIs);
      }
      if (this.aaAp != null) {
        paramVarArgs.g(5, this.aaAp);
      }
      AppMethodBeat.o(82463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      i += i.a.a.b.b.a.cJ(3, this.abbc);
      paramInt = i;
      if (this.tIs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.tIs);
      }
      i = paramInt;
      if (this.aaAp != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaAp);
      }
      AppMethodBeat.o(82463);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82463);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dve localdve = (dve)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82463);
          return -1;
        case 1: 
          localdve.scope = locala.ajGk.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 2: 
          localdve.desc = locala.ajGk.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 3: 
          localdve.abbc = locala.ajGk.aar();
          AppMethodBeat.o(82463);
          return 0;
        case 4: 
          localdve.tIs = locala.ajGk.readString();
          AppMethodBeat.o(82463);
          return 0;
        }
        localdve.aaAp = locala.ajGk.readString();
        AppMethodBeat.o(82463);
        return 0;
      }
      AppMethodBeat.o(82463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dve
 * JD-Core Version:    0.7.0.1
 */