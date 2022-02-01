package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class btg
  extends cvp
{
  public btc GNJ;
  public xf GNK;
  public egb GNL;
  public cnj GNM;
  public bd GNN;
  public cgh GNO;
  public String duW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123625);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123625);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GNJ != null)
      {
        paramVarArgs.lC(2, this.GNJ.computeSize());
        this.GNJ.writeFields(paramVarArgs);
      }
      if (this.GNK != null)
      {
        paramVarArgs.lC(3, this.GNK.computeSize());
        this.GNK.writeFields(paramVarArgs);
      }
      if (this.GNL != null)
      {
        paramVarArgs.lC(4, this.GNL.computeSize());
        this.GNL.writeFields(paramVarArgs);
      }
      if (this.GNM != null)
      {
        paramVarArgs.lC(5, this.GNM.computeSize());
        this.GNM.writeFields(paramVarArgs);
      }
      if (this.GNN != null)
      {
        paramVarArgs.lC(6, this.GNN.computeSize());
        this.GNN.writeFields(paramVarArgs);
      }
      if (this.GNO != null)
      {
        paramVarArgs.lC(7, this.GNO.computeSize());
        this.GNO.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(8, this.duW);
      }
      AppMethodBeat.o(123625);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1350;
      }
    }
    label1350:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GNJ != null) {
        paramInt = i + f.a.a.a.lB(2, this.GNJ.computeSize());
      }
      i = paramInt;
      if (this.GNK != null) {
        i = paramInt + f.a.a.a.lB(3, this.GNK.computeSize());
      }
      paramInt = i;
      if (this.GNL != null) {
        paramInt = i + f.a.a.a.lB(4, this.GNL.computeSize());
      }
      i = paramInt;
      if (this.GNM != null) {
        i = paramInt + f.a.a.a.lB(5, this.GNM.computeSize());
      }
      paramInt = i;
      if (this.GNN != null) {
        paramInt = i + f.a.a.a.lB(6, this.GNN.computeSize());
      }
      i = paramInt;
      if (this.GNO != null) {
        i = paramInt + f.a.a.a.lB(7, this.GNO.computeSize());
      }
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.duW);
      }
      AppMethodBeat.o(123625);
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
          AppMethodBeat.o(123625);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123625);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btg localbtg = (btg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123625);
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
            localbtg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.GNJ = ((btc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.GNK = ((xf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.GNL = ((egb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.GNM = ((cnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.GNN = ((bd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.GNO = ((cgh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        }
        localbtg.duW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123625);
        return 0;
      }
      AppMethodBeat.o(123625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btg
 * JD-Core Version:    0.7.0.1
 */