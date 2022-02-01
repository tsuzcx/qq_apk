package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class l
  extends com.tencent.mm.bw.a
{
  public String url;
  public String vFF;
  public int vFG;
  public LinkedList<e> vFH;
  public int vFd;
  
  public l()
  {
    AppMethodBeat.i(91278);
    this.vFH = new LinkedList();
    AppMethodBeat.o(91278);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91279);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: id_info");
        AppMethodBeat.o(91279);
        throw paramVarArgs;
      }
      if (this.vFF != null) {
        paramVarArgs.d(1, this.vFF);
      }
      paramVarArgs.aR(2, this.vFG);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.e(4, 8, this.vFH);
      paramVarArgs.aR(5, this.vFd);
      AppMethodBeat.o(91279);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vFF == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.b.b.a.e(1, this.vFF) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vFG);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = f.a.a.a.c(4, 8, this.vFH);
      int j = f.a.a.b.b.a.bx(5, this.vFd);
      AppMethodBeat.o(91279);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vFH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vFF == null)
        {
          paramVarArgs = new b("Not all required fields were included: id_info");
          AppMethodBeat.o(91279);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91279);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91279);
          return -1;
        case 1: 
          locall.vFF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 2: 
          locall.vFG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91279);
          return 0;
        case 3: 
          locall.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locall.vFH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91279);
          return 0;
        }
        locall.vFd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91279);
        return 0;
      }
      AppMethodBeat.o(91279);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.l
 * JD-Core Version:    0.7.0.1
 */