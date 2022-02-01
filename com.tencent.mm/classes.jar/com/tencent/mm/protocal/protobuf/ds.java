package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ds
  extends com.tencent.mm.bw.a
{
  public dzd KHG;
  public dqi KHH;
  public int KHI;
  public dmo KHJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125705);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHG == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsADObject");
        AppMethodBeat.o(125705);
        throw paramVarArgs;
      }
      if (this.KHG != null)
      {
        paramVarArgs.ni(1, this.KHG.computeSize());
        this.KHG.writeFields(paramVarArgs);
      }
      if (this.KHH != null)
      {
        paramVarArgs.ni(2, this.KHH.computeSize());
        this.KHH.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.KHI);
      if (this.KHJ != null)
      {
        paramVarArgs.ni(4, this.KHJ.computeSize());
        this.KHJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHG == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = g.a.a.a.nh(1, this.KHG.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KHH != null) {
        i = paramInt + g.a.a.a.nh(2, this.KHH.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.KHI);
      paramInt = i;
      if (this.KHJ != null) {
        paramInt = i + g.a.a.a.nh(4, this.KHJ.computeSize());
      }
      AppMethodBeat.o(125705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHG == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsADObject");
          AppMethodBeat.o(125705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ds localds = (ds)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125705);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localds.KHG = ((dzd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localds.KHH = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 3: 
          localds.KHI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125705);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localds.KHJ = ((dmo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      AppMethodBeat.o(125705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ds
 * JD-Core Version:    0.7.0.1
 */