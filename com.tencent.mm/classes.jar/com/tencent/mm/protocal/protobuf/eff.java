package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eff
  extends com.tencent.mm.cd.a
{
  public LinkedList<efe> UiE;
  public String Uiw;
  public String fFe;
  public String wmA;
  
  public eff()
  {
    AppMethodBeat.i(122532);
    this.UiE = new LinkedList();
    AppMethodBeat.o(122532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122533);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wmA != null) {
        paramVarArgs.f(1, this.wmA);
      }
      if (this.Uiw != null) {
        paramVarArgs.f(2, this.Uiw);
      }
      if (this.fFe != null) {
        paramVarArgs.f(3, this.fFe);
      }
      paramVarArgs.e(4, 8, this.UiE);
      AppMethodBeat.o(122533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmA == null) {
        break label456;
      }
    }
    label456:
    for (int i = g.a.a.b.b.a.g(1, this.wmA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Uiw != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uiw);
      }
      i = paramInt;
      if (this.fFe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fFe);
      }
      paramInt = g.a.a.a.c(4, 8, this.UiE);
      AppMethodBeat.o(122533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UiE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eff localeff = (eff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122533);
          return -1;
        case 1: 
          localeff.wmA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 2: 
          localeff.Uiw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 3: 
          localeff.fFe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122533);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          efe localefe = new efe();
          if ((localObject != null) && (localObject.length > 0)) {
            localefe.parseFrom((byte[])localObject);
          }
          localeff.UiE.add(localefe);
          paramInt += 1;
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      AppMethodBeat.o(122533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eff
 * JD-Core Version:    0.7.0.1
 */