package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvw
  extends com.tencent.mm.bx.a
{
  public String DGl;
  public String EJK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJK != null) {
        paramVarArgs.d(1, this.EJK);
      }
      if (this.DGl != null) {
        paramVarArgs.d(2, this.DGl);
      }
      AppMethodBeat.o(123709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EJK == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.EJK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DGl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DGl);
      }
      AppMethodBeat.o(123709);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123709);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvw localdvw = (dvw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123709);
          return -1;
        case 1: 
          localdvw.EJK = locala.KhF.readString();
          AppMethodBeat.o(123709);
          return 0;
        }
        localdvw.DGl = locala.KhF.readString();
        AppMethodBeat.o(123709);
        return 0;
      }
      AppMethodBeat.o(123709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvw
 * JD-Core Version:    0.7.0.1
 */