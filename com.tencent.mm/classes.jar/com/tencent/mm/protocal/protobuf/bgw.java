package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgw
  extends cvw
{
  public String FJg;
  public String dnO;
  public String dqk;
  public String txG;
  public String txH;
  public String txI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dnO != null) {
        paramVarArgs.d(2, this.dnO);
      }
      if (this.txG != null) {
        paramVarArgs.d(3, this.txG);
      }
      if (this.txH != null) {
        paramVarArgs.d(4, this.txH);
      }
      if (this.txI != null) {
        paramVarArgs.d(5, this.txI);
      }
      if (this.dqk != null) {
        paramVarArgs.d(6, this.dqk);
      }
      if (this.FJg != null) {
        paramVarArgs.d(7, this.FJg);
      }
      AppMethodBeat.o(32262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label687;
      }
    }
    label687:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dnO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dnO);
      }
      i = paramInt;
      if (this.txG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.txG);
      }
      paramInt = i;
      if (this.txH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.txH);
      }
      i = paramInt;
      if (this.txI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.txI);
      }
      paramInt = i;
      if (this.dqk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dqk);
      }
      i = paramInt;
      if (this.FJg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FJg);
      }
      AppMethodBeat.o(32262);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgw localbgw = (bgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32262);
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
            localbgw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32262);
          return 0;
        case 2: 
          localbgw.dnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 3: 
          localbgw.txG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 4: 
          localbgw.txH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 5: 
          localbgw.txI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 6: 
          localbgw.dqk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32262);
          return 0;
        }
        localbgw.FJg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32262);
        return 0;
      }
      AppMethodBeat.o(32262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgw
 * JD-Core Version:    0.7.0.1
 */