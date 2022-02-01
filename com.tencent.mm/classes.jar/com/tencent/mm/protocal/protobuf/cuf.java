package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuf
  extends com.tencent.mm.cd.a
{
  public String coverUrl;
  public String desc;
  public int duration;
  public int llq;
  public int llr = 0;
  public int lls;
  public int llt;
  public int lpx = -1;
  public String vid;
  public int videoHeight;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125740);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.lpx);
      paramVarArgs.aY(2, this.llr);
      if (this.desc != null) {
        paramVarArgs.f(3, this.desc);
      }
      paramVarArgs.aY(4, this.videoWidth);
      paramVarArgs.aY(5, this.videoHeight);
      paramVarArgs.aY(6, this.llq);
      paramVarArgs.aY(7, this.duration);
      if (this.vid != null) {
        paramVarArgs.f(8, this.vid);
      }
      paramVarArgs.aY(9, this.llt);
      if (this.coverUrl != null) {
        paramVarArgs.f(10, this.coverUrl);
      }
      paramVarArgs.aY(11, this.lls);
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.lpx) + 0 + g.a.a.b.b.a.bM(2, this.llr);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.desc);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.videoWidth) + g.a.a.b.b.a.bM(5, this.videoHeight) + g.a.a.b.b.a.bM(6, this.llq) + g.a.a.b.b.a.bM(7, this.duration);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.vid);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.llt);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.coverUrl);
      }
      i = g.a.a.b.b.a.bM(11, this.lls);
      AppMethodBeat.o(125740);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cuf localcuf = (cuf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125740);
        return -1;
      case 1: 
        localcuf.lpx = locala.abFh.AK();
        AppMethodBeat.o(125740);
        return 0;
      case 2: 
        localcuf.llr = locala.abFh.AK();
        AppMethodBeat.o(125740);
        return 0;
      case 3: 
        localcuf.desc = locala.abFh.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 4: 
        localcuf.videoWidth = locala.abFh.AK();
        AppMethodBeat.o(125740);
        return 0;
      case 5: 
        localcuf.videoHeight = locala.abFh.AK();
        AppMethodBeat.o(125740);
        return 0;
      case 6: 
        localcuf.llq = locala.abFh.AK();
        AppMethodBeat.o(125740);
        return 0;
      case 7: 
        localcuf.duration = locala.abFh.AK();
        AppMethodBeat.o(125740);
        return 0;
      case 8: 
        localcuf.vid = locala.abFh.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 9: 
        localcuf.llt = locala.abFh.AK();
        AppMethodBeat.o(125740);
        return 0;
      case 10: 
        localcuf.coverUrl = locala.abFh.readString();
        AppMethodBeat.o(125740);
        return 0;
      }
      localcuf.lls = locala.abFh.AK();
      AppMethodBeat.o(125740);
      return 0;
    }
    AppMethodBeat.o(125740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuf
 * JD-Core Version:    0.7.0.1
 */