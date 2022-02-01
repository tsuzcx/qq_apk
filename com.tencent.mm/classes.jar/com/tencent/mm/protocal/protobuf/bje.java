package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bje
  extends cvc
{
  public int FPp;
  public String GDK;
  public String GDL;
  public int GDM;
  public int GDN = 4;
  public String duW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123580);
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
      if (this.GDK != null) {
        paramVarArgs.d(3, this.GDK);
      }
      if (this.GDL != null) {
        paramVarArgs.d(4, this.GDL);
      }
      paramVarArgs.aS(5, this.FPp);
      paramVarArgs.aS(6, this.GDM);
      paramVarArgs.aS(7, this.GDN);
      AppMethodBeat.o(123580);
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
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.GDK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GDK);
      }
      paramInt = i;
      if (this.GDL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GDL);
      }
      i = f.a.a.b.b.a.bz(5, this.FPp);
      int j = f.a.a.b.b.a.bz(6, this.GDM);
      int k = f.a.a.b.b.a.bz(7, this.GDN);
      AppMethodBeat.o(123580);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bje localbje = (bje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123580);
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
            localbje.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123580);
          return 0;
        case 2: 
          localbje.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 3: 
          localbje.GDK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 4: 
          localbje.GDL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 5: 
          localbje.FPp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123580);
          return 0;
        case 6: 
          localbje.GDM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123580);
          return 0;
        }
        localbje.GDN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123580);
        return 0;
      }
      AppMethodBeat.o(123580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bje
 * JD-Core Version:    0.7.0.1
 */