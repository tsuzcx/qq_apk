package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwk
  extends com.tencent.mm.bx.a
{
  public long ZNj;
  public String ZYN;
  public int aaft;
  public bxq aafu;
  public int aafv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258654);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaft);
      if (this.aafu != null)
      {
        paramVarArgs.qD(2, this.aafu.computeSize());
        this.aafu.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aafv);
      paramVarArgs.bv(4, this.ZNj);
      if (this.ZYN != null) {
        paramVarArgs.g(5, this.ZYN);
      }
      AppMethodBeat.o(258654);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaft) + 0;
      paramInt = i;
      if (this.aafu != null) {
        paramInt = i + i.a.a.a.qC(2, this.aafu.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.aafv) + i.a.a.b.b.a.q(4, this.ZNj);
      paramInt = i;
      if (this.ZYN != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZYN);
      }
      AppMethodBeat.o(258654);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258654);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bwk localbwk = (bwk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258654);
        return -1;
      case 1: 
        localbwk.aaft = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258654);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bxq localbxq = new bxq();
          if ((localObject != null) && (localObject.length > 0)) {
            localbxq.parseFrom((byte[])localObject);
          }
          localbwk.aafu = localbxq;
          paramInt += 1;
        }
        AppMethodBeat.o(258654);
        return 0;
      case 3: 
        localbwk.aafv = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258654);
        return 0;
      case 4: 
        localbwk.ZNj = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258654);
        return 0;
      }
      localbwk.ZYN = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258654);
      return 0;
    }
    AppMethodBeat.o(258654);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwk
 * JD-Core Version:    0.7.0.1
 */