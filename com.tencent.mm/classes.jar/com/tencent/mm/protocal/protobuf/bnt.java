package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bnt
  extends erp
{
  public atz YIY;
  public bns ZWq;
  public b ZWr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258674);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.ZWq != null)
      {
        paramVarArgs.qD(3, this.ZWq.computeSize());
        this.ZWq.writeFields(paramVarArgs);
      }
      if (this.ZWr != null) {
        paramVarArgs.d(4, this.ZWr);
      }
      AppMethodBeat.o(258674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label608;
      }
    }
    label608:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.ZWq != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZWq.computeSize());
      }
      paramInt = i;
      if (this.ZWr != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.ZWr);
      }
      AppMethodBeat.o(258674);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258674);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bnt localbnt = (bnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258674);
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
            localbnt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258674);
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
            localbnt.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258674);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bns();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bns)localObject2).parseFrom((byte[])localObject1);
            }
            localbnt.ZWq = ((bns)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258674);
          return 0;
        }
        localbnt.ZWr = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(258674);
        return 0;
      }
      AppMethodBeat.o(258674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnt
 * JD-Core Version:    0.7.0.1
 */