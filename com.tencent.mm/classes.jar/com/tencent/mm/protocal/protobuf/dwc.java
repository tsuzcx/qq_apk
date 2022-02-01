package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwc
  extends com.tencent.mm.bx.a
{
  public LinkedList<of> FJw;
  public int GlW;
  public String HIB;
  public String HIC;
  public int HID;
  public long HIE;
  public LinkedList<bsq> HIF;
  public boolean HIG;
  public int aHQ;
  public int dtK;
  public String dtL;
  public String id;
  public long timestamp;
  public int type;
  public String typeName;
  
  public dwc()
  {
    AppMethodBeat.i(210619);
    this.id = "";
    this.HIB = "";
    this.typeName = "";
    this.dtL = "";
    this.HIC = "";
    this.dtK = 0;
    this.timestamp = 0L;
    this.HIE = 0L;
    this.GlW = 0;
    this.FJw = new LinkedList();
    this.HIF = new LinkedList();
    this.HIG = true;
    this.type = -1;
    AppMethodBeat.o(210619);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210620);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.HIB != null) {
        paramVarArgs.d(2, this.HIB);
      }
      if (this.typeName != null) {
        paramVarArgs.d(3, this.typeName);
      }
      if (this.dtL != null) {
        paramVarArgs.d(4, this.dtL);
      }
      if (this.HIC != null) {
        paramVarArgs.d(5, this.HIC);
      }
      paramVarArgs.aS(6, this.dtK);
      paramVarArgs.aS(7, this.aHQ);
      paramVarArgs.aS(8, this.HID);
      paramVarArgs.aY(9, this.timestamp);
      paramVarArgs.aY(10, this.HIE);
      paramVarArgs.aS(11, this.GlW);
      paramVarArgs.e(12, 8, this.FJw);
      paramVarArgs.e(13, 8, this.HIF);
      paramVarArgs.bt(14, this.HIG);
      paramVarArgs.aS(15, this.type);
      AppMethodBeat.o(210620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1122;
      }
    }
    label1122:
    for (int i = f.a.a.b.b.a.e(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HIB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HIB);
      }
      i = paramInt;
      if (this.typeName != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.typeName);
      }
      paramInt = i;
      if (this.dtL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dtL);
      }
      i = paramInt;
      if (this.HIC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HIC);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.dtK);
      int j = f.a.a.b.b.a.bz(7, this.aHQ);
      int k = f.a.a.b.b.a.bz(8, this.HID);
      int m = f.a.a.b.b.a.p(9, this.timestamp);
      int n = f.a.a.b.b.a.p(10, this.HIE);
      int i1 = f.a.a.b.b.a.bz(11, this.GlW);
      int i2 = f.a.a.a.c(12, 8, this.FJw);
      int i3 = f.a.a.a.c(13, 8, this.HIF);
      int i4 = f.a.a.b.b.a.alV(14);
      int i5 = f.a.a.b.b.a.bz(15, this.type);
      AppMethodBeat.o(210620);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJw.clear();
        this.HIF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(210620);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwc localdwc = (dwc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210620);
          return -1;
        case 1: 
          localdwc.id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210620);
          return 0;
        case 2: 
          localdwc.HIB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210620);
          return 0;
        case 3: 
          localdwc.typeName = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210620);
          return 0;
        case 4: 
          localdwc.dtL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210620);
          return 0;
        case 5: 
          localdwc.HIC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210620);
          return 0;
        case 6: 
          localdwc.dtK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210620);
          return 0;
        case 7: 
          localdwc.aHQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210620);
          return 0;
        case 8: 
          localdwc.HID = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210620);
          return 0;
        case 9: 
          localdwc.timestamp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(210620);
          return 0;
        case 10: 
          localdwc.HIE = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(210620);
          return 0;
        case 11: 
          localdwc.GlW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210620);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new of();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((of)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwc.FJw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210620);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwc.HIF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210620);
          return 0;
        case 14: 
          localdwc.HIG = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(210620);
          return 0;
        }
        localdwc.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(210620);
        return 0;
      }
      AppMethodBeat.o(210620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwc
 * JD-Core Version:    0.7.0.1
 */