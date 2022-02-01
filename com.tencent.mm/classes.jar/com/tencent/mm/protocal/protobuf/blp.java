package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blp
  extends com.tencent.mm.cd.a
{
  public String SWE;
  public String SWF;
  public String SWG;
  public String feedId;
  public String jXW;
  public String nonceId;
  public String whH;
  public String wwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200021);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.feedId != null) {
        paramVarArgs.f(1, this.feedId);
      }
      if (this.nonceId != null) {
        paramVarArgs.f(2, this.nonceId);
      }
      if (this.whH != null) {
        paramVarArgs.f(3, this.whH);
      }
      if (this.SWE != null) {
        paramVarArgs.f(4, this.SWE);
      }
      if (this.SWF != null) {
        paramVarArgs.f(5, this.SWF);
      }
      if (this.jXW != null) {
        paramVarArgs.f(6, this.jXW);
      }
      if (this.SWG != null) {
        paramVarArgs.f(7, this.SWG);
      }
      if (this.wwr != null) {
        paramVarArgs.f(8, this.wwr);
      }
      AppMethodBeat.o(200021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.feedId == null) {
        break label642;
      }
    }
    label642:
    for (int i = g.a.a.b.b.a.g(1, this.feedId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nonceId);
      }
      i = paramInt;
      if (this.whH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.whH);
      }
      paramInt = i;
      if (this.SWE != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SWE);
      }
      i = paramInt;
      if (this.SWF != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SWF);
      }
      paramInt = i;
      if (this.jXW != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.jXW);
      }
      i = paramInt;
      if (this.SWG != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SWG);
      }
      paramInt = i;
      if (this.wwr != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.wwr);
      }
      AppMethodBeat.o(200021);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200021);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        blp localblp = (blp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200021);
          return -1;
        case 1: 
          localblp.feedId = locala.abFh.readString();
          AppMethodBeat.o(200021);
          return 0;
        case 2: 
          localblp.nonceId = locala.abFh.readString();
          AppMethodBeat.o(200021);
          return 0;
        case 3: 
          localblp.whH = locala.abFh.readString();
          AppMethodBeat.o(200021);
          return 0;
        case 4: 
          localblp.SWE = locala.abFh.readString();
          AppMethodBeat.o(200021);
          return 0;
        case 5: 
          localblp.SWF = locala.abFh.readString();
          AppMethodBeat.o(200021);
          return 0;
        case 6: 
          localblp.jXW = locala.abFh.readString();
          AppMethodBeat.o(200021);
          return 0;
        case 7: 
          localblp.SWG = locala.abFh.readString();
          AppMethodBeat.o(200021);
          return 0;
        }
        localblp.wwr = locala.abFh.readString();
        AppMethodBeat.o(200021);
        return 0;
      }
      AppMethodBeat.o(200021);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blp
 * JD-Core Version:    0.7.0.1
 */