package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class feh
  extends dyl
{
  public int SmH;
  public int Svu;
  public long Svv;
  public int TWa;
  public String TWw;
  public fev UCF;
  public fev UCG;
  public long UCJ;
  public int UCK;
  public int UCL;
  public LinkedList<dbt> UCM;
  public int UDF;
  public int UDR;
  public LinkedList<eaf> UDS;
  public int UDT;
  public int Uon;
  
  public feh()
  {
    AppMethodBeat.i(115883);
    this.UDS = new LinkedList();
    this.UCM = new LinkedList();
    AppMethodBeat.o(115883);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115884);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UCF == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.UCG == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TWw != null) {
        paramVarArgs.f(2, this.TWw);
      }
      paramVarArgs.aY(3, this.UDR);
      paramVarArgs.e(4, 8, this.UDS);
      if (this.UCF != null)
      {
        paramVarArgs.oE(6, this.UCF.computeSize());
        this.UCF.writeFields(paramVarArgs);
      }
      if (this.UCG != null)
      {
        paramVarArgs.oE(7, this.UCG.computeSize());
        this.UCG.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.SmH);
      paramVarArgs.aY(9, this.Uon);
      paramVarArgs.aY(10, this.Svu);
      paramVarArgs.bm(11, this.Svv);
      paramVarArgs.aY(12, this.UDF);
      paramVarArgs.bm(13, this.UCJ);
      paramVarArgs.aY(14, this.UDT);
      paramVarArgs.aY(15, this.TWa);
      paramVarArgs.aY(16, this.UCK);
      paramVarArgs.aY(17, this.UCL);
      paramVarArgs.e(18, 8, this.UCM);
      AppMethodBeat.o(115884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1476;
      }
    }
    label1476:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TWw != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TWw);
      }
      i = i + g.a.a.b.b.a.bM(3, this.UDR) + g.a.a.a.c(4, 8, this.UDS);
      paramInt = i;
      if (this.UCF != null) {
        paramInt = i + g.a.a.a.oD(6, this.UCF.computeSize());
      }
      i = paramInt;
      if (this.UCG != null) {
        i = paramInt + g.a.a.a.oD(7, this.UCG.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(8, this.SmH);
      int j = g.a.a.b.b.a.bM(9, this.Uon);
      int k = g.a.a.b.b.a.bM(10, this.Svu);
      int m = g.a.a.b.b.a.p(11, this.Svv);
      int n = g.a.a.b.b.a.bM(12, this.UDF);
      int i1 = g.a.a.b.b.a.p(13, this.UCJ);
      int i2 = g.a.a.b.b.a.bM(14, this.UDT);
      int i3 = g.a.a.b.b.a.bM(15, this.TWa);
      int i4 = g.a.a.b.b.a.bM(16, this.UCK);
      int i5 = g.a.a.b.b.a.bM(17, this.UCL);
      int i6 = g.a.a.a.c(18, 8, this.UCM);
      AppMethodBeat.o(115884);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UDS.clear();
        this.UCM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UCF == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        if (this.UCG == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        feh localfeh = (feh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115884);
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
            localfeh.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 2: 
          localfeh.TWw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115884);
          return 0;
        case 3: 
          localfeh.UDR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfeh.UDS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fev();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fev)localObject2).parseFrom((byte[])localObject1);
            }
            localfeh.UCF = ((fev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fev();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fev)localObject2).parseFrom((byte[])localObject1);
            }
            localfeh.UCG = ((fev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 8: 
          localfeh.SmH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        case 9: 
          localfeh.Uon = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        case 10: 
          localfeh.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        case 11: 
          localfeh.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115884);
          return 0;
        case 12: 
          localfeh.UDF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        case 13: 
          localfeh.UCJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115884);
          return 0;
        case 14: 
          localfeh.UDT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        case 15: 
          localfeh.TWa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        case 16: 
          localfeh.UCK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        case 17: 
          localfeh.UCL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115884);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbt)localObject2).parseFrom((byte[])localObject1);
          }
          localfeh.UCM.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      AppMethodBeat.o(115884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feh
 * JD-Core Version:    0.7.0.1
 */