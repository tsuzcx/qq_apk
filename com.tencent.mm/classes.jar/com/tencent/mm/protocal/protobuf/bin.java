package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bin
  extends cld
{
  public String CFH;
  public String CXk;
  public String CXl;
  public String CXm;
  public String CXn;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.CXk != null) {
        paramVarArgs.d(3, this.CXk);
      }
      if (this.CFH != null) {
        paramVarArgs.d(4, this.CFH);
      }
      if (this.CXl != null) {
        paramVarArgs.d(5, this.CXl);
      }
      if (this.CXm != null) {
        paramVarArgs.d(6, this.CXm);
      }
      if (this.CXn != null) {
        paramVarArgs.d(7, this.CXn);
      }
      AppMethodBeat.o(82437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.CXk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CXk);
      }
      paramInt = i;
      if (this.CFH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CFH);
      }
      i = paramInt;
      if (this.CXl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CXl);
      }
      paramInt = i;
      if (this.CXm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CXm);
      }
      i = paramInt;
      if (this.CXn != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CXn);
      }
      AppMethodBeat.o(82437);
      return i;
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
          AppMethodBeat.o(82437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bin localbin = (bin)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82437);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbin.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82437);
          return 0;
        case 2: 
          localbin.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 3: 
          localbin.CXk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 4: 
          localbin.CFH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 5: 
          localbin.CXl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 6: 
          localbin.CXm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82437);
          return 0;
        }
        localbin.CXn = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82437);
        return 0;
      }
      AppMethodBeat.o(82437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bin
 * JD-Core Version:    0.7.0.1
 */