package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fvp
  extends com.tencent.mm.bx.a
{
  public long Zmx;
  public String Zmy;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121106);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(121106);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.g(1, this.key);
      }
      paramVarArgs.bv(2, this.Zmx);
      if (this.Zmy != null) {
        paramVarArgs.g(3, this.Zmy);
      }
      AppMethodBeat.o(121106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Zmx);
      paramInt = i;
      if (this.Zmy != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zmy);
      }
      AppMethodBeat.o(121106);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(121106);
          throw paramVarArgs;
        }
        AppMethodBeat.o(121106);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fvp localfvp = (fvp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(121106);
          return -1;
        case 1: 
          localfvp.key = locala.ajGk.readString();
          AppMethodBeat.o(121106);
          return 0;
        case 2: 
          localfvp.Zmx = locala.ajGk.aaw();
          AppMethodBeat.o(121106);
          return 0;
        }
        localfvp.Zmy = locala.ajGk.readString();
        AppMethodBeat.o(121106);
        return 0;
      }
      AppMethodBeat.o(121106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvp
 * JD-Core Version:    0.7.0.1
 */