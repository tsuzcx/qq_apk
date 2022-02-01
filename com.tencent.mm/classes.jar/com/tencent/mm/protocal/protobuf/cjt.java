package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjt
  extends com.tencent.mm.cd.a
{
  public long HlH;
  public String RJQ;
  public int Tfy;
  public long Trk;
  public String UserName;
  public String lWn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259130);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.HlH);
      paramVarArgs.bm(2, this.Trk);
      if (this.lWn != null) {
        paramVarArgs.f(3, this.lWn);
      }
      paramVarArgs.aY(4, this.Tfy);
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      if (this.RJQ != null) {
        paramVarArgs.f(6, this.RJQ);
      }
      AppMethodBeat.o(259130);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.HlH) + 0 + g.a.a.b.b.a.p(2, this.Trk);
      paramInt = i;
      if (this.lWn != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.lWn);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.Tfy);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UserName);
      }
      i = paramInt;
      if (this.RJQ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RJQ);
      }
      AppMethodBeat.o(259130);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(259130);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cjt localcjt = (cjt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259130);
        return -1;
      case 1: 
        localcjt.HlH = locala.abFh.AN();
        AppMethodBeat.o(259130);
        return 0;
      case 2: 
        localcjt.Trk = locala.abFh.AN();
        AppMethodBeat.o(259130);
        return 0;
      case 3: 
        localcjt.lWn = locala.abFh.readString();
        AppMethodBeat.o(259130);
        return 0;
      case 4: 
        localcjt.Tfy = locala.abFh.AK();
        AppMethodBeat.o(259130);
        return 0;
      case 5: 
        localcjt.UserName = locala.abFh.readString();
        AppMethodBeat.o(259130);
        return 0;
      }
      localcjt.RJQ = locala.abFh.readString();
      AppMethodBeat.o(259130);
      return 0;
    }
    AppMethodBeat.o(259130);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjt
 * JD-Core Version:    0.7.0.1
 */