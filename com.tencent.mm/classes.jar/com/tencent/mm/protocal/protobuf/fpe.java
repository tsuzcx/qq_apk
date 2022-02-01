package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpe
  extends erp
{
  public String YJY;
  public String ZoO;
  public dao abPi;
  public int abPj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32471);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZoO != null) {
        paramVarArgs.g(2, this.ZoO);
      }
      if (this.YJY != null) {
        paramVarArgs.g(3, this.YJY);
      }
      if (this.abPi != null)
      {
        paramVarArgs.qD(4, this.abPi.computeSize());
        this.abPi.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.abPj);
      AppMethodBeat.o(32471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label593;
      }
    }
    label593:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZoO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZoO);
      }
      i = paramInt;
      if (this.YJY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YJY);
      }
      paramInt = i;
      if (this.abPi != null) {
        paramInt = i + i.a.a.a.qC(4, this.abPi.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.abPj);
      AppMethodBeat.o(32471);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fpe localfpe = (fpe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32471);
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
            localfpe.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32471);
          return 0;
        case 2: 
          localfpe.ZoO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32471);
          return 0;
        case 3: 
          localfpe.YJY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32471);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dao();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dao)localObject2).parseFrom((byte[])localObject1);
            }
            localfpe.abPi = ((dao)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32471);
          return 0;
        }
        localfpe.abPj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32471);
        return 0;
      }
      AppMethodBeat.o(32471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpe
 * JD-Core Version:    0.7.0.1
 */