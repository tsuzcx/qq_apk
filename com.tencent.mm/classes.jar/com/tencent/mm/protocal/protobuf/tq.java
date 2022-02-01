package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class tq
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> YZj;
  public LinkedList<b> YZk;
  public boolean YZl;
  public LinkedList<ub> YZm;
  
  public tq()
  {
    AppMethodBeat.i(259803);
    this.YZj = new LinkedList();
    this.YZk = new LinkedList();
    this.YZm = new LinkedList();
    AppMethodBeat.o(259803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259808);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 2, this.YZj);
      paramVarArgs.e(2, 6, this.YZk);
      paramVarArgs.di(3, this.YZl);
      paramVarArgs.e(4, 8, this.YZm);
      AppMethodBeat.o(259808);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 2, this.YZj);
      i = i.a.a.a.c(2, 6, this.YZk);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.a.c(4, 8, this.YZm);
      AppMethodBeat.o(259808);
      return paramInt + 0 + i + (j + 1) + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YZj.clear();
      this.YZk.clear();
      this.YZm.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259808);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      tq localtq = (tq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259808);
        return -1;
      case 1: 
        localtq.YZj.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
        AppMethodBeat.o(259808);
        return 0;
      case 2: 
        localtq.YZk.add(((i.a.a.a.a)localObject).ajGk.kFX());
        AppMethodBeat.o(259808);
        return 0;
      case 3: 
        localtq.YZl = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(259808);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ub localub = new ub();
        if ((localObject != null) && (localObject.length > 0)) {
          localub.parseFrom((byte[])localObject);
        }
        localtq.YZm.add(localub);
        paramInt += 1;
      }
      AppMethodBeat.o(259808);
      return 0;
    }
    AppMethodBeat.o(259808);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tq
 * JD-Core Version:    0.7.0.1
 */