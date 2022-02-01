package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjf
  extends com.tencent.mm.cd.a
{
  public String QSw;
  public String SOz;
  public String STr;
  public String STs;
  public String STt;
  public String lLg;
  public String poiName;
  public String xzN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201033);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.STr != null) {
        paramVarArgs.f(1, this.STr);
      }
      if (this.STs != null) {
        paramVarArgs.f(2, this.STs);
      }
      if (this.poiName != null) {
        paramVarArgs.f(3, this.poiName);
      }
      if (this.STt != null) {
        paramVarArgs.f(4, this.STt);
      }
      if (this.lLg != null) {
        paramVarArgs.f(5, this.lLg);
      }
      if (this.QSw != null) {
        paramVarArgs.f(6, this.QSw);
      }
      if (this.SOz != null) {
        paramVarArgs.f(7, this.SOz);
      }
      if (this.xzN != null) {
        paramVarArgs.f(8, this.xzN);
      }
      AppMethodBeat.o(201033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.STr == null) {
        break label642;
      }
    }
    label642:
    for (int i = g.a.a.b.b.a.g(1, this.STr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.STs != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.STs);
      }
      i = paramInt;
      if (this.poiName != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.poiName);
      }
      paramInt = i;
      if (this.STt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.STt);
      }
      i = paramInt;
      if (this.lLg != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.lLg);
      }
      paramInt = i;
      if (this.QSw != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.QSw);
      }
      i = paramInt;
      if (this.SOz != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SOz);
      }
      paramInt = i;
      if (this.xzN != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.xzN);
      }
      AppMethodBeat.o(201033);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201033);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bjf localbjf = (bjf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(201033);
          return -1;
        case 1: 
          localbjf.STr = locala.abFh.readString();
          AppMethodBeat.o(201033);
          return 0;
        case 2: 
          localbjf.STs = locala.abFh.readString();
          AppMethodBeat.o(201033);
          return 0;
        case 3: 
          localbjf.poiName = locala.abFh.readString();
          AppMethodBeat.o(201033);
          return 0;
        case 4: 
          localbjf.STt = locala.abFh.readString();
          AppMethodBeat.o(201033);
          return 0;
        case 5: 
          localbjf.lLg = locala.abFh.readString();
          AppMethodBeat.o(201033);
          return 0;
        case 6: 
          localbjf.QSw = locala.abFh.readString();
          AppMethodBeat.o(201033);
          return 0;
        case 7: 
          localbjf.SOz = locala.abFh.readString();
          AppMethodBeat.o(201033);
          return 0;
        }
        localbjf.xzN = locala.abFh.readString();
        AppMethodBeat.o(201033);
        return 0;
      }
      AppMethodBeat.o(201033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjf
 * JD-Core Version:    0.7.0.1
 */