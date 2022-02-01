package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsw
  extends cpx
{
  public LinkedList<dcg> EPF;
  public double Ecf;
  public double Ecg;
  public int EqS;
  public int Exf;
  public long Exg;
  public long Gbe;
  public crm Gbf;
  public crm Gbg;
  public int Gbh;
  
  public dsw()
  {
    AppMethodBeat.i(115913);
    this.EPF = new LinkedList();
    AppMethodBeat.o(115913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115914);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gbf == null)
      {
        paramVarArgs = new b("Not all required fields were included: NetName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.Gbg == null)
      {
        paramVarArgs = new b("Not all required fields were included: WifiName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Gbe);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.EqS);
      if (this.Gbf != null)
      {
        paramVarArgs.ln(5, this.Gbf.computeSize());
        this.Gbf.writeFields(paramVarArgs);
      }
      if (this.Gbg != null)
      {
        paramVarArgs.ln(6, this.Gbg.computeSize());
        this.Gbg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, this.Ecf);
      paramVarArgs.e(8, this.Ecg);
      paramVarArgs.aR(9, this.Exf);
      paramVarArgs.aR(10, this.Gbh);
      paramVarArgs.e(11, 8, this.EPF);
      AppMethodBeat.o(115914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1184;
      }
    }
    label1184:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Gbe) + f.a.a.b.b.a.p(3, this.Exg) + f.a.a.b.b.a.bx(4, this.EqS);
      paramInt = i;
      if (this.Gbf != null) {
        paramInt = i + f.a.a.a.lm(5, this.Gbf.computeSize());
      }
      i = paramInt;
      if (this.Gbg != null) {
        i = paramInt + f.a.a.a.lm(6, this.Gbg.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(7);
      int j = f.a.a.b.b.a.fK(8);
      int k = f.a.a.b.b.a.bx(9, this.Exf);
      int m = f.a.a.b.b.a.bx(10, this.Gbh);
      int n = f.a.a.a.c(11, 8, this.EPF);
      AppMethodBeat.o(115914);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EPF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Gbf == null)
        {
          paramVarArgs = new b("Not all required fields were included: NetName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        if (this.Gbg == null)
        {
          paramVarArgs = new b("Not all required fields were included: WifiName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsw localdsw = (dsw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115914);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 2: 
          localdsw.Gbe = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115914);
          return 0;
        case 3: 
          localdsw.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115914);
          return 0;
        case 4: 
          localdsw.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115914);
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
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsw.Gbf = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsw.Gbg = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 7: 
          localdsw.Ecf = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(115914);
          return 0;
        case 8: 
          localdsw.Ecg = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(115914);
          return 0;
        case 9: 
          localdsw.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115914);
          return 0;
        case 10: 
          localdsw.Gbh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115914);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsw.EPF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      AppMethodBeat.o(115914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsw
 * JD-Core Version:    0.7.0.1
 */