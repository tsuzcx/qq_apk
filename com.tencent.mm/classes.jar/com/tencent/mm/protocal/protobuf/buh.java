package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class buh
  extends dyy
{
  public eae RJA;
  public LinkedList<akh> Tek;
  public int Teo;
  public LinkedList<ajy> Tep;
  public int VHV;
  public aju VHW;
  public int VHX;
  public LinkedList<aju> VHY;
  public int VHZ;
  public LinkedList<ajw> VIa;
  public int VIb;
  public int VIc;
  public int VId;
  public LinkedList<ajw> VIe;
  public String VIf;
  
  public buh()
  {
    AppMethodBeat.i(104800);
    this.Tek = new LinkedList();
    this.VHY = new LinkedList();
    this.Tep = new LinkedList();
    this.VIa = new LinkedList();
    this.VIe = new LinkedList();
    AppMethodBeat.o(104800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104801);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104801);
        throw paramVarArgs;
      }
      if (this.RJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RJA != null)
      {
        paramVarArgs.oE(2, this.RJA.computeSize());
        this.RJA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.VHV);
      paramVarArgs.e(4, 8, this.Tek);
      if (this.VHW != null)
      {
        paramVarArgs.oE(5, this.VHW.computeSize());
        this.VHW.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.VHX);
      paramVarArgs.e(7, 8, this.VHY);
      paramVarArgs.aY(8, this.Teo);
      paramVarArgs.e(9, 8, this.Tep);
      paramVarArgs.aY(10, this.VHZ);
      paramVarArgs.e(11, 8, this.VIa);
      paramVarArgs.aY(12, this.VIb);
      paramVarArgs.aY(13, this.VIc);
      paramVarArgs.aY(14, this.VId);
      paramVarArgs.e(15, 8, this.VIe);
      if (this.VIf != null) {
        paramVarArgs.f(16, this.VIf);
      }
      AppMethodBeat.o(104801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1606;
      }
    }
    label1606:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RJA != null) {
        i = paramInt + g.a.a.a.oD(2, this.RJA.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.VHV) + g.a.a.a.c(4, 8, this.Tek);
      paramInt = i;
      if (this.VHW != null) {
        paramInt = i + g.a.a.a.oD(5, this.VHW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.VHX) + g.a.a.a.c(7, 8, this.VHY) + g.a.a.b.b.a.bM(8, this.Teo) + g.a.a.a.c(9, 8, this.Tep) + g.a.a.b.b.a.bM(10, this.VHZ) + g.a.a.a.c(11, 8, this.VIa) + g.a.a.b.b.a.bM(12, this.VIb) + g.a.a.b.b.a.bM(13, this.VIc) + g.a.a.b.b.a.bM(14, this.VId) + g.a.a.a.c(15, 8, this.VIe);
      paramInt = i;
      if (this.VIf != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.VIf);
      }
      AppMethodBeat.o(104801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tek.clear();
        this.VHY.clear();
        this.Tep.clear();
        this.VIa.clear();
        this.VIe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104801);
          throw paramVarArgs;
        }
        if (this.RJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        buh localbuh = (buh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104801);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbuh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 2: 
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
            localbuh.RJA = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 3: 
          localbuh.VHV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104801);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akh)localObject2).parseFrom((byte[])localObject1);
            }
            localbuh.Tek.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aju();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aju)localObject2).parseFrom((byte[])localObject1);
            }
            localbuh.VHW = ((aju)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 6: 
          localbuh.VHX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104801);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aju();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aju)localObject2).parseFrom((byte[])localObject1);
            }
            localbuh.VHY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 8: 
          localbuh.Teo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104801);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ajy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ajy)localObject2).parseFrom((byte[])localObject1);
            }
            localbuh.Tep.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 10: 
          localbuh.VHZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104801);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ajw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ajw)localObject2).parseFrom((byte[])localObject1);
            }
            localbuh.VIa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 12: 
          localbuh.VIb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104801);
          return 0;
        case 13: 
          localbuh.VIc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104801);
          return 0;
        case 14: 
          localbuh.VId = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104801);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ajw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ajw)localObject2).parseFrom((byte[])localObject1);
            }
            localbuh.VIe.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        }
        localbuh.VIf = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(104801);
        return 0;
      }
      AppMethodBeat.o(104801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buh
 * JD-Core Version:    0.7.0.1
 */