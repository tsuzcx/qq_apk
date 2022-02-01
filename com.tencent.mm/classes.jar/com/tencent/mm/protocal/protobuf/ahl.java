package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahl
  extends com.tencent.mm.cd.a
{
  public int Ssb;
  public LinkedList<acg> Ssc;
  public String title;
  public String tnY;
  
  public ahl()
  {
    AppMethodBeat.i(113996);
    this.Ssc = new LinkedList();
    AppMethodBeat.o(113996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113997);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.tnY != null) {
        paramVarArgs.f(2, this.tnY);
      }
      paramVarArgs.aY(3, this.Ssb);
      paramVarArgs.e(4, 8, this.Ssc);
      AppMethodBeat.o(113997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tnY != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.tnY);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Ssb);
      int j = g.a.a.a.c(4, 8, this.Ssc);
      AppMethodBeat.o(113997);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ssc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ahl localahl = (ahl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113997);
          return -1;
        case 1: 
          localahl.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 2: 
          localahl.tnY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 3: 
          localahl.Ssb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(113997);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          acg localacg = new acg();
          if ((localObject != null) && (localObject.length > 0)) {
            localacg.parseFrom((byte[])localObject);
          }
          localahl.Ssc.add(localacg);
          paramInt += 1;
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      AppMethodBeat.o(113997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahl
 * JD-Core Version:    0.7.0.1
 */