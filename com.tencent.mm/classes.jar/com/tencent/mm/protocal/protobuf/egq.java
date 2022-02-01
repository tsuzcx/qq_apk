package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class egq
  extends com.tencent.mm.bw.a
{
  public int IkA;
  public egt IkB;
  public int Ikz;
  public String Md5;
  public String ucL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110857);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.ucL == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.ucL != null) {
        paramVarArgs.d(2, this.ucL);
      }
      paramVarArgs.aS(3, this.Ikz);
      paramVarArgs.aS(4, this.IkA);
      if (this.IkB != null)
      {
        paramVarArgs.lJ(5, this.IkB.computeSize());
        this.IkB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ucL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ucL);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Ikz) + f.a.a.b.b.a.bz(4, this.IkA);
      paramInt = i;
      if (this.IkB != null) {
        paramInt = i + f.a.a.a.lI(5, this.IkB.computeSize());
      }
      AppMethodBeat.o(110857);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        if (this.ucL == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        egq localegq = (egq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110857);
          return -1;
        case 1: 
          localegq.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 2: 
          localegq.ucL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 3: 
          localegq.Ikz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(110857);
          return 0;
        case 4: 
          localegq.IkA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(110857);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((egt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegq.IkB = ((egt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      AppMethodBeat.o(110857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egq
 * JD-Core Version:    0.7.0.1
 */