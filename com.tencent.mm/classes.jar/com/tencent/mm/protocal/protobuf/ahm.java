package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahm
  extends com.tencent.mm.cd.a
{
  public int SoV;
  public int Ssd;
  public int Sse;
  public int Ssf;
  public int Ssg;
  public int Ssh;
  public int Ssi;
  public int channels;
  public int tRG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90964);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Ssd);
      paramVarArgs.aY(2, this.Sse);
      paramVarArgs.aY(3, this.channels);
      paramVarArgs.aY(4, this.Ssf);
      paramVarArgs.aY(5, this.SoV);
      paramVarArgs.aY(6, this.tRG);
      paramVarArgs.aY(7, this.Ssg);
      paramVarArgs.aY(8, this.Ssh);
      paramVarArgs.aY(9, this.Ssi);
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Ssd);
      int i = g.a.a.b.b.a.bM(2, this.Sse);
      int j = g.a.a.b.b.a.bM(3, this.channels);
      int k = g.a.a.b.b.a.bM(4, this.Ssf);
      int m = g.a.a.b.b.a.bM(5, this.SoV);
      int n = g.a.a.b.b.a.bM(6, this.tRG);
      int i1 = g.a.a.b.b.a.bM(7, this.Ssg);
      int i2 = g.a.a.b.b.a.bM(8, this.Ssh);
      int i3 = g.a.a.b.b.a.bM(9, this.Ssi);
      AppMethodBeat.o(90964);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ahm localahm = (ahm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90964);
        return -1;
      case 1: 
        localahm.Ssd = locala.abFh.AK();
        AppMethodBeat.o(90964);
        return 0;
      case 2: 
        localahm.Sse = locala.abFh.AK();
        AppMethodBeat.o(90964);
        return 0;
      case 3: 
        localahm.channels = locala.abFh.AK();
        AppMethodBeat.o(90964);
        return 0;
      case 4: 
        localahm.Ssf = locala.abFh.AK();
        AppMethodBeat.o(90964);
        return 0;
      case 5: 
        localahm.SoV = locala.abFh.AK();
        AppMethodBeat.o(90964);
        return 0;
      case 6: 
        localahm.tRG = locala.abFh.AK();
        AppMethodBeat.o(90964);
        return 0;
      case 7: 
        localahm.Ssg = locala.abFh.AK();
        AppMethodBeat.o(90964);
        return 0;
      case 8: 
        localahm.Ssh = locala.abFh.AK();
        AppMethodBeat.o(90964);
        return 0;
      }
      localahm.Ssi = locala.abFh.AK();
      AppMethodBeat.o(90964);
      return 0;
    }
    AppMethodBeat.o(90964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahm
 * JD-Core Version:    0.7.0.1
 */