package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class pc
  extends com.tencent.mm.bx.a
{
  public String YRQ;
  public String YSA;
  public int YSa;
  public int YSl;
  public int YSm;
  public int YSn;
  public long YSo;
  public long YSp;
  public boolean YSq;
  public int YSr;
  public boolean YSs;
  public jt YSt;
  public boolean YSu;
  public zb YSv;
  public LinkedList<gdt> YSw;
  public boolean YSx;
  public LinkedList<String> YSy;
  public String YSz;
  public int user_flag;
  
  public pc()
  {
    AppMethodBeat.i(258387);
    this.YSw = new LinkedList();
    this.YSy = new LinkedList();
    AppMethodBeat.o(258387);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124426);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124426);
        throw paramVarArgs;
      }
      if (this.YRQ != null) {
        paramVarArgs.g(1, this.YRQ);
      }
      paramVarArgs.bS(2, this.YSl);
      paramVarArgs.bS(3, this.YSm);
      paramVarArgs.bS(4, this.user_flag);
      paramVarArgs.bS(5, this.YSn);
      paramVarArgs.bv(6, this.YSo);
      paramVarArgs.bv(7, this.YSp);
      paramVarArgs.bS(8, this.YSa);
      paramVarArgs.di(9, this.YSq);
      paramVarArgs.bS(10, this.YSr);
      paramVarArgs.di(11, this.YSs);
      if (this.YSt != null)
      {
        paramVarArgs.qD(12, this.YSt.computeSize());
        this.YSt.writeFields(paramVarArgs);
      }
      paramVarArgs.di(13, this.YSu);
      if (this.YSv != null)
      {
        paramVarArgs.qD(14, this.YSv.computeSize());
        this.YSv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.YSw);
      paramVarArgs.di(16, this.YSx);
      paramVarArgs.e(17, 1, this.YSy);
      if (this.YSz != null) {
        paramVarArgs.g(18, this.YSz);
      }
      if (this.YSA != null) {
        paramVarArgs.g(19, this.YSA);
      }
      AppMethodBeat.o(124426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRQ == null) {
        break label1348;
      }
    }
    label1348:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRQ) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YSl) + i.a.a.b.b.a.cJ(3, this.YSm) + i.a.a.b.b.a.cJ(4, this.user_flag) + i.a.a.b.b.a.cJ(5, this.YSn) + i.a.a.b.b.a.q(6, this.YSo) + i.a.a.b.b.a.q(7, this.YSp) + i.a.a.b.b.a.cJ(8, this.YSa) + (i.a.a.b.b.a.ko(9) + 1) + i.a.a.b.b.a.cJ(10, this.YSr) + (i.a.a.b.b.a.ko(11) + 1);
      paramInt = i;
      if (this.YSt != null) {
        paramInt = i + i.a.a.a.qC(12, this.YSt.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(13) + 1);
      paramInt = i;
      if (this.YSv != null) {
        paramInt = i + i.a.a.a.qC(14, this.YSv.computeSize());
      }
      i = paramInt + i.a.a.a.c(15, 8, this.YSw) + (i.a.a.b.b.a.ko(16) + 1) + i.a.a.a.c(17, 1, this.YSy);
      paramInt = i;
      if (this.YSz != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.YSz);
      }
      i = paramInt;
      if (this.YSA != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.YSA);
      }
      AppMethodBeat.o(124426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YSw.clear();
        this.YSy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YRQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        pc localpc = (pc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124426);
          return -1;
        case 1: 
          localpc.YRQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124426);
          return 0;
        case 2: 
          localpc.YSl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124426);
          return 0;
        case 3: 
          localpc.YSm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124426);
          return 0;
        case 4: 
          localpc.user_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124426);
          return 0;
        case 5: 
          localpc.YSn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124426);
          return 0;
        case 6: 
          localpc.YSo = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124426);
          return 0;
        case 7: 
          localpc.YSp = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124426);
          return 0;
        case 8: 
          localpc.YSa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124426);
          return 0;
        case 9: 
          localpc.YSq = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(124426);
          return 0;
        case 10: 
          localpc.YSr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124426);
          return 0;
        case 11: 
          localpc.YSs = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(124426);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jt)localObject2).parseFrom((byte[])localObject1);
            }
            localpc.YSt = ((jt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 13: 
          localpc.YSu = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(124426);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new zb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((zb)localObject2).parseFrom((byte[])localObject1);
            }
            localpc.YSv = ((zb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gdt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gdt)localObject2).parseFrom((byte[])localObject1);
            }
            localpc.YSw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 16: 
          localpc.YSx = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(124426);
          return 0;
        case 17: 
          localpc.YSy.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(124426);
          return 0;
        case 18: 
          localpc.YSz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124426);
          return 0;
        }
        localpc.YSA = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(124426);
        return 0;
      }
      AppMethodBeat.o(124426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pc
 * JD-Core Version:    0.7.0.1
 */