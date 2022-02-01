package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekw
  extends com.tencent.mm.cd.a
{
  public String CQx;
  public long UmL;
  public int rVx;
  public LinkedList<eaf> rVy;
  
  public ekw()
  {
    AppMethodBeat.i(125816);
    this.rVy = new LinkedList();
    AppMethodBeat.o(125816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.UmL);
      if (this.CQx != null) {
        paramVarArgs.f(2, this.CQx);
      }
      paramVarArgs.aY(3, this.rVx);
      paramVarArgs.e(4, 8, this.rVy);
      AppMethodBeat.o(125817);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.UmL) + 0;
      paramInt = i;
      if (this.CQx != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CQx);
      }
      i = g.a.a.b.b.a.bM(3, this.rVx);
      int j = g.a.a.a.c(4, 8, this.rVy);
      AppMethodBeat.o(125817);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rVy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ekw localekw = (ekw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125817);
        return -1;
      case 1: 
        localekw.UmL = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(125817);
        return 0;
      case 2: 
        localekw.CQx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(125817);
        return 0;
      case 3: 
        localekw.rVx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125817);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eaf localeaf = new eaf();
        if ((localObject != null) && (localObject.length > 0)) {
          localeaf.de((byte[])localObject);
        }
        localekw.rVy.add(localeaf);
        paramInt += 1;
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    AppMethodBeat.o(125817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekw
 * JD-Core Version:    0.7.0.1
 */