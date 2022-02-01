package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class anu
  extends cvc
{
  public alk Glv;
  public b GmG;
  public String Gmz;
  public int duh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168982);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gmz != null) {
        paramVarArgs.d(2, this.Gmz);
      }
      if (this.GmG != null) {
        paramVarArgs.c(3, this.GmG);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(4, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.duh);
      AppMethodBeat.o(168982);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gmz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gmz);
      }
      i = paramInt;
      if (this.GmG != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GmG);
      }
      paramInt = i;
      if (this.Glv != null) {
        paramInt = i + f.a.a.a.lB(4, this.Glv.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.duh);
      AppMethodBeat.o(168982);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168982);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anu localanu = (anu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168982);
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
            localanu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168982);
          return 0;
        case 2: 
          localanu.Gmz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168982);
          return 0;
        case 3: 
          localanu.GmG = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(168982);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanu.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168982);
          return 0;
        }
        localanu.duh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168982);
        return 0;
      }
      AppMethodBeat.o(168982);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anu
 * JD-Core Version:    0.7.0.1
 */