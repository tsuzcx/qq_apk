package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhk
  extends com.tencent.mm.cd.a
{
  public String GIL;
  public int TOA;
  public LinkedList<dhi> TOB;
  public boolean TOC;
  public LinkedList<dyu> TOD;
  public LinkedList<dhj> TOw;
  public int TOx;
  public int TOy;
  public dyu TOz;
  public int state;
  
  public dhk()
  {
    AppMethodBeat.i(117544);
    this.TOw = new LinkedList();
    this.TOB = new LinkedList();
    this.TOD = new LinkedList();
    AppMethodBeat.o(117544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GIL == null)
      {
        paramVarArgs = new b("Not all required fields were included: pid");
        AppMethodBeat.o(117545);
        throw paramVarArgs;
      }
      if (this.GIL != null) {
        paramVarArgs.f(1, this.GIL);
      }
      paramVarArgs.aY(2, this.state);
      paramVarArgs.e(3, 8, this.TOw);
      paramVarArgs.aY(4, this.TOx);
      paramVarArgs.aY(5, this.TOy);
      if (this.TOz != null)
      {
        paramVarArgs.oE(6, this.TOz.computeSize());
        this.TOz.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.TOA);
      paramVarArgs.e(8, 8, this.TOB);
      paramVarArgs.co(9, this.TOC);
      paramVarArgs.e(10, 8, this.TOD);
      AppMethodBeat.o(117545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GIL == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = g.a.a.b.b.a.g(1, this.GIL) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.state) + g.a.a.a.c(3, 8, this.TOw) + g.a.a.b.b.a.bM(4, this.TOx) + g.a.a.b.b.a.bM(5, this.TOy);
      paramInt = i;
      if (this.TOz != null) {
        paramInt = i + g.a.a.a.oD(6, this.TOz.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.TOA);
      int j = g.a.a.a.c(8, 8, this.TOB);
      int k = g.a.a.b.b.a.gL(9);
      int m = g.a.a.a.c(10, 8, this.TOD);
      AppMethodBeat.o(117545);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TOw.clear();
        this.TOB.clear();
        this.TOD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.GIL == null)
        {
          paramVarArgs = new b("Not all required fields were included: pid");
          AppMethodBeat.o(117545);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhk localdhk = (dhk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117545);
          return -1;
        case 1: 
          localdhk.GIL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117545);
          return 0;
        case 2: 
          localdhk.state = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117545);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhj)localObject2).parseFrom((byte[])localObject1);
            }
            localdhk.TOw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 4: 
          localdhk.TOx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117545);
          return 0;
        case 5: 
          localdhk.TOy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117545);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dyu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dyu)localObject2).parseFrom((byte[])localObject1);
            }
            localdhk.TOz = ((dyu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 7: 
          localdhk.TOA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117545);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhi)localObject2).parseFrom((byte[])localObject1);
            }
            localdhk.TOB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 9: 
          localdhk.TOC = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(117545);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dyu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dyu)localObject2).parseFrom((byte[])localObject1);
          }
          localdhk.TOD.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      AppMethodBeat.o(117545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhk
 * JD-Core Version:    0.7.0.1
 */