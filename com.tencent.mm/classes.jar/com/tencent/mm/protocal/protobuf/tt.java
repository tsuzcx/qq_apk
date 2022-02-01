package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tt
  extends cpx
{
  public String Enm;
  public String djr;
  public String wLA;
  public String wLB;
  public String wLu;
  public long wNG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djr == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.wLB == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.wLA == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.wLu == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djr != null) {
        paramVarArgs.d(2, this.djr);
      }
      if (this.wLB != null) {
        paramVarArgs.d(3, this.wLB);
      }
      if (this.wLA != null) {
        paramVarArgs.d(4, this.wLA);
      }
      if (this.wLu != null) {
        paramVarArgs.d(5, this.wLu);
      }
      paramVarArgs.aO(6, this.wNG);
      if (this.Enm != null) {
        paramVarArgs.d(7, this.Enm);
      }
      AppMethodBeat.o(72450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label850;
      }
    }
    label850:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djr);
      }
      i = paramInt;
      if (this.wLB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wLB);
      }
      paramInt = i;
      if (this.wLA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wLA);
      }
      i = paramInt;
      if (this.wLu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.wLu);
      }
      i += f.a.a.b.b.a.p(6, this.wNG);
      paramInt = i;
      if (this.Enm != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Enm);
      }
      AppMethodBeat.o(72450);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.djr == null)
        {
          paramVarArgs = new b("Not all required fields were included: req_key");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.wLB == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.wLA == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.wLu == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_openid");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72450);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tt localtt = (tt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72450);
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
            localtt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72450);
          return 0;
        case 2: 
          localtt.djr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 3: 
          localtt.wLB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 4: 
          localtt.wLA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 5: 
          localtt.wLu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 6: 
          localtt.wNG = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72450);
          return 0;
        }
        localtt.Enm = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72450);
        return 0;
      }
      AppMethodBeat.o(72450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tt
 * JD-Core Version:    0.7.0.1
 */