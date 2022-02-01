package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csz
  extends com.tencent.mm.bx.a
{
  public String EkG;
  public String dlB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153300);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.EkG != null) {
        paramVarArgs.d(2, this.EkG);
      }
      AppMethodBeat.o(153300);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EkG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EkG);
      }
      AppMethodBeat.o(153300);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153300);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csz localcsz = (csz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153300);
          return -1;
        case 1: 
          localcsz.dlB = locala.KhF.readString();
          AppMethodBeat.o(153300);
          return 0;
        }
        localcsz.EkG = locala.KhF.readString();
        AppMethodBeat.o(153300);
        return 0;
      }
      AppMethodBeat.o(153300);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csz
 * JD-Core Version:    0.7.0.1
 */