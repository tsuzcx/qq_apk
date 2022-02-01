package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gkx
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b YRt;
  public LinkedList<gku> YRu;
  public String aaLU;
  
  public gkx()
  {
    AppMethodBeat.i(123701);
    this.YRu = new LinkedList();
    AppMethodBeat.o(123701);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123702);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaLU == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(123702);
        throw paramVarArgs;
      }
      if (this.aaLU != null) {
        paramVarArgs.g(1, this.aaLU);
      }
      if (this.YRt != null) {
        paramVarArgs.d(2, this.YRt);
      }
      paramVarArgs.e(3, 8, this.YRu);
      AppMethodBeat.o(123702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaLU == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaLU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YRt != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YRt);
      }
      paramInt = i.a.a.a.c(3, 8, this.YRu);
      AppMethodBeat.o(123702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YRu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaLU == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(123702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gkx localgkx = (gkx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123702);
          return -1;
        case 1: 
          localgkx.aaLU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123702);
          return 0;
        case 2: 
          localgkx.YRt = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(123702);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gku localgku = new gku();
          if ((localObject != null) && (localObject.length > 0)) {
            localgku.parseFrom((byte[])localObject);
          }
          localgkx.YRu.add(localgku);
          paramInt += 1;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      AppMethodBeat.o(123702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkx
 * JD-Core Version:    0.7.0.1
 */