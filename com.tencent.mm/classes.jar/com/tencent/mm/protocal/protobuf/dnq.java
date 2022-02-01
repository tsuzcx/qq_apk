package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dnq
  extends dop
{
  public float MQJ;
  public b MQK;
  public boolean MQL;
  public boolean MQM;
  public float dTj;
  public String eaO;
  public float latitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114064);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.E(2, this.dTj);
      paramVarArgs.E(3, this.latitude);
      paramVarArgs.E(4, this.MQJ);
      if (this.MQK != null) {
        paramVarArgs.c(5, this.MQK);
      }
      if (this.eaO != null) {
        paramVarArgs.e(6, this.eaO);
      }
      paramVarArgs.cc(7, this.MQL);
      paramVarArgs.cc(8, this.MQM);
      AppMethodBeat.o(114064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label655;
      }
    }
    label655:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 4) + (g.a.a.b.b.a.fS(3) + 4) + (g.a.a.b.b.a.fS(4) + 4);
      paramInt = i;
      if (this.MQK != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.MQK);
      }
      i = paramInt;
      if (this.eaO != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.eaO);
      }
      paramInt = g.a.a.b.b.a.fS(7);
      int j = g.a.a.b.b.a.fS(8);
      AppMethodBeat.o(114064);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnq localdnq = (dnq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114064);
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
            localdnq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114064);
          return 0;
        case 2: 
          localdnq.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(114064);
          return 0;
        case 3: 
          localdnq.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(114064);
          return 0;
        case 4: 
          localdnq.MQJ = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(114064);
          return 0;
        case 5: 
          localdnq.MQK = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(114064);
          return 0;
        case 6: 
          localdnq.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114064);
          return 0;
        case 7: 
          localdnq.MQL = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(114064);
          return 0;
        }
        localdnq.MQM = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(114064);
        return 0;
      }
      AppMethodBeat.o(114064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnq
 * JD-Core Version:    0.7.0.1
 */