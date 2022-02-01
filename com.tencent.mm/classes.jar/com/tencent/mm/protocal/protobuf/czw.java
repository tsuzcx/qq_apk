package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czw
  extends com.tencent.mm.bx.a
{
  public int LSR;
  public long aaFl;
  public long aaFm;
  public LinkedList<eah> aaFn;
  public LinkedList<ead> aaFo;
  public int aaFp;
  public int aaFq;
  public boolean aaFr;
  public long muJ;
  
  public czw()
  {
    AppMethodBeat.i(122515);
    this.aaFl = 0L;
    this.aaFm = 0L;
    this.aaFn = new LinkedList();
    this.LSR = -1;
    this.aaFo = new LinkedList();
    this.aaFp = -1;
    this.aaFq = -1;
    this.muJ = 0L;
    this.aaFr = false;
    AppMethodBeat.o(122515);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122516);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaFl);
      paramVarArgs.bv(2, this.aaFm);
      paramVarArgs.e(3, 8, this.aaFn);
      paramVarArgs.bS(4, this.LSR);
      paramVarArgs.e(5, 8, this.aaFo);
      paramVarArgs.bS(6, this.aaFp);
      paramVarArgs.bS(7, this.aaFq);
      paramVarArgs.bv(8, this.muJ);
      paramVarArgs.di(9, this.aaFr);
      AppMethodBeat.o(122516);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aaFl);
      i = i.a.a.b.b.a.q(2, this.aaFm);
      int j = i.a.a.a.c(3, 8, this.aaFn);
      int k = i.a.a.b.b.a.cJ(4, this.LSR);
      int m = i.a.a.a.c(5, 8, this.aaFo);
      int n = i.a.a.b.b.a.cJ(6, this.aaFp);
      int i1 = i.a.a.b.b.a.cJ(7, this.aaFq);
      int i2 = i.a.a.b.b.a.q(8, this.muJ);
      int i3 = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(122516);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + (i3 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaFn.clear();
      this.aaFo.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122516);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      czw localczw = (czw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122516);
        return -1;
      case 1: 
        localczw.aaFl = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(122516);
        return 0;
      case 2: 
        localczw.aaFm = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(122516);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eah();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eah)localObject2).parseFrom((byte[])localObject1);
          }
          localczw.aaFn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 4: 
        localczw.LSR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(122516);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ead();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ead)localObject2).parseFrom((byte[])localObject1);
          }
          localczw.aaFo.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 6: 
        localczw.aaFp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(122516);
        return 0;
      case 7: 
        localczw.aaFq = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(122516);
        return 0;
      case 8: 
        localczw.muJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(122516);
        return 0;
      }
      localczw.aaFr = ((i.a.a.a.a)localObject1).ajGk.aai();
      AppMethodBeat.o(122516);
      return 0;
    }
    AppMethodBeat.o(122516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czw
 * JD-Core Version:    0.7.0.1
 */