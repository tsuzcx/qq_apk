package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cqy
  extends dyl
{
  public int fSo;
  public String lmG;
  public String username;
  public String vpp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32336);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.vpp == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.lmG == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.vpp != null) {
        paramVarArgs.f(3, this.vpp);
      }
      paramVarArgs.aY(4, this.fSo);
      if (this.lmG != null) {
        paramVarArgs.f(5, this.lmG);
      }
      AppMethodBeat.o(32336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label675;
      }
    }
    label675:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.vpp != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.vpp);
      }
      i += g.a.a.b.b.a.bM(4, this.fSo);
      paramInt = i;
      if (this.lmG != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.lmG);
      }
      AppMethodBeat.o(32336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.vpp == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.lmG == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cqy localcqy = (cqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32336);
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
            localcqy.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32336);
          return 0;
        case 2: 
          localcqy.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 3: 
          localcqy.vpp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 4: 
          localcqy.fSo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32336);
          return 0;
        }
        localcqy.lmG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32336);
        return 0;
      }
      AppMethodBeat.o(32336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqy
 * JD-Core Version:    0.7.0.1
 */