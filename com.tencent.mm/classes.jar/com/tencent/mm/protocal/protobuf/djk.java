package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djk
  extends com.tencent.mm.cd.a
{
  public String Sba;
  public int TQS;
  public String TQT;
  public String TQU;
  public String appid;
  public String llI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91579);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      paramVarArgs.aY(2, this.TQS);
      if (this.TQT != null) {
        paramVarArgs.f(3, this.TQT);
      }
      if (this.TQU != null) {
        paramVarArgs.f(4, this.TQU);
      }
      if (this.Sba != null) {
        paramVarArgs.f(5, this.Sba);
      }
      if (this.llI != null) {
        paramVarArgs.f(6, this.llI);
      }
      AppMethodBeat.o(91579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TQS);
      paramInt = i;
      if (this.TQT != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TQT);
      }
      i = paramInt;
      if (this.TQU != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TQU);
      }
      paramInt = i;
      if (this.Sba != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sba);
      }
      i = paramInt;
      if (this.llI != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.llI);
      }
      AppMethodBeat.o(91579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91579);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        djk localdjk = (djk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91579);
          return -1;
        case 1: 
          localdjk.appid = locala.abFh.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 2: 
          localdjk.TQS = locala.abFh.AK();
          AppMethodBeat.o(91579);
          return 0;
        case 3: 
          localdjk.TQT = locala.abFh.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 4: 
          localdjk.TQU = locala.abFh.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 5: 
          localdjk.Sba = locala.abFh.readString();
          AppMethodBeat.o(91579);
          return 0;
        }
        localdjk.llI = locala.abFh.readString();
        AppMethodBeat.o(91579);
        return 0;
      }
      AppMethodBeat.o(91579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djk
 * JD-Core Version:    0.7.0.1
 */