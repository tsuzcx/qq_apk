package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdq
  extends cpx
{
  public bb EhT;
  public int Fsq;
  public String vxU;
  public int vyb;
  public String vym;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Fsq);
      if (this.vxU != null) {
        paramVarArgs.d(3, this.vxU);
      }
      paramVarArgs.aR(4, this.vyb);
      if (this.vym != null) {
        paramVarArgs.d(5, this.vym);
      }
      if (this.EhT != null)
      {
        paramVarArgs.ln(6, this.EhT.computeSize());
        this.EhT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fsq);
      paramInt = i;
      if (this.vxU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vxU);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.vyb);
      paramInt = i;
      if (this.vym != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vym);
      }
      i = paramInt;
      if (this.EhT != null) {
        i = paramInt + f.a.a.a.lm(6, this.EhT.computeSize());
      }
      AppMethodBeat.o(91575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdq localcdq = (cdq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91575);
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
            localcdq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91575);
          return 0;
        case 2: 
          localcdq.Fsq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91575);
          return 0;
        case 3: 
          localcdq.vxU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91575);
          return 0;
        case 4: 
          localcdq.vyb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91575);
          return 0;
        case 5: 
          localcdq.vym = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91575);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdq.EhT = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      AppMethodBeat.o(91575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdq
 * JD-Core Version:    0.7.0.1
 */