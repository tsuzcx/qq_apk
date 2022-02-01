package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cic
  extends cpx
{
  public int Exf;
  public long FvT;
  public crm Fwj;
  public crm Fwk;
  public crm Fwl;
  public int Fwm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fwj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.Fwk == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChannelReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.Fwl == null)
      {
        paramVarArgs = new b("Not all required fields were included: EngineReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fwj != null)
      {
        paramVarArgs.ln(2, this.Fwj.computeSize());
        this.Fwj.writeFields(paramVarArgs);
      }
      if (this.Fwk != null)
      {
        paramVarArgs.ln(3, this.Fwk.computeSize());
        this.Fwk.writeFields(paramVarArgs);
      }
      if (this.Fwl != null)
      {
        paramVarArgs.ln(4, this.Fwl.computeSize());
        this.Fwl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Exf);
      paramVarArgs.aO(6, this.FvT);
      paramVarArgs.aR(7, this.Fwm);
      AppMethodBeat.o(32386);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1075;
      }
    }
    label1075:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fwj != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fwj.computeSize());
      }
      i = paramInt;
      if (this.Fwk != null) {
        i = paramInt + f.a.a.a.lm(3, this.Fwk.computeSize());
      }
      paramInt = i;
      if (this.Fwl != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fwl.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.Exf);
      int j = f.a.a.b.b.a.p(6, this.FvT);
      int k = f.a.a.b.b.a.bx(7, this.Fwm);
      AppMethodBeat.o(32386);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fwj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.Fwk == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChannelReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.Fwl == null)
        {
          paramVarArgs = new b("Not all required fields were included: EngineReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32386);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cic localcic = (cic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32386);
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
            localcic.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcic.Fwj = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
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
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcic.Fwk = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
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
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcic.Fwl = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 5: 
          localcic.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32386);
          return 0;
        case 6: 
          localcic.FvT = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32386);
          return 0;
        }
        localcic.Fwm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32386);
        return 0;
      }
      AppMethodBeat.o(32386);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cic
 * JD-Core Version:    0.7.0.1
 */