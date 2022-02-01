package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yy
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b FYB;
  public com.tencent.mm.bx.b FYC;
  public int dataType;
  public int status;
  public long timestamp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FYB == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: version");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.FYC == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: clientcheckdata");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.FYB != null) {
        paramVarArgs.c(1, this.FYB);
      }
      paramVarArgs.aS(2, this.type);
      if (this.FYC != null) {
        paramVarArgs.c(3, this.FYC);
      }
      paramVarArgs.aY(4, this.timestamp);
      paramVarArgs.aS(5, this.dataType);
      paramVarArgs.aS(6, this.status);
      AppMethodBeat.o(145667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FYB == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.b.b.a.b(1, this.FYB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.FYC != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.FYC);
      }
      i = f.a.a.b.b.a.p(4, this.timestamp);
      int j = f.a.a.b.b.a.bz(5, this.dataType);
      int k = f.a.a.b.b.a.bz(6, this.status);
      AppMethodBeat.o(145667);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FYB == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: version");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        if (this.FYC == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: clientcheckdata");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(145667);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        yy localyy = (yy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145667);
          return -1;
        case 1: 
          localyy.FYB = locala.NPN.gxI();
          AppMethodBeat.o(145667);
          return 0;
        case 2: 
          localyy.type = locala.NPN.zc();
          AppMethodBeat.o(145667);
          return 0;
        case 3: 
          localyy.FYC = locala.NPN.gxI();
          AppMethodBeat.o(145667);
          return 0;
        case 4: 
          localyy.timestamp = locala.NPN.zd();
          AppMethodBeat.o(145667);
          return 0;
        case 5: 
          localyy.dataType = locala.NPN.zc();
          AppMethodBeat.o(145667);
          return 0;
        }
        localyy.status = locala.NPN.zc();
        AppMethodBeat.o(145667);
        return 0;
      }
      AppMethodBeat.o(145667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yy
 * JD-Core Version:    0.7.0.1
 */