package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class efy
  extends cvp
{
  public int HQW;
  public int HQX;
  public int HgA;
  public String dxg;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123686);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aS(4, this.version);
      paramVarArgs.aS(5, this.HQW);
      paramVarArgs.aS(6, this.HgA);
      paramVarArgs.aS(7, this.HQX);
      if (this.dxg != null) {
        paramVarArgs.d(8, this.dxg);
      }
      AppMethodBeat.o(123686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bz(4, this.version) + f.a.a.b.b.a.bz(5, this.HQW) + f.a.a.b.b.a.bz(6, this.HgA) + f.a.a.b.b.a.bz(7, this.HQX);
      paramInt = i;
      if (this.dxg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dxg);
      }
      AppMethodBeat.o(123686);
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
          AppMethodBeat.o(123686);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123686);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        efy localefy = (efy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123686);
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
            localefy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123686);
          return 0;
        case 2: 
          localefy.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 3: 
          localefy.md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 4: 
          localefy.version = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123686);
          return 0;
        case 5: 
          localefy.HQW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123686);
          return 0;
        case 6: 
          localefy.HgA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123686);
          return 0;
        case 7: 
          localefy.HQX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123686);
          return 0;
        }
        localefy.dxg = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123686);
        return 0;
      }
      AppMethodBeat.o(123686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efy
 * JD-Core Version:    0.7.0.1
 */