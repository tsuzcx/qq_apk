package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acv
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b Zls;
  public com.tencent.mm.bx.b Zlt;
  public int dataType;
  public int status;
  public long timestamp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145667);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zls == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: version");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.Zlt == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: clientcheckdata");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.Zls != null) {
        paramVarArgs.d(1, this.Zls);
      }
      paramVarArgs.bS(2, this.type);
      if (this.Zlt != null) {
        paramVarArgs.d(3, this.Zlt);
      }
      paramVarArgs.bv(4, this.timestamp);
      paramVarArgs.bS(5, this.dataType);
      paramVarArgs.bS(6, this.status);
      AppMethodBeat.o(145667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zls == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = i.a.a.b.b.a.c(1, this.Zls) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.Zlt != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.Zlt);
      }
      i = i.a.a.b.b.a.q(4, this.timestamp);
      int j = i.a.a.b.b.a.cJ(5, this.dataType);
      int k = i.a.a.b.b.a.cJ(6, this.status);
      AppMethodBeat.o(145667);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Zls == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: version");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        if (this.Zlt == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: clientcheckdata");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(145667);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        acv localacv = (acv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145667);
          return -1;
        case 1: 
          localacv.Zls = locala.ajGk.kFX();
          AppMethodBeat.o(145667);
          return 0;
        case 2: 
          localacv.type = locala.ajGk.aar();
          AppMethodBeat.o(145667);
          return 0;
        case 3: 
          localacv.Zlt = locala.ajGk.kFX();
          AppMethodBeat.o(145667);
          return 0;
        case 4: 
          localacv.timestamp = locala.ajGk.aaw();
          AppMethodBeat.o(145667);
          return 0;
        case 5: 
          localacv.dataType = locala.ajGk.aar();
          AppMethodBeat.o(145667);
          return 0;
        }
        localacv.status = locala.ajGk.aar();
        AppMethodBeat.o(145667);
        return 0;
      }
      AppMethodBeat.o(145667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acv
 * JD-Core Version:    0.7.0.1
 */