package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public String GaA;
  public long GaB;
  public String GaC;
  public int Gat;
  public w Gau;
  public String Gav;
  public String Gaw;
  public String Gax;
  public String Gay;
  public int Gaz;
  public String description;
  public String iUX;
  public double latitude;
  public double longitude;
  public int pRN;
  public int visibility;
  public int zGN;
  public int zGO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222825);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.longitude);
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.aM(3, this.Gat);
      if (this.Gau != null)
      {
        paramVarArgs.ni(4, this.Gau.computeSize());
        this.Gau.writeFields(paramVarArgs);
      }
      if (this.Gav != null) {
        paramVarArgs.e(5, this.Gav);
      }
      if (this.Gaw != null) {
        paramVarArgs.e(6, this.Gaw);
      }
      if (this.Gax != null) {
        paramVarArgs.e(7, this.Gax);
      }
      if (this.Gay != null) {
        paramVarArgs.e(8, this.Gay);
      }
      paramVarArgs.aM(9, this.visibility);
      if (this.description != null) {
        paramVarArgs.e(10, this.description);
      }
      paramVarArgs.aM(11, this.Gaz);
      paramVarArgs.aM(12, this.pRN);
      if (this.GaA != null) {
        paramVarArgs.e(13, this.GaA);
      }
      if (this.iUX != null) {
        paramVarArgs.e(14, this.iUX);
      }
      paramVarArgs.bb(15, this.GaB);
      paramVarArgs.aM(16, this.zGN);
      paramVarArgs.aM(17, this.zGO);
      if (this.GaC != null) {
        paramVarArgs.e(18, this.GaC);
      }
      AppMethodBeat.o(222825);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.fS(1) + 8 + 0 + (g.a.a.b.b.a.fS(2) + 8) + g.a.a.b.b.a.bu(3, this.Gat);
      paramInt = i;
      if (this.Gau != null) {
        paramInt = i + g.a.a.a.nh(4, this.Gau.computeSize());
      }
      i = paramInt;
      if (this.Gav != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Gav);
      }
      paramInt = i;
      if (this.Gaw != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Gaw);
      }
      i = paramInt;
      if (this.Gax != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Gax);
      }
      paramInt = i;
      if (this.Gay != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Gay);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.visibility);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.description);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.Gaz) + g.a.a.b.b.a.bu(12, this.pRN);
      paramInt = i;
      if (this.GaA != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.GaA);
      }
      i = paramInt;
      if (this.iUX != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.iUX);
      }
      i = i + g.a.a.b.b.a.r(15, this.GaB) + g.a.a.b.b.a.bu(16, this.zGN) + g.a.a.b.b.a.bu(17, this.zGO);
      paramInt = i;
      if (this.GaC != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.GaC);
      }
      AppMethodBeat.o(222825);
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
      AppMethodBeat.o(222825);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(222825);
        return -1;
      case 1: 
        localg.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(222825);
        return 0;
      case 2: 
        localg.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(222825);
        return 0;
      case 3: 
        localg.Gat = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(222825);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new w();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((w)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localg.Gau = ((w)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(222825);
        return 0;
      case 5: 
        localg.Gav = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(222825);
        return 0;
      case 6: 
        localg.Gaw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(222825);
        return 0;
      case 7: 
        localg.Gax = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(222825);
        return 0;
      case 8: 
        localg.Gay = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(222825);
        return 0;
      case 9: 
        localg.visibility = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(222825);
        return 0;
      case 10: 
        localg.description = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(222825);
        return 0;
      case 11: 
        localg.Gaz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(222825);
        return 0;
      case 12: 
        localg.pRN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(222825);
        return 0;
      case 13: 
        localg.GaA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(222825);
        return 0;
      case 14: 
        localg.iUX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(222825);
        return 0;
      case 15: 
        localg.GaB = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(222825);
        return 0;
      case 16: 
        localg.zGN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(222825);
        return 0;
      case 17: 
        localg.zGO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(222825);
        return 0;
      }
      localg.GaC = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(222825);
      return 0;
    }
    AppMethodBeat.o(222825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.g
 * JD-Core Version:    0.7.0.1
 */