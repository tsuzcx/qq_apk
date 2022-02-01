package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyy
  extends com.tencent.mm.bw.a
{
  public String EDk;
  public String EDm;
  public dyx Gfe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110858);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EDk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.EDm == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.Gfe == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.EDk != null) {
        paramVarArgs.d(1, this.EDk);
      }
      if (this.EDm != null) {
        paramVarArgs.d(2, this.EDm);
      }
      if (this.Gfe != null)
      {
        paramVarArgs.ln(3, this.Gfe.computeSize());
        this.Gfe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EDk == null) {
        break label574;
      }
    }
    label574:
    for (int i = f.a.a.b.b.a.e(1, this.EDk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EDm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EDm);
      }
      i = paramInt;
      if (this.Gfe != null) {
        i = paramInt + f.a.a.a.lm(3, this.Gfe.computeSize());
      }
      AppMethodBeat.o(110858);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EDk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.EDm == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.Gfe == null)
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
        dyy localdyy = (dyy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110858);
          return -1;
        case 1: 
          localdyy.EDk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110858);
          return 0;
        case 2: 
          localdyy.EDm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110858);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dyx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyy.Gfe = ((dyx)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyy
 * JD-Core Version:    0.7.0.1
 */