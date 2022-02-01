package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbb
  extends cvc
{
  public String CwR;
  public int CwW;
  public String Fvy;
  public long dOa;
  public String dkR;
  public int fKG;
  public String wCE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.CwW);
      if (this.dkR != null) {
        paramVarArgs.d(3, this.dkR);
      }
      if (this.wCE != null) {
        paramVarArgs.d(4, this.wCE);
      }
      if (this.CwR != null) {
        paramVarArgs.d(5, this.CwR);
      }
      paramVarArgs.aY(6, this.dOa);
      paramVarArgs.aS(7, this.fKG);
      if (this.Fvy != null) {
        paramVarArgs.d(8, this.Fvy);
      }
      AppMethodBeat.o(91545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.CwW);
      paramInt = i;
      if (this.dkR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dkR);
      }
      i = paramInt;
      if (this.wCE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.wCE);
      }
      paramInt = i;
      if (this.CwR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CwR);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.dOa) + f.a.a.b.b.a.bz(7, this.fKG);
      paramInt = i;
      if (this.Fvy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fvy);
      }
      AppMethodBeat.o(91545);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbb localcbb = (cbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91545);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91545);
          return 0;
        case 2: 
          localcbb.CwW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91545);
          return 0;
        case 3: 
          localcbb.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 4: 
          localcbb.wCE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 5: 
          localcbb.CwR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 6: 
          localcbb.dOa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91545);
          return 0;
        case 7: 
          localcbb.fKG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91545);
          return 0;
        }
        localcbb.Fvy = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91545);
        return 0;
      }
      AppMethodBeat.o(91545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbb
 * JD-Core Version:    0.7.0.1
 */