package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aat
  extends cpx
{
  public String DPx;
  public LinkedList<abd> DPz;
  public int Scene;
  public int fsB;
  
  public aat()
  {
    AppMethodBeat.i(101801);
    this.DPz = new LinkedList();
    AppMethodBeat.o(101801);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.fsB);
      paramVarArgs.e(3, 8, this.DPz);
      if (this.DPx != null) {
        paramVarArgs.d(4, this.DPx);
      }
      paramVarArgs.aR(5, this.Scene);
      AppMethodBeat.o(101802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.fsB) + f.a.a.a.c(3, 8, this.DPz);
      paramInt = i;
      if (this.DPx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DPx);
      }
      i = f.a.a.b.b.a.bx(5, this.Scene);
      AppMethodBeat.o(101802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DPz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(101802);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aat localaat = (aat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101802);
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
            localaat.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 2: 
          localaat.fsB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101802);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaat.DPz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 4: 
          localaat.DPx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101802);
          return 0;
        }
        localaat.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(101802);
        return 0;
      }
      AppMethodBeat.o(101802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aat
 * JD-Core Version:    0.7.0.1
 */