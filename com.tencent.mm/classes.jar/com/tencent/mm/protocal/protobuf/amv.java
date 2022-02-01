package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class amv
  extends com.tencent.mm.bx.a
{
  public String IMg;
  public String MD5;
  public int NkN;
  public int NkO;
  public String YFJ;
  public String ZaR;
  public gol ZtL;
  public String ZtM;
  public String ZtN;
  public String ZtO;
  public int ZtP;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109446);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZtL == null)
      {
        paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(109446);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.g(1, this.MD5);
      }
      paramVarArgs.bS(2, this.NkO);
      paramVarArgs.bS(3, this.NkN);
      if (this.ZtL != null)
      {
        paramVarArgs.qD(4, this.ZtL.computeSize());
        this.ZtL.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.vhJ);
      if (this.IMg != null) {
        paramVarArgs.g(6, this.IMg);
      }
      if (this.ZtM != null) {
        paramVarArgs.g(7, this.ZtM);
      }
      if (this.ZtN != null) {
        paramVarArgs.g(8, this.ZtN);
      }
      if (this.ZtO != null) {
        paramVarArgs.g(9, this.ZtO);
      }
      if (this.YFJ != null) {
        paramVarArgs.g(10, this.YFJ);
      }
      paramVarArgs.bS(11, this.ZtP);
      if (this.ZaR != null) {
        paramVarArgs.g(12, this.ZaR);
      }
      AppMethodBeat.o(109446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label940;
      }
    }
    label940:
    for (paramInt = i.a.a.b.b.a.h(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkO) + i.a.a.b.b.a.cJ(3, this.NkN);
      paramInt = i;
      if (this.ZtL != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZtL.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.vhJ);
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IMg);
      }
      i = paramInt;
      if (this.ZtM != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZtM);
      }
      paramInt = i;
      if (this.ZtN != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZtN);
      }
      i = paramInt;
      if (this.ZtO != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZtO);
      }
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YFJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.ZtP);
      paramInt = i;
      if (this.ZaR != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZaR);
      }
      AppMethodBeat.o(109446);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZtL == null)
        {
          paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(109446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(109446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        amv localamv = (amv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(109446);
          return -1;
        case 1: 
          localamv.MD5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 2: 
          localamv.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(109446);
          return 0;
        case 3: 
          localamv.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(109446);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gol localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localamv.ZtL = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(109446);
          return 0;
        case 5: 
          localamv.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(109446);
          return 0;
        case 6: 
          localamv.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 7: 
          localamv.ZtM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 8: 
          localamv.ZtN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 9: 
          localamv.ZtO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 10: 
          localamv.YFJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 11: 
          localamv.ZtP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(109446);
          return 0;
        }
        localamv.ZaR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(109446);
        return 0;
      }
      AppMethodBeat.o(109446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amv
 * JD-Core Version:    0.7.0.1
 */