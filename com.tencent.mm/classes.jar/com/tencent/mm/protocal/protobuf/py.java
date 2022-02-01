package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class py
  extends cvw
{
  public String FOf;
  public String FOg;
  public String FOh;
  public int FOj;
  public b GdB;
  public String yoT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91365);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FOf != null) {
        paramVarArgs.d(2, this.FOf);
      }
      if (this.FOg != null) {
        paramVarArgs.d(3, this.FOg);
      }
      if (this.yoT != null) {
        paramVarArgs.d(4, this.yoT);
      }
      paramVarArgs.aS(5, this.FOj);
      if (this.GdB != null) {
        paramVarArgs.c(6, this.GdB);
      }
      if (this.FOh != null) {
        paramVarArgs.d(7, this.FOh);
      }
      AppMethodBeat.o(91365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FOf);
      }
      i = paramInt;
      if (this.FOg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOg);
      }
      paramInt = i;
      if (this.yoT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.yoT);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FOj);
      paramInt = i;
      if (this.GdB != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.GdB);
      }
      i = paramInt;
      if (this.FOh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FOh);
      }
      AppMethodBeat.o(91365);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        py localpy = (py)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91365);
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
            localpy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91365);
          return 0;
        case 2: 
          localpy.FOf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 3: 
          localpy.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 4: 
          localpy.yoT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 5: 
          localpy.FOj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91365);
          return 0;
        case 6: 
          localpy.GdB = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91365);
          return 0;
        }
        localpy.FOh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91365);
        return 0;
      }
      AppMethodBeat.o(91365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.py
 * JD-Core Version:    0.7.0.1
 */