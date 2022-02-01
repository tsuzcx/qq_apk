package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cpr
  extends cvc
{
  public iy FWK;
  public int FXO;
  public int FXP;
  public int HiD;
  public b HiE;
  public b HiF;
  public b HiG;
  public int HiH;
  public cps HiI;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FWK != null)
      {
        paramVarArgs.lC(2, this.FWK.computeSize());
        this.FWK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HiD);
      if (this.HiE != null) {
        paramVarArgs.c(4, this.HiE);
      }
      if (this.HiF != null) {
        paramVarArgs.c(5, this.HiF);
      }
      if (this.HiG != null) {
        paramVarArgs.c(6, this.HiG);
      }
      paramVarArgs.aS(7, this.FXP);
      paramVarArgs.aS(8, this.FXO);
      paramVarArgs.aS(9, this.HiH);
      paramVarArgs.aY(10, this.timestamp);
      if (this.HiI != null)
      {
        paramVarArgs.lC(11, this.HiI.computeSize());
        this.HiI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FWK != null) {
        i = paramInt + f.a.a.a.lB(2, this.FWK.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.HiD);
      paramInt = i;
      if (this.HiE != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HiE);
      }
      i = paramInt;
      if (this.HiF != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.HiF);
      }
      paramInt = i;
      if (this.HiG != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.HiG);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FXP) + f.a.a.b.b.a.bz(8, this.FXO) + f.a.a.b.b.a.bz(9, this.HiH) + f.a.a.b.b.a.p(10, this.timestamp);
      paramInt = i;
      if (this.HiI != null) {
        paramInt = i + f.a.a.a.lB(11, this.HiI.computeSize());
      }
      AppMethodBeat.o(91653);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpr localcpr = (cpr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91653);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpr.FWK = ((iy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 3: 
          localcpr.HiD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91653);
          return 0;
        case 4: 
          localcpr.HiE = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91653);
          return 0;
        case 5: 
          localcpr.HiF = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91653);
          return 0;
        case 6: 
          localcpr.HiG = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91653);
          return 0;
        case 7: 
          localcpr.FXP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91653);
          return 0;
        case 8: 
          localcpr.FXO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91653);
          return 0;
        case 9: 
          localcpr.HiH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91653);
          return 0;
        case 10: 
          localcpr.timestamp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91653);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cps();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cps)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcpr.HiI = ((cps)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      AppMethodBeat.o(91653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpr
 * JD-Core Version:    0.7.0.1
 */