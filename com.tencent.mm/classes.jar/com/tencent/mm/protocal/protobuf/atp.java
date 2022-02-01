package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class atp
  extends dyy
{
  public LinkedList<asn> SFU;
  public int continueFlag;
  public b xHE;
  
  public atp()
  {
    AppMethodBeat.i(168971);
    this.SFU = new LinkedList();
    AppMethodBeat.o(168971);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168972);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SFU);
      paramVarArgs.aY(3, this.continueFlag);
      if (this.xHE != null) {
        paramVarArgs.c(4, this.xHE);
      }
      AppMethodBeat.o(168972);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SFU) + g.a.a.b.b.a.bM(3, this.continueFlag);
      paramInt = i;
      if (this.xHE != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.xHE);
      }
      AppMethodBeat.o(168972);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SFU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168972);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atp localatp = (atp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168972);
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
            localatp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168972);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new asn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((asn)localObject2).parseFrom((byte[])localObject1);
            }
            localatp.SFU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168972);
          return 0;
        case 3: 
          localatp.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168972);
          return 0;
        }
        localatp.xHE = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(168972);
        return 0;
      }
      AppMethodBeat.o(168972);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atp
 * JD-Core Version:    0.7.0.1
 */