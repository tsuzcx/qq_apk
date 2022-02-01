package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cot
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public dqi KHm;
  public String KHq;
  public String LbN;
  public int MuU;
  public String iAc;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43104);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43104);
        throw paramVarArgs;
      }
      if (this.KHm != null)
      {
        paramVarArgs.ni(1, this.KHm.computeSize());
        this.KHm.writeFields(paramVarArgs);
      }
      if (this.iAc != null) {
        paramVarArgs.e(2, this.iAc);
      }
      paramVarArgs.aM(3, this.oUv);
      paramVarArgs.aM(4, this.CreateTime);
      paramVarArgs.aM(5, this.MuU);
      if (this.KHq != null) {
        paramVarArgs.e(6, this.KHq);
      }
      if (this.LbN != null) {
        paramVarArgs.e(9, this.LbN);
      }
      AppMethodBeat.o(43104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHm == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = g.a.a.a.nh(1, this.KHm.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.iAc);
      }
      i = i + g.a.a.b.b.a.bu(3, this.oUv) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.MuU);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHq);
      }
      i = paramInt;
      if (this.LbN != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LbN);
      }
      AppMethodBeat.o(43104);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(43104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cot localcot = (cot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(43104);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcot.KHm = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43104);
          return 0;
        case 2: 
          localcot.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43104);
          return 0;
        case 3: 
          localcot.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43104);
          return 0;
        case 4: 
          localcot.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43104);
          return 0;
        case 5: 
          localcot.MuU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43104);
          return 0;
        case 6: 
          localcot.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43104);
          return 0;
        }
        localcot.LbN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43104);
        return 0;
      }
      AppMethodBeat.o(43104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cot
 * JD-Core Version:    0.7.0.1
 */