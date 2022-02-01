package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bil
  extends dop
{
  public int LSC;
  public String app_id;
  public String pRX;
  public b pUz;
  public int qcJ;
  public String qcK;
  public String qcL;
  public String qcM;
  public String qcN;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114000);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.e(2, this.app_id);
      }
      paramVarArgs.aM(3, this.qcJ);
      if (this.qcK != null) {
        paramVarArgs.e(4, this.qcK);
      }
      if (this.qcL != null) {
        paramVarArgs.e(5, this.qcL);
      }
      paramVarArgs.aM(6, this.time_stamp);
      if (this.qcM != null) {
        paramVarArgs.e(7, this.qcM);
      }
      if (this.pRX != null) {
        paramVarArgs.e(8, this.pRX);
      }
      if (this.qcN != null) {
        paramVarArgs.e(9, this.qcN);
      }
      if (this.pUz != null) {
        paramVarArgs.c(10, this.pUz);
      }
      paramVarArgs.aM(11, this.LSC);
      AppMethodBeat.o(114000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.app_id);
      }
      i += g.a.a.b.b.a.bu(3, this.qcJ);
      paramInt = i;
      if (this.qcK != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qcK);
      }
      i = paramInt;
      if (this.qcL != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.qcL);
      }
      i += g.a.a.b.b.a.bu(6, this.time_stamp);
      paramInt = i;
      if (this.qcM != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.qcM);
      }
      i = paramInt;
      if (this.pRX != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.pRX);
      }
      paramInt = i;
      if (this.qcN != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.qcN);
      }
      i = paramInt;
      if (this.pUz != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.pUz);
      }
      paramInt = g.a.a.b.b.a.bu(11, this.LSC);
      AppMethodBeat.o(114000);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bil localbil = (bil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114000);
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
            localbil.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114000);
          return 0;
        case 2: 
          localbil.app_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 3: 
          localbil.qcJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114000);
          return 0;
        case 4: 
          localbil.qcK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 5: 
          localbil.qcL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 6: 
          localbil.time_stamp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114000);
          return 0;
        case 7: 
          localbil.qcM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 8: 
          localbil.pRX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 9: 
          localbil.qcN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 10: 
          localbil.pUz = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(114000);
          return 0;
        }
        localbil.LSC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(114000);
        return 0;
      }
      AppMethodBeat.o(114000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bil
 * JD-Core Version:    0.7.0.1
 */