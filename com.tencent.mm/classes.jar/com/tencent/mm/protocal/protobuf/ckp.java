package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckp
  extends com.tencent.mm.bw.a
{
  public String LRO;
  public String Lir;
  public String Lis;
  public ebj MmQ;
  public aeq MmR;
  public alg MpZ;
  public String Nickname;
  public String Username;
  public String kdX;
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155440);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.e(2, this.Nickname);
      }
      if (this.kdX != null) {
        paramVarArgs.e(3, this.kdX);
      }
      paramVarArgs.aM(4, this.kdY);
      if (this.kdZ != null) {
        paramVarArgs.e(5, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(6, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(7, this.keb);
      }
      paramVarArgs.aM(8, this.kec);
      if (this.ked != null) {
        paramVarArgs.e(9, this.ked);
      }
      if (this.MpZ != null)
      {
        paramVarArgs.ni(10, this.MpZ.computeSize());
        this.MpZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.kee);
      paramVarArgs.aM(12, this.kef);
      if (this.keg != null) {
        paramVarArgs.e(13, this.keg);
      }
      if (this.MmQ != null)
      {
        paramVarArgs.ni(14, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.keh != null) {
        paramVarArgs.e(15, this.keh);
      }
      if (this.kei != null) {
        paramVarArgs.e(16, this.kei);
      }
      if (this.MmR != null)
      {
        paramVarArgs.ni(17, this.MmR.computeSize());
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
      AppMethodBeat.o(155440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1610;
      }
    }
    label1610:
    for (int i = g.a.a.b.b.a.f(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nickname);
      }
      i = paramInt;
      if (this.kdX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.kdX);
      }
      i += g.a.a.b.b.a.bu(4, this.kdY);
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.kea);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.kec);
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.ked);
      }
      i = paramInt;
      if (this.MpZ != null) {
        i = paramInt + g.a.a.a.nh(10, this.MpZ.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(11, this.kee) + g.a.a.b.b.a.bu(12, this.kef);
      paramInt = i;
      if (this.keg != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.keg);
      }
      i = paramInt;
      if (this.MmQ != null) {
        i = paramInt + g.a.a.a.nh(14, this.MmQ.computeSize());
      }
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.keh);
      }
      i = paramInt;
      if (this.kei != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.kei);
      }
      paramInt = i;
      if (this.MmR != null) {
        paramInt = i + g.a.a.a.nh(17, this.MmR.computeSize());
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
      AppMethodBeat.o(155440);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ckp localckp = (ckp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(155440);
          return -1;
        case 1: 
          localckp.Username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 2: 
          localckp.Nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 3: 
          localckp.kdX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 4: 
          localckp.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155440);
          return 0;
        case 5: 
          localckp.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 6: 
          localckp.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 7: 
          localckp.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 8: 
          localckp.kec = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155440);
          return 0;
        case 9: 
          localckp.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localckp.MpZ = ((alg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 11: 
          localckp.kee = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155440);
          return 0;
        case 12: 
          localckp.kef = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155440);
          return 0;
        case 13: 
          localckp.keg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localckp.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 15: 
          localckp.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 16: 
          localckp.kei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localckp.MmR = ((aeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 20: 
          localckp.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 21: 
          localckp.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155440);
          return 0;
        }
        localckp.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155440);
        return 0;
      }
      AppMethodBeat.o(155440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckp
 * JD-Core Version:    0.7.0.1
 */