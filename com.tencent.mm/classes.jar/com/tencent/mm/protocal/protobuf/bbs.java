package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbs
  extends cvw
{
  public String GRH;
  public String pqK;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.scene);
      if (this.pqK != null) {
        paramVarArgs.d(3, this.pqK);
      }
      if (this.GRH != null) {
        paramVarArgs.d(4, this.GRH);
      }
      AppMethodBeat.o(104369);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.scene);
      paramInt = i;
      if (this.pqK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pqK);
      }
      i = paramInt;
      if (this.GRH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GRH);
      }
      AppMethodBeat.o(104369);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104369);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbs localbbs = (bbs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104369);
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
            localbbs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104369);
          return 0;
        case 2: 
          localbbs.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104369);
          return 0;
        case 3: 
          localbbs.pqK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104369);
          return 0;
        }
        localbbs.GRH = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(104369);
        return 0;
      }
      AppMethodBeat.o(104369);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbs
 * JD-Core Version:    0.7.0.1
 */