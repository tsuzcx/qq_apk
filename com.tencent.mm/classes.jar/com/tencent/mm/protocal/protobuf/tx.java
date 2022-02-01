package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tx
  extends com.tencent.mm.bw.a
{
  public String KBH;
  public LinkedList<adz> Lch;
  public int Lci;
  public String Lcj;
  public String name;
  
  public tx()
  {
    AppMethodBeat.i(32155);
    this.Lch = new LinkedList();
    AppMethodBeat.o(32155);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Lch);
      if (this.KBH != null) {
        paramVarArgs.e(2, this.KBH);
      }
      paramVarArgs.aM(3, this.Lci);
      if (this.Lcj != null) {
        paramVarArgs.e(4, this.Lcj);
      }
      if (this.name != null) {
        paramVarArgs.e(5, this.name);
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Lch) + 0;
      paramInt = i;
      if (this.KBH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KBH);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Lci);
      paramInt = i;
      if (this.Lcj != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lcj);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.name);
      }
      AppMethodBeat.o(32156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lch.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      tx localtx = (tx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32156);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((adz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localtx.Lch.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32156);
        return 0;
      case 2: 
        localtx.KBH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32156);
        return 0;
      case 3: 
        localtx.Lci = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32156);
        return 0;
      case 4: 
        localtx.Lcj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32156);
        return 0;
      }
      localtx.name = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(32156);
      return 0;
    }
    AppMethodBeat.o(32156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tx
 * JD-Core Version:    0.7.0.1
 */