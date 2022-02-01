package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bw.a
{
  public String BqZ;
  public int Brp;
  public LinkedList<l> Brq;
  public LinkedList<l> Brr;
  public LinkedList<l> Brs;
  public LinkedList<aj> Brt;
  public String Bru;
  public int Brv;
  public String content;
  
  public i()
  {
    AppMethodBeat.i(122665);
    this.Brq = new LinkedList();
    this.Brr = new LinkedList();
    this.Brs = new LinkedList();
    this.Brt = new LinkedList();
    this.Brv = 20;
    AppMethodBeat.o(122665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(122666);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Brp);
      if (this.BqZ != null) {
        paramVarArgs.e(2, this.BqZ);
      }
      paramVarArgs.e(3, 8, this.Brq);
      paramVarArgs.e(4, 8, this.Brr);
      paramVarArgs.e(5, 8, this.Brs);
      paramVarArgs.e(6, 8, this.Brt);
      if (this.Bru != null) {
        paramVarArgs.e(7, this.Bru);
      }
      if (this.content != null) {
        paramVarArgs.e(8, this.content);
      }
      paramVarArgs.aM(9, this.Brv);
      AppMethodBeat.o(122666);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Brp) + 0;
      paramInt = i;
      if (this.BqZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.BqZ);
      }
      i = paramInt + g.a.a.a.c(3, 8, this.Brq) + g.a.a.a.c(4, 8, this.Brr) + g.a.a.a.c(5, 8, this.Brs) + g.a.a.a.c(6, 8, this.Brt);
      paramInt = i;
      if (this.Bru != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Bru);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.content);
      }
      paramInt = g.a.a.b.b.a.bu(9, this.Brv);
      AppMethodBeat.o(122666);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Brq.clear();
      this.Brr.clear();
      this.Brs.clear();
      this.Brt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(122666);
        throw paramVarArgs;
      }
      AppMethodBeat.o(122666);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122666);
        return -1;
      case 1: 
        locali.Brp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122666);
        return 0;
      case 2: 
        locali.BqZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locali.Brq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locali.Brr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locali.Brs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locali.Brt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 7: 
        locali.Bru = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 8: 
        locali.content = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122666);
        return 0;
      }
      locali.Brv = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(122666);
      return 0;
    }
    AppMethodBeat.o(122666);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.i
 * JD-Core Version:    0.7.0.1
 */