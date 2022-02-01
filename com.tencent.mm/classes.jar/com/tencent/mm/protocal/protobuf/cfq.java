package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfq
  extends com.tencent.mm.bw.a
{
  public String AWI;
  public String AWJ;
  public int AWN;
  public String AWO;
  public djd FtX;
  public bws FtY;
  public bup FtZ;
  public String cZz;
  public long dBN;
  public int fsg;
  public int state;
  public String tGS;
  public String vxk;
  public String wEw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fsg);
      paramVarArgs.aO(2, this.dBN);
      if (this.cZz != null) {
        paramVarArgs.d(3, this.cZz);
      }
      if (this.vxk != null) {
        paramVarArgs.d(4, this.vxk);
      }
      if (this.AWI != null) {
        paramVarArgs.d(5, this.AWI);
      }
      if (this.AWJ != null) {
        paramVarArgs.d(6, this.AWJ);
      }
      if (this.FtX != null)
      {
        paramVarArgs.ln(7, this.FtX.computeSize());
        this.FtX.writeFields(paramVarArgs);
      }
      if (this.FtY != null)
      {
        paramVarArgs.ln(8, this.FtY.computeSize());
        this.FtY.writeFields(paramVarArgs);
      }
      if (this.FtZ != null)
      {
        paramVarArgs.ln(9, this.FtZ.computeSize());
        this.FtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.AWN);
      paramVarArgs.aR(11, this.state);
      if (this.tGS != null) {
        paramVarArgs.d(12, this.tGS);
      }
      if (this.wEw != null) {
        paramVarArgs.d(13, this.wEw);
      }
      if (this.AWO != null) {
        paramVarArgs.d(14, this.AWO);
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.fsg) + 0 + f.a.a.b.b.a.p(2, this.dBN);
      paramInt = i;
      if (this.cZz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.cZz);
      }
      i = paramInt;
      if (this.vxk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vxk);
      }
      paramInt = i;
      if (this.AWI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.AWI);
      }
      i = paramInt;
      if (this.AWJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.AWJ);
      }
      paramInt = i;
      if (this.FtX != null) {
        paramInt = i + f.a.a.a.lm(7, this.FtX.computeSize());
      }
      i = paramInt;
      if (this.FtY != null) {
        i = paramInt + f.a.a.a.lm(8, this.FtY.computeSize());
      }
      paramInt = i;
      if (this.FtZ != null) {
        paramInt = i + f.a.a.a.lm(9, this.FtZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.AWN) + f.a.a.b.b.a.bx(11, this.state);
      paramInt = i;
      if (this.tGS != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.tGS);
      }
      i = paramInt;
      if (this.wEw != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.wEw);
      }
      paramInt = i;
      if (this.AWO != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.AWO);
      }
      AppMethodBeat.o(91618);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cfq localcfq = (cfq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91618);
        return -1;
      case 1: 
        localcfq.fsg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91618);
        return 0;
      case 2: 
        localcfq.dBN = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91618);
        return 0;
      case 3: 
        localcfq.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 4: 
        localcfq.vxk = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 5: 
        localcfq.AWI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 6: 
        localcfq.AWJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((djd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcfq.FtX = ((djd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bws();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcfq.FtY = ((bws)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bup();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bup)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcfq.FtZ = ((bup)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 10: 
        localcfq.AWN = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91618);
        return 0;
      case 11: 
        localcfq.state = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91618);
        return 0;
      case 12: 
        localcfq.tGS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 13: 
        localcfq.wEw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91618);
        return 0;
      }
      localcfq.AWO = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91618);
      return 0;
    }
    AppMethodBeat.o(91618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfq
 * JD-Core Version:    0.7.0.1
 */