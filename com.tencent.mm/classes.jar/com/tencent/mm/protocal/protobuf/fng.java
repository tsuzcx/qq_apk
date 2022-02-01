package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fng
  extends com.tencent.mm.bx.a
{
  public String abNo;
  public String abNp;
  public String abNq;
  public String abNr;
  public boolean abNs;
  public String akls;
  public LinkedList<String> hrh;
  public int num;
  public String title;
  public String url;
  
  public fng()
  {
    AppMethodBeat.i(258460);
    this.hrh = new LinkedList();
    AppMethodBeat.o(258460);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127284);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.num);
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      paramVarArgs.e(4, 1, this.hrh);
      if (this.abNo != null) {
        paramVarArgs.g(5, this.abNo);
      }
      if (this.abNp != null) {
        paramVarArgs.g(6, this.abNp);
      }
      if (this.abNq != null) {
        paramVarArgs.g(7, this.abNq);
      }
      if (this.abNr != null) {
        paramVarArgs.g(8, this.abNr);
      }
      paramVarArgs.di(9, this.abNs);
      if (this.akls != null) {
        paramVarArgs.g(10, this.akls);
      }
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.num) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.url);
      }
      i += i.a.a.a.c(4, 1, this.hrh);
      paramInt = i;
      if (this.abNo != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abNo);
      }
      i = paramInt;
      if (this.abNp != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abNp);
      }
      paramInt = i;
      if (this.abNq != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abNq);
      }
      i = paramInt;
      if (this.abNr != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abNr);
      }
      i += i.a.a.b.b.a.ko(9) + 1;
      paramInt = i;
      if (this.akls != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.akls);
      }
      AppMethodBeat.o(127284);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hrh.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fng localfng = (fng)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127284);
        return -1;
      case 1: 
        localfng.num = locala.ajGk.aar();
        AppMethodBeat.o(127284);
        return 0;
      case 2: 
        localfng.title = locala.ajGk.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 3: 
        localfng.url = locala.ajGk.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 4: 
        localfng.hrh.add(locala.ajGk.readString());
        AppMethodBeat.o(127284);
        return 0;
      case 5: 
        localfng.abNo = locala.ajGk.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 6: 
        localfng.abNp = locala.ajGk.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 7: 
        localfng.abNq = locala.ajGk.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 8: 
        localfng.abNr = locala.ajGk.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 9: 
        localfng.abNs = locala.ajGk.aai();
        AppMethodBeat.o(127284);
        return 0;
      }
      localfng.akls = locala.ajGk.readString();
      AppMethodBeat.o(127284);
      return 0;
    }
    AppMethodBeat.o(127284);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fng
 * JD-Core Version:    0.7.0.1
 */