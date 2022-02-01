package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhe
  extends cvp
{
  public int GTD;
  public LinkedList<dfk> GTE;
  public dfk HvH;
  public long Id;
  public String hCW;
  public int nEf;
  public int xcK;
  public int xcL;
  
  public dhe()
  {
    AppMethodBeat.i(125831);
    this.GTE = new LinkedList();
    AppMethodBeat.o(125831);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125832);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.HvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: BufferUrl");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xcL);
      paramVarArgs.aS(3, this.xcK);
      if (this.hCW != null) {
        paramVarArgs.d(4, this.hCW);
      }
      if (this.HvH != null)
      {
        paramVarArgs.lC(5, this.HvH.computeSize());
        this.HvH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.GTD);
      paramVarArgs.e(7, 8, this.GTE);
      paramVarArgs.aY(8, this.Id);
      paramVarArgs.aS(9, this.nEf);
      AppMethodBeat.o(125832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xcL) + f.a.a.b.b.a.bz(3, this.xcK);
      paramInt = i;
      if (this.hCW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hCW);
      }
      i = paramInt;
      if (this.HvH != null) {
        i = paramInt + f.a.a.a.lB(5, this.HvH.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.GTD);
      int j = f.a.a.a.c(7, 8, this.GTE);
      int k = f.a.a.b.b.a.p(8, this.Id);
      int m = f.a.a.b.b.a.bz(9, this.nEf);
      AppMethodBeat.o(125832);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GTE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        if (this.HvH == null)
        {
          paramVarArgs = new b("Not all required fields were included: BufferUrl");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhe localdhe = (dhe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125832);
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
            localdhe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 2: 
          localdhe.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125832);
          return 0;
        case 3: 
          localdhe.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125832);
          return 0;
        case 4: 
          localdhe.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125832);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HvH = ((dfk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 6: 
          localdhe.GTD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125832);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.GTE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 8: 
          localdhe.Id = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125832);
          return 0;
        }
        localdhe.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125832);
        return 0;
      }
      AppMethodBeat.o(125832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhe
 * JD-Core Version:    0.7.0.1
 */