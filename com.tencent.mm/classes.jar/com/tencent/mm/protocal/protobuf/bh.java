package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bh
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String Url;
  public String YCA;
  public String YCB;
  public bd YCC;
  public String YCD;
  public fb YCE;
  public ft YCF;
  public fs YCG;
  public fs YCH;
  public String YCz;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125689);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.Url != null) {
        paramVarArgs.g(2, this.Url);
      }
      paramVarArgs.bS(3, this.IJG);
      if (this.YCz != null) {
        paramVarArgs.g(4, this.YCz);
      }
      if (this.YCA != null) {
        paramVarArgs.g(5, this.YCA);
      }
      if (this.YCB != null) {
        paramVarArgs.g(6, this.YCB);
      }
      if (this.YCC != null)
      {
        paramVarArgs.qD(7, this.YCC.computeSize());
        this.YCC.writeFields(paramVarArgs);
      }
      if (this.YCD != null) {
        paramVarArgs.g(8, this.YCD);
      }
      if (this.YCE != null)
      {
        paramVarArgs.qD(9, this.YCE.computeSize());
        this.YCE.writeFields(paramVarArgs);
      }
      if (this.YCF != null)
      {
        paramVarArgs.qD(10, this.YCF.computeSize());
        this.YCF.writeFields(paramVarArgs);
      }
      if (this.YCG != null)
      {
        paramVarArgs.qD(11, this.YCG.computeSize());
        this.YCG.writeFields(paramVarArgs);
      }
      if (this.YCH != null)
      {
        paramVarArgs.qD(12, this.YCH.computeSize());
        this.YCH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.YCz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YCz);
      }
      i = paramInt;
      if (this.YCA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YCA);
      }
      paramInt = i;
      if (this.YCB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YCB);
      }
      i = paramInt;
      if (this.YCC != null) {
        i = paramInt + i.a.a.a.qC(7, this.YCC.computeSize());
      }
      paramInt = i;
      if (this.YCD != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YCD);
      }
      i = paramInt;
      if (this.YCE != null) {
        i = paramInt + i.a.a.a.qC(9, this.YCE.computeSize());
      }
      paramInt = i;
      if (this.YCF != null) {
        paramInt = i + i.a.a.a.qC(10, this.YCF.computeSize());
      }
      i = paramInt;
      if (this.YCG != null) {
        i = paramInt + i.a.a.a.qC(11, this.YCG.computeSize());
      }
      paramInt = i;
      if (this.YCH != null) {
        paramInt = i + i.a.a.a.qC(12, this.YCH.computeSize());
      }
      AppMethodBeat.o(125689);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bh localbh = (bh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125689);
        return -1;
      case 1: 
        localbh.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125689);
        return 0;
      case 2: 
        localbh.Url = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 3: 
        localbh.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125689);
        return 0;
      case 4: 
        localbh.YCz = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 5: 
        localbh.YCA = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 6: 
        localbh.YCB = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bd)localObject2).parseFrom((byte[])localObject1);
          }
          localbh.YCC = ((bd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 8: 
        localbh.YCD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fb)localObject2).parseFrom((byte[])localObject1);
          }
          localbh.YCE = ((fb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ft();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ft)localObject2).parseFrom((byte[])localObject1);
          }
          localbh.YCF = ((ft)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fs)localObject2).parseFrom((byte[])localObject1);
          }
          localbh.YCG = ((fs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fs();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fs)localObject2).parseFrom((byte[])localObject1);
        }
        localbh.YCH = ((fs)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    AppMethodBeat.o(125689);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bh
 * JD-Core Version:    0.7.0.1
 */