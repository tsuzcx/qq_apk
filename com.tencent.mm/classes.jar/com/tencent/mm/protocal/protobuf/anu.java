package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anu
  extends com.tencent.mm.bw.a
{
  public String DtK;
  public String EGB;
  public String EGC;
  public int EGD;
  public int EGE;
  public String EGF;
  public String EGG;
  public alj EGH;
  public alf EGI;
  public int hSw;
  public String ohG;
  public aoe qXj;
  public int recommendType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195112);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ohG != null) {
        paramVarArgs.d(1, this.ohG);
      }
      if (this.EGB != null) {
        paramVarArgs.d(2, this.EGB);
      }
      if (this.EGC != null) {
        paramVarArgs.d(3, this.EGC);
      }
      paramVarArgs.aR(4, this.EGD);
      paramVarArgs.aR(5, this.EGE);
      if (this.EGF != null) {
        paramVarArgs.d(6, this.EGF);
      }
      if (this.EGG != null) {
        paramVarArgs.d(7, this.EGG);
      }
      if (this.DtK != null) {
        paramVarArgs.d(8, this.DtK);
      }
      paramVarArgs.aR(9, this.hSw);
      if (this.EGH != null)
      {
        paramVarArgs.ln(10, this.EGH.computeSize());
        this.EGH.writeFields(paramVarArgs);
      }
      if (this.qXj != null)
      {
        paramVarArgs.ln(11, this.qXj.computeSize());
        this.qXj.writeFields(paramVarArgs);
      }
      if (this.EGI != null)
      {
        paramVarArgs.ln(12, this.EGI.computeSize());
        this.EGI.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.recommendType);
      AppMethodBeat.o(195112);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ohG == null) {
        break label1170;
      }
    }
    label1170:
    for (int i = f.a.a.b.b.a.e(1, this.ohG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EGB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EGB);
      }
      i = paramInt;
      if (this.EGC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EGC);
      }
      i = i + f.a.a.b.b.a.bx(4, this.EGD) + f.a.a.b.b.a.bx(5, this.EGE);
      paramInt = i;
      if (this.EGF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EGF);
      }
      i = paramInt;
      if (this.EGG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EGG);
      }
      paramInt = i;
      if (this.DtK != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DtK);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.hSw);
      paramInt = i;
      if (this.EGH != null) {
        paramInt = i + f.a.a.a.lm(10, this.EGH.computeSize());
      }
      i = paramInt;
      if (this.qXj != null) {
        i = paramInt + f.a.a.a.lm(11, this.qXj.computeSize());
      }
      paramInt = i;
      if (this.EGI != null) {
        paramInt = i + f.a.a.a.lm(12, this.EGI.computeSize());
      }
      i = f.a.a.b.b.a.bx(13, this.recommendType);
      AppMethodBeat.o(195112);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195112);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anu localanu = (anu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195112);
          return -1;
        case 1: 
          localanu.ohG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195112);
          return 0;
        case 2: 
          localanu.EGB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195112);
          return 0;
        case 3: 
          localanu.EGC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195112);
          return 0;
        case 4: 
          localanu.EGD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195112);
          return 0;
        case 5: 
          localanu.EGE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195112);
          return 0;
        case 6: 
          localanu.EGF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195112);
          return 0;
        case 7: 
          localanu.EGG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195112);
          return 0;
        case 8: 
          localanu.DtK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195112);
          return 0;
        case 9: 
          localanu.hSw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195112);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanu.EGH = ((alj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195112);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanu.qXj = ((aoe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195112);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanu.EGI = ((alf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195112);
          return 0;
        }
        localanu.recommendType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(195112);
        return 0;
      }
      AppMethodBeat.o(195112);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anu
 * JD-Core Version:    0.7.0.1
 */