package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkr
  extends dop
{
  public String LTC;
  public String LTD;
  public double latitude;
  public double longitude;
  public String pVT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114020);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.e(3, this.longitude);
      if (this.pVT != null) {
        paramVarArgs.e(4, this.pVT);
      }
      if (this.LTC != null) {
        paramVarArgs.e(5, this.LTC);
      }
      if (this.LTD != null) {
        paramVarArgs.e(6, this.LTD);
      }
      AppMethodBeat.o(114020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 8) + (g.a.a.b.b.a.fS(3) + 8);
      paramInt = i;
      if (this.pVT != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pVT);
      }
      i = paramInt;
      if (this.LTC != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LTC);
      }
      paramInt = i;
      if (this.LTD != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LTD);
      }
      AppMethodBeat.o(114020);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkr localbkr = (bkr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114020);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbkr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114020);
          return 0;
        case 2: 
          localbkr.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(114020);
          return 0;
        case 3: 
          localbkr.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(114020);
          return 0;
        case 4: 
          localbkr.pVT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114020);
          return 0;
        case 5: 
          localbkr.LTC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114020);
          return 0;
        }
        localbkr.LTD = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114020);
        return 0;
      }
      AppMethodBeat.o(114020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkr
 * JD-Core Version:    0.7.0.1
 */