package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fap
  extends dyy
{
  public String TGl;
  public String UAD;
  public faq UAE;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152728);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152728);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.TGl != null) {
        paramVarArgs.f(3, this.TGl);
      }
      if (this.UAE != null)
      {
        paramVarArgs.oE(4, this.UAE.computeSize());
        this.UAE.writeFields(paramVarArgs);
      }
      if (this.UAD != null) {
        paramVarArgs.f(5, this.UAD);
      }
      AppMethodBeat.o(152728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.TGl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TGl);
      }
      paramInt = i;
      if (this.UAE != null) {
        paramInt = i + g.a.a.a.oD(4, this.UAE.computeSize());
      }
      i = paramInt;
      if (this.UAD != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UAD);
      }
      AppMethodBeat.o(152728);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152728);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fap localfap = (fap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152728);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localfap.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152728);
          return 0;
        case 2: 
          localfap.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152728);
          return 0;
        case 3: 
          localfap.TGl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152728);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new faq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((faq)localObject2).parseFrom((byte[])localObject1);
            }
            localfap.UAE = ((faq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152728);
          return 0;
        }
        localfap.UAD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152728);
        return 0;
      }
      AppMethodBeat.o(152728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fap
 * JD-Core Version:    0.7.0.1
 */