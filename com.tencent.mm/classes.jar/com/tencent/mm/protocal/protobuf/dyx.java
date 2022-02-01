package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyx
  extends com.tencent.mm.bw.a
{
  public int Gfl;
  public int Gfm;
  public dza Gfn;
  public String Md5;
  public String sVp;
  
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
      if (this.sVp == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.sVp != null) {
        paramVarArgs.d(2, this.sVp);
      }
      paramVarArgs.aR(3, this.Gfl);
      paramVarArgs.aR(4, this.Gfm);
      if (this.Gfn != null)
      {
        paramVarArgs.ln(5, this.Gfn.computeSize());
        this.Gfn.writeFields(paramVarArgs);
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
      if (this.sVp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sVp);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Gfl) + f.a.a.b.b.a.bx(4, this.Gfm);
      paramInt = i;
      if (this.Gfn != null) {
        paramInt = i + f.a.a.a.lm(5, this.Gfn.computeSize());
      }
      AppMethodBeat.o(110857);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        if (this.sVp == null)
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
        dyx localdyx = (dyx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110857);
          return -1;
        case 1: 
          localdyx.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 2: 
          localdyx.sVp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 3: 
          localdyx.Gfl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(110857);
          return 0;
        case 4: 
          localdyx.Gfm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(110857);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dza();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyx.Gfn = ((dza)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyx
 * JD-Core Version:    0.7.0.1
 */