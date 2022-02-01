package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpx
  extends cpx
{
  public String Ewu;
  public int FeP;
  public LinkedList<crm> FeQ;
  public int FeR;
  public LinkedList<crm> FeS;
  
  public bpx()
  {
    AppMethodBeat.i(155434);
    this.FeQ = new LinkedList();
    this.FeS = new LinkedList();
    AppMethodBeat.o(155434);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(2, this.Ewu);
      }
      paramVarArgs.aR(3, this.FeP);
      paramVarArgs.e(4, 8, this.FeQ);
      paramVarArgs.aR(5, this.FeR);
      paramVarArgs.e(6, 8, this.FeS);
      AppMethodBeat.o(155435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ewu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ewu);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FeP);
      int j = f.a.a.a.c(4, 8, this.FeQ);
      int k = f.a.a.b.b.a.bx(5, this.FeR);
      int m = f.a.a.a.c(6, 8, this.FeS);
      AppMethodBeat.o(155435);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FeQ.clear();
        this.FeS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpx localbpx = (bpx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155435);
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
            localbpx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 2: 
          localbpx.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155435);
          return 0;
        case 3: 
          localbpx.FeP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155435);
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
            localbpx.FeQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 5: 
          localbpx.FeR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155435);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpx.FeS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      AppMethodBeat.o(155435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpx
 * JD-Core Version:    0.7.0.1
 */