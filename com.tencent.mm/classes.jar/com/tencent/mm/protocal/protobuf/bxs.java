package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxs
  extends cvc
{
  public int FqH;
  public ix FzF;
  public String FzG;
  public int FzH;
  public String FzI;
  public String FzJ;
  public SKBuiltinBuffer_t FzK;
  public SKBuiltinBuffer_t FzL;
  public String GRJ;
  public String GRK;
  public String GRL;
  public int GRM;
  public String GdW;
  public String GtW;
  public String gsM;
  public String gsN;
  public int gsU;
  public String jdf;
  public String nDs;
  public String qeh;
  public String qei;
  public String uEK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133176);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FzF != null)
      {
        paramVarArgs.lC(2, this.FzF.computeSize());
        this.FzF.writeFields(paramVarArgs);
      }
      if (this.uEK != null) {
        paramVarArgs.d(3, this.uEK);
      }
      if (this.FzG != null) {
        paramVarArgs.d(4, this.FzG);
      }
      paramVarArgs.aS(5, this.FzH);
      if (this.FzI != null) {
        paramVarArgs.d(6, this.FzI);
      }
      if (this.jdf != null) {
        paramVarArgs.d(7, this.jdf);
      }
      if (this.nDs != null) {
        paramVarArgs.d(8, this.nDs);
      }
      if (this.FzJ != null) {
        paramVarArgs.d(9, this.FzJ);
      }
      if (this.qei != null) {
        paramVarArgs.d(10, this.qei);
      }
      if (this.qeh != null) {
        paramVarArgs.d(11, this.qeh);
      }
      paramVarArgs.aS(13, this.FqH);
      paramVarArgs.aS(14, this.gsU);
      if (this.gsN != null) {
        paramVarArgs.d(15, this.gsN);
      }
      if (this.gsM != null) {
        paramVarArgs.d(16, this.gsM);
      }
      if (this.GRJ != null) {
        paramVarArgs.d(17, this.GRJ);
      }
      if (this.GdW != null) {
        paramVarArgs.d(18, this.GdW);
      }
      if (this.GtW != null) {
        paramVarArgs.d(19, this.GtW);
      }
      if (this.GRK != null) {
        paramVarArgs.d(20, this.GRK);
      }
      if (this.GRL != null) {
        paramVarArgs.d(21, this.GRL);
      }
      paramVarArgs.aS(22, this.GRM);
      if (this.FzK != null)
      {
        paramVarArgs.lC(23, this.FzK.computeSize());
        this.FzK.writeFields(paramVarArgs);
      }
      if (this.FzL != null)
      {
        paramVarArgs.lC(24, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133176);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1886;
      }
    }
    label1886:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FzF != null) {
        paramInt = i + f.a.a.a.lB(2, this.FzF.computeSize());
      }
      i = paramInt;
      if (this.uEK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uEK);
      }
      paramInt = i;
      if (this.FzG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FzG);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FzH);
      paramInt = i;
      if (this.FzI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FzI);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.jdf);
      }
      paramInt = i;
      if (this.nDs != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.nDs);
      }
      i = paramInt;
      if (this.FzJ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FzJ);
      }
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qei);
      }
      i = paramInt;
      if (this.qeh != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.qeh);
      }
      i = i + f.a.a.b.b.a.bz(13, this.FqH) + f.a.a.b.b.a.bz(14, this.gsU);
      paramInt = i;
      if (this.gsN != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.gsN);
      }
      i = paramInt;
      if (this.gsM != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.gsM);
      }
      paramInt = i;
      if (this.GRJ != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GRJ);
      }
      i = paramInt;
      if (this.GdW != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.GdW);
      }
      paramInt = i;
      if (this.GtW != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GtW);
      }
      i = paramInt;
      if (this.GRK != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.GRK);
      }
      paramInt = i;
      if (this.GRL != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GRL);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.GRM);
      paramInt = i;
      if (this.FzK != null) {
        paramInt = i + f.a.a.a.lB(23, this.FzK.computeSize());
      }
      i = paramInt;
      if (this.FzL != null) {
        i = paramInt + f.a.a.a.lB(24, this.FzL.computeSize());
      }
      AppMethodBeat.o(133176);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxs localbxs = (bxs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 12: 
        default: 
          AppMethodBeat.o(133176);
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
            localbxs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxs.FzF = ((ix)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 3: 
          localbxs.uEK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 4: 
          localbxs.FzG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 5: 
          localbxs.FzH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133176);
          return 0;
        case 6: 
          localbxs.FzI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 7: 
          localbxs.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 8: 
          localbxs.nDs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 9: 
          localbxs.FzJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 10: 
          localbxs.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 11: 
          localbxs.qeh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 13: 
          localbxs.FqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133176);
          return 0;
        case 14: 
          localbxs.gsU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133176);
          return 0;
        case 15: 
          localbxs.gsN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 16: 
          localbxs.gsM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 17: 
          localbxs.GRJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 18: 
          localbxs.GdW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 19: 
          localbxs.GtW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 20: 
          localbxs.GRK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 21: 
          localbxs.GRL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 22: 
          localbxs.GRM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133176);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxs.FzK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxs.FzL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      AppMethodBeat.o(133176);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxs
 * JD-Core Version:    0.7.0.1
 */