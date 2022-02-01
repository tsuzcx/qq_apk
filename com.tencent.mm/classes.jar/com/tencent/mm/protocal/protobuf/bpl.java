package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpl
  extends com.tencent.mm.bx.a
{
  public int DJF;
  public int DMS;
  public bpd DNK;
  public int DNL;
  public LinkedList<bpd> DNM;
  public String DNN;
  public String DNO;
  public String DNP;
  public boj DNQ;
  public int DNR;
  public String DNl;
  public int DNn;
  public int DNo;
  public int DNw;
  public String DNx;
  public String Desc;
  public int aTB;
  public int dia;
  public String dlB;
  public int gll;
  public String md5;
  public String token;
  public String videoPath;
  
  public bpl()
  {
    AppMethodBeat.i(125747);
    this.DNM = new LinkedList();
    AppMethodBeat.o(125747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125748);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DNn);
      paramVarArgs.aR(2, this.DNo);
      paramVarArgs.aR(3, this.DMS);
      if (this.DNK != null)
      {
        paramVarArgs.kX(4, this.DNK.computeSize());
        this.DNK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.DNL);
      paramVarArgs.e(6, 8, this.DNM);
      paramVarArgs.aR(7, this.gll);
      paramVarArgs.aR(8, this.DJF);
      if (this.Desc != null) {
        paramVarArgs.d(9, this.Desc);
      }
      if (this.DNN != null) {
        paramVarArgs.d(10, this.DNN);
      }
      if (this.token != null) {
        paramVarArgs.d(11, this.token);
      }
      if (this.DNx != null) {
        paramVarArgs.d(12, this.DNx);
      }
      paramVarArgs.aR(13, this.DNw);
      if (this.videoPath != null) {
        paramVarArgs.d(14, this.videoPath);
      }
      if (this.DNO != null) {
        paramVarArgs.d(15, this.DNO);
      }
      if (this.DNP != null) {
        paramVarArgs.d(16, this.DNP);
      }
      if (this.md5 != null) {
        paramVarArgs.d(17, this.md5);
      }
      if (this.dlB != null) {
        paramVarArgs.d(18, this.dlB);
      }
      paramVarArgs.aR(19, this.aTB);
      paramVarArgs.aR(20, this.dia);
      if (this.DNl != null) {
        paramVarArgs.d(21, this.DNl);
      }
      if (this.DNQ != null)
      {
        paramVarArgs.kX(22, this.DNQ.computeSize());
        this.DNQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(23, this.DNR);
      AppMethodBeat.o(125748);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DNn) + 0 + f.a.a.b.b.a.bA(2, this.DNo) + f.a.a.b.b.a.bA(3, this.DMS);
      paramInt = i;
      if (this.DNK != null) {
        paramInt = i + f.a.a.a.kW(4, this.DNK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DNL) + f.a.a.a.c(6, 8, this.DNM) + f.a.a.b.b.a.bA(7, this.gll) + f.a.a.b.b.a.bA(8, this.DJF);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Desc);
      }
      i = paramInt;
      if (this.DNN != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DNN);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.token);
      }
      i = paramInt;
      if (this.DNx != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DNx);
      }
      i += f.a.a.b.b.a.bA(13, this.DNw);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.videoPath);
      }
      i = paramInt;
      if (this.DNO != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DNO);
      }
      paramInt = i;
      if (this.DNP != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DNP);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.md5);
      }
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.dlB);
      }
      i = paramInt + f.a.a.b.b.a.bA(19, this.aTB) + f.a.a.b.b.a.bA(20, this.dia);
      paramInt = i;
      if (this.DNl != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DNl);
      }
      i = paramInt;
      if (this.DNQ != null) {
        i = paramInt + f.a.a.a.kW(22, this.DNQ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(23, this.DNR);
      AppMethodBeat.o(125748);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DNM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125748);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bpl localbpl = (bpl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125748);
        return -1;
      case 1: 
        localbpl.DNn = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 2: 
        localbpl.DNo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 3: 
        localbpl.DMS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpl.DNK = ((bpd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 5: 
        localbpl.DNL = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpl.DNM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 7: 
        localbpl.gll = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 8: 
        localbpl.DJF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 9: 
        localbpl.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 10: 
        localbpl.DNN = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 11: 
        localbpl.token = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 12: 
        localbpl.DNx = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 13: 
        localbpl.DNw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 14: 
        localbpl.videoPath = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 15: 
        localbpl.DNO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 16: 
        localbpl.DNP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 17: 
        localbpl.md5 = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 18: 
        localbpl.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 19: 
        localbpl.aTB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 20: 
        localbpl.dia = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125748);
        return 0;
      case 21: 
        localbpl.DNl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((boj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpl.DNQ = ((boj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      }
      localbpl.DNR = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(125748);
      return 0;
    }
    AppMethodBeat.o(125748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpl
 * JD-Core Version:    0.7.0.1
 */