package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auz
  extends com.tencent.mm.bw.a
{
  public String LFM;
  public awd LFN;
  public int LFO;
  public String LFP;
  public int LFQ;
  public int LFR;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LFM != null) {
        paramVarArgs.e(1, this.LFM);
      }
      paramVarArgs.aM(2, this.LFQ);
      paramVarArgs.aM(3, this.LFR);
      if (this.LFN != null)
      {
        paramVarArgs.ni(4, this.LFN.computeSize());
        this.LFN.writeFields(paramVarArgs);
      }
      if (this.content != null) {
        paramVarArgs.e(5, this.content);
      }
      paramVarArgs.aM(6, this.LFO);
      if (this.LFP != null) {
        paramVarArgs.e(7, this.LFP);
      }
      AppMethodBeat.o(209492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LFM == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = g.a.a.b.b.a.f(1, this.LFM) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LFQ) + g.a.a.b.b.a.bu(3, this.LFR);
      paramInt = i;
      if (this.LFN != null) {
        paramInt = i + g.a.a.a.nh(4, this.LFN.computeSize());
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.content);
      }
      i += g.a.a.b.b.a.bu(6, this.LFO);
      paramInt = i;
      if (this.LFP != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LFP);
      }
      AppMethodBeat.o(209492);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        auz localauz = (auz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209492);
          return -1;
        case 1: 
          localauz.LFM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209492);
          return 0;
        case 2: 
          localauz.LFQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209492);
          return 0;
        case 3: 
          localauz.LFR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209492);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((awd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauz.LFN = ((awd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209492);
          return 0;
        case 5: 
          localauz.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209492);
          return 0;
        case 6: 
          localauz.LFO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209492);
          return 0;
        }
        localauz.LFP = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209492);
        return 0;
      }
      AppMethodBeat.o(209492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auz
 * JD-Core Version:    0.7.0.1
 */