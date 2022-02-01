package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpm
  extends dyy
{
  public int Swo;
  public LinkedList<cpi> TwQ;
  public int TwR;
  
  public cpm()
  {
    AppMethodBeat.i(251893);
    this.TwQ = new LinkedList();
    AppMethodBeat.o(251893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251894);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TwQ);
      paramVarArgs.aY(3, this.TwR);
      paramVarArgs.aY(4, this.Swo);
      AppMethodBeat.o(251894);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.TwQ);
      int j = g.a.a.b.b.a.bM(3, this.TwR);
      int k = g.a.a.b.b.a.bM(4, this.Swo);
      AppMethodBeat.o(251894);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TwQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(251894);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpm localcpm = (cpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(251894);
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
            localcpm.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(251894);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cpi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cpi)localObject2).parseFrom((byte[])localObject1);
            }
            localcpm.TwQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(251894);
          return 0;
        case 3: 
          localcpm.TwR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(251894);
          return 0;
        }
        localcpm.Swo = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(251894);
        return 0;
      }
      AppMethodBeat.o(251894);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpm
 * JD-Core Version:    0.7.0.1
 */