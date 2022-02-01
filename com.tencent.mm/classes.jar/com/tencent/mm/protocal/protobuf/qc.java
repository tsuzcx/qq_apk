package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qc
  extends cvw
{
  public String GdL;
  public int GdM;
  public int channel;
  public String iWC;
  public int vxx;
  public int yns;
  public String ynt;
  public String ynu;
  public String yoQ;
  public String yoT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91370);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.vxx);
      paramVarArgs.aS(3, this.channel);
      paramVarArgs.aS(4, this.yns);
      if (this.GdL != null) {
        paramVarArgs.d(5, this.GdL);
      }
      if (this.yoQ != null) {
        paramVarArgs.d(6, this.yoQ);
      }
      if (this.ynt != null) {
        paramVarArgs.d(7, this.ynt);
      }
      if (this.yoT != null) {
        paramVarArgs.d(8, this.yoT);
      }
      if (this.iWC != null) {
        paramVarArgs.d(9, this.iWC);
      }
      if (this.ynu != null) {
        paramVarArgs.d(10, this.ynu);
      }
      paramVarArgs.aS(11, this.GdM);
      AppMethodBeat.o(91370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.vxx) + f.a.a.b.b.a.bz(3, this.channel) + f.a.a.b.b.a.bz(4, this.yns);
      paramInt = i;
      if (this.GdL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GdL);
      }
      i = paramInt;
      if (this.yoQ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.yoQ);
      }
      paramInt = i;
      if (this.ynt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ynt);
      }
      i = paramInt;
      if (this.yoT != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.yoT);
      }
      paramInt = i;
      if (this.iWC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iWC);
      }
      i = paramInt;
      if (this.ynu != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.ynu);
      }
      paramInt = f.a.a.b.b.a.bz(11, this.GdM);
      AppMethodBeat.o(91370);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qc localqc = (qc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91370);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91370);
          return 0;
        case 2: 
          localqc.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91370);
          return 0;
        case 3: 
          localqc.channel = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91370);
          return 0;
        case 4: 
          localqc.yns = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91370);
          return 0;
        case 5: 
          localqc.GdL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 6: 
          localqc.yoQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 7: 
          localqc.ynt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 8: 
          localqc.yoT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 9: 
          localqc.iWC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 10: 
          localqc.ynu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91370);
          return 0;
        }
        localqc.GdM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91370);
        return 0;
      }
      AppMethodBeat.o(91370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qc
 * JD-Core Version:    0.7.0.1
 */