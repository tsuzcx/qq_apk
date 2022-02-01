package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crq
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public boolean ROp;
  public String SMa;
  public int SOs;
  public boolean Snz;
  public String Srb;
  public int TgX;
  public int TyC;
  public LinkedList<String> TyD;
  public boolean TyE;
  public String TyF;
  public String TyG;
  public String TyH;
  public String TyI;
  public int TyJ;
  public xl TyK;
  public int end_time;
  public long klE;
  public int status;
  
  public crq()
  {
    AppMethodBeat.i(196358);
    this.TyD = new LinkedList();
    AppMethodBeat.o(196358);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196369);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.klE);
      if (this.Srb != null) {
        paramVarArgs.f(2, this.Srb);
      }
      paramVarArgs.aY(3, this.ChC);
      paramVarArgs.aY(4, this.end_time);
      paramVarArgs.aY(5, this.status);
      paramVarArgs.aY(6, this.SOs);
      paramVarArgs.aY(7, this.TyC);
      paramVarArgs.aY(8, this.TgX);
      if (this.SMa != null) {
        paramVarArgs.f(9, this.SMa);
      }
      paramVarArgs.e(10, 1, this.TyD);
      paramVarArgs.co(11, this.ROp);
      paramVarArgs.co(12, this.Snz);
      paramVarArgs.co(13, this.TyE);
      if (this.TyF != null) {
        paramVarArgs.f(14, this.TyF);
      }
      if (this.TyG != null) {
        paramVarArgs.f(15, this.TyG);
      }
      if (this.TyH != null) {
        paramVarArgs.f(16, this.TyH);
      }
      if (this.TyI != null) {
        paramVarArgs.f(17, this.TyI);
      }
      paramVarArgs.aY(18, this.TyJ);
      if (this.TyK != null)
      {
        paramVarArgs.oE(19, this.TyK.computeSize());
        this.TyK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(196369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.klE) + 0;
      paramInt = i;
      if (this.Srb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Srb);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.ChC) + g.a.a.b.b.a.bM(4, this.end_time) + g.a.a.b.b.a.bM(5, this.status) + g.a.a.b.b.a.bM(6, this.SOs) + g.a.a.b.b.a.bM(7, this.TyC) + g.a.a.b.b.a.bM(8, this.TgX);
      paramInt = i;
      if (this.SMa != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SMa);
      }
      i = paramInt + g.a.a.a.c(10, 1, this.TyD) + (g.a.a.b.b.a.gL(11) + 1) + (g.a.a.b.b.a.gL(12) + 1) + (g.a.a.b.b.a.gL(13) + 1);
      paramInt = i;
      if (this.TyF != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.TyF);
      }
      i = paramInt;
      if (this.TyG != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.TyG);
      }
      paramInt = i;
      if (this.TyH != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.TyH);
      }
      i = paramInt;
      if (this.TyI != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.TyI);
      }
      i += g.a.a.b.b.a.bM(18, this.TyJ);
      paramInt = i;
      if (this.TyK != null) {
        paramInt = i + g.a.a.a.oD(19, this.TyK.computeSize());
      }
      AppMethodBeat.o(196369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TyD.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(196369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      crq localcrq = (crq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(196369);
        return -1;
      case 1: 
        localcrq.klE = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(196369);
        return 0;
      case 2: 
        localcrq.Srb = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(196369);
        return 0;
      case 3: 
        localcrq.ChC = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196369);
        return 0;
      case 4: 
        localcrq.end_time = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196369);
        return 0;
      case 5: 
        localcrq.status = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196369);
        return 0;
      case 6: 
        localcrq.SOs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196369);
        return 0;
      case 7: 
        localcrq.TyC = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196369);
        return 0;
      case 8: 
        localcrq.TgX = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196369);
        return 0;
      case 9: 
        localcrq.SMa = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(196369);
        return 0;
      case 10: 
        localcrq.TyD.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(196369);
        return 0;
      case 11: 
        localcrq.ROp = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(196369);
        return 0;
      case 12: 
        localcrq.Snz = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(196369);
        return 0;
      case 13: 
        localcrq.TyE = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(196369);
        return 0;
      case 14: 
        localcrq.TyF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(196369);
        return 0;
      case 15: 
        localcrq.TyG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(196369);
        return 0;
      case 16: 
        localcrq.TyH = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(196369);
        return 0;
      case 17: 
        localcrq.TyI = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(196369);
        return 0;
      case 18: 
        localcrq.TyJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196369);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        xl localxl = new xl();
        if ((localObject != null) && (localObject.length > 0)) {
          localxl.parseFrom((byte[])localObject);
        }
        localcrq.TyK = localxl;
        paramInt += 1;
      }
      AppMethodBeat.o(196369);
      return 0;
    }
    AppMethodBeat.o(196369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crq
 * JD-Core Version:    0.7.0.1
 */