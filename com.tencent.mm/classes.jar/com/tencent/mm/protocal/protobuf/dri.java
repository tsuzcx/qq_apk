package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dri
  extends cpx
{
  public int EqS;
  public String FYS;
  public com.tencent.mm.bw.b FYT;
  public com.tencent.mm.bw.b FYU;
  public String FYV;
  public long FvQ;
  public int FvR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125498);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FYS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ToBizUserName");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.FYU == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FvR);
      if (this.FYS != null) {
        paramVarArgs.d(3, this.FYS);
      }
      paramVarArgs.aR(4, this.EqS);
      if (this.FYT != null) {
        paramVarArgs.c(5, this.FYT);
      }
      if (this.FYU != null) {
        paramVarArgs.c(6, this.FYU);
      }
      paramVarArgs.aO(7, this.FvQ);
      if (this.FYV != null) {
        paramVarArgs.d(8, this.FYV);
      }
      AppMethodBeat.o(125498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FvR);
      paramInt = i;
      if (this.FYS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FYS);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.EqS);
      paramInt = i;
      if (this.FYT != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.FYT);
      }
      i = paramInt;
      if (this.FYU != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.FYU);
      }
      i += f.a.a.b.b.a.p(7, this.FvQ);
      paramInt = i;
      if (this.FYV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FYV);
      }
      AppMethodBeat.o(125498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FYS == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ToBizUserName");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        if (this.FYU == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dri localdri = (dri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125498);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdri.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125498);
          return 0;
        case 2: 
          localdri.FvR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125498);
          return 0;
        case 3: 
          localdri.FYS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125498);
          return 0;
        case 4: 
          localdri.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125498);
          return 0;
        case 5: 
          localdri.FYT = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(125498);
          return 0;
        case 6: 
          localdri.FYU = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(125498);
          return 0;
        case 7: 
          localdri.FvQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125498);
          return 0;
        }
        localdri.FYV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125498);
        return 0;
      }
      AppMethodBeat.o(125498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dri
 * JD-Core Version:    0.7.0.1
 */