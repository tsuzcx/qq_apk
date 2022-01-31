package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqr
  extends com.tencent.mm.bv.a
{
  public String cqf;
  public String cwc;
  public String kwH;
  public String xZg;
  public String xlD;
  public String xmq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96315);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      if (this.cqf != null) {
        paramVarArgs.e(2, this.cqf);
      }
      if (this.xmq != null) {
        paramVarArgs.e(3, this.xmq);
      }
      if (this.xZg != null) {
        paramVarArgs.e(4, this.xZg);
      }
      if (this.kwH != null) {
        paramVarArgs.e(5, this.kwH);
      }
      if (this.xlD != null) {
        paramVarArgs.e(6, this.xlD);
      }
      AppMethodBeat.o(96315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label518;
      }
    }
    label518:
    for (int i = e.a.a.b.b.a.f(1, this.cwc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cqf != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cqf);
      }
      i = paramInt;
      if (this.xmq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xmq);
      }
      paramInt = i;
      if (this.xZg != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xZg);
      }
      i = paramInt;
      if (this.kwH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.kwH);
      }
      paramInt = i;
      if (this.xlD != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xlD);
      }
      AppMethodBeat.o(96315);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96315);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cqr localcqr = (cqr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96315);
          return -1;
        case 1: 
          localcqr.cwc = locala.CLY.readString();
          AppMethodBeat.o(96315);
          return 0;
        case 2: 
          localcqr.cqf = locala.CLY.readString();
          AppMethodBeat.o(96315);
          return 0;
        case 3: 
          localcqr.xmq = locala.CLY.readString();
          AppMethodBeat.o(96315);
          return 0;
        case 4: 
          localcqr.xZg = locala.CLY.readString();
          AppMethodBeat.o(96315);
          return 0;
        case 5: 
          localcqr.kwH = locala.CLY.readString();
          AppMethodBeat.o(96315);
          return 0;
        }
        localcqr.xlD = locala.CLY.readString();
        AppMethodBeat.o(96315);
        return 0;
      }
      AppMethodBeat.o(96315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqr
 * JD-Core Version:    0.7.0.1
 */