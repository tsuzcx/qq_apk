package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kh
  extends com.tencent.mm.bx.a
{
  public long CFc = 0L;
  public long CFd = 0L;
  public long CFe = 0L;
  public long CFf = 0L;
  public int CFg;
  public int dlI;
  public int wVR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.CFc);
      paramVarArgs.aG(2, this.CFd);
      paramVarArgs.aG(3, this.CFe);
      paramVarArgs.aG(4, this.CFf);
      paramVarArgs.aR(5, this.wVR);
      paramVarArgs.aR(6, this.dlI);
      paramVarArgs.aR(7, this.CFg);
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.CFc);
      int i = f.a.a.b.b.a.q(2, this.CFd);
      int j = f.a.a.b.b.a.q(3, this.CFe);
      int k = f.a.a.b.b.a.q(4, this.CFf);
      int m = f.a.a.b.b.a.bA(5, this.wVR);
      int n = f.a.a.b.b.a.bA(6, this.dlI);
      int i1 = f.a.a.b.b.a.bA(7, this.CFg);
      AppMethodBeat.o(110886);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      kh localkh = (kh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110886);
        return -1;
      case 1: 
        localkh.CFc = locala.KhF.xT();
        AppMethodBeat.o(110886);
        return 0;
      case 2: 
        localkh.CFd = locala.KhF.xT();
        AppMethodBeat.o(110886);
        return 0;
      case 3: 
        localkh.CFe = locala.KhF.xT();
        AppMethodBeat.o(110886);
        return 0;
      case 4: 
        localkh.CFf = locala.KhF.xT();
        AppMethodBeat.o(110886);
        return 0;
      case 5: 
        localkh.wVR = locala.KhF.xS();
        AppMethodBeat.o(110886);
        return 0;
      case 6: 
        localkh.dlI = locala.KhF.xS();
        AppMethodBeat.o(110886);
        return 0;
      }
      localkh.CFg = locala.KhF.xS();
      AppMethodBeat.o(110886);
      return 0;
    }
    AppMethodBeat.o(110886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kh
 * JD-Core Version:    0.7.0.1
 */