package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class efx
  extends com.tencent.mm.bw.a
{
  public String KGX;
  public String Mmv;
  public feo NfS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153307);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mmv == null)
      {
        paramVarArgs = new b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(153307);
        throw paramVarArgs;
      }
      if (this.Mmv != null) {
        paramVarArgs.e(1, this.Mmv);
      }
      if (this.NfS != null)
      {
        paramVarArgs.ni(2, this.NfS.computeSize());
        this.NfS.writeFields(paramVarArgs);
      }
      if (this.KGX != null) {
        paramVarArgs.e(3, this.KGX);
      }
      AppMethodBeat.o(153307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mmv == null) {
        break label478;
      }
    }
    label478:
    for (int i = g.a.a.b.b.a.f(1, this.Mmv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NfS != null) {
        paramInt = i + g.a.a.a.nh(2, this.NfS.computeSize());
      }
      i = paramInt;
      if (this.KGX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KGX);
      }
      AppMethodBeat.o(153307);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Mmv == null)
        {
          paramVarArgs = new b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(153307);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        efx localefx = (efx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153307);
          return -1;
        case 1: 
          localefx.Mmv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153307);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new feo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((feo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefx.NfS = ((feo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153307);
          return 0;
        }
        localefx.KGX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153307);
        return 0;
      }
      AppMethodBeat.o(153307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efx
 * JD-Core Version:    0.7.0.1
 */