package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class baq
  extends dop
{
  public LinkedList<String> Gbc;
  public int LCN;
  public int LKa;
  public float LKc;
  public float LKd;
  public int LKe;
  public FinderObjectDesc LKf;
  public long LKg;
  public long LKh;
  public LinkedList<String> LKi;
  public b LKj;
  public String LKk;
  public int LKl;
  public aoq attachmentList;
  public String clientId;
  public float dTj;
  public String groupId;
  public float latitude;
  public int originalFlag;
  public String refObjectNonceId;
  public long twd;
  public aov uli;
  public String username;
  
  public baq()
  {
    AppMethodBeat.i(169036);
    this.Gbc = new LinkedList();
    this.LKi = new LinkedList();
    AppMethodBeat.o(169036);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169037);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.LKf != null)
      {
        paramVarArgs.ni(3, this.LKf.computeSize());
        this.LKf.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.e(4, this.clientId);
      }
      paramVarArgs.bb(5, this.LKg);
      if (this.refObjectNonceId != null) {
        paramVarArgs.e(6, this.refObjectNonceId);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(7, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      paramVarArgs.E(8, this.dTj);
      paramVarArgs.E(9, this.latitude);
      paramVarArgs.E(10, this.LKc);
      paramVarArgs.E(11, this.LKd);
      paramVarArgs.aM(12, this.LKe);
      paramVarArgs.e(13, 1, this.Gbc);
      paramVarArgs.aM(14, this.originalFlag);
      paramVarArgs.bb(15, this.LKh);
      paramVarArgs.e(16, 1, this.LKi);
      if (this.LKj != null) {
        paramVarArgs.c(17, this.LKj);
      }
      if (this.groupId != null) {
        paramVarArgs.e(18, this.groupId);
      }
      if (this.attachmentList != null)
      {
        paramVarArgs.ni(20, this.attachmentList.computeSize());
        this.attachmentList.writeFields(paramVarArgs);
      }
      if (this.LKk != null) {
        paramVarArgs.e(21, this.LKk);
      }
      paramVarArgs.aM(22, this.LKl);
      paramVarArgs.aM(23, this.LKa);
      paramVarArgs.bb(24, this.twd);
      paramVarArgs.aM(25, this.LCN);
      AppMethodBeat.o(169037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1814;
      }
    }
    label1814:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.LKf != null) {
        i = paramInt + g.a.a.a.nh(3, this.LKf.computeSize());
      }
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.clientId);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.LKg);
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(7, this.uli.computeSize());
      }
      i = i + (g.a.a.b.b.a.fS(8) + 4) + (g.a.a.b.b.a.fS(9) + 4) + (g.a.a.b.b.a.fS(10) + 4) + (g.a.a.b.b.a.fS(11) + 4) + g.a.a.b.b.a.bu(12, this.LKe) + g.a.a.a.c(13, 1, this.Gbc) + g.a.a.b.b.a.bu(14, this.originalFlag) + g.a.a.b.b.a.r(15, this.LKh) + g.a.a.a.c(16, 1, this.LKi);
      paramInt = i;
      if (this.LKj != null) {
        paramInt = i + g.a.a.b.b.a.b(17, this.LKj);
      }
      i = paramInt;
      if (this.groupId != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.groupId);
      }
      paramInt = i;
      if (this.attachmentList != null) {
        paramInt = i + g.a.a.a.nh(20, this.attachmentList.computeSize());
      }
      i = paramInt;
      if (this.LKk != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.LKk);
      }
      paramInt = g.a.a.b.b.a.bu(22, this.LKl);
      int j = g.a.a.b.b.a.bu(23, this.LKa);
      int k = g.a.a.b.b.a.r(24, this.twd);
      int m = g.a.a.b.b.a.bu(25, this.LCN);
      AppMethodBeat.o(169037);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gbc.clear();
        this.LKi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        baq localbaq = (baq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 19: 
        default: 
          AppMethodBeat.o(169037);
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
            localbaq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 2: 
          localbaq.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObjectDesc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbaq.LKf = ((FinderObjectDesc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 4: 
          localbaq.clientId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 5: 
          localbaq.LKg = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169037);
          return 0;
        case 6: 
          localbaq.refObjectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbaq.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 8: 
          localbaq.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169037);
          return 0;
        case 9: 
          localbaq.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169037);
          return 0;
        case 10: 
          localbaq.LKc = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169037);
          return 0;
        case 11: 
          localbaq.LKd = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169037);
          return 0;
        case 12: 
          localbaq.LKe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169037);
          return 0;
        case 13: 
          localbaq.Gbc.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(169037);
          return 0;
        case 14: 
          localbaq.originalFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169037);
          return 0;
        case 15: 
          localbaq.LKh = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169037);
          return 0;
        case 16: 
          localbaq.LKi.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(169037);
          return 0;
        case 17: 
          localbaq.LKj = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169037);
          return 0;
        case 18: 
          localbaq.groupId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbaq.attachmentList = ((aoq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 21: 
          localbaq.LKk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 22: 
          localbaq.LKl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169037);
          return 0;
        case 23: 
          localbaq.LKa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169037);
          return 0;
        case 24: 
          localbaq.twd = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169037);
          return 0;
        }
        localbaq.LCN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169037);
        return 0;
      }
      AppMethodBeat.o(169037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baq
 * JD-Core Version:    0.7.0.1
 */