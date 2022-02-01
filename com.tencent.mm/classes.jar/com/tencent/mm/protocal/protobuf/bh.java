package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bh
  extends com.tencent.mm.bx.a
{
  public dcm CvH;
  public String CvI = "";
  public String CvJ = "";
  public String CvK = "";
  public long CvL = 0L;
  public int flags = -1;
  public int state = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CvH != null)
      {
        paramVarArgs.kX(1, this.CvH.computeSize());
        this.CvH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.flags);
      paramVarArgs.aR(3, this.state);
      if (this.CvI != null) {
        paramVarArgs.d(4, this.CvI);
      }
      if (this.CvJ != null) {
        paramVarArgs.d(5, this.CvJ);
      }
      if (this.CvK != null) {
        paramVarArgs.d(6, this.CvK);
      }
      paramVarArgs.aG(7, this.CvL);
      AppMethodBeat.o(122482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CvH == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.kW(1, this.CvH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.flags) + f.a.a.b.b.a.bA(3, this.state);
      paramInt = i;
      if (this.CvI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CvI);
      }
      i = paramInt;
      if (this.CvJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CvJ);
      }
      paramInt = i;
      if (this.CvK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CvK);
      }
      i = f.a.a.b.b.a.q(7, this.CvL);
      AppMethodBeat.o(122482);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122482);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.CvH = ((dcm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122482);
          return 0;
        case 2: 
          localbh.flags = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122482);
          return 0;
        case 3: 
          localbh.state = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122482);
          return 0;
        case 4: 
          localbh.CvI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 5: 
          localbh.CvJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 6: 
          localbh.CvK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122482);
          return 0;
        }
        localbh.CvL = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(122482);
        return 0;
      }
      AppMethodBeat.o(122482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bh
 * JD-Core Version:    0.7.0.1
 */