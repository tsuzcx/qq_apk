package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ceg
  extends cvw
{
  public bb Ghz;
  public int Hra;
  public String Id;
  public String jfC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hra);
      if (this.Id != null) {
        paramVarArgs.d(3, this.Id);
      }
      if (this.jfC != null) {
        paramVarArgs.d(4, this.jfC);
      }
      if (this.Ghz != null)
      {
        paramVarArgs.lJ(5, this.Ghz.computeSize());
        this.Ghz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hra);
      paramInt = i;
      if (this.Id != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Id);
      }
      i = paramInt;
      if (this.jfC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.jfC);
      }
      paramInt = i;
      if (this.Ghz != null) {
        paramInt = i + f.a.a.a.lI(5, this.Ghz.computeSize());
      }
      AppMethodBeat.o(91556);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ceg localceg = (ceg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91556);
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
            localceg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91556);
          return 0;
        case 2: 
          localceg.Hra = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91556);
          return 0;
        case 3: 
          localceg.Id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91556);
          return 0;
        case 4: 
          localceg.jfC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91556);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localceg.Ghz = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91556);
        return 0;
      }
      AppMethodBeat.o(91556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceg
 * JD-Core Version:    0.7.0.1
 */