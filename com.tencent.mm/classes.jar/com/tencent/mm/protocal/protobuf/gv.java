package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gv
  extends com.tencent.mm.bx.a
{
  public int YIq;
  public int YIr;
  public int YIs;
  public ha YIt;
  public gu YIu;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32118);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.YIq);
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      paramVarArgs.bS(3, this.YIr);
      paramVarArgs.bS(4, this.YIs);
      if (this.YIt != null)
      {
        paramVarArgs.qD(5, this.YIt.computeSize());
        this.YIt.writeFields(paramVarArgs);
      }
      if (this.YIu != null)
      {
        paramVarArgs.qD(6, this.YIu.computeSize());
        this.YIu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YIq) + 0;
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.YIr) + i.a.a.b.b.a.cJ(4, this.YIs);
      paramInt = i;
      if (this.YIt != null) {
        paramInt = i + i.a.a.a.qC(5, this.YIt.computeSize());
      }
      i = paramInt;
      if (this.YIu != null) {
        i = paramInt + i.a.a.a.qC(6, this.YIu.computeSize());
      }
      AppMethodBeat.o(32118);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      gv localgv = (gv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32118);
        return -1;
      case 1: 
        localgv.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32118);
        return 0;
      case 2: 
        localgv.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32118);
        return 0;
      case 3: 
        localgv.YIr = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32118);
        return 0;
      case 4: 
        localgv.YIs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32118);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ha();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ha)localObject2).parseFrom((byte[])localObject1);
          }
          localgv.YIt = ((ha)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32118);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new gu();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((gu)localObject2).parseFrom((byte[])localObject1);
        }
        localgv.YIu = ((gu)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    AppMethodBeat.o(32118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gv
 * JD-Core Version:    0.7.0.1
 */