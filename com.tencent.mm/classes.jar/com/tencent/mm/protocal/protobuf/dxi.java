package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxi
  extends com.tencent.mm.bw.a
{
  public String FFr;
  public int FMB;
  public com.tencent.mm.bw.b GdR;
  public com.tencent.mm.bw.b GdS;
  public String GdT;
  public String GdU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FFr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.FMB);
      if (this.FFr != null) {
        paramVarArgs.d(2, this.FFr);
      }
      if (this.GdR != null) {
        paramVarArgs.c(3, this.GdR);
      }
      if (this.GdS != null) {
        paramVarArgs.c(4, this.GdS);
      }
      if (this.GdT != null) {
        paramVarArgs.d(5, this.GdT);
      }
      if (this.GdU != null) {
        paramVarArgs.d(6, this.GdU);
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FMB) + 0;
      paramInt = i;
      if (this.FFr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FFr);
      }
      i = paramInt;
      if (this.GdR != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GdR);
      }
      paramInt = i;
      if (this.GdS != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GdS);
      }
      i = paramInt;
      if (this.GdT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GdT);
      }
      paramInt = i;
      if (this.GdU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GdU);
      }
      AppMethodBeat.o(32550);
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
      if (this.FFr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dxi localdxi = (dxi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32550);
        return -1;
      case 1: 
        localdxi.FMB = locala.LVo.xF();
        AppMethodBeat.o(32550);
        return 0;
      case 2: 
        localdxi.FFr = locala.LVo.readString();
        AppMethodBeat.o(32550);
        return 0;
      case 3: 
        localdxi.GdR = locala.LVo.gfk();
        AppMethodBeat.o(32550);
        return 0;
      case 4: 
        localdxi.GdS = locala.LVo.gfk();
        AppMethodBeat.o(32550);
        return 0;
      case 5: 
        localdxi.GdT = locala.LVo.readString();
        AppMethodBeat.o(32550);
        return 0;
      }
      localdxi.GdU = locala.LVo.readString();
      AppMethodBeat.o(32550);
      return 0;
    }
    AppMethodBeat.o(32550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxi
 * JD-Core Version:    0.7.0.1
 */