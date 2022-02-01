package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cvd
  extends cvc
{
  public int FLz;
  public String FyD;
  public String GZy;
  public int Hnf;
  public String Hng;
  public int Hnh;
  public int Hni;
  public b Hnj;
  public String dkR;
  public String xSA;
  public int xSm;
  public String xSz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72581);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xSz != null) {
        paramVarArgs.d(2, this.xSz);
      }
      if (this.xSA != null) {
        paramVarArgs.d(3, this.xSA);
      }
      if (this.dkR != null) {
        paramVarArgs.d(4, this.dkR);
      }
      paramVarArgs.aS(5, this.xSm);
      paramVarArgs.aS(6, this.Hnf);
      if (this.Hng != null) {
        paramVarArgs.d(7, this.Hng);
      }
      paramVarArgs.aS(8, this.Hnh);
      paramVarArgs.aS(9, this.Hni);
      if (this.FyD != null) {
        paramVarArgs.d(10, this.FyD);
      }
      if (this.GZy != null) {
        paramVarArgs.d(11, this.GZy);
      }
      if (this.Hnj != null) {
        paramVarArgs.c(12, this.Hnj);
      }
      paramVarArgs.aS(13, this.FLz);
      AppMethodBeat.o(72581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xSz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xSz);
      }
      i = paramInt;
      if (this.xSA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xSA);
      }
      paramInt = i;
      if (this.dkR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dkR);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.xSm) + f.a.a.b.b.a.bz(6, this.Hnf);
      paramInt = i;
      if (this.Hng != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hng);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Hnh) + f.a.a.b.b.a.bz(9, this.Hni);
      paramInt = i;
      if (this.FyD != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FyD);
      }
      i = paramInt;
      if (this.GZy != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GZy);
      }
      paramInt = i;
      if (this.Hnj != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.Hnj);
      }
      i = f.a.a.b.b.a.bz(13, this.FLz);
      AppMethodBeat.o(72581);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvd localcvd = (cvd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72581);
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
            localcvd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72581);
          return 0;
        case 2: 
          localcvd.xSz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 3: 
          localcvd.xSA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 4: 
          localcvd.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 5: 
          localcvd.xSm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72581);
          return 0;
        case 6: 
          localcvd.Hnf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72581);
          return 0;
        case 7: 
          localcvd.Hng = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 8: 
          localcvd.Hnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72581);
          return 0;
        case 9: 
          localcvd.Hni = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72581);
          return 0;
        case 10: 
          localcvd.FyD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 11: 
          localcvd.GZy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 12: 
          localcvd.Hnj = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(72581);
          return 0;
        }
        localcvd.FLz = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72581);
        return 0;
      }
      AppMethodBeat.o(72581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvd
 * JD-Core Version:    0.7.0.1
 */