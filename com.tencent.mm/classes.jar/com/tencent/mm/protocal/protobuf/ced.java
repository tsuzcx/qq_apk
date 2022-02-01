package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ced
  extends dpc
{
  public String KPJ;
  public String Lkp;
  public String Lkq;
  public String Lkr;
  public String Lks;
  public String jfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.Lkp != null) {
        paramVarArgs.e(3, this.Lkp);
      }
      if (this.KPJ != null) {
        paramVarArgs.e(4, this.KPJ);
      }
      if (this.Lkq != null) {
        paramVarArgs.e(5, this.Lkq);
      }
      if (this.Lkr != null) {
        paramVarArgs.e(6, this.Lkr);
      }
      if (this.Lks != null) {
        paramVarArgs.e(7, this.Lks);
      }
      AppMethodBeat.o(82437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label722;
      }
    }
    label722:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.Lkp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lkp);
      }
      paramInt = i;
      if (this.KPJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KPJ);
      }
      i = paramInt;
      if (this.Lkq != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lkq);
      }
      paramInt = i;
      if (this.Lkr != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lkr);
      }
      i = paramInt;
      if (this.Lks != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lks);
      }
      AppMethodBeat.o(82437);
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
          AppMethodBeat.o(82437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ced localced = (ced)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82437);
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
            localced.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82437);
          return 0;
        case 2: 
          localced.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 3: 
          localced.Lkp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 4: 
          localced.KPJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 5: 
          localced.Lkq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 6: 
          localced.Lkr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82437);
          return 0;
        }
        localced.Lks = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82437);
        return 0;
      }
      AppMethodBeat.o(82437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ced
 * JD-Core Version:    0.7.0.1
 */