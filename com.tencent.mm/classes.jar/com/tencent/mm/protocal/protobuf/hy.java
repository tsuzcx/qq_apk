package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hy
  extends com.tencent.mm.bw.a
{
  public crm DPT;
  public crm DPU;
  public crm DPV;
  public String DPY;
  public String DRb;
  public int DVn;
  public int DVo;
  public int DVp;
  public LinkedList<crm> DVq;
  public LinkedList<crn> DVr;
  public SKBuiltinBuffer_t DVs;
  public int DVt;
  public int DVu;
  public int DVv;
  public long DVw;
  public int DVx;
  public int ndI;
  public int vTO;
  public long vTQ;
  
  public hy()
  {
    AppMethodBeat.i(32137);
    this.DVq = new LinkedList();
    this.DVr = new LinkedList();
    AppMethodBeat.o(32137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32138);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.DPV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.ndI);
      if (this.DRb != null) {
        paramVarArgs.d(2, this.DRb);
      }
      if (this.DPT != null)
      {
        paramVarArgs.ln(3, this.DPT.computeSize());
        this.DPT.writeFields(paramVarArgs);
      }
      if (this.DPU != null)
      {
        paramVarArgs.ln(4, this.DPU.computeSize());
        this.DPU.writeFields(paramVarArgs);
      }
      if (this.DPV != null)
      {
        paramVarArgs.ln(5, this.DPV.computeSize());
        this.DPV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.DVn);
      paramVarArgs.aR(7, this.DVo);
      if (this.DPY != null) {
        paramVarArgs.d(8, this.DPY);
      }
      paramVarArgs.aR(9, this.vTO);
      paramVarArgs.aR(10, this.DVp);
      paramVarArgs.e(11, 8, this.DVq);
      paramVarArgs.e(12, 8, this.DVr);
      if (this.DVs != null)
      {
        paramVarArgs.ln(13, this.DVs.computeSize());
        this.DVs.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.DVt);
      paramVarArgs.aR(15, this.DVu);
      paramVarArgs.aO(16, this.vTQ);
      paramVarArgs.aR(17, this.DVv);
      paramVarArgs.aO(18, this.DVw);
      paramVarArgs.aR(19, this.DVx);
      AppMethodBeat.o(32138);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ndI) + 0;
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DRb);
      }
      i = paramInt;
      if (this.DPT != null) {
        i = paramInt + f.a.a.a.lm(3, this.DPT.computeSize());
      }
      paramInt = i;
      if (this.DPU != null) {
        paramInt = i + f.a.a.a.lm(4, this.DPU.computeSize());
      }
      i = paramInt;
      if (this.DPV != null) {
        i = paramInt + f.a.a.a.lm(5, this.DPV.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(6, this.DVn) + f.a.a.b.b.a.bx(7, this.DVo);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DPY);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.vTO) + f.a.a.b.b.a.bx(10, this.DVp) + f.a.a.a.c(11, 8, this.DVq) + f.a.a.a.c(12, 8, this.DVr);
      paramInt = i;
      if (this.DVs != null) {
        paramInt = i + f.a.a.a.lm(13, this.DVs.computeSize());
      }
      i = f.a.a.b.b.a.bx(14, this.DVt);
      int j = f.a.a.b.b.a.bx(15, this.DVu);
      int k = f.a.a.b.b.a.p(16, this.vTQ);
      int m = f.a.a.b.b.a.bx(17, this.DVv);
      int n = f.a.a.b.b.a.p(18, this.DVw);
      int i1 = f.a.a.b.b.a.bx(19, this.DVx);
      AppMethodBeat.o(32138);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DVq.clear();
      this.DVr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DPT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.DPV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32138);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      hy localhy = (hy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32138);
        return -1;
      case 1: 
        localhy.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32138);
        return 0;
      case 2: 
        localhy.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhy.DPT = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhy.DPU = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhy.DPV = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 6: 
        localhy.DVn = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32138);
        return 0;
      case 7: 
        localhy.DVo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32138);
        return 0;
      case 8: 
        localhy.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 9: 
        localhy.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32138);
        return 0;
      case 10: 
        localhy.DVp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32138);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhy.DVq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhy.DVr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhy.DVs = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 14: 
        localhy.DVt = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32138);
        return 0;
      case 15: 
        localhy.DVu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32138);
        return 0;
      case 16: 
        localhy.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32138);
        return 0;
      case 17: 
        localhy.DVv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32138);
        return 0;
      case 18: 
        localhy.DVw = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32138);
        return 0;
      }
      localhy.DVx = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(32138);
      return 0;
    }
    AppMethodBeat.o(32138);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hy
 * JD-Core Version:    0.7.0.1
 */