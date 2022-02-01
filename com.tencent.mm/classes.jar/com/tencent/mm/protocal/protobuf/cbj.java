package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbj
  extends com.tencent.mm.bw.a
{
  public String LOY;
  public int LOZ;
  public String LPa;
  public boolean LPb = false;
  public boolean LPc = false;
  public eih Mhd;
  public eih Mhe;
  public String Mhf;
  public String Mhg;
  public boolean Mhh = false;
  public boolean Mhi;
  public cbn Mhj;
  public erd Mhk;
  public boj Mhl;
  public int flags;
  public int msgType = -1;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.msgType);
      if (this.Mhd != null)
      {
        paramVarArgs.ni(2, this.Mhd.computeSize());
        this.Mhd.writeFields(paramVarArgs);
      }
      if (this.Mhe != null)
      {
        paramVarArgs.ni(3, this.Mhe.computeSize());
        this.Mhe.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(4, this.LPb);
      if (this.LOY != null) {
        paramVarArgs.e(5, this.LOY);
      }
      paramVarArgs.aM(6, this.flags);
      if (this.LPa != null) {
        paramVarArgs.e(7, this.LPa);
      }
      if (this.Mhf != null) {
        paramVarArgs.e(8, this.Mhf);
      }
      if (this.Mhg != null) {
        paramVarArgs.e(9, this.Mhg);
      }
      paramVarArgs.cc(10, this.Mhh);
      paramVarArgs.cc(11, this.Mhi);
      paramVarArgs.cc(12, this.LPc);
      if (this.Mhj != null)
      {
        paramVarArgs.ni(13, this.Mhj.computeSize());
        this.Mhj.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(14, this.timestamp);
      if (this.Mhk != null)
      {
        paramVarArgs.ni(15, this.Mhk.computeSize());
        this.Mhk.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(16, this.LOZ);
      if (this.Mhl != null)
      {
        paramVarArgs.ni(17, this.Mhl.computeSize());
        this.Mhl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.msgType) + 0;
      paramInt = i;
      if (this.Mhd != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mhd.computeSize());
      }
      i = paramInt;
      if (this.Mhe != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mhe.computeSize());
      }
      i += g.a.a.b.b.a.fS(4) + 1;
      paramInt = i;
      if (this.LOY != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LOY);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.flags);
      paramInt = i;
      if (this.LPa != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LPa);
      }
      i = paramInt;
      if (this.Mhf != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Mhf);
      }
      paramInt = i;
      if (this.Mhg != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Mhg);
      }
      i = paramInt + (g.a.a.b.b.a.fS(10) + 1) + (g.a.a.b.b.a.fS(11) + 1) + (g.a.a.b.b.a.fS(12) + 1);
      paramInt = i;
      if (this.Mhj != null) {
        paramInt = i + g.a.a.a.nh(13, this.Mhj.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(14, this.timestamp);
      paramInt = i;
      if (this.Mhk != null) {
        paramInt = i + g.a.a.a.nh(15, this.Mhk.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.LOZ);
      paramInt = i;
      if (this.Mhl != null) {
        paramInt = i + g.a.a.a.nh(17, this.Mhl.computeSize());
      }
      AppMethodBeat.o(122507);
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
      AppMethodBeat.o(122507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cbj localcbj = (cbj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122507);
        return -1;
      case 1: 
        localcbj.msgType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122507);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eih();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbj.Mhd = ((eih)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eih();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbj.Mhe = ((eih)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 4: 
        localcbj.LPb = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(122507);
        return 0;
      case 5: 
        localcbj.LOY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 6: 
        localcbj.flags = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122507);
        return 0;
      case 7: 
        localcbj.LPa = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 8: 
        localcbj.Mhf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 9: 
        localcbj.Mhg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 10: 
        localcbj.Mhh = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(122507);
        return 0;
      case 11: 
        localcbj.Mhi = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(122507);
        return 0;
      case 12: 
        localcbj.LPc = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(122507);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbj.Mhj = ((cbn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 14: 
        localcbj.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(122507);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new erd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((erd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbj.Mhk = ((erd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 16: 
        localcbj.LOZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122507);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new boj();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((boj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localcbj.Mhl = ((boj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    AppMethodBeat.o(122507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbj
 * JD-Core Version:    0.7.0.1
 */