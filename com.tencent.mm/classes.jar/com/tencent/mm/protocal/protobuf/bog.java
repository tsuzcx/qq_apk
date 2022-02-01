package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bog
  extends com.tencent.mm.cd.a
{
  public LinkedList<cvl> Nni;
  public long RQi;
  public long RQj;
  public boolean RQl;
  public eeu SZi;
  public long SZj;
  public long SZk;
  public long SZl;
  public long SZm;
  public long SZn;
  public long uin;
  
  public bog()
  {
    AppMethodBeat.i(110895);
    this.Nni = new LinkedList();
    this.SZj = 10L;
    this.SZk = 0L;
    this.RQl = false;
    this.SZl = 0L;
    this.SZm = 0L;
    this.SZn = 0L;
    AppMethodBeat.o(110895);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110896);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RQi);
      paramVarArgs.bm(2, this.uin);
      paramVarArgs.bm(3, this.RQj);
      paramVarArgs.e(4, 8, this.Nni);
      if (this.SZi != null)
      {
        paramVarArgs.oE(5, this.SZi.computeSize());
        this.SZi.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.SZj);
      paramVarArgs.bm(7, this.SZk);
      paramVarArgs.co(8, this.RQl);
      paramVarArgs.bm(9, this.SZl);
      paramVarArgs.bm(10, this.SZm);
      paramVarArgs.bm(11, this.SZn);
      AppMethodBeat.o(110896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.RQi) + 0 + g.a.a.b.b.a.p(2, this.uin) + g.a.a.b.b.a.p(3, this.RQj) + g.a.a.a.c(4, 8, this.Nni);
      paramInt = i;
      if (this.SZi != null) {
        paramInt = i + g.a.a.a.oD(5, this.SZi.computeSize());
      }
      i = g.a.a.b.b.a.p(6, this.SZj);
      int j = g.a.a.b.b.a.p(7, this.SZk);
      int k = g.a.a.b.b.a.gL(8);
      int m = g.a.a.b.b.a.p(9, this.SZl);
      int n = g.a.a.b.b.a.p(10, this.SZm);
      int i1 = g.a.a.b.b.a.p(11, this.SZn);
      AppMethodBeat.o(110896);
      return paramInt + i + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nni.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bog localbog = (bog)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110896);
        return -1;
      case 1: 
        localbog.RQi = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110896);
        return 0;
      case 2: 
        localbog.uin = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110896);
        return 0;
      case 3: 
        localbog.RQj = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110896);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cvl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cvl)localObject2).parseFrom((byte[])localObject1);
          }
          localbog.Nni.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eeu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eeu)localObject2).parseFrom((byte[])localObject1);
          }
          localbog.SZi = ((eeu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 6: 
        localbog.SZj = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110896);
        return 0;
      case 7: 
        localbog.SZk = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110896);
        return 0;
      case 8: 
        localbog.RQl = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(110896);
        return 0;
      case 9: 
        localbog.SZl = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110896);
        return 0;
      case 10: 
        localbog.SZm = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110896);
        return 0;
      }
      localbog.SZn = ((g.a.a.a.a)localObject1).abFh.AN();
      AppMethodBeat.o(110896);
      return 0;
    }
    AppMethodBeat.o(110896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bog
 * JD-Core Version:    0.7.0.1
 */