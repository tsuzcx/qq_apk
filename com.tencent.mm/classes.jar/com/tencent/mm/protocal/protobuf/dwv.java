package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dwv
  extends com.tencent.mm.bw.a
{
  public int KHo;
  public String LRO;
  public String Lir;
  public String Lis;
  public int MWP;
  public SKBuiltinBuffer_t MWQ;
  public int MWR;
  public String MbK;
  public String MmJ;
  public int MmK;
  public String MmL;
  public String MmM;
  public String MmN;
  public int MmO;
  public int MmP;
  public ebj MmQ;
  public aeq MmR;
  public String UserName;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public String keh;
  public String kei;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32440);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MWQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuffer");
        AppMethodBeat.o(32440);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.kdZ != null) {
        paramVarArgs.e(3, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(4, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(5, this.keb);
      }
      if (this.MmJ != null) {
        paramVarArgs.e(6, this.MmJ);
      }
      paramVarArgs.aM(7, this.kdY);
      paramVarArgs.aM(8, this.KHo);
      paramVarArgs.aM(9, this.MWP);
      if (this.MWQ != null)
      {
        paramVarArgs.ni(10, this.MWQ.computeSize());
        this.MWQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.MWR);
      if (this.MmM != null) {
        paramVarArgs.e(12, this.MmM);
      }
      if (this.MmN != null) {
        paramVarArgs.e(13, this.MmN);
      }
      paramVarArgs.aM(14, this.MmO);
      paramVarArgs.aM(15, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(16, this.MmL);
      }
      if (this.MbK != null) {
        paramVarArgs.e(17, this.MbK);
      }
      paramVarArgs.aM(21, this.MmP);
      if (this.MmQ != null)
      {
        paramVarArgs.ni(22, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.keh != null) {
        paramVarArgs.e(23, this.keh);
      }
      if (this.Lir != null) {
        paramVarArgs.e(24, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(25, this.Lis);
      }
      if (this.kei != null) {
        paramVarArgs.e(26, this.kei);
      }
      if (this.MmR != null)
      {
        paramVarArgs.ni(27, this.MmR.computeSize());
        this.MmR.writeFields(paramVarArgs);
      }
      if (this.LRO != null) {
        paramVarArgs.e(28, this.LRO);
      }
      AppMethodBeat.o(32440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1953;
      }
    }
    label1953:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.kdZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.kdZ);
      }
      paramInt = i;
      if (this.kea != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.kea);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.keb);
      }
      paramInt = i;
      if (this.MmJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MmJ);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.kdY) + g.a.a.b.b.a.bu(8, this.KHo) + g.a.a.b.b.a.bu(9, this.MWP);
      paramInt = i;
      if (this.MWQ != null) {
        paramInt = i + g.a.a.a.nh(10, this.MWQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.MWR);
      paramInt = i;
      if (this.MmM != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MmM);
      }
      i = paramInt;
      if (this.MmN != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MmN);
      }
      i = i + g.a.a.b.b.a.bu(14, this.MmO) + g.a.a.b.b.a.bu(15, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.MmL);
      }
      i = paramInt;
      if (this.MbK != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.MbK);
      }
      i += g.a.a.b.b.a.bu(21, this.MmP);
      paramInt = i;
      if (this.MmQ != null) {
        paramInt = i + g.a.a.a.nh(22, this.MmQ.computeSize());
      }
      i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.keh);
      }
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(25, this.Lis);
      }
      paramInt = i;
      if (this.kei != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.kei);
      }
      i = paramInt;
      if (this.MmR != null) {
        i = paramInt + g.a.a.a.nh(27, this.MmR.computeSize());
      }
      paramInt = i;
      if (this.LRO != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.LRO);
      }
      AppMethodBeat.o(32440);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MWQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuffer");
          AppMethodBeat.o(32440);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dwv localdwv = (dwv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(32440);
          return -1;
        case 1: 
          localdwv.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 2: 
          localdwv.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 3: 
          localdwv.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 4: 
          localdwv.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 5: 
          localdwv.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 6: 
          localdwv.MmJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 7: 
          localdwv.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32440);
          return 0;
        case 8: 
          localdwv.KHo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32440);
          return 0;
        case 9: 
          localdwv.MWP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32440);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwv.MWQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 11: 
          localdwv.MWR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32440);
          return 0;
        case 12: 
          localdwv.MmM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 13: 
          localdwv.MmN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 14: 
          localdwv.MmO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32440);
          return 0;
        case 15: 
          localdwv.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32440);
          return 0;
        case 16: 
          localdwv.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 17: 
          localdwv.MbK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 21: 
          localdwv.MmP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32440);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwv.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 23: 
          localdwv.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 24: 
          localdwv.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 25: 
          localdwv.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 26: 
          localdwv.kei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 27: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwv.MmR = ((aeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        }
        localdwv.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32440);
        return 0;
      }
      AppMethodBeat.o(32440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwv
 * JD-Core Version:    0.7.0.1
 */