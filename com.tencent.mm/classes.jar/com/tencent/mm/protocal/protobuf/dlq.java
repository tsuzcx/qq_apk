package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlq
  extends com.tencent.mm.bx.a
{
  public String FJT;
  public int FuX;
  public String HAa;
  public String jdf;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      paramVarArgs.aS(3, this.FuX);
      if (this.HAa != null) {
        paramVarArgs.d(4, this.HAa);
      }
      if (this.jdf != null) {
        paramVarArgs.d(5, this.jdf);
      }
      if (this.FJT != null) {
        paramVarArgs.d(6, this.FJT);
      }
      AppMethodBeat.o(124559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nEt);
      }
      i += f.a.a.b.b.a.bz(3, this.FuX);
      paramInt = i;
      if (this.HAa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HAa);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jdf);
      }
      paramInt = i;
      if (this.FJT != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FJT);
      }
      AppMethodBeat.o(124559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124559);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dlq localdlq = (dlq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124559);
          return -1;
        case 1: 
          localdlq.nDo = locala.NPN.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 2: 
          localdlq.nEt = locala.NPN.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 3: 
          localdlq.FuX = locala.NPN.zc();
          AppMethodBeat.o(124559);
          return 0;
        case 4: 
          localdlq.HAa = locala.NPN.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 5: 
          localdlq.jdf = locala.NPN.readString();
          AppMethodBeat.o(124559);
          return 0;
        }
        localdlq.FJT = locala.NPN.readString();
        AppMethodBeat.o(124559);
        return 0;
      }
      AppMethodBeat.o(124559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlq
 * JD-Core Version:    0.7.0.1
 */