package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmu
  extends com.tencent.mm.bw.a
{
  public long Msk;
  public long Msl;
  public long Msm;
  public LinkedList<fbr> Msn;
  public long Mso;
  public boolean Msp;
  public double Msq;
  public LinkedList<fbr> Msr;
  public LinkedList<eko> Mss;
  public ejo Mst;
  public long begin_time;
  public long dDw;
  public long duration;
  public long id;
  public String path;
  
  public cmu()
  {
    AppMethodBeat.i(110905);
    this.Msn = new LinkedList();
    this.Msr = new LinkedList();
    this.Mss = new LinkedList();
    AppMethodBeat.o(110905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110906);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.id);
      paramVarArgs.bb(2, this.dDw);
      paramVarArgs.bb(3, this.begin_time);
      paramVarArgs.bb(4, this.duration);
      paramVarArgs.bb(5, this.Msk);
      paramVarArgs.bb(6, this.Msl);
      paramVarArgs.bb(7, this.Msm);
      paramVarArgs.e(8, 8, this.Msn);
      paramVarArgs.bb(9, this.Mso);
      paramVarArgs.cc(10, this.Msp);
      paramVarArgs.e(11, this.Msq);
      paramVarArgs.e(12, 8, this.Msr);
      paramVarArgs.e(13, 8, this.Mss);
      if (this.Mst != null)
      {
        paramVarArgs.ni(14, this.Mst.computeSize());
        this.Mst.writeFields(paramVarArgs);
      }
      if (this.path != null) {
        paramVarArgs.e(15, this.path);
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.id) + 0 + g.a.a.b.b.a.r(2, this.dDw) + g.a.a.b.b.a.r(3, this.begin_time) + g.a.a.b.b.a.r(4, this.duration) + g.a.a.b.b.a.r(5, this.Msk) + g.a.a.b.b.a.r(6, this.Msl) + g.a.a.b.b.a.r(7, this.Msm) + g.a.a.a.c(8, 8, this.Msn) + g.a.a.b.b.a.r(9, this.Mso) + (g.a.a.b.b.a.fS(10) + 1) + (g.a.a.b.b.a.fS(11) + 8) + g.a.a.a.c(12, 8, this.Msr) + g.a.a.a.c(13, 8, this.Mss);
      paramInt = i;
      if (this.Mst != null) {
        paramInt = i + g.a.a.a.nh(14, this.Mst.computeSize());
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.path);
      }
      AppMethodBeat.o(110906);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Msn.clear();
      this.Msr.clear();
      this.Mss.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cmu localcmu = (cmu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110906);
        return -1;
      case 1: 
        localcmu.id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110906);
        return 0;
      case 2: 
        localcmu.dDw = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110906);
        return 0;
      case 3: 
        localcmu.begin_time = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110906);
        return 0;
      case 4: 
        localcmu.duration = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110906);
        return 0;
      case 5: 
        localcmu.Msk = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110906);
        return 0;
      case 6: 
        localcmu.Msl = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110906);
        return 0;
      case 7: 
        localcmu.Msm = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110906);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fbr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcmu.Msn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 9: 
        localcmu.Mso = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110906);
        return 0;
      case 10: 
        localcmu.Msp = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(110906);
        return 0;
      case 11: 
        localcmu.Msq = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(110906);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fbr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcmu.Msr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eko();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eko)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcmu.Mss.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ejo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcmu.Mst = ((ejo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      }
      localcmu.path = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(110906);
      return 0;
    }
    AppMethodBeat.o(110906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmu
 * JD-Core Version:    0.7.0.1
 */