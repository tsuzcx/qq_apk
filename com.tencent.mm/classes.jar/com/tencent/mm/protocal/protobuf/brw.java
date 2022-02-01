package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brw
  extends cvw
{
  public LinkedList<String> HeP;
  public int HeQ;
  public int HeR;
  public eio HeS;
  public int Hfa;
  public String Hfb;
  public String ikm;
  
  public brw()
  {
    AppMethodBeat.i(123611);
    this.HeP = new LinkedList();
    AppMethodBeat.o(123611);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      paramVarArgs.e(3, 1, this.HeP);
      paramVarArgs.aS(4, this.Hfa);
      if (this.Hfb != null) {
        paramVarArgs.d(6, this.Hfb);
      }
      paramVarArgs.aS(7, this.HeQ);
      paramVarArgs.aS(8, this.HeR);
      if (this.HeS != null)
      {
        paramVarArgs.lJ(9, this.HeS.computeSize());
        this.HeS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = i + f.a.a.a.c(3, 1, this.HeP) + f.a.a.b.b.a.bz(4, this.Hfa);
      paramInt = i;
      if (this.Hfb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hfb);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HeQ) + f.a.a.b.b.a.bz(8, this.HeR);
      paramInt = i;
      if (this.HeS != null) {
        paramInt = i + f.a.a.a.lI(9, this.HeS.computeSize());
      }
      AppMethodBeat.o(123612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HeP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brw localbrw = (brw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(123612);
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
            localbrw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123612);
          return 0;
        case 2: 
          localbrw.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123612);
          return 0;
        case 3: 
          localbrw.HeP.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(123612);
          return 0;
        case 4: 
          localbrw.Hfa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123612);
          return 0;
        case 6: 
          localbrw.Hfb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123612);
          return 0;
        case 7: 
          localbrw.HeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123612);
          return 0;
        case 8: 
          localbrw.HeR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123612);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eio();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrw.HeS = ((eio)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123612);
        return 0;
      }
      AppMethodBeat.o(123612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brw
 * JD-Core Version:    0.7.0.1
 */