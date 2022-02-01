package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqy
  extends cpx
{
  public String EJX;
  public int EJY;
  public LinkedList<ara> EJZ;
  public int SetType;
  
  public aqy()
  {
    AppMethodBeat.i(191067);
    this.EJZ = new LinkedList();
    AppMethodBeat.o(191067);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74654);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.SetType);
      if (this.EJX != null) {
        paramVarArgs.d(3, this.EJX);
      }
      paramVarArgs.aR(4, this.EJY);
      paramVarArgs.e(5, 8, this.EJZ);
      AppMethodBeat.o(74654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.SetType);
      paramInt = i;
      if (this.EJX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EJX);
      }
      i = f.a.a.b.b.a.bx(4, this.EJY);
      int j = f.a.a.a.c(5, 8, this.EJZ);
      AppMethodBeat.o(74654);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(74654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqy localaqy = (aqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74654);
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
            localaqy.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74654);
          return 0;
        case 2: 
          localaqy.SetType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(74654);
          return 0;
        case 3: 
          localaqy.EJX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(74654);
          return 0;
        case 4: 
          localaqy.EJY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(74654);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ara();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ara)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaqy.EJZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(74654);
        return 0;
      }
      AppMethodBeat.o(74654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqy
 * JD-Core Version:    0.7.0.1
 */