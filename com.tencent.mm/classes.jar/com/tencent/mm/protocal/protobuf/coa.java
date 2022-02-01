package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coa
  extends dop
{
  public String LOd;
  public cnh MtV;
  public int opType;
  public long tsR;
  public long twG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209758);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MtV != null)
      {
        paramVarArgs.ni(2, this.MtV.computeSize());
        this.MtV.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(3, this.twG);
      paramVarArgs.aM(4, this.opType);
      paramVarArgs.bb(5, this.tsR);
      if (this.LOd != null) {
        paramVarArgs.e(6, this.LOd);
      }
      AppMethodBeat.o(209758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MtV != null) {
        i = paramInt + g.a.a.a.nh(2, this.MtV.computeSize());
      }
      i = i + g.a.a.b.b.a.r(3, this.twG) + g.a.a.b.b.a.bu(4, this.opType) + g.a.a.b.b.a.r(5, this.tsR);
      paramInt = i;
      if (this.LOd != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LOd);
      }
      AppMethodBeat.o(209758);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        coa localcoa = (coa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209758);
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
            localcoa.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209758);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcoa.MtV = ((cnh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209758);
          return 0;
        case 3: 
          localcoa.twG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209758);
          return 0;
        case 4: 
          localcoa.opType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209758);
          return 0;
        case 5: 
          localcoa.tsR = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209758);
          return 0;
        }
        localcoa.LOd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209758);
        return 0;
      }
      AppMethodBeat.o(209758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coa
 * JD-Core Version:    0.7.0.1
 */