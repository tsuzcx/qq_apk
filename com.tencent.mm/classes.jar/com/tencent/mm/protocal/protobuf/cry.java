package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cry
  extends com.tencent.mm.bw.a
{
  public axy Aqo;
  public String MqW;
  public String MwX;
  public String Mxa;
  public int Mxb;
  public String lDR;
  public String qHg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MwX != null) {
        paramVarArgs.e(1, this.MwX);
      }
      if (this.MqW != null) {
        paramVarArgs.e(2, this.MqW);
      }
      if (this.lDR != null) {
        paramVarArgs.e(3, this.lDR);
      }
      if (this.qHg != null) {
        paramVarArgs.e(4, this.qHg);
      }
      if (this.Mxa != null) {
        paramVarArgs.e(5, this.Mxa);
      }
      paramVarArgs.aM(6, this.Mxb);
      if (this.Aqo != null)
      {
        paramVarArgs.ni(7, this.Aqo.computeSize());
        this.Aqo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MwX == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.b.b.a.f(1, this.MwX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MqW != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MqW);
      }
      i = paramInt;
      if (this.lDR != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.lDR);
      }
      paramInt = i;
      if (this.qHg != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qHg);
      }
      i = paramInt;
      if (this.Mxa != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mxa);
      }
      i += g.a.a.b.b.a.bu(6, this.Mxb);
      paramInt = i;
      if (this.Aqo != null) {
        paramInt = i + g.a.a.a.nh(7, this.Aqo.computeSize());
      }
      AppMethodBeat.o(256709);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256709);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cry localcry = (cry)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256709);
          return -1;
        case 1: 
          localcry.MwX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256709);
          return 0;
        case 2: 
          localcry.MqW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256709);
          return 0;
        case 3: 
          localcry.lDR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256709);
          return 0;
        case 4: 
          localcry.qHg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256709);
          return 0;
        case 5: 
          localcry.Mxa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256709);
          return 0;
        case 6: 
          localcry.Mxb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256709);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((axy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcry.Aqo = ((axy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256709);
        return 0;
      }
      AppMethodBeat.o(256709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cry
 * JD-Core Version:    0.7.0.1
 */