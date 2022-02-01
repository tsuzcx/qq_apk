package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ate
  extends com.tencent.mm.bx.a
{
  public int CLL;
  public ckp Dth;
  public bmj Dti;
  public int Dtj;
  public boolean Dtk;
  public boolean Dtl;
  public int Dtm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dth != null)
      {
        paramVarArgs.kX(1, this.Dth.computeSize());
        this.Dth.writeFields(paramVarArgs);
      }
      if (this.Dti != null)
      {
        paramVarArgs.kX(2, this.Dti.computeSize());
        this.Dti.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Dtj);
      paramVarArgs.aR(4, this.CLL);
      paramVarArgs.bg(5, this.Dtk);
      paramVarArgs.bg(6, this.Dtl);
      paramVarArgs.aR(7, this.Dtm);
      AppMethodBeat.o(175244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dth == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.kW(1, this.Dth.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dti != null) {
        i = paramInt + f.a.a.a.kW(2, this.Dti.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Dtj);
      int j = f.a.a.b.b.a.bA(4, this.CLL);
      int k = f.a.a.b.b.a.fY(5);
      int m = f.a.a.b.b.a.fY(6);
      int n = f.a.a.b.b.a.bA(7, this.Dtm);
      AppMethodBeat.o(175244);
      return i + paramInt + j + (k + 1) + (m + 1) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(175244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ate localate = (ate)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175244);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localate.Dth = ((ckp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localate.Dti = ((bmj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 3: 
          localate.Dtj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(175244);
          return 0;
        case 4: 
          localate.CLL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(175244);
          return 0;
        case 5: 
          localate.Dtk = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(175244);
          return 0;
        case 6: 
          localate.Dtl = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(175244);
          return 0;
        }
        localate.Dtm = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(175244);
        return 0;
      }
      AppMethodBeat.o(175244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ate
 * JD-Core Version:    0.7.0.1
 */