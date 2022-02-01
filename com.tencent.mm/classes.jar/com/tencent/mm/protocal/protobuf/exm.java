package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exm
  extends com.tencent.mm.cd.a
{
  public String AttachedText;
  public String AttachedTextColor;
  public int HmZ;
  public int Hna;
  public String LensId;
  public String MD5;
  public com.tencent.mm.cd.b UxN;
  public boolean UxO;
  public LinkedList<String> UxP;
  public String UxQ;
  
  public exm()
  {
    AppMethodBeat.i(104839);
    this.UxP = new LinkedList();
    AppMethodBeat.o(104839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104840);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UxN == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(104840);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.f(1, this.MD5);
      }
      paramVarArgs.aY(2, this.Hna);
      paramVarArgs.aY(3, this.HmZ);
      if (this.UxN != null) {
        paramVarArgs.c(4, this.UxN);
      }
      paramVarArgs.co(5, this.UxO);
      paramVarArgs.e(6, 1, this.UxP);
      if (this.AttachedText != null) {
        paramVarArgs.f(7, this.AttachedText);
      }
      if (this.UxQ != null) {
        paramVarArgs.f(8, this.UxQ);
      }
      if (this.LensId != null) {
        paramVarArgs.f(9, this.LensId);
      }
      if (this.AttachedTextColor != null) {
        paramVarArgs.f(10, this.AttachedTextColor);
      }
      AppMethodBeat.o(104840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = g.a.a.b.b.a.g(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Hna) + g.a.a.b.b.a.bM(3, this.HmZ);
      paramInt = i;
      if (this.UxN != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.UxN);
      }
      i = paramInt + (g.a.a.b.b.a.gL(5) + 1) + g.a.a.a.c(6, 1, this.UxP);
      paramInt = i;
      if (this.AttachedText != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.AttachedText);
      }
      i = paramInt;
      if (this.UxQ != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.UxQ);
      }
      paramInt = i;
      if (this.LensId != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.LensId);
      }
      i = paramInt;
      if (this.AttachedTextColor != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.AttachedTextColor);
      }
      AppMethodBeat.o(104840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UxP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UxN == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(104840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104840);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exm localexm = (exm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104840);
          return -1;
        case 1: 
          localexm.MD5 = locala.abFh.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 2: 
          localexm.Hna = locala.abFh.AK();
          AppMethodBeat.o(104840);
          return 0;
        case 3: 
          localexm.HmZ = locala.abFh.AK();
          AppMethodBeat.o(104840);
          return 0;
        case 4: 
          localexm.UxN = locala.abFh.iUw();
          AppMethodBeat.o(104840);
          return 0;
        case 5: 
          localexm.UxO = locala.abFh.AB();
          AppMethodBeat.o(104840);
          return 0;
        case 6: 
          localexm.UxP.add(locala.abFh.readString());
          AppMethodBeat.o(104840);
          return 0;
        case 7: 
          localexm.AttachedText = locala.abFh.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 8: 
          localexm.UxQ = locala.abFh.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 9: 
          localexm.LensId = locala.abFh.readString();
          AppMethodBeat.o(104840);
          return 0;
        }
        localexm.AttachedTextColor = locala.abFh.readString();
        AppMethodBeat.o(104840);
        return 0;
      }
      AppMethodBeat.o(104840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exm
 * JD-Core Version:    0.7.0.1
 */