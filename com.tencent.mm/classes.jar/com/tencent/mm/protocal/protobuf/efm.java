package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efm
  extends com.tencent.mm.cd.a
{
  public boolean Aaj;
  public String SYa;
  public long SYb;
  public LinkedList<efi> UiM;
  public int index;
  public int type;
  public String wmA;
  
  public efm()
  {
    AppMethodBeat.i(169384);
    this.UiM = new LinkedList();
    this.Aaj = false;
    this.type = 0;
    this.index = -1;
    AppMethodBeat.o(169384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169385);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wmA != null) {
        paramVarArgs.f(1, this.wmA);
      }
      paramVarArgs.bm(2, this.SYb);
      paramVarArgs.e(3, 8, this.UiM);
      if (this.SYa != null) {
        paramVarArgs.f(4, this.SYa);
      }
      paramVarArgs.co(5, this.Aaj);
      paramVarArgs.aY(6, this.type);
      paramVarArgs.aY(7, this.index);
      AppMethodBeat.o(169385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmA == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = g.a.a.b.b.a.g(1, this.wmA) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SYb) + g.a.a.a.c(3, 8, this.UiM);
      paramInt = i;
      if (this.SYa != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SYa);
      }
      i = g.a.a.b.b.a.gL(5);
      int j = g.a.a.b.b.a.bM(6, this.type);
      int k = g.a.a.b.b.a.bM(7, this.index);
      AppMethodBeat.o(169385);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UiM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        efm localefm = (efm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169385);
          return -1;
        case 1: 
          localefm.wmA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 2: 
          localefm.SYb = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(169385);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            efi localefi = new efi();
            if ((localObject != null) && (localObject.length > 0)) {
              localefi.parseFrom((byte[])localObject);
            }
            localefm.UiM.add(localefi);
            paramInt += 1;
          }
          AppMethodBeat.o(169385);
          return 0;
        case 4: 
          localefm.SYa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 5: 
          localefm.Aaj = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(169385);
          return 0;
        case 6: 
          localefm.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169385);
          return 0;
        }
        localefm.index = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169385);
        return 0;
      }
      AppMethodBeat.o(169385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efm
 * JD-Core Version:    0.7.0.1
 */