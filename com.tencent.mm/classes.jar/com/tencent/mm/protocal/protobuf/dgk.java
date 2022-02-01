package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgk
  extends com.tencent.mm.bw.a
{
  public String LRO;
  public String Lir;
  public String Lis;
  public int MKZ;
  public String MLa;
  public int MLb;
  public String MLc;
  public ebj MmQ;
  public aeq MmR;
  public String UserName;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public int kec;
  public String ked;
  public int kee;
  public int kef;
  public String keg;
  public String keh;
  public String kei;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155448);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MKZ);
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(3, this.oUJ);
      }
      if (this.MLa != null) {
        paramVarArgs.e(4, this.MLa);
      }
      paramVarArgs.aM(5, this.MLb);
      if (this.MLc != null) {
        paramVarArgs.e(6, this.MLc);
      }
      paramVarArgs.aM(7, this.kdY);
      if (this.kdZ != null) {
        paramVarArgs.e(8, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(9, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(10, this.keb);
      }
      paramVarArgs.aM(11, this.kec);
      if (this.ked != null) {
        paramVarArgs.e(12, this.ked);
      }
      paramVarArgs.aM(13, this.kee);
      paramVarArgs.aM(14, this.kef);
      if (this.keg != null) {
        paramVarArgs.e(15, this.keg);
      }
      if (this.MmQ != null)
      {
        paramVarArgs.ni(16, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.keh != null) {
        paramVarArgs.e(17, this.keh);
      }
      if (this.kei != null) {
        paramVarArgs.e(18, this.kei);
      }
      if (this.MmR != null)
      {
        paramVarArgs.ni(19, this.MmR.computeSize());
        this.MmR.writeFields(paramVarArgs);
      }
      if (this.Lir != null) {
        paramVarArgs.e(20, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(21, this.Lis);
      }
      if (this.LRO != null) {
        paramVarArgs.e(22, this.LRO);
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MKZ) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUJ);
      }
      paramInt = i;
      if (this.MLa != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MLa);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MLb);
      paramInt = i;
      if (this.MLc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MLc);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.kdY);
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.kea);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.kec);
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.ked);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.kee) + g.a.a.b.b.a.bu(14, this.kef);
      paramInt = i;
      if (this.keg != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.keg);
      }
      i = paramInt;
      if (this.MmQ != null) {
        i = paramInt + g.a.a.a.nh(16, this.MmQ.computeSize());
      }
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.keh);
      }
      i = paramInt;
      if (this.kei != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.kei);
      }
      paramInt = i;
      if (this.MmR != null) {
        paramInt = i + g.a.a.a.nh(19, this.MmR.computeSize());
      }
      i = paramInt;
      if (this.Lir != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.Lir);
      }
      paramInt = i;
      if (this.Lis != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.Lis);
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.LRO);
      }
      AppMethodBeat.o(155448);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dgk localdgk = (dgk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155448);
        return -1;
      case 1: 
        localdgk.MKZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155448);
        return 0;
      case 2: 
        localdgk.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 3: 
        localdgk.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 4: 
        localdgk.MLa = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 5: 
        localdgk.MLb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155448);
        return 0;
      case 6: 
        localdgk.MLc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 7: 
        localdgk.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155448);
        return 0;
      case 8: 
        localdgk.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 9: 
        localdgk.kea = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 10: 
        localdgk.keb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 11: 
        localdgk.kec = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155448);
        return 0;
      case 12: 
        localdgk.ked = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 13: 
        localdgk.kee = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155448);
        return 0;
      case 14: 
        localdgk.kef = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155448);
        return 0;
      case 15: 
        localdgk.keg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdgk.MmQ = ((ebj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 17: 
        localdgk.keh = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 18: 
        localdgk.kei = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aeq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdgk.MmR = ((aeq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 20: 
        localdgk.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 21: 
        localdgk.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155448);
        return 0;
      }
      localdgk.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(155448);
      return 0;
    }
    AppMethodBeat.o(155448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgk
 * JD-Core Version:    0.7.0.1
 */