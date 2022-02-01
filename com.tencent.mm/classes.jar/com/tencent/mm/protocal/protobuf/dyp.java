package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dyp
  extends dyy
{
  public String ByI;
  public String TNi;
  public int TNk;
  public String TNu;
  public int Uee;
  public int Uef;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91672);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91672);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ByI != null) {
        paramVarArgs.f(2, this.ByI);
      }
      if (this.TNi != null) {
        paramVarArgs.f(3, this.TNi);
      }
      paramVarArgs.aY(4, this.Uee);
      paramVarArgs.aY(5, this.Uef);
      paramVarArgs.aY(6, this.TNk);
      if (this.TNu != null) {
        paramVarArgs.f(7, this.TNu);
      }
      AppMethodBeat.o(91672);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label648;
      }
    }
    label648:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ByI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ByI);
      }
      i = paramInt;
      if (this.TNi != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TNi);
      }
      i = i + g.a.a.b.b.a.bM(4, this.Uee) + g.a.a.b.b.a.bM(5, this.Uef) + g.a.a.b.b.a.bM(6, this.TNk);
      paramInt = i;
      if (this.TNu != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TNu);
      }
      AppMethodBeat.o(91672);
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
          AppMethodBeat.o(91672);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91672);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dyp localdyp = (dyp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91672);
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
            localdyp.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91672);
          return 0;
        case 2: 
          localdyp.ByI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 3: 
          localdyp.TNi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 4: 
          localdyp.Uee = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91672);
          return 0;
        case 5: 
          localdyp.Uef = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91672);
          return 0;
        case 6: 
          localdyp.TNk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91672);
          return 0;
        }
        localdyp.TNu = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91672);
        return 0;
      }
      AppMethodBeat.o(91672);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyp
 * JD-Core Version:    0.7.0.1
 */