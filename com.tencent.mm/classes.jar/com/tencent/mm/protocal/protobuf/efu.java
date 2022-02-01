package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efu
  extends com.tencent.mm.bw.a
{
  public String KNW;
  public int MMP;
  public int NfN;
  public ahg NfO;
  public ahg NfP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91706);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MMP);
      paramVarArgs.aM(2, this.NfN);
      if (this.KNW != null) {
        paramVarArgs.e(3, this.KNW);
      }
      if (this.NfO != null)
      {
        paramVarArgs.ni(4, this.NfO.computeSize());
        this.NfO.writeFields(paramVarArgs);
      }
      if (this.NfP != null)
      {
        paramVarArgs.ni(5, this.NfP.computeSize());
        this.NfP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MMP) + 0 + g.a.a.b.b.a.bu(2, this.NfN);
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KNW);
      }
      i = paramInt;
      if (this.NfO != null) {
        i = paramInt + g.a.a.a.nh(4, this.NfO.computeSize());
      }
      paramInt = i;
      if (this.NfP != null) {
        paramInt = i + g.a.a.a.nh(5, this.NfP.computeSize());
      }
      AppMethodBeat.o(91706);
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
      AppMethodBeat.o(91706);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      efu localefu = (efu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91706);
        return -1;
      case 1: 
        localefu.MMP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91706);
        return 0;
      case 2: 
        localefu.NfN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91706);
        return 0;
      case 3: 
        localefu.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91706);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localefu.NfO = ((ahg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91706);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ahg();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ahg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localefu.NfP = ((ahg)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    AppMethodBeat.o(91706);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efu
 * JD-Core Version:    0.7.0.1
 */