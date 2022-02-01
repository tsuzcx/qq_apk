package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cex
  extends dyl
{
  public boolean Tmw;
  public String Tmx;
  public String lmG;
  public String vpp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32281);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vpp == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32281);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.Tmw);
      if (this.lmG != null) {
        paramVarArgs.f(3, this.lmG);
      }
      if (this.vpp != null) {
        paramVarArgs.f(4, this.vpp);
      }
      if (this.Tmx != null) {
        paramVarArgs.f(5, this.Tmx);
      }
      AppMethodBeat.o(32281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label571;
      }
    }
    label571:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.lmG != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.lmG);
      }
      i = paramInt;
      if (this.vpp != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.vpp);
      }
      paramInt = i;
      if (this.Tmx != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tmx);
      }
      AppMethodBeat.o(32281);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.vpp == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32281);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cex localcex = (cex)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32281);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localcex.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32281);
          return 0;
        case 2: 
          localcex.Tmw = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(32281);
          return 0;
        case 3: 
          localcex.lmG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32281);
          return 0;
        case 4: 
          localcex.vpp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32281);
          return 0;
        }
        localcex.Tmx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32281);
        return 0;
      }
      AppMethodBeat.o(32281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cex
 * JD-Core Version:    0.7.0.1
 */