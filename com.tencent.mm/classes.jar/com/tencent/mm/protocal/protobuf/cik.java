package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cik
  extends com.tencent.mm.bx.a
{
  public String DOs;
  public String EdN;
  public String EdO;
  public String EdP;
  public String mBV;
  public String oXr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134253);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mBV != null) {
        paramVarArgs.d(1, this.mBV);
      }
      if (this.EdN != null) {
        paramVarArgs.d(2, this.EdN);
      }
      if (this.DOs != null) {
        paramVarArgs.d(3, this.DOs);
      }
      if (this.EdO != null) {
        paramVarArgs.d(4, this.EdO);
      }
      if (this.oXr != null) {
        paramVarArgs.d(5, this.oXr);
      }
      if (this.EdP != null) {
        paramVarArgs.d(6, this.EdP);
      }
      AppMethodBeat.o(134253);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mBV == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.mBV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EdN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EdN);
      }
      i = paramInt;
      if (this.DOs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DOs);
      }
      paramInt = i;
      if (this.EdO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EdO);
      }
      i = paramInt;
      if (this.oXr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oXr);
      }
      paramInt = i;
      if (this.EdP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EdP);
      }
      AppMethodBeat.o(134253);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(134253);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cik localcik = (cik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134253);
          return -1;
        case 1: 
          localcik.mBV = locala.KhF.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 2: 
          localcik.EdN = locala.KhF.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 3: 
          localcik.DOs = locala.KhF.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 4: 
          localcik.EdO = locala.KhF.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 5: 
          localcik.oXr = locala.KhF.readString();
          AppMethodBeat.o(134253);
          return 0;
        }
        localcik.EdP = locala.KhF.readString();
        AppMethodBeat.o(134253);
        return 0;
      }
      AppMethodBeat.o(134253);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cik
 * JD-Core Version:    0.7.0.1
 */