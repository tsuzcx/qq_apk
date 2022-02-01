package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqn
  extends cvw
{
  public String FIw;
  public String FOg;
  public String HWV;
  public String HWW;
  public String HXn;
  public String HXv;
  public int vxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FIw != null) {
        paramVarArgs.d(2, this.FIw);
      }
      if (this.FOg != null) {
        paramVarArgs.d(3, this.FOg);
      }
      if (this.HWV != null) {
        paramVarArgs.d(4, this.HWV);
      }
      if (this.HWW != null) {
        paramVarArgs.d(5, this.HWW);
      }
      paramVarArgs.aS(6, this.vxx);
      if (this.HXn != null) {
        paramVarArgs.d(7, this.HXn);
      }
      if (this.HXv != null) {
        paramVarArgs.d(8, this.HXv);
      }
      AppMethodBeat.o(72609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FIw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FIw);
      }
      i = paramInt;
      if (this.FOg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOg);
      }
      paramInt = i;
      if (this.HWV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HWV);
      }
      i = paramInt;
      if (this.HWW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HWW);
      }
      i += f.a.a.b.b.a.bz(6, this.vxx);
      paramInt = i;
      if (this.HXn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HXn);
      }
      i = paramInt;
      if (this.HXv != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HXv);
      }
      AppMethodBeat.o(72609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72609);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqn localdqn = (dqn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72609);
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
            localdqn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72609);
          return 0;
        case 2: 
          localdqn.FIw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 3: 
          localdqn.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 4: 
          localdqn.HWV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 5: 
          localdqn.HWW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 6: 
          localdqn.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72609);
          return 0;
        case 7: 
          localdqn.HXn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72609);
          return 0;
        }
        localdqn.HXv = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72609);
        return 0;
      }
      AppMethodBeat.o(72609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqn
 * JD-Core Version:    0.7.0.1
 */