package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class chi
  extends com.tencent.mm.bw.a
{
  public int KHa;
  public int KHo;
  public String LRO;
  public String Lir;
  public String Lis;
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
  public int MmS;
  public String UserName;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public String ked;
  public String keh;
  public String kei;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
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
      paramVarArgs.aM(9, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(10, this.MmL);
      }
      if (this.MbK != null) {
        paramVarArgs.e(11, this.MbK);
      }
      if (this.ked != null) {
        paramVarArgs.e(12, this.ked);
      }
      if (this.MmM != null) {
        paramVarArgs.e(13, this.MmM);
      }
      if (this.MmN != null) {
        paramVarArgs.e(14, this.MmN);
      }
      paramVarArgs.aM(15, this.MmO);
      paramVarArgs.aM(19, this.MmP);
      if (this.MmQ != null)
      {
        paramVarArgs.ni(20, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.keh != null) {
        paramVarArgs.e(21, this.keh);
      }
      if (this.Lir != null) {
        paramVarArgs.e(22, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(23, this.Lis);
      }
      if (this.kei != null) {
        paramVarArgs.e(24, this.kei);
      }
      if (this.MmR != null)
      {
        paramVarArgs.ni(25, this.MmR.computeSize());
        this.MmR.writeFields(paramVarArgs);
      }
      if (this.LRO != null) {
        paramVarArgs.e(26, this.LRO);
      }
      paramVarArgs.aM(27, this.KHa);
      paramVarArgs.aM(28, this.MmS);
      AppMethodBeat.o(89925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1782;
      }
    }
    label1782:
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
      i = paramInt + g.a.a.b.b.a.bu(7, this.kdY) + g.a.a.b.b.a.bu(8, this.KHo) + g.a.a.b.b.a.bu(9, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MmL);
      }
      i = paramInt;
      if (this.MbK != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MbK);
      }
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.ked);
      }
      i = paramInt;
      if (this.MmM != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MmM);
      }
      paramInt = i;
      if (this.MmN != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MmN);
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.MmO) + g.a.a.b.b.a.bu(19, this.MmP);
      paramInt = i;
      if (this.MmQ != null) {
        paramInt = i + g.a.a.a.nh(20, this.MmQ.computeSize());
      }
      i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.keh);
      }
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.Lis);
      }
      paramInt = i;
      if (this.kei != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.kei);
      }
      i = paramInt;
      if (this.MmR != null) {
        i = paramInt + g.a.a.a.nh(25, this.MmR.computeSize());
      }
      paramInt = i;
      if (this.LRO != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.LRO);
      }
      i = g.a.a.b.b.a.bu(27, this.KHa);
      int j = g.a.a.b.b.a.bu(28, this.MmS);
      AppMethodBeat.o(89925);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(89925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chi localchi = (chi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(89925);
          return -1;
        case 1: 
          localchi.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 2: 
          localchi.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 3: 
          localchi.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 4: 
          localchi.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 5: 
          localchi.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 6: 
          localchi.MmJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 7: 
          localchi.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89925);
          return 0;
        case 8: 
          localchi.KHo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89925);
          return 0;
        case 9: 
          localchi.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89925);
          return 0;
        case 10: 
          localchi.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 11: 
          localchi.MbK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 12: 
          localchi.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 13: 
          localchi.MmM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 14: 
          localchi.MmN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 15: 
          localchi.MmO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89925);
          return 0;
        case 19: 
          localchi.MmP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89925);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchi.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 21: 
          localchi.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 22: 
          localchi.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 23: 
          localchi.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 24: 
          localchi.kei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchi.MmR = ((aeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 26: 
          localchi.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 27: 
          localchi.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89925);
          return 0;
        }
        localchi.MmS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(89925);
        return 0;
      }
      AppMethodBeat.o(89925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chi
 * JD-Core Version:    0.7.0.1
 */