package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eat
  extends com.tencent.mm.bx.a
{
  public int CJZ;
  public String Lzi;
  public int Lzj;
  public String content;
  public String fvv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Lzi != null) {
        paramVarArgs.d(1, this.Lzi);
      }
      if (this.fvv != null) {
        paramVarArgs.d(2, this.fvv);
      }
      paramVarArgs.aR(3, this.CJZ);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aR(5, this.Lzj);
      AppMethodBeat.o(202517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lzi == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.Lzi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fvv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fvv);
      }
      i += f.a.a.b.b.a.bA(3, this.CJZ);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = f.a.a.b.b.a.bA(5, this.Lzj);
      AppMethodBeat.o(202517);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(202517);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eat localeat = (eat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(202517);
          return -1;
        case 1: 
          localeat.Lzi = locala.KhF.readString();
          AppMethodBeat.o(202517);
          return 0;
        case 2: 
          localeat.fvv = locala.KhF.readString();
          AppMethodBeat.o(202517);
          return 0;
        case 3: 
          localeat.CJZ = locala.KhF.xS();
          AppMethodBeat.o(202517);
          return 0;
        case 4: 
          localeat.content = locala.KhF.readString();
          AppMethodBeat.o(202517);
          return 0;
        }
        localeat.Lzj = locala.KhF.xS();
        AppMethodBeat.o(202517);
        return 0;
      }
      AppMethodBeat.o(202517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eat
 * JD-Core Version:    0.7.0.1
 */