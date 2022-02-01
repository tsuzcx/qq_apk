package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdm
  extends cvw
{
  public String GKA;
  public String GKy;
  public String GKz;
  public String GSQ;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GKy != null) {
        paramVarArgs.d(2, this.GKy);
      }
      if (this.GSQ != null) {
        paramVarArgs.d(3, this.GSQ);
      }
      if (this.GKz != null) {
        paramVarArgs.d(4, this.GKz);
      }
      if (this.GKA != null) {
        paramVarArgs.d(5, this.GKA);
      }
      if (this.xrf != null) {
        paramVarArgs.d(6, this.xrf);
      }
      AppMethodBeat.o(91489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GKy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GKy);
      }
      i = paramInt;
      if (this.GSQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GSQ);
      }
      paramInt = i;
      if (this.GKz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GKz);
      }
      i = paramInt;
      if (this.GKA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GKA);
      }
      paramInt = i;
      if (this.xrf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.xrf);
      }
      AppMethodBeat.o(91489);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdm localbdm = (bdm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91489);
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
            localbdm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91489);
          return 0;
        case 2: 
          localbdm.GKy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 3: 
          localbdm.GSQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 4: 
          localbdm.GKz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 5: 
          localbdm.GKA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91489);
          return 0;
        }
        localbdm.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91489);
        return 0;
      }
      AppMethodBeat.o(91489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdm
 * JD-Core Version:    0.7.0.1
 */