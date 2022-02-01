package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class clh
  extends cvc
{
  public int FIy;
  public long Fsa;
  public String Fsb;
  public String Fsc;
  public b GzS;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211979);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GzS != null) {
        paramVarArgs.c(2, this.GzS);
      }
      paramVarArgs.aS(3, this.FIy);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aY(5, this.Fsa);
      if (this.Fsb != null) {
        paramVarArgs.d(6, this.Fsb);
      }
      if (this.Fsc != null) {
        paramVarArgs.d(7, this.Fsc);
      }
      AppMethodBeat.o(211979);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GzS != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.GzS);
      }
      i += f.a.a.b.b.a.bz(3, this.FIy);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.Fsa);
      paramInt = i;
      if (this.Fsb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fsb);
      }
      i = paramInt;
      if (this.Fsc != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Fsc);
      }
      AppMethodBeat.o(211979);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211979);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clh localclh = (clh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211979);
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
            localclh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211979);
          return 0;
        case 2: 
          localclh.GzS = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(211979);
          return 0;
        case 3: 
          localclh.FIy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(211979);
          return 0;
        case 4: 
          localclh.content = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211979);
          return 0;
        case 5: 
          localclh.Fsa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(211979);
          return 0;
        case 6: 
          localclh.Fsb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211979);
          return 0;
        }
        localclh.Fsc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(211979);
        return 0;
      }
      AppMethodBeat.o(211979);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clh
 * JD-Core Version:    0.7.0.1
 */