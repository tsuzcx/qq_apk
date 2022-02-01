package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzi
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int IsNotRichText;
  public dmo KHJ;
  public String LsY;
  public String MKC;
  public String MYQ;
  public String MYR;
  public int MYS;
  public int MYT;
  public long MYU;
  public long MYV;
  public SKBuiltinBuffer_t MYW;
  public int MYX;
  public LinkedList<dzu> MYY;
  public int MYZ;
  public String iAc;
  public int oUv;
  public int xub;
  
  public dzi()
  {
    AppMethodBeat.i(125770);
    this.MYY = new LinkedList();
    AppMethodBeat.o(125770);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125771);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MKC != null) {
        paramVarArgs.e(1, this.MKC);
      }
      if (this.LsY != null) {
        paramVarArgs.e(2, this.LsY);
      }
      if (this.MYQ != null) {
        paramVarArgs.e(3, this.MYQ);
      }
      if (this.MYR != null) {
        paramVarArgs.e(4, this.MYR);
      }
      paramVarArgs.aM(5, this.oUv);
      paramVarArgs.aM(6, this.xub);
      paramVarArgs.aM(7, this.CreateTime);
      if (this.iAc != null) {
        paramVarArgs.e(8, this.iAc);
      }
      paramVarArgs.aM(9, this.MYS);
      paramVarArgs.aM(10, this.MYT);
      paramVarArgs.aM(11, this.IsNotRichText);
      paramVarArgs.bb(12, this.MYU);
      paramVarArgs.bb(13, this.MYV);
      if (this.MYW != null)
      {
        paramVarArgs.ni(14, this.MYW.computeSize());
        this.MYW.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(15, this.MYX);
      if (this.KHJ != null)
      {
        paramVarArgs.ni(16, this.KHJ.computeSize());
        this.KHJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.MYY);
      paramVarArgs.aM(18, this.MYZ);
      AppMethodBeat.o(125771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MKC == null) {
        break label1362;
      }
    }
    label1362:
    for (int i = g.a.a.b.b.a.f(1, this.MKC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LsY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LsY);
      }
      i = paramInt;
      if (this.MYQ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MYQ);
      }
      paramInt = i;
      if (this.MYR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MYR);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.oUv) + g.a.a.b.b.a.bu(6, this.xub) + g.a.a.b.b.a.bu(7, this.CreateTime);
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.iAc);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.MYS) + g.a.a.b.b.a.bu(10, this.MYT) + g.a.a.b.b.a.bu(11, this.IsNotRichText) + g.a.a.b.b.a.r(12, this.MYU) + g.a.a.b.b.a.r(13, this.MYV);
      paramInt = i;
      if (this.MYW != null) {
        paramInt = i + g.a.a.a.nh(14, this.MYW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.MYX);
      paramInt = i;
      if (this.KHJ != null) {
        paramInt = i + g.a.a.a.nh(16, this.KHJ.computeSize());
      }
      i = g.a.a.a.c(17, 8, this.MYY);
      int j = g.a.a.b.b.a.bu(18, this.MYZ);
      AppMethodBeat.o(125771);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MYY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125771);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzi localdzi = (dzi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125771);
          return -1;
        case 1: 
          localdzi.MKC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 2: 
          localdzi.LsY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 3: 
          localdzi.MYQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 4: 
          localdzi.MYR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 5: 
          localdzi.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125771);
          return 0;
        case 6: 
          localdzi.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125771);
          return 0;
        case 7: 
          localdzi.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125771);
          return 0;
        case 8: 
          localdzi.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 9: 
          localdzi.MYS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125771);
          return 0;
        case 10: 
          localdzi.MYT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125771);
          return 0;
        case 11: 
          localdzi.IsNotRichText = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125771);
          return 0;
        case 12: 
          localdzi.MYU = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125771);
          return 0;
        case 13: 
          localdzi.MYV = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125771);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzi.MYW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 15: 
          localdzi.MYX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125771);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzi.KHJ = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzi.MYY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        }
        localdzi.MYZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125771);
        return 0;
      }
      AppMethodBeat.o(125771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzi
 * JD-Core Version:    0.7.0.1
 */