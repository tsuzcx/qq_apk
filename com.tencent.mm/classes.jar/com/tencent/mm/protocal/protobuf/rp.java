package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rp
  extends com.tencent.mm.bx.a
{
  public String CSr;
  public String code;
  public String dlB;
  public String nrr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113977);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nrr != null) {
        paramVarArgs.d(1, this.nrr);
      }
      if (this.code != null) {
        paramVarArgs.d(2, this.code);
      }
      if (this.CSr != null) {
        paramVarArgs.d(3, this.CSr);
      }
      if (this.dlB != null) {
        paramVarArgs.d(4, this.dlB);
      }
      AppMethodBeat.o(113977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nrr == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.nrr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.code != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.code);
      }
      i = paramInt;
      if (this.CSr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CSr);
      }
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dlB);
      }
      AppMethodBeat.o(113977);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113977);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rp localrp = (rp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113977);
          return -1;
        case 1: 
          localrp.nrr = locala.KhF.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 2: 
          localrp.code = locala.KhF.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 3: 
          localrp.CSr = locala.KhF.readString();
          AppMethodBeat.o(113977);
          return 0;
        }
        localrp.dlB = locala.KhF.readString();
        AppMethodBeat.o(113977);
        return 0;
      }
      AppMethodBeat.o(113977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rp
 * JD-Core Version:    0.7.0.1
 */