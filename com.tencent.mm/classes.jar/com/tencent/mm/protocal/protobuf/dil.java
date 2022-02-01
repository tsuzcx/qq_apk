package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dil
  extends com.tencent.mm.bw.a
{
  public LinkedList<yh> BYq;
  public dio FRA;
  public cyv FRB;
  public boolean FRC;
  public LinkedList<dio> FRD;
  public int FRE;
  public int FRF;
  public String FRG;
  public int FRH;
  public boolean FRI;
  public String FRv;
  public String FRw;
  public String FRx;
  public String FRy;
  public long FRz;
  public String cZL;
  public boolean ftN;
  public String jKB;
  public int offset;
  public String qox;
  public int scene;
  
  public dil()
  {
    AppMethodBeat.i(153006);
    this.BYq = new LinkedList();
    this.FRD = new LinkedList();
    AppMethodBeat.o(153006);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153007);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRv != null) {
        paramVarArgs.d(1, this.FRv);
      }
      if (this.FRw != null) {
        paramVarArgs.d(2, this.FRw);
      }
      if (this.FRx != null) {
        paramVarArgs.d(3, this.FRx);
      }
      if (this.FRy != null) {
        paramVarArgs.d(4, this.FRy);
      }
      paramVarArgs.aO(5, this.FRz);
      paramVarArgs.aR(6, this.scene);
      if (this.jKB != null) {
        paramVarArgs.d(7, this.jKB);
      }
      if (this.cZL != null) {
        paramVarArgs.d(8, this.cZL);
      }
      if (this.FRA != null)
      {
        paramVarArgs.ln(9, this.FRA.computeSize());
        this.FRA.writeFields(paramVarArgs);
      }
      if (this.FRB != null)
      {
        paramVarArgs.ln(10, this.FRB.computeSize());
        this.FRB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.BYq);
      if (this.qox != null) {
        paramVarArgs.d(12, this.qox);
      }
      paramVarArgs.aR(13, this.offset);
      paramVarArgs.bl(14, this.FRC);
      paramVarArgs.e(15, 8, this.FRD);
      paramVarArgs.aR(16, this.FRE);
      paramVarArgs.aR(17, this.FRF);
      paramVarArgs.bl(18, this.ftN);
      if (this.FRG != null) {
        paramVarArgs.d(19, this.FRG);
      }
      paramVarArgs.aR(20, this.FRH);
      paramVarArgs.bl(21, this.FRI);
      AppMethodBeat.o(153007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FRv == null) {
        break label1638;
      }
    }
    label1638:
    for (int i = f.a.a.b.b.a.e(1, this.FRv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FRw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FRw);
      }
      i = paramInt;
      if (this.FRx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FRx);
      }
      paramInt = i;
      if (this.FRy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FRy);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.FRz) + f.a.a.b.b.a.bx(6, this.scene);
      paramInt = i;
      if (this.jKB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.jKB);
      }
      i = paramInt;
      if (this.cZL != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.cZL);
      }
      paramInt = i;
      if (this.FRA != null) {
        paramInt = i + f.a.a.a.lm(9, this.FRA.computeSize());
      }
      i = paramInt;
      if (this.FRB != null) {
        i = paramInt + f.a.a.a.lm(10, this.FRB.computeSize());
      }
      i += f.a.a.a.c(11, 8, this.BYq);
      paramInt = i;
      if (this.qox != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.qox);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.offset) + (f.a.a.b.b.a.fK(14) + 1) + f.a.a.a.c(15, 8, this.FRD) + f.a.a.b.b.a.bx(16, this.FRE) + f.a.a.b.b.a.bx(17, this.FRF) + (f.a.a.b.b.a.fK(18) + 1);
      paramInt = i;
      if (this.FRG != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.FRG);
      }
      i = f.a.a.b.b.a.bx(20, this.FRH);
      int j = f.a.a.b.b.a.fK(21);
      AppMethodBeat.o(153007);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.BYq.clear();
        this.FRD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dil localdil = (dil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153007);
          return -1;
        case 1: 
          localdil.FRv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 2: 
          localdil.FRw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 3: 
          localdil.FRx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 4: 
          localdil.FRy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 5: 
          localdil.FRz = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153007);
          return 0;
        case 6: 
          localdil.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153007);
          return 0;
        case 7: 
          localdil.jKB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 8: 
          localdil.cZL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdil.FRA = ((dio)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdil.FRB = ((cyv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdil.BYq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 12: 
          localdil.qox = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 13: 
          localdil.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153007);
          return 0;
        case 14: 
          localdil.FRC = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153007);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdil.FRD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 16: 
          localdil.FRE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153007);
          return 0;
        case 17: 
          localdil.FRF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153007);
          return 0;
        case 18: 
          localdil.ftN = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153007);
          return 0;
        case 19: 
          localdil.FRG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 20: 
          localdil.FRH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153007);
          return 0;
        }
        localdil.FRI = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(153007);
        return 0;
      }
      AppMethodBeat.o(153007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dil
 * JD-Core Version:    0.7.0.1
 */