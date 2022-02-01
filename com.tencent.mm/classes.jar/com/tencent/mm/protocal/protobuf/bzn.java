package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzn
  extends com.tencent.mm.bw.a
{
  public int EeA;
  public int EqS;
  public int Fou;
  public String Fov;
  public String Fox;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EeA);
      if (this.Fox != null) {
        paramVarArgs.d(3, this.Fox);
      }
      paramVarArgs.aR(4, this.Fou);
      paramVarArgs.aR(5, this.EqS);
      if (this.Fov != null) {
        paramVarArgs.d(6, this.Fov);
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EeA) + 0;
      paramInt = i;
      if (this.Fox != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fox);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Fou) + f.a.a.b.b.a.bx(5, this.EqS);
      paramInt = i;
      if (this.Fov != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fov);
      }
      AppMethodBeat.o(43114);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bzn localbzn = (bzn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(43114);
        return -1;
      case 1: 
        localbzn.EeA = locala.LVo.xF();
        AppMethodBeat.o(43114);
        return 0;
      case 3: 
        localbzn.Fox = locala.LVo.readString();
        AppMethodBeat.o(43114);
        return 0;
      case 4: 
        localbzn.Fou = locala.LVo.xF();
        AppMethodBeat.o(43114);
        return 0;
      case 5: 
        localbzn.EqS = locala.LVo.xF();
        AppMethodBeat.o(43114);
        return 0;
      }
      localbzn.Fov = locala.LVo.readString();
      AppMethodBeat.o(43114);
      return 0;
    }
    AppMethodBeat.o(43114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzn
 * JD-Core Version:    0.7.0.1
 */