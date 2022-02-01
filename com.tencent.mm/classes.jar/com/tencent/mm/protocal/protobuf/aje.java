package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aje
  extends cvc
{
  public long Ggm;
  public String Ggn;
  public String Ggu;
  public int dnh;
  public String duW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104365);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Ggm);
      if (this.Ggu != null) {
        paramVarArgs.d(3, this.Ggu);
      }
      if (this.duW != null) {
        paramVarArgs.d(4, this.duW);
      }
      if (this.Ggn != null) {
        paramVarArgs.d(5, this.Ggn);
      }
      paramVarArgs.aS(6, this.dnh);
      AppMethodBeat.o(104365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Ggm);
      paramInt = i;
      if (this.Ggu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ggu);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.duW);
      }
      paramInt = i;
      if (this.Ggn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ggn);
      }
      i = f.a.a.b.b.a.bz(6, this.dnh);
      AppMethodBeat.o(104365);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aje localaje = (aje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104365);
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
            localaje.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104365);
          return 0;
        case 2: 
          localaje.Ggm = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(104365);
          return 0;
        case 3: 
          localaje.Ggu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 4: 
          localaje.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 5: 
          localaje.Ggn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104365);
          return 0;
        }
        localaje.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104365);
        return 0;
      }
      AppMethodBeat.o(104365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aje
 * JD-Core Version:    0.7.0.1
 */