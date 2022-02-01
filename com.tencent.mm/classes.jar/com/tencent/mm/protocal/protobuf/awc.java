package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awc
  extends esc
{
  public FinderObject ZGU;
  public String ZGV;
  public bgq ZGW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257377);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZGU != null)
      {
        paramVarArgs.qD(2, this.ZGU.computeSize());
        this.ZGU.writeFields(paramVarArgs);
      }
      if (this.ZGV != null) {
        paramVarArgs.g(3, this.ZGV);
      }
      if (this.ZGW != null)
      {
        paramVarArgs.qD(4, this.ZGW.computeSize());
        this.ZGW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257377);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label608;
      }
    }
    label608:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZGU != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZGU.computeSize());
      }
      i = paramInt;
      if (this.ZGV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZGV);
      }
      paramInt = i;
      if (this.ZGW != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZGW.computeSize());
      }
      AppMethodBeat.o(257377);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257377);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        awc localawc = (awc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257377);
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
            localawc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257377);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localawc.ZGU = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257377);
          return 0;
        case 3: 
          localawc.ZGV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257377);
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
          localawc.ZGW = ((bgq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257377);
        return 0;
      }
      AppMethodBeat.o(257377);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awc
 * JD-Core Version:    0.7.0.1
 */