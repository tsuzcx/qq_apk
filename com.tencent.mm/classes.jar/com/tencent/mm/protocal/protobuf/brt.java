package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brt
  extends erp
{
  public atz YIY;
  public long YZe;
  public long object_id;
  public int op;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260198);
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
      paramVarArgs.bv(3, this.object_id);
      paramVarArgs.bv(4, this.YZe);
      paramVarArgs.bS(5, this.op);
      AppMethodBeat.o(260198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(3, this.object_id);
      int j = i.a.a.b.b.a.q(4, this.YZe);
      int k = i.a.a.b.b.a.cJ(5, this.op);
      AppMethodBeat.o(260198);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        brt localbrt = (brt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260198);
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
            localbrt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260198);
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
            localbrt.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260198);
          return 0;
        case 3: 
          localbrt.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260198);
          return 0;
        case 4: 
          localbrt.YZe = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260198);
          return 0;
        }
        localbrt.op = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260198);
        return 0;
      }
      AppMethodBeat.o(260198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brt
 * JD-Core Version:    0.7.0.1
 */