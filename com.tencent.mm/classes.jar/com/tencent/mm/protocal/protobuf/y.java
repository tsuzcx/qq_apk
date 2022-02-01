package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class y
  extends cld
{
  public String CsU;
  public int CsV;
  public int CsW;
  public String CsX;
  public LinkedList<k> CsY;
  public String CsZ;
  public int dcG;
  public String nTK;
  
  public y()
  {
    AppMethodBeat.i(91337);
    this.dcG = 268513600;
    this.nTK = "请求不成功，请稍候再试";
    this.CsY = new LinkedList();
    AppMethodBeat.o(91337);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91338);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91338);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      paramVarArgs.e(4, 8, this.CsY);
      if (this.CsZ != null) {
        paramVarArgs.d(5, this.CsZ);
      }
      if (this.CsU != null) {
        paramVarArgs.d(6, this.CsU);
      }
      paramVarArgs.aR(7, this.CsV);
      paramVarArgs.aR(8, this.CsW);
      if (this.CsX != null) {
        paramVarArgs.d(9, this.CsX);
      }
      AppMethodBeat.o(91338);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.CsY);
      paramInt = i;
      if (this.CsZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CsZ);
      }
      i = paramInt;
      if (this.CsU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CsU);
      }
      i = i + f.a.a.b.b.a.bA(7, this.CsV) + f.a.a.b.b.a.bA(8, this.CsW);
      paramInt = i;
      if (this.CsX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CsX);
      }
      AppMethodBeat.o(91338);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CsY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91338);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91338);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91338);
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
            localy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 2: 
          localy.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91338);
          return 0;
        case 3: 
          localy.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localy.CsY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 5: 
          localy.CsZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 6: 
          localy.CsU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 7: 
          localy.CsV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91338);
          return 0;
        case 8: 
          localy.CsW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91338);
          return 0;
        }
        localy.CsX = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91338);
        return 0;
      }
      AppMethodBeat.o(91338);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.y
 * JD-Core Version:    0.7.0.1
 */