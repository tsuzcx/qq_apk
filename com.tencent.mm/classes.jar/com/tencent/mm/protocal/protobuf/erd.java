package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erd
  extends com.tencent.mm.bw.a
{
  public LinkedList<pd> KVY;
  public int LCp;
  public String NoL;
  public String NoM;
  public int NoN;
  public long NoO;
  public LinkedList<cgd> NoP;
  public boolean NoQ;
  public int aHK;
  public String dMl;
  public int eventId;
  public String id;
  public long timestamp;
  public int type;
  public String typeName;
  
  public erd()
  {
    AppMethodBeat.i(220727);
    this.id = "";
    this.NoL = "";
    this.typeName = "";
    this.dMl = "";
    this.NoM = "";
    this.eventId = 0;
    this.timestamp = 0L;
    this.NoO = 0L;
    this.LCp = 0;
    this.KVY = new LinkedList();
    this.NoP = new LinkedList();
    this.NoQ = true;
    this.type = -1;
    AppMethodBeat.o(220727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220728);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.NoL != null) {
        paramVarArgs.e(2, this.NoL);
      }
      if (this.typeName != null) {
        paramVarArgs.e(3, this.typeName);
      }
      if (this.dMl != null) {
        paramVarArgs.e(4, this.dMl);
      }
      if (this.NoM != null) {
        paramVarArgs.e(5, this.NoM);
      }
      paramVarArgs.aM(6, this.eventId);
      paramVarArgs.aM(7, this.aHK);
      paramVarArgs.aM(8, this.NoN);
      paramVarArgs.bb(9, this.timestamp);
      paramVarArgs.bb(10, this.NoO);
      paramVarArgs.aM(11, this.LCp);
      paramVarArgs.e(12, 8, this.KVY);
      paramVarArgs.e(13, 8, this.NoP);
      paramVarArgs.cc(14, this.NoQ);
      paramVarArgs.aM(15, this.type);
      AppMethodBeat.o(220728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1126;
      }
    }
    label1126:
    for (int i = g.a.a.b.b.a.f(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NoL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NoL);
      }
      i = paramInt;
      if (this.typeName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.typeName);
      }
      paramInt = i;
      if (this.dMl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dMl);
      }
      i = paramInt;
      if (this.NoM != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NoM);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.eventId);
      int j = g.a.a.b.b.a.bu(7, this.aHK);
      int k = g.a.a.b.b.a.bu(8, this.NoN);
      int m = g.a.a.b.b.a.r(9, this.timestamp);
      int n = g.a.a.b.b.a.r(10, this.NoO);
      int i1 = g.a.a.b.b.a.bu(11, this.LCp);
      int i2 = g.a.a.a.c(12, 8, this.KVY);
      int i3 = g.a.a.a.c(13, 8, this.NoP);
      int i4 = g.a.a.b.b.a.fS(14);
      int i5 = g.a.a.b.b.a.bu(15, this.type);
      AppMethodBeat.o(220728);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KVY.clear();
        this.NoP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(220728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        erd localerd = (erd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220728);
          return -1;
        case 1: 
          localerd.id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220728);
          return 0;
        case 2: 
          localerd.NoL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220728);
          return 0;
        case 3: 
          localerd.typeName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220728);
          return 0;
        case 4: 
          localerd.dMl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220728);
          return 0;
        case 5: 
          localerd.NoM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220728);
          return 0;
        case 6: 
          localerd.eventId = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220728);
          return 0;
        case 7: 
          localerd.aHK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220728);
          return 0;
        case 8: 
          localerd.NoN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220728);
          return 0;
        case 9: 
          localerd.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(220728);
          return 0;
        case 10: 
          localerd.NoO = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(220728);
          return 0;
        case 11: 
          localerd.LCp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220728);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localerd.KVY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220728);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localerd.NoP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220728);
          return 0;
        case 14: 
          localerd.NoQ = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(220728);
          return 0;
        }
        localerd.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(220728);
        return 0;
      }
      AppMethodBeat.o(220728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erd
 * JD-Core Version:    0.7.0.1
 */