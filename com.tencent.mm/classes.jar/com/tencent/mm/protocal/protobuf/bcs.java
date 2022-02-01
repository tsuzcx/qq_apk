package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcs
  extends cvc
{
  public String GxL;
  public int Gzk;
  public String yXS;
  public int zyN;
  public long zyP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.zyP);
      paramVarArgs.aS(3, this.Gzk);
      if (this.GxL != null) {
        paramVarArgs.d(4, this.GxL);
      }
      if (this.yXS != null) {
        paramVarArgs.d(5, this.yXS);
      }
      paramVarArgs.aS(6, this.zyN);
      AppMethodBeat.o(125732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.zyP) + f.a.a.b.b.a.bz(3, this.Gzk);
      paramInt = i;
      if (this.GxL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GxL);
      }
      i = paramInt;
      if (this.yXS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.yXS);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.zyN);
      AppMethodBeat.o(125732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcs localbcs = (bcs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125732);
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
            localbcs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125732);
          return 0;
        case 2: 
          localbcs.zyP = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125732);
          return 0;
        case 3: 
          localbcs.Gzk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125732);
          return 0;
        case 4: 
          localbcs.GxL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125732);
          return 0;
        case 5: 
          localbcs.yXS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125732);
          return 0;
        }
        localbcs.zyN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125732);
        return 0;
      }
      AppMethodBeat.o(125732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcs
 * JD-Core Version:    0.7.0.1
 */