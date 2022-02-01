package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import java.util.LinkedList;

public final class x
  extends dpc
{
  public String Bsg;
  public String Bsh;
  public String Bsi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198624);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(198624);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Bsg != null) {
        paramVarArgs.e(2, this.Bsg);
      }
      if (this.Bsh != null) {
        paramVarArgs.e(3, this.Bsh);
      }
      if (this.Bsi != null) {
        paramVarArgs.e(4, this.Bsi);
      }
      AppMethodBeat.o(198624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label538;
      }
    }
    label538:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Bsg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Bsg);
      }
      i = paramInt;
      if (this.Bsh != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Bsh);
      }
      paramInt = i;
      if (this.Bsi != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Bsi);
      }
      AppMethodBeat.o(198624);
      return paramInt;
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
          AppMethodBeat.o(198624);
          throw paramVarArgs;
        }
        AppMethodBeat.o(198624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198624);
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
            localx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(198624);
          return 0;
        case 2: 
          localx.Bsg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(198624);
          return 0;
        case 3: 
          localx.Bsh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(198624);
          return 0;
        }
        localx.Bsi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198624);
        return 0;
      }
      AppMethodBeat.o(198624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.x
 * JD-Core Version:    0.7.0.1
 */