package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aod
  extends com.tencent.mm.bx.a
{
  public String Dpp;
  public String Dpq;
  public String sdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190803);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdZ != null) {
        paramVarArgs.d(1, this.sdZ);
      }
      if (this.Dpp != null) {
        paramVarArgs.d(2, this.Dpp);
      }
      if (this.Dpq != null) {
        paramVarArgs.d(3, this.Dpq);
      }
      AppMethodBeat.o(190803);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdZ == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.sdZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dpp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dpp);
      }
      i = paramInt;
      if (this.Dpq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dpq);
      }
      AppMethodBeat.o(190803);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(190803);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aod localaod = (aod)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190803);
          return -1;
        case 1: 
          localaod.sdZ = locala.KhF.readString();
          AppMethodBeat.o(190803);
          return 0;
        case 2: 
          localaod.Dpp = locala.KhF.readString();
          AppMethodBeat.o(190803);
          return 0;
        }
        localaod.Dpq = locala.KhF.readString();
        AppMethodBeat.o(190803);
        return 0;
      }
      AppMethodBeat.o(190803);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aod
 * JD-Core Version:    0.7.0.1
 */