package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uv
  extends com.tencent.mm.bw.a
{
  public int GcL;
  public String GmN;
  public String dJb;
  public int oEs;
  public String oIt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dJb != null) {
        paramVarArgs.d(1, this.dJb);
      }
      if (this.oIt != null) {
        paramVarArgs.d(2, this.oIt);
      }
      paramVarArgs.aS(3, this.oEs);
      paramVarArgs.aS(4, this.GcL);
      if (this.GmN != null) {
        paramVarArgs.d(5, this.GmN);
      }
      AppMethodBeat.o(113981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dJb == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.dJb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oIt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oIt);
      }
      i = i + f.a.a.b.b.a.bz(3, this.oEs) + f.a.a.b.b.a.bz(4, this.GcL);
      paramInt = i;
      if (this.GmN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GmN);
      }
      AppMethodBeat.o(113981);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113981);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        uv localuv = (uv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113981);
          return -1;
        case 1: 
          localuv.dJb = locala.OmT.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 2: 
          localuv.oIt = locala.OmT.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 3: 
          localuv.oEs = locala.OmT.zc();
          AppMethodBeat.o(113981);
          return 0;
        case 4: 
          localuv.GcL = locala.OmT.zc();
          AppMethodBeat.o(113981);
          return 0;
        }
        localuv.GmN = locala.OmT.readString();
        AppMethodBeat.o(113981);
        return 0;
      }
      AppMethodBeat.o(113981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uv
 * JD-Core Version:    0.7.0.1
 */