package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cav
  extends dyy
{
  public czd Tjg;
  public eza Tjh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134246);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.Tjg == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfo");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.Tjh == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfoExt");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tjg != null)
      {
        paramVarArgs.oE(2, this.Tjg.computeSize());
        this.Tjg.writeFields(paramVarArgs);
      }
      if (this.Tjh != null)
      {
        paramVarArgs.oE(3, this.Tjh.computeSize());
        this.Tjh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134246);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label696;
      }
    }
    label696:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tjg != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tjg.computeSize());
      }
      i = paramInt;
      if (this.Tjh != null) {
        i = paramInt + g.a.a.a.oD(3, this.Tjh.computeSize());
      }
      AppMethodBeat.o(134246);
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
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.Tjg == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfo");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.Tjh == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfoExt");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134246);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cav localcav = (cav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134246);
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
            localcav.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new czd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((czd)localObject2).parseFrom((byte[])localObject1);
            }
            localcav.Tjg = ((czd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eza();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eza)localObject2).parseFrom((byte[])localObject1);
          }
          localcav.Tjh = ((eza)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(134246);
        return 0;
      }
      AppMethodBeat.o(134246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cav
 * JD-Core Version:    0.7.0.1
 */