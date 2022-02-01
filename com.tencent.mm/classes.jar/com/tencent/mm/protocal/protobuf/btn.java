package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btn
  extends dyy
{
  public String mVA;
  public String mVH;
  public String mVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32237);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32237);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(2, this.mVH);
      }
      if (this.mVz != null) {
        paramVarArgs.f(3, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(4, this.mVA);
      }
      AppMethodBeat.o(32237);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label530;
      }
    }
    label530:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mVH);
      }
      i = paramInt;
      if (this.mVz != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mVz);
      }
      paramInt = i;
      if (this.mVA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mVA);
      }
      AppMethodBeat.o(32237);
      return paramInt;
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
          AppMethodBeat.o(32237);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32237);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        btn localbtn = (btn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32237);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localbtn.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32237);
          return 0;
        case 2: 
          localbtn.mVH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32237);
          return 0;
        case 3: 
          localbtn.mVz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32237);
          return 0;
        }
        localbtn.mVA = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32237);
        return 0;
      }
      AppMethodBeat.o(32237);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btn
 * JD-Core Version:    0.7.0.1
 */