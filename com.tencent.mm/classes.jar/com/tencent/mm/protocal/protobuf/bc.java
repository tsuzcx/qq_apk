package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bc
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String RFL;
  public String RFM;
  public String RFN;
  public ba RFO;
  public String RFP;
  public eh RFQ;
  public ez RFR;
  public ey RFS;
  public ey RFT;
  public String Url;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125689);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      if (this.Url != null) {
        paramVarArgs.f(2, this.Url);
      }
      paramVarArgs.aY(3, this.CPw);
      if (this.RFL != null) {
        paramVarArgs.f(4, this.RFL);
      }
      if (this.RFM != null) {
        paramVarArgs.f(5, this.RFM);
      }
      if (this.RFN != null) {
        paramVarArgs.f(6, this.RFN);
      }
      if (this.RFO != null)
      {
        paramVarArgs.oE(7, this.RFO.computeSize());
        this.RFO.writeFields(paramVarArgs);
      }
      if (this.RFP != null) {
        paramVarArgs.f(8, this.RFP);
      }
      if (this.RFQ != null)
      {
        paramVarArgs.oE(9, this.RFQ.computeSize());
        this.RFQ.writeFields(paramVarArgs);
      }
      if (this.RFR != null)
      {
        paramVarArgs.oE(10, this.RFR.computeSize());
        this.RFR.writeFields(paramVarArgs);
      }
      if (this.RFS != null)
      {
        paramVarArgs.oE(11, this.RFS.computeSize());
        this.RFS.writeFields(paramVarArgs);
      }
      if (this.RFT != null)
      {
        paramVarArgs.oE(12, this.RFT.computeSize());
        this.RFT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.rWu) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Url);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.RFL != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RFL);
      }
      i = paramInt;
      if (this.RFM != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RFM);
      }
      paramInt = i;
      if (this.RFN != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RFN);
      }
      i = paramInt;
      if (this.RFO != null) {
        i = paramInt + g.a.a.a.oD(7, this.RFO.computeSize());
      }
      paramInt = i;
      if (this.RFP != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RFP);
      }
      i = paramInt;
      if (this.RFQ != null) {
        i = paramInt + g.a.a.a.oD(9, this.RFQ.computeSize());
      }
      paramInt = i;
      if (this.RFR != null) {
        paramInt = i + g.a.a.a.oD(10, this.RFR.computeSize());
      }
      i = paramInt;
      if (this.RFS != null) {
        i = paramInt + g.a.a.a.oD(11, this.RFS.computeSize());
      }
      paramInt = i;
      if (this.RFT != null) {
        paramInt = i + g.a.a.a.oD(12, this.RFT.computeSize());
      }
      AppMethodBeat.o(125689);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bc localbc = (bc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125689);
        return -1;
      case 1: 
        localbc.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125689);
        return 0;
      case 2: 
        localbc.Url = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 3: 
        localbc.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125689);
        return 0;
      case 4: 
        localbc.RFL = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 5: 
        localbc.RFM = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 6: 
        localbc.RFN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ba();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ba)localObject2).parseFrom((byte[])localObject1);
          }
          localbc.RFO = ((ba)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 8: 
        localbc.RFP = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eh)localObject2).parseFrom((byte[])localObject1);
          }
          localbc.RFQ = ((eh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ez();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ez)localObject2).parseFrom((byte[])localObject1);
          }
          localbc.RFR = ((ez)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ey();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ey)localObject2).parseFrom((byte[])localObject1);
          }
          localbc.RFS = ((ey)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ey();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ey)localObject2).parseFrom((byte[])localObject1);
        }
        localbc.RFT = ((ey)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    AppMethodBeat.o(125689);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bc
 * JD-Core Version:    0.7.0.1
 */