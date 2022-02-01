package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhx
  extends cvw
{
  public int ExtFlag;
  public String FNF;
  public SKBuiltinBuffer_t FTj;
  public int GqB;
  public int HPh;
  public int HPi;
  public int HPj;
  public int HmG;
  public int HmH;
  public dqz HxX;
  public String MD5;
  public String hFO;
  public String ikm;
  public int nJA;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125830);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FTj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125830);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nJA);
      paramVarArgs.aS(3, this.xsC);
      paramVarArgs.aS(17, this.HPh);
      paramVarArgs.aS(4, this.xsB);
      if (this.FTj != null)
      {
        paramVarArgs.lJ(5, this.FTj.computeSize());
        this.FTj.writeFields(paramVarArgs);
      }
      if (this.hFO != null) {
        paramVarArgs.d(6, this.hFO);
      }
      paramVarArgs.aS(7, this.HmG);
      paramVarArgs.aS(8, this.HmH);
      if (this.FNF != null) {
        paramVarArgs.d(9, this.FNF);
      }
      paramVarArgs.aS(10, this.HPi);
      paramVarArgs.aS(11, this.GqB);
      if (this.HxX != null)
      {
        paramVarArgs.lJ(12, this.HxX.computeSize());
        this.HxX.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(13, this.ikm);
      }
      paramVarArgs.aS(14, this.ExtFlag);
      if (this.MD5 != null) {
        paramVarArgs.d(15, this.MD5);
      }
      paramVarArgs.aS(16, this.HPj);
      AppMethodBeat.o(125830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA) + f.a.a.b.b.a.bz(3, this.xsC) + f.a.a.b.b.a.bz(17, this.HPh) + f.a.a.b.b.a.bz(4, this.xsB);
      paramInt = i;
      if (this.FTj != null) {
        paramInt = i + f.a.a.a.lI(5, this.FTj.computeSize());
      }
      i = paramInt;
      if (this.hFO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hFO);
      }
      i = i + f.a.a.b.b.a.bz(7, this.HmG) + f.a.a.b.b.a.bz(8, this.HmH);
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FNF);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.HPi) + f.a.a.b.b.a.bz(11, this.GqB);
      paramInt = i;
      if (this.HxX != null) {
        paramInt = i + f.a.a.a.lI(12, this.HxX.computeSize());
      }
      i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ikm);
      }
      i += f.a.a.b.b.a.bz(14, this.ExtFlag);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.MD5);
      }
      i = f.a.a.b.b.a.bz(16, this.HPj);
      AppMethodBeat.o(125830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FTj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125830);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhx localdhx = (dhx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125830);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 2: 
          localdhx.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 3: 
          localdhx.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 17: 
          localdhx.HPh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 4: 
          localdhx.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhx.FTj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 6: 
          localdhx.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 7: 
          localdhx.HmG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 8: 
          localdhx.HmH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 9: 
          localdhx.FNF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 10: 
          localdhx.HPi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 11: 
          localdhx.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhx.HxX = ((dqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 13: 
          localdhx.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 14: 
          localdhx.ExtFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 15: 
          localdhx.MD5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125830);
          return 0;
        }
        localdhx.HPj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125830);
        return 0;
      }
      AppMethodBeat.o(125830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhx
 * JD-Core Version:    0.7.0.1
 */