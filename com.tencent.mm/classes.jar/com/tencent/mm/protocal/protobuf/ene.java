package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ene
  extends com.tencent.mm.bw.a
{
  public int BsF;
  public int BsG;
  public String Lsm;
  public String Lsn;
  public String Lso;
  public String MD5;
  public com.tencent.mm.bw.b Nlc;
  public boolean Nld;
  public LinkedList<String> Nle;
  public String Nlf;
  
  public ene()
  {
    AppMethodBeat.i(104839);
    this.Nle = new LinkedList();
    AppMethodBeat.o(104839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104840);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nlc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(104840);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.e(1, this.MD5);
      }
      paramVarArgs.aM(2, this.BsG);
      paramVarArgs.aM(3, this.BsF);
      if (this.Nlc != null) {
        paramVarArgs.c(4, this.Nlc);
      }
      paramVarArgs.cc(5, this.Nld);
      paramVarArgs.e(6, 1, this.Nle);
      if (this.Lsm != null) {
        paramVarArgs.e(7, this.Lsm);
      }
      if (this.Nlf != null) {
        paramVarArgs.e(8, this.Nlf);
      }
      if (this.Lso != null) {
        paramVarArgs.e(9, this.Lso);
      }
      if (this.Lsn != null) {
        paramVarArgs.e(10, this.Lsn);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
      paramInt = i;
      if (this.Nlc != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.Nlc);
      }
      i = paramInt + (g.a.a.b.b.a.fS(5) + 1) + g.a.a.a.c(6, 1, this.Nle);
      paramInt = i;
      if (this.Lsm != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Lsm);
      }
      i = paramInt;
      if (this.Nlf != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Nlf);
      }
      paramInt = i;
      if (this.Lso != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Lso);
      }
      i = paramInt;
      if (this.Lsn != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Lsn);
      }
      AppMethodBeat.o(104840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nle.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Nlc == null)
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
        ene localene = (ene)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104840);
          return -1;
        case 1: 
          localene.MD5 = locala.UbS.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 2: 
          localene.BsG = locala.UbS.zi();
          AppMethodBeat.o(104840);
          return 0;
        case 3: 
          localene.BsF = locala.UbS.zi();
          AppMethodBeat.o(104840);
          return 0;
        case 4: 
          localene.Nlc = locala.UbS.hPo();
          AppMethodBeat.o(104840);
          return 0;
        case 5: 
          localene.Nld = locala.UbS.yZ();
          AppMethodBeat.o(104840);
          return 0;
        case 6: 
          localene.Nle.add(locala.UbS.readString());
          AppMethodBeat.o(104840);
          return 0;
        case 7: 
          localene.Lsm = locala.UbS.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 8: 
          localene.Nlf = locala.UbS.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 9: 
          localene.Lso = locala.UbS.readString();
          AppMethodBeat.o(104840);
          return 0;
        }
        localene.Lsn = locala.UbS.readString();
        AppMethodBeat.o(104840);
        return 0;
      }
      AppMethodBeat.o(104840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ene
 * JD-Core Version:    0.7.0.1
 */