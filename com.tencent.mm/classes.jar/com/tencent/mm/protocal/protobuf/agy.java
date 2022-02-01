package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agy
  extends erp
{
  public String Kmq;
  public String Zje;
  public String Zji;
  public String ZpZ;
  public long Zqa;
  public boolean Zqb;
  public int tNW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72466);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZpZ != null) {
        paramVarArgs.g(2, this.ZpZ);
      }
      paramVarArgs.bv(3, this.Zqa);
      if (this.Zje != null) {
        paramVarArgs.g(4, this.Zje);
      }
      if (this.Zji != null) {
        paramVarArgs.g(5, this.Zji);
      }
      paramVarArgs.bS(6, this.tNW);
      if (this.Kmq != null) {
        paramVarArgs.g(7, this.Kmq);
      }
      paramVarArgs.di(8, this.Zqb);
      AppMethodBeat.o(72466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label660;
      }
    }
    label660:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZpZ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZpZ);
      }
      i += i.a.a.b.b.a.q(3, this.Zqa);
      paramInt = i;
      if (this.Zje != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zje);
      }
      i = paramInt;
      if (this.Zji != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zji);
      }
      i += i.a.a.b.b.a.cJ(6, this.tNW);
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Kmq);
      }
      i = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(72466);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        agy localagy = (agy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72466);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localagy.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72466);
          return 0;
        case 2: 
          localagy.ZpZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 3: 
          localagy.Zqa = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(72466);
          return 0;
        case 4: 
          localagy.Zje = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 5: 
          localagy.Zji = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 6: 
          localagy.tNW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72466);
          return 0;
        case 7: 
          localagy.Kmq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72466);
          return 0;
        }
        localagy.Zqb = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(72466);
        return 0;
      }
      AppMethodBeat.o(72466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agy
 * JD-Core Version:    0.7.0.1
 */