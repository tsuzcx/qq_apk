package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cvl
  extends com.tencent.mm.cd.a
{
  public long TCb;
  public LinkedList<b> TDn;
  public cla TDo;
  public long TDp;
  public long fwf;
  public long id;
  
  public cvl()
  {
    AppMethodBeat.i(110903);
    this.TDn = new LinkedList();
    AppMethodBeat.o(110903);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110904);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.id);
      paramVarArgs.e(2, 6, this.TDn);
      if (this.TDo != null)
      {
        paramVarArgs.oE(3, this.TDo.computeSize());
        this.TDo.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(4, this.fwf);
      paramVarArgs.bm(5, this.TCb);
      paramVarArgs.bm(6, this.TDp);
      AppMethodBeat.o(110904);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.id) + 0 + g.a.a.a.c(2, 6, this.TDn);
      paramInt = i;
      if (this.TDo != null) {
        paramInt = i + g.a.a.a.oD(3, this.TDo.computeSize());
      }
      i = g.a.a.b.b.a.p(4, this.fwf);
      int j = g.a.a.b.b.a.p(5, this.TCb);
      int k = g.a.a.b.b.a.p(6, this.TDp);
      AppMethodBeat.o(110904);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TDn.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110904);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      cvl localcvl = (cvl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110904);
        return -1;
      case 1: 
        localcvl.id = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110904);
        return 0;
      case 2: 
        localcvl.TDn.add(((g.a.a.a.a)localObject).abFh.iUw());
        AppMethodBeat.o(110904);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cla localcla = new cla();
          if ((localObject != null) && (localObject.length > 0)) {
            localcla.parseFrom((byte[])localObject);
          }
          localcvl.TDo = localcla;
          paramInt += 1;
        }
        AppMethodBeat.o(110904);
        return 0;
      case 4: 
        localcvl.fwf = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110904);
        return 0;
      case 5: 
        localcvl.TCb = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110904);
        return 0;
      }
      localcvl.TDp = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(110904);
      return 0;
    }
    AppMethodBeat.o(110904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvl
 * JD-Core Version:    0.7.0.1
 */