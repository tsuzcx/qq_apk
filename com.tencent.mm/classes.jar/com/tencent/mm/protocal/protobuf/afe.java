package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afe
  extends com.tencent.mm.bw.a
{
  public int ExA;
  public String ExB;
  public int Exw;
  public int Exx;
  public int Exy;
  public String Exz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Exw);
      paramVarArgs.aR(2, this.Exx);
      paramVarArgs.aR(3, this.Exy);
      if (this.Exz != null) {
        paramVarArgs.d(4, this.Exz);
      }
      paramVarArgs.aR(5, this.ExA);
      if (this.ExB != null) {
        paramVarArgs.d(6, this.ExB);
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Exw) + 0 + f.a.a.b.b.a.bx(2, this.Exx) + f.a.a.b.b.a.bx(3, this.Exy);
      paramInt = i;
      if (this.Exz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Exz);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.ExA);
      paramInt = i;
      if (this.ExB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ExB);
      }
      AppMethodBeat.o(122488);
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
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afe localafe = (afe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122488);
        return -1;
      case 1: 
        localafe.Exw = locala.LVo.xF();
        AppMethodBeat.o(122488);
        return 0;
      case 2: 
        localafe.Exx = locala.LVo.xF();
        AppMethodBeat.o(122488);
        return 0;
      case 3: 
        localafe.Exy = locala.LVo.xF();
        AppMethodBeat.o(122488);
        return 0;
      case 4: 
        localafe.Exz = locala.LVo.readString();
        AppMethodBeat.o(122488);
        return 0;
      case 5: 
        localafe.ExA = locala.LVo.xF();
        AppMethodBeat.o(122488);
        return 0;
      }
      localafe.ExB = locala.LVo.readString();
      AppMethodBeat.o(122488);
      return 0;
    }
    AppMethodBeat.o(122488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afe
 * JD-Core Version:    0.7.0.1
 */