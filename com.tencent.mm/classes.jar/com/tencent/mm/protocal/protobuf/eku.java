package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eku
  extends esc
{
  public frf abpF;
  public int hAV;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72575);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.abpF != null)
      {
        paramVarArgs.qD(4, this.abpF.computeSize());
        this.abpF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.abpF != null) {
        i = paramInt + i.a.a.a.qC(4, this.abpF.computeSize());
      }
      AppMethodBeat.o(72575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eku localeku = (eku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72575);
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
            localeku.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72575);
          return 0;
        case 2: 
          localeku.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72575);
          return 0;
        case 3: 
          localeku.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72575);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new frf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((frf)localObject2).parseFrom((byte[])localObject1);
          }
          localeku.abpF = ((frf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72575);
        return 0;
      }
      AppMethodBeat.o(72575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eku
 * JD-Core Version:    0.7.0.1
 */