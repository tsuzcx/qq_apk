package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class fqp
  extends com.tencent.mm.bx.a
{
  public b abQA;
  public b abQy;
  public String abQz;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82480);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abQy != null) {
        paramVarArgs.d(1, this.abQy);
      }
      if (this.abQz != null) {
        paramVarArgs.g(2, this.abQz);
      }
      if (this.abQA != null) {
        paramVarArgs.d(3, this.abQA);
      }
      paramVarArgs.bS(4, this.uin);
      AppMethodBeat.o(82480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abQy == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.c(1, this.abQy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abQz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abQz);
      }
      i = paramInt;
      if (this.abQA != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.abQA);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.uin);
      AppMethodBeat.o(82480);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82480);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fqp localfqp = (fqp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82480);
          return -1;
        case 1: 
          localfqp.abQy = locala.ajGk.kFX();
          AppMethodBeat.o(82480);
          return 0;
        case 2: 
          localfqp.abQz = locala.ajGk.readString();
          AppMethodBeat.o(82480);
          return 0;
        case 3: 
          localfqp.abQA = locala.ajGk.kFX();
          AppMethodBeat.o(82480);
          return 0;
        }
        localfqp.uin = locala.ajGk.aar();
        AppMethodBeat.o(82480);
        return 0;
      }
      AppMethodBeat.o(82480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqp
 * JD-Core Version:    0.7.0.1
 */