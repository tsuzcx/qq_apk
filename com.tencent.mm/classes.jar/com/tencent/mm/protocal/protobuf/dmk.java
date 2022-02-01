package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmk
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String TST;
  public LinkedList<dml> TTO;
  public String TpT;
  public String URL;
  public int rVx;
  
  public dmk()
  {
    AppMethodBeat.i(202709);
    this.TTO = new LinkedList();
    AppMethodBeat.o(202709);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202715);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      if (this.TpT != null) {
        paramVarArgs.f(2, this.TpT);
      }
      if (this.URL != null) {
        paramVarArgs.f(3, this.URL);
      }
      paramVarArgs.aY(4, this.rVx);
      if (this.TST != null) {
        paramVarArgs.f(5, this.TST);
      }
      paramVarArgs.e(6, 8, this.TTO);
      AppMethodBeat.o(202715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label560;
      }
    }
    label560:
    for (int i = g.a.a.b.b.a.g(1, this.CMP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TpT != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TpT);
      }
      i = paramInt;
      if (this.URL != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.URL);
      }
      i += g.a.a.b.b.a.bM(4, this.rVx);
      paramInt = i;
      if (this.TST != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TST);
      }
      i = g.a.a.a.c(6, 8, this.TTO);
      AppMethodBeat.o(202715);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TTO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202715);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dmk localdmk = (dmk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202715);
          return -1;
        case 1: 
          localdmk.CMP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202715);
          return 0;
        case 2: 
          localdmk.TpT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202715);
          return 0;
        case 3: 
          localdmk.URL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202715);
          return 0;
        case 4: 
          localdmk.rVx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(202715);
          return 0;
        case 5: 
          localdmk.TST = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202715);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dml localdml = new dml();
          if ((localObject != null) && (localObject.length > 0)) {
            localdml.parseFrom((byte[])localObject);
          }
          localdmk.TTO.add(localdml);
          paramInt += 1;
        }
        AppMethodBeat.o(202715);
        return 0;
      }
      AppMethodBeat.o(202715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmk
 * JD-Core Version:    0.7.0.1
 */