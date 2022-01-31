package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ctn
  extends bvk
{
  public int wBX;
  public SKBuiltinBuffer_t wFR;
  public int wQP;
  public long wQQ;
  public csj ycD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5280);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5280);
        throw paramVarArgs;
      }
      if (this.wFR == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(5280);
        throw paramVarArgs;
      }
      if (this.ycD == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(5280);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wQP);
      if (this.wFR != null)
      {
        paramVarArgs.iQ(4, this.wFR.computeSize());
        this.wFR.writeFields(paramVarArgs);
      }
      if (this.ycD != null)
      {
        paramVarArgs.iQ(5, this.ycD.computeSize());
        this.ycD.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.wBX);
      paramVarArgs.am(8, this.wQQ);
      AppMethodBeat.o(5280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(3, this.wQP);
      paramInt = i;
      if (this.wFR != null) {
        paramInt = i + e.a.a.a.iP(4, this.wFR.computeSize());
      }
      i = paramInt;
      if (this.ycD != null) {
        i = paramInt + e.a.a.a.iP(5, this.ycD.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(7, this.wBX);
      int j = e.a.a.b.b.a.p(8, this.wQQ);
      AppMethodBeat.o(5280);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(5280);
          throw paramVarArgs;
        }
        if (this.wFR == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(5280);
          throw paramVarArgs;
        }
        if (this.ycD == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(5280);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5280);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ctn localctn = (ctn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 6: 
        default: 
          AppMethodBeat.o(5280);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5280);
          return 0;
        case 3: 
          localctn.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5280);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctn.wFR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5280);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctn.ycD = ((csj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5280);
          return 0;
        case 7: 
          localctn.wBX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5280);
          return 0;
        }
        localctn.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(5280);
        return 0;
      }
      AppMethodBeat.o(5280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctn
 * JD-Core Version:    0.7.0.1
 */