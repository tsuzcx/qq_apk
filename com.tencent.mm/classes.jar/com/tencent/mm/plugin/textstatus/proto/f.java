package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
  extends com.tencent.mm.cd.a
{
  public String MEV;
  public String MEW;
  public int MEX;
  public int MEY;
  public int MEZ;
  public int MFa;
  public int MFb;
  public int MFc;
  public long MFd;
  public long MFe;
  public long MFf;
  public String lVU;
  public String sessionId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243764);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.f(1, this.sessionId);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.MEV != null) {
        paramVarArgs.f(3, this.MEV);
      }
      if (this.MEW != null) {
        paramVarArgs.f(4, this.MEW);
      }
      paramVarArgs.aY(5, this.MEX);
      paramVarArgs.aY(6, this.MEY);
      paramVarArgs.aY(7, this.MEZ);
      paramVarArgs.aY(8, this.MFa);
      paramVarArgs.aY(9, this.MFb);
      paramVarArgs.aY(10, this.MFc);
      if (this.lVU != null) {
        paramVarArgs.f(11, this.lVU);
      }
      paramVarArgs.bm(12, this.MFd);
      paramVarArgs.bm(13, this.MFe);
      paramVarArgs.bm(14, this.MFf);
      AppMethodBeat.o(243764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label862;
      }
    }
    label862:
    for (int i = g.a.a.b.b.a.g(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.MEV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MEV);
      }
      paramInt = i;
      if (this.MEW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.MEW);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.MEX) + g.a.a.b.b.a.bM(6, this.MEY) + g.a.a.b.b.a.bM(7, this.MEZ) + g.a.a.b.b.a.bM(8, this.MFa) + g.a.a.b.b.a.bM(9, this.MFb) + g.a.a.b.b.a.bM(10, this.MFc);
      paramInt = i;
      if (this.lVU != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.lVU);
      }
      i = g.a.a.b.b.a.p(12, this.MFd);
      int j = g.a.a.b.b.a.p(13, this.MFe);
      int k = g.a.a.b.b.a.p(14, this.MFf);
      AppMethodBeat.o(243764);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243764);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243764);
          return -1;
        case 1: 
          localf.sessionId = locala.abFh.readString();
          AppMethodBeat.o(243764);
          return 0;
        case 2: 
          localf.username = locala.abFh.readString();
          AppMethodBeat.o(243764);
          return 0;
        case 3: 
          localf.MEV = locala.abFh.readString();
          AppMethodBeat.o(243764);
          return 0;
        case 4: 
          localf.MEW = locala.abFh.readString();
          AppMethodBeat.o(243764);
          return 0;
        case 5: 
          localf.MEX = locala.abFh.AK();
          AppMethodBeat.o(243764);
          return 0;
        case 6: 
          localf.MEY = locala.abFh.AK();
          AppMethodBeat.o(243764);
          return 0;
        case 7: 
          localf.MEZ = locala.abFh.AK();
          AppMethodBeat.o(243764);
          return 0;
        case 8: 
          localf.MFa = locala.abFh.AK();
          AppMethodBeat.o(243764);
          return 0;
        case 9: 
          localf.MFb = locala.abFh.AK();
          AppMethodBeat.o(243764);
          return 0;
        case 10: 
          localf.MFc = locala.abFh.AK();
          AppMethodBeat.o(243764);
          return 0;
        case 11: 
          localf.lVU = locala.abFh.readString();
          AppMethodBeat.o(243764);
          return 0;
        case 12: 
          localf.MFd = locala.abFh.AN();
          AppMethodBeat.o(243764);
          return 0;
        case 13: 
          localf.MFe = locala.abFh.AN();
          AppMethodBeat.o(243764);
          return 0;
        }
        localf.MFf = locala.abFh.AN();
        AppMethodBeat.o(243764);
        return 0;
      }
      AppMethodBeat.o(243764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.f
 * JD-Core Version:    0.7.0.1
 */