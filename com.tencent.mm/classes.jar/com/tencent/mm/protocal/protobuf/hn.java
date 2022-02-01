package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class hn
  extends dyl
{
  public String Dtb;
  public String RGL;
  public eae RLV;
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
  public String mVB;
  public String rVG;
  public String vhp;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133146);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLV == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133146);
        throw paramVarArgs;
      }
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
      if (this.RLV != null)
      {
        paramVarArgs.oE(3, this.RLV.computeSize());
        this.RLV.writeFields(paramVarArgs);
      }
      if (this.Dtb != null) {
        paramVarArgs.f(4, this.Dtb);
      }
      if (this.RMH != null) {
        paramVarArgs.f(5, this.RMH);
      }
      paramVarArgs.aY(6, this.RMI);
      if (this.RMJ != null) {
        paramVarArgs.f(7, this.RMJ);
      }
      if (this.mVB != null) {
        paramVarArgs.f(8, this.mVB);
      }
      if (this.rVG != null) {
        paramVarArgs.f(9, this.rVG);
      }
      if (this.RMK != null) {
        paramVarArgs.f(10, this.RMK);
      }
      if (this.vhq != null) {
        paramVarArgs.f(11, this.vhq);
      }
      if (this.vhp != null) {
        paramVarArgs.f(12, this.vhp);
      }
      paramVarArgs.aY(13, this.RML);
      if (this.RMM != null)
      {
        paramVarArgs.oE(14, this.RMM.computeSize());
        this.RMM.writeFields(paramVarArgs);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(15, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      if (this.RMO != null) {
        paramVarArgs.f(16, this.RMO);
      }
      if (this.RGL != null) {
        paramVarArgs.f(17, this.RGL);
      }
      if (this.RMP != null)
      {
        paramVarArgs.oE(18, this.RMP.computeSize());
        this.RMP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1710;
      }
    }
    label1710:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RMG != null) {
        paramInt = i + g.a.a.a.oD(2, this.RMG.computeSize());
      }
      i = paramInt;
      if (this.RLV != null) {
        i = paramInt + g.a.a.a.oD(3, this.RLV.computeSize());
      }
      paramInt = i;
      if (this.Dtb != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Dtb);
      }
      i = paramInt;
      if (this.RMH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RMH);
      }
      i += g.a.a.b.b.a.bM(6, this.RMI);
      paramInt = i;
      if (this.RMJ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RMJ);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.mVB);
      }
      paramInt = i;
      if (this.rVG != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.rVG);
      }
      i = paramInt;
      if (this.RMK != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.RMK);
      }
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.vhq);
      }
      i = paramInt;
      if (this.vhp != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.vhp);
      }
      i += g.a.a.b.b.a.bM(13, this.RML);
      paramInt = i;
      if (this.RMM != null) {
        paramInt = i + g.a.a.a.oD(14, this.RMM.computeSize());
      }
      i = paramInt;
      if (this.RMN != null) {
        i = paramInt + g.a.a.a.oD(15, this.RMN.computeSize());
      }
      paramInt = i;
      if (this.RMO != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.RMO);
      }
      i = paramInt;
      if (this.RGL != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.RGL);
      }
      paramInt = i;
      if (this.RMP != null) {
        paramInt = i + g.a.a.a.oD(18, this.RMP.computeSize());
      }
      AppMethodBeat.o(133146);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RLV == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hn localhn = (hn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133146);
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
            localhn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
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
            localhn.RMG = ((iz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 3: 
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
            localhn.RLV = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 4: 
          localhn.Dtb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 5: 
          localhn.RMH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 6: 
          localhn.RMI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133146);
          return 0;
        case 7: 
          localhn.RMJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 8: 
          localhn.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 9: 
          localhn.rVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 10: 
          localhn.RMK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 11: 
          localhn.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 12: 
          localhn.vhp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 13: 
          localhn.RML = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133146);
          return 0;
        case 14: 
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
            localhn.RMM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 15: 
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
            localhn.RMN = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 16: 
          localhn.RMO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 17: 
          localhn.RGL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133146);
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
          localhn.RMP = ((dpr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      AppMethodBeat.o(133146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hn
 * JD-Core Version:    0.7.0.1
 */