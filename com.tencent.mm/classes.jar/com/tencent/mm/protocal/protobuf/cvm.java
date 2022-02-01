package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvm
  extends com.tencent.mm.cd.a
{
  public long TDq;
  public long TDr;
  public long TDs;
  public LinkedList<fmk> TDt;
  public long TDu;
  public boolean TDv;
  public double TDw;
  public LinkedList<fmk> TDx;
  public LinkedList<eut> TDy;
  public etr TDz;
  public long begin_time;
  public long duration;
  public long fwf;
  public long id;
  public String path;
  
  public cvm()
  {
    AppMethodBeat.i(110905);
    this.TDt = new LinkedList();
    this.TDx = new LinkedList();
    this.TDy = new LinkedList();
    AppMethodBeat.o(110905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110906);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.id);
      paramVarArgs.bm(2, this.fwf);
      paramVarArgs.bm(3, this.begin_time);
      paramVarArgs.bm(4, this.duration);
      paramVarArgs.bm(5, this.TDq);
      paramVarArgs.bm(6, this.TDr);
      paramVarArgs.bm(7, this.TDs);
      paramVarArgs.e(8, 8, this.TDt);
      paramVarArgs.bm(9, this.TDu);
      paramVarArgs.co(10, this.TDv);
      paramVarArgs.e(11, this.TDw);
      paramVarArgs.e(12, 8, this.TDx);
      paramVarArgs.e(13, 8, this.TDy);
      if (this.TDz != null)
      {
        paramVarArgs.oE(14, this.TDz.computeSize());
        this.TDz.writeFields(paramVarArgs);
      }
      if (this.path != null) {
        paramVarArgs.f(15, this.path);
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.id) + 0 + g.a.a.b.b.a.p(2, this.fwf) + g.a.a.b.b.a.p(3, this.begin_time) + g.a.a.b.b.a.p(4, this.duration) + g.a.a.b.b.a.p(5, this.TDq) + g.a.a.b.b.a.p(6, this.TDr) + g.a.a.b.b.a.p(7, this.TDs) + g.a.a.a.c(8, 8, this.TDt) + g.a.a.b.b.a.p(9, this.TDu) + (g.a.a.b.b.a.gL(10) + 1) + (g.a.a.b.b.a.gL(11) + 8) + g.a.a.a.c(12, 8, this.TDx) + g.a.a.a.c(13, 8, this.TDy);
      paramInt = i;
      if (this.TDz != null) {
        paramInt = i + g.a.a.a.oD(14, this.TDz.computeSize());
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.path);
      }
      AppMethodBeat.o(110906);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TDt.clear();
      this.TDx.clear();
      this.TDy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cvm localcvm = (cvm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110906);
        return -1;
      case 1: 
        localcvm.id = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110906);
        return 0;
      case 2: 
        localcvm.fwf = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110906);
        return 0;
      case 3: 
        localcvm.begin_time = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110906);
        return 0;
      case 4: 
        localcvm.duration = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110906);
        return 0;
      case 5: 
        localcvm.TDq = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110906);
        return 0;
      case 6: 
        localcvm.TDr = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110906);
        return 0;
      case 7: 
        localcvm.TDs = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110906);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmk)localObject2).parseFrom((byte[])localObject1);
          }
          localcvm.TDt.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 9: 
        localcvm.TDu = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110906);
        return 0;
      case 10: 
        localcvm.TDv = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(110906);
        return 0;
      case 11: 
        localcvm.TDw = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
        AppMethodBeat.o(110906);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmk)localObject2).parseFrom((byte[])localObject1);
          }
          localcvm.TDx.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eut();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eut)localObject2).parseFrom((byte[])localObject1);
          }
          localcvm.TDy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etr)localObject2).parseFrom((byte[])localObject1);
          }
          localcvm.TDz = ((etr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      }
      localcvm.path = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(110906);
      return 0;
    }
    AppMethodBeat.o(110906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvm
 * JD-Core Version:    0.7.0.1
 */