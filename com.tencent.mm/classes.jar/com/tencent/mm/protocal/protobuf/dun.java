package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dun
  extends com.tencent.mm.bx.a
{
  public boolean EIE;
  public boolean EIG;
  public String EIS;
  public csy EIT;
  public dcj EIU;
  public String EkG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153317);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EIS != null) {
        paramVarArgs.d(1, this.EIS);
      }
      if (this.EkG != null) {
        paramVarArgs.d(2, this.EkG);
      }
      if (this.EIT != null)
      {
        paramVarArgs.kX(3, this.EIT.computeSize());
        this.EIT.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(4, this.EIE);
      paramVarArgs.bg(5, this.EIG);
      if (this.EIU != null)
      {
        paramVarArgs.kX(6, this.EIU.computeSize());
        this.EIU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EIS == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.b.b.a.e(1, this.EIS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EkG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EkG);
      }
      i = paramInt;
      if (this.EIT != null) {
        i = paramInt + f.a.a.a.kW(3, this.EIT.computeSize());
      }
      i = i + (f.a.a.b.b.a.fY(4) + 1) + (f.a.a.b.b.a.fY(5) + 1);
      paramInt = i;
      if (this.EIU != null) {
        paramInt = i + f.a.a.a.kW(6, this.EIU.computeSize());
      }
      AppMethodBeat.o(153317);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dun localdun = (dun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153317);
          return -1;
        case 1: 
          localdun.EIS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 2: 
          localdun.EkG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdun.EIT = ((csy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 4: 
          localdun.EIE = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153317);
          return 0;
        case 5: 
          localdun.EIG = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153317);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdun.EIU = ((dcj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      AppMethodBeat.o(153317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dun
 * JD-Core Version:    0.7.0.1
 */