package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doc
  extends com.tencent.mm.bx.a
{
  public LinkedList<aag> DBj;
  public String HCb;
  public String HCc;
  public String HCd;
  public String HCe;
  public long HCf;
  public dei HCh;
  public boolean HCo;
  public LinkedList<dod> HCs;
  public String dld;
  public int offset;
  public String qXu;
  public int scene;
  
  public doc()
  {
    AppMethodBeat.i(153010);
    this.HCs = new LinkedList();
    this.DBj = new LinkedList();
    AppMethodBeat.o(153010);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153011);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HCb != null) {
        paramVarArgs.d(1, this.HCb);
      }
      if (this.HCc != null) {
        paramVarArgs.d(2, this.HCc);
      }
      if (this.HCd != null) {
        paramVarArgs.d(3, this.HCd);
      }
      if (this.HCe != null) {
        paramVarArgs.d(4, this.HCe);
      }
      if (this.HCh != null)
      {
        paramVarArgs.lC(5, this.HCh.computeSize());
        this.HCh.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.HCf);
      if (this.qXu != null) {
        paramVarArgs.d(7, this.qXu);
      }
      paramVarArgs.aS(8, this.offset);
      paramVarArgs.bt(9, this.HCo);
      paramVarArgs.aS(10, this.scene);
      if (this.dld != null) {
        paramVarArgs.d(11, this.dld);
      }
      paramVarArgs.e(12, 8, this.HCs);
      paramVarArgs.e(13, 8, this.DBj);
      AppMethodBeat.o(153011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HCb == null) {
        break label1138;
      }
    }
    label1138:
    for (int i = f.a.a.b.b.a.e(1, this.HCb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HCc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HCc);
      }
      i = paramInt;
      if (this.HCd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HCd);
      }
      paramInt = i;
      if (this.HCe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HCe);
      }
      i = paramInt;
      if (this.HCh != null) {
        i = paramInt + f.a.a.a.lB(5, this.HCh.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.HCf);
      paramInt = i;
      if (this.qXu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.qXu);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.offset) + f.a.a.b.b.a.alV(9) + f.a.a.b.b.a.bz(10, this.scene);
      paramInt = i;
      if (this.dld != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dld);
      }
      i = f.a.a.a.c(12, 8, this.HCs);
      int j = f.a.a.a.c(13, 8, this.DBj);
      AppMethodBeat.o(153011);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HCs.clear();
        this.DBj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        doc localdoc = (doc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153011);
          return -1;
        case 1: 
          localdoc.HCb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 2: 
          localdoc.HCc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 3: 
          localdoc.HCd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 4: 
          localdoc.HCe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dei();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoc.HCh = ((dei)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        case 6: 
          localdoc.HCf = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153011);
          return 0;
        case 7: 
          localdoc.qXu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 8: 
          localdoc.offset = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153011);
          return 0;
        case 9: 
          localdoc.HCo = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153011);
          return 0;
        case 10: 
          localdoc.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153011);
          return 0;
        case 11: 
          localdoc.dld = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoc.HCs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aag();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdoc.DBj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      AppMethodBeat.o(153011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doc
 * JD-Core Version:    0.7.0.1
 */