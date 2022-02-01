package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ky
  extends erp
{
  public LinkedList<cip> YMQ;
  public aeo YMR;
  public int scene;
  
  public ky()
  {
    AppMethodBeat.i(175240);
    this.YMQ = new LinkedList();
    AppMethodBeat.o(175240);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175241);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YMQ);
      paramVarArgs.bS(3, this.scene);
      if (this.YMR != null)
      {
        paramVarArgs.qD(4, this.YMR.computeSize());
        this.YMR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(175241);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YMQ) + i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.YMR != null) {
        paramInt = i + i.a.a.a.qC(4, this.YMR.computeSize());
      }
      AppMethodBeat.o(175241);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YMQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(175241);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ky localky = (ky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175241);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localky.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(175241);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cip();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cip)localObject2).parseFrom((byte[])localObject1);
            }
            localky.YMQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(175241);
          return 0;
        case 3: 
          localky.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(175241);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aeo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aeo)localObject2).parseFrom((byte[])localObject1);
          }
          localky.YMR = ((aeo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(175241);
        return 0;
      }
      AppMethodBeat.o(175241);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ky
 * JD-Core Version:    0.7.0.1
 */