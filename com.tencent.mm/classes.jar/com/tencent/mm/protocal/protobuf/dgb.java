package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgb
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public cty FOe;
  public String Gxp;
  public String HNh;
  public String HNi;
  public int HNj;
  public int HNk;
  public long HNl;
  public long HNm;
  public SKBuiltinBuffer_t HNn;
  public int HNo;
  public LinkedList<dgn> HNp;
  public int HNq;
  public String HzT;
  public int IsNotRichText;
  public String hFS;
  public int nJA;
  public int ucK;
  
  public dgb()
  {
    AppMethodBeat.i(125770);
    this.HNp = new LinkedList();
    AppMethodBeat.o(125770);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125771);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HzT != null) {
        paramVarArgs.d(1, this.HzT);
      }
      if (this.Gxp != null) {
        paramVarArgs.d(2, this.Gxp);
      }
      if (this.HNh != null) {
        paramVarArgs.d(3, this.HNh);
      }
      if (this.HNi != null) {
        paramVarArgs.d(4, this.HNi);
      }
      paramVarArgs.aS(5, this.nJA);
      paramVarArgs.aS(6, this.ucK);
      paramVarArgs.aS(7, this.CreateTime);
      if (this.hFS != null) {
        paramVarArgs.d(8, this.hFS);
      }
      paramVarArgs.aS(9, this.HNj);
      paramVarArgs.aS(10, this.HNk);
      paramVarArgs.aS(11, this.IsNotRichText);
      paramVarArgs.aZ(12, this.HNl);
      paramVarArgs.aZ(13, this.HNm);
      if (this.HNn != null)
      {
        paramVarArgs.lJ(14, this.HNn.computeSize());
        this.HNn.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.HNo);
      if (this.FOe != null)
      {
        paramVarArgs.lJ(16, this.FOe.computeSize());
        this.FOe.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.HNp);
      paramVarArgs.aS(18, this.HNq);
      AppMethodBeat.o(125771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HzT == null) {
        break label1362;
      }
    }
    label1362:
    for (int i = f.a.a.b.b.a.e(1, this.HzT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gxp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gxp);
      }
      i = paramInt;
      if (this.HNh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HNh);
      }
      paramInt = i;
      if (this.HNi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HNi);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.nJA) + f.a.a.b.b.a.bz(6, this.ucK) + f.a.a.b.b.a.bz(7, this.CreateTime);
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hFS);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.HNj) + f.a.a.b.b.a.bz(10, this.HNk) + f.a.a.b.b.a.bz(11, this.IsNotRichText) + f.a.a.b.b.a.p(12, this.HNl) + f.a.a.b.b.a.p(13, this.HNm);
      paramInt = i;
      if (this.HNn != null) {
        paramInt = i + f.a.a.a.lI(14, this.HNn.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.HNo);
      paramInt = i;
      if (this.FOe != null) {
        paramInt = i + f.a.a.a.lI(16, this.FOe.computeSize());
      }
      i = f.a.a.a.c(17, 8, this.HNp);
      int j = f.a.a.b.b.a.bz(18, this.HNq);
      AppMethodBeat.o(125771);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HNp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125771);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgb localdgb = (dgb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125771);
          return -1;
        case 1: 
          localdgb.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 2: 
          localdgb.Gxp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 3: 
          localdgb.HNh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 4: 
          localdgb.HNi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 5: 
          localdgb.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 6: 
          localdgb.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 7: 
          localdgb.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 8: 
          localdgb.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 9: 
          localdgb.HNj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 10: 
          localdgb.HNk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 11: 
          localdgb.IsNotRichText = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 12: 
          localdgb.HNl = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125771);
          return 0;
        case 13: 
          localdgb.HNm = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125771);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgb.HNn = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 15: 
          localdgb.HNo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cty();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgb.FOe = ((cty)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgb.HNp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        }
        localdgb.HNq = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125771);
        return 0;
      }
      AppMethodBeat.o(125771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgb
 * JD-Core Version:    0.7.0.1
 */