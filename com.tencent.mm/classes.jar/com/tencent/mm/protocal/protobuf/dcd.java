package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcd
  extends com.tencent.mm.bw.a
{
  public dcm MGO;
  public dcp MGP;
  public String MGQ;
  public LinkedList<dcg> MGR;
  public float MGS;
  public String MGT;
  public String MGU;
  public LinkedList<dcb> MGV;
  public String MmX;
  public String Name;
  public String UID;
  public String kdZ;
  public String kea;
  public String keh;
  public int xub;
  
  public dcd()
  {
    AppMethodBeat.i(209776);
    this.MGR = new LinkedList();
    this.MGV = new LinkedList();
    AppMethodBeat.o(209776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209777);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UID != null) {
        paramVarArgs.e(1, this.UID);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.MGO != null)
      {
        paramVarArgs.ni(3, this.MGO.computeSize());
        this.MGO.writeFields(paramVarArgs);
      }
      if (this.MGP != null)
      {
        paramVarArgs.ni(4, this.MGP.computeSize());
        this.MGP.writeFields(paramVarArgs);
      }
      if (this.MmX != null) {
        paramVarArgs.e(5, this.MmX);
      }
      if (this.MGQ != null) {
        paramVarArgs.e(6, this.MGQ);
      }
      paramVarArgs.e(7, 8, this.MGR);
      paramVarArgs.E(8, this.MGS);
      if (this.kdZ != null) {
        paramVarArgs.e(9, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(10, this.kea);
      }
      if (this.MGT != null) {
        paramVarArgs.e(11, this.MGT);
      }
      if (this.MGU != null) {
        paramVarArgs.e(12, this.MGU);
      }
      paramVarArgs.aM(13, this.xub);
      if (this.keh != null) {
        paramVarArgs.e(14, this.keh);
      }
      paramVarArgs.e(15, 8, this.MGV);
      AppMethodBeat.o(209777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UID == null) {
        break label1393;
      }
    }
    label1393:
    for (int i = g.a.a.b.b.a.f(1, this.UID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.MGO != null) {
        i = paramInt + g.a.a.a.nh(3, this.MGO.computeSize());
      }
      paramInt = i;
      if (this.MGP != null) {
        paramInt = i + g.a.a.a.nh(4, this.MGP.computeSize());
      }
      i = paramInt;
      if (this.MmX != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MmX);
      }
      paramInt = i;
      if (this.MGQ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MGQ);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.MGR) + (g.a.a.b.b.a.fS(8) + 4);
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.kea);
      }
      paramInt = i;
      if (this.MGT != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MGT);
      }
      i = paramInt;
      if (this.MGU != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MGU);
      }
      i += g.a.a.b.b.a.bu(13, this.xub);
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.keh);
      }
      i = g.a.a.a.c(15, 8, this.MGV);
      AppMethodBeat.o(209777);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MGR.clear();
        this.MGV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcd localdcd = (dcd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209777);
          return -1;
        case 1: 
          localdcd.UID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        case 2: 
          localdcd.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdcd.MGO = ((dcm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209777);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdcd.MGP = ((dcp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209777);
          return 0;
        case 5: 
          localdcd.MmX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        case 6: 
          localdcd.MGQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdcd.MGR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209777);
          return 0;
        case 8: 
          localdcd.MGS = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209777);
          return 0;
        case 9: 
          localdcd.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        case 10: 
          localdcd.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        case 11: 
          localdcd.MGT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        case 12: 
          localdcd.MGU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        case 13: 
          localdcd.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209777);
          return 0;
        case 14: 
          localdcd.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209777);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdcd.MGV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209777);
        return 0;
      }
      AppMethodBeat.o(209777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcd
 * JD-Core Version:    0.7.0.1
 */