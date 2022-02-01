package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gz
  extends ckq
{
  public ik CBN;
  public String CBO;
  public int CBP;
  public String CBQ;
  public String CBS;
  public SKBuiltinBuffer_t CBT;
  public SKBuiltinBuffer_t CBU;
  public SKBuiltinBuffer_t CBc;
  public int Ctl;
  public String ijP;
  public String mAU;
  public String oXr;
  public String oXs;
  public String sul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBc == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133146);
        throw paramVarArgs;
      }
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
      if (this.CBc != null)
      {
        paramVarArgs.kX(3, this.CBc.computeSize());
        this.CBc.writeFields(paramVarArgs);
      }
      if (this.sul != null) {
        paramVarArgs.d(4, this.sul);
      }
      if (this.CBO != null) {
        paramVarArgs.d(5, this.CBO);
      }
      paramVarArgs.aR(6, this.CBP);
      if (this.CBQ != null) {
        paramVarArgs.d(7, this.CBQ);
      }
      if (this.ijP != null) {
        paramVarArgs.d(8, this.ijP);
      }
      if (this.mAU != null) {
        paramVarArgs.d(9, this.mAU);
      }
      if (this.CBS != null) {
        paramVarArgs.d(10, this.CBS);
      }
      if (this.oXs != null) {
        paramVarArgs.d(11, this.oXs);
      }
      if (this.oXr != null) {
        paramVarArgs.d(12, this.oXr);
      }
      paramVarArgs.aR(13, this.Ctl);
      if (this.CBT != null)
      {
        paramVarArgs.kX(14, this.CBT.computeSize());
        this.CBT.writeFields(paramVarArgs);
      }
      if (this.CBU != null)
      {
        paramVarArgs.kX(15, this.CBU.computeSize());
        this.CBU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1562;
      }
    }
    label1562:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CBN != null) {
        paramInt = i + f.a.a.a.kW(2, this.CBN.computeSize());
      }
      i = paramInt;
      if (this.CBc != null) {
        i = paramInt + f.a.a.a.kW(3, this.CBc.computeSize());
      }
      paramInt = i;
      if (this.sul != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sul);
      }
      i = paramInt;
      if (this.CBO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CBO);
      }
      i += f.a.a.b.b.a.bA(6, this.CBP);
      paramInt = i;
      if (this.CBQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CBQ);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ijP);
      }
      paramInt = i;
      if (this.mAU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.mAU);
      }
      i = paramInt;
      if (this.CBS != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CBS);
      }
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.oXs);
      }
      i = paramInt;
      if (this.oXr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.oXr);
      }
      i += f.a.a.b.b.a.bA(13, this.Ctl);
      paramInt = i;
      if (this.CBT != null) {
        paramInt = i + f.a.a.a.kW(14, this.CBT.computeSize());
      }
      i = paramInt;
      if (this.CBU != null) {
        i = paramInt + f.a.a.a.kW(15, this.CBU.computeSize());
      }
      AppMethodBeat.o(133146);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CBc == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gz localgz = (gz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133146);
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
            localgz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
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
            localgz.CBN = ((ik)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgz.CBc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 4: 
          localgz.sul = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 5: 
          localgz.CBO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 6: 
          localgz.CBP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133146);
          return 0;
        case 7: 
          localgz.CBQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 8: 
          localgz.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 9: 
          localgz.mAU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 10: 
          localgz.CBS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 11: 
          localgz.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 12: 
          localgz.oXr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 13: 
          localgz.Ctl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133146);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgz.CBT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
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
          localgz.CBU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      AppMethodBeat.o(133146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gz
 * JD-Core Version:    0.7.0.1
 */