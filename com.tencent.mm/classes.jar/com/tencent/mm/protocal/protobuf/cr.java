package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cr
  extends com.tencent.mm.bx.a
{
  public String Cxu;
  public int Cxv;
  public String Cxw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149137);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxu != null) {
        paramVarArgs.d(1, this.Cxu);
      }
      paramVarArgs.aR(2, this.Cxv);
      if (this.Cxw != null) {
        paramVarArgs.d(3, this.Cxw);
      }
      AppMethodBeat.o(149137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxu == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Cxu) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Cxv);
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Cxw);
      }
      AppMethodBeat.o(149137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(149137);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149137);
          return -1;
        case 1: 
          localcr.Cxu = locala.KhF.readString();
          AppMethodBeat.o(149137);
          return 0;
        case 2: 
          localcr.Cxv = locala.KhF.xS();
          AppMethodBeat.o(149137);
          return 0;
        }
        localcr.Cxw = locala.KhF.readString();
        AppMethodBeat.o(149137);
        return 0;
      }
      AppMethodBeat.o(149137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cr
 * JD-Core Version:    0.7.0.1
 */