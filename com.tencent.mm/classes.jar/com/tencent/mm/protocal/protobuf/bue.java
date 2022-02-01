package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bue
  extends com.tencent.mm.bw.a
{
  public crm EtY;
  public crm EtZ;
  public int Etq;
  public crm EuJ;
  public crm Fbd;
  public int Feq;
  public String Fer;
  public int Fkj;
  public crm Fkk;
  public crm Fkl;
  public crm Fkm;
  public int iJT;
  public String iJU;
  public String iJV;
  public String iJW;
  public int iJX;
  public String iKc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101823);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.EtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.EtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Fkk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Fkl == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Fkm == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.EuJ != null)
      {
        paramVarArgs.ln(1, this.EuJ.computeSize());
        this.EuJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Fkj);
      if (this.Fbd != null)
      {
        paramVarArgs.ln(3, this.Fbd.computeSize());
        this.Fbd.writeFields(paramVarArgs);
      }
      if (this.EtY != null)
      {
        paramVarArgs.ln(4, this.EtY.computeSize());
        this.EtY.writeFields(paramVarArgs);
      }
      if (this.EtZ != null)
      {
        paramVarArgs.ln(5, this.EtZ.computeSize());
        this.EtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.iJT);
      if (this.Fkk != null)
      {
        paramVarArgs.ln(9, this.Fkk.computeSize());
        this.Fkk.writeFields(paramVarArgs);
      }
      if (this.Fkl != null)
      {
        paramVarArgs.ln(10, this.Fkl.computeSize());
        this.Fkl.writeFields(paramVarArgs);
      }
      if (this.Fkm != null)
      {
        paramVarArgs.ln(11, this.Fkm.computeSize());
        this.Fkm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.Etq);
      if (this.iJU != null) {
        paramVarArgs.d(13, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(14, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(15, this.iJW);
      }
      paramVarArgs.aR(16, this.iJX);
      paramVarArgs.aR(17, this.Feq);
      if (this.Fer != null) {
        paramVarArgs.d(18, this.Fer);
      }
      if (this.iKc != null) {
        paramVarArgs.d(19, this.iKc);
      }
      AppMethodBeat.o(101823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuJ == null) {
        break label2122;
      }
    }
    label2122:
    for (paramInt = f.a.a.a.lm(1, this.EuJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fkj);
      paramInt = i;
      if (this.Fbd != null) {
        paramInt = i + f.a.a.a.lm(3, this.Fbd.computeSize());
      }
      i = paramInt;
      if (this.EtY != null) {
        i = paramInt + f.a.a.a.lm(4, this.EtY.computeSize());
      }
      paramInt = i;
      if (this.EtZ != null) {
        paramInt = i + f.a.a.a.lm(5, this.EtZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.iJT);
      paramInt = i;
      if (this.Fkk != null) {
        paramInt = i + f.a.a.a.lm(9, this.Fkk.computeSize());
      }
      i = paramInt;
      if (this.Fkl != null) {
        i = paramInt + f.a.a.a.lm(10, this.Fkl.computeSize());
      }
      paramInt = i;
      if (this.Fkm != null) {
        paramInt = i + f.a.a.a.lm(11, this.Fkm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.Etq);
      paramInt = i;
      if (this.iJU != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.iJU);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.iJV);
      }
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.iJW);
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.iJX) + f.a.a.b.b.a.bx(17, this.Feq);
      paramInt = i;
      if (this.Fer != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Fer);
      }
      i = paramInt;
      if (this.iKc != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.iKc);
      }
      AppMethodBeat.o(101823);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EuJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Fbd == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.EtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.EtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Fkk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Fkl == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Fkm == null)
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
        bue localbue = (bue)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.EuJ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 2: 
          localbue.Fkj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101823);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.Fbd = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.EtY = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.EtZ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 6: 
          localbue.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101823);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.Fkk = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.Fkl = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.Fkm = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 12: 
          localbue.Etq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101823);
          return 0;
        case 13: 
          localbue.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 14: 
          localbue.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 15: 
          localbue.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 16: 
          localbue.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101823);
          return 0;
        case 17: 
          localbue.Feq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101823);
          return 0;
        case 18: 
          localbue.Fer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101823);
          return 0;
        }
        localbue.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(101823);
        return 0;
      }
      AppMethodBeat.o(101823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bue
 * JD-Core Version:    0.7.0.1
 */