package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgn
  extends cvp
{
  public daz GBK;
  public egu GBL;
  public ehm GBM;
  public akw GBN;
  public egw GBO;
  public ehv GBP;
  public ehx GBQ;
  public String GBR;
  public String GBS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153276);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GBK != null)
      {
        paramVarArgs.lC(2, this.GBK.computeSize());
        this.GBK.writeFields(paramVarArgs);
      }
      if (this.GBL != null)
      {
        paramVarArgs.lC(3, this.GBL.computeSize());
        this.GBL.writeFields(paramVarArgs);
      }
      if (this.GBM != null)
      {
        paramVarArgs.lC(4, this.GBM.computeSize());
        this.GBM.writeFields(paramVarArgs);
      }
      if (this.GBN != null)
      {
        paramVarArgs.lC(5, this.GBN.computeSize());
        this.GBN.writeFields(paramVarArgs);
      }
      if (this.GBO != null)
      {
        paramVarArgs.lC(6, this.GBO.computeSize());
        this.GBO.writeFields(paramVarArgs);
      }
      if (this.GBP != null)
      {
        paramVarArgs.lC(7, this.GBP.computeSize());
        this.GBP.writeFields(paramVarArgs);
      }
      if (this.GBQ != null)
      {
        paramVarArgs.lC(8, this.GBQ.computeSize());
        this.GBQ.writeFields(paramVarArgs);
      }
      if (this.GBR != null) {
        paramVarArgs.d(10, this.GBR);
      }
      if (this.GBS != null) {
        paramVarArgs.d(11, this.GBS);
      }
      AppMethodBeat.o(153276);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GBK != null) {
        paramInt = i + f.a.a.a.lB(2, this.GBK.computeSize());
      }
      i = paramInt;
      if (this.GBL != null) {
        i = paramInt + f.a.a.a.lB(3, this.GBL.computeSize());
      }
      paramInt = i;
      if (this.GBM != null) {
        paramInt = i + f.a.a.a.lB(4, this.GBM.computeSize());
      }
      i = paramInt;
      if (this.GBN != null) {
        i = paramInt + f.a.a.a.lB(5, this.GBN.computeSize());
      }
      paramInt = i;
      if (this.GBO != null) {
        paramInt = i + f.a.a.a.lB(6, this.GBO.computeSize());
      }
      i = paramInt;
      if (this.GBP != null) {
        i = paramInt + f.a.a.a.lB(7, this.GBP.computeSize());
      }
      paramInt = i;
      if (this.GBQ != null) {
        paramInt = i + f.a.a.a.lB(8, this.GBQ.computeSize());
      }
      i = paramInt;
      if (this.GBR != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GBR);
      }
      paramInt = i;
      if (this.GBS != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GBS);
      }
      AppMethodBeat.o(153276);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153276);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgn localbgn = (bgn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(153276);
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
            localbgn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new daz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((daz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgn.GBK = ((daz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgn.GBL = ((egu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgn.GBM = ((ehm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgn.GBN = ((akw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgn.GBO = ((egw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgn.GBP = ((ehv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgn.GBQ = ((ehx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 10: 
          localbgn.GBR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153276);
          return 0;
        }
        localbgn.GBS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(153276);
        return 0;
      }
      AppMethodBeat.o(153276);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgn
 * JD-Core Version:    0.7.0.1
 */