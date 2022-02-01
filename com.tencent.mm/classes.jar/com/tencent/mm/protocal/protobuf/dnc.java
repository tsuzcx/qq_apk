package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnc
  extends cpx
{
  public int DUY;
  public String DYn;
  public int FUJ;
  public int FUK;
  public LinkedList<brp> FUL;
  public LinkedList<buq> FeQ;
  public String ncR;
  
  public dnc()
  {
    AppMethodBeat.i(155474);
    this.FeQ = new LinkedList();
    this.FUL = new LinkedList();
    AppMethodBeat.o(155474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      paramVarArgs.aR(3, this.DUY);
      if (this.DYn != null) {
        paramVarArgs.d(4, this.DYn);
      }
      paramVarArgs.aR(5, this.FUJ);
      paramVarArgs.e(6, 8, this.FeQ);
      paramVarArgs.aR(7, this.FUK);
      paramVarArgs.e(8, 8, this.FUL);
      AppMethodBeat.o(155475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ncR);
      }
      i += f.a.a.b.b.a.bx(3, this.DUY);
      paramInt = i;
      if (this.DYn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DYn);
      }
      i = f.a.a.b.b.a.bx(5, this.FUJ);
      int j = f.a.a.a.c(6, 8, this.FeQ);
      int k = f.a.a.b.b.a.bx(7, this.FUK);
      int m = f.a.a.a.c(8, 8, this.FUL);
      AppMethodBeat.o(155475);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FeQ.clear();
        this.FUL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnc localdnc = (dnc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155475);
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
            localdnc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 2: 
          localdnc.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 3: 
          localdnc.DUY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155475);
          return 0;
        case 4: 
          localdnc.DYn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 5: 
          localdnc.FUJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155475);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnc.FeQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 7: 
          localdnc.FUK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155475);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new brp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((brp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdnc.FUL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      AppMethodBeat.o(155475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnc
 * JD-Core Version:    0.7.0.1
 */