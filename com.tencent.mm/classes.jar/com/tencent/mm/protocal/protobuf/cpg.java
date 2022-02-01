package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpg
  extends com.tencent.mm.bx.a
{
  public String Ddo;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(2, this.Ddo);
      }
      AppMethodBeat.o(32430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ddo);
      }
      AppMethodBeat.o(32430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32430);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cpg localcpg = (cpg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32430);
          return -1;
        case 1: 
          localcpg.mAQ = locala.KhF.readString();
          AppMethodBeat.o(32430);
          return 0;
        }
        localcpg.Ddo = locala.KhF.readString();
        AppMethodBeat.o(32430);
        return 0;
      }
      AppMethodBeat.o(32430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpg
 * JD-Core Version:    0.7.0.1
 */