package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bw.a
{
  public long FIr;
  public String FIx;
  public long FIy;
  public int FIz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIx != null) {
        paramVarArgs.d(1, this.FIx);
      }
      paramVarArgs.aZ(2, this.FIr);
      paramVarArgs.aZ(3, this.FIy);
      paramVarArgs.aS(4, this.FIz);
      AppMethodBeat.o(91332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FIx == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.FIx) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FIr);
      int j = f.a.a.b.b.a.p(3, this.FIy);
      int k = f.a.a.b.b.a.bz(4, this.FIz);
      AppMethodBeat.o(91332);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91332);
          return -1;
        case 1: 
          localu.FIx = locala.OmT.readString();
          AppMethodBeat.o(91332);
          return 0;
        case 2: 
          localu.FIr = locala.OmT.zd();
          AppMethodBeat.o(91332);
          return 0;
        case 3: 
          localu.FIy = locala.OmT.zd();
          AppMethodBeat.o(91332);
          return 0;
        }
        localu.FIz = locala.OmT.zc();
        AppMethodBeat.o(91332);
        return 0;
      }
      AppMethodBeat.o(91332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.u
 * JD-Core Version:    0.7.0.1
 */