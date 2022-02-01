package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqj
  extends cpx
{
  public String EJp;
  public LinkedList<String> EJq;
  public String tju;
  
  public aqj()
  {
    AppMethodBeat.i(42633);
    this.EJq = new LinkedList();
    AppMethodBeat.o(42633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EJp != null) {
        paramVarArgs.d(2, this.EJp);
      }
      paramVarArgs.e(3, 1, this.EJq);
      if (this.tju != null) {
        paramVarArgs.d(4, this.tju);
      }
      AppMethodBeat.o(42634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EJp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EJp);
      }
      i += f.a.a.a.c(3, 1, this.EJq);
      paramInt = i;
      if (this.tju != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tju);
      }
      AppMethodBeat.o(42634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(42634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqj localaqj = (aqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42634);
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
            localaqj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42634);
          return 0;
        case 2: 
          localaqj.EJp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42634);
          return 0;
        case 3: 
          localaqj.EJq.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(42634);
          return 0;
        }
        localaqj.tju = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(42634);
        return 0;
      }
      AppMethodBeat.o(42634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqj
 * JD-Core Version:    0.7.0.1
 */