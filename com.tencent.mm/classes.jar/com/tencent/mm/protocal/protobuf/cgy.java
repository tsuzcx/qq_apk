package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cgy
  extends dyy
{
  public fon Top;
  public foo Toq;
  public fol Tor;
  public fqd Tos;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50093);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(50093);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Top != null)
      {
        paramVarArgs.oE(2, this.Top.computeSize());
        this.Top.writeFields(paramVarArgs);
      }
      if (this.Toq != null)
      {
        paramVarArgs.oE(3, this.Toq.computeSize());
        this.Toq.writeFields(paramVarArgs);
      }
      if (this.Tor != null)
      {
        paramVarArgs.oE(4, this.Tor.computeSize());
        this.Tor.writeFields(paramVarArgs);
      }
      if (this.Tos != null)
      {
        paramVarArgs.oE(5, this.Tos.computeSize());
        this.Tos.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50093);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label864;
      }
    }
    label864:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Top != null) {
        paramInt = i + g.a.a.a.oD(2, this.Top.computeSize());
      }
      i = paramInt;
      if (this.Toq != null) {
        i = paramInt + g.a.a.a.oD(3, this.Toq.computeSize());
      }
      paramInt = i;
      if (this.Tor != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tor.computeSize());
      }
      i = paramInt;
      if (this.Tos != null) {
        i = paramInt + g.a.a.a.oD(5, this.Tos.computeSize());
      }
      AppMethodBeat.o(50093);
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
          AppMethodBeat.o(50093);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50093);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgy localcgy = (cgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50093);
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
            localcgy.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50093);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fon();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fon)localObject2).parseFrom((byte[])localObject1);
            }
            localcgy.Top = ((fon)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50093);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foo)localObject2).parseFrom((byte[])localObject1);
            }
            localcgy.Toq = ((foo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50093);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fol)localObject2).parseFrom((byte[])localObject1);
            }
            localcgy.Tor = ((fol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50093);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqd)localObject2).parseFrom((byte[])localObject1);
          }
          localcgy.Tos = ((fqd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(50093);
        return 0;
      }
      AppMethodBeat.o(50093);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgy
 * JD-Core Version:    0.7.0.1
 */