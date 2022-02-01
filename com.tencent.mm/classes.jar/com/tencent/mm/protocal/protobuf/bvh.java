package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bvh
  extends com.tencent.mm.bx.a
{
  public b AEA;
  public LinkedList<String> aacP;
  public LinkedList<String> aacQ;
  public String cardId;
  public String title;
  public String uCW;
  
  public bvh()
  {
    AppMethodBeat.i(258974);
    this.aacP = new LinkedList();
    this.aacQ = new LinkedList();
    AppMethodBeat.o(258974);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258980);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.cardId != null) {
        paramVarArgs.g(1, this.cardId);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.uCW != null) {
        paramVarArgs.g(3, this.uCW);
      }
      paramVarArgs.e(4, 1, this.aacP);
      paramVarArgs.e(5, 1, this.aacQ);
      if (this.AEA != null) {
        paramVarArgs.d(6, this.AEA);
      }
      AppMethodBeat.o(258980);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cardId == null) {
        break label506;
      }
    }
    label506:
    for (int i = i.a.a.b.b.a.h(1, this.cardId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.uCW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.uCW);
      }
      i = i + i.a.a.a.c(4, 1, this.aacP) + i.a.a.a.c(5, 1, this.aacQ);
      paramInt = i;
      if (this.AEA != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.AEA);
      }
      AppMethodBeat.o(258980);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aacP.clear();
        this.aacQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258980);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bvh localbvh = (bvh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258980);
          return -1;
        case 1: 
          localbvh.cardId = locala.ajGk.readString();
          AppMethodBeat.o(258980);
          return 0;
        case 2: 
          localbvh.title = locala.ajGk.readString();
          AppMethodBeat.o(258980);
          return 0;
        case 3: 
          localbvh.uCW = locala.ajGk.readString();
          AppMethodBeat.o(258980);
          return 0;
        case 4: 
          localbvh.aacP.add(locala.ajGk.readString());
          AppMethodBeat.o(258980);
          return 0;
        case 5: 
          localbvh.aacQ.add(locala.ajGk.readString());
          AppMethodBeat.o(258980);
          return 0;
        }
        localbvh.AEA = locala.ajGk.kFX();
        AppMethodBeat.o(258980);
        return 0;
      }
      AppMethodBeat.o(258980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvh
 * JD-Core Version:    0.7.0.1
 */