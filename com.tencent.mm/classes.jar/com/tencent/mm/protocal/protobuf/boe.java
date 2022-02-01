package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boe
  extends com.tencent.mm.bx.a
{
  public String CNs;
  public long DLA;
  public String DLy;
  public long DLz;
  public int mBH;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.scene);
      if (this.DLy != null) {
        paramVarArgs.d(2, this.DLy);
      }
      paramVarArgs.aG(3, this.DLz);
      paramVarArgs.aG(4, this.DLA);
      if (this.CNs != null) {
        paramVarArgs.d(5, this.CNs);
      }
      paramVarArgs.aR(6, this.mBH);
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.scene) + 0;
      paramInt = i;
      if (this.DLy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DLy);
      }
      i = paramInt + f.a.a.b.b.a.q(3, this.DLz) + f.a.a.b.b.a.q(4, this.DLA);
      paramInt = i;
      if (this.CNs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CNs);
      }
      i = f.a.a.b.b.a.bA(6, this.mBH);
      AppMethodBeat.o(117876);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      boe localboe = (boe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117876);
        return -1;
      case 1: 
        localboe.scene = locala.KhF.xS();
        AppMethodBeat.o(117876);
        return 0;
      case 2: 
        localboe.DLy = locala.KhF.readString();
        AppMethodBeat.o(117876);
        return 0;
      case 3: 
        localboe.DLz = locala.KhF.xT();
        AppMethodBeat.o(117876);
        return 0;
      case 4: 
        localboe.DLA = locala.KhF.xT();
        AppMethodBeat.o(117876);
        return 0;
      case 5: 
        localboe.CNs = locala.KhF.readString();
        AppMethodBeat.o(117876);
        return 0;
      }
      localboe.mBH = locala.KhF.xS();
      AppMethodBeat.o(117876);
      return 0;
    }
    AppMethodBeat.o(117876);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boe
 * JD-Core Version:    0.7.0.1
 */