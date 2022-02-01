package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddx
  extends cld
{
  public String EvA;
  public String EvB;
  public civ Evv;
  public int ntx;
  public String nty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.EvA != null) {
        paramVarArgs.d(4, this.EvA);
      }
      if (this.EvB != null) {
        paramVarArgs.d(5, this.EvB);
      }
      if (this.Evv != null)
      {
        paramVarArgs.kX(6, this.Evv.computeSize());
        this.Evv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.EvA != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EvA);
      }
      paramInt = i;
      if (this.EvB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EvB);
      }
      i = paramInt;
      if (this.Evv != null) {
        i = paramInt + f.a.a.a.kW(6, this.Evv.computeSize());
      }
      AppMethodBeat.o(72591);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddx localddx = (ddx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72591);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72591);
          return 0;
        case 2: 
          localddx.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72591);
          return 0;
        case 3: 
          localddx.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 4: 
          localddx.EvA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 5: 
          localddx.EvB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72591);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new civ();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localddx.Evv = ((civ)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      AppMethodBeat.o(72591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddx
 * JD-Core Version:    0.7.0.1
 */