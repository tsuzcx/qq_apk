package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nq
  extends com.tencent.mm.cd.a
{
  public String RUj;
  public int RUk;
  public String RUn;
  public String RUq;
  public LinkedList<nr> RUy;
  public int RUz;
  public String jEj;
  public String tsk;
  public int ver;
  
  public nq()
  {
    AppMethodBeat.i(206377);
    this.RUy = new LinkedList();
    AppMethodBeat.o(206377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUq != null) {
        paramVarArgs.f(1, this.RUq);
      }
      if (this.tsk != null) {
        paramVarArgs.f(2, this.tsk);
      }
      paramVarArgs.aY(3, this.ver);
      if (this.RUj != null) {
        paramVarArgs.f(4, this.RUj);
      }
      if (this.jEj != null) {
        paramVarArgs.f(5, this.jEj);
      }
      paramVarArgs.aY(6, this.RUk);
      if (this.RUn != null) {
        paramVarArgs.f(7, this.RUn);
      }
      paramVarArgs.e(8, 8, this.RUy);
      paramVarArgs.aY(9, this.RUz);
      AppMethodBeat.o(124425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RUq == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = g.a.a.b.b.a.g(1, this.RUq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tsk != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.tsk);
      }
      i += g.a.a.b.b.a.bM(3, this.ver);
      paramInt = i;
      if (this.RUj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RUj);
      }
      i = paramInt;
      if (this.jEj != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jEj);
      }
      i += g.a.a.b.b.a.bM(6, this.RUk);
      paramInt = i;
      if (this.RUn != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RUn);
      }
      i = g.a.a.a.c(8, 8, this.RUy);
      int j = g.a.a.b.b.a.bM(9, this.RUz);
      AppMethodBeat.o(124425);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RUy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        nq localnq = (nq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124425);
          return -1;
        case 1: 
          localnq.RUq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 2: 
          localnq.tsk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 3: 
          localnq.ver = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124425);
          return 0;
        case 4: 
          localnq.RUj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 5: 
          localnq.jEj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 6: 
          localnq.RUk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124425);
          return 0;
        case 7: 
          localnq.RUn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            nr localnr = new nr();
            if ((localObject != null) && (localObject.length > 0)) {
              localnr.parseFrom((byte[])localObject);
            }
            localnq.RUy.add(localnr);
            paramInt += 1;
          }
          AppMethodBeat.o(124425);
          return 0;
        }
        localnq.RUz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124425);
        return 0;
      }
      AppMethodBeat.o(124425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nq
 * JD-Core Version:    0.7.0.1
 */