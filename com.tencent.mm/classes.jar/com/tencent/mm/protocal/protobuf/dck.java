package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dck
  extends com.tencent.mm.cd.a
{
  public String RQx;
  public String Sqe;
  public int SvP;
  public String TJO;
  public int TtY;
  public String UserName;
  public String rWI;
  public int vhf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155445);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.vhf);
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.RQx != null) {
        paramVarArgs.f(3, this.RQx);
      }
      if (this.Sqe != null) {
        paramVarArgs.f(4, this.Sqe);
      }
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      paramVarArgs.aY(6, this.TtY);
      paramVarArgs.aY(7, this.SvP);
      if (this.TJO != null) {
        paramVarArgs.f(8, this.TJO);
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.vhf) + 0;
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.RQx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RQx);
      }
      paramInt = i;
      if (this.Sqe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sqe);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UserName);
      }
      i = i + g.a.a.b.b.a.bM(6, this.TtY) + g.a.a.b.b.a.bM(7, this.SvP);
      paramInt = i;
      if (this.TJO != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TJO);
      }
      AppMethodBeat.o(155445);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dck localdck = (dck)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155445);
        return -1;
      case 1: 
        localdck.vhf = locala.abFh.AK();
        AppMethodBeat.o(155445);
        return 0;
      case 2: 
        localdck.rWI = locala.abFh.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 3: 
        localdck.RQx = locala.abFh.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 4: 
        localdck.Sqe = locala.abFh.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 5: 
        localdck.UserName = locala.abFh.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 6: 
        localdck.TtY = locala.abFh.AK();
        AppMethodBeat.o(155445);
        return 0;
      case 7: 
        localdck.SvP = locala.abFh.AK();
        AppMethodBeat.o(155445);
        return 0;
      }
      localdck.TJO = locala.abFh.readString();
      AppMethodBeat.o(155445);
      return 0;
    }
    AppMethodBeat.o(155445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dck
 * JD-Core Version:    0.7.0.1
 */