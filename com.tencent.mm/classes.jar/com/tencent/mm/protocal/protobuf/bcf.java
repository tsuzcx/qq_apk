package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcf
  extends cvp
{
  public String CKD;
  public boolean CKE;
  public String CKF;
  public String CKG;
  public String CKH;
  public String CKI;
  public String CKJ;
  public String CKK;
  public boolean CKM;
  public LinkedList<bnw> GyR;
  public int dlw;
  public String paA;
  
  public bcf()
  {
    AppMethodBeat.i(72486);
    this.dlw = 0;
    this.paA = "ok";
    this.GyR = new LinkedList();
    AppMethodBeat.o(72486);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72487);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.CKD != null) {
        paramVarArgs.d(4, this.CKD);
      }
      paramVarArgs.bt(6, this.CKE);
      if (this.CKF != null) {
        paramVarArgs.d(7, this.CKF);
      }
      if (this.CKG != null) {
        paramVarArgs.d(8, this.CKG);
      }
      if (this.CKH != null) {
        paramVarArgs.d(9, this.CKH);
      }
      if (this.CKI != null) {
        paramVarArgs.d(10, this.CKI);
      }
      if (this.CKJ != null) {
        paramVarArgs.d(11, this.CKJ);
      }
      if (this.CKK != null) {
        paramVarArgs.d(12, this.CKK);
      }
      paramVarArgs.e(13, 8, this.GyR);
      paramVarArgs.bt(14, this.CKM);
      AppMethodBeat.o(72487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.CKD != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CKD);
      }
      i += f.a.a.b.b.a.alV(6);
      paramInt = i;
      if (this.CKF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CKF);
      }
      i = paramInt;
      if (this.CKG != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CKG);
      }
      paramInt = i;
      if (this.CKH != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CKH);
      }
      i = paramInt;
      if (this.CKI != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CKI);
      }
      paramInt = i;
      if (this.CKJ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CKJ);
      }
      i = paramInt;
      if (this.CKK != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CKK);
      }
      paramInt = f.a.a.a.c(13, 8, this.GyR);
      int j = f.a.a.b.b.a.alV(14);
      AppMethodBeat.o(72487);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GyR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcf localbcf = (bcf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(72487);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        case 2: 
          localbcf.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72487);
          return 0;
        case 3: 
          localbcf.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 4: 
          localbcf.CKD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 6: 
          localbcf.CKE = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72487);
          return 0;
        case 7: 
          localbcf.CKF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 8: 
          localbcf.CKG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 9: 
          localbcf.CKH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 10: 
          localbcf.CKI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 11: 
          localbcf.CKJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 12: 
          localbcf.CKK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcf.GyR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        }
        localbcf.CKM = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(72487);
        return 0;
      }
      AppMethodBeat.o(72487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcf
 * JD-Core Version:    0.7.0.1
 */