package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cva
  extends dyl
{
  public String Dtb;
  public String RGL;
  public iz RMG;
  public String RMH;
  public int RMI;
  public String RMJ;
  public String RMK;
  public int RML;
  public eae RMM;
  public eae RMN;
  public String RMO;
  public dpr RMP;
  public String StL;
  public String TCG;
  public String TCH;
  public String TCI;
  public int TCJ;
  public String jUb;
  public String jUc;
  public int jUj;
  public String mVB;
  public String rVG;
  public String vhp;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133176);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RMG != null)
      {
        paramVarArgs.oE(2, this.RMG.computeSize());
        this.RMG.writeFields(paramVarArgs);
      }
      if (this.Dtb != null) {
        paramVarArgs.f(3, this.Dtb);
      }
      if (this.RMH != null) {
        paramVarArgs.f(4, this.RMH);
      }
      paramVarArgs.aY(5, this.RMI);
      if (this.RMJ != null) {
        paramVarArgs.f(6, this.RMJ);
      }
      if (this.mVB != null) {
        paramVarArgs.f(7, this.mVB);
      }
      if (this.rVG != null) {
        paramVarArgs.f(8, this.rVG);
      }
      if (this.RMK != null) {
        paramVarArgs.f(9, this.RMK);
      }
      if (this.vhq != null) {
        paramVarArgs.f(10, this.vhq);
      }
      if (this.vhp != null) {
        paramVarArgs.f(11, this.vhp);
      }
      paramVarArgs.aY(13, this.RML);
      paramVarArgs.aY(14, this.jUj);
      if (this.jUc != null) {
        paramVarArgs.f(15, this.jUc);
      }
      if (this.jUb != null) {
        paramVarArgs.f(16, this.jUb);
      }
      if (this.TCG != null) {
        paramVarArgs.f(17, this.TCG);
      }
      if (this.StL != null) {
        paramVarArgs.f(18, this.StL);
      }
      if (this.RMO != null) {
        paramVarArgs.f(19, this.RMO);
      }
      if (this.TCH != null) {
        paramVarArgs.f(20, this.TCH);
      }
      if (this.TCI != null) {
        paramVarArgs.f(21, this.TCI);
      }
      paramVarArgs.aY(22, this.TCJ);
      if (this.RMM != null)
      {
        paramVarArgs.oE(23, this.RMM.computeSize());
        this.RMM.writeFields(paramVarArgs);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(24, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      if (this.RGL != null) {
        paramVarArgs.f(25, this.RGL);
      }
      if (this.RMP != null)
      {
        paramVarArgs.oE(26, this.RMP.computeSize());
        this.RMP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133176);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1996;
      }
    }
    label1996:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RMG != null) {
        paramInt = i + g.a.a.a.oD(2, this.RMG.computeSize());
      }
      i = paramInt;
      if (this.Dtb != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Dtb);
      }
      paramInt = i;
      if (this.RMH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RMH);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RMI);
      paramInt = i;
      if (this.RMJ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RMJ);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.mVB);
      }
      paramInt = i;
      if (this.rVG != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.rVG);
      }
      i = paramInt;
      if (this.RMK != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RMK);
      }
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.vhq);
      }
      i = paramInt;
      if (this.vhp != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.vhp);
      }
      i = i + g.a.a.b.b.a.bM(13, this.RML) + g.a.a.b.b.a.bM(14, this.jUj);
      paramInt = i;
      if (this.jUc != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.jUc);
      }
      i = paramInt;
      if (this.jUb != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.jUb);
      }
      paramInt = i;
      if (this.TCG != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.TCG);
      }
      i = paramInt;
      if (this.StL != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.StL);
      }
      paramInt = i;
      if (this.RMO != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.RMO);
      }
      i = paramInt;
      if (this.TCH != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.TCH);
      }
      paramInt = i;
      if (this.TCI != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.TCI);
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.TCJ);
      paramInt = i;
      if (this.RMM != null) {
        paramInt = i + g.a.a.a.oD(23, this.RMM.computeSize());
      }
      i = paramInt;
      if (this.RMN != null) {
        i = paramInt + g.a.a.a.oD(24, this.RMN.computeSize());
      }
      paramInt = i;
      if (this.RGL != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.RGL);
      }
      i = paramInt;
      if (this.RMP != null) {
        i = paramInt + g.a.a.a.oD(26, this.RMP.computeSize());
      }
      AppMethodBeat.o(133176);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cva localcva = (cva)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 12: 
        default: 
          AppMethodBeat.o(133176);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcva.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new iz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((iz)localObject2).parseFrom((byte[])localObject1);
            }
            localcva.RMG = ((iz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 3: 
          localcva.Dtb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 4: 
          localcva.RMH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 5: 
          localcva.RMI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133176);
          return 0;
        case 6: 
          localcva.RMJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 7: 
          localcva.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 8: 
          localcva.rVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 9: 
          localcva.RMK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 10: 
          localcva.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 11: 
          localcva.vhp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 13: 
          localcva.RML = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133176);
          return 0;
        case 14: 
          localcva.jUj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133176);
          return 0;
        case 15: 
          localcva.jUc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 16: 
          localcva.jUb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 17: 
          localcva.TCG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 18: 
          localcva.StL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 19: 
          localcva.RMO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 20: 
          localcva.TCH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 21: 
          localcva.TCI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 22: 
          localcva.TCJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133176);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localcva.RMM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localcva.RMN = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 25: 
          localcva.RGL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133176);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dpr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dpr)localObject2).parseFrom((byte[])localObject1);
          }
          localcva.RMP = ((dpr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      AppMethodBeat.o(133176);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cva
 * JD-Core Version:    0.7.0.1
 */