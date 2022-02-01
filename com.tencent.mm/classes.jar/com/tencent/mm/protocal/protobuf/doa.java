package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doa
  extends com.tencent.mm.bx.a
{
  public LinkedList<aag> DBj;
  public String HCb;
  public String HCc;
  public String HCd;
  public String HCe;
  public long HCf;
  public dod HCg;
  public dei HCh;
  public boolean HCi;
  public LinkedList<dod> HCj;
  public int HCk;
  public int HCl;
  public String HCm;
  public int HCn;
  public boolean HCo;
  public String dld;
  public boolean fMP;
  public String keN;
  public int offset;
  public String qXu;
  public int scene;
  
  public doa()
  {
    AppMethodBeat.i(153006);
    this.DBj = new LinkedList();
    this.HCj = new LinkedList();
    AppMethodBeat.o(153006);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153007);
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
      paramVarArgs.aY(5, this.HCf);
      paramVarArgs.aS(6, this.scene);
      if (this.keN != null) {
        paramVarArgs.d(7, this.keN);
      }
      if (this.dld != null) {
        paramVarArgs.d(8, this.dld);
      }
      if (this.HCg != null)
      {
        paramVarArgs.lC(9, this.HCg.computeSize());
        this.HCg.writeFields(paramVarArgs);
      }
      if (this.HCh != null)
      {
        paramVarArgs.lC(10, this.HCh.computeSize());
        this.HCh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.DBj);
      if (this.qXu != null) {
        paramVarArgs.d(12, this.qXu);
      }
      paramVarArgs.aS(13, this.offset);
      paramVarArgs.bt(14, this.HCi);
      paramVarArgs.e(15, 8, this.HCj);
      paramVarArgs.aS(16, this.HCk);
      paramVarArgs.aS(17, this.HCl);
      paramVarArgs.bt(18, this.fMP);
      if (this.HCm != null) {
        paramVarArgs.d(19, this.HCm);
      }
      paramVarArgs.aS(20, this.HCn);
      paramVarArgs.bt(21, this.HCo);
      AppMethodBeat.o(153007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HCb == null) {
        break label1630;
      }
    }
    label1630:
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
      i = paramInt + f.a.a.b.b.a.p(5, this.HCf) + f.a.a.b.b.a.bz(6, this.scene);
      paramInt = i;
      if (this.keN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.keN);
      }
      i = paramInt;
      if (this.dld != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dld);
      }
      paramInt = i;
      if (this.HCg != null) {
        paramInt = i + f.a.a.a.lB(9, this.HCg.computeSize());
      }
      i = paramInt;
      if (this.HCh != null) {
        i = paramInt + f.a.a.a.lB(10, this.HCh.computeSize());
      }
      i += f.a.a.a.c(11, 8, this.DBj);
      paramInt = i;
      if (this.qXu != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.qXu);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.offset) + f.a.a.b.b.a.alV(14) + f.a.a.a.c(15, 8, this.HCj) + f.a.a.b.b.a.bz(16, this.HCk) + f.a.a.b.b.a.bz(17, this.HCl) + f.a.a.b.b.a.alV(18);
      paramInt = i;
      if (this.HCm != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.HCm);
      }
      i = f.a.a.b.b.a.bz(20, this.HCn);
      int j = f.a.a.b.b.a.alV(21);
      AppMethodBeat.o(153007);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DBj.clear();
        this.HCj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        doa localdoa = (doa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153007);
          return -1;
        case 1: 
          localdoa.HCb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 2: 
          localdoa.HCc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 3: 
          localdoa.HCd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 4: 
          localdoa.HCe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 5: 
          localdoa.HCf = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153007);
          return 0;
        case 6: 
          localdoa.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153007);
          return 0;
        case 7: 
          localdoa.keN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 8: 
          localdoa.dld = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoa.HCg = ((dod)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dei();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoa.HCh = ((dei)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aag();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoa.DBj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 12: 
          localdoa.qXu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 13: 
          localdoa.offset = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153007);
          return 0;
        case 14: 
          localdoa.HCi = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153007);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoa.HCj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 16: 
          localdoa.HCk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153007);
          return 0;
        case 17: 
          localdoa.HCl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153007);
          return 0;
        case 18: 
          localdoa.fMP = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153007);
          return 0;
        case 19: 
          localdoa.HCm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 20: 
          localdoa.HCn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153007);
          return 0;
        }
        localdoa.HCo = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(153007);
        return 0;
      }
      AppMethodBeat.o(153007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doa
 * JD-Core Version:    0.7.0.1
 */