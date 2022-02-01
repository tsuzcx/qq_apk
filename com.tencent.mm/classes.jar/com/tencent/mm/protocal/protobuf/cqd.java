package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqd
  extends com.tencent.mm.bw.a
{
  public int DkK;
  public int EPB;
  public int EZW;
  public int Eha;
  public cqg FDn;
  public cqf FDo;
  public int FDp;
  public String FDq;
  public int FDr;
  public int FDs;
  public int FDt;
  public int FvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.FvC);
      if (this.FDn != null)
      {
        paramVarArgs.ln(2, this.FDn.computeSize());
        this.FDn.writeFields(paramVarArgs);
      }
      if (this.FDo != null)
      {
        paramVarArgs.ln(3, this.FDo.computeSize());
        this.FDo.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.EPB);
      paramVarArgs.aR(5, this.FDp);
      if (this.FDq != null) {
        paramVarArgs.d(6, this.FDq);
      }
      paramVarArgs.aR(7, this.Eha);
      paramVarArgs.aR(8, this.FDr);
      paramVarArgs.aR(9, this.DkK);
      paramVarArgs.aR(10, this.FDs);
      paramVarArgs.aR(11, this.FDt);
      paramVarArgs.aR(12, this.EZW);
      AppMethodBeat.o(152668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FvC) + 0;
      paramInt = i;
      if (this.FDn != null) {
        paramInt = i + f.a.a.a.lm(2, this.FDn.computeSize());
      }
      i = paramInt;
      if (this.FDo != null) {
        i = paramInt + f.a.a.a.lm(3, this.FDo.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(4, this.EPB) + f.a.a.b.b.a.bx(5, this.FDp);
      paramInt = i;
      if (this.FDq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FDq);
      }
      i = f.a.a.b.b.a.bx(7, this.Eha);
      int j = f.a.a.b.b.a.bx(8, this.FDr);
      int k = f.a.a.b.b.a.bx(9, this.DkK);
      int m = f.a.a.b.b.a.bx(10, this.FDs);
      int n = f.a.a.b.b.a.bx(11, this.FDt);
      int i1 = f.a.a.b.b.a.bx(12, this.EZW);
      AppMethodBeat.o(152668);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FDq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cqd localcqd = (cqd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152668);
        return -1;
      case 1: 
        localcqd.FvC = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152668);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqd.FDn = ((cqg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqd.FDo = ((cqf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 4: 
        localcqd.EPB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152668);
        return 0;
      case 5: 
        localcqd.FDp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152668);
        return 0;
      case 6: 
        localcqd.FDq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152668);
        return 0;
      case 7: 
        localcqd.Eha = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152668);
        return 0;
      case 8: 
        localcqd.FDr = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152668);
        return 0;
      case 9: 
        localcqd.DkK = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152668);
        return 0;
      case 10: 
        localcqd.FDs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152668);
        return 0;
      case 11: 
        localcqd.FDt = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152668);
        return 0;
      }
      localcqd.EZW = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(152668);
      return 0;
    }
    AppMethodBeat.o(152668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqd
 * JD-Core Version:    0.7.0.1
 */