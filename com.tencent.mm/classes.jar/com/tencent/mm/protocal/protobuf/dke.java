package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dke
  extends cvc
{
  public String FuL;
  public String HtU;
  public long HtV;
  public long Hvg;
  public int Hvh;
  public long HyS;
  public String nDo;
  public int tRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HtU != null) {
        paramVarArgs.d(2, this.HtU);
      }
      if (this.nDo != null) {
        paramVarArgs.d(3, this.nDo);
      }
      paramVarArgs.aY(4, this.HtV);
      paramVarArgs.aY(5, this.Hvg);
      paramVarArgs.aS(6, this.Hvh);
      paramVarArgs.aY(7, this.HyS);
      paramVarArgs.aS(8, this.tRT);
      if (this.FuL != null) {
        paramVarArgs.d(9, this.FuL);
      }
      AppMethodBeat.o(118476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label710;
      }
    }
    label710:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HtU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HtU);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nDo);
      }
      i = i + f.a.a.b.b.a.p(4, this.HtV) + f.a.a.b.b.a.p(5, this.Hvg) + f.a.a.b.b.a.bz(6, this.Hvh) + f.a.a.b.b.a.p(7, this.HyS) + f.a.a.b.b.a.bz(8, this.tRT);
      paramInt = i;
      if (this.FuL != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FuL);
      }
      AppMethodBeat.o(118476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(118476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dke localdke = (dke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118476);
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
            localdke.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118476);
          return 0;
        case 2: 
          localdke.HtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 3: 
          localdke.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 4: 
          localdke.HtV = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(118476);
          return 0;
        case 5: 
          localdke.Hvg = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(118476);
          return 0;
        case 6: 
          localdke.Hvh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118476);
          return 0;
        case 7: 
          localdke.HyS = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(118476);
          return 0;
        case 8: 
          localdke.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118476);
          return 0;
        }
        localdke.FuL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118476);
        return 0;
      }
      AppMethodBeat.o(118476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dke
 * JD-Core Version:    0.7.0.1
 */