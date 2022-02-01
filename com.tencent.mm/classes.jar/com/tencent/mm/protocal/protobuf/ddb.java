package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddb
  extends com.tencent.mm.bx.a
{
  public LinkedList<xp> AFX;
  public String AGA;
  public String AGB;
  public String AGx;
  public String AGy;
  public String AGz;
  public String EuM;
  public long EuN;
  public String EuO;
  public String EuP;
  public int EuQ;
  public String EuR;
  public String EuS;
  public long EuT;
  public long EuU;
  public LinkedList<ddd> EuV;
  public int EuW;
  public long EuX;
  public dcw EuY;
  public int EuZ;
  public int Eva;
  public boolean Evb;
  public String Evc;
  public dcz Evd;
  public int Eve;
  public ddb Evf;
  public int Evg;
  public dcu Evh;
  public long dcn;
  public boolean ddw;
  public String kqB;
  public String oYa;
  public String oYb;
  public LinkedList<ctk> rNO;
  public String rNP;
  public String rUO;
  public String roQ;
  public String source;
  public int thumbHeight;
  public int thumbWidth;
  public long timestamp;
  public String title;
  public String videoUrl;
  public int xot;
  
  public ddb()
  {
    AppMethodBeat.i(153012);
    this.rNO = new LinkedList();
    this.EuV = new LinkedList();
    this.AFX = new LinkedList();
    AppMethodBeat.o(153012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(2, this.videoUrl);
      }
      if (this.EuM != null) {
        paramVarArgs.d(3, this.EuM);
      }
      paramVarArgs.aR(4, this.xot);
      if (this.rNP != null) {
        paramVarArgs.d(5, this.rNP);
      }
      paramVarArgs.aR(6, this.thumbWidth);
      paramVarArgs.aR(7, this.thumbHeight);
      if (this.oYa != null) {
        paramVarArgs.d(8, this.oYa);
      }
      if (this.oYb != null) {
        paramVarArgs.d(9, this.oYb);
      }
      if (this.rUO != null) {
        paramVarArgs.d(10, this.rUO);
      }
      if (this.AGx != null) {
        paramVarArgs.d(11, this.AGx);
      }
      if (this.AGy != null) {
        paramVarArgs.d(12, this.AGy);
      }
      if (this.AGz != null) {
        paramVarArgs.d(13, this.AGz);
      }
      if (this.source != null) {
        paramVarArgs.d(14, this.source);
      }
      if (this.kqB != null) {
        paramVarArgs.d(15, this.kqB);
      }
      paramVarArgs.aG(16, this.EuN);
      if (this.EuO != null) {
        paramVarArgs.d(17, this.EuO);
      }
      if (this.EuP != null) {
        paramVarArgs.d(18, this.EuP);
      }
      if (this.AGA != null) {
        paramVarArgs.d(19, this.AGA);
      }
      if (this.AGB != null) {
        paramVarArgs.d(20, this.AGB);
      }
      paramVarArgs.aR(21, this.EuQ);
      if (this.EuR != null) {
        paramVarArgs.d(22, this.EuR);
      }
      if (this.EuS != null) {
        paramVarArgs.d(23, this.EuS);
      }
      paramVarArgs.e(24, 8, this.rNO);
      paramVarArgs.aG(25, this.timestamp);
      paramVarArgs.bg(26, this.ddw);
      if (this.roQ != null) {
        paramVarArgs.d(27, this.roQ);
      }
      paramVarArgs.aG(28, this.EuT);
      paramVarArgs.aG(29, this.dcn);
      paramVarArgs.aG(30, this.EuU);
      paramVarArgs.e(31, 8, this.EuV);
      paramVarArgs.aR(32, this.EuW);
      paramVarArgs.aG(33, this.EuX);
      if (this.EuY != null)
      {
        paramVarArgs.kX(34, this.EuY.computeSize());
        this.EuY.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(35, this.EuZ);
      paramVarArgs.aR(36, this.Eva);
      paramVarArgs.bg(37, this.Evb);
      if (this.Evc != null) {
        paramVarArgs.d(38, this.Evc);
      }
      if (this.Evd != null)
      {
        paramVarArgs.kX(39, this.Evd.computeSize());
        this.Evd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(40, this.Eve);
      if (this.Evf != null)
      {
        paramVarArgs.kX(41, this.Evf.computeSize());
        this.Evf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(42, 8, this.AFX);
      paramVarArgs.aR(43, this.Evg);
      if (this.Evh != null)
      {
        paramVarArgs.kX(44, this.Evh.computeSize());
        this.Evh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label3190;
      }
    }
    label3190:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.videoUrl);
      }
      i = paramInt;
      if (this.EuM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EuM);
      }
      i += f.a.a.b.b.a.bA(4, this.xot);
      paramInt = i;
      if (this.rNP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.rNP);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.thumbWidth) + f.a.a.b.b.a.bA(7, this.thumbHeight);
      paramInt = i;
      if (this.oYa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.oYa);
      }
      i = paramInt;
      if (this.oYb != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.oYb);
      }
      paramInt = i;
      if (this.rUO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.rUO);
      }
      i = paramInt;
      if (this.AGx != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.AGx);
      }
      paramInt = i;
      if (this.AGy != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.AGy);
      }
      i = paramInt;
      if (this.AGz != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.AGz);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.source);
      }
      i = paramInt;
      if (this.kqB != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.kqB);
      }
      i += f.a.a.b.b.a.q(16, this.EuN);
      paramInt = i;
      if (this.EuO != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EuO);
      }
      i = paramInt;
      if (this.EuP != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.EuP);
      }
      paramInt = i;
      if (this.AGA != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.AGA);
      }
      i = paramInt;
      if (this.AGB != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.AGB);
      }
      i += f.a.a.b.b.a.bA(21, this.EuQ);
      paramInt = i;
      if (this.EuR != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.EuR);
      }
      i = paramInt;
      if (this.EuS != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.EuS);
      }
      i = i + f.a.a.a.c(24, 8, this.rNO) + f.a.a.b.b.a.q(25, this.timestamp) + (f.a.a.b.b.a.fY(26) + 1);
      paramInt = i;
      if (this.roQ != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.roQ);
      }
      i = paramInt + f.a.a.b.b.a.q(28, this.EuT) + f.a.a.b.b.a.q(29, this.dcn) + f.a.a.b.b.a.q(30, this.EuU) + f.a.a.a.c(31, 8, this.EuV) + f.a.a.b.b.a.bA(32, this.EuW) + f.a.a.b.b.a.q(33, this.EuX);
      paramInt = i;
      if (this.EuY != null) {
        paramInt = i + f.a.a.a.kW(34, this.EuY.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(35, this.EuZ) + f.a.a.b.b.a.bA(36, this.Eva) + (f.a.a.b.b.a.fY(37) + 1);
      paramInt = i;
      if (this.Evc != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.Evc);
      }
      i = paramInt;
      if (this.Evd != null) {
        i = paramInt + f.a.a.a.kW(39, this.Evd.computeSize());
      }
      i += f.a.a.b.b.a.bA(40, this.Eve);
      paramInt = i;
      if (this.Evf != null) {
        paramInt = i + f.a.a.a.kW(41, this.Evf.computeSize());
      }
      i = paramInt + f.a.a.a.c(42, 8, this.AFX) + f.a.a.b.b.a.bA(43, this.Evg);
      paramInt = i;
      if (this.Evh != null) {
        paramInt = i + f.a.a.a.kW(44, this.Evh.computeSize());
      }
      AppMethodBeat.o(153013);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rNO.clear();
        this.EuV.clear();
        this.AFX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddb localddb = (ddb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153013);
          return -1;
        case 1: 
          localddb.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 2: 
          localddb.videoUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 3: 
          localddb.EuM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 4: 
          localddb.xot = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        case 5: 
          localddb.rNP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 6: 
          localddb.thumbWidth = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        case 7: 
          localddb.thumbHeight = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        case 8: 
          localddb.oYa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 9: 
          localddb.oYb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 10: 
          localddb.rUO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 11: 
          localddb.AGx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 12: 
          localddb.AGy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 13: 
          localddb.AGz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 14: 
          localddb.source = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 15: 
          localddb.kqB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 16: 
          localddb.EuN = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153013);
          return 0;
        case 17: 
          localddb.EuO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 18: 
          localddb.EuP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 19: 
          localddb.AGA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 20: 
          localddb.AGB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 21: 
          localddb.EuQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        case 22: 
          localddb.EuR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 23: 
          localddb.EuS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.rNO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 25: 
          localddb.timestamp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153013);
          return 0;
        case 26: 
          localddb.ddw = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153013);
          return 0;
        case 27: 
          localddb.roQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 28: 
          localddb.EuT = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153013);
          return 0;
        case 29: 
          localddb.dcn = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153013);
          return 0;
        case 30: 
          localddb.EuU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153013);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.EuV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 32: 
          localddb.EuW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        case 33: 
          localddb.EuX = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153013);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.EuY = ((dcw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 35: 
          localddb.EuZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        case 36: 
          localddb.Eva = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        case 37: 
          localddb.Evb = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153013);
          return 0;
        case 38: 
          localddb.Evc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 39: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.Evd = ((dcz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 40: 
          localddb.Eve = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        case 41: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.Evf = ((ddb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 42: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.AFX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 43: 
          localddb.Evg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153013);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localddb.Evh = ((dcu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      AppMethodBeat.o(153013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddb
 * JD-Core Version:    0.7.0.1
 */