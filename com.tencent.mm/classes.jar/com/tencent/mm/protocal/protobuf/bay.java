package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bay
  extends esc
{
  public bzc ZLN;
  public int ZLO;
  public int ZLP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259820);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZLN != null)
      {
        paramVarArgs.qD(2, this.ZLN.computeSize());
        this.ZLN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.ZLO);
      paramVarArgs.bS(4, this.ZLP);
      AppMethodBeat.o(259820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZLN != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZLN.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZLO);
      int j = i.a.a.b.b.a.cJ(4, this.ZLP);
      AppMethodBeat.o(259820);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bay localbay = (bay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259820);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbay.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259820);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzc)localObject2).parseFrom((byte[])localObject1);
            }
            localbay.ZLN = ((bzc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259820);
          return 0;
        case 3: 
          localbay.ZLO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259820);
          return 0;
        }
        localbay.ZLP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259820);
        return 0;
      }
      AppMethodBeat.o(259820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bay
 * JD-Core Version:    0.7.0.1
 */