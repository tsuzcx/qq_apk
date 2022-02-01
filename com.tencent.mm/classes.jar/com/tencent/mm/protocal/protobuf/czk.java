package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czk
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t MEG;
  public int MEH;
  public SKBuiltinBuffer_t MEI;
  public int uin;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129972);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.uin);
      paramVarArgs.aM(2, this.version);
      if (this.MEG != null)
      {
        paramVarArgs.ni(3, this.MEG.computeSize());
        this.MEG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.MEH);
      if (this.MEI != null)
      {
        paramVarArgs.ni(5, this.MEI.computeSize());
        this.MEI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.uin) + 0 + g.a.a.b.b.a.bu(2, this.version);
      paramInt = i;
      if (this.MEG != null) {
        paramInt = i + g.a.a.a.nh(3, this.MEG.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.MEH);
      paramInt = i;
      if (this.MEI != null) {
        paramInt = i + g.a.a.a.nh(5, this.MEI.computeSize());
      }
      AppMethodBeat.o(129972);
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
      AppMethodBeat.o(129972);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      czk localczk = (czk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(129972);
        return -1;
      case 1: 
        localczk.uin = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(129972);
        return 0;
      case 2: 
        localczk.version = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(129972);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localczk.MEG = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(129972);
        return 0;
      case 4: 
        localczk.MEH = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(129972);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localczk.MEI = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    AppMethodBeat.o(129972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czk
 * JD-Core Version:    0.7.0.1
 */