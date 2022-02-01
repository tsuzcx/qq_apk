package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dda
  extends com.tencent.mm.cd.a
{
  public String RVH;
  public String RVI;
  public String SaZ;
  public int SnQ;
  public String TKP;
  public int TKQ;
  public String TKR;
  public int duration;
  public int height;
  public String lpM;
  public String title;
  public String vid;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176147);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TKP != null) {
        paramVarArgs.f(1, this.TKP);
      }
      paramVarArgs.aY(2, this.duration);
      if (this.RVH != null) {
        paramVarArgs.f(3, this.RVH);
      }
      if (this.RVI != null) {
        paramVarArgs.f(4, this.RVI);
      }
      if (this.title != null) {
        paramVarArgs.f(5, this.title);
      }
      if (this.lpM != null) {
        paramVarArgs.f(6, this.lpM);
      }
      paramVarArgs.aY(7, this.TKQ);
      paramVarArgs.aY(8, this.width);
      paramVarArgs.aY(9, this.height);
      if (this.SaZ != null) {
        paramVarArgs.f(10, this.SaZ);
      }
      if (this.vid != null) {
        paramVarArgs.f(11, this.vid);
      }
      if (this.TKR != null) {
        paramVarArgs.f(12, this.TKR);
      }
      paramVarArgs.aY(13, this.SnQ);
      AppMethodBeat.o(176147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TKP == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = g.a.a.b.b.a.g(1, this.TKP) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.duration);
      paramInt = i;
      if (this.RVH != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RVH);
      }
      i = paramInt;
      if (this.RVI != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RVI);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.title);
      }
      i = paramInt;
      if (this.lpM != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.lpM);
      }
      i = i + g.a.a.b.b.a.bM(7, this.TKQ) + g.a.a.b.b.a.bM(8, this.width) + g.a.a.b.b.a.bM(9, this.height);
      paramInt = i;
      if (this.SaZ != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SaZ);
      }
      i = paramInt;
      if (this.vid != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.vid);
      }
      paramInt = i;
      if (this.TKR != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TKR);
      }
      i = g.a.a.b.b.a.bM(13, this.SnQ);
      AppMethodBeat.o(176147);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(176147);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dda localdda = (dda)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176147);
          return -1;
        case 1: 
          localdda.TKP = locala.abFh.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 2: 
          localdda.duration = locala.abFh.AK();
          AppMethodBeat.o(176147);
          return 0;
        case 3: 
          localdda.RVH = locala.abFh.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 4: 
          localdda.RVI = locala.abFh.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 5: 
          localdda.title = locala.abFh.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 6: 
          localdda.lpM = locala.abFh.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 7: 
          localdda.TKQ = locala.abFh.AK();
          AppMethodBeat.o(176147);
          return 0;
        case 8: 
          localdda.width = locala.abFh.AK();
          AppMethodBeat.o(176147);
          return 0;
        case 9: 
          localdda.height = locala.abFh.AK();
          AppMethodBeat.o(176147);
          return 0;
        case 10: 
          localdda.SaZ = locala.abFh.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 11: 
          localdda.vid = locala.abFh.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 12: 
          localdda.TKR = locala.abFh.readString();
          AppMethodBeat.o(176147);
          return 0;
        }
        localdda.SnQ = locala.abFh.AK();
        AppMethodBeat.o(176147);
        return 0;
      }
      AppMethodBeat.o(176147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dda
 * JD-Core Version:    0.7.0.1
 */