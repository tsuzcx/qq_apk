package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwx
  extends com.tencent.mm.bw.a
{
  public int GEY;
  public LinkedList<oh> GbV;
  public String Icn;
  public String Ico;
  public int Icp;
  public long Icq;
  public LinkedList<btk> Icr;
  public boolean Ics;
  public int aHQ;
  public int duP;
  public String duQ;
  public String id;
  public long timestamp;
  public int type;
  public String typeName;
  
  public dwx()
  {
    AppMethodBeat.i(196286);
    this.id = "";
    this.Icn = "";
    this.typeName = "";
    this.duQ = "";
    this.Ico = "";
    this.duP = 0;
    this.timestamp = 0L;
    this.Icq = 0L;
    this.GEY = 0;
    this.GbV = new LinkedList();
    this.Icr = new LinkedList();
    this.Ics = true;
    this.type = -1;
    AppMethodBeat.o(196286);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196287);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.Icn != null) {
        paramVarArgs.d(2, this.Icn);
      }
      if (this.typeName != null) {
        paramVarArgs.d(3, this.typeName);
      }
      if (this.duQ != null) {
        paramVarArgs.d(4, this.duQ);
      }
      if (this.Ico != null) {
        paramVarArgs.d(5, this.Ico);
      }
      paramVarArgs.aS(6, this.duP);
      paramVarArgs.aS(7, this.aHQ);
      paramVarArgs.aS(8, this.Icp);
      paramVarArgs.aZ(9, this.timestamp);
      paramVarArgs.aZ(10, this.Icq);
      paramVarArgs.aS(11, this.GEY);
      paramVarArgs.e(12, 8, this.GbV);
      paramVarArgs.e(13, 8, this.Icr);
      paramVarArgs.bC(14, this.Ics);
      paramVarArgs.aS(15, this.type);
      AppMethodBeat.o(196287);
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
      if (this.Icn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Icn);
      }
      i = paramInt;
      if (this.typeName != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.typeName);
      }
      paramInt = i;
      if (this.duQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.duQ);
      }
      i = paramInt;
      if (this.Ico != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ico);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.duP);
      int j = f.a.a.b.b.a.bz(7, this.aHQ);
      int k = f.a.a.b.b.a.bz(8, this.Icp);
      int m = f.a.a.b.b.a.p(9, this.timestamp);
      int n = f.a.a.b.b.a.p(10, this.Icq);
      int i1 = f.a.a.b.b.a.bz(11, this.GEY);
      int i2 = f.a.a.a.c(12, 8, this.GbV);
      int i3 = f.a.a.a.c(13, 8, this.Icr);
      int i4 = f.a.a.b.b.a.amF(14);
      int i5 = f.a.a.b.b.a.bz(15, this.type);
      AppMethodBeat.o(196287);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GbV.clear();
        this.Icr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(196287);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwx localdwx = (dwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196287);
          return -1;
        case 1: 
          localdwx.id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196287);
          return 0;
        case 2: 
          localdwx.Icn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196287);
          return 0;
        case 3: 
          localdwx.typeName = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196287);
          return 0;
        case 4: 
          localdwx.duQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196287);
          return 0;
        case 5: 
          localdwx.Ico = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196287);
          return 0;
        case 6: 
          localdwx.duP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196287);
          return 0;
        case 7: 
          localdwx.aHQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196287);
          return 0;
        case 8: 
          localdwx.Icp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196287);
          return 0;
        case 9: 
          localdwx.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(196287);
          return 0;
        case 10: 
          localdwx.Icq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(196287);
          return 0;
        case 11: 
          localdwx.GEY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196287);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwx.GbV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196287);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwx.Icr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196287);
          return 0;
        case 14: 
          localdwx.Ics = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(196287);
          return 0;
        }
        localdwx.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(196287);
        return 0;
      }
      AppMethodBeat.o(196287);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwx
 * JD-Core Version:    0.7.0.1
 */