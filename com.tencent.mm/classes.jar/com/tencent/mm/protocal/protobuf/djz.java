package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class djz
  extends ckq
{
  public String DAa;
  public int EdW;
  public int EdY;
  public dkz EzQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EzQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Piece");
        AppMethodBeat.o(32494);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EzQ != null)
      {
        paramVarArgs.kX(2, this.EzQ.computeSize());
        this.EzQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EdW);
      paramVarArgs.aR(4, this.EdY);
      if (this.DAa != null) {
        paramVarArgs.d(5, this.DAa);
      }
      AppMethodBeat.o(32494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label673;
      }
    }
    label673:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EzQ != null) {
        i = paramInt + f.a.a.a.kW(2, this.EzQ.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.EdW) + f.a.a.b.b.a.bA(4, this.EdY);
      paramInt = i;
      if (this.DAa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DAa);
      }
      AppMethodBeat.o(32494);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EzQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Piece");
          AppMethodBeat.o(32494);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djz localdjz = (djz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32494);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32494);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjz.EzQ = ((dkz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32494);
          return 0;
        case 3: 
          localdjz.EdW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32494);
          return 0;
        case 4: 
          localdjz.EdY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32494);
          return 0;
        }
        localdjz.DAa = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32494);
        return 0;
      }
      AppMethodBeat.o(32494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djz
 * JD-Core Version:    0.7.0.1
 */