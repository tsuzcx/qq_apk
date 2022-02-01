package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bse
  extends cvc
{
  public String GMV;
  public LinkedList<String> GMY;
  public LinkedList<Integer> GMZ;
  
  public bse()
  {
    AppMethodBeat.i(124524);
    this.GMY = new LinkedList();
    this.GMZ = new LinkedList();
    AppMethodBeat.o(124524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GMV != null) {
        paramVarArgs.d(2, this.GMV);
      }
      paramVarArgs.e(3, 1, this.GMY);
      paramVarArgs.e(4, 2, this.GMZ);
      AppMethodBeat.o(124525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label493;
      }
    }
    label493:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GMV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GMV);
      }
      paramInt = f.a.a.a.c(3, 1, this.GMY);
      int j = f.a.a.a.c(4, 2, this.GMZ);
      AppMethodBeat.o(124525);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GMY.clear();
        this.GMZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bse localbse = (bse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124525);
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
            localbse.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124525);
          return 0;
        case 2: 
          localbse.GMV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124525);
          return 0;
        case 3: 
          localbse.GMY.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(124525);
          return 0;
        }
        localbse.GMZ.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
        AppMethodBeat.o(124525);
        return 0;
      }
      AppMethodBeat.o(124525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bse
 * JD-Core Version:    0.7.0.1
 */