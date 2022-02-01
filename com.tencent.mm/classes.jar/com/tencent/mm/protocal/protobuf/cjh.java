package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjh
  extends com.tencent.mm.bx.a
{
  public long aarR;
  public String aarS;
  public emd aarT;
  public gim aarU;
  public int aarV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258553);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aarR);
      if (this.aarS != null) {
        paramVarArgs.g(2, this.aarS);
      }
      if (this.aarT != null)
      {
        paramVarArgs.qD(3, this.aarT.computeSize());
        this.aarT.writeFields(paramVarArgs);
      }
      if (this.aarU != null)
      {
        paramVarArgs.qD(4, this.aarU.computeSize());
        this.aarU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.aarV);
      AppMethodBeat.o(258553);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.aarR) + 0;
      paramInt = i;
      if (this.aarS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aarS);
      }
      i = paramInt;
      if (this.aarT != null) {
        i = paramInt + i.a.a.a.qC(3, this.aarT.computeSize());
      }
      paramInt = i;
      if (this.aarU != null) {
        paramInt = i + i.a.a.a.qC(4, this.aarU.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.aarV);
      AppMethodBeat.o(258553);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258553);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      cjh localcjh = (cjh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258553);
        return -1;
      case 1: 
        localcjh.aarR = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258553);
        return 0;
      case 2: 
        localcjh.aarS = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258553);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new emd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((emd)localObject2).parseFrom((byte[])localObject1);
          }
          localcjh.aarT = ((emd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258553);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gim();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gim)localObject2).parseFrom((byte[])localObject1);
          }
          localcjh.aarU = ((gim)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258553);
        return 0;
      }
      localcjh.aarV = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(258553);
      return 0;
    }
    AppMethodBeat.o(258553);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjh
 * JD-Core Version:    0.7.0.1
 */