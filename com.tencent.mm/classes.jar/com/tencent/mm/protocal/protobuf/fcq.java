package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fcq
  extends dyy
{
  public LinkedList<eaf> RIj;
  public int Tdc;
  public String UCs;
  public int lVs;
  
  public fcq()
  {
    AppMethodBeat.i(148665);
    this.RIj = new LinkedList();
    AppMethodBeat.o(148665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148666);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.lVs);
      paramVarArgs.aY(3, this.Tdc);
      paramVarArgs.e(4, 8, this.RIj);
      if (this.UCs != null) {
        paramVarArgs.f(5, this.UCs);
      }
      AppMethodBeat.o(148666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.lVs) + g.a.a.b.b.a.bM(3, this.Tdc) + g.a.a.a.c(4, 8, this.RIj);
      paramInt = i;
      if (this.UCs != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UCs);
      }
      AppMethodBeat.o(148666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(148666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcq localfcq = (fcq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148666);
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
            localfcq.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148666);
          return 0;
        case 2: 
          localfcq.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148666);
          return 0;
        case 3: 
          localfcq.Tdc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148666);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfcq.RIj.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148666);
          return 0;
        }
        localfcq.UCs = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(148666);
        return 0;
      }
      AppMethodBeat.o(148666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcq
 * JD-Core Version:    0.7.0.1
 */