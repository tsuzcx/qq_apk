package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nx
  extends com.tencent.mm.bw.a
{
  public oa KTw;
  public String KTx;
  public String KTy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124421);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTw != null)
      {
        paramVarArgs.ni(1, this.KTw.computeSize());
        this.KTw.writeFields(paramVarArgs);
      }
      if (this.KTx != null) {
        paramVarArgs.e(2, this.KTx);
      }
      if (this.KTy != null) {
        paramVarArgs.e(3, this.KTy);
      }
      AppMethodBeat.o(124421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KTw == null) {
        break label430;
      }
    }
    label430:
    for (int i = g.a.a.a.nh(1, this.KTw.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KTx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KTx);
      }
      i = paramInt;
      if (this.KTy != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KTy);
      }
      AppMethodBeat.o(124421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        nx localnx = (nx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124421);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oa();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((oa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localnx.KTw = ((oa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124421);
          return 0;
        case 2: 
          localnx.KTx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124421);
          return 0;
        }
        localnx.KTy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124421);
        return 0;
      }
      AppMethodBeat.o(124421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nx
 * JD-Core Version:    0.7.0.1
 */