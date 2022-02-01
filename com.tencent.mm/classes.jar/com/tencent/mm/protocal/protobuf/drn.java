package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drn
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public long Njv;
  public String UserName;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138184);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      paramVarArgs.bv(4, this.Njv);
      AppMethodBeat.o(138184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.UserName);
      }
      paramInt = i.a.a.b.b.a.q(4, this.Njv);
      AppMethodBeat.o(138184);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(138184);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        drn localdrn = (drn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138184);
          return -1;
        case 1: 
          localdrn.hAP = locala.ajGk.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 2: 
          localdrn.IGG = locala.ajGk.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 3: 
          localdrn.UserName = locala.ajGk.readString();
          AppMethodBeat.o(138184);
          return 0;
        }
        localdrn.Njv = locala.ajGk.aaw();
        AppMethodBeat.o(138184);
        return 0;
      }
      AppMethodBeat.o(138184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drn
 * JD-Core Version:    0.7.0.1
 */