package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnt
  extends cpx
{
  public String Fds;
  public LinkedList<String> Fdv;
  public LinkedList<Integer> Fdw;
  
  public bnt()
  {
    AppMethodBeat.i(124524);
    this.Fdv = new LinkedList();
    this.Fdw = new LinkedList();
    AppMethodBeat.o(124524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fds != null) {
        paramVarArgs.d(2, this.Fds);
      }
      paramVarArgs.e(3, 1, this.Fdv);
      paramVarArgs.e(4, 2, this.Fdw);
      AppMethodBeat.o(124525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label493;
      }
    }
    label493:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fds != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fds);
      }
      paramInt = f.a.a.a.c(3, 1, this.Fdv);
      int j = f.a.a.a.c(4, 2, this.Fdw);
      AppMethodBeat.o(124525);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fdv.clear();
        this.Fdw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnt localbnt = (bnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124525);
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
            localbnt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124525);
          return 0;
        case 2: 
          localbnt.Fds = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124525);
          return 0;
        case 3: 
          localbnt.Fdv.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(124525);
          return 0;
        }
        localbnt.Fdw.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
        AppMethodBeat.o(124525);
        return 0;
      }
      AppMethodBeat.o(124525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnt
 * JD-Core Version:    0.7.0.1
 */