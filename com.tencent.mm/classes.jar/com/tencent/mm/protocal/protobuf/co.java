package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class co
  extends com.tencent.mm.cd.a
{
  public db RIe;
  public String RIf;
  public b RIg;
  public boolean RIh;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247756);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIe != null)
      {
        paramVarArgs.oE(1, this.RIe.computeSize());
        this.RIe.writeFields(paramVarArgs);
      }
      if (this.RIf != null) {
        paramVarArgs.f(2, this.RIf);
      }
      paramVarArgs.bm(3, this.seq);
      if (this.RIg != null) {
        paramVarArgs.c(4, this.RIg);
      }
      paramVarArgs.co(5, this.RIh);
      AppMethodBeat.o(247756);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RIe == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.a.oD(1, this.RIe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RIf != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RIf);
      }
      i += g.a.a.b.b.a.p(3, this.seq);
      paramInt = i;
      if (this.RIg != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.RIg);
      }
      i = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(247756);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(247756);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(247756);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            db localdb = new db();
            if ((localObject != null) && (localObject.length > 0)) {
              localdb.parseFrom((byte[])localObject);
            }
            localco.RIe = localdb;
            paramInt += 1;
          }
          AppMethodBeat.o(247756);
          return 0;
        case 2: 
          localco.RIf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(247756);
          return 0;
        case 3: 
          localco.seq = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(247756);
          return 0;
        case 4: 
          localco.RIg = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(247756);
          return 0;
        }
        localco.RIh = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(247756);
        return 0;
      }
      AppMethodBeat.o(247756);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.co
 * JD-Core Version:    0.7.0.1
 */