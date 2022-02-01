package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfh
  extends com.tencent.mm.bx.a
{
  public long DCu;
  public int DCv;
  public long DCw;
  public int DCx;
  public long DCy;
  public int DCz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.DCu);
      paramVarArgs.aR(2, this.DCv);
      paramVarArgs.aG(3, this.DCw);
      paramVarArgs.aR(4, this.DCx);
      paramVarArgs.aG(5, this.DCy);
      paramVarArgs.aR(6, this.DCz);
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.DCu);
      int i = f.a.a.b.b.a.bA(2, this.DCv);
      int j = f.a.a.b.b.a.q(3, this.DCw);
      int k = f.a.a.b.b.a.bA(4, this.DCx);
      int m = f.a.a.b.b.a.q(5, this.DCy);
      int n = f.a.a.b.b.a.bA(6, this.DCz);
      AppMethodBeat.o(115845);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bfh localbfh = (bfh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115845);
        return -1;
      case 1: 
        localbfh.DCu = locala.KhF.xT();
        AppMethodBeat.o(115845);
        return 0;
      case 2: 
        localbfh.DCv = locala.KhF.xS();
        AppMethodBeat.o(115845);
        return 0;
      case 3: 
        localbfh.DCw = locala.KhF.xT();
        AppMethodBeat.o(115845);
        return 0;
      case 4: 
        localbfh.DCx = locala.KhF.xS();
        AppMethodBeat.o(115845);
        return 0;
      case 5: 
        localbfh.DCy = locala.KhF.xT();
        AppMethodBeat.o(115845);
        return 0;
      }
      localbfh.DCz = locala.KhF.xS();
      AppMethodBeat.o(115845);
      return 0;
    }
    AppMethodBeat.o(115845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfh
 * JD-Core Version:    0.7.0.1
 */