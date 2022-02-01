package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efi
  extends com.tencent.mm.cd.a
{
  public LinkedList<dhw> UiG;
  public LinkedList<fbp> UiH;
  public String fFe;
  
  public efi()
  {
    AppMethodBeat.i(122536);
    this.fFe = "";
    this.UiG = new LinkedList();
    this.UiH = new LinkedList();
    AppMethodBeat.o(122536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122537);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fFe != null) {
        paramVarArgs.f(1, this.fFe);
      }
      paramVarArgs.e(2, 8, this.UiG);
      paramVarArgs.e(3, 8, this.UiH);
      AppMethodBeat.o(122537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fFe == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = g.a.a.b.b.a.g(1, this.fFe) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.UiG);
      int j = g.a.a.a.c(3, 8, this.UiH);
      AppMethodBeat.o(122537);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UiG.clear();
        this.UiH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        efi localefi = (efi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122537);
          return -1;
        case 1: 
          localefi.fFe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(122537);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhw)localObject2).parseFrom((byte[])localObject1);
            }
            localefi.UiG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122537);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fbp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fbp)localObject2).parseFrom((byte[])localObject1);
          }
          localefi.UiH.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      AppMethodBeat.o(122537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efi
 * JD-Core Version:    0.7.0.1
 */