package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dma
  extends dop
{
  public String Ltk;
  public eox MPD;
  public ejg MPE;
  public int hil;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56259);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MPD == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPosition");
        AppMethodBeat.o(56259);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ltk != null) {
        paramVarArgs.e(2, this.Ltk);
      }
      paramVarArgs.aM(3, this.oUv);
      if (this.MPD != null)
      {
        paramVarArgs.ni(4, this.MPD.computeSize());
        this.MPD.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.hil);
      if (this.MPE != null)
      {
        paramVarArgs.ni(6, this.MPE.computeSize());
        this.MPE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ltk != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Ltk);
      }
      i += g.a.a.b.b.a.bu(3, this.oUv);
      paramInt = i;
      if (this.MPD != null) {
        paramInt = i + g.a.a.a.nh(4, this.MPD.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.hil);
      paramInt = i;
      if (this.MPE != null) {
        paramInt = i + g.a.a.a.nh(6, this.MPE.computeSize());
      }
      AppMethodBeat.o(56259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MPD == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPosition");
          AppMethodBeat.o(56259);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dma localdma = (dma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56259);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdma.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 2: 
          localdma.Ltk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(56259);
          return 0;
        case 3: 
          localdma.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56259);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eox();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eox)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdma.MPD = ((eox)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 5: 
          localdma.hil = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56259);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ejg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdma.MPE = ((ejg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      AppMethodBeat.o(56259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dma
 * JD-Core Version:    0.7.0.1
 */