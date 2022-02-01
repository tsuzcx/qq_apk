package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cbf
  extends dyy
{
  public String fileid;
  public String nickname;
  public String oDV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152595);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152595);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.oDV != null) {
        paramVarArgs.f(3, this.oDV);
      }
      if (this.fileid != null) {
        paramVarArgs.f(4, this.fileid);
      }
      AppMethodBeat.o(152595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label516;
      }
    }
    label516:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.oDV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.oDV);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fileid);
      }
      AppMethodBeat.o(152595);
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
          AppMethodBeat.o(152595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cbf localcbf = (cbf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152595);
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
            localcbf.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(152595);
          return 0;
        case 2: 
          localcbf.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152595);
          return 0;
        case 3: 
          localcbf.oDV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152595);
          return 0;
        }
        localcbf.fileid = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152595);
        return 0;
      }
      AppMethodBeat.o(152595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbf
 * JD-Core Version:    0.7.0.1
 */