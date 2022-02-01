package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eaj
  extends com.tencent.mm.bw.a
{
  public int MZH;
  public ebp MZI;
  public dio MZJ;
  public agf MZK;
  public deh MZL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125802);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MZH);
      if (this.MZI != null)
      {
        paramVarArgs.ni(2, this.MZI.computeSize());
        this.MZI.writeFields(paramVarArgs);
      }
      if (this.MZJ != null)
      {
        paramVarArgs.ni(3, this.MZJ.computeSize());
        this.MZJ.writeFields(paramVarArgs);
      }
      if (this.MZK != null)
      {
        paramVarArgs.ni(4, this.MZK.computeSize());
        this.MZK.writeFields(paramVarArgs);
      }
      if (this.MZL != null)
      {
        paramVarArgs.ni(5, this.MZL.computeSize());
        this.MZL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MZH) + 0;
      paramInt = i;
      if (this.MZI != null) {
        paramInt = i + g.a.a.a.nh(2, this.MZI.computeSize());
      }
      i = paramInt;
      if (this.MZJ != null) {
        i = paramInt + g.a.a.a.nh(3, this.MZJ.computeSize());
      }
      paramInt = i;
      if (this.MZK != null) {
        paramInt = i + g.a.a.a.nh(4, this.MZK.computeSize());
      }
      i = paramInt;
      if (this.MZL != null) {
        i = paramInt + g.a.a.a.nh(5, this.MZL.computeSize());
      }
      AppMethodBeat.o(125802);
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
      AppMethodBeat.o(125802);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eaj localeaj = (eaj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125802);
        return -1;
      case 1: 
        localeaj.MZH = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125802);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeaj.MZI = ((ebp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dio();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeaj.MZJ = ((dio)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeaj.MZK = ((agf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new deh();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((deh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeaj.MZL = ((deh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    AppMethodBeat.o(125802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaj
 * JD-Core Version:    0.7.0.1
 */