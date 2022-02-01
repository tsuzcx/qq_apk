package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aij
  extends com.tencent.mm.bw.a
{
  public LinkedList<aii> LrQ;
  public String script;
  public String syg;
  public int syj;
  public int syk;
  public int syl;
  public int syn;
  public int syo;
  public int syp;
  public int syq;
  public String syr;
  public String sys;
  
  public aij()
  {
    AppMethodBeat.i(220691);
    this.LrQ = new LinkedList();
    AppMethodBeat.o(220691);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220692);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.syg != null) {
        paramVarArgs.e(1, this.syg);
      }
      paramVarArgs.aM(2, this.syj);
      paramVarArgs.aM(3, this.syk);
      paramVarArgs.aM(4, this.syl);
      paramVarArgs.e(5, 8, this.LrQ);
      paramVarArgs.aM(6, this.syn);
      paramVarArgs.aM(7, this.syq);
      if (this.script != null) {
        paramVarArgs.e(8, this.script);
      }
      if (this.syr != null) {
        paramVarArgs.e(9, this.syr);
      }
      paramVarArgs.aM(10, this.syp);
      paramVarArgs.aM(11, this.syo);
      if (this.sys != null) {
        paramVarArgs.e(12, this.sys);
      }
      AppMethodBeat.o(220692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.syg == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = g.a.a.b.b.a.f(1, this.syg) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.syj) + g.a.a.b.b.a.bu(3, this.syk) + g.a.a.b.b.a.bu(4, this.syl) + g.a.a.a.c(5, 8, this.LrQ) + g.a.a.b.b.a.bu(6, this.syn) + g.a.a.b.b.a.bu(7, this.syq);
      paramInt = i;
      if (this.script != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.script);
      }
      i = paramInt;
      if (this.syr != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.syr);
      }
      i = i + g.a.a.b.b.a.bu(10, this.syp) + g.a.a.b.b.a.bu(11, this.syo);
      paramInt = i;
      if (this.sys != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.sys);
      }
      AppMethodBeat.o(220692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LrQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(220692);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aij localaij = (aij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220692);
          return -1;
        case 1: 
          localaij.syg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220692);
          return 0;
        case 2: 
          localaij.syj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220692);
          return 0;
        case 3: 
          localaij.syk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220692);
          return 0;
        case 4: 
          localaij.syl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220692);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aii();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aii)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaij.LrQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220692);
          return 0;
        case 6: 
          localaij.syn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220692);
          return 0;
        case 7: 
          localaij.syq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220692);
          return 0;
        case 8: 
          localaij.script = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220692);
          return 0;
        case 9: 
          localaij.syr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220692);
          return 0;
        case 10: 
          localaij.syp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220692);
          return 0;
        case 11: 
          localaij.syo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220692);
          return 0;
        }
        localaij.sys = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(220692);
        return 0;
      }
      AppMethodBeat.o(220692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aij
 * JD-Core Version:    0.7.0.1
 */