package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dak
  extends com.tencent.mm.bw.a
{
  public String AOl;
  public String CpP;
  public int MFG;
  public String MFH;
  public int MFI;
  public String MFJ;
  public int MFK;
  public String MFL;
  public long MFM;
  public LinkedList<czz> MFN;
  public String MiL;
  public String iZU;
  
  public dak()
  {
    AppMethodBeat.i(91593);
    this.MFN = new LinkedList();
    AppMethodBeat.o(91593);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91594);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MFG);
      if (this.MFH != null) {
        paramVarArgs.e(2, this.MFH);
      }
      if (this.MiL != null) {
        paramVarArgs.e(3, this.MiL);
      }
      paramVarArgs.aM(4, this.MFI);
      if (this.AOl != null) {
        paramVarArgs.e(5, this.AOl);
      }
      if (this.MFJ != null) {
        paramVarArgs.e(6, this.MFJ);
      }
      if (this.CpP != null) {
        paramVarArgs.e(7, this.CpP);
      }
      paramVarArgs.aM(8, this.MFK);
      if (this.iZU != null) {
        paramVarArgs.e(9, this.iZU);
      }
      if (this.MFL != null) {
        paramVarArgs.e(10, this.MFL);
      }
      paramVarArgs.bb(11, this.MFM);
      paramVarArgs.e(12, 8, this.MFN);
      AppMethodBeat.o(91594);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MFG) + 0;
      paramInt = i;
      if (this.MFH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MFH);
      }
      i = paramInt;
      if (this.MiL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MiL);
      }
      i += g.a.a.b.b.a.bu(4, this.MFI);
      paramInt = i;
      if (this.AOl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.AOl);
      }
      i = paramInt;
      if (this.MFJ != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MFJ);
      }
      paramInt = i;
      if (this.CpP != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.CpP);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.MFK);
      paramInt = i;
      if (this.iZU != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.iZU);
      }
      i = paramInt;
      if (this.MFL != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MFL);
      }
      paramInt = g.a.a.b.b.a.r(11, this.MFM);
      int j = g.a.a.a.c(12, 8, this.MFN);
      AppMethodBeat.o(91594);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MFN.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dak localdak = (dak)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91594);
        return -1;
      case 1: 
        localdak.MFG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91594);
        return 0;
      case 2: 
        localdak.MFH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 3: 
        localdak.MiL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 4: 
        localdak.MFI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91594);
        return 0;
      case 5: 
        localdak.AOl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 6: 
        localdak.MFJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 7: 
        localdak.CpP = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 8: 
        localdak.MFK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91594);
        return 0;
      case 9: 
        localdak.iZU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 10: 
        localdak.MFL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 11: 
        localdak.MFM = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91594);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new czz();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((czz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdak.MFN.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    AppMethodBeat.o(91594);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dak
 * JD-Core Version:    0.7.0.1
 */