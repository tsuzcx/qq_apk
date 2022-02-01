package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwc
  extends dyy
{
  public String Cqt;
  public String TfO;
  public String TfP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32242);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32242);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TfO != null) {
        paramVarArgs.f(2, this.TfO);
      }
      if (this.TfP != null) {
        paramVarArgs.f(3, this.TfP);
      }
      if (this.Cqt != null) {
        paramVarArgs.f(4, this.Cqt);
      }
      AppMethodBeat.o(32242);
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
      if (this.TfO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TfO);
      }
      i = paramInt;
      if (this.TfP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TfP);
      }
      paramInt = i;
      if (this.Cqt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Cqt);
      }
      AppMethodBeat.o(32242);
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
          AppMethodBeat.o(32242);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32242);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bwc localbwc = (bwc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32242);
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
            localbwc.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32242);
          return 0;
        case 2: 
          localbwc.TfO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32242);
          return 0;
        case 3: 
          localbwc.TfP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32242);
          return 0;
        }
        localbwc.Cqt = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32242);
        return 0;
      }
      AppMethodBeat.o(32242);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwc
 * JD-Core Version:    0.7.0.1
 */