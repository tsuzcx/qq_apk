package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class egr
  extends com.tencent.mm.bw.a
{
  public String GDE;
  public String GDG;
  public egq Iks;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110858);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GDE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.GDG == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.Iks == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.GDE != null) {
        paramVarArgs.d(1, this.GDE);
      }
      if (this.GDG != null) {
        paramVarArgs.d(2, this.GDG);
      }
      if (this.Iks != null)
      {
        paramVarArgs.lJ(3, this.Iks.computeSize());
        this.Iks.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GDE == null) {
        break label574;
      }
    }
    label574:
    for (int i = f.a.a.b.b.a.e(1, this.GDE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GDG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GDG);
      }
      i = paramInt;
      if (this.Iks != null) {
        i = paramInt + f.a.a.a.lI(3, this.Iks.computeSize());
      }
      AppMethodBeat.o(110858);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GDE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.GDG == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.Iks == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        egr localegr = (egr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110858);
          return -1;
        case 1: 
          localegr.GDE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110858);
          return 0;
        case 2: 
          localegr.GDG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110858);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((egq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegr.Iks = ((egq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110858);
        return 0;
      }
      AppMethodBeat.o(110858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egr
 * JD-Core Version:    0.7.0.1
 */