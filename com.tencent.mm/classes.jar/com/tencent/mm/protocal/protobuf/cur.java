package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cur
  extends cvc
{
  public int GOl;
  public long HfW;
  public long HmK;
  public String HmL;
  public int HmM;
  public int HmN;
  public int HmO;
  public long HmP;
  public int Scene;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HmK);
      if (this.HmL != null) {
        paramVarArgs.d(3, this.HmL);
      }
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aS(5, this.HmM);
      paramVarArgs.aS(6, this.GOl);
      paramVarArgs.aS(7, this.HmN);
      paramVarArgs.aY(8, this.HfW);
      paramVarArgs.aS(9, this.HmO);
      if (this.iht != null) {
        paramVarArgs.d(10, this.iht);
      }
      paramVarArgs.aY(11, this.HmP);
      AppMethodBeat.o(117902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HmK);
      paramInt = i;
      if (this.HmL != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HmL);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Scene) + f.a.a.b.b.a.bz(5, this.HmM) + f.a.a.b.b.a.bz(6, this.GOl) + f.a.a.b.b.a.bz(7, this.HmN) + f.a.a.b.b.a.p(8, this.HfW) + f.a.a.b.b.a.bz(9, this.HmO);
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.iht);
      }
      i = f.a.a.b.b.a.p(11, this.HmP);
      AppMethodBeat.o(117902);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cur localcur = (cur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117902);
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
            localcur.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117902);
          return 0;
        case 2: 
          localcur.HmK = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(117902);
          return 0;
        case 3: 
          localcur.HmL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117902);
          return 0;
        case 4: 
          localcur.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 5: 
          localcur.HmM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 6: 
          localcur.GOl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 7: 
          localcur.HmN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 8: 
          localcur.HfW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(117902);
          return 0;
        case 9: 
          localcur.HmO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117902);
          return 0;
        case 10: 
          localcur.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117902);
          return 0;
        }
        localcur.HmP = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117902);
        return 0;
      }
      AppMethodBeat.o(117902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cur
 * JD-Core Version:    0.7.0.1
 */