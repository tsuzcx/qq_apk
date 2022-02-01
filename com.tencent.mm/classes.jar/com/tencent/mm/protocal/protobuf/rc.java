package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rc
  extends com.tencent.mm.bx.a
{
  public int Aoy;
  public String zHs;
  public String zHt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zHs != null) {
        paramVarArgs.d(1, this.zHs);
      }
      if (this.zHt != null) {
        paramVarArgs.d(2, this.zHt);
      }
      paramVarArgs.aR(3, this.Aoy);
      AppMethodBeat.o(113965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zHs == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.zHs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.zHt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.zHt);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Aoy);
      AppMethodBeat.o(113965);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113965);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rc localrc = (rc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113965);
          return -1;
        case 1: 
          localrc.zHs = locala.KhF.readString();
          AppMethodBeat.o(113965);
          return 0;
        case 2: 
          localrc.zHt = locala.KhF.readString();
          AppMethodBeat.o(113965);
          return 0;
        }
        localrc.Aoy = locala.KhF.xS();
        AppMethodBeat.o(113965);
        return 0;
      }
      AppMethodBeat.o(113965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rc
 * JD-Core Version:    0.7.0.1
 */