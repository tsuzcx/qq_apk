package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ij
  extends erp
{
  public String Jmq;
  public String YDN;
  public jv YJU;
  public String YJV;
  public int YJW;
  public String YJX;
  public String YJY;
  public int YJZ;
  public gol YJj;
  public gol YKa;
  public gol YKb;
  public String YKc;
  public eil YKd;
  public String pSi;
  public String vgW;
  public String ytr;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133146);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YJj == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133146);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YJU != null)
      {
        paramVarArgs.qD(2, this.YJU.computeSize());
        this.YJU.writeFields(paramVarArgs);
      }
      if (this.YJj != null)
      {
        paramVarArgs.qD(3, this.YJj.computeSize());
        this.YJj.writeFields(paramVarArgs);
      }
      if (this.Jmq != null) {
        paramVarArgs.g(4, this.Jmq);
      }
      if (this.YJV != null) {
        paramVarArgs.g(5, this.YJV);
      }
      paramVarArgs.bS(6, this.YJW);
      if (this.YJX != null) {
        paramVarArgs.g(7, this.YJX);
      }
      if (this.pSi != null) {
        paramVarArgs.g(8, this.pSi);
      }
      if (this.vgW != null) {
        paramVarArgs.g(9, this.vgW);
      }
      if (this.YJY != null) {
        paramVarArgs.g(10, this.YJY);
      }
      if (this.yts != null) {
        paramVarArgs.g(11, this.yts);
      }
      if (this.ytr != null) {
        paramVarArgs.g(12, this.ytr);
      }
      paramVarArgs.bS(13, this.YJZ);
      if (this.YKa != null)
      {
        paramVarArgs.qD(14, this.YKa.computeSize());
        this.YKa.writeFields(paramVarArgs);
      }
      if (this.YKb != null)
      {
        paramVarArgs.qD(15, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      if (this.YKc != null) {
        paramVarArgs.g(16, this.YKc);
      }
      if (this.YDN != null) {
        paramVarArgs.g(17, this.YDN);
      }
      if (this.YKd != null)
      {
        paramVarArgs.qD(18, this.YKd.computeSize());
        this.YKd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1706;
      }
    }
    label1706:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YJU != null) {
        paramInt = i + i.a.a.a.qC(2, this.YJU.computeSize());
      }
      i = paramInt;
      if (this.YJj != null) {
        i = paramInt + i.a.a.a.qC(3, this.YJj.computeSize());
      }
      paramInt = i;
      if (this.Jmq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Jmq);
      }
      i = paramInt;
      if (this.YJV != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YJV);
      }
      i += i.a.a.b.b.a.cJ(6, this.YJW);
      paramInt = i;
      if (this.YJX != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YJX);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.pSi);
      }
      paramInt = i;
      if (this.vgW != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.vgW);
      }
      i = paramInt;
      if (this.YJY != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YJY);
      }
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.yts);
      }
      i = paramInt;
      if (this.ytr != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.ytr);
      }
      i += i.a.a.b.b.a.cJ(13, this.YJZ);
      paramInt = i;
      if (this.YKa != null) {
        paramInt = i + i.a.a.a.qC(14, this.YKa.computeSize());
      }
      i = paramInt;
      if (this.YKb != null) {
        i = paramInt + i.a.a.a.qC(15, this.YKb.computeSize());
      }
      paramInt = i;
      if (this.YKc != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.YKc);
      }
      i = paramInt;
      if (this.YDN != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.YDN);
      }
      paramInt = i;
      if (this.YKd != null) {
        paramInt = i + i.a.a.a.qC(18, this.YKd.computeSize());
      }
      AppMethodBeat.o(133146);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YJj == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ij localij = (ij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133146);
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
            localij.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jv)localObject2).parseFrom((byte[])localObject1);
            }
            localij.YJU = ((jv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localij.YJj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 4: 
          localij.Jmq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 5: 
          localij.YJV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 6: 
          localij.YJW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133146);
          return 0;
        case 7: 
          localij.YJX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 8: 
          localij.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 9: 
          localij.vgW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 10: 
          localij.YJY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 11: 
          localij.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 12: 
          localij.ytr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 13: 
          localij.YJZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133146);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localij.YKa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localij.YKb = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 16: 
          localij.YKc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 17: 
          localij.YDN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133146);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eil();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eil)localObject2).parseFrom((byte[])localObject1);
          }
          localij.YKd = ((eil)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ij
 * JD-Core Version:    0.7.0.1
 */