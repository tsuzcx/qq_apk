package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aej
  extends cqk
{
  public LinkedList<dgr> DPz;
  public int DVc;
  public LinkedList<dgq> DVd;
  public int Exf;
  public long Exg;
  public int Exh;
  public int Exi;
  public int Exj;
  
  public aej()
  {
    AppMethodBeat.i(32191);
    this.DPz = new LinkedList();
    this.DVd = new LinkedList();
    AppMethodBeat.o(32191);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32192);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32192);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.Exh);
      paramVarArgs.aR(5, this.Exi);
      paramVarArgs.e(6, 8, this.DPz);
      paramVarArgs.aR(7, this.Exj);
      paramVarArgs.aR(8, this.DVc);
      paramVarArgs.e(9, 8, this.DVd);
      AppMethodBeat.o(32192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Exf);
      int j = f.a.a.b.b.a.p(3, this.Exg);
      int k = f.a.a.b.b.a.bx(4, this.Exh);
      int m = f.a.a.b.b.a.bx(5, this.Exi);
      int n = f.a.a.a.c(6, 8, this.DPz);
      int i1 = f.a.a.b.b.a.bx(7, this.Exj);
      int i2 = f.a.a.b.b.a.bx(8, this.DVc);
      int i3 = f.a.a.a.c(9, 8, this.DVd);
      AppMethodBeat.o(32192);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DPz.clear();
        this.DVd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aej localaej = (aej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32192);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaej.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 2: 
          localaej.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32192);
          return 0;
        case 3: 
          localaej.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32192);
          return 0;
        case 4: 
          localaej.Exh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32192);
          return 0;
        case 5: 
          localaej.Exi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32192);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaej.DPz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 7: 
          localaej.Exj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32192);
          return 0;
        case 8: 
          localaej.DVc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32192);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaej.DVd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      AppMethodBeat.o(32192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aej
 * JD-Core Version:    0.7.0.1
 */