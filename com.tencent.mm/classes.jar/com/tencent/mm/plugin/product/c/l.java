package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class l
  extends com.tencent.mm.cd.a
{
  public String GTZ;
  public int GTx;
  public int GUa;
  public LinkedList<e> GUb;
  public String url;
  
  public l()
  {
    AppMethodBeat.i(91278);
    this.GUb = new LinkedList();
    AppMethodBeat.o(91278);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91279);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GTZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: id_info");
        AppMethodBeat.o(91279);
        throw paramVarArgs;
      }
      if (this.GTZ != null) {
        paramVarArgs.f(1, this.GTZ);
      }
      paramVarArgs.aY(2, this.GUa);
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      paramVarArgs.e(4, 8, this.GUb);
      paramVarArgs.aY(5, this.GTx);
      AppMethodBeat.o(91279);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GTZ == null) {
        break label532;
      }
    }
    label532:
    for (paramInt = g.a.a.b.b.a.g(1, this.GTZ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.GUa);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.url);
      }
      i = g.a.a.a.c(4, 8, this.GUb);
      int j = g.a.a.b.b.a.bM(5, this.GTx);
      AppMethodBeat.o(91279);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GUb.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.GTZ == null)
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91279);
          return -1;
        case 1: 
          locall.GTZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 2: 
          locall.GUa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91279);
          return 0;
        case 3: 
          locall.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            e locale = new e();
            if ((localObject != null) && (localObject.length > 0)) {
              locale.parseFrom((byte[])localObject);
            }
            locall.GUb.add(locale);
            paramInt += 1;
          }
          AppMethodBeat.o(91279);
          return 0;
        }
        locall.GTx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91279);
        return 0;
      }
      AppMethodBeat.o(91279);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.l
 * JD-Core Version:    0.7.0.1
 */