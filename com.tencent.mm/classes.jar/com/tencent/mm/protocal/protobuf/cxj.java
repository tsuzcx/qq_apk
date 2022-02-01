package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxj
  extends com.tencent.mm.bw.a
{
  public String FUn;
  public dnl Gtc;
  public chy HHT;
  public float HHU;
  public long HHV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91675);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUn != null) {
        paramVarArgs.d(1, this.FUn);
      }
      if (this.Gtc != null)
      {
        paramVarArgs.lJ(2, this.Gtc.computeSize());
        this.Gtc.writeFields(paramVarArgs);
      }
      if (this.HHT != null)
      {
        paramVarArgs.lJ(3, this.HHT.computeSize());
        this.HHT.writeFields(paramVarArgs);
      }
      paramVarArgs.y(4, this.HHU);
      paramVarArgs.aZ(5, this.HHV);
      AppMethodBeat.o(91675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUn == null) {
        break label613;
      }
    }
    label613:
    for (int i = f.a.a.b.b.a.e(1, this.FUn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gtc != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gtc.computeSize());
      }
      i = paramInt;
      if (this.HHT != null) {
        i = paramInt + f.a.a.a.lI(3, this.HHT.computeSize());
      }
      paramInt = f.a.a.b.b.a.amE(4);
      int j = f.a.a.b.b.a.p(5, this.HHV);
      AppMethodBeat.o(91675);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxj localcxj = (cxj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91675);
          return -1;
        case 1: 
          localcxj.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91675);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxj.Gtc = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxj.HHT = ((chy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 4: 
          localcxj.HHU = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(91675);
          return 0;
        }
        localcxj.HHV = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91675);
        return 0;
      }
      AppMethodBeat.o(91675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxj
 * JD-Core Version:    0.7.0.1
 */