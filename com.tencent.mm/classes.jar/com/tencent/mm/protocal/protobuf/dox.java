package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dox
  extends com.tencent.mm.bw.a
{
  public LinkedList<aaj> DTg;
  public String HVO;
  public String HVP;
  public String HVQ;
  public String HVR;
  public long HVS;
  public dpa HVT;
  public dfc HVU;
  public boolean HVV;
  public LinkedList<dpa> HVW;
  public int HVX;
  public int HVY;
  public String HVZ;
  public int HWa;
  public boolean HWb;
  public String dmf;
  public boolean fOX;
  public String kid;
  public int offset;
  public String rfA;
  public int scene;
  
  public dox()
  {
    AppMethodBeat.i(153006);
    this.DTg = new LinkedList();
    this.HVW = new LinkedList();
    AppMethodBeat.o(153006);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153007);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HVO != null) {
        paramVarArgs.d(1, this.HVO);
      }
      if (this.HVP != null) {
        paramVarArgs.d(2, this.HVP);
      }
      if (this.HVQ != null) {
        paramVarArgs.d(3, this.HVQ);
      }
      if (this.HVR != null) {
        paramVarArgs.d(4, this.HVR);
      }
      paramVarArgs.aZ(5, this.HVS);
      paramVarArgs.aS(6, this.scene);
      if (this.kid != null) {
        paramVarArgs.d(7, this.kid);
      }
      if (this.dmf != null) {
        paramVarArgs.d(8, this.dmf);
      }
      if (this.HVT != null)
      {
        paramVarArgs.lJ(9, this.HVT.computeSize());
        this.HVT.writeFields(paramVarArgs);
      }
      if (this.HVU != null)
      {
        paramVarArgs.lJ(10, this.HVU.computeSize());
        this.HVU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.DTg);
      if (this.rfA != null) {
        paramVarArgs.d(12, this.rfA);
      }
      paramVarArgs.aS(13, this.offset);
      paramVarArgs.bC(14, this.HVV);
      paramVarArgs.e(15, 8, this.HVW);
      paramVarArgs.aS(16, this.HVX);
      paramVarArgs.aS(17, this.HVY);
      paramVarArgs.bC(18, this.fOX);
      if (this.HVZ != null) {
        paramVarArgs.d(19, this.HVZ);
      }
      paramVarArgs.aS(20, this.HWa);
      paramVarArgs.bC(21, this.HWb);
      AppMethodBeat.o(153007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HVO == null) {
        break label1630;
      }
    }
    label1630:
    for (int i = f.a.a.b.b.a.e(1, this.HVO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HVP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HVP);
      }
      i = paramInt;
      if (this.HVQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HVQ);
      }
      paramInt = i;
      if (this.HVR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HVR);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.HVS) + f.a.a.b.b.a.bz(6, this.scene);
      paramInt = i;
      if (this.kid != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.kid);
      }
      i = paramInt;
      if (this.dmf != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dmf);
      }
      paramInt = i;
      if (this.HVT != null) {
        paramInt = i + f.a.a.a.lI(9, this.HVT.computeSize());
      }
      i = paramInt;
      if (this.HVU != null) {
        i = paramInt + f.a.a.a.lI(10, this.HVU.computeSize());
      }
      i += f.a.a.a.c(11, 8, this.DTg);
      paramInt = i;
      if (this.rfA != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.rfA);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.offset) + f.a.a.b.b.a.amF(14) + f.a.a.a.c(15, 8, this.HVW) + f.a.a.b.b.a.bz(16, this.HVX) + f.a.a.b.b.a.bz(17, this.HVY) + f.a.a.b.b.a.amF(18);
      paramInt = i;
      if (this.HVZ != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.HVZ);
      }
      i = f.a.a.b.b.a.bz(20, this.HWa);
      int j = f.a.a.b.b.a.amF(21);
      AppMethodBeat.o(153007);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTg.clear();
        this.HVW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dox localdox = (dox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153007);
          return -1;
        case 1: 
          localdox.HVO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 2: 
          localdox.HVP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 3: 
          localdox.HVQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 4: 
          localdox.HVR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 5: 
          localdox.HVS = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153007);
          return 0;
        case 6: 
          localdox.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153007);
          return 0;
        case 7: 
          localdox.kid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 8: 
          localdox.dmf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdox.HVT = ((dpa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdox.HVU = ((dfc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdox.DTg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 12: 
          localdox.rfA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 13: 
          localdox.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153007);
          return 0;
        case 14: 
          localdox.HVV = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153007);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdox.HVW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 16: 
          localdox.HVX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153007);
          return 0;
        case 17: 
          localdox.HVY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153007);
          return 0;
        case 18: 
          localdox.fOX = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153007);
          return 0;
        case 19: 
          localdox.HVZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 20: 
          localdox.HWa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153007);
          return 0;
        }
        localdox.HWb = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(153007);
        return 0;
      }
      AppMethodBeat.o(153007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dox
 * JD-Core Version:    0.7.0.1
 */