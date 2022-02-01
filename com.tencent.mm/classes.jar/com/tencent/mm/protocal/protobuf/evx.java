package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class evx
  extends dyl
{
  public String RUp;
  public nj SXD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124572);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUp == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124572);
        throw paramVarArgs;
      }
      if (this.SXD == null)
      {
        paramVarArgs = new b("Not all required fields were included: chat");
        AppMethodBeat.o(124572);
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
      if (this.SXD != null)
      {
        paramVarArgs.oE(3, this.SXD.computeSize());
        this.SXD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RUp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RUp);
      }
      i = paramInt;
      if (this.SXD != null) {
        i = paramInt + g.a.a.a.oD(3, this.SXD.computeSize());
      }
      AppMethodBeat.o(124572);
      return i;
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
          AppMethodBeat.o(124572);
          throw paramVarArgs;
        }
        if (this.SXD == null)
        {
          paramVarArgs = new b("Not all required fields were included: chat");
          AppMethodBeat.o(124572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        evx localevx = (evx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124572);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localevx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124572);
          return 0;
        case 2: 
          localevx.RUp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124572);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new nj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((nj)localObject2).parseFrom((byte[])localObject1);
          }
          localevx.SXD = ((nj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124572);
        return 0;
      }
      AppMethodBeat.o(124572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evx
 * JD-Core Version:    0.7.0.1
 */