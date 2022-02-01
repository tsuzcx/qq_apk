package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class i
  extends cld
{
  public String Csi;
  public String Csk;
  public z Cst;
  public a Csu;
  public int dcG = 268513600;
  public String nTK = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91320);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91320);
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
      if (this.Csi != null) {
        paramVarArgs.d(4, this.Csi);
      }
      if (this.Csk != null) {
        paramVarArgs.d(6, this.Csk);
      }
      if (this.Cst != null)
      {
        paramVarArgs.kX(7, this.Cst.computeSize());
        this.Cst.writeFields(paramVarArgs);
      }
      if (this.Csu != null)
      {
        paramVarArgs.kX(8, this.Csu.computeSize());
        this.Csu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91320);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.Csi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Csi);
      }
      paramInt = i;
      if (this.Csk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Csk);
      }
      i = paramInt;
      if (this.Cst != null) {
        i = paramInt + f.a.a.a.kW(7, this.Cst.computeSize());
      }
      paramInt = i;
      if (this.Csu != null) {
        paramInt = i + f.a.a.a.kW(8, this.Csu.computeSize());
      }
      AppMethodBeat.o(91320);
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
          AppMethodBeat.o(91320);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91320);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(91320);
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
            locali.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91320);
          return 0;
        case 2: 
          locali.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91320);
          return 0;
        case 3: 
          locali.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 4: 
          locali.Csi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 6: 
          locali.Csk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new z();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locali.Cst = ((z)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91320);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.Csu = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91320);
        return 0;
      }
      AppMethodBeat.o(91320);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.i
 * JD-Core Version:    0.7.0.1
 */