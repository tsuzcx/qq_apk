package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class buh
  extends com.tencent.mm.bw.a
{
  public String Fks;
  public String Fkt;
  public String Fku;
  public int Fkv;
  public String dlQ;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.type);
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.Fks != null) {
        paramVarArgs.d(4, this.Fks);
      }
      if (this.Fkt != null) {
        paramVarArgs.d(5, this.Fkt);
      }
      if (this.Fku != null) {
        paramVarArgs.d(6, this.Fku);
      }
      paramVarArgs.aR(7, this.Fkv);
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.Fks != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fks);
      }
      i = paramInt;
      if (this.Fkt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fkt);
      }
      paramInt = i;
      if (this.Fku != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fku);
      }
      i = f.a.a.b.b.a.bx(7, this.Fkv);
      AppMethodBeat.o(91538);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.dlQ == null)
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
      buh localbuh = (buh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91538);
        return -1;
      case 1: 
        localbuh.type = locala.LVo.xF();
        AppMethodBeat.o(91538);
        return 0;
      case 2: 
        localbuh.dlQ = locala.LVo.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 3: 
        localbuh.url = locala.LVo.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 4: 
        localbuh.Fks = locala.LVo.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 5: 
        localbuh.Fkt = locala.LVo.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 6: 
        localbuh.Fku = locala.LVo.readString();
        AppMethodBeat.o(91538);
        return 0;
      }
      localbuh.Fkv = locala.LVo.xF();
      AppMethodBeat.o(91538);
      return 0;
    }
    AppMethodBeat.o(91538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buh
 * JD-Core Version:    0.7.0.1
 */