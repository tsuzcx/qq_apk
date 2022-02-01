package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bpq
  extends com.tencent.mm.bx.a
{
  public String DOb;
  public String DOc;
  public String DOd;
  public int DOe;
  public String doh;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.doh == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.type);
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.DOb != null) {
        paramVarArgs.d(4, this.DOb);
      }
      if (this.DOc != null) {
        paramVarArgs.d(5, this.DOc);
      }
      if (this.DOd != null) {
        paramVarArgs.d(6, this.DOd);
      }
      paramVarArgs.aR(7, this.DOe);
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.DOb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DOb);
      }
      i = paramInt;
      if (this.DOc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DOc);
      }
      paramInt = i;
      if (this.DOd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DOd);
      }
      i = f.a.a.b.b.a.bA(7, this.DOe);
      AppMethodBeat.o(91538);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.doh == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpq localbpq = (bpq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91538);
        return -1;
      case 1: 
        localbpq.type = locala.KhF.xS();
        AppMethodBeat.o(91538);
        return 0;
      case 2: 
        localbpq.doh = locala.KhF.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 3: 
        localbpq.url = locala.KhF.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 4: 
        localbpq.DOb = locala.KhF.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 5: 
        localbpq.DOc = locala.KhF.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 6: 
        localbpq.DOd = locala.KhF.readString();
        AppMethodBeat.o(91538);
        return 0;
      }
      localbpq.DOe = locala.KhF.xS();
      AppMethodBeat.o(91538);
      return 0;
    }
    AppMethodBeat.o(91538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpq
 * JD-Core Version:    0.7.0.1
 */