package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gb
  extends com.tencent.mm.bw.a
{
  public int FQG;
  public int FQH;
  public gg FQI;
  public ga FQJ;
  public int OpCode;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.OpCode);
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      paramVarArgs.aS(3, this.FQG);
      paramVarArgs.aS(4, this.FQH);
      if (this.FQI != null)
      {
        paramVarArgs.lJ(5, this.FQI.computeSize());
        this.FQI.writeFields(paramVarArgs);
      }
      if (this.FQJ != null)
      {
        paramVarArgs.lJ(6, this.FQJ.computeSize());
        this.FQJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.OpCode) + 0;
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FQG) + f.a.a.b.b.a.bz(4, this.FQH);
      paramInt = i;
      if (this.FQI != null) {
        paramInt = i + f.a.a.a.lI(5, this.FQI.computeSize());
      }
      i = paramInt;
      if (this.FQJ != null) {
        i = paramInt + f.a.a.a.lI(6, this.FQJ.computeSize());
      }
      AppMethodBeat.o(32118);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.ikm == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      gb localgb = (gb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32118);
        return -1;
      case 1: 
        localgb.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32118);
        return 0;
      case 2: 
        localgb.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32118);
        return 0;
      case 3: 
        localgb.FQG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32118);
        return 0;
      case 4: 
        localgb.FQH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32118);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgb.FQI = ((gg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32118);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ga();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ga)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localgb.FQJ = ((ga)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    AppMethodBeat.o(32118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gb
 * JD-Core Version:    0.7.0.1
 */