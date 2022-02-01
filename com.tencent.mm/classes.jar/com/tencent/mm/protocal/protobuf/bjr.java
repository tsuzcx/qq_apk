package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjr
  extends com.tencent.mm.bw.a
{
  public String EIF;
  public String EIG;
  public boolean EIH = false;
  public boolean EII = false;
  public dhz EZc;
  public dhz EZd;
  public String EZe;
  public String EZf;
  public boolean EZg = false;
  public boolean EZh;
  public bjv EZi;
  public int flags;
  public int msgType = -1;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.msgType);
      if (this.EZc != null)
      {
        paramVarArgs.ln(2, this.EZc.computeSize());
        this.EZc.writeFields(paramVarArgs);
      }
      if (this.EZd != null)
      {
        paramVarArgs.ln(3, this.EZd.computeSize());
        this.EZd.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(4, this.EIH);
      if (this.EIF != null) {
        paramVarArgs.d(5, this.EIF);
      }
      paramVarArgs.aR(6, this.flags);
      if (this.EIG != null) {
        paramVarArgs.d(7, this.EIG);
      }
      if (this.EZe != null) {
        paramVarArgs.d(8, this.EZe);
      }
      if (this.EZf != null) {
        paramVarArgs.d(9, this.EZf);
      }
      paramVarArgs.bl(10, this.EZg);
      paramVarArgs.bl(11, this.EZh);
      paramVarArgs.bl(12, this.EII);
      if (this.EZi != null)
      {
        paramVarArgs.ln(13, this.EZi.computeSize());
        this.EZi.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(14, this.timestamp);
      AppMethodBeat.o(122507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.msgType) + 0;
      paramInt = i;
      if (this.EZc != null) {
        paramInt = i + f.a.a.a.lm(2, this.EZc.computeSize());
      }
      i = paramInt;
      if (this.EZd != null) {
        i = paramInt + f.a.a.a.lm(3, this.EZd.computeSize());
      }
      i += f.a.a.b.b.a.fK(4) + 1;
      paramInt = i;
      if (this.EIF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EIF);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.flags);
      paramInt = i;
      if (this.EIG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EIG);
      }
      i = paramInt;
      if (this.EZe != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EZe);
      }
      paramInt = i;
      if (this.EZf != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EZf);
      }
      i = paramInt + (f.a.a.b.b.a.fK(10) + 1) + (f.a.a.b.b.a.fK(11) + 1) + (f.a.a.b.b.a.fK(12) + 1);
      paramInt = i;
      if (this.EZi != null) {
        paramInt = i + f.a.a.a.lm(13, this.EZi.computeSize());
      }
      i = f.a.a.b.b.a.p(14, this.timestamp);
      AppMethodBeat.o(122507);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bjr localbjr = (bjr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122507);
        return -1;
      case 1: 
        localbjr.msgType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122507);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjr.EZc = ((dhz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjr.EZd = ((dhz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 4: 
        localbjr.EIH = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(122507);
        return 0;
      case 5: 
        localbjr.EIF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 6: 
        localbjr.flags = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122507);
        return 0;
      case 7: 
        localbjr.EIG = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 8: 
        localbjr.EZe = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 9: 
        localbjr.EZf = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 10: 
        localbjr.EZg = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(122507);
        return 0;
      case 11: 
        localbjr.EZh = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(122507);
        return 0;
      case 12: 
        localbjr.EII = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(122507);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjr.EZi = ((bjv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      }
      localbjr.timestamp = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(122507);
      return 0;
    }
    AppMethodBeat.o(122507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjr
 * JD-Core Version:    0.7.0.1
 */