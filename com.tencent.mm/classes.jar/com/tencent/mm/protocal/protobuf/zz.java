package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class zz
  extends dpc
{
  public String Lli;
  public String bxK;
  public String nzu;
  public String nzv;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123566);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123566);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.status);
      if (this.nzu != null) {
        paramVarArgs.e(3, this.nzu);
      }
      if (this.bxK != null) {
        paramVarArgs.e(4, this.bxK);
      }
      if (this.Lli != null) {
        paramVarArgs.e(5, this.Lli);
      }
      if (this.nzv != null) {
        paramVarArgs.e(6, this.nzv);
      }
      AppMethodBeat.o(123566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.status);
      paramInt = i;
      if (this.nzu != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.nzu);
      }
      i = paramInt;
      if (this.bxK != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.bxK);
      }
      paramInt = i;
      if (this.Lli != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Lli);
      }
      i = paramInt;
      if (this.nzv != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.nzv);
      }
      AppMethodBeat.o(123566);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zz localzz = (zz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123566);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123566);
          return 0;
        case 2: 
          localzz.status = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123566);
          return 0;
        case 3: 
          localzz.nzu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 4: 
          localzz.bxK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 5: 
          localzz.Lli = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123566);
          return 0;
        }
        localzz.nzv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123566);
        return 0;
      }
      AppMethodBeat.o(123566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zz
 * JD-Core Version:    0.7.0.1
 */