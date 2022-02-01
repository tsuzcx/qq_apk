package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class yg
  extends dpc
{
  public String Ljj;
  public String Ljk;
  public String Ljl;
  public String xNG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124470);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ljj != null) {
        paramVarArgs.e(2, this.Ljj);
      }
      if (this.xNG != null) {
        paramVarArgs.e(3, this.xNG);
      }
      if (this.Ljk != null) {
        paramVarArgs.e(4, this.Ljk);
      }
      if (this.Ljl != null) {
        paramVarArgs.e(5, this.Ljl);
      }
      AppMethodBeat.o(124470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ljj != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Ljj);
      }
      i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNG);
      }
      paramInt = i;
      if (this.Ljk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Ljk);
      }
      i = paramInt;
      if (this.Ljl != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Ljl);
      }
      AppMethodBeat.o(124470);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124470);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yg localyg = (yg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124470);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localyg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124470);
          return 0;
        case 2: 
          localyg.Ljj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124470);
          return 0;
        case 3: 
          localyg.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124470);
          return 0;
        case 4: 
          localyg.Ljk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124470);
          return 0;
        }
        localyg.Ljl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124470);
        return 0;
      }
      AppMethodBeat.o(124470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yg
 * JD-Core Version:    0.7.0.1
 */