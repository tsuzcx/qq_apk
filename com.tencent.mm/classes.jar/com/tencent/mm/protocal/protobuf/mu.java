package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class mu
  extends com.tencent.mm.bw.a
{
  public int EbD;
  public int EbM;
  public int EbN;
  public int EbO;
  public int EbP;
  public long EbQ;
  public long EbR;
  public boolean EbS;
  public int EbT;
  public boolean EbU;
  public io EbV;
  public boolean EbW;
  public ty EbX;
  public LinkedList<dvc> EbY;
  public boolean EbZ;
  public String Ebs;
  public LinkedList<String> Eca;
  public String Ecb;
  public String Ecc;
  
  public mu()
  {
    AppMethodBeat.i(209565);
    this.EbY = new LinkedList();
    this.Eca = new LinkedList();
    AppMethodBeat.o(209565);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebs == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124426);
        throw paramVarArgs;
      }
      if (this.Ebs != null) {
        paramVarArgs.d(1, this.Ebs);
      }
      paramVarArgs.aR(2, this.EbM);
      paramVarArgs.aR(3, this.EbN);
      paramVarArgs.aR(4, this.EbO);
      paramVarArgs.aR(5, this.EbP);
      paramVarArgs.aO(6, this.EbQ);
      paramVarArgs.aO(7, this.EbR);
      paramVarArgs.aR(8, this.EbD);
      paramVarArgs.bl(9, this.EbS);
      paramVarArgs.aR(10, this.EbT);
      paramVarArgs.bl(11, this.EbU);
      if (this.EbV != null)
      {
        paramVarArgs.ln(12, this.EbV.computeSize());
        this.EbV.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(13, this.EbW);
      if (this.EbX != null)
      {
        paramVarArgs.ln(14, this.EbX.computeSize());
        this.EbX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.EbY);
      paramVarArgs.bl(16, this.EbZ);
      paramVarArgs.e(17, 1, this.Eca);
      if (this.Ecb != null) {
        paramVarArgs.d(18, this.Ecb);
      }
      if (this.Ecc != null) {
        paramVarArgs.d(19, this.Ecc);
      }
      AppMethodBeat.o(124426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ebs == null) {
        break label1418;
      }
    }
    label1418:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ebs) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EbM) + f.a.a.b.b.a.bx(3, this.EbN) + f.a.a.b.b.a.bx(4, this.EbO) + f.a.a.b.b.a.bx(5, this.EbP) + f.a.a.b.b.a.p(6, this.EbQ) + f.a.a.b.b.a.p(7, this.EbR) + f.a.a.b.b.a.bx(8, this.EbD) + (f.a.a.b.b.a.fK(9) + 1) + f.a.a.b.b.a.bx(10, this.EbT) + (f.a.a.b.b.a.fK(11) + 1);
      paramInt = i;
      if (this.EbV != null) {
        paramInt = i + f.a.a.a.lm(12, this.EbV.computeSize());
      }
      i = paramInt + (f.a.a.b.b.a.fK(13) + 1);
      paramInt = i;
      if (this.EbX != null) {
        paramInt = i + f.a.a.a.lm(14, this.EbX.computeSize());
      }
      i = paramInt + f.a.a.a.c(15, 8, this.EbY) + (f.a.a.b.b.a.fK(16) + 1) + f.a.a.a.c(17, 1, this.Eca);
      paramInt = i;
      if (this.Ecb != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Ecb);
      }
      i = paramInt;
      if (this.Ecc != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.Ecc);
      }
      AppMethodBeat.o(124426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EbY.clear();
        this.Eca.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Ebs == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mu localmu = (mu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124426);
          return -1;
        case 1: 
          localmu.Ebs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124426);
          return 0;
        case 2: 
          localmu.EbM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124426);
          return 0;
        case 3: 
          localmu.EbN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124426);
          return 0;
        case 4: 
          localmu.EbO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124426);
          return 0;
        case 5: 
          localmu.EbP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124426);
          return 0;
        case 6: 
          localmu.EbQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124426);
          return 0;
        case 7: 
          localmu.EbR = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124426);
          return 0;
        case 8: 
          localmu.EbD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124426);
          return 0;
        case 9: 
          localmu.EbS = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(124426);
          return 0;
        case 10: 
          localmu.EbT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124426);
          return 0;
        case 11: 
          localmu.EbU = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(124426);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new io();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((io)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmu.EbV = ((io)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 13: 
          localmu.EbW = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(124426);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ty();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmu.EbX = ((ty)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmu.EbY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 16: 
          localmu.EbZ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(124426);
          return 0;
        case 17: 
          localmu.Eca.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(124426);
          return 0;
        case 18: 
          localmu.Ecb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124426);
          return 0;
        }
        localmu.Ecc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124426);
        return 0;
      }
      AppMethodBeat.o(124426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mu
 * JD-Core Version:    0.7.0.1
 */