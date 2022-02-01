package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class no
  extends dyl
{
  public String RUp;
  public String fwe;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124422);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUp == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124422);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RUp != null) {
        paramVarArgs.f(2, this.RUp);
      }
      if (this.fwe != null) {
        paramVarArgs.f(3, this.fwe);
      }
      paramVarArgs.aY(4, this.offset);
      AppMethodBeat.o(124422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label500;
      }
    }
    label500:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RUp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RUp);
      }
      i = paramInt;
      if (this.fwe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fwe);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.offset);
      AppMethodBeat.o(124422);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RUp == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124422);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        no localno = (no)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124422);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localno.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124422);
          return 0;
        case 2: 
          localno.RUp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124422);
          return 0;
        case 3: 
          localno.fwe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124422);
          return 0;
        }
        localno.offset = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124422);
        return 0;
      }
      AppMethodBeat.o(124422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.no
 * JD-Core Version:    0.7.0.1
 */