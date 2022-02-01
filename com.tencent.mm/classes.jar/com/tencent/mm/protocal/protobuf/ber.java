package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ber
  extends cqk
{
  public int EUf;
  public LinkedList<cll> EUg;
  public int EUh;
  public int EUi;
  public int EUj;
  public bhx EUk;
  public LinkedList<bhy> tkD;
  public LinkedList<bl> tkW;
  
  public ber()
  {
    AppMethodBeat.i(152598);
    this.EUg = new LinkedList();
    this.tkW = new LinkedList();
    this.tkD = new LinkedList();
    AppMethodBeat.o(152598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152599);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152599);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EUf);
      paramVarArgs.e(3, 8, this.EUg);
      paramVarArgs.aR(4, this.EUh);
      paramVarArgs.aR(5, this.EUi);
      paramVarArgs.e(6, 8, this.tkW);
      paramVarArgs.aR(7, this.EUj);
      paramVarArgs.e(8, 8, this.tkD);
      if (this.EUk != null)
      {
        paramVarArgs.ln(9, this.EUk.computeSize());
        this.EUk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1102;
      }
    }
    label1102:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EUf) + f.a.a.a.c(3, 8, this.EUg) + f.a.a.b.b.a.bx(4, this.EUh) + f.a.a.b.b.a.bx(5, this.EUi) + f.a.a.a.c(6, 8, this.tkW) + f.a.a.b.b.a.bx(7, this.EUj) + f.a.a.a.c(8, 8, this.tkD);
      paramInt = i;
      if (this.EUk != null) {
        paramInt = i + f.a.a.a.lm(9, this.EUk.computeSize());
      }
      AppMethodBeat.o(152599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EUg.clear();
        this.tkW.clear();
        this.tkD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152599);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ber localber = (ber)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152599);
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
            localber.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 2: 
          localber.EUf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152599);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cll();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cll)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localber.EUg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 4: 
          localber.EUh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152599);
          return 0;
        case 5: 
          localber.EUi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152599);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localber.tkW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 7: 
          localber.EUj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152599);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localber.tkD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bhx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bhx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localber.EUk = ((bhx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      AppMethodBeat.o(152599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ber
 * JD-Core Version:    0.7.0.1
 */