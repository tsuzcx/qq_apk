package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ecq
  extends erp
{
  public int YJZ;
  public int Zbd;
  public bi Zbi;
  public String abif;
  public String abig;
  public b abih;
  public int abii;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91598);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abif != null) {
        paramVarArgs.g(2, this.abif);
      }
      if (this.abig != null) {
        paramVarArgs.g(3, this.abig);
      }
      if (this.abih != null) {
        paramVarArgs.d(4, this.abih);
      }
      paramVarArgs.bS(5, this.Zbd);
      paramVarArgs.bS(6, this.YJZ);
      paramVarArgs.bS(7, this.abii);
      if (this.Zbi != null)
      {
        paramVarArgs.qD(8, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label730;
      }
    }
    label730:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abif != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abif);
      }
      i = paramInt;
      if (this.abig != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abig);
      }
      paramInt = i;
      if (this.abih != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.abih);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Zbd) + i.a.a.b.b.a.cJ(6, this.YJZ) + i.a.a.b.b.a.cJ(7, this.abii);
      paramInt = i;
      if (this.Zbi != null) {
        paramInt = i + i.a.a.a.qC(8, this.Zbi.computeSize());
      }
      AppMethodBeat.o(91598);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ecq localecq = (ecq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91598);
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
            localecq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91598);
          return 0;
        case 2: 
          localecq.abif = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 3: 
          localecq.abig = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 4: 
          localecq.abih = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(91598);
          return 0;
        case 5: 
          localecq.Zbd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91598);
          return 0;
        case 6: 
          localecq.YJZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91598);
          return 0;
        case 7: 
          localecq.abii = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91598);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bi)localObject2).parseFrom((byte[])localObject1);
          }
          localecq.Zbi = ((bi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      AppMethodBeat.o(91598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecq
 * JD-Core Version:    0.7.0.1
 */