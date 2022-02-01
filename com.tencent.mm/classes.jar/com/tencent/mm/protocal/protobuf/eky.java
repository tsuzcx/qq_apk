package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eky
  extends dyy
{
  public int JWa;
  public int RLe;
  public String UmM;
  public int rVx;
  public LinkedList<ekw> rVy;
  
  public eky()
  {
    AppMethodBeat.i(125819);
    this.rVy = new LinkedList();
    AppMethodBeat.o(125819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125820);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125820);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      if (this.UmM != null) {
        paramVarArgs.f(3, this.UmM);
      }
      paramVarArgs.aY(4, this.rVx);
      paramVarArgs.e(5, 8, this.rVy);
      paramVarArgs.aY(6, this.JWa);
      AppMethodBeat.o(125820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe);
      paramInt = i;
      if (this.UmM != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UmM);
      }
      i = g.a.a.b.b.a.bM(4, this.rVx);
      int j = g.a.a.a.c(5, 8, this.rVy);
      int k = g.a.a.b.b.a.bM(6, this.JWa);
      AppMethodBeat.o(125820);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rVy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eky localeky = (eky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125820);
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
            localeky.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        case 2: 
          localeky.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125820);
          return 0;
        case 3: 
          localeky.UmM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125820);
          return 0;
        case 4: 
          localeky.rVx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125820);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ekw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ekw)localObject2).parseFrom((byte[])localObject1);
            }
            localeky.rVy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        }
        localeky.JWa = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125820);
        return 0;
      }
      AppMethodBeat.o(125820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eky
 * JD-Core Version:    0.7.0.1
 */