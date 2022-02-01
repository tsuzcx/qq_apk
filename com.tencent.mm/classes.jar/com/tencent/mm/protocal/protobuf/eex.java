package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eex
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String YRE;
  public LinkedList<eep> abjB;
  public int abkq;
  public String abkt;
  public String abku;
  public int abkv;
  
  public eex()
  {
    AppMethodBeat.i(259909);
    this.abjB = new LinkedList();
    AppMethodBeat.o(259909);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259916);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abkt != null) {
        paramVarArgs.g(1, this.abkt);
      }
      if (this.YRE != null) {
        paramVarArgs.g(2, this.YRE);
      }
      paramVarArgs.bS(3, this.CreateTime);
      paramVarArgs.e(4, 8, this.abjB);
      if (this.abku != null) {
        paramVarArgs.g(5, this.abku);
      }
      paramVarArgs.bS(6, this.abkq);
      paramVarArgs.bS(7, this.abkv);
      AppMethodBeat.o(259916);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abkt == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = i.a.a.b.b.a.h(1, this.abkt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YRE != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YRE);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.CreateTime) + i.a.a.a.c(4, 8, this.abjB);
      paramInt = i;
      if (this.abku != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abku);
      }
      i = i.a.a.b.b.a.cJ(6, this.abkq);
      int j = i.a.a.b.b.a.cJ(7, this.abkv);
      AppMethodBeat.o(259916);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abjB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259916);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eex localeex = (eex)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259916);
          return -1;
        case 1: 
          localeex.abkt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259916);
          return 0;
        case 2: 
          localeex.YRE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259916);
          return 0;
        case 3: 
          localeex.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259916);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eep localeep = new eep();
            if ((localObject != null) && (localObject.length > 0)) {
              localeep.parseFrom((byte[])localObject);
            }
            localeex.abjB.add(localeep);
            paramInt += 1;
          }
          AppMethodBeat.o(259916);
          return 0;
        case 5: 
          localeex.abku = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259916);
          return 0;
        case 6: 
          localeex.abkq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259916);
          return 0;
        }
        localeex.abkv = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259916);
        return 0;
      }
      AppMethodBeat.o(259916);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eex
 * JD-Core Version:    0.7.0.1
 */