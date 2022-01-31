package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clu
  extends com.tencent.mm.bv.a
{
  public int Height;
  public int Width;
  public int X;
  public int Y;
  public int wRe;
  public String xVP;
  public int xVQ;
  public int xVR;
  public String xvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(81507);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.X);
      paramVarArgs.aO(2, this.Y);
      paramVarArgs.aO(3, this.Width);
      paramVarArgs.aO(4, this.Height);
      if (this.xVP != null) {
        paramVarArgs.e(5, this.xVP);
      }
      if (this.xvP != null) {
        paramVarArgs.e(6, this.xvP);
      }
      paramVarArgs.aO(7, this.xVQ);
      paramVarArgs.aO(8, this.wRe);
      paramVarArgs.aO(9, this.xVR);
      AppMethodBeat.o(81507);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.X) + 0 + e.a.a.b.b.a.bl(2, this.Y) + e.a.a.b.b.a.bl(3, this.Width) + e.a.a.b.b.a.bl(4, this.Height);
      paramInt = i;
      if (this.xVP != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xVP);
      }
      i = paramInt;
      if (this.xvP != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xvP);
      }
      paramInt = e.a.a.b.b.a.bl(7, this.xVQ);
      int j = e.a.a.b.b.a.bl(8, this.wRe);
      int k = e.a.a.b.b.a.bl(9, this.xVR);
      AppMethodBeat.o(81507);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(81507);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      clu localclu = (clu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(81507);
        return -1;
      case 1: 
        localclu.X = locala.CLY.sl();
        AppMethodBeat.o(81507);
        return 0;
      case 2: 
        localclu.Y = locala.CLY.sl();
        AppMethodBeat.o(81507);
        return 0;
      case 3: 
        localclu.Width = locala.CLY.sl();
        AppMethodBeat.o(81507);
        return 0;
      case 4: 
        localclu.Height = locala.CLY.sl();
        AppMethodBeat.o(81507);
        return 0;
      case 5: 
        localclu.xVP = locala.CLY.readString();
        AppMethodBeat.o(81507);
        return 0;
      case 6: 
        localclu.xvP = locala.CLY.readString();
        AppMethodBeat.o(81507);
        return 0;
      case 7: 
        localclu.xVQ = locala.CLY.sl();
        AppMethodBeat.o(81507);
        return 0;
      case 8: 
        localclu.wRe = locala.CLY.sl();
        AppMethodBeat.o(81507);
        return 0;
      }
      localclu.xVR = locala.CLY.sl();
      AppMethodBeat.o(81507);
      return 0;
    }
    AppMethodBeat.o(81507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clu
 * JD-Core Version:    0.7.0.1
 */