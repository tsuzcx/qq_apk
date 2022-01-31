package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccb
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String URL;
  public String wQr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28655);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.e(1, this.URL);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.wQr != null) {
        paramVarArgs.e(3, this.wQr);
      }
      AppMethodBeat.o(28655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label343;
      }
    }
    label343:
    for (int i = e.a.a.b.b.a.f(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.wQr != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wQr);
      }
      AppMethodBeat.o(28655);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28655);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ccb localccb = (ccb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28655);
          return -1;
        case 1: 
          localccb.URL = locala.CLY.readString();
          AppMethodBeat.o(28655);
          return 0;
        case 2: 
          localccb.Title = locala.CLY.readString();
          AppMethodBeat.o(28655);
          return 0;
        }
        localccb.wQr = locala.CLY.readString();
        AppMethodBeat.o(28655);
        return 0;
      }
      AppMethodBeat.o(28655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccb
 * JD-Core Version:    0.7.0.1
 */