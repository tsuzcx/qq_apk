package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ftf
  extends com.tencent.mm.bx.a
{
  public String AttachedText;
  public String AttachedTextColor;
  public String LensId;
  public String MD5;
  public int NkN;
  public int NkO;
  public com.tencent.mm.bx.b abRu;
  public boolean abRv;
  public LinkedList<String> abRw;
  public String abRx;
  
  public ftf()
  {
    AppMethodBeat.i(104839);
    this.abRw = new LinkedList();
    AppMethodBeat.o(104839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104840);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abRu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(104840);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.g(1, this.MD5);
      }
      paramVarArgs.bS(2, this.NkO);
      paramVarArgs.bS(3, this.NkN);
      if (this.abRu != null) {
        paramVarArgs.d(4, this.abRu);
      }
      paramVarArgs.di(5, this.abRv);
      paramVarArgs.e(6, 1, this.abRw);
      if (this.AttachedText != null) {
        paramVarArgs.g(7, this.AttachedText);
      }
      if (this.abRx != null) {
        paramVarArgs.g(8, this.abRx);
      }
      if (this.LensId != null) {
        paramVarArgs.g(9, this.LensId);
      }
      if (this.AttachedTextColor != null) {
        paramVarArgs.g(10, this.AttachedTextColor);
      }
      AppMethodBeat.o(104840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = i.a.a.b.b.a.h(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkO) + i.a.a.b.b.a.cJ(3, this.NkN);
      paramInt = i;
      if (this.abRu != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.abRu);
      }
      i = paramInt + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.a.c(6, 1, this.abRw);
      paramInt = i;
      if (this.AttachedText != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.AttachedText);
      }
      i = paramInt;
      if (this.abRx != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abRx);
      }
      paramInt = i;
      if (this.LensId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.LensId);
      }
      i = paramInt;
      if (this.AttachedTextColor != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.AttachedTextColor);
      }
      AppMethodBeat.o(104840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abRw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abRu == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(104840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104840);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ftf localftf = (ftf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104840);
          return -1;
        case 1: 
          localftf.MD5 = locala.ajGk.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 2: 
          localftf.NkO = locala.ajGk.aar();
          AppMethodBeat.o(104840);
          return 0;
        case 3: 
          localftf.NkN = locala.ajGk.aar();
          AppMethodBeat.o(104840);
          return 0;
        case 4: 
          localftf.abRu = locala.ajGk.kFX();
          AppMethodBeat.o(104840);
          return 0;
        case 5: 
          localftf.abRv = locala.ajGk.aai();
          AppMethodBeat.o(104840);
          return 0;
        case 6: 
          localftf.abRw.add(locala.ajGk.readString());
          AppMethodBeat.o(104840);
          return 0;
        case 7: 
          localftf.AttachedText = locala.ajGk.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 8: 
          localftf.abRx = locala.ajGk.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 9: 
          localftf.LensId = locala.ajGk.readString();
          AppMethodBeat.o(104840);
          return 0;
        }
        localftf.AttachedTextColor = locala.ajGk.readString();
        AppMethodBeat.o(104840);
        return 0;
      }
      AppMethodBeat.o(104840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftf
 * JD-Core Version:    0.7.0.1
 */