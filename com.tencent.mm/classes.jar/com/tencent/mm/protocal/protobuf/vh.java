package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vh
  extends cvp
{
  public String FUC;
  public String FUF;
  public String FUH;
  public String FUI;
  public String FUL;
  public String FUM;
  public String FUN;
  public LinkedList<Integer> FUk;
  public int FUm;
  public String FUw;
  public String desc;
  public int dlw;
  public String paA;
  public String xYy;
  
  public vh()
  {
    AppMethodBeat.i(72440);
    this.FUk = new LinkedList();
    AppMethodBeat.o(72440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72441);
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
      if (this.FUC != null) {
        paramVarArgs.d(4, this.FUC);
      }
      paramVarArgs.e(5, 2, this.FUk);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      if (this.FUL != null) {
        paramVarArgs.d(7, this.FUL);
      }
      if (this.xYy != null) {
        paramVarArgs.d(8, this.xYy);
      }
      if (this.FUF != null) {
        paramVarArgs.d(9, this.FUF);
      }
      if (this.FUH != null) {
        paramVarArgs.d(10, this.FUH);
      }
      if (this.FUI != null) {
        paramVarArgs.d(11, this.FUI);
      }
      paramVarArgs.aS(12, this.FUm);
      if (this.FUw != null) {
        paramVarArgs.d(13, this.FUw);
      }
      if (this.FUM != null) {
        paramVarArgs.d(14, this.FUM);
      }
      if (this.FUN != null) {
        paramVarArgs.d(15, this.FUN);
      }
      AppMethodBeat.o(72441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1189;
      }
    }
    label1189:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.FUC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FUC);
      }
      i += f.a.a.a.c(5, 2, this.FUk);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt;
      if (this.FUL != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FUL);
      }
      paramInt = i;
      if (this.xYy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.xYy);
      }
      i = paramInt;
      if (this.FUF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FUF);
      }
      paramInt = i;
      if (this.FUH != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FUH);
      }
      i = paramInt;
      if (this.FUI != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FUI);
      }
      i += f.a.a.b.b.a.bz(12, this.FUm);
      paramInt = i;
      if (this.FUw != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FUw);
      }
      i = paramInt;
      if (this.FUM != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FUM);
      }
      paramInt = i;
      if (this.FUN != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FUN);
      }
      AppMethodBeat.o(72441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vh localvh = (vh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72441);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72441);
          return 0;
        case 2: 
          localvh.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72441);
          return 0;
        case 3: 
          localvh.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 4: 
          localvh.FUC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 5: 
          localvh.FUk.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(72441);
          return 0;
        case 6: 
          localvh.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 7: 
          localvh.FUL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 8: 
          localvh.xYy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 9: 
          localvh.FUF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 10: 
          localvh.FUH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 11: 
          localvh.FUI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 12: 
          localvh.FUm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72441);
          return 0;
        case 13: 
          localvh.FUw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 14: 
          localvh.FUM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72441);
          return 0;
        }
        localvh.FUN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72441);
        return 0;
      }
      AppMethodBeat.o(72441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vh
 * JD-Core Version:    0.7.0.1
 */