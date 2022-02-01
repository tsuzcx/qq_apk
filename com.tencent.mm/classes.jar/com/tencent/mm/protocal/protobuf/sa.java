package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sa
  extends cvp
{
  public int CreateTime;
  public String FAe;
  public String FOH;
  public int FOM;
  public String FOw;
  public String Fvn;
  public String uki;
  public String ukj;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152512);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152512);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FOw != null) {
        paramVarArgs.d(3, this.FOw);
      }
      if (this.ukj != null) {
        paramVarArgs.d(4, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(5, this.uki);
      }
      paramVarArgs.aS(9, this.CreateTime);
      paramVarArgs.aY(10, this.xbt);
      if (this.FOH != null) {
        paramVarArgs.d(11, this.FOH);
      }
      if (this.FAe != null) {
        paramVarArgs.d(12, this.FAe);
      }
      if (this.Fvn != null) {
        paramVarArgs.d(13, this.Fvn);
      }
      paramVarArgs.aS(14, this.FOM);
      AppMethodBeat.o(152512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FOw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FOw);
      }
      i = paramInt;
      if (this.ukj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ukj);
      }
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uki);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.CreateTime) + f.a.a.b.b.a.p(10, this.xbt);
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FOH);
      }
      i = paramInt;
      if (this.FAe != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FAe);
      }
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Fvn);
      }
      i = f.a.a.b.b.a.bz(14, this.FOM);
      AppMethodBeat.o(152512);
      return paramInt + i;
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
          AppMethodBeat.o(152512);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152512);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sa localsa = (sa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152512);
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
            localsa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152512);
          return 0;
        case 3: 
          localsa.FOw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 4: 
          localsa.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 5: 
          localsa.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 9: 
          localsa.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152512);
          return 0;
        case 10: 
          localsa.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(152512);
          return 0;
        case 11: 
          localsa.FOH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 12: 
          localsa.FAe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 13: 
          localsa.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152512);
          return 0;
        }
        localsa.FOM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152512);
        return 0;
      }
      AppMethodBeat.o(152512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sa
 * JD-Core Version:    0.7.0.1
 */