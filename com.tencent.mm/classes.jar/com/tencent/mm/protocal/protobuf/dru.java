package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dru
  extends com.tencent.mm.bw.a
{
  public long KZg;
  public String KZj;
  public int KZk;
  public String LUZ;
  public int MUr;
  public LinkedList<eou> MUs;
  public chl MlQ;
  public int Scene;
  
  public dru()
  {
    AppMethodBeat.i(117908);
    this.MUs = new LinkedList();
    AppMethodBeat.o(117908);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117909);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LUZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.KZg);
      if (this.LUZ != null) {
        paramVarArgs.e(2, this.LUZ);
      }
      paramVarArgs.aM(3, this.KZk);
      if (this.MlQ != null)
      {
        paramVarArgs.ni(4, this.MlQ.computeSize());
        this.MlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.MUr);
      paramVarArgs.e(6, 8, this.MUs);
      paramVarArgs.aM(7, this.Scene);
      if (this.KZj != null) {
        paramVarArgs.e(8, this.KZj);
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.KZg) + 0;
      paramInt = i;
      if (this.LUZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LUZ);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.KZk);
      paramInt = i;
      if (this.MlQ != null) {
        paramInt = i + g.a.a.a.nh(4, this.MlQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MUr) + g.a.a.a.c(6, 8, this.MUs) + g.a.a.b.b.a.bu(7, this.Scene);
      paramInt = i;
      if (this.KZj != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KZj);
      }
      AppMethodBeat.o(117909);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MUs.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.LUZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dru localdru = (dru)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117909);
        return -1;
      case 1: 
        localdru.KZg = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117909);
        return 0;
      case 2: 
        localdru.LUZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117909);
        return 0;
      case 3: 
        localdru.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117909);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdru.MlQ = ((chl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 5: 
        localdru.MUr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117909);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eou();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eou)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdru.MUs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 7: 
        localdru.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117909);
        return 0;
      }
      localdru.KZj = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(117909);
      return 0;
    }
    AppMethodBeat.o(117909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dru
 * JD-Core Version:    0.7.0.1
 */