package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caz
  extends com.tencent.mm.bx.a
{
  public int DBz;
  public String DXn;
  public String DcE;
  public String DwR;
  public String zPB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DwR != null) {
        paramVarArgs.d(1, this.DwR);
      }
      if (this.DXn != null) {
        paramVarArgs.d(2, this.DXn);
      }
      if (this.zPB != null) {
        paramVarArgs.d(3, this.zPB);
      }
      if (this.DcE != null) {
        paramVarArgs.d(4, this.DcE);
      }
      paramVarArgs.aR(5, this.DBz);
      AppMethodBeat.o(72549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DwR == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.DwR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DXn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DXn);
      }
      i = paramInt;
      if (this.zPB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.zPB);
      }
      paramInt = i;
      if (this.DcE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DcE);
      }
      i = f.a.a.b.b.a.bA(5, this.DBz);
      AppMethodBeat.o(72549);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72549);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        caz localcaz = (caz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72549);
          return -1;
        case 1: 
          localcaz.DwR = locala.KhF.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 2: 
          localcaz.DXn = locala.KhF.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 3: 
          localcaz.zPB = locala.KhF.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 4: 
          localcaz.DcE = locala.KhF.readString();
          AppMethodBeat.o(72549);
          return 0;
        }
        localcaz.DBz = locala.KhF.xS();
        AppMethodBeat.o(72549);
        return 0;
      }
      AppMethodBeat.o(72549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caz
 * JD-Core Version:    0.7.0.1
 */