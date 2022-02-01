package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eck
  extends com.tencent.mm.bw.a
{
  public int Eae;
  public int FbR;
  public int GhR;
  public int GhS;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123712);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FbR);
      paramVarArgs.aR(2, this.Eae);
      paramVarArgs.aR(3, this.GhR);
      paramVarArgs.aR(4, this.Scene);
      paramVarArgs.aR(10, this.GhS);
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FbR);
      int i = f.a.a.b.b.a.bx(2, this.Eae);
      int j = f.a.a.b.b.a.bx(3, this.GhR);
      int k = f.a.a.b.b.a.bx(4, this.Scene);
      int m = f.a.a.b.b.a.bx(10, this.GhS);
      AppMethodBeat.o(123712);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eck localeck = (eck)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(123712);
        return -1;
      case 1: 
        localeck.FbR = locala.LVo.xF();
        AppMethodBeat.o(123712);
        return 0;
      case 2: 
        localeck.Eae = locala.LVo.xF();
        AppMethodBeat.o(123712);
        return 0;
      case 3: 
        localeck.GhR = locala.LVo.xF();
        AppMethodBeat.o(123712);
        return 0;
      case 4: 
        localeck.Scene = locala.LVo.xF();
        AppMethodBeat.o(123712);
        return 0;
      }
      localeck.GhS = locala.LVo.xF();
      AppMethodBeat.o(123712);
      return 0;
    }
    AppMethodBeat.o(123712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eck
 * JD-Core Version:    0.7.0.1
 */