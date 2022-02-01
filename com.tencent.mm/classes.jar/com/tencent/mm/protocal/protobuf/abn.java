package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abn
  extends cvp
{
  public String CPy;
  public LinkedList<sq> Gbj;
  public int Gbk;
  public int Gbl;
  public int version;
  
  public abn()
  {
    AppMethodBeat.i(32177);
    this.Gbj = new LinkedList();
    AppMethodBeat.o(32177);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32178);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Gbj);
      paramVarArgs.aS(3, this.version);
      paramVarArgs.aS(4, this.Gbk);
      paramVarArgs.aS(5, this.Gbl);
      if (this.CPy != null) {
        paramVarArgs.d(6, this.CPy);
      }
      AppMethodBeat.o(32178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Gbj) + f.a.a.b.b.a.bz(3, this.version) + f.a.a.b.b.a.bz(4, this.Gbk) + f.a.a.b.b.a.bz(5, this.Gbl);
      paramInt = i;
      if (this.CPy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CPy);
      }
      AppMethodBeat.o(32178);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gbj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abn localabn = (abn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32178);
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
            localabn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabn.Gbj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 3: 
          localabn.version = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32178);
          return 0;
        case 4: 
          localabn.Gbk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32178);
          return 0;
        case 5: 
          localabn.Gbl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32178);
          return 0;
        }
        localabn.CPy = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32178);
        return 0;
      }
      AppMethodBeat.o(32178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abn
 * JD-Core Version:    0.7.0.1
 */