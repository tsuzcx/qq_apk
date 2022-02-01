package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fjf
  extends com.tencent.mm.bx.a
{
  public long Id;
  public fjg abJW;
  public fjg abJX;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118471);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abJW == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.Id);
      paramVarArgs.bS(2, this.vhJ);
      if (this.abJW != null)
      {
        paramVarArgs.qD(3, this.abJW.computeSize());
        this.abJW.writeFields(paramVarArgs);
      }
      if (this.abJX != null)
      {
        paramVarArgs.qD(4, this.abJX.computeSize());
        this.abJX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Id) + 0 + i.a.a.b.b.a.cJ(2, this.vhJ);
      paramInt = i;
      if (this.abJW != null) {
        paramInt = i + i.a.a.a.qC(3, this.abJW.computeSize());
      }
      i = paramInt;
      if (this.abJX != null) {
        i = paramInt + i.a.a.a.qC(4, this.abJX.computeSize());
      }
      AppMethodBeat.o(118471);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abJW == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fjf localfjf = (fjf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fjg localfjg;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118471);
        return -1;
      case 1: 
        localfjf.Id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(118471);
        return 0;
      case 2: 
        localfjf.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118471);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfjg = new fjg();
          if ((localObject != null) && (localObject.length > 0)) {
            localfjg.parseFrom((byte[])localObject);
          }
          localfjf.abJW = localfjg;
          paramInt += 1;
        }
        AppMethodBeat.o(118471);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localfjg = new fjg();
        if ((localObject != null) && (localObject.length > 0)) {
          localfjg.parseFrom((byte[])localObject);
        }
        localfjf.abJX = localfjg;
        paramInt += 1;
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    AppMethodBeat.o(118471);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjf
 * JD-Core Version:    0.7.0.1
 */