package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bgh
  extends com.tencent.mm.bx.a
{
  public int ZEt;
  public bfl ZJX;
  public LinkedList<bfl> ZKa;
  public b ZLo;
  public String ZOx;
  public int ZPQ;
  public int ZPR;
  public int ZPS;
  public String ZPT;
  public boolean ZPU;
  public int ZPV;
  public long ZPW;
  public FinderContact contact;
  public int mXJ;
  
  public bgh()
  {
    AppMethodBeat.i(258063);
    this.ZKa = new LinkedList();
    AppMethodBeat.o(258063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258068);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.qD(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.mXJ);
      paramVarArgs.bS(3, this.ZPQ);
      paramVarArgs.bS(4, this.ZPR);
      paramVarArgs.bS(5, this.ZPS);
      if (this.ZJX != null)
      {
        paramVarArgs.qD(6, this.ZJX.computeSize());
        this.ZJX.writeFields(paramVarArgs);
      }
      if (this.ZPT != null) {
        paramVarArgs.g(9, this.ZPT);
      }
      paramVarArgs.bS(10, this.ZEt);
      if (this.ZOx != null) {
        paramVarArgs.g(11, this.ZOx);
      }
      if (this.ZLo != null) {
        paramVarArgs.d(12, this.ZLo);
      }
      paramVarArgs.di(13, this.ZPU);
      paramVarArgs.e(14, 8, this.ZKa);
      paramVarArgs.bS(15, this.ZPV);
      paramVarArgs.bv(16, this.ZPW);
      AppMethodBeat.o(258068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label1092;
      }
    }
    label1092:
    for (paramInt = i.a.a.a.qC(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.mXJ) + i.a.a.b.b.a.cJ(3, this.ZPQ) + i.a.a.b.b.a.cJ(4, this.ZPR) + i.a.a.b.b.a.cJ(5, this.ZPS);
      paramInt = i;
      if (this.ZJX != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZJX.computeSize());
      }
      i = paramInt;
      if (this.ZPT != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZPT);
      }
      i += i.a.a.b.b.a.cJ(10, this.ZEt);
      paramInt = i;
      if (this.ZOx != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZOx);
      }
      i = paramInt;
      if (this.ZLo != null) {
        i = paramInt + i.a.a.b.b.a.c(12, this.ZLo);
      }
      paramInt = i.a.a.b.b.a.ko(13);
      int j = i.a.a.a.c(14, 8, this.ZKa);
      int k = i.a.a.b.b.a.cJ(15, this.ZPV);
      int m = i.a.a.b.b.a.q(16, this.ZPW);
      AppMethodBeat.o(258068);
      return i + (paramInt + 1) + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZKa.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bgh localbgh = (bgh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(258068);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbgh.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258068);
          return 0;
        case 2: 
          localbgh.mXJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258068);
          return 0;
        case 3: 
          localbgh.ZPQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258068);
          return 0;
        case 4: 
          localbgh.ZPR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258068);
          return 0;
        case 5: 
          localbgh.ZPS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258068);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfl)localObject2).parseFrom((byte[])localObject1);
            }
            localbgh.ZJX = ((bfl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258068);
          return 0;
        case 9: 
          localbgh.ZPT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258068);
          return 0;
        case 10: 
          localbgh.ZEt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258068);
          return 0;
        case 11: 
          localbgh.ZOx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258068);
          return 0;
        case 12: 
          localbgh.ZLo = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258068);
          return 0;
        case 13: 
          localbgh.ZPU = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(258068);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfl)localObject2).parseFrom((byte[])localObject1);
            }
            localbgh.ZKa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258068);
          return 0;
        case 15: 
          localbgh.ZPV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258068);
          return 0;
        }
        localbgh.ZPW = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258068);
        return 0;
      }
      AppMethodBeat.o(258068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgh
 * JD-Core Version:    0.7.0.1
 */