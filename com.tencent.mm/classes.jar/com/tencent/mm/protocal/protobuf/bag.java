package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bag
  extends dop
{
  public apc LAv;
  public aov LBM;
  public long LCz;
  public b LDs;
  public int LJW;
  public String dRy;
  public float dTj;
  public float latitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209628);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LBM != null)
      {
        paramVarArgs.ni(2, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      if (this.LDs != null) {
        paramVarArgs.c(3, this.LDs);
      }
      paramVarArgs.E(4, this.dTj);
      paramVarArgs.E(5, this.latitude);
      if (this.LAv != null)
      {
        paramVarArgs.ni(6, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      if (this.dRy != null) {
        paramVarArgs.e(7, this.dRy);
      }
      paramVarArgs.bb(8, this.LCz);
      paramVarArgs.aM(9, this.LJW);
      AppMethodBeat.o(209628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label924;
      }
    }
    label924:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LBM != null) {
        paramInt = i + g.a.a.a.nh(2, this.LBM.computeSize());
      }
      i = paramInt;
      if (this.LDs != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LDs);
      }
      i = i + (g.a.a.b.b.a.fS(4) + 4) + (g.a.a.b.b.a.fS(5) + 4);
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(6, this.LAv.computeSize());
      }
      i = paramInt;
      if (this.dRy != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.dRy);
      }
      paramInt = g.a.a.b.b.a.r(8, this.LCz);
      int j = g.a.a.b.b.a.bu(9, this.LJW);
      AppMethodBeat.o(209628);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209628);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bag localbag = (bag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209628);
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
            localbag.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209628);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbag.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209628);
          return 0;
        case 3: 
          localbag.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209628);
          return 0;
        case 4: 
          localbag.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209628);
          return 0;
        case 5: 
          localbag.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209628);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbag.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209628);
          return 0;
        case 7: 
          localbag.dRy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209628);
          return 0;
        case 8: 
          localbag.LCz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209628);
          return 0;
        }
        localbag.LJW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209628);
        return 0;
      }
      AppMethodBeat.o(209628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bag
 * JD-Core Version:    0.7.0.1
 */