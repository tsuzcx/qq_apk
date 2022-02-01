package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public String MRF;
  public String MRG;
  public LinkedList<h> MRH;
  
  public m()
  {
    AppMethodBeat.i(91280);
    this.MRH = new LinkedList();
    AppMethodBeat.o(91280);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91281);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MRF != null) {
        paramVarArgs.g(1, this.MRF);
      }
      if (this.MRG != null) {
        paramVarArgs.g(2, this.MRG);
      }
      paramVarArgs.e(3, 8, this.MRH);
      AppMethodBeat.o(91281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRF == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.MRF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MRG != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.MRG);
      }
      paramInt = i.a.a.a.c(3, 8, this.MRH);
      AppMethodBeat.o(91281);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MRH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91281);
          return -1;
        case 1: 
          localm.MRF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91281);
          return 0;
        case 2: 
          localm.MRG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91281);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          h localh = new h();
          if ((localObject != null) && (localObject.length > 0)) {
            localh.parseFrom((byte[])localObject);
          }
          localm.MRH.add(localh);
          paramInt += 1;
        }
        AppMethodBeat.o(91281);
        return 0;
      }
      AppMethodBeat.o(91281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.m
 * JD-Core Version:    0.7.0.1
 */