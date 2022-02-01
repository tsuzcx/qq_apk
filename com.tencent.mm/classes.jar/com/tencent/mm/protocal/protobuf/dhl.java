package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhl
  extends ckq
{
  public int CAG;
  public int CAJ;
  public int CNt;
  public String ExD;
  public int ExE;
  public int ExF;
  public int hno;
  public String mAQ;
  public SKBuiltinBuffer_t uKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148657);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.uKT != null)
      {
        paramVarArgs.kX(3, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CNt);
      if (this.ExD != null) {
        paramVarArgs.d(5, this.ExD);
      }
      paramVarArgs.aR(6, this.hno);
      paramVarArgs.aR(7, this.ExE);
      paramVarArgs.aR(8, this.CAJ);
      paramVarArgs.aR(9, this.ExF);
      paramVarArgs.aR(10, this.CAG);
      AppMethodBeat.o(148657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.uKT != null) {
        i = paramInt + f.a.a.a.kW(3, this.uKT.computeSize());
      }
      i += f.a.a.b.b.a.bA(4, this.CNt);
      paramInt = i;
      if (this.ExD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ExD);
      }
      i = f.a.a.b.b.a.bA(6, this.hno);
      int j = f.a.a.b.b.a.bA(7, this.ExE);
      int k = f.a.a.b.b.a.bA(8, this.CAJ);
      int m = f.a.a.b.b.a.bA(9, this.ExF);
      int n = f.a.a.b.b.a.bA(10, this.CAG);
      AppMethodBeat.o(148657);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.uKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhl localdhl = (dhl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148657);
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
            localdhl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148657);
          return 0;
        case 2: 
          localdhl.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148657);
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
            localdhl.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148657);
          return 0;
        case 4: 
          localdhl.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148657);
          return 0;
        case 5: 
          localdhl.ExD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148657);
          return 0;
        case 6: 
          localdhl.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148657);
          return 0;
        case 7: 
          localdhl.ExE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148657);
          return 0;
        case 8: 
          localdhl.CAJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148657);
          return 0;
        case 9: 
          localdhl.ExF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148657);
          return 0;
        }
        localdhl.CAG = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148657);
        return 0;
      }
      AppMethodBeat.o(148657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhl
 * JD-Core Version:    0.7.0.1
 */