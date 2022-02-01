package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bua
  extends com.tencent.mm.bw.a
{
  public String Ewu;
  public int FjE;
  public int FjF;
  public LinkedList<bqx> FjG;
  public LinkedList<dbw> FjH;
  public int FjI;
  public long FjJ;
  public int FjK;
  public LinkedList<Long> FjL;
  public int FjM;
  public int FjN;
  public String FjO;
  public int FjP;
  public daw FjQ;
  public LinkedList<dbc> FjR;
  public String FjS;
  public long FjT;
  public String FjU;
  public boolean FjV;
  public czw FjW;
  public cbh FjX;
  public int Fjj;
  public LinkedList<crm> GroupUser;
  public int dBA;
  public String dvr;
  public int gLY;
  public String hkN;
  public String sessionId;
  public String token;
  
  public bua()
  {
    AppMethodBeat.i(125744);
    this.FjG = new LinkedList();
    this.FjH = new LinkedList();
    this.FjL = new LinkedList();
    this.GroupUser = new LinkedList();
    this.FjR = new LinkedList();
    AppMethodBeat.o(125744);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FjE);
      paramVarArgs.aR(2, this.FjF);
      paramVarArgs.aR(3, this.Fjj);
      if (this.hkN != null) {
        paramVarArgs.d(4, this.hkN);
      }
      paramVarArgs.e(5, 8, this.FjG);
      paramVarArgs.e(6, 8, this.FjH);
      paramVarArgs.aR(7, this.FjI);
      paramVarArgs.aR(8, this.gLY);
      paramVarArgs.aO(9, this.FjJ);
      paramVarArgs.aR(10, this.FjK);
      paramVarArgs.e(11, 3, this.FjL);
      paramVarArgs.aR(12, this.FjM);
      paramVarArgs.aR(13, this.FjN);
      if (this.token != null) {
        paramVarArgs.d(14, this.token);
      }
      if (this.FjO != null) {
        paramVarArgs.d(15, this.FjO);
      }
      paramVarArgs.aR(16, this.FjP);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.FjQ != null)
      {
        paramVarArgs.ln(18, this.FjQ.computeSize());
        this.FjQ.writeFields(paramVarArgs);
      }
      if (this.dvr != null) {
        paramVarArgs.d(19, this.dvr);
      }
      paramVarArgs.e(20, 8, this.FjR);
      if (this.sessionId != null) {
        paramVarArgs.d(21, this.sessionId);
      }
      if (this.FjS != null) {
        paramVarArgs.d(22, this.FjS);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(23, this.Ewu);
      }
      paramVarArgs.aR(24, this.dBA);
      paramVarArgs.aO(25, this.FjT);
      if (this.FjU != null) {
        paramVarArgs.d(26, this.FjU);
      }
      paramVarArgs.bl(27, this.FjV);
      if (this.FjW != null)
      {
        paramVarArgs.ln(28, this.FjW.computeSize());
        this.FjW.writeFields(paramVarArgs);
      }
      if (this.FjX != null)
      {
        paramVarArgs.ln(29, this.FjX.computeSize());
        this.FjX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FjE) + 0 + f.a.a.b.b.a.bx(2, this.FjF) + f.a.a.b.b.a.bx(3, this.Fjj);
      paramInt = i;
      if (this.hkN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hkN);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.FjG) + f.a.a.a.c(6, 8, this.FjH) + f.a.a.b.b.a.bx(7, this.FjI) + f.a.a.b.b.a.bx(8, this.gLY) + f.a.a.b.b.a.p(9, this.FjJ) + f.a.a.b.b.a.bx(10, this.FjK) + f.a.a.a.c(11, 3, this.FjL) + f.a.a.b.b.a.bx(12, this.FjM) + f.a.a.b.b.a.bx(13, this.FjN);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.token);
      }
      i = paramInt;
      if (this.FjO != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.FjO);
      }
      i = i + f.a.a.b.b.a.bx(16, this.FjP) + f.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.FjQ != null) {
        paramInt = i + f.a.a.a.lm(18, this.FjQ.computeSize());
      }
      i = paramInt;
      if (this.dvr != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.dvr);
      }
      i += f.a.a.a.c(20, 8, this.FjR);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.sessionId);
      }
      i = paramInt;
      if (this.FjS != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.FjS);
      }
      paramInt = i;
      if (this.Ewu != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Ewu);
      }
      i = paramInt + f.a.a.b.b.a.bx(24, this.dBA) + f.a.a.b.b.a.p(25, this.FjT);
      paramInt = i;
      if (this.FjU != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.FjU);
      }
      i = paramInt + (f.a.a.b.b.a.fK(27) + 1);
      paramInt = i;
      if (this.FjW != null) {
        paramInt = i + f.a.a.a.lm(28, this.FjW.computeSize());
      }
      i = paramInt;
      if (this.FjX != null) {
        i = paramInt + f.a.a.a.lm(29, this.FjX.computeSize());
      }
      AppMethodBeat.o(125745);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FjG.clear();
      this.FjH.clear();
      this.FjL.clear();
      this.GroupUser.clear();
      this.FjR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bua localbua = (bua)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125745);
        return -1;
      case 1: 
        localbua.FjE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 2: 
        localbua.FjF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 3: 
        localbua.Fjj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 4: 
        localbua.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbua.FjG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbua.FjH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 7: 
        localbua.FjI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 8: 
        localbua.gLY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 9: 
        localbua.FjJ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(125745);
        return 0;
      case 10: 
        localbua.FjK = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 11: 
        localbua.FjL.add(Long.valueOf(((f.a.a.a.a)localObject1).LVo.xG()));
        AppMethodBeat.o(125745);
        return 0;
      case 12: 
        localbua.FjM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 13: 
        localbua.FjN = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 14: 
        localbua.token = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 15: 
        localbua.FjO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 16: 
        localbua.FjP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbua.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new daw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((daw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbua.FjQ = ((daw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 19: 
        localbua.dvr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbua.FjR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 21: 
        localbua.sessionId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 22: 
        localbua.FjS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 23: 
        localbua.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 24: 
        localbua.dBA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125745);
        return 0;
      case 25: 
        localbua.FjT = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(125745);
        return 0;
      case 26: 
        localbua.FjU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 27: 
        localbua.FjV = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(125745);
        return 0;
      case 28: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbua.FjW = ((czw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cbh();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cbh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbua.FjX = ((cbh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    AppMethodBeat.o(125745);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bua
 * JD-Core Version:    0.7.0.1
 */