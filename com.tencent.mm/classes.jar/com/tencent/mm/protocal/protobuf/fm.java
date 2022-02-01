package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fm
  extends com.tencent.mm.bx.a
{
  public int ReqType;
  public String Url;
  public String gKn;
  public int gKq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124391);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gKn != null) {
        paramVarArgs.d(1, this.gKn);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      paramVarArgs.aR(3, this.ReqType);
      paramVarArgs.aR(4, this.gKq);
      AppMethodBeat.o(124391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gKn == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.gKn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Url);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.ReqType);
      int j = f.a.a.b.b.a.bA(4, this.gKq);
      AppMethodBeat.o(124391);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124391);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fm localfm = (fm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124391);
          return -1;
        case 1: 
          localfm.gKn = locala.KhF.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 2: 
          localfm.Url = locala.KhF.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 3: 
          localfm.ReqType = locala.KhF.xS();
          AppMethodBeat.o(124391);
          return 0;
        }
        localfm.gKq = locala.KhF.xS();
        AppMethodBeat.o(124391);
        return 0;
      }
      AppMethodBeat.o(124391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fm
 * JD-Core Version:    0.7.0.1
 */