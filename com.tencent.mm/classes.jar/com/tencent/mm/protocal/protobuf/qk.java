package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qk
  extends buy
{
  public String cwk;
  public int okH;
  public String wIJ;
  public String wIK;
  public String wIM;
  public String wpq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48797);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwk != null) {
        paramVarArgs.e(2, this.cwk);
      }
      if (this.wIM != null) {
        paramVarArgs.e(3, this.wIM);
      }
      if (this.wpq != null) {
        paramVarArgs.e(4, this.wpq);
      }
      paramVarArgs.aO(5, this.okH);
      if (this.wIK != null) {
        paramVarArgs.e(6, this.wIK);
      }
      if (this.wIJ != null) {
        paramVarArgs.e(7, this.wIJ);
      }
      AppMethodBeat.o(48797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cwk != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwk);
      }
      i = paramInt;
      if (this.wIM != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wIM);
      }
      paramInt = i;
      if (this.wpq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wpq);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.okH);
      paramInt = i;
      if (this.wIK != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wIK);
      }
      i = paramInt;
      if (this.wIJ != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wIJ);
      }
      AppMethodBeat.o(48797);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48797);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qk localqk = (qk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48797);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localqk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48797);
          return 0;
        case 2: 
          localqk.cwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48797);
          return 0;
        case 3: 
          localqk.wIM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48797);
          return 0;
        case 4: 
          localqk.wpq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48797);
          return 0;
        case 5: 
          localqk.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48797);
          return 0;
        case 6: 
          localqk.wIK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48797);
          return 0;
        }
        localqk.wIJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48797);
        return 0;
      }
      AppMethodBeat.o(48797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qk
 * JD-Core Version:    0.7.0.1
 */