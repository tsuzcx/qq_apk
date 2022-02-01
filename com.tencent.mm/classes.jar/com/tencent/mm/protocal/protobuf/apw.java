package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apw
  extends com.tencent.mm.bw.a
{
  public FinderObject GEz;
  public apx GGX;
  public int dataType;
  public aqj sJm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dataType);
      if (this.GGX != null)
      {
        paramVarArgs.lJ(2, this.GGX.computeSize());
        this.GGX.writeFields(paramVarArgs);
      }
      if (this.sJm != null)
      {
        paramVarArgs.lJ(3, this.sJm.computeSize());
        this.sJm.writeFields(paramVarArgs);
      }
      if (this.GEz != null)
      {
        paramVarArgs.lJ(4, this.GEz.computeSize());
        this.GEz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(189378);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.dataType) + 0;
      paramInt = i;
      if (this.GGX != null) {
        paramInt = i + f.a.a.a.lI(2, this.GGX.computeSize());
      }
      i = paramInt;
      if (this.sJm != null) {
        i = paramInt + f.a.a.a.lI(3, this.sJm.computeSize());
      }
      paramInt = i;
      if (this.GEz != null) {
        paramInt = i + f.a.a.a.lI(4, this.GEz.computeSize());
      }
      AppMethodBeat.o(189378);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189378);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      apw localapw = (apw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(189378);
        return -1;
      case 1: 
        localapw.dataType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189378);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localapw.GGX = ((apx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189378);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localapw.sJm = ((aqj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189378);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new FinderObject();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localapw.GEz = ((FinderObject)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(189378);
      return 0;
    }
    AppMethodBeat.o(189378);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apw
 * JD-Core Version:    0.7.0.1
 */