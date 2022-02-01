package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ewx
  extends erp
{
  public String Md5;
  public int YIE;
  public int ZaP;
  public int ZaQ;
  public String ZaR;
  public int ZtS;
  public fu abyY;
  public String abyZ;
  public String abza;
  public int abzb;
  public int abzc;
  public String pSi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32426);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abyY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Msg");
        AppMethodBeat.o(32426);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abyY != null)
      {
        paramVarArgs.qD(2, this.abyY.computeSize());
        this.abyY.writeFields(paramVarArgs);
      }
      if (this.abyZ != null) {
        paramVarArgs.g(3, this.abyZ);
      }
      paramVarArgs.bS(4, this.ZtS);
      if (this.Md5 != null) {
        paramVarArgs.g(5, this.Md5);
      }
      paramVarArgs.bS(6, this.YIE);
      if (this.pSi != null) {
        paramVarArgs.g(7, this.pSi);
      }
      if (this.abza != null) {
        paramVarArgs.g(8, this.abza);
      }
      paramVarArgs.bS(9, this.abzb);
      paramVarArgs.bS(10, this.ZaP);
      paramVarArgs.bS(11, this.ZaQ);
      paramVarArgs.bS(12, this.abzc);
      if (this.ZaR != null) {
        paramVarArgs.g(13, this.ZaR);
      }
      AppMethodBeat.o(32426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1061;
      }
    }
    label1061:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abyY != null) {
        paramInt = i + i.a.a.a.qC(2, this.abyY.computeSize());
      }
      i = paramInt;
      if (this.abyZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abyZ);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZtS);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Md5);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.YIE);
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.pSi);
      }
      i = paramInt;
      if (this.abza != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abza);
      }
      i = i + i.a.a.b.b.a.cJ(9, this.abzb) + i.a.a.b.b.a.cJ(10, this.ZaP) + i.a.a.b.b.a.cJ(11, this.ZaQ) + i.a.a.b.b.a.cJ(12, this.abzc);
      paramInt = i;
      if (this.ZaR != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ZaR);
      }
      AppMethodBeat.o(32426);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abyY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Msg");
          AppMethodBeat.o(32426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ewx localewx = (ewx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32426);
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
            localewx.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fu)localObject2).parseFrom((byte[])localObject1);
            }
            localewx.abyY = ((fu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 3: 
          localewx.abyZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 4: 
          localewx.ZtS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32426);
          return 0;
        case 5: 
          localewx.Md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 6: 
          localewx.YIE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32426);
          return 0;
        case 7: 
          localewx.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 8: 
          localewx.abza = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 9: 
          localewx.abzb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32426);
          return 0;
        case 10: 
          localewx.ZaP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32426);
          return 0;
        case 11: 
          localewx.ZaQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32426);
          return 0;
        case 12: 
          localewx.abzc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32426);
          return 0;
        }
        localewx.ZaR = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32426);
        return 0;
      }
      AppMethodBeat.o(32426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewx
 * JD-Core Version:    0.7.0.1
 */