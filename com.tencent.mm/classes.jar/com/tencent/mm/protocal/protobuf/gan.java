package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gan
  extends erp
{
  public gol YLa;
  public long ZvA;
  public int Zvz;
  public int abXT;
  public int abXU;
  public int abXV;
  public int abXW;
  public int abXX;
  public int abna;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115876);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115876);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.abna);
      paramVarArgs.bS(5, this.abXT);
      paramVarArgs.bS(6, this.abXU);
      paramVarArgs.bS(7, this.abXV);
      paramVarArgs.bS(8, this.abXW);
      paramVarArgs.bS(9, this.abXX);
      if (this.YLa != null)
      {
        paramVarArgs.qD(10, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.q(3, this.ZvA) + i.a.a.b.b.a.cJ(4, this.abna) + i.a.a.b.b.a.cJ(5, this.abXT) + i.a.a.b.b.a.cJ(6, this.abXU) + i.a.a.b.b.a.cJ(7, this.abXV) + i.a.a.b.b.a.cJ(8, this.abXW) + i.a.a.b.b.a.cJ(9, this.abXX);
      paramInt = i;
      if (this.YLa != null) {
        paramInt = i + i.a.a.a.qC(10, this.YLa.computeSize());
      }
      AppMethodBeat.o(115876);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YLa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(115876);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gan localgan = (gan)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115876);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localgan.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115876);
          return 0;
        case 2: 
          localgan.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115876);
          return 0;
        case 3: 
          localgan.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115876);
          return 0;
        case 4: 
          localgan.abna = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115876);
          return 0;
        case 5: 
          localgan.abXT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115876);
          return 0;
        case 6: 
          localgan.abXU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115876);
          return 0;
        case 7: 
          localgan.abXV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115876);
          return 0;
        case 8: 
          localgan.abXW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115876);
          return 0;
        case 9: 
          localgan.abXX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115876);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localgan.YLa = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      AppMethodBeat.o(115876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gan
 * JD-Core Version:    0.7.0.1
 */