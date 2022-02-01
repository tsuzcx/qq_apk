package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckq
  extends com.tencent.mm.cd.a
{
  public LinkedList<cks> Tsh;
  public int oey;
  public String uuid;
  
  public ckq()
  {
    AppMethodBeat.i(82427);
    this.Tsh = new LinkedList();
    AppMethodBeat.o(82427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82428);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.f(1, this.uuid);
      }
      paramVarArgs.aY(2, this.oey);
      paramVarArgs.e(3, 8, this.Tsh);
      AppMethodBeat.o(82428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.b.b.a.g(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.oey);
      int j = g.a.a.a.c(3, 8, this.Tsh);
      AppMethodBeat.o(82428);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tsh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ckq localckq = (ckq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82428);
          return -1;
        case 1: 
          localckq.uuid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82428);
          return 0;
        case 2: 
          localckq.oey = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82428);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cks localcks = new cks();
          if ((localObject != null) && (localObject.length > 0)) {
            localcks.parseFrom((byte[])localObject);
          }
          localckq.Tsh.add(localcks);
          paramInt += 1;
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      AppMethodBeat.o(82428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckq
 * JD-Core Version:    0.7.0.1
 */