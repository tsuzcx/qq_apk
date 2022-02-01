package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eoh
  extends com.tencent.mm.cd.a
{
  public long Id;
  public eoi UqX;
  public eoi UqY;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UqX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(118471);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.Id);
      paramVarArgs.aY(2, this.rWu);
      if (this.UqX != null)
      {
        paramVarArgs.oE(3, this.UqX.computeSize());
        this.UqX.writeFields(paramVarArgs);
      }
      if (this.UqY != null)
      {
        paramVarArgs.oE(4, this.UqY.computeSize());
        this.UqY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Id) + 0 + g.a.a.b.b.a.bM(2, this.rWu);
      paramInt = i;
      if (this.UqX != null) {
        paramInt = i + g.a.a.a.oD(3, this.UqX.computeSize());
      }
      i = paramInt;
      if (this.UqY != null) {
        i = paramInt + g.a.a.a.oD(4, this.UqY.computeSize());
      }
      AppMethodBeat.o(118471);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.UqX == null)
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
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eoh localeoh = (eoh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      eoi localeoi;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118471);
        return -1;
      case 1: 
        localeoh.Id = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(118471);
        return 0;
      case 2: 
        localeoh.rWu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118471);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeoi = new eoi();
          if ((localObject != null) && (localObject.length > 0)) {
            localeoi.parseFrom((byte[])localObject);
          }
          localeoh.UqX = localeoi;
          paramInt += 1;
        }
        AppMethodBeat.o(118471);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localeoi = new eoi();
        if ((localObject != null) && (localObject.length > 0)) {
          localeoi.parseFrom((byte[])localObject);
        }
        localeoh.UqY = localeoi;
        paramInt += 1;
      }
      AppMethodBeat.o(118471);
      return 0;
    }
    AppMethodBeat.o(118471);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoh
 * JD-Core Version:    0.7.0.1
 */