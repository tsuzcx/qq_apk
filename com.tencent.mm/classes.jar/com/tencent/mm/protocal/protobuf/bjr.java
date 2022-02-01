package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bjr
  extends com.tencent.mm.cd.a
{
  public int STW;
  public bjs STX;
  public int STx;
  public String wording;
  public long zAO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207280);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.STW);
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      paramVarArgs.aY(3, this.STx);
      paramVarArgs.bm(4, this.zAO);
      if (this.STX != null)
      {
        paramVarArgs.oE(5, this.STX.computeSize());
        this.STX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207280);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.STW) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.STx) + g.a.a.b.b.a.p(4, this.zAO);
      paramInt = i;
      if (this.STX != null) {
        paramInt = i + g.a.a.a.oD(5, this.STX.computeSize());
      }
      AppMethodBeat.o(207280);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207280);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bjr localbjr = (bjr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207280);
        return -1;
      case 1: 
        localbjr.STW = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(207280);
        return 0;
      case 2: 
        localbjr.wording = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(207280);
        return 0;
      case 3: 
        localbjr.STx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(207280);
        return 0;
      case 4: 
        localbjr.zAO = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(207280);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bjs localbjs = new bjs();
        if ((localObject != null) && (localObject.length > 0)) {
          localbjs.parseFrom((byte[])localObject);
        }
        localbjr.STX = localbjs;
        paramInt += 1;
      }
      AppMethodBeat.o(207280);
      return 0;
    }
    AppMethodBeat.o(207280);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjr
 * JD-Core Version:    0.7.0.1
 */