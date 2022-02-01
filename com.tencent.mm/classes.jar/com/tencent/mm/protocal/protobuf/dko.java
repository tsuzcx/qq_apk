package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dko
  extends com.tencent.mm.bw.a
{
  public String MOA;
  public String MOB;
  public int MOu;
  public String MOv;
  public String MOw;
  public String MOx;
  public String MOy;
  public bzt MOz;
  public String gTT;
  public String nHd;
  public String nHe;
  public String nHf;
  public String nHg;
  public int nHh;
  public String nHi;
  public String qGI;
  public double score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50101);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.nHh);
      paramVarArgs.aM(2, this.MOu);
      if (this.gTT != null) {
        paramVarArgs.e(3, this.gTT);
      }
      if (this.nHf != null) {
        paramVarArgs.e(4, this.nHf);
      }
      if (this.nHg != null) {
        paramVarArgs.e(5, this.nHg);
      }
      if (this.MOv != null) {
        paramVarArgs.e(6, this.MOv);
      }
      if (this.qGI != null) {
        paramVarArgs.e(7, this.qGI);
      }
      if (this.MOw != null) {
        paramVarArgs.e(8, this.MOw);
      }
      if (this.MOx != null) {
        paramVarArgs.e(9, this.MOx);
      }
      paramVarArgs.e(10, this.score);
      if (this.MOy != null) {
        paramVarArgs.e(11, this.MOy);
      }
      if (this.nHd != null) {
        paramVarArgs.e(12, this.nHd);
      }
      if (this.MOz != null)
      {
        paramVarArgs.ni(14, this.MOz.computeSize());
        this.MOz.writeFields(paramVarArgs);
      }
      if (this.nHe != null) {
        paramVarArgs.e(15, this.nHe);
      }
      if (this.MOA != null) {
        paramVarArgs.e(16, this.MOA);
      }
      if (this.MOB != null) {
        paramVarArgs.e(17, this.MOB);
      }
      if (this.nHi != null) {
        paramVarArgs.e(18, this.nHi);
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.nHh) + 0 + g.a.a.b.b.a.bu(2, this.MOu);
      paramInt = i;
      if (this.gTT != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.gTT);
      }
      i = paramInt;
      if (this.nHf != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.nHf);
      }
      paramInt = i;
      if (this.nHg != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.nHg);
      }
      i = paramInt;
      if (this.MOv != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MOv);
      }
      paramInt = i;
      if (this.qGI != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.qGI);
      }
      i = paramInt;
      if (this.MOw != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MOw);
      }
      paramInt = i;
      if (this.MOx != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MOx);
      }
      i = paramInt + (g.a.a.b.b.a.fS(10) + 8);
      paramInt = i;
      if (this.MOy != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MOy);
      }
      i = paramInt;
      if (this.nHd != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.nHd);
      }
      paramInt = i;
      if (this.MOz != null) {
        paramInt = i + g.a.a.a.nh(14, this.MOz.computeSize());
      }
      i = paramInt;
      if (this.nHe != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.nHe);
      }
      paramInt = i;
      if (this.MOA != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.MOA);
      }
      i = paramInt;
      if (this.MOB != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.MOB);
      }
      paramInt = i;
      if (this.nHi != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.nHi);
      }
      AppMethodBeat.o(50101);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dko localdko = (dko)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(50101);
        return -1;
      case 1: 
        localdko.nHh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(50101);
        return 0;
      case 2: 
        localdko.MOu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(50101);
        return 0;
      case 3: 
        localdko.gTT = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 4: 
        localdko.nHf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 5: 
        localdko.nHg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 6: 
        localdko.MOv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 7: 
        localdko.qGI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 8: 
        localdko.MOw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 9: 
        localdko.MOx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 10: 
        localdko.score = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(50101);
        return 0;
      case 11: 
        localdko.MOy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 12: 
        localdko.nHd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bzt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdko.MOz = ((bzt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50101);
        return 0;
      case 15: 
        localdko.nHe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 16: 
        localdko.MOA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 17: 
        localdko.MOB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50101);
        return 0;
      }
      localdko.nHi = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(50101);
      return 0;
    }
    AppMethodBeat.o(50101);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dko
 * JD-Core Version:    0.7.0.1
 */