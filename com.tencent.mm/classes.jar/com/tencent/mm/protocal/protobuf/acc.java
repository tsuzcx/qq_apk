package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acc
  extends com.tencent.mm.cd.a
{
  public String SnL;
  public aby SnM;
  public String comment;
  public String fIY;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117861);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.timestamp);
      if (this.SnL != null) {
        paramVarArgs.f(2, this.SnL);
      }
      if (this.comment != null) {
        paramVarArgs.f(3, this.comment);
      }
      if (this.fIY != null) {
        paramVarArgs.f(4, this.fIY);
      }
      if (this.SnM != null)
      {
        paramVarArgs.oE(5, this.SnM.computeSize());
        this.SnM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.timestamp) + 0;
      paramInt = i;
      if (this.SnL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SnL);
      }
      i = paramInt;
      if (this.comment != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.comment);
      }
      paramInt = i;
      if (this.fIY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fIY);
      }
      i = paramInt;
      if (this.SnM != null) {
        i = paramInt + g.a.a.a.oD(5, this.SnM.computeSize());
      }
      AppMethodBeat.o(117861);
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
      AppMethodBeat.o(117861);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      acc localacc = (acc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117861);
        return -1;
      case 1: 
        localacc.timestamp = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(117861);
        return 0;
      case 2: 
        localacc.SnL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 3: 
        localacc.comment = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 4: 
        localacc.fIY = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117861);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        aby localaby = new aby();
        if ((localObject != null) && (localObject.length > 0)) {
          localaby.parseFrom((byte[])localObject);
        }
        localacc.SnM = localaby;
        paramInt += 1;
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    AppMethodBeat.o(117861);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acc
 * JD-Core Version:    0.7.0.1
 */