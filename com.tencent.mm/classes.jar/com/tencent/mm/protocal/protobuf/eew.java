package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eew
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String URL;
  public String aaDV;
  public String abjs;
  public LinkedList<eex> abks;
  public int vgN;
  
  public eew()
  {
    AppMethodBeat.i(259915);
    this.abks = new LinkedList();
    AppMethodBeat.o(259915);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259922);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      if (this.aaDV != null) {
        paramVarArgs.g(2, this.aaDV);
      }
      if (this.URL != null) {
        paramVarArgs.g(3, this.URL);
      }
      paramVarArgs.bS(4, this.vgN);
      if (this.abjs != null) {
        paramVarArgs.g(5, this.abjs);
      }
      paramVarArgs.e(6, 8, this.abks);
      AppMethodBeat.o(259922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label560;
      }
    }
    label560:
    for (int i = i.a.a.b.b.a.h(1, this.IGU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaDV != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaDV);
      }
      i = paramInt;
      if (this.URL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.URL);
      }
      i += i.a.a.b.b.a.cJ(4, this.vgN);
      paramInt = i;
      if (this.abjs != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abjs);
      }
      i = i.a.a.a.c(6, 8, this.abks);
      AppMethodBeat.o(259922);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abks.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eew localeew = (eew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259922);
          return -1;
        case 1: 
          localeew.IGU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259922);
          return 0;
        case 2: 
          localeew.aaDV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259922);
          return 0;
        case 3: 
          localeew.URL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259922);
          return 0;
        case 4: 
          localeew.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259922);
          return 0;
        case 5: 
          localeew.abjs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259922);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eex localeex = new eex();
          if ((localObject != null) && (localObject.length > 0)) {
            localeex.parseFrom((byte[])localObject);
          }
          localeew.abks.add(localeex);
          paramInt += 1;
        }
        AppMethodBeat.o(259922);
        return 0;
      }
      AppMethodBeat.o(259922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eew
 * JD-Core Version:    0.7.0.1
 */