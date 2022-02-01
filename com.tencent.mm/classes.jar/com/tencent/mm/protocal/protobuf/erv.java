package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class erv
  extends com.tencent.mm.bx.a
{
  public int XVH;
  public int Zan;
  public int aaFY;
  public int aasS;
  public int abmA;
  public ery abvF;
  public erx abvG;
  public String abvH;
  public int abvI;
  public int abvJ;
  public int abvK;
  public int xKa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152668);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.abmA);
      if (this.abvF != null)
      {
        paramVarArgs.qD(2, this.abvF.computeSize());
        this.abvF.writeFields(paramVarArgs);
      }
      if (this.abvG != null)
      {
        paramVarArgs.qD(3, this.abvG.computeSize());
        this.abvG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.aasS);
      paramVarArgs.bS(5, this.xKa);
      if (this.abvH != null) {
        paramVarArgs.g(6, this.abvH);
      }
      paramVarArgs.bS(7, this.Zan);
      paramVarArgs.bS(8, this.abvI);
      paramVarArgs.bS(9, this.XVH);
      paramVarArgs.bS(10, this.abvJ);
      paramVarArgs.bS(11, this.abvK);
      paramVarArgs.bS(12, this.aaFY);
      AppMethodBeat.o(152668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abmA) + 0;
      paramInt = i;
      if (this.abvF != null) {
        paramInt = i + i.a.a.a.qC(2, this.abvF.computeSize());
      }
      i = paramInt;
      if (this.abvG != null) {
        i = paramInt + i.a.a.a.qC(3, this.abvG.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(4, this.aasS) + i.a.a.b.b.a.cJ(5, this.xKa);
      paramInt = i;
      if (this.abvH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abvH);
      }
      i = i.a.a.b.b.a.cJ(7, this.Zan);
      int j = i.a.a.b.b.a.cJ(8, this.abvI);
      int k = i.a.a.b.b.a.cJ(9, this.XVH);
      int m = i.a.a.b.b.a.cJ(10, this.abvJ);
      int n = i.a.a.b.b.a.cJ(11, this.abvK);
      int i1 = i.a.a.b.b.a.cJ(12, this.aaFY);
      AppMethodBeat.o(152668);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      erv localerv = (erv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152668);
        return -1;
      case 1: 
        localerv.abmA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152668);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ery();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ery)localObject2).parseFrom((byte[])localObject1);
          }
          localerv.abvF = ((ery)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new erx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((erx)localObject2).parseFrom((byte[])localObject1);
          }
          localerv.abvG = ((erx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 4: 
        localerv.aasS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152668);
        return 0;
      case 5: 
        localerv.xKa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152668);
        return 0;
      case 6: 
        localerv.abvH = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152668);
        return 0;
      case 7: 
        localerv.Zan = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152668);
        return 0;
      case 8: 
        localerv.abvI = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152668);
        return 0;
      case 9: 
        localerv.XVH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152668);
        return 0;
      case 10: 
        localerv.abvJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152668);
        return 0;
      case 11: 
        localerv.abvK = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152668);
        return 0;
      }
      localerv.aaFY = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(152668);
      return 0;
    }
    AppMethodBeat.o(152668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erv
 * JD-Core Version:    0.7.0.1
 */