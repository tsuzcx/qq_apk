package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eoy
  extends dyy
{
  public int RPr;
  public String RPs;
  public String Urr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91703);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91703);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Urr != null) {
        paramVarArgs.f(2, this.Urr);
      }
      paramVarArgs.aY(3, this.RPr);
      if (this.RPs != null) {
        paramVarArgs.f(4, this.RPs);
      }
      AppMethodBeat.o(91703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Urr != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Urr);
      }
      i += g.a.a.b.b.a.bM(3, this.RPr);
      paramInt = i;
      if (this.RPs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RPs);
      }
      AppMethodBeat.o(91703);
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
          AppMethodBeat.o(91703);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eoy localeoy = (eoy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91703);
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
            localeoy.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91703);
          return 0;
        case 2: 
          localeoy.Urr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91703);
          return 0;
        case 3: 
          localeoy.RPr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91703);
          return 0;
        }
        localeoy.RPs = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91703);
        return 0;
      }
      AppMethodBeat.o(91703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoy
 * JD-Core Version:    0.7.0.1
 */