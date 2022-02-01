package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class div
  extends com.tencent.mm.cd.a
{
  public long TQn;
  public diu TQo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.TQn);
      if (this.TQo != null)
      {
        paramVarArgs.oE(2, this.TQo.computeSize());
        this.TQo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(186531);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.TQn) + 0;
      paramInt = i;
      if (this.TQo != null) {
        paramInt = i + g.a.a.a.oD(2, this.TQo.computeSize());
      }
      AppMethodBeat.o(186531);
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
      AppMethodBeat.o(186531);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      div localdiv = (div)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(186531);
        return -1;
      case 1: 
        localdiv.TQn = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(186531);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        diu localdiu = new diu();
        if ((localObject != null) && (localObject.length > 0)) {
          localdiu.parseFrom((byte[])localObject);
        }
        localdiv.TQo = localdiu;
        paramInt += 1;
      }
      AppMethodBeat.o(186531);
      return 0;
    }
    AppMethodBeat.o(186531);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.div
 * JD-Core Version:    0.7.0.1
 */