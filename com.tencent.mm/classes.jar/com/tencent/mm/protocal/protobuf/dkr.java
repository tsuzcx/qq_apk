package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dkr
  extends dyy
{
  public int TRQ;
  public String TRR;
  public eae TrG;
  public int TrH;
  public String TrI;
  public int TrJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91611);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91611);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TrG != null)
      {
        paramVarArgs.oE(2, this.TrG.computeSize());
        this.TrG.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.TrH);
      if (this.TrI != null) {
        paramVarArgs.f(4, this.TrI);
      }
      paramVarArgs.aY(5, this.TrJ);
      paramVarArgs.aY(6, this.TRQ);
      if (this.TRR != null) {
        paramVarArgs.f(7, this.TRR);
      }
      AppMethodBeat.o(91611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TrG != null) {
        i = paramInt + g.a.a.a.oD(2, this.TrG.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.TrH);
      paramInt = i;
      if (this.TrI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TrI);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TrJ) + g.a.a.b.b.a.bM(6, this.TRQ);
      paramInt = i;
      if (this.TRR != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TRR);
      }
      AppMethodBeat.o(91611);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91611);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dkr localdkr = (dkr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91611);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdkr.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localdkr.TrG = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 3: 
          localdkr.TrH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91611);
          return 0;
        case 4: 
          localdkr.TrI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91611);
          return 0;
        case 5: 
          localdkr.TrJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91611);
          return 0;
        case 6: 
          localdkr.TRQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91611);
          return 0;
        }
        localdkr.TRR = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91611);
        return 0;
      }
      AppMethodBeat.o(91611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkr
 * JD-Core Version:    0.7.0.1
 */