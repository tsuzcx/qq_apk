package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class clg
  extends com.tencent.mm.bw.a
{
  public egs Hxw;
  public egv Hxx;
  public ego Hxy;
  public String urm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110851);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urm == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110851);
        throw paramVarArgs;
      }
      if (this.urm != null) {
        paramVarArgs.d(1, this.urm);
      }
      if (this.Hxw != null)
      {
        paramVarArgs.lJ(2, this.Hxw.computeSize());
        this.Hxw.writeFields(paramVarArgs);
      }
      if (this.Hxx != null)
      {
        paramVarArgs.lJ(3, this.Hxx.computeSize());
        this.Hxx.writeFields(paramVarArgs);
      }
      if (this.Hxy != null)
      {
        paramVarArgs.lJ(4, this.Hxy.computeSize());
        this.Hxy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110851);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urm == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.b.b.a.e(1, this.urm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hxw != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hxw.computeSize());
      }
      i = paramInt;
      if (this.Hxx != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hxx.computeSize());
      }
      paramInt = i;
      if (this.Hxy != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hxy.computeSize());
      }
      AppMethodBeat.o(110851);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.urm == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110851);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clg localclg = (clg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110851);
          return -1;
        case 1: 
          localclg.urm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110851);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclg.Hxw = ((egs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclg.Hxx = ((egv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ego();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ego)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclg.Hxy = ((ego)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      AppMethodBeat.o(110851);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clg
 * JD-Core Version:    0.7.0.1
 */