package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eki
  extends dpc
{
  public String KBM;
  public String KHN;
  public dmq NjA;
  public String NjB;
  public dmp Nja;
  public String Nje;
  public String Njt;
  public String Njv;
  public int Njw;
  public int Njx;
  public dmp Njy;
  public aae Njz;
  public String dNQ;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72608);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.aM(4, this.Njw);
      if (this.Nja != null)
      {
        paramVarArgs.ni(5, this.Nja.computeSize());
        this.Nja.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.Njx);
      if (this.Njy != null)
      {
        paramVarArgs.ni(7, this.Njy.computeSize());
        this.Njy.writeFields(paramVarArgs);
      }
      if (this.Njz != null)
      {
        paramVarArgs.ni(8, this.Njz.computeSize());
        this.Njz.writeFields(paramVarArgs);
      }
      if (this.NjA != null)
      {
        paramVarArgs.ni(9, this.NjA.computeSize());
        this.NjA.writeFields(paramVarArgs);
      }
      if (this.dNQ != null) {
        paramVarArgs.e(10, this.dNQ);
      }
      if (this.KBM != null) {
        paramVarArgs.e(11, this.KBM);
      }
      if (this.KHN != null) {
        paramVarArgs.e(12, this.KHN);
      }
      if (this.Njt != null) {
        paramVarArgs.e(13, this.Njt);
      }
      if (this.NjB != null) {
        paramVarArgs.e(14, this.NjB);
      }
      if (this.Njv != null) {
        paramVarArgs.e(15, this.Njv);
      }
      if (this.Nje != null) {
        paramVarArgs.e(16, this.Nje);
      }
      AppMethodBeat.o(72608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1562;
      }
    }
    label1562:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Njw);
      paramInt = i;
      if (this.Nja != null) {
        paramInt = i + g.a.a.a.nh(5, this.Nja.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Njx);
      paramInt = i;
      if (this.Njy != null) {
        paramInt = i + g.a.a.a.nh(7, this.Njy.computeSize());
      }
      i = paramInt;
      if (this.Njz != null) {
        i = paramInt + g.a.a.a.nh(8, this.Njz.computeSize());
      }
      paramInt = i;
      if (this.NjA != null) {
        paramInt = i + g.a.a.a.nh(9, this.NjA.computeSize());
      }
      i = paramInt;
      if (this.dNQ != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.dNQ);
      }
      paramInt = i;
      if (this.KBM != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KBM);
      }
      i = paramInt;
      if (this.KHN != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KHN);
      }
      paramInt = i;
      if (this.Njt != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Njt);
      }
      i = paramInt;
      if (this.NjB != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.NjB);
      }
      paramInt = i;
      if (this.Njv != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Njv);
      }
      i = paramInt;
      if (this.Nje != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.Nje);
      }
      AppMethodBeat.o(72608);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eki localeki = (eki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72608);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeki.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 2: 
          localeki.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72608);
          return 0;
        case 3: 
          localeki.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 4: 
          localeki.Njw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72608);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeki.Nja = ((dmp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 6: 
          localeki.Njx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72608);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeki.Njy = ((dmp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aae();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aae)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeki.Njz = ((aae)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeki.NjA = ((dmq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 10: 
          localeki.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 11: 
          localeki.KBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 12: 
          localeki.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 13: 
          localeki.Njt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 14: 
          localeki.NjB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 15: 
          localeki.Njv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72608);
          return 0;
        }
        localeki.Nje = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72608);
        return 0;
      }
      AppMethodBeat.o(72608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eki
 * JD-Core Version:    0.7.0.1
 */