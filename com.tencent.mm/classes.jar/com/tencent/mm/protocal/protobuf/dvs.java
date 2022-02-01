package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dvs
  extends cvw
{
  public String HyQ;
  public String HyR;
  public int HyS;
  public String HyT;
  public SKBuiltinBuffer_t IaZ;
  public int Iba;
  public int Ibb;
  public String Ibc;
  public String ProductID;
  public int wTg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91722);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IaZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Receipt");
        AppMethodBeat.o(91722);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IaZ != null)
      {
        paramVarArgs.lJ(2, this.IaZ.computeSize());
        this.IaZ.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(3, this.ProductID);
      }
      paramVarArgs.aS(4, this.Iba);
      paramVarArgs.aS(5, this.wTg);
      if (this.HyQ != null) {
        paramVarArgs.d(6, this.HyQ);
      }
      if (this.HyR != null) {
        paramVarArgs.d(7, this.HyR);
      }
      if (this.HyT != null) {
        paramVarArgs.d(8, this.HyT);
      }
      paramVarArgs.aS(9, this.Ibb);
      if (this.Ibc != null) {
        paramVarArgs.d(10, this.Ibc);
      }
      paramVarArgs.aS(11, this.HyS);
      AppMethodBeat.o(91722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label998;
      }
    }
    label998:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IaZ != null) {
        paramInt = i + f.a.a.a.lI(2, this.IaZ.computeSize());
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ProductID);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Iba) + f.a.a.b.b.a.bz(5, this.wTg);
      paramInt = i;
      if (this.HyQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HyQ);
      }
      i = paramInt;
      if (this.HyR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HyR);
      }
      paramInt = i;
      if (this.HyT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HyT);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Ibb);
      paramInt = i;
      if (this.Ibc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ibc);
      }
      i = f.a.a.b.b.a.bz(11, this.HyS);
      AppMethodBeat.o(91722);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.IaZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Receipt");
          AppMethodBeat.o(91722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvs localdvs = (dvs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91722);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvs.IaZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 3: 
          localdvs.ProductID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 4: 
          localdvs.Iba = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91722);
          return 0;
        case 5: 
          localdvs.wTg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91722);
          return 0;
        case 6: 
          localdvs.HyQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 7: 
          localdvs.HyR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 8: 
          localdvs.HyT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 9: 
          localdvs.Ibb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91722);
          return 0;
        case 10: 
          localdvs.Ibc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91722);
          return 0;
        }
        localdvs.HyS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91722);
        return 0;
      }
      AppMethodBeat.o(91722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvs
 * JD-Core Version:    0.7.0.1
 */