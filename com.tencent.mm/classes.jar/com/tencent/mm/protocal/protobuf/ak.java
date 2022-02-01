package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ak
  extends cpx
{
  public String DMk;
  public String DMl;
  public int DMm;
  public int DMn;
  public dcq DMo;
  public String dvO;
  public String dvP;
  public int dvQ;
  public String nVI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvO == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(113922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nVI != null) {
        paramVarArgs.d(2, this.nVI);
      }
      paramVarArgs.aR(3, this.dvQ);
      if (this.dvO != null) {
        paramVarArgs.d(4, this.dvO);
      }
      if (this.dvP != null) {
        paramVarArgs.d(5, this.dvP);
      }
      if (this.DMk != null) {
        paramVarArgs.d(6, this.DMk);
      }
      if (this.DMl != null) {
        paramVarArgs.d(7, this.DMl);
      }
      paramVarArgs.aR(8, this.DMm);
      paramVarArgs.aR(9, this.DMn);
      if (this.DMo != null)
      {
        paramVarArgs.ln(10, this.DMo.computeSize());
        this.DMo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nVI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nVI);
      }
      i += f.a.a.b.b.a.bx(3, this.dvQ);
      paramInt = i;
      if (this.dvO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dvO);
      }
      i = paramInt;
      if (this.dvP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dvP);
      }
      paramInt = i;
      if (this.DMk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DMk);
      }
      i = paramInt;
      if (this.DMl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DMl);
      }
      i = i + f.a.a.b.b.a.bx(8, this.DMm) + f.a.a.b.b.a.bx(9, this.DMn);
      paramInt = i;
      if (this.DMo != null) {
        paramInt = i + f.a.a.a.lm(10, this.DMo.computeSize());
      }
      AppMethodBeat.o(113922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.dvO == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(113922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113922);
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
            localak.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113922);
          return 0;
        case 2: 
          localak.nVI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 3: 
          localak.dvQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113922);
          return 0;
        case 4: 
          localak.dvO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 5: 
          localak.dvP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 6: 
          localak.DMk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 7: 
          localak.DMl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 8: 
          localak.DMm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113922);
          return 0;
        case 9: 
          localak.DMn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113922);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localak.DMo = ((dcq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      AppMethodBeat.o(113922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */