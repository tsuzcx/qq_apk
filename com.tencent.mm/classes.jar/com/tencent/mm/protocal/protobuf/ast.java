package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ast
  extends cld
{
  public int DsQ;
  public qw DsR;
  public rc DsS;
  public String DsT;
  public int DsU;
  public int DsV;
  public rl DsW;
  public int ntx;
  public String nty;
  public int ocT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192649);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(192649);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.aR(4, this.ocT);
      paramVarArgs.aR(5, this.DsQ);
      if (this.DsR != null)
      {
        paramVarArgs.kX(6, this.DsR.computeSize());
        this.DsR.writeFields(paramVarArgs);
      }
      if (this.DsS != null)
      {
        paramVarArgs.kX(7, this.DsS.computeSize());
        this.DsS.writeFields(paramVarArgs);
      }
      if (this.DsT != null) {
        paramVarArgs.d(8, this.DsT);
      }
      paramVarArgs.aR(9, this.DsU);
      paramVarArgs.aR(10, this.DsV);
      if (this.DsW != null)
      {
        paramVarArgs.kX(11, this.DsW.computeSize());
        this.DsW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(192649);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1170;
      }
    }
    label1170:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.ocT) + f.a.a.b.b.a.bA(5, this.DsQ);
      paramInt = i;
      if (this.DsR != null) {
        paramInt = i + f.a.a.a.kW(6, this.DsR.computeSize());
      }
      i = paramInt;
      if (this.DsS != null) {
        i = paramInt + f.a.a.a.kW(7, this.DsS.computeSize());
      }
      paramInt = i;
      if (this.DsT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DsT);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.DsU) + f.a.a.b.b.a.bA(10, this.DsV);
      paramInt = i;
      if (this.DsW != null) {
        paramInt = i + f.a.a.a.kW(11, this.DsW.computeSize());
      }
      AppMethodBeat.o(192649);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(192649);
          throw paramVarArgs;
        }
        AppMethodBeat.o(192649);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ast localast = (ast)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192649);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localast.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192649);
          return 0;
        case 2: 
          localast.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192649);
          return 0;
        case 3: 
          localast.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192649);
          return 0;
        case 4: 
          localast.ocT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192649);
          return 0;
        case 5: 
          localast.DsQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192649);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localast.DsR = ((qw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192649);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localast.DsS = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192649);
          return 0;
        case 8: 
          localast.DsT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192649);
          return 0;
        case 9: 
          localast.DsU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192649);
          return 0;
        case 10: 
          localast.DsV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192649);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localast.DsW = ((rl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(192649);
        return 0;
      }
      AppMethodBeat.o(192649);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ast
 * JD-Core Version:    0.7.0.1
 */