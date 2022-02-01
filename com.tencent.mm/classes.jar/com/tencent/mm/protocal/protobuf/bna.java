package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bna
  extends com.tencent.mm.bx.a
{
  public int BeA;
  public LinkedList<bmz> YBg;
  public LinkedList<String> ZVM;
  public int ZVN;
  public int Zpm;
  public b Zpn;
  public String icon_url;
  public String name;
  public int type;
  
  public bna()
  {
    AppMethodBeat.i(258798);
    this.YBg = new LinkedList();
    this.ZVM = new LinkedList();
    AppMethodBeat.o(258798);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258801);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zpm);
      paramVarArgs.bS(2, this.type);
      if (this.name != null) {
        paramVarArgs.g(3, this.name);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(4, this.icon_url);
      }
      paramVarArgs.e(5, 8, this.YBg);
      paramVarArgs.bS(6, this.BeA);
      paramVarArgs.e(7, 1, this.ZVM);
      if (this.Zpn != null) {
        paramVarArgs.d(8, this.Zpn);
      }
      paramVarArgs.bS(9, this.ZVN);
      AppMethodBeat.o(258801);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Zpm) + 0 + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.name);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.icon_url);
      }
      i = i + i.a.a.a.c(5, 8, this.YBg) + i.a.a.b.b.a.cJ(6, this.BeA) + i.a.a.a.c(7, 1, this.ZVM);
      paramInt = i;
      if (this.Zpn != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.Zpn);
      }
      i = i.a.a.b.b.a.cJ(9, this.ZVN);
      AppMethodBeat.o(258801);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YBg.clear();
      this.ZVM.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258801);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bna localbna = (bna)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258801);
        return -1;
      case 1: 
        localbna.Zpm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258801);
        return 0;
      case 2: 
        localbna.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258801);
        return 0;
      case 3: 
        localbna.name = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258801);
        return 0;
      case 4: 
        localbna.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258801);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bmz localbmz = new bmz();
          if ((localObject != null) && (localObject.length > 0)) {
            localbmz.parseFrom((byte[])localObject);
          }
          localbna.YBg.add(localbmz);
          paramInt += 1;
        }
        AppMethodBeat.o(258801);
        return 0;
      case 6: 
        localbna.BeA = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258801);
        return 0;
      case 7: 
        localbna.ZVM.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(258801);
        return 0;
      case 8: 
        localbna.Zpn = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(258801);
        return 0;
      }
      localbna.ZVN = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258801);
      return 0;
    }
    AppMethodBeat.o(258801);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bna
 * JD-Core Version:    0.7.0.1
 */