package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fal
  extends com.tencent.mm.bw.a
{
  public String KZj;
  public int KZk;
  public String LPT;
  public String MEr;
  public String MOi;
  public int MRb;
  public int MRf;
  public int MRy;
  public int MaY;
  public chl MlQ;
  public int NgA;
  public LinkedList<aca> Nva;
  public int NwG;
  public String NwH;
  public String NwI;
  public LinkedList<String> NwJ;
  public int NwK;
  public beo NwL;
  public int Scene;
  public int oUv;
  
  public fal()
  {
    AppMethodBeat.i(117947);
    this.NwG = 2;
    this.Nva = new LinkedList();
    this.NwJ = new LinkedList();
    AppMethodBeat.o(117947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117948);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KZk);
      paramVarArgs.aM(2, this.MaY);
      paramVarArgs.aM(3, this.MRb);
      if (this.LPT != null) {
        paramVarArgs.e(4, this.LPT);
      }
      if (this.MlQ != null)
      {
        paramVarArgs.ni(5, this.MlQ.computeSize());
        this.MlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.Scene);
      if (this.KZj != null) {
        paramVarArgs.e(7, this.KZj);
      }
      paramVarArgs.aM(8, this.MRf);
      paramVarArgs.aM(9, this.NwG);
      paramVarArgs.e(10, 8, this.Nva);
      if (this.NwH != null) {
        paramVarArgs.e(11, this.NwH);
      }
      if (this.MEr != null) {
        paramVarArgs.e(12, this.MEr);
      }
      paramVarArgs.aM(13, this.NgA);
      if (this.NwI != null) {
        paramVarArgs.e(14, this.NwI);
      }
      if (this.MOi != null) {
        paramVarArgs.e(15, this.MOi);
      }
      paramVarArgs.e(16, 1, this.NwJ);
      paramVarArgs.aM(17, this.MRy);
      paramVarArgs.aM(18, this.oUv);
      paramVarArgs.aM(19, this.NwK);
      if (this.NwL != null)
      {
        paramVarArgs.ni(20, this.NwL.computeSize());
        this.NwL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KZk) + 0 + g.a.a.b.b.a.bu(2, this.MaY) + g.a.a.b.b.a.bu(3, this.MRb);
      paramInt = i;
      if (this.LPT != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LPT);
      }
      i = paramInt;
      if (this.MlQ != null) {
        i = paramInt + g.a.a.a.nh(5, this.MlQ.computeSize());
      }
      i += g.a.a.b.b.a.bu(6, this.Scene);
      paramInt = i;
      if (this.KZj != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KZj);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.MRf) + g.a.a.b.b.a.bu(9, this.NwG) + g.a.a.a.c(10, 8, this.Nva);
      paramInt = i;
      if (this.NwH != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.NwH);
      }
      i = paramInt;
      if (this.MEr != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MEr);
      }
      i += g.a.a.b.b.a.bu(13, this.NgA);
      paramInt = i;
      if (this.NwI != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.NwI);
      }
      i = paramInt;
      if (this.MOi != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MOi);
      }
      i = i + g.a.a.a.c(16, 1, this.NwJ) + g.a.a.b.b.a.bu(17, this.MRy) + g.a.a.b.b.a.bu(18, this.oUv) + g.a.a.b.b.a.bu(19, this.NwK);
      paramInt = i;
      if (this.NwL != null) {
        paramInt = i + g.a.a.a.nh(20, this.NwL.computeSize());
      }
      AppMethodBeat.o(117948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nva.clear();
      this.NwJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fal localfal = (fal)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117948);
        return -1;
      case 1: 
        localfal.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 2: 
        localfal.MaY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 3: 
        localfal.MRb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 4: 
        localfal.LPT = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfal.MlQ = ((chl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 6: 
        localfal.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 7: 
        localfal.KZj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 8: 
        localfal.MRf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 9: 
        localfal.NwG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aca();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfal.Nva.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 11: 
        localfal.NwH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 12: 
        localfal.MEr = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 13: 
        localfal.NgA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 14: 
        localfal.NwI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 15: 
        localfal.MOi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 16: 
        localfal.NwJ.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(117948);
        return 0;
      case 17: 
        localfal.MRy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 18: 
        localfal.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      case 19: 
        localfal.NwK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117948);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new beo();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((beo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localfal.NwL = ((beo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    AppMethodBeat.o(117948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fal
 * JD-Core Version:    0.7.0.1
 */