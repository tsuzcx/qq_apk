package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsy
  extends dop
{
  public String KXA;
  public long MRu;
  public long MRz;
  public int MUZ;
  public long MVa;
  public boolean MVb;
  public fdw MVc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117921);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KXA != null) {
        paramVarArgs.e(2, this.KXA);
      }
      paramVarArgs.bb(3, this.MRu);
      paramVarArgs.aM(4, this.MUZ);
      paramVarArgs.bb(5, this.MVa);
      paramVarArgs.cc(6, this.MVb);
      if (this.MVc != null)
      {
        paramVarArgs.ni(7, this.MVc.computeSize());
        this.MVc.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(8, this.MRz);
      AppMethodBeat.o(117921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KXA != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KXA);
      }
      i = i + g.a.a.b.b.a.r(3, this.MRu) + g.a.a.b.b.a.bu(4, this.MUZ) + g.a.a.b.b.a.r(5, this.MVa) + (g.a.a.b.b.a.fS(6) + 1);
      paramInt = i;
      if (this.MVc != null) {
        paramInt = i + g.a.a.a.nh(7, this.MVc.computeSize());
      }
      i = g.a.a.b.b.a.r(8, this.MRz);
      AppMethodBeat.o(117921);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsy localdsy = (dsy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117921);
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
            localdsy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        case 2: 
          localdsy.KXA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117921);
          return 0;
        case 3: 
          localdsy.MRu = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(117921);
          return 0;
        case 4: 
          localdsy.MUZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117921);
          return 0;
        case 5: 
          localdsy.MVa = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(117921);
          return 0;
        case 6: 
          localdsy.MVb = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(117921);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdsy.MVc = ((fdw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        }
        localdsy.MRz = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117921);
        return 0;
      }
      AppMethodBeat.o(117921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsy
 * JD-Core Version:    0.7.0.1
 */