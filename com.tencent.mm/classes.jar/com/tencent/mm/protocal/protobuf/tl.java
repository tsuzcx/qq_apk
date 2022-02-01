package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class tl
  extends dyl
{
  public String RLK;
  public int Sdk;
  public int Sdl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91387);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqKey");
        AppMethodBeat.o(91387);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Sdk);
      paramVarArgs.aY(3, this.Sdl);
      if (this.RLK != null) {
        paramVarArgs.f(4, this.RLK);
      }
      AppMethodBeat.o(91387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Sdk) + g.a.a.b.b.a.bM(3, this.Sdl);
      paramInt = i;
      if (this.RLK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RLK);
      }
      AppMethodBeat.o(91387);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RLK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqKey");
          AppMethodBeat.o(91387);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91387);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        tl localtl = (tl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91387);
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
            localtl.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91387);
          return 0;
        case 2: 
          localtl.Sdk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91387);
          return 0;
        case 3: 
          localtl.Sdl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91387);
          return 0;
        }
        localtl.RLK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91387);
        return 0;
      }
      AppMethodBeat.o(91387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tl
 * JD-Core Version:    0.7.0.1
 */