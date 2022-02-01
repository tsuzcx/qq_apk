package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wo
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b CYH;
  public com.tencent.mm.bx.b CYI;
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
      if (this.CYH == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: version");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.CYI == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: clientcheckdata");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.CYH != null) {
        paramVarArgs.c(1, this.CYH);
      }
      paramVarArgs.aR(2, this.type);
      if (this.CYI != null) {
        paramVarArgs.c(3, this.CYI);
      }
      paramVarArgs.aG(4, this.timestamp);
      paramVarArgs.aR(5, this.dataType);
      paramVarArgs.aR(6, this.status);
      AppMethodBeat.o(145667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CYH == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.b.b.a.b(1, this.CYH) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.type);
      paramInt = i;
      if (this.CYI != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.CYI);
      }
      i = f.a.a.b.b.a.q(4, this.timestamp);
      int j = f.a.a.b.b.a.bA(5, this.dataType);
      int k = f.a.a.b.b.a.bA(6, this.status);
      AppMethodBeat.o(145667);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CYH == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: version");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        if (this.CYI == null)
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
        wo localwo = (wo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145667);
          return -1;
        case 1: 
          localwo.CYH = locala.KhF.fMu();
          AppMethodBeat.o(145667);
          return 0;
        case 2: 
          localwo.type = locala.KhF.xS();
          AppMethodBeat.o(145667);
          return 0;
        case 3: 
          localwo.CYI = locala.KhF.fMu();
          AppMethodBeat.o(145667);
          return 0;
        case 4: 
          localwo.timestamp = locala.KhF.xT();
          AppMethodBeat.o(145667);
          return 0;
        case 5: 
          localwo.dataType = locala.KhF.xS();
          AppMethodBeat.o(145667);
          return 0;
        }
        localwo.status = locala.KhF.xS();
        AppMethodBeat.o(145667);
        return 0;
      }
      AppMethodBeat.o(145667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wo
 * JD-Core Version:    0.7.0.1
 */