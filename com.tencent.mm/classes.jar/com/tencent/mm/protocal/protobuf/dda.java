package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dda
  extends com.tencent.mm.bx.a
{
  public LinkedList<xp> AFX;
  public ctk EuA;
  public boolean EuH;
  public LinkedList<ddb> EuL;
  public String Euu;
  public String Euv;
  public String Euw;
  public String Eux;
  public long Euy;
  public String dcm;
  public int offset;
  public String qwV;
  public int scene;
  
  public dda()
  {
    AppMethodBeat.i(153010);
    this.EuL = new LinkedList();
    this.AFX = new LinkedList();
    AppMethodBeat.o(153010);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153011);
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
      if (this.EuA != null)
      {
        paramVarArgs.kX(5, this.EuA.computeSize());
        this.EuA.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.Euy);
      if (this.qwV != null) {
        paramVarArgs.d(7, this.qwV);
      }
      paramVarArgs.aR(8, this.offset);
      paramVarArgs.bg(9, this.EuH);
      paramVarArgs.aR(10, this.scene);
      if (this.dcm != null) {
        paramVarArgs.d(11, this.dcm);
      }
      paramVarArgs.e(12, 8, this.EuL);
      paramVarArgs.e(13, 8, this.AFX);
      AppMethodBeat.o(153011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Euu == null) {
        break label1138;
      }
    }
    label1138:
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
      i = paramInt;
      if (this.EuA != null) {
        i = paramInt + f.a.a.a.kW(5, this.EuA.computeSize());
      }
      i += f.a.a.b.b.a.q(6, this.Euy);
      paramInt = i;
      if (this.qwV != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.qwV);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.offset) + (f.a.a.b.b.a.fY(9) + 1) + f.a.a.b.b.a.bA(10, this.scene);
      paramInt = i;
      if (this.dcm != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dcm);
      }
      i = f.a.a.a.c(12, 8, this.EuL);
      int j = f.a.a.a.c(13, 8, this.AFX);
      AppMethodBeat.o(153011);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EuL.clear();
        this.AFX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dda localdda = (dda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153011);
          return -1;
        case 1: 
          localdda.Euu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 2: 
          localdda.Euv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 3: 
          localdda.Euw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 4: 
          localdda.Eux = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdda.EuA = ((ctk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        case 6: 
          localdda.Euy = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153011);
          return 0;
        case 7: 
          localdda.qwV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 8: 
          localdda.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153011);
          return 0;
        case 9: 
          localdda.EuH = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153011);
          return 0;
        case 10: 
          localdda.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153011);
          return 0;
        case 11: 
          localdda.dcm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdda.EuL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdda.AFX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      AppMethodBeat.o(153011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dda
 * JD-Core Version:    0.7.0.1
 */