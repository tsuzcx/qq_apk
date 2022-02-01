package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxe
  extends com.tencent.mm.bx.a
{
  public String Epn;
  public String nsM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114081);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Epn != null) {
        paramVarArgs.d(1, this.Epn);
      }
      if (this.nsM != null) {
        paramVarArgs.d(2, this.nsM);
      }
      AppMethodBeat.o(114081);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Epn == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Epn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nsM != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nsM);
      }
      AppMethodBeat.o(114081);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114081);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cxe localcxe = (cxe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114081);
          return -1;
        case 1: 
          localcxe.Epn = locala.KhF.readString();
          AppMethodBeat.o(114081);
          return 0;
        }
        localcxe.nsM = locala.KhF.readString();
        AppMethodBeat.o(114081);
        return 0;
      }
      AppMethodBeat.o(114081);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxe
 * JD-Core Version:    0.7.0.1
 */