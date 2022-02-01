package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class l
  extends com.tencent.mm.bx.a
{
  public String url;
  public String wML;
  public int wMM;
  public LinkedList<e> wMN;
  public int wMj;
  
  public l()
  {
    AppMethodBeat.i(91278);
    this.wMN = new LinkedList();
    AppMethodBeat.o(91278);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91279);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wML == null)
      {
        paramVarArgs = new b("Not all required fields were included: id_info");
        AppMethodBeat.o(91279);
        throw paramVarArgs;
      }
      if (this.wML != null) {
        paramVarArgs.d(1, this.wML);
      }
      paramVarArgs.aS(2, this.wMM);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.e(4, 8, this.wMN);
      paramVarArgs.aS(5, this.wMj);
      AppMethodBeat.o(91279);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wML == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.b.b.a.e(1, this.wML) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.wMM);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = f.a.a.a.c(4, 8, this.wMN);
      int j = f.a.a.b.b.a.bz(5, this.wMj);
      AppMethodBeat.o(91279);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wMN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.wML == null)
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
          locall.wML = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 2: 
          locall.wMM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91279);
          return 0;
        case 3: 
          locall.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locall.wMN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91279);
          return 0;
        }
        locall.wMj = ((f.a.a.a.a)localObject1).NPN.zc();
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