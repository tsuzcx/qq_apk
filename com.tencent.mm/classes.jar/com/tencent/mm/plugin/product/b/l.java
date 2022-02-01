package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class l
  extends com.tencent.mm.bx.a
{
  public String MRC;
  public int MRD;
  public LinkedList<e> MRE;
  public int MRb;
  public String url;
  
  public l()
  {
    AppMethodBeat.i(91278);
    this.MRE = new LinkedList();
    AppMethodBeat.o(91278);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91279);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MRC == null)
      {
        paramVarArgs = new b("Not all required fields were included: id_info");
        AppMethodBeat.o(91279);
        throw paramVarArgs;
      }
      if (this.MRC != null) {
        paramVarArgs.g(1, this.MRC);
      }
      paramVarArgs.bS(2, this.MRD);
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      paramVarArgs.e(4, 8, this.MRE);
      paramVarArgs.bS(5, this.MRb);
      AppMethodBeat.o(91279);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRC == null) {
        break label532;
      }
    }
    label532:
    for (paramInt = i.a.a.b.b.a.h(1, this.MRC) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.MRD);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.url);
      }
      i = i.a.a.a.c(4, 8, this.MRE);
      int j = i.a.a.b.b.a.cJ(5, this.MRb);
      AppMethodBeat.o(91279);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MRE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.MRC == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91279);
          return -1;
        case 1: 
          locall.MRC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 2: 
          locall.MRD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91279);
          return 0;
        case 3: 
          locall.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            e locale = new e();
            if ((localObject != null) && (localObject.length > 0)) {
              locale.parseFrom((byte[])localObject);
            }
            locall.MRE.add(locale);
            paramInt += 1;
          }
          AppMethodBeat.o(91279);
          return 0;
        }
        locall.MRb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91279);
        return 0;
      }
      AppMethodBeat.o(91279);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.l
 * JD-Core Version:    0.7.0.1
 */