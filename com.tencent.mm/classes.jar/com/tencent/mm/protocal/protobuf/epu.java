package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epu
  extends erp
{
  public int YPI;
  public LinkedList<pw> abtM;
  public int abtN;
  public int abtO;
  public long abtP;
  public int abtQ;
  public long abtR;
  public int scene;
  
  public epu()
  {
    AppMethodBeat.i(6424);
    this.abtM = new LinkedList();
    AppMethodBeat.o(6424);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6425);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.abtM);
      paramVarArgs.bS(3, this.abtN);
      paramVarArgs.bS(4, this.abtO);
      paramVarArgs.bS(5, this.YPI);
      paramVarArgs.bv(6, this.abtP);
      paramVarArgs.bS(7, this.scene);
      paramVarArgs.bS(8, this.abtQ);
      paramVarArgs.bv(9, this.abtR);
      AppMethodBeat.o(6425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label749;
      }
    }
    label749:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.abtM);
      int j = i.a.a.b.b.a.cJ(3, this.abtN);
      int k = i.a.a.b.b.a.cJ(4, this.abtO);
      int m = i.a.a.b.b.a.cJ(5, this.YPI);
      int n = i.a.a.b.b.a.q(6, this.abtP);
      int i1 = i.a.a.b.b.a.cJ(7, this.scene);
      int i2 = i.a.a.b.b.a.cJ(8, this.abtQ);
      int i3 = i.a.a.b.b.a.q(9, this.abtR);
      AppMethodBeat.o(6425);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abtM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        epu localepu = (epu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6425);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localepu.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pw)localObject2).parseFrom((byte[])localObject1);
            }
            localepu.abtM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 3: 
          localepu.abtN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6425);
          return 0;
        case 4: 
          localepu.abtO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6425);
          return 0;
        case 5: 
          localepu.YPI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6425);
          return 0;
        case 6: 
          localepu.abtP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(6425);
          return 0;
        case 7: 
          localepu.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6425);
          return 0;
        case 8: 
          localepu.abtQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6425);
          return 0;
        }
        localepu.abtR = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(6425);
        return 0;
      }
      AppMethodBeat.o(6425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epu
 * JD-Core Version:    0.7.0.1
 */