package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chu
  extends com.tencent.mm.bw.a
{
  public int Mne = 0;
  public ctg Mnf;
  public chw Mng;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200210);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mne);
      if (this.Mnf != null)
      {
        paramVarArgs.ni(2, this.Mnf.computeSize());
        this.Mnf.writeFields(paramVarArgs);
      }
      if (this.Mng != null)
      {
        paramVarArgs.ni(3, this.Mng.computeSize());
        this.Mng.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Mne) + 0;
      paramInt = i;
      if (this.Mnf != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mnf.computeSize());
      }
      i = paramInt;
      if (this.Mng != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mng.computeSize());
      }
      AppMethodBeat.o(200210);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(200210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      chu localchu = (chu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200210);
        return -1;
      case 1: 
        localchu.Mne = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(200210);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localchu.Mnf = ((ctg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200210);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new chw();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((chw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localchu.Mng = ((chw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(200210);
      return 0;
    }
    AppMethodBeat.o(200210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chu
 * JD-Core Version:    0.7.0.1
 */