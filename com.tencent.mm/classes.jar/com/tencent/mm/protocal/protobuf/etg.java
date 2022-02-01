package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etg
  extends com.tencent.mm.bx.a
{
  public LinkedList<aki> Zqv;
  public fnf abwC;
  public akh abwD;
  public int abwE;
  public boolean abwF;
  public ahk abwG;
  public bm abwH;
  public int type;
  public String url;
  
  public etg()
  {
    AppMethodBeat.i(91676);
    this.Zqv = new LinkedList();
    AppMethodBeat.o(91676);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91677);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.abwC != null)
      {
        paramVarArgs.qD(3, this.abwC.computeSize());
        this.abwC.writeFields(paramVarArgs);
      }
      if (this.abwD != null)
      {
        paramVarArgs.qD(4, this.abwD.computeSize());
        this.abwD.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.abwE);
      paramVarArgs.di(6, this.abwF);
      paramVarArgs.e(7, 8, this.Zqv);
      if (this.abwG != null)
      {
        paramVarArgs.qD(8, this.abwG.computeSize());
        this.abwG.writeFields(paramVarArgs);
      }
      if (this.abwH != null)
      {
        paramVarArgs.qD(9, this.abwH.computeSize());
        this.abwH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.abwC != null) {
        i = paramInt + i.a.a.a.qC(3, this.abwC.computeSize());
      }
      paramInt = i;
      if (this.abwD != null) {
        paramInt = i + i.a.a.a.qC(4, this.abwD.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abwE) + (i.a.a.b.b.a.ko(6) + 1) + i.a.a.a.c(7, 8, this.Zqv);
      paramInt = i;
      if (this.abwG != null) {
        paramInt = i + i.a.a.a.qC(8, this.abwG.computeSize());
      }
      i = paramInt;
      if (this.abwH != null) {
        i = paramInt + i.a.a.a.qC(9, this.abwH.computeSize());
      }
      AppMethodBeat.o(91677);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zqv.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      etg localetg = (etg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91677);
        return -1;
      case 1: 
        localetg.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91677);
        return 0;
      case 2: 
        localetg.url = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91677);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fnf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fnf)localObject2).parseFrom((byte[])localObject1);
          }
          localetg.abwC = ((fnf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akh)localObject2).parseFrom((byte[])localObject1);
          }
          localetg.abwD = ((akh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 5: 
        localetg.abwE = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91677);
        return 0;
      case 6: 
        localetg.abwF = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(91677);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aki();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aki)localObject2).parseFrom((byte[])localObject1);
          }
          localetg.Zqv.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ahk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ahk)localObject2).parseFrom((byte[])localObject1);
          }
          localetg.abwG = ((ahk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bm();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bm)localObject2).parseFrom((byte[])localObject1);
        }
        localetg.abwH = ((bm)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    AppMethodBeat.o(91677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etg
 * JD-Core Version:    0.7.0.1
 */