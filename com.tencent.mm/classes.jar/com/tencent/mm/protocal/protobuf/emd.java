package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emd
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> abqA;
  public String abqB;
  public String appid;
  public int auth_type;
  public String igL;
  public int status;
  
  public emd()
  {
    AppMethodBeat.i(257446);
    this.abqA = new LinkedList();
    AppMethodBeat.o(257446);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257450);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      paramVarArgs.e(2, 2, this.abqA);
      paramVarArgs.bS(3, this.auth_type);
      if (this.abqB != null) {
        paramVarArgs.g(4, this.abqB);
      }
      if (this.igL != null) {
        paramVarArgs.g(5, this.igL);
      }
      paramVarArgs.bS(100, this.status);
      AppMethodBeat.o(257450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label501;
      }
    }
    label501:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 2, this.abqA) + i.a.a.b.b.a.cJ(3, this.auth_type);
      paramInt = i;
      if (this.abqB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abqB);
      }
      i = paramInt;
      if (this.igL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.igL);
      }
      paramInt = i.a.a.b.b.a.cJ(100, this.status);
      AppMethodBeat.o(257450);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abqA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257450);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        emd localemd = (emd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257450);
          return -1;
        case 1: 
          localemd.appid = locala.ajGk.readString();
          AppMethodBeat.o(257450);
          return 0;
        case 2: 
          localemd.abqA.add(Integer.valueOf(locala.ajGk.aar()));
          AppMethodBeat.o(257450);
          return 0;
        case 3: 
          localemd.auth_type = locala.ajGk.aar();
          AppMethodBeat.o(257450);
          return 0;
        case 4: 
          localemd.abqB = locala.ajGk.readString();
          AppMethodBeat.o(257450);
          return 0;
        case 5: 
          localemd.igL = locala.ajGk.readString();
          AppMethodBeat.o(257450);
          return 0;
        }
        localemd.status = locala.ajGk.aar();
        AppMethodBeat.o(257450);
        return 0;
      }
      AppMethodBeat.o(257450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emd
 * JD-Core Version:    0.7.0.1
 */