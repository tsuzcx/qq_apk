package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class p
  extends cvp
{
  public String FpI;
  public a FpS;
  public String FpY;
  public String dEn;
  public int dlw = 268513600;
  public String paA = "请求不成功，请稍候再试";
  public String thm;
  public String xYy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91327);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91327);
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
      if (this.thm != null) {
        paramVarArgs.d(4, this.thm);
      }
      if (this.dEn != null) {
        paramVarArgs.d(5, this.dEn);
      }
      if (this.xYy != null) {
        paramVarArgs.d(7, this.xYy);
      }
      if (this.FpI != null) {
        paramVarArgs.d(8, this.FpI);
      }
      if (this.FpS != null)
      {
        paramVarArgs.lC(9, this.FpS.computeSize());
        this.FpS.writeFields(paramVarArgs);
      }
      if (this.FpY != null) {
        paramVarArgs.d(10, this.FpY);
      }
      AppMethodBeat.o(91327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.thm != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.thm);
      }
      paramInt = i;
      if (this.dEn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dEn);
      }
      i = paramInt;
      if (this.xYy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.xYy);
      }
      paramInt = i;
      if (this.FpI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FpI);
      }
      i = paramInt;
      if (this.FpS != null) {
        i = paramInt + f.a.a.a.lB(9, this.FpS.computeSize());
      }
      paramInt = i;
      if (this.FpY != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FpY);
      }
      AppMethodBeat.o(91327);
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
          AppMethodBeat.o(91327);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91327);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91327);
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
            localp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        case 2: 
          localp.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91327);
          return 0;
        case 3: 
          localp.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 4: 
          localp.thm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 5: 
          localp.dEn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 7: 
          localp.xYy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 8: 
          localp.FpI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localp.FpS = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        }
        localp.FpY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91327);
        return 0;
      }
      AppMethodBeat.o(91327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.p
 * JD-Core Version:    0.7.0.1
 */