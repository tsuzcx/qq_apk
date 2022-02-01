package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aqq
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int EJI;
  public int EJJ;
  public String EJo;
  public int EbF;
  public String ThumbUrl;
  public String Title;
  public String hOf;
  public String tkL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42646);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(3, this.ThumbUrl);
      }
      if (this.EJo != null) {
        paramVarArgs.d(4, this.EJo);
      }
      paramVarArgs.aR(5, this.EJI);
      paramVarArgs.aR(6, this.EJJ);
      if (this.hOf != null) {
        paramVarArgs.d(7, this.hOf);
      }
      paramVarArgs.aR(8, this.EbF);
      if (this.tkL != null) {
        paramVarArgs.d(9, this.tkL);
      }
      AppMethodBeat.o(42646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.EJo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EJo);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EJI) + f.a.a.b.b.a.bx(6, this.EJJ);
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hOf);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.EbF);
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.tkL);
      }
      AppMethodBeat.o(42646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42646);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aqq localaqq = (aqq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42646);
          return -1;
        case 1: 
          localaqq.Title = locala.LVo.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 2: 
          localaqq.Desc = locala.LVo.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 3: 
          localaqq.ThumbUrl = locala.LVo.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 4: 
          localaqq.EJo = locala.LVo.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 5: 
          localaqq.EJI = locala.LVo.xF();
          AppMethodBeat.o(42646);
          return 0;
        case 6: 
          localaqq.EJJ = locala.LVo.xF();
          AppMethodBeat.o(42646);
          return 0;
        case 7: 
          localaqq.hOf = locala.LVo.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 8: 
          localaqq.EbF = locala.LVo.xF();
          AppMethodBeat.o(42646);
          return 0;
        }
        localaqq.tkL = locala.LVo.readString();
        AppMethodBeat.o(42646);
        return 0;
      }
      AppMethodBeat.o(42646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqq
 * JD-Core Version:    0.7.0.1
 */