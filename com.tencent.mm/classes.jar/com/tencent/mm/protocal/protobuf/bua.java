package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bua
  extends erp
{
  public aur ZDQ;
  public atz aabS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259260);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aabS != null)
      {
        paramVarArgs.qD(2, this.aabS.computeSize());
        this.aabS.writeFields(paramVarArgs);
      }
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(3, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aabS != null) {
        paramInt = i + i.a.a.a.qC(2, this.aabS.computeSize());
      }
      i = paramInt;
      if (this.ZDQ != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZDQ.computeSize());
      }
      AppMethodBeat.o(259260);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bua localbua = (bua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259260);
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
            localbua.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259260);
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
            localbua.aabS = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259260);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aur();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aur)localObject2).parseFrom((byte[])localObject1);
          }
          localbua.ZDQ = ((aur)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259260);
        return 0;
      }
      AppMethodBeat.o(259260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bua
 * JD-Core Version:    0.7.0.1
 */