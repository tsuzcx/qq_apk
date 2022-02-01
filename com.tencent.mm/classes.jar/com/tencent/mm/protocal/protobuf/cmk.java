package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmk
  extends com.tencent.mm.bx.a
{
  public String DYG;
  public String DYH;
  public String DwS;
  public int mAK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91678);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DwS != null) {
        paramVarArgs.d(1, this.DwS);
      }
      if (this.DYH != null) {
        paramVarArgs.d(2, this.DYH);
      }
      paramVarArgs.aR(3, this.mAK);
      if (this.DYG != null) {
        paramVarArgs.d(4, this.DYG);
      }
      AppMethodBeat.o(91678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DwS == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.DwS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DYH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DYH);
      }
      i += f.a.a.b.b.a.bA(3, this.mAK);
      paramInt = i;
      if (this.DYG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DYG);
      }
      AppMethodBeat.o(91678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91678);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cmk localcmk = (cmk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91678);
          return -1;
        case 1: 
          localcmk.DwS = locala.KhF.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 2: 
          localcmk.DYH = locala.KhF.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 3: 
          localcmk.mAK = locala.KhF.xS();
          AppMethodBeat.o(91678);
          return 0;
        }
        localcmk.DYG = locala.KhF.readString();
        AppMethodBeat.o(91678);
        return 0;
      }
      AppMethodBeat.o(91678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmk
 * JD-Core Version:    0.7.0.1
 */