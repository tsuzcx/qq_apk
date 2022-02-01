package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cyo
  extends cvw
{
  public String HIE;
  public String HIF;
  public b HIG;
  public String HIL;
  public String HIM;
  public String dwb;
  public String scope;
  public String state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      if (this.scope != null) {
        paramVarArgs.d(3, this.scope);
      }
      if (this.state != null) {
        paramVarArgs.d(4, this.state);
      }
      if (this.HIE != null) {
        paramVarArgs.d(5, this.HIE);
      }
      if (this.HIL != null) {
        paramVarArgs.d(6, this.HIL);
      }
      if (this.HIM != null) {
        paramVarArgs.d(7, this.HIM);
      }
      if (this.HIF != null) {
        paramVarArgs.d(13, this.HIF);
      }
      if (this.HIG != null) {
        paramVarArgs.c(14, this.HIG);
      }
      AppMethodBeat.o(82473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.scope);
      }
      paramInt = i;
      if (this.state != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.state);
      }
      i = paramInt;
      if (this.HIE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HIE);
      }
      paramInt = i;
      if (this.HIL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HIL);
      }
      i = paramInt;
      if (this.HIM != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HIM);
      }
      paramInt = i;
      if (this.HIF != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HIF);
      }
      i = paramInt;
      if (this.HIG != null) {
        i = paramInt + f.a.a.b.b.a.b(14, this.HIG);
      }
      AppMethodBeat.o(82473);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyo localcyo = (cyo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(82473);
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
            localcyo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82473);
          return 0;
        case 2: 
          localcyo.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 3: 
          localcyo.scope = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 4: 
          localcyo.state = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 5: 
          localcyo.HIE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 6: 
          localcyo.HIL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 7: 
          localcyo.HIM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 13: 
          localcyo.HIF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82473);
          return 0;
        }
        localcyo.HIG = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(82473);
        return 0;
      }
      AppMethodBeat.o(82473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyo
 * JD-Core Version:    0.7.0.1
 */