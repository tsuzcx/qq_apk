package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ded
  extends cvc
{
  public LinkedList<Integer> HqA;
  public int Hsu;
  public String duW;
  
  public ded()
  {
    AppMethodBeat.i(123650);
    this.HqA = new LinkedList();
    AppMethodBeat.o(123650);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123651);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      paramVarArgs.e(3, 2, this.HqA);
      paramVarArgs.aS(4, this.Hsu);
      AppMethodBeat.o(123651);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      paramInt = f.a.a.a.c(3, 2, this.HqA);
      int j = f.a.a.b.b.a.bz(4, this.Hsu);
      AppMethodBeat.o(123651);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HqA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123651);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ded localded = (ded)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123651);
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
            localded.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123651);
          return 0;
        case 2: 
          localded.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123651);
          return 0;
        case 3: 
          localded.HqA.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(123651);
          return 0;
        }
        localded.Hsu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123651);
        return 0;
      }
      AppMethodBeat.o(123651);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ded
 * JD-Core Version:    0.7.0.1
 */