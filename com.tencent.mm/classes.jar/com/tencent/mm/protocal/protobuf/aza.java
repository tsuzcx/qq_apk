package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aza
  extends erp
{
  public String YIZ;
  public b ZEQ;
  public atz ZHY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259225);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(2, this.ZEQ);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(3, this.YIZ);
      }
      if (this.ZHY != null)
      {
        paramVarArgs.qD(4, this.ZHY.computeSize());
        this.ZHY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259225);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZEQ);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YIZ);
      }
      paramInt = i;
      if (this.ZHY != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZHY.computeSize());
      }
      AppMethodBeat.o(259225);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259225);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aza localaza = (aza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259225);
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
            localaza.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259225);
          return 0;
        case 2: 
          localaza.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259225);
          return 0;
        case 3: 
          localaza.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259225);
          return 0;
        }
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
          localaza.ZHY = ((atz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259225);
        return 0;
      }
      AppMethodBeat.o(259225);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aza
 * JD-Core Version:    0.7.0.1
 */