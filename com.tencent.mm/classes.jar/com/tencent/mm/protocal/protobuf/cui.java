package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cui
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public ciu CxV;
  public String DZr;
  public String DdY;
  public String ElX;
  public String ElY;
  public int ElZ;
  public int Ema;
  public long Emb;
  public long Emc;
  public SKBuiltinBuffer_t Emd;
  public int Eme;
  public LinkedList<cuu> Emf;
  public int Emg;
  public int IsNotRichText;
  public String gKr;
  public int mBH;
  public int rNz;
  
  public cui()
  {
    AppMethodBeat.i(125770);
    this.Emf = new LinkedList();
    AppMethodBeat.o(125770);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125771);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DZr != null) {
        paramVarArgs.d(1, this.DZr);
      }
      if (this.DdY != null) {
        paramVarArgs.d(2, this.DdY);
      }
      if (this.ElX != null) {
        paramVarArgs.d(3, this.ElX);
      }
      if (this.ElY != null) {
        paramVarArgs.d(4, this.ElY);
      }
      paramVarArgs.aR(5, this.mBH);
      paramVarArgs.aR(6, this.rNz);
      paramVarArgs.aR(7, this.CreateTime);
      if (this.gKr != null) {
        paramVarArgs.d(8, this.gKr);
      }
      paramVarArgs.aR(9, this.ElZ);
      paramVarArgs.aR(10, this.Ema);
      paramVarArgs.aR(11, this.IsNotRichText);
      paramVarArgs.aG(12, this.Emb);
      paramVarArgs.aG(13, this.Emc);
      if (this.Emd != null)
      {
        paramVarArgs.kX(14, this.Emd.computeSize());
        this.Emd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(15, this.Eme);
      if (this.CxV != null)
      {
        paramVarArgs.kX(16, this.CxV.computeSize());
        this.CxV.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.Emf);
      paramVarArgs.aR(18, this.Emg);
      AppMethodBeat.o(125771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DZr == null) {
        break label1362;
      }
    }
    label1362:
    for (int i = f.a.a.b.b.a.e(1, this.DZr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DdY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DdY);
      }
      i = paramInt;
      if (this.ElX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ElX);
      }
      paramInt = i;
      if (this.ElY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ElY);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.mBH) + f.a.a.b.b.a.bA(6, this.rNz) + f.a.a.b.b.a.bA(7, this.CreateTime);
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gKr);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.ElZ) + f.a.a.b.b.a.bA(10, this.Ema) + f.a.a.b.b.a.bA(11, this.IsNotRichText) + f.a.a.b.b.a.q(12, this.Emb) + f.a.a.b.b.a.q(13, this.Emc);
      paramInt = i;
      if (this.Emd != null) {
        paramInt = i + f.a.a.a.kW(14, this.Emd.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(15, this.Eme);
      paramInt = i;
      if (this.CxV != null) {
        paramInt = i + f.a.a.a.kW(16, this.CxV.computeSize());
      }
      i = f.a.a.a.c(17, 8, this.Emf);
      int j = f.a.a.b.b.a.bA(18, this.Emg);
      AppMethodBeat.o(125771);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Emf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125771);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cui localcui = (cui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125771);
          return -1;
        case 1: 
          localcui.DZr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 2: 
          localcui.DdY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 3: 
          localcui.ElX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 4: 
          localcui.ElY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 5: 
          localcui.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125771);
          return 0;
        case 6: 
          localcui.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125771);
          return 0;
        case 7: 
          localcui.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125771);
          return 0;
        case 8: 
          localcui.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 9: 
          localcui.ElZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125771);
          return 0;
        case 10: 
          localcui.Ema = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125771);
          return 0;
        case 11: 
          localcui.IsNotRichText = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125771);
          return 0;
        case 12: 
          localcui.Emb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125771);
          return 0;
        case 13: 
          localcui.Emc = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125771);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcui.Emd = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 15: 
          localcui.Eme = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125771);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcui.CxV = ((ciu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cuu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcui.Emf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        }
        localcui.Emg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125771);
        return 0;
      }
      AppMethodBeat.o(125771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cui
 * JD-Core Version:    0.7.0.1
 */