package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pb
  extends cpx
{
  public dj EeP;
  public long EfA;
  public String Efg;
  public int Efy;
  public int Efz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91376);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EeP != null)
      {
        paramVarArgs.ln(2, this.EeP.computeSize());
        this.EeP.writeFields(paramVarArgs);
      }
      if (this.Efg != null) {
        paramVarArgs.d(3, this.Efg);
      }
      paramVarArgs.aR(4, this.Efy);
      paramVarArgs.aR(5, this.Efz);
      paramVarArgs.aO(6, this.EfA);
      AppMethodBeat.o(91376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EeP != null) {
        paramInt = i + f.a.a.a.lm(2, this.EeP.computeSize());
      }
      i = paramInt;
      if (this.Efg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Efg);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.Efy);
      int j = f.a.a.b.b.a.bx(5, this.Efz);
      int k = f.a.a.b.b.a.p(6, this.EfA);
      AppMethodBeat.o(91376);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pb localpb = (pb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91376);
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
            localpb.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpb.EeP = ((dj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 3: 
          localpb.Efg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91376);
          return 0;
        case 4: 
          localpb.Efy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91376);
          return 0;
        case 5: 
          localpb.Efz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91376);
          return 0;
        }
        localpb.EfA = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91376);
        return 0;
      }
      AppMethodBeat.o(91376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pb
 * JD-Core Version:    0.7.0.1
 */