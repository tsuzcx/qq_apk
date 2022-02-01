package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcy
  extends com.tencent.mm.bx.a
{
  public LinkedList<xp> AFX;
  public ctk EuA;
  public boolean EuB;
  public LinkedList<ddb> EuC;
  public int EuD;
  public int EuE;
  public String EuF;
  public int EuG;
  public boolean EuH;
  public String Euu;
  public String Euv;
  public String Euw;
  public String Eux;
  public long Euy;
  public ddb Euz;
  public String dcm;
  public boolean fqj;
  public String jko;
  public int offset;
  public String qwV;
  public int scene;
  
  public dcy()
  {
    AppMethodBeat.i(153006);
    this.AFX = new LinkedList();
    this.EuC = new LinkedList();
    AppMethodBeat.o(153006);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153007);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Euu != null) {
        paramVarArgs.d(1, this.Euu);
      }
      if (this.Euv != null) {
        paramVarArgs.d(2, this.Euv);
      }
      if (this.Euw != null) {
        paramVarArgs.d(3, this.Euw);
      }
      if (this.Eux != null) {
        paramVarArgs.d(4, this.Eux);
      }
      paramVarArgs.aG(5, this.Euy);
      paramVarArgs.aR(6, this.scene);
      if (this.jko != null) {
        paramVarArgs.d(7, this.jko);
      }
      if (this.dcm != null) {
        paramVarArgs.d(8, this.dcm);
      }
      if (this.Euz != null)
      {
        paramVarArgs.kX(9, this.Euz.computeSize());
        this.Euz.writeFields(paramVarArgs);
      }
      if (this.EuA != null)
      {
        paramVarArgs.kX(10, this.EuA.computeSize());
        this.EuA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.AFX);
      if (this.qwV != null) {
        paramVarArgs.d(12, this.qwV);
      }
      paramVarArgs.aR(13, this.offset);
      paramVarArgs.bg(14, this.EuB);
      paramVarArgs.e(15, 8, this.EuC);
      paramVarArgs.aR(16, this.EuD);
      paramVarArgs.aR(17, this.EuE);
      paramVarArgs.bg(18, this.fqj);
      if (this.EuF != null) {
        paramVarArgs.d(19, this.EuF);
      }
      paramVarArgs.aR(20, this.EuG);
      paramVarArgs.bg(21, this.EuH);
      AppMethodBeat.o(153007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Euu == null) {
        break label1638;
      }
    }
    label1638:
    for (int i = f.a.a.b.b.a.e(1, this.Euu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Euv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Euv);
      }
      i = paramInt;
      if (this.Euw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Euw);
      }
      paramInt = i;
      if (this.Eux != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eux);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.Euy) + f.a.a.b.b.a.bA(6, this.scene);
      paramInt = i;
      if (this.jko != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.jko);
      }
      i = paramInt;
      if (this.dcm != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dcm);
      }
      paramInt = i;
      if (this.Euz != null) {
        paramInt = i + f.a.a.a.kW(9, this.Euz.computeSize());
      }
      i = paramInt;
      if (this.EuA != null) {
        i = paramInt + f.a.a.a.kW(10, this.EuA.computeSize());
      }
      i += f.a.a.a.c(11, 8, this.AFX);
      paramInt = i;
      if (this.qwV != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.qwV);
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.offset) + (f.a.a.b.b.a.fY(14) + 1) + f.a.a.a.c(15, 8, this.EuC) + f.a.a.b.b.a.bA(16, this.EuD) + f.a.a.b.b.a.bA(17, this.EuE) + (f.a.a.b.b.a.fY(18) + 1);
      paramInt = i;
      if (this.EuF != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.EuF);
      }
      i = f.a.a.b.b.a.bA(20, this.EuG);
      int j = f.a.a.b.b.a.fY(21);
      AppMethodBeat.o(153007);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.AFX.clear();
        this.EuC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcy localdcy = (dcy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153007);
          return -1;
        case 1: 
          localdcy.Euu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 2: 
          localdcy.Euv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 3: 
          localdcy.Euw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 4: 
          localdcy.Eux = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 5: 
          localdcy.Euy = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153007);
          return 0;
        case 6: 
          localdcy.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153007);
          return 0;
        case 7: 
          localdcy.jko = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 8: 
          localdcy.dcm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcy.Euz = ((ddb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcy.EuA = ((ctk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcy.AFX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 12: 
          localdcy.qwV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 13: 
          localdcy.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153007);
          return 0;
        case 14: 
          localdcy.EuB = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153007);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcy.EuC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 16: 
          localdcy.EuD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153007);
          return 0;
        case 17: 
          localdcy.EuE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153007);
          return 0;
        case 18: 
          localdcy.fqj = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153007);
          return 0;
        case 19: 
          localdcy.EuF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 20: 
          localdcy.EuG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153007);
          return 0;
        }
        localdcy.EuH = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(153007);
        return 0;
      }
      AppMethodBeat.o(153007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcy
 * JD-Core Version:    0.7.0.1
 */