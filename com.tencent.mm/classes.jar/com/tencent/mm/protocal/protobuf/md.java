package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class md
  extends cvw
{
  public int FXA;
  public mc FXB;
  public ma FXC;
  public mb FXD;
  public long FXE;
  public b FXp;
  public String FXq;
  public String FXr;
  public String FXs;
  public int FXt;
  public int FXu;
  public long FXv;
  public boolean FXw;
  public boolean FXx;
  public GoodsObject FXy;
  public int FXz;
  public int mode;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FXp != null) {
        paramVarArgs.c(2, this.FXp);
      }
      paramVarArgs.aS(11, this.type);
      paramVarArgs.aS(12, this.mode);
      if (this.FXq != null) {
        paramVarArgs.d(13, this.FXq);
      }
      if (this.FXr != null) {
        paramVarArgs.d(14, this.FXr);
      }
      if (this.FXs != null) {
        paramVarArgs.d(15, this.FXs);
      }
      paramVarArgs.aS(16, this.FXt);
      paramVarArgs.aS(17, this.FXu);
      paramVarArgs.aZ(18, this.FXv);
      paramVarArgs.bC(19, this.FXw);
      paramVarArgs.bC(20, this.FXx);
      if (this.FXy != null)
      {
        paramVarArgs.lJ(21, this.FXy.computeSize());
        this.FXy.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(22, this.FXz);
      paramVarArgs.aS(23, this.FXA);
      if (this.FXB != null)
      {
        paramVarArgs.lJ(26, this.FXB.computeSize());
        this.FXB.writeFields(paramVarArgs);
      }
      if (this.FXC != null)
      {
        paramVarArgs.lJ(31, this.FXC.computeSize());
        this.FXC.writeFields(paramVarArgs);
      }
      if (this.FXD != null)
      {
        paramVarArgs.lJ(32, this.FXD.computeSize());
        this.FXD.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(50, this.FXE);
      AppMethodBeat.o(124394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1694;
      }
    }
    label1694:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FXp != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FXp);
      }
      i = i + f.a.a.b.b.a.bz(11, this.type) + f.a.a.b.b.a.bz(12, this.mode);
      paramInt = i;
      if (this.FXq != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FXq);
      }
      i = paramInt;
      if (this.FXr != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FXr);
      }
      paramInt = i;
      if (this.FXs != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FXs);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FXt) + f.a.a.b.b.a.bz(17, this.FXu) + f.a.a.b.b.a.p(18, this.FXv) + f.a.a.b.b.a.amF(19) + f.a.a.b.b.a.amF(20);
      paramInt = i;
      if (this.FXy != null) {
        paramInt = i + f.a.a.a.lI(21, this.FXy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.FXz) + f.a.a.b.b.a.bz(23, this.FXA);
      paramInt = i;
      if (this.FXB != null) {
        paramInt = i + f.a.a.a.lI(26, this.FXB.computeSize());
      }
      i = paramInt;
      if (this.FXC != null) {
        i = paramInt + f.a.a.a.lI(31, this.FXC.computeSize());
      }
      paramInt = i;
      if (this.FXD != null) {
        paramInt = i + f.a.a.a.lI(32, this.FXD.computeSize());
      }
      i = f.a.a.b.b.a.p(50, this.FXE);
      AppMethodBeat.o(124394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        md localmd = (md)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124394);
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
            localmd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 2: 
          localmd.FXp = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(124394);
          return 0;
        case 11: 
          localmd.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 12: 
          localmd.mode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 13: 
          localmd.FXq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 14: 
          localmd.FXr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 15: 
          localmd.FXs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 16: 
          localmd.FXt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 17: 
          localmd.FXu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 18: 
          localmd.FXv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124394);
          return 0;
        case 19: 
          localmd.FXw = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(124394);
          return 0;
        case 20: 
          localmd.FXx = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(124394);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmd.FXy = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 22: 
          localmd.FXz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 23: 
          localmd.FXA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmd.FXB = ((mc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ma();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ma)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmd.FXC = ((ma)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmd.FXD = ((mb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        }
        localmd.FXE = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(124394);
        return 0;
      }
      AppMethodBeat.o(124394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.md
 * JD-Core Version:    0.7.0.1
 */