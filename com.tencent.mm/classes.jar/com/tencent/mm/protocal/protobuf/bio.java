package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bio
  extends com.tencent.mm.bx.a
{
  public int DGh;
  public int DGi;
  public int DGj;
  public int DoW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DoW);
      paramVarArgs.aR(2, this.DGh);
      paramVarArgs.aR(3, this.DGi);
      paramVarArgs.aR(4, this.DGj);
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DoW);
      int i = f.a.a.b.b.a.bA(2, this.DGh);
      int j = f.a.a.b.b.a.bA(3, this.DGi);
      int k = f.a.a.b.b.a.bA(4, this.DGj);
      AppMethodBeat.o(152617);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bio localbio = (bio)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152617);
        return -1;
      case 1: 
        localbio.DoW = locala.KhF.xS();
        AppMethodBeat.o(152617);
        return 0;
      case 2: 
        localbio.DGh = locala.KhF.xS();
        AppMethodBeat.o(152617);
        return 0;
      case 3: 
        localbio.DGi = locala.KhF.xS();
        AppMethodBeat.o(152617);
        return 0;
      }
      localbio.DGj = locala.KhF.xS();
      AppMethodBeat.o(152617);
      return 0;
    }
    AppMethodBeat.o(152617);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bio
 * JD-Core Version:    0.7.0.1
 */