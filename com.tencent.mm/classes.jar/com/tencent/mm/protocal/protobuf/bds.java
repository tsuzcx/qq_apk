package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bds
  extends com.tencent.mm.bw.a
{
  public azk LJj;
  public int LNt;
  public int LNu;
  public int LNv;
  public bdr LNw;
  public int LNx;
  public int LNy;
  public aqk LNz;
  public int LzC;
  public String coverUrl;
  public String dST;
  public int followFlag;
  public int friendFollowCount;
  public bdl tmpl_info;
  public int tvC;
  public long twp;
  public String twq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209704);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dST != null) {
        paramVarArgs.e(1, this.dST);
      }
      paramVarArgs.bb(2, this.twp);
      paramVarArgs.aM(3, this.LzC);
      if (this.twq != null) {
        paramVarArgs.e(4, this.twq);
      }
      paramVarArgs.aM(5, this.tvC);
      paramVarArgs.aM(6, this.followFlag);
      if (this.coverUrl != null) {
        paramVarArgs.e(7, this.coverUrl);
      }
      paramVarArgs.aM(8, this.friendFollowCount);
      paramVarArgs.aM(9, this.LNt);
      paramVarArgs.aM(10, this.LNu);
      if (this.LJj != null)
      {
        paramVarArgs.ni(11, this.LJj.computeSize());
        this.LJj.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.LNv);
      if (this.LNw != null)
      {
        paramVarArgs.ni(13, this.LNw.computeSize());
        this.LNw.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.LNx);
      if (this.tmpl_info != null)
      {
        paramVarArgs.ni(15, this.tmpl_info.computeSize());
        this.tmpl_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(16, this.LNy);
      if (this.LNz != null)
      {
        paramVarArgs.ni(17, this.LNz.computeSize());
        this.LNz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dST == null) {
        break label1410;
      }
    }
    label1410:
    for (paramInt = g.a.a.b.b.a.f(1, this.dST) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.twp) + g.a.a.b.b.a.bu(3, this.LzC);
      paramInt = i;
      if (this.twq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.twq);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.tvC) + g.a.a.b.b.a.bu(6, this.followFlag);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.coverUrl);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.friendFollowCount) + g.a.a.b.b.a.bu(9, this.LNt) + g.a.a.b.b.a.bu(10, this.LNu);
      paramInt = i;
      if (this.LJj != null) {
        paramInt = i + g.a.a.a.nh(11, this.LJj.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.LNv);
      paramInt = i;
      if (this.LNw != null) {
        paramInt = i + g.a.a.a.nh(13, this.LNw.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.LNx);
      paramInt = i;
      if (this.tmpl_info != null) {
        paramInt = i + g.a.a.a.nh(15, this.tmpl_info.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.LNy);
      paramInt = i;
      if (this.LNz != null) {
        paramInt = i + g.a.a.a.nh(17, this.LNz.computeSize());
      }
      AppMethodBeat.o(209704);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209704);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bds localbds = (bds)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209704);
          return -1;
        case 1: 
          localbds.dST = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209704);
          return 0;
        case 2: 
          localbds.twp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209704);
          return 0;
        case 3: 
          localbds.LzC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        case 4: 
          localbds.twq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209704);
          return 0;
        case 5: 
          localbds.tvC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        case 6: 
          localbds.followFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        case 7: 
          localbds.coverUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209704);
          return 0;
        case 8: 
          localbds.friendFollowCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        case 9: 
          localbds.LNt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        case 10: 
          localbds.LNu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbds.LJj = ((azk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209704);
          return 0;
        case 12: 
          localbds.LNv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbds.LNw = ((bdr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209704);
          return 0;
        case 14: 
          localbds.LNx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbds.tmpl_info = ((bdl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209704);
          return 0;
        case 16: 
          localbds.LNy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209704);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbds.LNz = ((aqk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209704);
        return 0;
      }
      AppMethodBeat.o(209704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bds
 * JD-Core Version:    0.7.0.1
 */