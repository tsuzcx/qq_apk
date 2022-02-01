package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cti
  extends com.tencent.mm.bw.a
{
  public String Eof;
  public String Eog;
  public crm EuE;
  public crm Fbd;
  public int Feq;
  public String Fer;
  public String Fes;
  public String Fet;
  public int Feu;
  public aaf Fex;
  public int iJT;
  public String iJU;
  public String iJV;
  public String iJW;
  public int iJX;
  public String iJY;
  public String iKc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6431);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(6431);
        throw paramVarArgs;
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(6431);
        throw paramVarArgs;
      }
      if (this.EuE != null)
      {
        paramVarArgs.ln(1, this.EuE.computeSize());
        this.EuE.writeFields(paramVarArgs);
      }
      if (this.Fbd != null)
      {
        paramVarArgs.ln(2, this.Fbd.computeSize());
        this.Fbd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.iJT);
      if (this.iJU != null) {
        paramVarArgs.d(4, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(5, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(6, this.iJW);
      }
      paramVarArgs.aR(7, this.iJX);
      paramVarArgs.aR(8, this.Feq);
      if (this.Fer != null) {
        paramVarArgs.d(9, this.Fer);
      }
      if (this.Fes != null) {
        paramVarArgs.d(10, this.Fes);
      }
      if (this.iJY != null) {
        paramVarArgs.d(11, this.iJY);
      }
      if (this.Fet != null) {
        paramVarArgs.d(12, this.Fet);
      }
      paramVarArgs.aR(13, this.Feu);
      if (this.iKc != null) {
        paramVarArgs.d(14, this.iKc);
      }
      if (this.Fex != null)
      {
        paramVarArgs.ln(15, this.Fex.computeSize());
        this.Fex.writeFields(paramVarArgs);
      }
      if (this.Eof != null) {
        paramVarArgs.d(16, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(17, this.Eog);
      }
      AppMethodBeat.o(6431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuE == null) {
        break label1541;
      }
    }
    label1541:
    for (paramInt = f.a.a.a.lm(1, this.EuE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fbd != null) {
        i = paramInt + f.a.a.a.lm(2, this.Fbd.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.iJT);
      paramInt = i;
      if (this.iJU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iJU);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iJV);
      }
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iJW);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.iJX) + f.a.a.b.b.a.bx(8, this.Feq);
      paramInt = i;
      if (this.Fer != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fer);
      }
      i = paramInt;
      if (this.Fes != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Fes);
      }
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.iJY);
      }
      i = paramInt;
      if (this.Fet != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Fet);
      }
      i += f.a.a.b.b.a.bx(13, this.Feu);
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.iKc);
      }
      i = paramInt;
      if (this.Fex != null) {
        i = paramInt + f.a.a.a.lm(15, this.Fex.computeSize());
      }
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Eog);
      }
      AppMethodBeat.o(6431);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EuE == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(6431);
          throw paramVarArgs;
        }
        if (this.Fbd == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(6431);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6431);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cti localcti = (cti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6431);
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
            localcti.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcti.Fbd = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 3: 
          localcti.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6431);
          return 0;
        case 4: 
          localcti.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 5: 
          localcti.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 6: 
          localcti.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 7: 
          localcti.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6431);
          return 0;
        case 8: 
          localcti.Feq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6431);
          return 0;
        case 9: 
          localcti.Fer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 10: 
          localcti.Fes = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 11: 
          localcti.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 12: 
          localcti.Fet = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 13: 
          localcti.Feu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6431);
          return 0;
        case 14: 
          localcti.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcti.Fex = ((aaf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 16: 
          localcti.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6431);
          return 0;
        }
        localcti.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(6431);
        return 0;
      }
      AppMethodBeat.o(6431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cti
 * JD-Core Version:    0.7.0.1
 */