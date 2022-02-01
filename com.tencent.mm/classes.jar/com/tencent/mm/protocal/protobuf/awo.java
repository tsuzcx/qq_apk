package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class awo
  extends dyl
{
  public aqe RLM;
  public aqo SCW;
  public b SDI;
  public int SDJ;
  public LinkedList<bku> SFC;
  public ayv SHo;
  public awq SHq;
  public bka SJg;
  public LinkedList<cve> SJh;
  public bcz SJi;
  public int SJj;
  public bhj SJk;
  public int fUN;
  public float latitude;
  public float longitude;
  public String zDZ;
  
  public awo()
  {
    AppMethodBeat.i(229982);
    this.SJh = new LinkedList();
    this.SFC = new LinkedList();
    AppMethodBeat.o(229982);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229995);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(2, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      if (this.SDI != null) {
        paramVarArgs.c(3, this.SDI);
      }
      paramVarArgs.i(4, this.longitude);
      paramVarArgs.i(5, this.latitude);
      if (this.SCW != null)
      {
        paramVarArgs.oE(6, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      if (this.SHo != null)
      {
        paramVarArgs.oE(7, this.SHo.computeSize());
        this.SHo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.SDJ);
      if (this.SJg != null)
      {
        paramVarArgs.oE(9, this.SJg.computeSize());
        this.SJg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.SJh);
      paramVarArgs.e(11, 8, this.SFC);
      if (this.SJi != null)
      {
        paramVarArgs.oE(12, this.SJi.computeSize());
        this.SJi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.fUN);
      if (this.SHq != null)
      {
        paramVarArgs.oE(14, this.SHq.computeSize());
        this.SHq.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(15, this.SJj);
      if (this.SJk != null)
      {
        paramVarArgs.oE(16, this.SJk.computeSize());
        this.SJk.writeFields(paramVarArgs);
      }
      if (this.zDZ != null) {
        paramVarArgs.f(17, this.zDZ);
      }
      AppMethodBeat.o(229995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1812;
      }
    }
    label1812:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = paramInt;
      if (this.SDI != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SDI);
      }
      i = i + (g.a.a.b.b.a.gL(4) + 4) + (g.a.a.b.b.a.gL(5) + 4);
      paramInt = i;
      if (this.SCW != null) {
        paramInt = i + g.a.a.a.oD(6, this.SCW.computeSize());
      }
      i = paramInt;
      if (this.SHo != null) {
        i = paramInt + g.a.a.a.oD(7, this.SHo.computeSize());
      }
      i += g.a.a.b.b.a.bM(8, this.SDJ);
      paramInt = i;
      if (this.SJg != null) {
        paramInt = i + g.a.a.a.oD(9, this.SJg.computeSize());
      }
      i = paramInt + g.a.a.a.c(10, 8, this.SJh) + g.a.a.a.c(11, 8, this.SFC);
      paramInt = i;
      if (this.SJi != null) {
        paramInt = i + g.a.a.a.oD(12, this.SJi.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.fUN);
      paramInt = i;
      if (this.SHq != null) {
        paramInt = i + g.a.a.a.oD(14, this.SHq.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.SJj);
      paramInt = i;
      if (this.SJk != null) {
        paramInt = i + g.a.a.a.oD(16, this.SJk.computeSize());
      }
      i = paramInt;
      if (this.zDZ != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.zDZ);
      }
      AppMethodBeat.o(229995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SJh.clear();
        this.SFC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229995);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awo localawo = (awo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229995);
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
            localawo.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 3: 
          localawo.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229995);
          return 0;
        case 4: 
          localawo.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(229995);
          return 0;
        case 5: 
          localawo.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(229995);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqo)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.SCW = ((aqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ayv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ayv)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.SHo = ((ayv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 8: 
          localawo.SDJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229995);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bka();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bka)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.SJg = ((bka)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cve)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.SJh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bku)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.SFC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcz)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.SJi = ((bcz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 13: 
          localawo.fUN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229995);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awq)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.SHq = ((awq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        case 15: 
          localawo.SJj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229995);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bhj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bhj)localObject2).parseFrom((byte[])localObject1);
            }
            localawo.SJk = ((bhj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229995);
          return 0;
        }
        localawo.zDZ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(229995);
        return 0;
      }
      AppMethodBeat.o(229995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awo
 * JD-Core Version:    0.7.0.1
 */