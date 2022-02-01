package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ehp
  extends cwj
{
  public int HAa;
  public int Ild;
  public int Ile;
  public String dyl;
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aS(4, this.version);
      paramVarArgs.aS(5, this.Ild);
      paramVarArgs.aS(6, this.HAa);
      paramVarArgs.aS(7, this.Ile);
      if (this.dyl != null) {
        paramVarArgs.d(8, this.dyl);
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
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bz(4, this.version) + f.a.a.b.b.a.bz(5, this.Ild) + f.a.a.b.b.a.bz(6, this.HAa) + f.a.a.b.b.a.bz(7, this.Ile);
      paramInt = i;
      if (this.dyl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dyl);
      }
      AppMethodBeat.o(123686);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        ehp localehp = (ehp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123686);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localehp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123686);
          return 0;
        case 2: 
          localehp.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 3: 
          localehp.md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 4: 
          localehp.version = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123686);
          return 0;
        case 5: 
          localehp.Ild = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123686);
          return 0;
        case 6: 
          localehp.HAa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123686);
          return 0;
        case 7: 
          localehp.Ile = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123686);
          return 0;
        }
        localehp.dyl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123686);
        return 0;
      }
      AppMethodBeat.o(123686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehp
 * JD-Core Version:    0.7.0.1
 */