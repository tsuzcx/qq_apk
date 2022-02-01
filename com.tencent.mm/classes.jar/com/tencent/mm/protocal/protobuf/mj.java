package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class mj
  extends cvw
{
  public int FTU;
  public mc FXB;
  public long FXP;
  public String FXQ;
  public String FXR;
  public ml FXT;
  public b FXp;
  public long FXv;
  public GoodsObject FXy;
  public int mode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188919);
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
      paramVarArgs.aS(12, this.mode);
      paramVarArgs.aZ(18, this.FXv);
      if (this.FXy != null)
      {
        paramVarArgs.lJ(21, this.FXy.computeSize());
        this.FXy.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(22, this.FTU);
      if (this.FXT != null)
      {
        paramVarArgs.lJ(23, this.FXT.computeSize());
        this.FXT.writeFields(paramVarArgs);
      }
      if (this.FXB != null)
      {
        paramVarArgs.lJ(26, this.FXB.computeSize());
        this.FXB.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(27, this.FXP);
      if (this.FXQ != null) {
        paramVarArgs.d(28, this.FXQ);
      }
      if (this.FXR != null) {
        paramVarArgs.d(29, this.FXR);
      }
      AppMethodBeat.o(188919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FXp != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FXp);
      }
      i = i + f.a.a.b.b.a.bz(12, this.mode) + f.a.a.b.b.a.p(18, this.FXv);
      paramInt = i;
      if (this.FXy != null) {
        paramInt = i + f.a.a.a.lI(21, this.FXy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.FTU);
      paramInt = i;
      if (this.FXT != null) {
        paramInt = i + f.a.a.a.lI(23, this.FXT.computeSize());
      }
      i = paramInt;
      if (this.FXB != null) {
        i = paramInt + f.a.a.a.lI(26, this.FXB.computeSize());
      }
      i += f.a.a.b.b.a.p(27, this.FXP);
      paramInt = i;
      if (this.FXQ != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.FXQ);
      }
      i = paramInt;
      if (this.FXR != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.FXR);
      }
      AppMethodBeat.o(188919);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mj localmj = (mj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188919);
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
            localmj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188919);
          return 0;
        case 2: 
          localmj.FXp = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(188919);
          return 0;
        case 12: 
          localmj.mode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188919);
          return 0;
        case 18: 
          localmj.FXv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(188919);
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
            localmj.FXy = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188919);
          return 0;
        case 22: 
          localmj.FTU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188919);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ml();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmj.FXT = ((ml)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188919);
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
            localmj.FXB = ((mc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188919);
          return 0;
        case 27: 
          localmj.FXP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(188919);
          return 0;
        case 28: 
          localmj.FXQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188919);
          return 0;
        }
        localmj.FXR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188919);
        return 0;
      }
      AppMethodBeat.o(188919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mj
 * JD-Core Version:    0.7.0.1
 */