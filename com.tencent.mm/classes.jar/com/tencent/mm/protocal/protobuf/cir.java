package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cir
  extends com.tencent.mm.bw.a
{
  public String ELg;
  public String Eof;
  public String Eog;
  public dbt Few;
  public aaf Fex;
  public int FwJ;
  public String FwK;
  public int FwL;
  public String FwM;
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
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FwJ);
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(3, this.ndW);
      }
      if (this.FwK != null) {
        paramVarArgs.d(4, this.FwK);
      }
      paramVarArgs.aR(5, this.FwL);
      if (this.FwM != null) {
        paramVarArgs.d(6, this.FwM);
      }
      paramVarArgs.aR(7, this.iJT);
      if (this.iJU != null) {
        paramVarArgs.d(8, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(9, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(10, this.iJW);
      }
      paramVarArgs.aR(11, this.iJX);
      if (this.iJY != null) {
        paramVarArgs.d(12, this.iJY);
      }
      paramVarArgs.aR(13, this.iJZ);
      paramVarArgs.aR(14, this.iKa);
      if (this.iKb != null) {
        paramVarArgs.d(15, this.iKb);
      }
      if (this.Few != null)
      {
        paramVarArgs.ln(16, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      if (this.iKc != null) {
        paramVarArgs.d(17, this.iKc);
      }
      if (this.iKd != null) {
        paramVarArgs.d(18, this.iKd);
      }
      if (this.Fex != null)
      {
        paramVarArgs.ln(19, this.Fex.computeSize());
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
      AppMethodBeat.o(155448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FwJ) + 0;
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ndW);
      }
      paramInt = i;
      if (this.FwK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FwK);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FwL);
      paramInt = i;
      if (this.FwM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FwM);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.iJT);
      paramInt = i;
      if (this.iJU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iJU);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iJV);
      }
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.iJW);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.iJX);
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.iJY);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.iJZ) + f.a.a.b.b.a.bx(14, this.iKa);
      paramInt = i;
      if (this.iKb != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.iKb);
      }
      i = paramInt;
      if (this.Few != null) {
        i = paramInt + f.a.a.a.lm(16, this.Few.computeSize());
      }
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.iKc);
      }
      i = paramInt;
      if (this.iKd != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.iKd);
      }
      paramInt = i;
      if (this.Fex != null) {
        paramInt = i + f.a.a.a.lm(19, this.Fex.computeSize());
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
      AppMethodBeat.o(155448);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cir localcir = (cir)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155448);
        return -1;
      case 1: 
        localcir.FwJ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155448);
        return 0;
      case 2: 
        localcir.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 3: 
        localcir.ndW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 4: 
        localcir.FwK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 5: 
        localcir.FwL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155448);
        return 0;
      case 6: 
        localcir.FwM = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 7: 
        localcir.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155448);
        return 0;
      case 8: 
        localcir.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 9: 
        localcir.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 10: 
        localcir.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 11: 
        localcir.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155448);
        return 0;
      case 12: 
        localcir.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 13: 
        localcir.iJZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155448);
        return 0;
      case 14: 
        localcir.iKa = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155448);
        return 0;
      case 15: 
        localcir.iKb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcir.Few = ((dbt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 17: 
        localcir.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 18: 
        localcir.iKd = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcir.Fex = ((aaf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 20: 
        localcir.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 21: 
        localcir.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155448);
        return 0;
      }
      localcir.ELg = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(155448);
      return 0;
    }
    AppMethodBeat.o(155448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cir
 * JD-Core Version:    0.7.0.1
 */