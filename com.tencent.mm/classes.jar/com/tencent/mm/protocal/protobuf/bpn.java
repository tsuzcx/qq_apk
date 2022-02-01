package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpn
  extends com.tencent.mm.bx.a
{
  public cmf DFJ;
  public int DIV;
  public String DIW;
  public int DNS;
  public cmf DNT;
  public cmf DNU;
  public cmf DNV;
  public int Dat;
  public cmf DbD;
  public cmf Dbb;
  public cmf Dbc;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public int ijQ;
  public String ijV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101823);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DbD == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Dbb == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Dbc == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.DNT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.DNU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.DNV == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.DbD != null)
      {
        paramVarArgs.kX(1, this.DbD.computeSize());
        this.DbD.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DNS);
      if (this.DFJ != null)
      {
        paramVarArgs.kX(3, this.DFJ.computeSize());
        this.DFJ.writeFields(paramVarArgs);
      }
      if (this.Dbb != null)
      {
        paramVarArgs.kX(4, this.Dbb.computeSize());
        this.Dbb.writeFields(paramVarArgs);
      }
      if (this.Dbc != null)
      {
        paramVarArgs.kX(5, this.Dbc.computeSize());
        this.Dbc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.ijM);
      if (this.DNT != null)
      {
        paramVarArgs.kX(9, this.DNT.computeSize());
        this.DNT.writeFields(paramVarArgs);
      }
      if (this.DNU != null)
      {
        paramVarArgs.kX(10, this.DNU.computeSize());
        this.DNU.writeFields(paramVarArgs);
      }
      if (this.DNV != null)
      {
        paramVarArgs.kX(11, this.DNV.computeSize());
        this.DNV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.Dat);
      if (this.ijN != null) {
        paramVarArgs.d(13, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(14, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(15, this.ijP);
      }
      paramVarArgs.aR(16, this.ijQ);
      paramVarArgs.aR(17, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(18, this.DIW);
      }
      if (this.ijV != null) {
        paramVarArgs.d(19, this.ijV);
      }
      AppMethodBeat.o(101823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DbD == null) {
        break label2122;
      }
    }
    label2122:
    for (paramInt = f.a.a.a.kW(1, this.DbD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DNS);
      paramInt = i;
      if (this.DFJ != null) {
        paramInt = i + f.a.a.a.kW(3, this.DFJ.computeSize());
      }
      i = paramInt;
      if (this.Dbb != null) {
        i = paramInt + f.a.a.a.kW(4, this.Dbb.computeSize());
      }
      paramInt = i;
      if (this.Dbc != null) {
        paramInt = i + f.a.a.a.kW(5, this.Dbc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.ijM);
      paramInt = i;
      if (this.DNT != null) {
        paramInt = i + f.a.a.a.kW(9, this.DNT.computeSize());
      }
      i = paramInt;
      if (this.DNU != null) {
        i = paramInt + f.a.a.a.kW(10, this.DNU.computeSize());
      }
      paramInt = i;
      if (this.DNV != null) {
        paramInt = i + f.a.a.a.kW(11, this.DNV.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.Dat);
      paramInt = i;
      if (this.ijN != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ijN);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.ijO);
      }
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.ijP);
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.ijQ) + f.a.a.b.b.a.bA(17, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.DIW);
      }
      i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.ijV);
      }
      AppMethodBeat.o(101823);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DbD == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.DFJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Dbb == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Dbc == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.DNT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.DNU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.DNV == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101823);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpn localbpn = (bpn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(101823);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpn.DbD = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 2: 
          localbpn.DNS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101823);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpn.DFJ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpn.Dbb = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpn.Dbc = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 6: 
          localbpn.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101823);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpn.DNT = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpn.DNU = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpn.DNV = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 12: 
          localbpn.Dat = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101823);
          return 0;
        case 13: 
          localbpn.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 14: 
          localbpn.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 15: 
          localbpn.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 16: 
          localbpn.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101823);
          return 0;
        case 17: 
          localbpn.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101823);
          return 0;
        case 18: 
          localbpn.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101823);
          return 0;
        }
        localbpn.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(101823);
        return 0;
      }
      AppMethodBeat.o(101823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpn
 * JD-Core Version:    0.7.0.1
 */