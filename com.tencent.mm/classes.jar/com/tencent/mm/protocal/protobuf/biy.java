package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class biy
  extends cvc
{
  public int GDB;
  public int uft;
  public String uhu;
  public LinkedList<cwt> uie;
  public int uiv;
  public int uiw;
  
  public biy()
  {
    AppMethodBeat.i(152596);
    this.uie = new LinkedList();
    AppMethodBeat.o(152596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.uft);
      paramVarArgs.aS(3, this.uiv);
      paramVarArgs.aS(4, this.uiw);
      if (this.uhu != null) {
        paramVarArgs.d(5, this.uhu);
      }
      paramVarArgs.aS(6, this.GDB);
      paramVarArgs.e(7, 8, this.uie);
      AppMethodBeat.o(152597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.uft) + f.a.a.b.b.a.bz(3, this.uiv) + f.a.a.b.b.a.bz(4, this.uiw);
      paramInt = i;
      if (this.uhu != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uhu);
      }
      i = f.a.a.b.b.a.bz(6, this.GDB);
      int j = f.a.a.a.c(7, 8, this.uie);
      AppMethodBeat.o(152597);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uie.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        biy localbiy = (biy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152597);
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
            localbiy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152597);
          return 0;
        case 2: 
          localbiy.uft = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152597);
          return 0;
        case 3: 
          localbiy.uiv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152597);
          return 0;
        case 4: 
          localbiy.uiw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152597);
          return 0;
        case 5: 
          localbiy.uhu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152597);
          return 0;
        case 6: 
          localbiy.GDB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152597);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbiy.uie.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      AppMethodBeat.o(152597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biy
 * JD-Core Version:    0.7.0.1
 */