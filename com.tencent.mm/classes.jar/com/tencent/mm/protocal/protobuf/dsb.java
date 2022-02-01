package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsb
  extends cqk
{
  public int CreateTime;
  public int Exf;
  public long Exg;
  public int FZh;
  public String FZq;
  public LinkedList<dtd> FZr;
  public int fsB;
  
  public dsb()
  {
    AppMethodBeat.i(115879);
    this.FZr = new LinkedList();
    AppMethodBeat.o(115879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115880);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115880);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(6, this.fsB);
      paramVarArgs.e(7, 8, this.FZr);
      if (this.FZq != null) {
        paramVarArgs.d(8, this.FZq);
      }
      paramVarArgs.aR(9, this.FZh);
      AppMethodBeat.o(115880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.p(3, this.Exg) + f.a.a.b.b.a.bx(4, this.CreateTime) + f.a.a.b.b.a.bx(6, this.fsB) + f.a.a.a.c(7, 8, this.FZr);
      paramInt = i;
      if (this.FZq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FZq);
      }
      i = f.a.a.b.b.a.bx(9, this.FZh);
      AppMethodBeat.o(115880);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FZr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsb localdsb = (dsb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115880);
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
            localdsb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 2: 
          localdsb.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115880);
          return 0;
        case 3: 
          localdsb.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115880);
          return 0;
        case 4: 
          localdsb.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115880);
          return 0;
        case 6: 
          localdsb.fsB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115880);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsb.FZr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 8: 
          localdsb.FZq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115880);
          return 0;
        }
        localdsb.FZh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115880);
        return 0;
      }
      AppMethodBeat.o(115880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsb
 * JD-Core Version:    0.7.0.1
 */