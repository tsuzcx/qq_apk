package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ann
  extends com.tencent.mm.bx.a
{
  public int YFu;
  public String ZuS;
  public String ZuT;
  public String ZuU;
  public String ZuV;
  public String ZuW;
  public int ZuX;
  public int ZuY;
  public String ZuZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104780);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZuS == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegWord");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.ZuT == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.ZuU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.ZuS != null) {
        paramVarArgs.g(1, this.ZuS);
      }
      if (this.ZuT != null) {
        paramVarArgs.g(2, this.ZuT);
      }
      if (this.ZuU != null) {
        paramVarArgs.g(3, this.ZuU);
      }
      if (this.ZuV != null) {
        paramVarArgs.g(4, this.ZuV);
      }
      if (this.ZuW != null) {
        paramVarArgs.g(5, this.ZuW);
      }
      paramVarArgs.bS(6, this.ZuX);
      paramVarArgs.bS(7, this.ZuY);
      if (this.ZuZ != null) {
        paramVarArgs.g(8, this.ZuZ);
      }
      paramVarArgs.bS(9, this.YFu);
      AppMethodBeat.o(104780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZuS == null) {
        break label794;
      }
    }
    label794:
    for (int i = i.a.a.b.b.a.h(1, this.ZuS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZuT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZuT);
      }
      i = paramInt;
      if (this.ZuU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZuU);
      }
      paramInt = i;
      if (this.ZuV != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZuV);
      }
      i = paramInt;
      if (this.ZuW != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZuW);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.ZuX) + i.a.a.b.b.a.cJ(7, this.ZuY);
      paramInt = i;
      if (this.ZuZ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZuZ);
      }
      i = i.a.a.b.b.a.cJ(9, this.YFu);
      AppMethodBeat.o(104780);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZuS == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegWord");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.ZuT == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.ZuU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104780);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ann localann = (ann)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104780);
          return -1;
        case 1: 
          localann.ZuS = locala.ajGk.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 2: 
          localann.ZuT = locala.ajGk.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 3: 
          localann.ZuU = locala.ajGk.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 4: 
          localann.ZuV = locala.ajGk.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 5: 
          localann.ZuW = locala.ajGk.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 6: 
          localann.ZuX = locala.ajGk.aar();
          AppMethodBeat.o(104780);
          return 0;
        case 7: 
          localann.ZuY = locala.ajGk.aar();
          AppMethodBeat.o(104780);
          return 0;
        case 8: 
          localann.ZuZ = locala.ajGk.readString();
          AppMethodBeat.o(104780);
          return 0;
        }
        localann.YFu = locala.ajGk.aar();
        AppMethodBeat.o(104780);
        return 0;
      }
      AppMethodBeat.o(104780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ann
 * JD-Core Version:    0.7.0.1
 */