package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dno
  extends dop
{
  public int MQI;
  public String eaO;
  public double latitude;
  public double longitude;
  public String pRX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114062);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.longitude);
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.aM(4, this.MQI);
      if (this.pRX != null) {
        paramVarArgs.e(5, this.pRX);
      }
      if (this.eaO != null) {
        paramVarArgs.e(6, this.eaO);
      }
      AppMethodBeat.o(114062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 8) + (g.a.a.b.b.a.fS(3) + 8) + g.a.a.b.b.a.bu(4, this.MQI);
      paramInt = i;
      if (this.pRX != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.pRX);
      }
      i = paramInt;
      if (this.eaO != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.eaO);
      }
      AppMethodBeat.o(114062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dno localdno = (dno)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114062);
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
            localdno.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114062);
          return 0;
        case 2: 
          localdno.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(114062);
          return 0;
        case 3: 
          localdno.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(114062);
          return 0;
        case 4: 
          localdno.MQI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114062);
          return 0;
        case 5: 
          localdno.pRX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114062);
          return 0;
        }
        localdno.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114062);
        return 0;
      }
      AppMethodBeat.o(114062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dno
 * JD-Core Version:    0.7.0.1
 */