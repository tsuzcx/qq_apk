package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccr
  extends com.tencent.mm.bx.a
{
  public LinkedList<dmr> UaK;
  public long YNA;
  public boolean YNC;
  public long YNz;
  public eyn aama;
  public long aamb;
  public long aamc;
  public long aamd;
  public long aame;
  public long aamf;
  public long uin;
  
  public ccr()
  {
    AppMethodBeat.i(110895);
    this.UaK = new LinkedList();
    this.aamb = 10L;
    this.aamc = 0L;
    this.YNC = false;
    this.aamd = 0L;
    this.aame = 0L;
    this.aamf = 0L;
    AppMethodBeat.o(110895);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110896);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YNz);
      paramVarArgs.bv(2, this.uin);
      paramVarArgs.bv(3, this.YNA);
      paramVarArgs.e(4, 8, this.UaK);
      if (this.aama != null)
      {
        paramVarArgs.qD(5, this.aama.computeSize());
        this.aama.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.aamb);
      paramVarArgs.bv(7, this.aamc);
      paramVarArgs.di(8, this.YNC);
      paramVarArgs.bv(9, this.aamd);
      paramVarArgs.bv(10, this.aame);
      paramVarArgs.bv(11, this.aamf);
      AppMethodBeat.o(110896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.YNz) + 0 + i.a.a.b.b.a.q(2, this.uin) + i.a.a.b.b.a.q(3, this.YNA) + i.a.a.a.c(4, 8, this.UaK);
      paramInt = i;
      if (this.aama != null) {
        paramInt = i + i.a.a.a.qC(5, this.aama.computeSize());
      }
      i = i.a.a.b.b.a.q(6, this.aamb);
      int j = i.a.a.b.b.a.q(7, this.aamc);
      int k = i.a.a.b.b.a.ko(8);
      int m = i.a.a.b.b.a.q(9, this.aamd);
      int n = i.a.a.b.b.a.q(10, this.aame);
      int i1 = i.a.a.b.b.a.q(11, this.aamf);
      AppMethodBeat.o(110896);
      return paramInt + i + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UaK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ccr localccr = (ccr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110896);
        return -1;
      case 1: 
        localccr.YNz = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110896);
        return 0;
      case 2: 
        localccr.uin = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110896);
        return 0;
      case 3: 
        localccr.YNA = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110896);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmr)localObject2).parseFrom((byte[])localObject1);
          }
          localccr.UaK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eyn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eyn)localObject2).parseFrom((byte[])localObject1);
          }
          localccr.aama = ((eyn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 6: 
        localccr.aamb = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110896);
        return 0;
      case 7: 
        localccr.aamc = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110896);
        return 0;
      case 8: 
        localccr.YNC = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(110896);
        return 0;
      case 9: 
        localccr.aamd = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110896);
        return 0;
      case 10: 
        localccr.aame = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110896);
        return 0;
      }
      localccr.aamf = ((i.a.a.a.a)localObject1).ajGk.aaw();
      AppMethodBeat.o(110896);
      return 0;
    }
    AppMethodBeat.o(110896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccr
 * JD-Core Version:    0.7.0.1
 */