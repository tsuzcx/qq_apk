package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cvx
  extends cvw
{
  public String FRb;
  public int GdY;
  public int HGF;
  public String HGG;
  public int HGH;
  public int HGI;
  public b HGJ;
  public String HsZ;
  public String dlT;
  public int yif;
  public String yis;
  public String yit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72581);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yis != null) {
        paramVarArgs.d(2, this.yis);
      }
      if (this.yit != null) {
        paramVarArgs.d(3, this.yit);
      }
      if (this.dlT != null) {
        paramVarArgs.d(4, this.dlT);
      }
      paramVarArgs.aS(5, this.yif);
      paramVarArgs.aS(6, this.HGF);
      if (this.HGG != null) {
        paramVarArgs.d(7, this.HGG);
      }
      paramVarArgs.aS(8, this.HGH);
      paramVarArgs.aS(9, this.HGI);
      if (this.FRb != null) {
        paramVarArgs.d(10, this.FRb);
      }
      if (this.HsZ != null) {
        paramVarArgs.d(11, this.HsZ);
      }
      if (this.HGJ != null) {
        paramVarArgs.c(12, this.HGJ);
      }
      paramVarArgs.aS(13, this.GdY);
      AppMethodBeat.o(72581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yis != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yis);
      }
      i = paramInt;
      if (this.yit != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.yit);
      }
      paramInt = i;
      if (this.dlT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dlT);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.yif) + f.a.a.b.b.a.bz(6, this.HGF);
      paramInt = i;
      if (this.HGG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HGG);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HGH) + f.a.a.b.b.a.bz(9, this.HGI);
      paramInt = i;
      if (this.FRb != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FRb);
      }
      i = paramInt;
      if (this.HsZ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HsZ);
      }
      paramInt = i;
      if (this.HGJ != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.HGJ);
      }
      i = f.a.a.b.b.a.bz(13, this.GdY);
      AppMethodBeat.o(72581);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvx localcvx = (cvx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72581);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72581);
          return 0;
        case 2: 
          localcvx.yis = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 3: 
          localcvx.yit = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 4: 
          localcvx.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 5: 
          localcvx.yif = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72581);
          return 0;
        case 6: 
          localcvx.HGF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72581);
          return 0;
        case 7: 
          localcvx.HGG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 8: 
          localcvx.HGH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72581);
          return 0;
        case 9: 
          localcvx.HGI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72581);
          return 0;
        case 10: 
          localcvx.FRb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 11: 
          localcvx.HsZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 12: 
          localcvx.HGJ = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(72581);
          return 0;
        }
        localcvx.GdY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72581);
        return 0;
      }
      AppMethodBeat.o(72581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvx
 * JD-Core Version:    0.7.0.1
 */