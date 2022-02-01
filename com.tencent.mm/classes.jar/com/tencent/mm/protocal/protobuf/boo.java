package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boo
  extends ckq
{
  public ik CBN;
  public String CBO;
  public int CBP;
  public String CBQ;
  public String CBS;
  public SKBuiltinBuffer_t CBT;
  public SKBuiltinBuffer_t CBU;
  public int Ctl;
  public String DLT;
  public String DLU;
  public String DLV;
  public int DLW;
  public String Ddm;
  public String DpQ;
  public int fVD;
  public String fVv;
  public String fVw;
  public String ijP;
  public String mAU;
  public String oXr;
  public String oXs;
  public String sul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133176);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CBN != null)
      {
        paramVarArgs.kX(2, this.CBN.computeSize());
        this.CBN.writeFields(paramVarArgs);
      }
      if (this.sul != null) {
        paramVarArgs.d(3, this.sul);
      }
      if (this.CBO != null) {
        paramVarArgs.d(4, this.CBO);
      }
      paramVarArgs.aR(5, this.CBP);
      if (this.CBQ != null) {
        paramVarArgs.d(6, this.CBQ);
      }
      if (this.ijP != null) {
        paramVarArgs.d(7, this.ijP);
      }
      if (this.mAU != null) {
        paramVarArgs.d(8, this.mAU);
      }
      if (this.CBS != null) {
        paramVarArgs.d(9, this.CBS);
      }
      if (this.oXs != null) {
        paramVarArgs.d(10, this.oXs);
      }
      if (this.oXr != null) {
        paramVarArgs.d(11, this.oXr);
      }
      paramVarArgs.aR(13, this.Ctl);
      paramVarArgs.aR(14, this.fVD);
      if (this.fVw != null) {
        paramVarArgs.d(15, this.fVw);
      }
      if (this.fVv != null) {
        paramVarArgs.d(16, this.fVv);
      }
      if (this.DLT != null) {
        paramVarArgs.d(17, this.DLT);
      }
      if (this.Ddm != null) {
        paramVarArgs.d(18, this.Ddm);
      }
      if (this.DpQ != null) {
        paramVarArgs.d(19, this.DpQ);
      }
      if (this.DLU != null) {
        paramVarArgs.d(20, this.DLU);
      }
      if (this.DLV != null) {
        paramVarArgs.d(21, this.DLV);
      }
      paramVarArgs.aR(22, this.DLW);
      if (this.CBT != null)
      {
        paramVarArgs.kX(23, this.CBT.computeSize());
        this.CBT.writeFields(paramVarArgs);
      }
      if (this.CBU != null)
      {
        paramVarArgs.kX(24, this.CBU.computeSize());
        this.CBU.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CBN != null) {
        paramInt = i + f.a.a.a.kW(2, this.CBN.computeSize());
      }
      i = paramInt;
      if (this.sul != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sul);
      }
      paramInt = i;
      if (this.CBO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CBO);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CBP);
      paramInt = i;
      if (this.CBQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CBQ);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ijP);
      }
      paramInt = i;
      if (this.mAU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.mAU);
      }
      i = paramInt;
      if (this.CBS != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CBS);
      }
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.oXs);
      }
      i = paramInt;
      if (this.oXr != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.oXr);
      }
      i = i + f.a.a.b.b.a.bA(13, this.Ctl) + f.a.a.b.b.a.bA(14, this.fVD);
      paramInt = i;
      if (this.fVw != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.fVw);
      }
      i = paramInt;
      if (this.fVv != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.fVv);
      }
      paramInt = i;
      if (this.DLT != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DLT);
      }
      i = paramInt;
      if (this.Ddm != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Ddm);
      }
      paramInt = i;
      if (this.DpQ != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DpQ);
      }
      i = paramInt;
      if (this.DLU != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.DLU);
      }
      paramInt = i;
      if (this.DLV != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DLV);
      }
      i = paramInt + f.a.a.b.b.a.bA(22, this.DLW);
      paramInt = i;
      if (this.CBT != null) {
        paramInt = i + f.a.a.a.kW(23, this.CBT.computeSize());
      }
      i = paramInt;
      if (this.CBU != null) {
        i = paramInt + f.a.a.a.kW(24, this.CBU.computeSize());
      }
      AppMethodBeat.o(133176);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        boo localboo = (boo)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboo.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ik();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ik)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboo.CBN = ((ik)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 3: 
          localboo.sul = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 4: 
          localboo.CBO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 5: 
          localboo.CBP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133176);
          return 0;
        case 6: 
          localboo.CBQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 7: 
          localboo.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 8: 
          localboo.mAU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 9: 
          localboo.CBS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 10: 
          localboo.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 11: 
          localboo.oXr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 13: 
          localboo.Ctl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133176);
          return 0;
        case 14: 
          localboo.fVD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133176);
          return 0;
        case 15: 
          localboo.fVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 16: 
          localboo.fVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 17: 
          localboo.DLT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 18: 
          localboo.Ddm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 19: 
          localboo.DpQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 20: 
          localboo.DLU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 21: 
          localboo.DLV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 22: 
          localboo.DLW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133176);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboo.CBT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localboo.CBU = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boo
 * JD-Core Version:    0.7.0.1
 */