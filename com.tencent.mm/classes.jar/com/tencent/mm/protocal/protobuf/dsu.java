package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsu
  extends cpx
{
  public int Exf;
  public long Exg;
  public long FYl;
  public dta FZg;
  public String Fwn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115911);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115911);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fwn != null) {
        paramVarArgs.d(2, this.Fwn);
      }
      paramVarArgs.aR(3, this.Exf);
      paramVarArgs.aO(4, this.Exg);
      if (this.FZg != null)
      {
        paramVarArgs.ln(5, this.FZg.computeSize());
        this.FZg.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.FYl);
      AppMethodBeat.o(115911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fwn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fwn);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Exf) + f.a.a.b.b.a.p(4, this.Exg);
      paramInt = i;
      if (this.FZg != null) {
        paramInt = i + f.a.a.a.lm(5, this.FZg.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.FYl);
      AppMethodBeat.o(115911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FZg == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsu localdsu = (dsu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115911);
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
            localdsu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        case 2: 
          localdsu.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115911);
          return 0;
        case 3: 
          localdsu.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115911);
          return 0;
        case 4: 
          localdsu.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115911);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsu.FZg = ((dta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        }
        localdsu.FYl = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(115911);
        return 0;
      }
      AppMethodBeat.o(115911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsu
 * JD-Core Version:    0.7.0.1
 */