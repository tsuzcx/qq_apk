package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgj
  extends esc
{
  public bjc Bhm;
  public bgq ZGW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258102);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Bhm != null)
      {
        paramVarArgs.qD(2, this.Bhm.computeSize());
        this.Bhm.writeFields(paramVarArgs);
      }
      if (this.ZGW != null)
      {
        paramVarArgs.qD(3, this.ZGW.computeSize());
        this.ZGW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258102);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Bhm != null) {
        paramInt = i + i.a.a.a.qC(2, this.Bhm.computeSize());
      }
      i = paramInt;
      if (this.ZGW != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZGW.computeSize());
      }
      AppMethodBeat.o(258102);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258102);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bgj localbgj = (bgj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258102);
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
            localbgj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258102);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjc)localObject2).parseFrom((byte[])localObject1);
            }
            localbgj.Bhm = ((bjc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258102);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgq)localObject2).parseFrom((byte[])localObject1);
          }
          localbgj.ZGW = ((bgq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258102);
        return 0;
      }
      AppMethodBeat.o(258102);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgj
 * JD-Core Version:    0.7.0.1
 */