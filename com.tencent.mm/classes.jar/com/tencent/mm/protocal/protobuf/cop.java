package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cop
  extends cvc
{
  public int Cyj;
  public String Cyu;
  public String Hfb;
  public int HgC;
  public String Hhu;
  public int uxm;
  public String xZh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91641);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hhu != null) {
        paramVarArgs.d(2, this.Hhu);
      }
      if (this.xZh != null) {
        paramVarArgs.d(3, this.xZh);
      }
      paramVarArgs.aS(4, this.HgC);
      paramVarArgs.aS(5, this.uxm);
      if (this.Hfb != null) {
        paramVarArgs.d(6, this.Hfb);
      }
      paramVarArgs.aS(7, this.Cyj);
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hhu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hhu);
      }
      i = paramInt;
      if (this.xZh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xZh);
      }
      i = i + f.a.a.b.b.a.bz(4, this.HgC) + f.a.a.b.b.a.bz(5, this.uxm);
      paramInt = i;
      if (this.Hfb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hfb);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Cyj);
      paramInt = i;
      if (this.Cyu != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91641);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91641);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cop localcop = (cop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91641);
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
            localcop.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91641);
          return 0;
        case 2: 
          localcop.Hhu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 3: 
          localcop.xZh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 4: 
          localcop.HgC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91641);
          return 0;
        case 5: 
          localcop.uxm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91641);
          return 0;
        case 6: 
          localcop.Hfb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 7: 
          localcop.Cyj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91641);
          return 0;
        }
        localcop.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91641);
        return 0;
      }
      AppMethodBeat.o(91641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cop
 * JD-Core Version:    0.7.0.1
 */