package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezd
  extends com.tencent.mm.bx.a
{
  public String aajW;
  public long aajX;
  public boolean abAi;
  public LinkedList<czu> abAj;
  public String hQR;
  public int index;
  public boolean lAr;
  
  public ezd()
  {
    AppMethodBeat.i(177411);
    this.index = -1;
    this.abAi = false;
    this.hQR = "";
    this.aajX = -1L;
    this.aajW = "";
    this.abAj = new LinkedList();
    this.lAr = false;
    AppMethodBeat.o(177411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177412);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.index);
      paramVarArgs.di(2, this.abAi);
      if (this.hQR != null) {
        paramVarArgs.g(3, this.hQR);
      }
      paramVarArgs.bv(4, this.aajX);
      if (this.aajW != null) {
        paramVarArgs.g(5, this.aajW);
      }
      paramVarArgs.e(6, 8, this.abAj);
      paramVarArgs.di(7, this.lAr);
      AppMethodBeat.o(177412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.index) + 0 + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.hQR != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hQR);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.aajX);
      paramInt = i;
      if (this.aajW != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aajW);
      }
      i = i.a.a.a.c(6, 8, this.abAj);
      int j = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(177412);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abAj.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(177412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ezd localezd = (ezd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(177412);
        return -1;
      case 1: 
        localezd.index = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(177412);
        return 0;
      case 2: 
        localezd.abAi = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(177412);
        return 0;
      case 3: 
        localezd.hQR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 4: 
        localezd.aajX = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(177412);
        return 0;
      case 5: 
        localezd.aajW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          czu localczu = new czu();
          if ((localObject != null) && (localObject.length > 0)) {
            localczu.parseFrom((byte[])localObject);
          }
          localezd.abAj.add(localczu);
          paramInt += 1;
        }
        AppMethodBeat.o(177412);
        return 0;
      }
      localezd.lAr = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(177412);
      return 0;
    }
    AppMethodBeat.o(177412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezd
 * JD-Core Version:    0.7.0.1
 */