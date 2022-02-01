package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class wh
  extends cqk
{
  public String DGU;
  public dis EqG;
  public cek Eqb;
  public int pAG;
  public String pAH;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91419);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.pAG);
      if (this.pAH != null) {
        paramVarArgs.d(3, this.pAH);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.Eqb != null)
      {
        paramVarArgs.ln(5, this.Eqb.computeSize());
        this.Eqb.writeFields(paramVarArgs);
      }
      if (this.DGU != null) {
        paramVarArgs.d(6, this.DGU);
      }
      if (this.EqG != null)
      {
        paramVarArgs.ln(7, this.EqG.computeSize());
        this.EqG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.pAG);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pAH);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.Eqb != null) {
        paramInt = i + f.a.a.a.lm(5, this.Eqb.computeSize());
      }
      i = paramInt;
      if (this.DGU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DGU);
      }
      paramInt = i;
      if (this.EqG != null) {
        paramInt = i + f.a.a.a.lm(7, this.EqG.computeSize());
      }
      AppMethodBeat.o(91419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wh localwh = (wh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91419);
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
            localwh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 2: 
          localwh.pAG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91419);
          return 0;
        case 3: 
          localwh.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 4: 
          localwh.token = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cek();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwh.Eqb = ((cek)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 6: 
          localwh.DGU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91419);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dis();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwh.EqG = ((dis)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91419);
        return 0;
      }
      AppMethodBeat.o(91419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wh
 * JD-Core Version:    0.7.0.1
 */