package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwf
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public com.tencent.mm.bw.b Gwe;
  public int HHk;
  public int HHl;
  public LinkedList<dfe> HHm;
  public String HHn;
  public String MD5;
  public String Url;
  
  public cwf()
  {
    AppMethodBeat.i(152670);
    this.HHm = new LinkedList();
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
      if (this.HHn == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: OriginalMD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aS(2, this.HHk);
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aS(4, this.HHl);
      paramVarArgs.e(5, 8, this.HHm);
      if (this.Gwe != null) {
        paramVarArgs.c(6, this.Gwe);
      }
      if (this.HHn != null) {
        paramVarArgs.d(7, this.HHn);
      }
      paramVarArgs.aS(8, this.FileSize);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HHk);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HHl) + f.a.a.a.c(5, 8, this.HHm);
      paramInt = i;
      if (this.Gwe != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.Gwe);
      }
      i = paramInt;
      if (this.HHn != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HHn);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.FileSize);
      AppMethodBeat.o(152671);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HHm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        if (this.HHn == null)
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
        cwf localcwf = (cwf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152671);
          return -1;
        case 1: 
          localcwf.MD5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 2: 
          localcwf.HHk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152671);
          return 0;
        case 3: 
          localcwf.Url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 4: 
          localcwf.HHl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152671);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dfe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwf.HHm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152671);
          return 0;
        case 6: 
          localcwf.Gwe = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(152671);
          return 0;
        case 7: 
          localcwf.HHn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152671);
          return 0;
        }
        localcwf.FileSize = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152671);
        return 0;
      }
      AppMethodBeat.o(152671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwf
 * JD-Core Version:    0.7.0.1
 */