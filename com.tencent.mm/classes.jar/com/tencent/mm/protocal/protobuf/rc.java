package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rc
  extends com.tencent.mm.bw.a
{
  public int EiQ;
  public String EiR;
  public rm EiS;
  public String EiT;
  public String Eja;
  public String Ejb;
  public String Ejc;
  public String Ejd;
  public LinkedList<rb> Eje;
  public LinkedList<ra> Ejf;
  public String Ejg;
  public String Ejh;
  public rm Eji;
  public rb Ejj;
  public int Ejk;
  public int Ejl;
  public int Ejm;
  public long Ejn;
  
  public rc()
  {
    AppMethodBeat.i(113954);
    this.Eje = new LinkedList();
    this.Ejf = new LinkedList();
    AppMethodBeat.o(113954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eja != null) {
        paramVarArgs.d(1, this.Eja);
      }
      if (this.Ejb != null) {
        paramVarArgs.d(2, this.Ejb);
      }
      if (this.Ejc != null) {
        paramVarArgs.d(3, this.Ejc);
      }
      if (this.Ejd != null) {
        paramVarArgs.d(4, this.Ejd);
      }
      paramVarArgs.e(5, 8, this.Eje);
      paramVarArgs.aR(6, this.EiQ);
      if (this.EiR != null) {
        paramVarArgs.d(7, this.EiR);
      }
      if (this.EiS != null)
      {
        paramVarArgs.ln(8, this.EiS.computeSize());
        this.EiS.writeFields(paramVarArgs);
      }
      if (this.EiT != null) {
        paramVarArgs.d(9, this.EiT);
      }
      paramVarArgs.e(10, 8, this.Ejf);
      if (this.Ejg != null) {
        paramVarArgs.d(11, this.Ejg);
      }
      if (this.Ejh != null) {
        paramVarArgs.d(12, this.Ejh);
      }
      if (this.Eji != null)
      {
        paramVarArgs.ln(13, this.Eji.computeSize());
        this.Eji.writeFields(paramVarArgs);
      }
      if (this.Ejj != null)
      {
        paramVarArgs.ln(14, this.Ejj.computeSize());
        this.Ejj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(15, this.Ejk);
      paramVarArgs.aR(16, this.Ejl);
      paramVarArgs.aR(17, this.Ejm);
      paramVarArgs.aO(18, this.Ejn);
      AppMethodBeat.o(113955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eja == null) {
        break label1630;
      }
    }
    label1630:
    for (int i = f.a.a.b.b.a.e(1, this.Eja) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ejb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ejb);
      }
      i = paramInt;
      if (this.Ejc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ejc);
      }
      paramInt = i;
      if (this.Ejd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ejd);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.Eje) + f.a.a.b.b.a.bx(6, this.EiQ);
      paramInt = i;
      if (this.EiR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EiR);
      }
      i = paramInt;
      if (this.EiS != null) {
        i = paramInt + f.a.a.a.lm(8, this.EiS.computeSize());
      }
      paramInt = i;
      if (this.EiT != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EiT);
      }
      i = paramInt + f.a.a.a.c(10, 8, this.Ejf);
      paramInt = i;
      if (this.Ejg != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Ejg);
      }
      i = paramInt;
      if (this.Ejh != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Ejh);
      }
      paramInt = i;
      if (this.Eji != null) {
        paramInt = i + f.a.a.a.lm(13, this.Eji.computeSize());
      }
      i = paramInt;
      if (this.Ejj != null) {
        i = paramInt + f.a.a.a.lm(14, this.Ejj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(15, this.Ejk);
      int j = f.a.a.b.b.a.bx(16, this.Ejl);
      int k = f.a.a.b.b.a.bx(17, this.Ejm);
      int m = f.a.a.b.b.a.p(18, this.Ejn);
      AppMethodBeat.o(113955);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eje.clear();
        this.Ejf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rc localrc = (rc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113955);
          return -1;
        case 1: 
          localrc.Eja = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 2: 
          localrc.Ejb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 3: 
          localrc.Ejc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 4: 
          localrc.Ejd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrc.Eje.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 6: 
          localrc.EiQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113955);
          return 0;
        case 7: 
          localrc.EiR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrc.EiS = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 9: 
          localrc.EiT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ra();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrc.Ejf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 11: 
          localrc.Ejg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 12: 
          localrc.Ejh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrc.Eji = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrc.Ejj = ((rb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 15: 
          localrc.Ejk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113955);
          return 0;
        case 16: 
          localrc.Ejl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113955);
          return 0;
        case 17: 
          localrc.Ejm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113955);
          return 0;
        }
        localrc.Ejn = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(113955);
        return 0;
      }
      AppMethodBeat.o(113955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rc
 * JD-Core Version:    0.7.0.1
 */