package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebq
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public long Sap;
  public String Sas;
  public int Sat;
  public String TdI;
  public cqh TwK;
  public int UgA;
  public LinkedList<ezc> UgB;
  
  public ebq()
  {
    AppMethodBeat.i(117908);
    this.UgB = new LinkedList();
    AppMethodBeat.o(117908);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117909);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TdI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.Sap);
      if (this.TdI != null) {
        paramVarArgs.f(2, this.TdI);
      }
      paramVarArgs.aY(3, this.Sat);
      if (this.TwK != null)
      {
        paramVarArgs.oE(4, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.UgA);
      paramVarArgs.e(6, 8, this.UgB);
      paramVarArgs.aY(7, this.CPw);
      if (this.Sas != null) {
        paramVarArgs.f(8, this.Sas);
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Sap) + 0;
      paramInt = i;
      if (this.TdI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TdI);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.Sat);
      paramInt = i;
      if (this.TwK != null) {
        paramInt = i + g.a.a.a.oD(4, this.TwK.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UgA) + g.a.a.a.c(6, 8, this.UgB) + g.a.a.b.b.a.bM(7, this.CPw);
      paramInt = i;
      if (this.Sas != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Sas);
      }
      AppMethodBeat.o(117909);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UgB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TdI == null)
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
      ebq localebq = (ebq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117909);
        return -1;
      case 1: 
        localebq.Sap = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(117909);
        return 0;
      case 2: 
        localebq.TdI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117909);
        return 0;
      case 3: 
        localebq.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117909);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cqh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cqh)localObject2).parseFrom((byte[])localObject1);
          }
          localebq.TwK = ((cqh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 5: 
        localebq.UgA = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117909);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ezc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ezc)localObject2).parseFrom((byte[])localObject1);
          }
          localebq.UgB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 7: 
        localebq.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117909);
        return 0;
      }
      localebq.Sas = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(117909);
      return 0;
    }
    AppMethodBeat.o(117909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebq
 * JD-Core Version:    0.7.0.1
 */