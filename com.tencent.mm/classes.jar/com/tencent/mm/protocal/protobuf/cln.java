package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cln
  extends com.tencent.mm.cd.a
{
  public LinkedList<clp> Ttd;
  public LinkedList<Integer> Tte;
  public int scene;
  public String sessionId;
  
  public cln()
  {
    AppMethodBeat.i(209727);
    this.Ttd = new LinkedList();
    this.Tte = new LinkedList();
    AppMethodBeat.o(209727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209731);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.f(1, this.sessionId);
      }
      paramVarArgs.aY(2, this.scene);
      paramVarArgs.e(3, 8, this.Ttd);
      paramVarArgs.e(4, 2, this.Tte);
      AppMethodBeat.o(209731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label443;
      }
    }
    label443:
    for (paramInt = g.a.a.b.b.a.g(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.scene);
      int j = g.a.a.a.c(3, 8, this.Ttd);
      int k = g.a.a.a.c(4, 2, this.Tte);
      AppMethodBeat.o(209731);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ttd.clear();
        this.Tte.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(209731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cln localcln = (cln)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209731);
          return -1;
        case 1: 
          localcln.sessionId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(209731);
          return 0;
        case 2: 
          localcln.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(209731);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            clp localclp = new clp();
            if ((localObject != null) && (localObject.length > 0)) {
              localclp.parseFrom((byte[])localObject);
            }
            localcln.Ttd.add(localclp);
            paramInt += 1;
          }
          AppMethodBeat.o(209731);
          return 0;
        }
        localcln.Tte.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
        AppMethodBeat.o(209731);
        return 0;
      }
      AppMethodBeat.o(209731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cln
 * JD-Core Version:    0.7.0.1
 */