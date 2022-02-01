package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chd
  extends dop
{
  public acc KOF;
  public String LkK;
  public int Mbn;
  public boolean Mem;
  public boolean Men;
  public fcc Mmn;
  public fea Mmo;
  public fdb Mmp;
  public fez Mmq;
  public fds Mmr;
  public feb Mms;
  public int Mmt;
  public String Mmu;
  public String Mmv;
  public fec Mmw;
  public ctd Mmx;
  public fdx Mmy;
  public String jfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123624);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.Mmn != null)
      {
        paramVarArgs.ni(3, this.Mmn.computeSize());
        this.Mmn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.Mbn);
      if (this.Mmo != null)
      {
        paramVarArgs.ni(5, this.Mmo.computeSize());
        this.Mmo.writeFields(paramVarArgs);
      }
      if (this.Mmp != null)
      {
        paramVarArgs.ni(6, this.Mmp.computeSize());
        this.Mmp.writeFields(paramVarArgs);
      }
      if (this.Mmq != null)
      {
        paramVarArgs.ni(7, this.Mmq.computeSize());
        this.Mmq.writeFields(paramVarArgs);
      }
      if (this.Mmr != null)
      {
        paramVarArgs.ni(8, this.Mmr.computeSize());
        this.Mmr.writeFields(paramVarArgs);
      }
      if (this.Mms != null)
      {
        paramVarArgs.ni(9, this.Mms.computeSize());
        this.Mms.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.Mmt);
      if (this.Mmu != null) {
        paramVarArgs.e(11, this.Mmu);
      }
      if (this.Mmv != null) {
        paramVarArgs.e(12, this.Mmv);
      }
      paramVarArgs.cc(13, this.Mem);
      paramVarArgs.cc(14, this.Men);
      if (this.Mmw != null)
      {
        paramVarArgs.ni(15, this.Mmw.computeSize());
        this.Mmw.writeFields(paramVarArgs);
      }
      if (this.Mmx != null)
      {
        paramVarArgs.ni(16, this.Mmx.computeSize());
        this.Mmx.writeFields(paramVarArgs);
      }
      if (this.LkK != null) {
        paramVarArgs.e(17, this.LkK);
      }
      if (this.KOF != null)
      {
        paramVarArgs.ni(18, this.KOF.computeSize());
        this.KOF.writeFields(paramVarArgs);
      }
      if (this.Mmy != null)
      {
        paramVarArgs.ni(19, this.Mmy.computeSize());
        this.Mmy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2290;
      }
    }
    label2290:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.Mmn != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mmn.computeSize());
      }
      i += g.a.a.b.b.a.bu(4, this.Mbn);
      paramInt = i;
      if (this.Mmo != null) {
        paramInt = i + g.a.a.a.nh(5, this.Mmo.computeSize());
      }
      i = paramInt;
      if (this.Mmp != null) {
        i = paramInt + g.a.a.a.nh(6, this.Mmp.computeSize());
      }
      paramInt = i;
      if (this.Mmq != null) {
        paramInt = i + g.a.a.a.nh(7, this.Mmq.computeSize());
      }
      i = paramInt;
      if (this.Mmr != null) {
        i = paramInt + g.a.a.a.nh(8, this.Mmr.computeSize());
      }
      paramInt = i;
      if (this.Mms != null) {
        paramInt = i + g.a.a.a.nh(9, this.Mms.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.Mmt);
      paramInt = i;
      if (this.Mmu != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Mmu);
      }
      i = paramInt;
      if (this.Mmv != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Mmv);
      }
      i = i + (g.a.a.b.b.a.fS(13) + 1) + (g.a.a.b.b.a.fS(14) + 1);
      paramInt = i;
      if (this.Mmw != null) {
        paramInt = i + g.a.a.a.nh(15, this.Mmw.computeSize());
      }
      i = paramInt;
      if (this.Mmx != null) {
        i = paramInt + g.a.a.a.nh(16, this.Mmx.computeSize());
      }
      paramInt = i;
      if (this.LkK != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.LkK);
      }
      i = paramInt;
      if (this.KOF != null) {
        i = paramInt + g.a.a.a.nh(18, this.KOF.computeSize());
      }
      paramInt = i;
      if (this.Mmy != null) {
        paramInt = i + g.a.a.a.nh(19, this.Mmy.computeSize());
      }
      AppMethodBeat.o(123624);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chd localchd = (chd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123624);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 2: 
          localchd.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fcc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fcc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.Mmn = ((fcc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 4: 
          localchd.Mbn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123624);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fea();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fea)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.Mmo = ((fea)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.Mmp = ((fdb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fez();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fez)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.Mmq = ((fez)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fds();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fds)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.Mmr = ((fds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new feb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((feb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.Mms = ((feb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 10: 
          localchd.Mmt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123624);
          return 0;
        case 11: 
          localchd.Mmu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 12: 
          localchd.Mmv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 13: 
          localchd.Mem = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123624);
          return 0;
        case 14: 
          localchd.Men = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123624);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fec();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fec)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.Mmw = ((fec)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.Mmx = ((ctd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 17: 
          localchd.LkK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchd.KOF = ((acc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fdx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fdx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localchd.Mmy = ((fdx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      AppMethodBeat.o(123624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chd
 * JD-Core Version:    0.7.0.1
 */