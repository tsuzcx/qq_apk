package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvm
  extends dop
{
  public String KPu;
  public String MAN;
  public int dUS;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KPu != null) {
        paramVarArgs.e(2, this.KPu);
      }
      if (this.MAN != null) {
        paramVarArgs.e(3, this.MAN);
      }
      paramVarArgs.aM(4, this.dUS);
      if (this.token != null) {
        paramVarArgs.e(5, this.token);
      }
      AppMethodBeat.o(72528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KPu != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KPu);
      }
      i = paramInt;
      if (this.MAN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MAN);
      }
      i += g.a.a.b.b.a.bu(4, this.dUS);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.token);
      }
      AppMethodBeat.o(72528);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72528);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvm localcvm = (cvm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72528);
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
            localcvm.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72528);
          return 0;
        case 2: 
          localcvm.KPu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72528);
          return 0;
        case 3: 
          localcvm.MAN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72528);
          return 0;
        case 4: 
          localcvm.dUS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72528);
          return 0;
        }
        localcvm.token = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72528);
        return 0;
      }
      AppMethodBeat.o(72528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvm
 * JD-Core Version:    0.7.0.1
 */