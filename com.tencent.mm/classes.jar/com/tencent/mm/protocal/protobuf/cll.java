package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cll
  extends dop
{
  public long BPd;
  public int MqK;
  public LinkedList<b> MqL;
  public long MqM;
  public long MqN;
  public float dTj;
  public float latitude;
  
  public cll()
  {
    AppMethodBeat.i(169918);
    this.MqL = new LinkedList();
    AppMethodBeat.o(169918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169919);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MqK);
      paramVarArgs.E(3, this.latitude);
      paramVarArgs.E(4, this.dTj);
      paramVarArgs.e(5, 6, this.MqL);
      paramVarArgs.bb(6, this.BPd);
      paramVarArgs.bb(7, this.MqM);
      paramVarArgs.bb(8, this.MqN);
      AppMethodBeat.o(169919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MqK);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.a.c(5, 6, this.MqL);
      int n = g.a.a.b.b.a.r(6, this.BPd);
      int i1 = g.a.a.b.b.a.r(7, this.MqM);
      int i2 = g.a.a.b.b.a.r(8, this.MqN);
      AppMethodBeat.o(169919);
      return paramInt + i + (j + 4) + (k + 4) + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MqL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cll localcll = (cll)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169919);
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
            localcll.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169919);
          return 0;
        case 2: 
          localcll.MqK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169919);
          return 0;
        case 3: 
          localcll.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169919);
          return 0;
        case 4: 
          localcll.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169919);
          return 0;
        case 5: 
          localcll.MqL.add(((g.a.a.a.a)localObject1).UbS.hPo());
          AppMethodBeat.o(169919);
          return 0;
        case 6: 
          localcll.BPd = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169919);
          return 0;
        case 7: 
          localcll.MqM = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169919);
          return 0;
        }
        localcll.MqN = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169919);
        return 0;
      }
      AppMethodBeat.o(169919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cll
 * JD-Core Version:    0.7.0.1
 */