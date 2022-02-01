package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dde
  extends com.tencent.mm.bx.a
{
  public int YJF;
  public String aaAp;
  public String aaIK;
  public String auth_desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82432);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaIK != null) {
        paramVarArgs.g(1, this.aaIK);
      }
      paramVarArgs.bS(2, this.YJF);
      if (this.auth_desc != null) {
        paramVarArgs.g(3, this.auth_desc);
      }
      if (this.aaAp != null) {
        paramVarArgs.g(4, this.aaAp);
      }
      AppMethodBeat.o(82432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaIK == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaIK) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YJF);
      paramInt = i;
      if (this.auth_desc != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.auth_desc);
      }
      i = paramInt;
      if (this.aaAp != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaAp);
      }
      AppMethodBeat.o(82432);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82432);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dde localdde = (dde)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82432);
          return -1;
        case 1: 
          localdde.aaIK = locala.ajGk.readString();
          AppMethodBeat.o(82432);
          return 0;
        case 2: 
          localdde.YJF = locala.ajGk.aar();
          AppMethodBeat.o(82432);
          return 0;
        case 3: 
          localdde.auth_desc = locala.ajGk.readString();
          AppMethodBeat.o(82432);
          return 0;
        }
        localdde.aaAp = locala.ajGk.readString();
        AppMethodBeat.o(82432);
        return 0;
      }
      AppMethodBeat.o(82432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dde
 * JD-Core Version:    0.7.0.1
 */