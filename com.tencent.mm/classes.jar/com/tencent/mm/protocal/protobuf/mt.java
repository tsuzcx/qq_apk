package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mt
  extends com.tencent.mm.bw.a
{
  public int DSk;
  public String DSl;
  public int EaR;
  public int EaS;
  public int EbE;
  public int EbF;
  public int EbG;
  public yl EbH;
  public int EbI;
  public int EbJ;
  public int EbK = 0;
  public int EbL;
  public String content;
  public String hhs;
  public String oGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103203);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EbE);
      paramVarArgs.aR(2, this.DSk);
      if (this.DSl != null) {
        paramVarArgs.d(3, this.DSl);
      }
      if (this.oGg != null) {
        paramVarArgs.d(4, this.oGg);
      }
      if (this.hhs != null) {
        paramVarArgs.d(5, this.hhs);
      }
      if (this.content != null) {
        paramVarArgs.d(6, this.content);
      }
      paramVarArgs.aR(7, this.EbF);
      paramVarArgs.aR(8, this.EbG);
      paramVarArgs.aR(9, this.EaR);
      paramVarArgs.aR(10, this.EaS);
      if (this.EbH != null)
      {
        paramVarArgs.ln(11, this.EbH.computeSize());
        this.EbH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.EbI);
      paramVarArgs.aR(13, this.EbJ);
      paramVarArgs.aR(14, this.EbK);
      paramVarArgs.aR(15, this.EbL);
      AppMethodBeat.o(103203);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EbE) + 0 + f.a.a.b.b.a.bx(2, this.DSk);
      paramInt = i;
      if (this.DSl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DSl);
      }
      i = paramInt;
      if (this.oGg != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.oGg);
      }
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hhs);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.content);
      }
      i = i + f.a.a.b.b.a.bx(7, this.EbF) + f.a.a.b.b.a.bx(8, this.EbG) + f.a.a.b.b.a.bx(9, this.EaR) + f.a.a.b.b.a.bx(10, this.EaS);
      paramInt = i;
      if (this.EbH != null) {
        paramInt = i + f.a.a.a.lm(11, this.EbH.computeSize());
      }
      i = f.a.a.b.b.a.bx(12, this.EbI);
      int j = f.a.a.b.b.a.bx(13, this.EbJ);
      int k = f.a.a.b.b.a.bx(14, this.EbK);
      int m = f.a.a.b.b.a.bx(15, this.EbL);
      AppMethodBeat.o(103203);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(103203);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      mt localmt = (mt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(103203);
        return -1;
      case 1: 
        localmt.EbE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      case 2: 
        localmt.DSk = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      case 3: 
        localmt.DSl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 4: 
        localmt.oGg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 5: 
        localmt.hhs = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 6: 
        localmt.content = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 7: 
        localmt.EbF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      case 8: 
        localmt.EbG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      case 9: 
        localmt.EaR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      case 10: 
        localmt.EaS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((yl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmt.EbH = ((yl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(103203);
        return 0;
      case 12: 
        localmt.EbI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      case 13: 
        localmt.EbJ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      case 14: 
        localmt.EbK = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103203);
        return 0;
      }
      localmt.EbL = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(103203);
      return 0;
    }
    AppMethodBeat.o(103203);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mt
 * JD-Core Version:    0.7.0.1
 */