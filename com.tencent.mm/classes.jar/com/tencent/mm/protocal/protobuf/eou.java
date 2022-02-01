package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eou
  extends dyy
{
  public int RMr;
  public String SqY;
  public hh Uil;
  public hl Urp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123658);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123658);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Uil != null)
      {
        paramVarArgs.oE(2, this.Uil.computeSize());
        this.Uil.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.RMr);
      if (this.Urp != null)
      {
        paramVarArgs.oE(4, this.Urp.computeSize());
        this.Urp.writeFields(paramVarArgs);
      }
      if (this.SqY != null) {
        paramVarArgs.f(5, this.SqY);
      }
      AppMethodBeat.o(123658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label704;
      }
    }
    label704:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Uil != null) {
        i = paramInt + g.a.a.a.oD(2, this.Uil.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.RMr);
      paramInt = i;
      if (this.Urp != null) {
        paramInt = i + g.a.a.a.oD(4, this.Urp.computeSize());
      }
      i = paramInt;
      if (this.SqY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SqY);
      }
      AppMethodBeat.o(123658);
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
          AppMethodBeat.o(123658);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eou localeou = (eou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123658);
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
            localeou.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hh)localObject2).parseFrom((byte[])localObject1);
            }
            localeou.Uil = ((hh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 3: 
          localeou.RMr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123658);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hl)localObject2).parseFrom((byte[])localObject1);
            }
            localeou.Urp = ((hl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        }
        localeou.SqY = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(123658);
        return 0;
      }
      AppMethodBeat.o(123658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eou
 * JD-Core Version:    0.7.0.1
 */