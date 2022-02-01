package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbd
  extends erp
{
  public long ADo;
  public atz ZHY;
  public String ZLT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259760);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZHY != null)
      {
        paramVarArgs.qD(2, this.ZHY.computeSize());
        this.ZHY.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.ADo);
      if (this.ZLT != null) {
        paramVarArgs.g(4, this.ZLT);
      }
      AppMethodBeat.o(259760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZHY != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZHY.computeSize());
      }
      i += i.a.a.b.b.a.q(3, this.ADo);
      paramInt = i;
      if (this.ZLT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZLT);
      }
      AppMethodBeat.o(259760);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bbd localbbd = (bbd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259760);
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
            localbbd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259760);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbbd.ZHY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259760);
          return 0;
        case 3: 
          localbbd.ADo = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259760);
          return 0;
        }
        localbbd.ZLT = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259760);
        return 0;
      }
      AppMethodBeat.o(259760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbd
 * JD-Core Version:    0.7.0.1
 */