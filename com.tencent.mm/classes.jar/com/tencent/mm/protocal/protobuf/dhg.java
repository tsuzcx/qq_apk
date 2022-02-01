package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhg
  extends com.tencent.mm.cd.a
{
  public String GIL;
  public LinkedList<dhg> PgO;
  public String TOo;
  public LinkedList<dhf> TOp;
  public int TOq;
  public int TOr;
  public int dXr;
  public String type;
  
  public dhg()
  {
    AppMethodBeat.i(117537);
    this.TOp = new LinkedList();
    this.PgO = new LinkedList();
    AppMethodBeat.o(117537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TOo != null) {
        paramVarArgs.f(1, this.TOo);
      }
      if (this.GIL != null) {
        paramVarArgs.f(2, this.GIL);
      }
      paramVarArgs.e(3, 8, this.TOp);
      paramVarArgs.aY(4, this.dXr);
      if (this.type != null) {
        paramVarArgs.f(5, this.type);
      }
      paramVarArgs.e(6, 8, this.PgO);
      paramVarArgs.aY(7, this.TOq);
      paramVarArgs.aY(8, this.TOr);
      AppMethodBeat.o(117538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TOo == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = g.a.a.b.b.a.g(1, this.TOo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GIL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.GIL);
      }
      i = i + g.a.a.a.c(3, 8, this.TOp) + g.a.a.b.b.a.bM(4, this.dXr);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.type);
      }
      i = g.a.a.a.c(6, 8, this.PgO);
      int j = g.a.a.b.b.a.bM(7, this.TOq);
      int k = g.a.a.b.b.a.bM(8, this.TOr);
      AppMethodBeat.o(117538);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TOp.clear();
        this.PgO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhg localdhg = (dhg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117538);
          return -1;
        case 1: 
          localdhg.TOo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 2: 
          localdhg.GIL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhf)localObject2).parseFrom((byte[])localObject1);
            }
            localdhg.TOp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 4: 
          localdhg.dXr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117538);
          return 0;
        case 5: 
          localdhg.type = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhg)localObject2).parseFrom((byte[])localObject1);
            }
            localdhg.PgO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 7: 
          localdhg.TOq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117538);
          return 0;
        }
        localdhg.TOr = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117538);
        return 0;
      }
      AppMethodBeat.o(117538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhg
 * JD-Core Version:    0.7.0.1
 */