package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class enq
  extends com.tencent.mm.cd.a
{
  public long Id;
  public String SsO;
  public int UpR;
  public eob Uqi;
  public LinkedList<Integer> Uqv;
  
  public enq()
  {
    AppMethodBeat.i(118447);
    this.Uqv = new LinkedList();
    AppMethodBeat.o(118447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118448);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Id);
      if (this.SsO != null) {
        paramVarArgs.f(2, this.SsO);
      }
      if (this.Uqi != null)
      {
        paramVarArgs.oE(3, this.Uqi.computeSize());
        this.Uqi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.UpR);
      paramVarArgs.f(5, 2, this.Uqv);
      AppMethodBeat.o(118448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.SsO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SsO);
      }
      i = paramInt;
      if (this.Uqi != null) {
        i = paramInt + g.a.a.a.oD(3, this.Uqi.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.UpR);
      int j = g.a.a.a.d(5, 2, this.Uqv);
      AppMethodBeat.o(118448);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Uqv.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(118448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      enq localenq = (enq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118448);
        return -1;
      case 1: 
        localenq.Id = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(118448);
        return 0;
      case 2: 
        localenq.SsO = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(118448);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eob localeob = new eob();
          if ((localObject != null) && (localObject.length > 0)) {
            localeob.parseFrom((byte[])localObject);
          }
          localenq.Uqi = localeob;
          paramInt += 1;
        }
        AppMethodBeat.o(118448);
        return 0;
      case 4: 
        localenq.UpR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118448);
        return 0;
      }
      localenq.Uqv = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
      AppMethodBeat.o(118448);
      return 0;
    }
    AppMethodBeat.o(118448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enq
 * JD-Core Version:    0.7.0.1
 */