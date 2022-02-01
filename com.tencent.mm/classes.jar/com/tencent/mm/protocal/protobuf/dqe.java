package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqe
  extends com.tencent.mm.bw.a
{
  public LinkedList<ahg> LpW;
  public ehu MTh;
  public ahf MTi;
  public int MTj;
  public boolean MTk;
  public aep MTl;
  public bj MTm;
  public int type;
  public String url;
  
  public dqe()
  {
    AppMethodBeat.i(91676);
    this.LpW = new LinkedList();
    AppMethodBeat.o(91676);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91677);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.MTh != null)
      {
        paramVarArgs.ni(3, this.MTh.computeSize());
        this.MTh.writeFields(paramVarArgs);
      }
      if (this.MTi != null)
      {
        paramVarArgs.ni(4, this.MTi.computeSize());
        this.MTi.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.MTj);
      paramVarArgs.cc(6, this.MTk);
      paramVarArgs.e(7, 8, this.LpW);
      if (this.MTl != null)
      {
        paramVarArgs.ni(8, this.MTl.computeSize());
        this.MTl.writeFields(paramVarArgs);
      }
      if (this.MTm != null)
      {
        paramVarArgs.ni(9, this.MTm.computeSize());
        this.MTm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.MTh != null) {
        i = paramInt + g.a.a.a.nh(3, this.MTh.computeSize());
      }
      paramInt = i;
      if (this.MTi != null) {
        paramInt = i + g.a.a.a.nh(4, this.MTi.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MTj) + (g.a.a.b.b.a.fS(6) + 1) + g.a.a.a.c(7, 8, this.LpW);
      paramInt = i;
      if (this.MTl != null) {
        paramInt = i + g.a.a.a.nh(8, this.MTl.computeSize());
      }
      i = paramInt;
      if (this.MTm != null) {
        i = paramInt + g.a.a.a.nh(9, this.MTm.computeSize());
      }
      AppMethodBeat.o(91677);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LpW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dqe localdqe = (dqe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91677);
        return -1;
      case 1: 
        localdqe.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91677);
        return 0;
      case 2: 
        localdqe.url = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91677);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdqe.MTh = ((ehu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdqe.MTi = ((ahf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 5: 
        localdqe.MTj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91677);
        return 0;
      case 6: 
        localdqe.MTk = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(91677);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdqe.LpW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aep();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aep)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdqe.MTl = ((aep)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bj();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdqe.MTm = ((bj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    AppMethodBeat.o(91677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqe
 * JD-Core Version:    0.7.0.1
 */