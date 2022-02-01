package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dte
  extends cpx
{
  public int Ekh;
  public SKBuiltinBuffer_t Eki;
  public int Exf;
  public long Exg;
  public long FYl;
  public String Fwn;
  public drv Gbv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eki == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.Gbv == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpLog");
        AppMethodBeat.o(115925);
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
      if (this.Eki != null)
      {
        paramVarArgs.ln(4, this.Eki.computeSize());
        this.Eki.writeFields(paramVarArgs);
      }
      if (this.Gbv != null)
      {
        paramVarArgs.ln(5, this.Gbv.computeSize());
        this.Gbv.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.Exg);
      paramVarArgs.aR(7, this.Ekh);
      paramVarArgs.aO(8, this.FYl);
      AppMethodBeat.o(115925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fwn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fwn);
      }
      i += f.a.a.b.b.a.bx(3, this.Exf);
      paramInt = i;
      if (this.Eki != null) {
        paramInt = i + f.a.a.a.lm(4, this.Eki.computeSize());
      }
      i = paramInt;
      if (this.Gbv != null) {
        i = paramInt + f.a.a.a.lm(5, this.Gbv.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(6, this.Exg);
      int j = f.a.a.b.b.a.bx(7, this.Ekh);
      int k = f.a.a.b.b.a.p(8, this.FYl);
      AppMethodBeat.o(115925);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Eki == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        if (this.Gbv == null)
        {
          paramVarArgs = new b("Not all required fields were included: OpLog");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dte localdte = (dte)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115925);
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
            localdte.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 2: 
          localdte.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115925);
          return 0;
        case 3: 
          localdte.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115925);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdte.Eki = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdte.Gbv = ((drv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 6: 
          localdte.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115925);
          return 0;
        case 7: 
          localdte.Ekh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115925);
          return 0;
        }
        localdte.FYl = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(115925);
        return 0;
      }
      AppMethodBeat.o(115925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dte
 * JD-Core Version:    0.7.0.1
 */