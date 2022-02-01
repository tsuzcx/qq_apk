package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blr
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String CCm;
  public int FileSize;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104821);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CCm != null) {
        paramVarArgs.d(1, this.CCm);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      paramVarArgs.aR(3, this.FileSize);
      AppMethodBeat.o(104821);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CCm == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.CCm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.AesKey);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.FileSize);
      AppMethodBeat.o(104821);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104821);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        blr localblr = (blr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104821);
          return -1;
        case 1: 
          localblr.CCm = locala.KhF.readString();
          AppMethodBeat.o(104821);
          return 0;
        case 2: 
          localblr.AesKey = locala.KhF.readString();
          AppMethodBeat.o(104821);
          return 0;
        }
        localblr.FileSize = locala.KhF.xS();
        AppMethodBeat.o(104821);
        return 0;
      }
      AppMethodBeat.o(104821);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blr
 * JD-Core Version:    0.7.0.1
 */