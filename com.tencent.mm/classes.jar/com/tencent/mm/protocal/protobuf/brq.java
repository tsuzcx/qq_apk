package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brq
  extends com.tencent.mm.bw.a
{
  public String ELg;
  public String Eof;
  public String Eog;
  public dbt Few;
  public aaf Fex;
  public afs FgI;
  public String Nickname;
  public String Username;
  public String iJS;
  public int iJT;
  public String iJU;
  public String iJV;
  public String iJW;
  public int iJX;
  public String iJY;
  public int iJZ;
  public int iKa;
  public String iKb;
  public String iKc;
  public String iKd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      if (this.iJS != null) {
        paramVarArgs.d(3, this.iJS);
      }
      paramVarArgs.aR(4, this.iJT);
      if (this.iJU != null) {
        paramVarArgs.d(5, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(6, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(7, this.iJW);
      }
      paramVarArgs.aR(8, this.iJX);
      if (this.iJY != null) {
        paramVarArgs.d(9, this.iJY);
      }
      if (this.FgI != null)
      {
        paramVarArgs.ln(10, this.FgI.computeSize());
        this.FgI.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.iJZ);
      paramVarArgs.aR(12, this.iKa);
      if (this.iKb != null) {
        paramVarArgs.d(13, this.iKb);
      }
      if (this.Few != null)
      {
        paramVarArgs.ln(14, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      if (this.iKc != null) {
        paramVarArgs.d(15, this.iKc);
      }
      if (this.iKd != null) {
        paramVarArgs.d(16, this.iKd);
      }
      if (this.Fex != null)
      {
        paramVarArgs.ln(17, this.Fex.computeSize());
        this.Fex.writeFields(paramVarArgs);
      }
      if (this.Eof != null) {
        paramVarArgs.d(20, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(21, this.Eog);
      }
      if (this.ELg != null) {
        paramVarArgs.d(22, this.ELg);
      }
      AppMethodBeat.o(155440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1610;
      }
    }
    label1610:
    for (int i = f.a.a.b.b.a.e(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = paramInt;
      if (this.iJS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iJS);
      }
      i += f.a.a.b.b.a.bx(4, this.iJT);
      paramInt = i;
      if (this.iJU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iJU);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.iJV);
      }
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iJW);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.iJX);
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iJY);
      }
      i = paramInt;
      if (this.FgI != null) {
        i = paramInt + f.a.a.a.lm(10, this.FgI.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(11, this.iJZ) + f.a.a.b.b.a.bx(12, this.iKa);
      paramInt = i;
      if (this.iKb != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.iKb);
      }
      i = paramInt;
      if (this.Few != null) {
        i = paramInt + f.a.a.a.lm(14, this.Few.computeSize());
      }
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.iKc);
      }
      i = paramInt;
      if (this.iKd != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.iKd);
      }
      paramInt = i;
      if (this.Fex != null) {
        paramInt = i + f.a.a.a.lm(17, this.Fex.computeSize());
      }
      i = paramInt;
      if (this.Eof != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Eof);
      }
      paramInt = i;
      if (this.Eog != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Eog);
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.ELg);
      }
      AppMethodBeat.o(155440);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brq localbrq = (brq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(155440);
          return -1;
        case 1: 
          localbrq.Username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 2: 
          localbrq.Nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 3: 
          localbrq.iJS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 4: 
          localbrq.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155440);
          return 0;
        case 5: 
          localbrq.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 6: 
          localbrq.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 7: 
          localbrq.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 8: 
          localbrq.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155440);
          return 0;
        case 9: 
          localbrq.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrq.FgI = ((afs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 11: 
          localbrq.iJZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155440);
          return 0;
        case 12: 
          localbrq.iKa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155440);
          return 0;
        case 13: 
          localbrq.iKb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrq.Few = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 15: 
          localbrq.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 16: 
          localbrq.iKd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrq.Fex = ((aaf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 20: 
          localbrq.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 21: 
          localbrq.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155440);
          return 0;
        }
        localbrq.ELg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155440);
        return 0;
      }
      AppMethodBeat.o(155440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brq
 * JD-Core Version:    0.7.0.1
 */