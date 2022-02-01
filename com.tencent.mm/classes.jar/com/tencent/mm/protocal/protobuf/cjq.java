package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cjq
  extends cvc
{
  public int FOV;
  public bb FPa;
  public int FqH;
  public String Hdu;
  public String Hdv;
  public b Hdw;
  public int Hdx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91598);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hdu != null) {
        paramVarArgs.d(2, this.Hdu);
      }
      if (this.Hdv != null) {
        paramVarArgs.d(3, this.Hdv);
      }
      if (this.Hdw != null) {
        paramVarArgs.c(4, this.Hdw);
      }
      paramVarArgs.aS(5, this.FOV);
      paramVarArgs.aS(6, this.FqH);
      paramVarArgs.aS(7, this.Hdx);
      if (this.FPa != null)
      {
        paramVarArgs.lC(8, this.FPa.computeSize());
        this.FPa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hdu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hdu);
      }
      i = paramInt;
      if (this.Hdv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hdv);
      }
      paramInt = i;
      if (this.Hdw != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Hdw);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FOV) + f.a.a.b.b.a.bz(6, this.FqH) + f.a.a.b.b.a.bz(7, this.Hdx);
      paramInt = i;
      if (this.FPa != null) {
        paramInt = i + f.a.a.a.lB(8, this.FPa.computeSize());
      }
      AppMethodBeat.o(91598);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjq localcjq = (cjq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91598);
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
            localcjq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91598);
          return 0;
        case 2: 
          localcjq.Hdu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 3: 
          localcjq.Hdv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 4: 
          localcjq.Hdw = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91598);
          return 0;
        case 5: 
          localcjq.FOV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91598);
          return 0;
        case 6: 
          localcjq.FqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91598);
          return 0;
        case 7: 
          localcjq.Hdx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91598);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjq.FPa = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      AppMethodBeat.o(91598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjq
 * JD-Core Version:    0.7.0.1
 */