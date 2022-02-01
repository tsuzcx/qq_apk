package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pt
  extends com.tencent.mm.cd.a
{
  public String RXY;
  public int RXZ;
  public String RYa;
  public int RYb;
  public LinkedList<mv> RYc;
  
  public pt()
  {
    AppMethodBeat.i(152509);
    this.RYc = new LinkedList();
    AppMethodBeat.o(152509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RXY != null) {
        paramVarArgs.f(1, this.RXY);
      }
      paramVarArgs.aY(2, this.RXZ);
      if (this.RYa != null) {
        paramVarArgs.f(3, this.RYa);
      }
      paramVarArgs.aY(4, this.RYb);
      paramVarArgs.e(5, 8, this.RYc);
      AppMethodBeat.o(152510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RXY == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = g.a.a.b.b.a.g(1, this.RXY) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RXZ);
      paramInt = i;
      if (this.RYa != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RYa);
      }
      i = g.a.a.b.b.a.bM(4, this.RYb);
      int j = g.a.a.a.c(5, 8, this.RYc);
      AppMethodBeat.o(152510);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RYc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        pt localpt = (pt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152510);
          return -1;
        case 1: 
          localpt.RXY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 2: 
          localpt.RXZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152510);
          return 0;
        case 3: 
          localpt.RYa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 4: 
          localpt.RYb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152510);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          mv localmv = new mv();
          if ((localObject != null) && (localObject.length > 0)) {
            localmv.parseFrom((byte[])localObject);
          }
          localpt.RYc.add(localmv);
          paramInt += 1;
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      AppMethodBeat.o(152510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pt
 * JD-Core Version:    0.7.0.1
 */