package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fll
  extends com.tencent.mm.cd.a
{
  public LinkedList<aci> Pye;
  public String fIY;
  public String fwe;
  public String jQi;
  public int scene;
  public String sessionId;
  public String url;
  
  public fll()
  {
    AppMethodBeat.i(222299);
    this.Pye = new LinkedList();
    AppMethodBeat.o(222299);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222323);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jQi != null) {
        paramVarArgs.f(1, this.jQi);
      }
      if (this.sessionId != null) {
        paramVarArgs.f(2, this.sessionId);
      }
      paramVarArgs.aY(3, this.scene);
      if (this.url != null) {
        paramVarArgs.f(4, this.url);
      }
      if (this.fIY != null) {
        paramVarArgs.f(5, this.fIY);
      }
      if (this.fwe != null) {
        paramVarArgs.f(6, this.fwe);
      }
      paramVarArgs.e(7, 8, this.Pye);
      AppMethodBeat.o(222323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jQi == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = g.a.a.b.b.a.g(1, this.jQi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.sessionId);
      }
      i += g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.url);
      }
      i = paramInt;
      if (this.fIY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fIY);
      }
      paramInt = i;
      if (this.fwe != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fwe);
      }
      i = g.a.a.a.c(7, 8, this.Pye);
      AppMethodBeat.o(222323);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Pye.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(222323);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fll localfll = (fll)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(222323);
          return -1;
        case 1: 
          localfll.jQi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222323);
          return 0;
        case 2: 
          localfll.sessionId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222323);
          return 0;
        case 3: 
          localfll.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(222323);
          return 0;
        case 4: 
          localfll.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222323);
          return 0;
        case 5: 
          localfll.fIY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222323);
          return 0;
        case 6: 
          localfll.fwe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222323);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aci localaci = new aci();
          if ((localObject != null) && (localObject.length > 0)) {
            localaci.parseFrom((byte[])localObject);
          }
          localfll.Pye.add(localaci);
          paramInt += 1;
        }
        AppMethodBeat.o(222323);
        return 0;
      }
      AppMethodBeat.o(222323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fll
 * JD-Core Version:    0.7.0.1
 */