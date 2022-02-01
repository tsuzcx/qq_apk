package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dnv
  extends com.tencent.mm.cd.a
{
  public String TVc;
  public int TVd;
  public String appId;
  public int fyH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153295);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.TVc != null) {
        paramVarArgs.f(2, this.TVc);
      }
      paramVarArgs.aY(3, this.fyH);
      paramVarArgs.aY(4, this.TVd);
      AppMethodBeat.o(153295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TVc != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TVc);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.fyH);
      int j = g.a.a.b.b.a.bM(4, this.TVd);
      AppMethodBeat.o(153295);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153295);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dnv localdnv = (dnv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153295);
          return -1;
        case 1: 
          localdnv.appId = locala.abFh.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 2: 
          localdnv.TVc = locala.abFh.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 3: 
          localdnv.fyH = locala.abFh.AK();
          AppMethodBeat.o(153295);
          return 0;
        }
        localdnv.TVd = locala.abFh.AK();
        AppMethodBeat.o(153295);
        return 0;
      }
      AppMethodBeat.o(153295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnv
 * JD-Core Version:    0.7.0.1
 */