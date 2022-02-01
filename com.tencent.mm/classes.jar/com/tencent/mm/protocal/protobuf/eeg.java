package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eeg
  extends com.tencent.mm.bw.a
{
  public long Id;
  public eeh Ney;
  public eeh Nez;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ney == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Id);
      paramVarArgs.aM(2, this.oUv);
      if (this.Ney != null)
      {
        paramVarArgs.ni(3, this.Ney.computeSize());
        this.Ney.writeFields(paramVarArgs);
      }
      if (this.Nez != null)
      {
        paramVarArgs.ni(4, this.Nez.computeSize());
        this.Nez.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Id) + 0 + g.a.a.b.b.a.bu(2, this.oUv);
      paramInt = i;
      if (this.Ney != null) {
        paramInt = i + g.a.a.a.nh(3, this.Ney.computeSize());
      }
      i = paramInt;
      if (this.Nez != null) {
        i = paramInt + g.a.a.a.nh(4, this.Nez.computeSize());
      }
      AppMethodBeat.o(118471);
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
      if (this.Ney == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eeg localeeg = (eeg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118471);
        return -1;
      case 1: 
        localeeg.Id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(118471);
        return 0;
      case 2: 
        localeeg.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118471);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeeg.Ney = ((eeh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118471);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eeh();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((eeh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeeg.Nez = ((eeh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    AppMethodBeat.o(118471);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeg
 * JD-Core Version:    0.7.0.1
 */