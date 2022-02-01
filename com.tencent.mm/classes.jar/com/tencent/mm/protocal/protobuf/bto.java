package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bto
  extends dop
{
  public int Height;
  public String Mae;
  public String URL;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.URL == null)
      {
        paramVarArgs = new b("Not all required fields were included: URL");
        AppMethodBeat.o(82416);
        throw paramVarArgs;
      }
      if (this.Mae == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserAgent");
        AppMethodBeat.o(82416);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.e(2, this.URL);
      }
      if (this.Mae != null) {
        paramVarArgs.e(3, this.Mae);
      }
      paramVarArgs.aM(4, this.Width);
      paramVarArgs.aM(5, this.Height);
      AppMethodBeat.o(82416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.URL);
      }
      i = paramInt;
      if (this.Mae != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mae);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Width);
      int j = g.a.a.b.b.a.bu(5, this.Height);
      AppMethodBeat.o(82416);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.URL == null)
        {
          paramVarArgs = new b("Not all required fields were included: URL");
          AppMethodBeat.o(82416);
          throw paramVarArgs;
        }
        if (this.Mae == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserAgent");
          AppMethodBeat.o(82416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bto localbto = (bto)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82416);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbto.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82416);
          return 0;
        case 2: 
          localbto.URL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82416);
          return 0;
        case 3: 
          localbto.Mae = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82416);
          return 0;
        case 4: 
          localbto.Width = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82416);
          return 0;
        }
        localbto.Height = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(82416);
        return 0;
      }
      AppMethodBeat.o(82416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bto
 * JD-Core Version:    0.7.0.1
 */