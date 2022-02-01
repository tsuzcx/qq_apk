package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class le
  extends cvc
{
  public String Daf;
  public String FDo;
  public String FDp;
  public String FDq;
  public int dBY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FDo != null) {
        paramVarArgs.d(2, this.FDo);
      }
      if (this.FDp != null) {
        paramVarArgs.d(3, this.FDp);
      }
      if (this.Daf != null) {
        paramVarArgs.d(4, this.Daf);
      }
      if (this.FDq != null) {
        paramVarArgs.d(5, this.FDq);
      }
      paramVarArgs.aS(7, this.dBY);
      AppMethodBeat.o(72422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FDo);
      }
      i = paramInt;
      if (this.FDp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FDp);
      }
      paramInt = i;
      if (this.Daf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Daf);
      }
      i = paramInt;
      if (this.FDq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FDq);
      }
      paramInt = f.a.a.b.b.a.bz(7, this.dBY);
      AppMethodBeat.o(72422);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        le localle = (le)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(72422);
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
            localle.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72422);
          return 0;
        case 2: 
          localle.FDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 3: 
          localle.FDp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 4: 
          localle.Daf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 5: 
          localle.FDq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72422);
          return 0;
        }
        localle.dBY = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72422);
        return 0;
      }
      AppMethodBeat.o(72422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.le
 * JD-Core Version:    0.7.0.1
 */