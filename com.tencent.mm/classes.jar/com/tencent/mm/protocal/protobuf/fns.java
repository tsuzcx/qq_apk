package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fns
  extends com.tencent.mm.cd.a
{
  public boolean ULL;
  public boolean ULN;
  public boolean ULO;
  public String UMd;
  public eht UMe;
  public esg UMf;
  public int UMg;
  public String UjS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153317);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UMd != null) {
        paramVarArgs.f(1, this.UMd);
      }
      if (this.UjS != null) {
        paramVarArgs.f(2, this.UjS);
      }
      if (this.UMe != null)
      {
        paramVarArgs.oE(3, this.UMe.computeSize());
        this.UMe.writeFields(paramVarArgs);
      }
      paramVarArgs.co(4, this.ULL);
      paramVarArgs.co(5, this.ULN);
      if (this.UMf != null)
      {
        paramVarArgs.oE(6, this.UMf.computeSize());
        this.UMf.writeFields(paramVarArgs);
      }
      paramVarArgs.co(7, this.ULO);
      paramVarArgs.aY(8, this.UMg);
      AppMethodBeat.o(153317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UMd == null) {
        break label718;
      }
    }
    label718:
    for (int i = g.a.a.b.b.a.g(1, this.UMd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UjS != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UjS);
      }
      i = paramInt;
      if (this.UMe != null) {
        i = paramInt + g.a.a.a.oD(3, this.UMe.computeSize());
      }
      i = i + (g.a.a.b.b.a.gL(4) + 1) + (g.a.a.b.b.a.gL(5) + 1);
      paramInt = i;
      if (this.UMf != null) {
        paramInt = i + g.a.a.a.oD(6, this.UMf.computeSize());
      }
      i = g.a.a.b.b.a.gL(7);
      int j = g.a.a.b.b.a.bM(8, this.UMg);
      AppMethodBeat.o(153317);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fns localfns = (fns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153317);
          return -1;
        case 1: 
          localfns.UMd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 2: 
          localfns.UjS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eht();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eht)localObject2).parseFrom((byte[])localObject1);
            }
            localfns.UMe = ((eht)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 4: 
          localfns.ULL = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153317);
          return 0;
        case 5: 
          localfns.ULN = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153317);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esg)localObject2).parseFrom((byte[])localObject1);
            }
            localfns.UMf = ((esg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 7: 
          localfns.ULO = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153317);
          return 0;
        }
        localfns.UMg = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(153317);
        return 0;
      }
      AppMethodBeat.o(153317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fns
 * JD-Core Version:    0.7.0.1
 */