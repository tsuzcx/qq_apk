package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coi
  extends cpx
{
  public int DZA;
  public LinkedList<nb> FBr;
  public int FBs;
  public int FBt;
  
  public coi()
  {
    AppMethodBeat.i(6424);
    this.FBr = new LinkedList();
    AppMethodBeat.o(6424);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FBr);
      paramVarArgs.aR(3, this.FBs);
      paramVarArgs.aR(4, this.FBt);
      paramVarArgs.aR(5, this.DZA);
      AppMethodBeat.o(6425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label601;
      }
    }
    label601:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.FBr);
      int j = f.a.a.b.b.a.bx(3, this.FBs);
      int k = f.a.a.b.b.a.bx(4, this.FBt);
      int m = f.a.a.b.b.a.bx(5, this.DZA);
      AppMethodBeat.o(6425);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FBr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coi localcoi = (coi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6425);
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
            localcoi.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoi.FBr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 3: 
          localcoi.FBs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6425);
          return 0;
        case 4: 
          localcoi.FBt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6425);
          return 0;
        }
        localcoi.DZA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(6425);
        return 0;
      }
      AppMethodBeat.o(6425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coi
 * JD-Core Version:    0.7.0.1
 */