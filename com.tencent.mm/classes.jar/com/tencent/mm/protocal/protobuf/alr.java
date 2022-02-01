package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alr
  extends com.tencent.mm.bx.a
{
  public LinkedList<fcy> MRf;
  public String YBi;
  public fcd ZsM;
  public fcq ZsN;
  public long ZsO;
  public etq ZsP;
  public int ZsQ;
  public long ZsR;
  public long ZsS;
  public int ZsT;
  public String ZsU;
  
  public alr()
  {
    AppMethodBeat.i(257893);
    this.MRf = new LinkedList();
    AppMethodBeat.o(257893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257902);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YBi != null) {
        paramVarArgs.g(1, this.YBi);
      }
      if (this.ZsM != null)
      {
        paramVarArgs.qD(2, this.ZsM.computeSize());
        this.ZsM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.MRf);
      if (this.ZsN != null)
      {
        paramVarArgs.qD(4, this.ZsN.computeSize());
        this.ZsN.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.ZsO);
      if (this.ZsP != null)
      {
        paramVarArgs.qD(6, this.ZsP.computeSize());
        this.ZsP.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.ZsQ);
      paramVarArgs.bv(8, this.ZsR);
      paramVarArgs.bv(9, this.ZsS);
      paramVarArgs.bS(10, this.ZsT);
      if (this.ZsU != null) {
        paramVarArgs.g(11, this.ZsU);
      }
      AppMethodBeat.o(257902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YBi == null) {
        break label1014;
      }
    }
    label1014:
    for (paramInt = i.a.a.b.b.a.h(1, this.YBi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZsM != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZsM.computeSize());
      }
      i += i.a.a.a.c(3, 8, this.MRf);
      paramInt = i;
      if (this.ZsN != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZsN.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.ZsO);
      paramInt = i;
      if (this.ZsP != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZsP.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.ZsQ) + i.a.a.b.b.a.q(8, this.ZsR) + i.a.a.b.b.a.q(9, this.ZsS) + i.a.a.b.b.a.cJ(10, this.ZsT);
      paramInt = i;
      if (this.ZsU != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZsU);
      }
      AppMethodBeat.o(257902);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MRf.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        alr localalr = (alr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257902);
          return -1;
        case 1: 
          localalr.YBi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257902);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcd)localObject2).parseFrom((byte[])localObject1);
            }
            localalr.ZsM = ((fcd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257902);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcy)localObject2).parseFrom((byte[])localObject1);
            }
            localalr.MRf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257902);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcq)localObject2).parseFrom((byte[])localObject1);
            }
            localalr.ZsN = ((fcq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257902);
          return 0;
        case 5: 
          localalr.ZsO = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257902);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etq)localObject2).parseFrom((byte[])localObject1);
            }
            localalr.ZsP = ((etq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257902);
          return 0;
        case 7: 
          localalr.ZsQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257902);
          return 0;
        case 8: 
          localalr.ZsR = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257902);
          return 0;
        case 9: 
          localalr.ZsS = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257902);
          return 0;
        case 10: 
          localalr.ZsT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257902);
          return 0;
        }
        localalr.ZsU = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257902);
        return 0;
      }
      AppMethodBeat.o(257902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alr
 * JD-Core Version:    0.7.0.1
 */