package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azf
  extends cld
{
  public boolean DxA;
  public String DxB;
  public long DxC;
  public boolean DxD;
  public boolean DxE;
  public boolean DxF;
  public String DxG;
  public String DxH;
  public String DxI;
  public String DxJ;
  public boolean DxK;
  public LinkedList<String> DxL;
  public bju DxM;
  public boolean DxN;
  public boolean DxO;
  public boolean DxP;
  public LinkedList<cgy> DxQ;
  public boolean DxR;
  public String Dxv;
  public String Dxw;
  public String Dxx;
  public String Dxy;
  public String Dxz;
  public int dcG;
  public String nTK;
  public boolean zWb;
  public String zYO;
  public String zYP;
  
  public azf()
  {
    AppMethodBeat.i(91509);
    this.DxL = new LinkedList();
    this.DxQ = new LinkedList();
    AppMethodBeat.o(91509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.Dxv != null) {
        paramVarArgs.d(4, this.Dxv);
      }
      if (this.Dxw != null) {
        paramVarArgs.d(5, this.Dxw);
      }
      if (this.Dxx != null) {
        paramVarArgs.d(6, this.Dxx);
      }
      if (this.Dxy != null) {
        paramVarArgs.d(7, this.Dxy);
      }
      if (this.Dxz != null) {
        paramVarArgs.d(8, this.Dxz);
      }
      paramVarArgs.bg(9, this.DxA);
      if (this.DxB != null) {
        paramVarArgs.d(10, this.DxB);
      }
      paramVarArgs.aG(11, this.DxC);
      paramVarArgs.bg(12, this.DxD);
      paramVarArgs.bg(13, this.DxE);
      paramVarArgs.bg(14, this.DxF);
      if (this.DxG != null) {
        paramVarArgs.d(15, this.DxG);
      }
      if (this.DxH != null) {
        paramVarArgs.d(16, this.DxH);
      }
      if (this.DxI != null) {
        paramVarArgs.d(17, this.DxI);
      }
      if (this.DxJ != null) {
        paramVarArgs.d(18, this.DxJ);
      }
      paramVarArgs.bg(19, this.DxK);
      paramVarArgs.e(20, 1, this.DxL);
      paramVarArgs.bg(21, this.zWb);
      if (this.DxM != null)
      {
        paramVarArgs.kX(22, this.DxM.computeSize());
        this.DxM.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(23, this.DxN);
      paramVarArgs.bg(26, this.DxO);
      paramVarArgs.bg(27, this.DxP);
      paramVarArgs.e(28, 8, this.DxQ);
      if (this.zYO != null) {
        paramVarArgs.d(29, this.zYO);
      }
      if (this.zYP != null) {
        paramVarArgs.d(30, this.zYP);
      }
      paramVarArgs.bg(31, this.DxR);
      AppMethodBeat.o(91510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2038;
      }
    }
    label2038:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.Dxv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Dxv);
      }
      paramInt = i;
      if (this.Dxw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Dxw);
      }
      i = paramInt;
      if (this.Dxx != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Dxx);
      }
      paramInt = i;
      if (this.Dxy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dxy);
      }
      i = paramInt;
      if (this.Dxz != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Dxz);
      }
      i += f.a.a.b.b.a.fY(9) + 1;
      paramInt = i;
      if (this.DxB != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DxB);
      }
      i = paramInt + f.a.a.b.b.a.q(11, this.DxC) + (f.a.a.b.b.a.fY(12) + 1) + (f.a.a.b.b.a.fY(13) + 1) + (f.a.a.b.b.a.fY(14) + 1);
      paramInt = i;
      if (this.DxG != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DxG);
      }
      i = paramInt;
      if (this.DxH != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.DxH);
      }
      paramInt = i;
      if (this.DxI != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DxI);
      }
      i = paramInt;
      if (this.DxJ != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.DxJ);
      }
      i = i + (f.a.a.b.b.a.fY(19) + 1) + f.a.a.a.c(20, 1, this.DxL) + (f.a.a.b.b.a.fY(21) + 1);
      paramInt = i;
      if (this.DxM != null) {
        paramInt = i + f.a.a.a.kW(22, this.DxM.computeSize());
      }
      i = paramInt + (f.a.a.b.b.a.fY(23) + 1) + (f.a.a.b.b.a.fY(26) + 1) + (f.a.a.b.b.a.fY(27) + 1) + f.a.a.a.c(28, 8, this.DxQ);
      paramInt = i;
      if (this.zYO != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.zYO);
      }
      i = paramInt;
      if (this.zYP != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.zYP);
      }
      paramInt = f.a.a.b.b.a.fY(31);
      AppMethodBeat.o(91510);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DxL.clear();
        this.DxQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azf localazf = (azf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(91510);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 2: 
          localazf.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91510);
          return 0;
        case 3: 
          localazf.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 4: 
          localazf.Dxv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 5: 
          localazf.Dxw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 6: 
          localazf.Dxx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 7: 
          localazf.Dxy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 8: 
          localazf.Dxz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 9: 
          localazf.DxA = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 10: 
          localazf.DxB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 11: 
          localazf.DxC = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91510);
          return 0;
        case 12: 
          localazf.DxD = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 13: 
          localazf.DxE = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 14: 
          localazf.DxF = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 15: 
          localazf.DxG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 16: 
          localazf.DxH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 17: 
          localazf.DxI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 18: 
          localazf.DxJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 19: 
          localazf.DxK = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 20: 
          localazf.DxL.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91510);
          return 0;
        case 21: 
          localazf.zWb = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bju();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bju)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazf.DxM = ((bju)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 23: 
          localazf.DxN = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 26: 
          localazf.DxO = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 27: 
          localazf.DxP = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91510);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazf.DxQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 29: 
          localazf.zYO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 30: 
          localazf.zYP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91510);
          return 0;
        }
        localazf.DxR = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(91510);
        return 0;
      }
      AppMethodBeat.o(91510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azf
 * JD-Core Version:    0.7.0.1
 */