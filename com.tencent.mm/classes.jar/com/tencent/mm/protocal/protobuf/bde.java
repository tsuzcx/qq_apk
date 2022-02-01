package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bde
  extends esc
{
  public LinkedList<bkv> ZNQ;
  public LinkedList<bkw> ZNR;
  
  public bde()
  {
    AppMethodBeat.i(259152);
    this.ZNQ = new LinkedList();
    this.ZNR = new LinkedList();
    AppMethodBeat.o(259152);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259158);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZNQ);
      paramVarArgs.e(3, 8, this.ZNR);
      AppMethodBeat.o(259158);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label524;
      }
    }
    label524:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.ZNQ);
      int j = i.a.a.a.c(3, 8, this.ZNR);
      AppMethodBeat.o(259158);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZNQ.clear();
        this.ZNR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259158);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bde localbde = (bde)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259158);
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
            localbde.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259158);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkv)localObject2).parseFrom((byte[])localObject1);
            }
            localbde.ZNQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259158);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bkw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bkw)localObject2).parseFrom((byte[])localObject1);
          }
          localbde.ZNR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259158);
        return 0;
      }
      AppMethodBeat.o(259158);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bde
 * JD-Core Version:    0.7.0.1
 */