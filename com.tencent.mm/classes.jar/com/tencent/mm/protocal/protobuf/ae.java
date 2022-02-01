package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ae
  extends com.tencent.mm.bx.a
{
  public String YAH;
  public String YAI;
  public String YAJ;
  public String YAK;
  public LinkedList<String> YAL;
  public String vgX;
  public String vhx;
  
  public ae()
  {
    AppMethodBeat.i(145665);
    this.YAL = new LinkedList();
    AppMethodBeat.o(145665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145666);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhx != null) {
        paramVarArgs.g(1, this.vhx);
      }
      if (this.vgX != null) {
        paramVarArgs.g(2, this.vgX);
      }
      if (this.YAH != null) {
        paramVarArgs.g(3, this.YAH);
      }
      if (this.YAI != null) {
        paramVarArgs.g(4, this.YAI);
      }
      if (this.YAJ != null) {
        paramVarArgs.g(5, this.YAJ);
      }
      if (this.YAK != null) {
        paramVarArgs.g(6, this.YAK);
      }
      paramVarArgs.e(7, 1, this.YAL);
      AppMethodBeat.o(145666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhx == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.b.b.a.h(1, this.vhx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vgX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vgX);
      }
      i = paramInt;
      if (this.YAH != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YAH);
      }
      paramInt = i;
      if (this.YAI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YAI);
      }
      i = paramInt;
      if (this.YAJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YAJ);
      }
      paramInt = i;
      if (this.YAK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YAK);
      }
      i = i.a.a.a.c(7, 1, this.YAL);
      AppMethodBeat.o(145666);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YAL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(145666);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145666);
          return -1;
        case 1: 
          localae.vhx = locala.ajGk.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 2: 
          localae.vgX = locala.ajGk.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 3: 
          localae.YAH = locala.ajGk.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 4: 
          localae.YAI = locala.ajGk.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 5: 
          localae.YAJ = locala.ajGk.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 6: 
          localae.YAK = locala.ajGk.readString();
          AppMethodBeat.o(145666);
          return 0;
        }
        localae.YAL.add(locala.ajGk.readString());
        AppMethodBeat.o(145666);
        return 0;
      }
      AppMethodBeat.o(145666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ae
 * JD-Core Version:    0.7.0.1
 */