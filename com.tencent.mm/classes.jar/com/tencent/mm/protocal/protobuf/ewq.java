package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ewq
  extends com.tencent.mm.bw.a
{
  public LinkedList<Long> KOJ;
  public long Nuj;
  public int Nuk;
  public SnsObject Nul;
  
  public ewq()
  {
    AppMethodBeat.i(192793);
    this.KOJ = new LinkedList();
    AppMethodBeat.o(192793);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192794);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Nuj);
      paramVarArgs.aM(2, this.Nuk);
      if (this.Nul != null)
      {
        paramVarArgs.ni(3, this.Nul.computeSize());
        this.Nul.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 3, this.KOJ);
      AppMethodBeat.o(192794);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Nuj) + 0 + g.a.a.b.b.a.bu(2, this.Nuk);
      paramInt = i;
      if (this.Nul != null) {
        paramInt = i + g.a.a.a.nh(3, this.Nul.computeSize());
      }
      i = g.a.a.a.c(4, 3, this.KOJ);
      AppMethodBeat.o(192794);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KOJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(192794);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ewq localewq = (ewq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(192794);
        return -1;
      case 1: 
        localewq.Nuj = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(192794);
        return 0;
      case 2: 
        localewq.Nuk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(192794);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SnsObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localewq.Nul = ((SnsObject)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(192794);
        return 0;
      }
      localewq.KOJ.add(Long.valueOf(((g.a.a.a.a)localObject1).UbS.zl()));
      AppMethodBeat.o(192794);
      return 0;
    }
    AppMethodBeat.o(192794);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewq
 * JD-Core Version:    0.7.0.1
 */