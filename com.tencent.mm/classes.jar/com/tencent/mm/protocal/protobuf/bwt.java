package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwt
  extends dyl
{
  public String SaD;
  public String Sdn;
  public dp Tgx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91486);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tgx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Address");
        AppMethodBeat.o(91486);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SaD != null) {
        paramVarArgs.f(2, this.SaD);
      }
      if (this.Sdn != null) {
        paramVarArgs.f(3, this.Sdn);
      }
      if (this.Tgx != null)
      {
        paramVarArgs.oE(4, this.Tgx.computeSize());
        this.Tgx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SaD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SaD);
      }
      i = paramInt;
      if (this.Sdn != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sdn);
      }
      paramInt = i;
      if (this.Tgx != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tgx.computeSize());
      }
      AppMethodBeat.o(91486);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Tgx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Address");
          AppMethodBeat.o(91486);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwt localbwt = (bwt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91486);
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
            localbwt.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91486);
          return 0;
        case 2: 
          localbwt.SaD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91486);
          return 0;
        case 3: 
          localbwt.Sdn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91486);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dp)localObject2).parseFrom((byte[])localObject1);
          }
          localbwt.Tgx = ((dp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91486);
        return 0;
      }
      AppMethodBeat.o(91486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwt
 * JD-Core Version:    0.7.0.1
 */