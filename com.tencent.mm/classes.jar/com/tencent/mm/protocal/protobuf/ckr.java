package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ckr
  extends ckq
{
  public String CAM;
  public int CMy;
  public String DTs;
  public int EfS;
  public String EfT;
  public int EfU;
  public int EfV;
  public b EfW;
  public String dca;
  public int vuA;
  public String vuN;
  public String vuO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72581);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vuN != null) {
        paramVarArgs.d(2, this.vuN);
      }
      if (this.vuO != null) {
        paramVarArgs.d(3, this.vuO);
      }
      if (this.dca != null) {
        paramVarArgs.d(4, this.dca);
      }
      paramVarArgs.aR(5, this.vuA);
      paramVarArgs.aR(6, this.EfS);
      if (this.EfT != null) {
        paramVarArgs.d(7, this.EfT);
      }
      paramVarArgs.aR(8, this.EfU);
      paramVarArgs.aR(9, this.EfV);
      if (this.CAM != null) {
        paramVarArgs.d(10, this.CAM);
      }
      if (this.DTs != null) {
        paramVarArgs.d(11, this.DTs);
      }
      if (this.EfW != null) {
        paramVarArgs.c(12, this.EfW);
      }
      paramVarArgs.aR(13, this.CMy);
      AppMethodBeat.o(72581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vuN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vuN);
      }
      i = paramInt;
      if (this.vuO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vuO);
      }
      paramInt = i;
      if (this.dca != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dca);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.vuA) + f.a.a.b.b.a.bA(6, this.EfS);
      paramInt = i;
      if (this.EfT != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EfT);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.EfU) + f.a.a.b.b.a.bA(9, this.EfV);
      paramInt = i;
      if (this.CAM != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CAM);
      }
      i = paramInt;
      if (this.DTs != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DTs);
      }
      paramInt = i;
      if (this.EfW != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.EfW);
      }
      i = f.a.a.b.b.a.bA(13, this.CMy);
      AppMethodBeat.o(72581);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckr localckr = (ckr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72581);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72581);
          return 0;
        case 2: 
          localckr.vuN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 3: 
          localckr.vuO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 4: 
          localckr.dca = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 5: 
          localckr.vuA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72581);
          return 0;
        case 6: 
          localckr.EfS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72581);
          return 0;
        case 7: 
          localckr.EfT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 8: 
          localckr.EfU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72581);
          return 0;
        case 9: 
          localckr.EfV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72581);
          return 0;
        case 10: 
          localckr.CAM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 11: 
          localckr.DTs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 12: 
          localckr.EfW = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(72581);
          return 0;
        }
        localckr.CMy = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72581);
        return 0;
      }
      AppMethodBeat.o(72581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckr
 * JD-Core Version:    0.7.0.1
 */