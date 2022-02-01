package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayr
  extends com.tencent.mm.bw.a
{
  public ays LIR;
  public int dataType;
  public FinderObject tuO;
  public azm vEa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209599);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dataType);
      if (this.LIR != null)
      {
        paramVarArgs.ni(2, this.LIR.computeSize());
        this.LIR.writeFields(paramVarArgs);
      }
      if (this.vEa != null)
      {
        paramVarArgs.ni(3, this.vEa.computeSize());
        this.vEa.writeFields(paramVarArgs);
      }
      if (this.tuO != null)
      {
        paramVarArgs.ni(4, this.tuO.computeSize());
        this.tuO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209599);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.dataType) + 0;
      paramInt = i;
      if (this.LIR != null) {
        paramInt = i + g.a.a.a.nh(2, this.LIR.computeSize());
      }
      i = paramInt;
      if (this.vEa != null) {
        i = paramInt + g.a.a.a.nh(3, this.vEa.computeSize());
      }
      paramInt = i;
      if (this.tuO != null) {
        paramInt = i + g.a.a.a.nh(4, this.tuO.computeSize());
      }
      AppMethodBeat.o(209599);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209599);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ayr localayr = (ayr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209599);
        return -1;
      case 1: 
        localayr.dataType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209599);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ays();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ays)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localayr.LIR = ((ays)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209599);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localayr.vEa = ((azm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209599);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new FinderObject();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localayr.tuO = ((FinderObject)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209599);
      return 0;
    }
    AppMethodBeat.o(209599);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayr
 * JD-Core Version:    0.7.0.1
 */