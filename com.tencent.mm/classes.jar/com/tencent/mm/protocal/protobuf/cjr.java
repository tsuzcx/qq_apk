package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjr
  extends com.tencent.mm.cd.a
{
  public int FXs;
  public long Trd;
  public long Tre;
  public LinkedList<dhx> Trf;
  public LinkedList<dht> Trg;
  public int Trh;
  public int Tri;
  public boolean Trj;
  public long jUq;
  
  public cjr()
  {
    AppMethodBeat.i(122515);
    this.Trd = 0L;
    this.Tre = 0L;
    this.Trf = new LinkedList();
    this.FXs = -1;
    this.Trg = new LinkedList();
    this.Trh = -1;
    this.Tri = -1;
    this.jUq = 0L;
    this.Trj = false;
    AppMethodBeat.o(122515);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122516);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Trd);
      paramVarArgs.bm(2, this.Tre);
      paramVarArgs.e(3, 8, this.Trf);
      paramVarArgs.aY(4, this.FXs);
      paramVarArgs.e(5, 8, this.Trg);
      paramVarArgs.aY(6, this.Trh);
      paramVarArgs.aY(7, this.Tri);
      paramVarArgs.bm(8, this.jUq);
      paramVarArgs.co(9, this.Trj);
      AppMethodBeat.o(122516);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.Trd);
      i = g.a.a.b.b.a.p(2, this.Tre);
      int j = g.a.a.a.c(3, 8, this.Trf);
      int k = g.a.a.b.b.a.bM(4, this.FXs);
      int m = g.a.a.a.c(5, 8, this.Trg);
      int n = g.a.a.b.b.a.bM(6, this.Trh);
      int i1 = g.a.a.b.b.a.bM(7, this.Tri);
      int i2 = g.a.a.b.b.a.p(8, this.jUq);
      int i3 = g.a.a.b.b.a.gL(9);
      AppMethodBeat.o(122516);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + (i3 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Trf.clear();
      this.Trg.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(122516);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cjr localcjr = (cjr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122516);
        return -1;
      case 1: 
        localcjr.Trd = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(122516);
        return 0;
      case 2: 
        localcjr.Tre = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(122516);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhx)localObject2).parseFrom((byte[])localObject1);
          }
          localcjr.Trf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 4: 
        localcjr.FXs = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(122516);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dht();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dht)localObject2).parseFrom((byte[])localObject1);
          }
          localcjr.Trg.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 6: 
        localcjr.Trh = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(122516);
        return 0;
      case 7: 
        localcjr.Tri = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(122516);
        return 0;
      case 8: 
        localcjr.jUq = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(122516);
        return 0;
      }
      localcjr.Trj = ((g.a.a.a.a)localObject1).abFh.AB();
      AppMethodBeat.o(122516);
      return 0;
    }
    AppMethodBeat.o(122516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjr
 * JD-Core Version:    0.7.0.1
 */