package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
  extends com.tencent.mm.bx.a
{
  public String nsA;
  public String nsB;
  public String nsy;
  public String nsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113931);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nsy != null) {
        paramVarArgs.d(1, this.nsy);
      }
      if (this.nsz != null) {
        paramVarArgs.d(2, this.nsz);
      }
      if (this.nsA != null) {
        paramVarArgs.d(3, this.nsA);
      }
      if (this.nsB != null) {
        paramVarArgs.d(4, this.nsB);
      }
      AppMethodBeat.o(113931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nsy == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.nsy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nsz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nsz);
      }
      i = paramInt;
      if (this.nsA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nsA);
      }
      paramInt = i;
      if (this.nsB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nsB);
      }
      AppMethodBeat.o(113931);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113931);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        as localas = (as)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113931);
          return -1;
        case 1: 
          localas.nsy = locala.KhF.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 2: 
          localas.nsz = locala.KhF.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 3: 
          localas.nsA = locala.KhF.readString();
          AppMethodBeat.o(113931);
          return 0;
        }
        localas.nsB = locala.KhF.readString();
        AppMethodBeat.o(113931);
        return 0;
      }
      AppMethodBeat.o(113931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.as
 * JD-Core Version:    0.7.0.1
 */