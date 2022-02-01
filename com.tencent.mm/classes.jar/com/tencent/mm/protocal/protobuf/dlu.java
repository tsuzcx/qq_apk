package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlu
  extends com.tencent.mm.cd.a
{
  public String TSK;
  public LinkedList<dlv> TSL;
  public LinkedList<dmb> TSM;
  public LinkedList<dmb> TSN;
  
  public dlu()
  {
    AppMethodBeat.i(199037);
    this.TSL = new LinkedList();
    this.TSM = new LinkedList();
    this.TSN = new LinkedList();
    AppMethodBeat.o(199037);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199053);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TSK != null) {
        paramVarArgs.f(1, this.TSK);
      }
      paramVarArgs.e(2, 8, this.TSL);
      paramVarArgs.e(3, 8, this.TSM);
      paramVarArgs.e(4, 8, this.TSN);
      AppMethodBeat.o(199053);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TSK == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = g.a.a.b.b.a.g(1, this.TSK) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.TSL);
      int j = g.a.a.a.c(3, 8, this.TSM);
      int k = g.a.a.a.c(4, 8, this.TSN);
      AppMethodBeat.o(199053);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TSL.clear();
        this.TSM.clear();
        this.TSN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199053);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dlu localdlu = (dlu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199053);
          return -1;
        case 1: 
          localdlu.TSK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(199053);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlv)localObject2).parseFrom((byte[])localObject1);
            }
            localdlu.TSL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199053);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmb)localObject2).parseFrom((byte[])localObject1);
            }
            localdlu.TSM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199053);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmb)localObject2).parseFrom((byte[])localObject1);
          }
          localdlu.TSN.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199053);
        return 0;
      }
      AppMethodBeat.o(199053);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlu
 * JD-Core Version:    0.7.0.1
 */