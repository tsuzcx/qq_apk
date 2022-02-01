package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public String MEN;
  public String MFj;
  public int MFs;
  public int MFt;
  public String MFz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243608);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MEN != null) {
        paramVarArgs.f(1, this.MEN);
      }
      if (this.MFz != null) {
        paramVarArgs.f(2, this.MFz);
      }
      if (this.MFj != null) {
        paramVarArgs.f(3, this.MFj);
      }
      paramVarArgs.aY(4, this.MFs);
      paramVarArgs.aY(5, this.ChC);
      paramVarArgs.aY(6, this.MFt);
      AppMethodBeat.o(243608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MEN == null) {
        break label474;
      }
    }
    label474:
    for (int i = g.a.a.b.b.a.g(1, this.MEN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MFz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.MFz);
      }
      i = paramInt;
      if (this.MFj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MFj);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.MFs);
      int j = g.a.a.b.b.a.bM(5, this.ChC);
      int k = g.a.a.b.b.a.bM(6, this.MFt);
      AppMethodBeat.o(243608);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243608);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243608);
          return -1;
        case 1: 
          localaa.MEN = locala.abFh.readString();
          AppMethodBeat.o(243608);
          return 0;
        case 2: 
          localaa.MFz = locala.abFh.readString();
          AppMethodBeat.o(243608);
          return 0;
        case 3: 
          localaa.MFj = locala.abFh.readString();
          AppMethodBeat.o(243608);
          return 0;
        case 4: 
          localaa.MFs = locala.abFh.AK();
          AppMethodBeat.o(243608);
          return 0;
        case 5: 
          localaa.ChC = locala.abFh.AK();
          AppMethodBeat.o(243608);
          return 0;
        }
        localaa.MFt = locala.abFh.AK();
        AppMethodBeat.o(243608);
        return 0;
      }
      AppMethodBeat.o(243608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.aa
 * JD-Core Version:    0.7.0.1
 */