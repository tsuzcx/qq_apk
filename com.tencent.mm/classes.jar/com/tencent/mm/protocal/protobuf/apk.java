package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apk
  extends cpx
{
  public int EIs;
  public int EIt;
  public ir Epy;
  public String Epz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Epy != null)
      {
        paramVarArgs.ln(2, this.Epy.computeSize());
        this.Epy.writeFields(paramVarArgs);
      }
      if (this.Epz != null) {
        paramVarArgs.d(3, this.Epz);
      }
      paramVarArgs.aR(4, this.EIs);
      paramVarArgs.aR(5, this.EIt);
      AppMethodBeat.o(91468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Epy != null) {
        paramInt = i + f.a.a.a.lm(2, this.Epy.computeSize());
      }
      i = paramInt;
      if (this.Epz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Epz);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.EIs);
      int j = f.a.a.b.b.a.bx(5, this.EIt);
      AppMethodBeat.o(91468);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apk localapk = (apk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91468);
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
            localapk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapk.Epy = ((ir)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 3: 
          localapk.Epz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91468);
          return 0;
        case 4: 
          localapk.EIs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91468);
          return 0;
        }
        localapk.EIt = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91468);
        return 0;
      }
      AppMethodBeat.o(91468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apk
 * JD-Core Version:    0.7.0.1
 */