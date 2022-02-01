package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqg
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Ewb;
  public String FDA;
  public int FDx;
  public int FDy;
  public LinkedList<cyx> FDz;
  public int FileSize;
  public String MD5;
  public String Url;
  
  public cqg()
  {
    AppMethodBeat.i(152670);
    this.FDz = new LinkedList();
    AppMethodBeat.o(152670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.MD5 == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: MD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Url");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.FDA == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: OriginalMD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aR(2, this.FDx);
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aR(4, this.FDy);
      paramVarArgs.e(5, 8, this.FDz);
      if (this.Ewb != null) {
        paramVarArgs.c(6, this.Ewb);
      }
      if (this.FDA != null) {
        paramVarArgs.d(7, this.FDA);
      }
      paramVarArgs.aR(8, this.FileSize);
      AppMethodBeat.o(152671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FDx);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.FDy) + f.a.a.a.c(5, 8, this.FDz);
      paramInt = i;
      if (this.Ewb != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.Ewb);
      }
      i = paramInt;
      if (this.FDA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FDA);
      }
      paramInt = f.a.a.b.b.a.bx(8, this.FileSize);
      AppMethodBeat.o(152671);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FDz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: MD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Url");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.FDA == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: OriginalMD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqg localcqg = (cqg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152671);
          return -1;
        case 1: 
          localcqg.MD5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 2: 
          localcqg.FDx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152671);
          return 0;
        case 3: 
          localcqg.Url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 4: 
          localcqg.FDy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152671);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cyx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqg.FDz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152671);
          return 0;
        case 6: 
          localcqg.Ewb = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(152671);
          return 0;
        case 7: 
          localcqg.FDA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152671);
          return 0;
        }
        localcqg.FileSize = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152671);
        return 0;
      }
      AppMethodBeat.o(152671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqg
 * JD-Core Version:    0.7.0.1
 */