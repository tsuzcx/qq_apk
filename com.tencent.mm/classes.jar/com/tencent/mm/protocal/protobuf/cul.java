package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cul
  extends com.tencent.mm.bw.a
{
  public int HEc;
  public String HEe;
  public String HEf;
  public String HEg;
  public String HEh;
  public String HEi;
  public String HEj;
  public int HFS;
  public String LFY;
  public cum MzF;
  public String MzG;
  public String MzH;
  public int MzI;
  public String MzJ;
  public String MzK;
  public String MzL;
  public String MzM;
  public String MzN;
  public String MzO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72526);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.HFS);
      if (this.MzF != null)
      {
        paramVarArgs.ni(2, this.MzF.computeSize());
        this.MzF.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.HEc);
      if (this.HEe != null) {
        paramVarArgs.e(4, this.HEe);
      }
      if (this.HEf != null) {
        paramVarArgs.e(5, this.HEf);
      }
      if (this.HEg != null) {
        paramVarArgs.e(6, this.HEg);
      }
      if (this.HEh != null) {
        paramVarArgs.e(7, this.HEh);
      }
      if (this.HEi != null) {
        paramVarArgs.e(8, this.HEi);
      }
      if (this.HEj != null) {
        paramVarArgs.e(9, this.HEj);
      }
      if (this.LFY != null) {
        paramVarArgs.e(10, this.LFY);
      }
      if (this.MzG != null) {
        paramVarArgs.e(11, this.MzG);
      }
      if (this.MzH != null) {
        paramVarArgs.e(12, this.MzH);
      }
      paramVarArgs.aM(13, this.MzI);
      if (this.MzJ != null) {
        paramVarArgs.e(14, this.MzJ);
      }
      if (this.MzK != null) {
        paramVarArgs.e(15, this.MzK);
      }
      if (this.MzL != null) {
        paramVarArgs.e(16, this.MzL);
      }
      if (this.MzM != null) {
        paramVarArgs.e(17, this.MzM);
      }
      if (this.MzN != null) {
        paramVarArgs.e(18, this.MzN);
      }
      if (this.MzO != null) {
        paramVarArgs.e(19, this.MzO);
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.HFS) + 0;
      paramInt = i;
      if (this.MzF != null) {
        paramInt = i + g.a.a.a.nh(2, this.MzF.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.HEc);
      paramInt = i;
      if (this.HEe != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HEe);
      }
      i = paramInt;
      if (this.HEf != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.HEf);
      }
      paramInt = i;
      if (this.HEg != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.HEg);
      }
      i = paramInt;
      if (this.HEh != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.HEh);
      }
      paramInt = i;
      if (this.HEi != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.HEi);
      }
      i = paramInt;
      if (this.HEj != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.HEj);
      }
      paramInt = i;
      if (this.LFY != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LFY);
      }
      i = paramInt;
      if (this.MzG != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MzG);
      }
      paramInt = i;
      if (this.MzH != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MzH);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.MzI);
      paramInt = i;
      if (this.MzJ != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MzJ);
      }
      i = paramInt;
      if (this.MzK != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MzK);
      }
      paramInt = i;
      if (this.MzL != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.MzL);
      }
      i = paramInt;
      if (this.MzM != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.MzM);
      }
      paramInt = i;
      if (this.MzN != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.MzN);
      }
      i = paramInt;
      if (this.MzO != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.MzO);
      }
      AppMethodBeat.o(72526);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cul localcul = (cul)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72526);
        return -1;
      case 1: 
        localcul.HFS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72526);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cum();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cum)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcul.MzF = ((cum)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72526);
        return 0;
      case 3: 
        localcul.HEc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72526);
        return 0;
      case 4: 
        localcul.HEe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 5: 
        localcul.HEf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 6: 
        localcul.HEg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 7: 
        localcul.HEh = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 8: 
        localcul.HEi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 9: 
        localcul.HEj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 10: 
        localcul.LFY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 11: 
        localcul.MzG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 12: 
        localcul.MzH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 13: 
        localcul.MzI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72526);
        return 0;
      case 14: 
        localcul.MzJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 15: 
        localcul.MzK = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 16: 
        localcul.MzL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 17: 
        localcul.MzM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 18: 
        localcul.MzN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72526);
        return 0;
      }
      localcul.MzO = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(72526);
      return 0;
    }
    AppMethodBeat.o(72526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cul
 * JD-Core Version:    0.7.0.1
 */